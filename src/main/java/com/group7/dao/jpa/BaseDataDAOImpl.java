package com.group7.dao.jpa;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;

import com.group7.dao.BaseDataDAO;
import com.group7.entities.BaseData;
import com.group7.entities.EventCause;
import com.group7.entities.Failure;
import com.group7.entities.Network;
import com.group7.entities.UE;
import com.group7.importBaseData.BaseDataValidation;

@Named
@NamedQueries({ @NamedQuery(name = "BaseData.getAll", query = "select bd from baseData bd") })
@Local
@Stateless
public class BaseDataDAOImpl implements BaseDataDAO {

	@PersistenceContext
	EntityManager em;
	BaseDataValidation bdv = BaseDataValidation.getInstance();

	public Collection<BaseData> getAllBaseData() {
		// TODO Auto-generated method stub
		return (Collection<BaseData>) em.createQuery(
				"select bd from BaseData bd").getResultList();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void addBaseData(BaseData basedata) {
		em.persist(basedata);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void putData(Collection<BaseData> bd) {

		for (BaseData basedata : bd) {
			// em.persist(basedata);

			BaseData base = new BaseData();
			base.setDateAndTime(basedata.getDateAndTime());
			base.setEventId(basedata.getEventId());
			base.setFailureClass(basedata.getFailureClass());
			base.setTac(basedata.getTac());
			base.setMcc(basedata.getMcc());
			base.setMnc(basedata.getMnc());
			base.setCellid(basedata.getCellid());
			base.setDuration(basedata.getDuration());
			base.setCauseCode(basedata.getCauseCode());
			base.setNeVersion(basedata.getNeVersion());
			base.setImsi(basedata.getImsi());
			base.setHeir3ID(basedata.getHeir3ID());
			base.setHeir32ID(basedata.getHeir32ID());
			base.setHeir321ID(basedata.getHeir321ID());
			em.persist(base);
		}

	}

	@Override
	public void putNetworkData(Collection<Network> networkData) {
		for (Network n : networkData) {
			if ((bdv.isNetworkFirst()) ||!bdv.persistCandidateKeysToNetworkTable(""+n.getMcc() + n.getMnc())) // works
				em.persist(n);
		}
		bdv.setNetworkFirst(false);
	}

	@Override
	public void putUEData(Collection<UE> ueData) {
		for (UE u : ueData) {
			if ((bdv.isUeFirst())|| (!bdv.persistEventCausePrimaryKey(Integer.toString(u.getTac())))) // Failed
				em.persist(u);

		}
		bdv.setUeFirst(false);
	}

	@Override
	public void putEventCauseData(Collection<EventCause> eventCauseData) {
		for (EventCause e : eventCauseData) {
			if ((bdv.isEventCauseFirst()) || !bdv.persistCandidateKeysToEventCauseTable(""+e.getCauseCode() + e.getEventId()))
				em.persist(e);
		}
		bdv.setEventCauseFirst(false);
	}

	@Override
	public void putFailureData(Collection<Failure> failureData) {
		for (Failure f : failureData) {
			if ((bdv.isFailureFirst())|| !bdv.persistFailurePrimaryKey(Integer.toString(f.getFailureCode()))) // failed
				em.persist(f);
		}
		bdv.setFailureFirst(false);
	}

}
