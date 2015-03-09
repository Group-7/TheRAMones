package com.group7.dao.jpa;

import java.math.BigInteger;
import java.util.Collection;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;

import com.group7.dao.BaseDataDAO;
import com.group7.entities.BaseData;

public class BaseDataDAOImpl implements BaseDataDAO {

	@PersistenceContext
	EntityManager em;

	public Collection<BaseData> getAllBaseData() {
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


	/*
	 * SELECT Base_Data.IMSI, Base_Data.Cause_Code, Base_Data.EventID,
	 * Event_Cause_Table.Description FROM Base_Data, Event_Cause_Table WHERE
	 * Base_Data.Cause_Code = Event_Cause_Table.Cause_Code AND Base_Data.EventID
	 * = Event_Cause_Table.EventID AND Base_Data.IMSI = 344930000000001;
	 */
	public Collection<Object> getAllCauseCodeAndEventIdByIMSI(BigInteger imsi) {
		return em
				.createQuery(
						"SELECT bd.imsi, bd.causeCode, bd.eventId, ec.description FROM Event_Cause_Table ec, BaseData bd WHERE bd.causeCode = ec.causeCode AND bd.eventId = ec.eventId AND bd.imsi = :imsi").setParameter("imsi", imsi).getResultList();
	}

	public Collection<BigInteger> getUniqueAffectedImsi() {
		return (Collection<BigInteger>) em.createQuery(
				"SELECT DISTINCT bd.imsi FROM BaseData bd").getResultList();

	}

}
