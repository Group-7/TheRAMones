package com.group7.dao.jpa;

import java.util.Collection;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;

import com.group7.dao.BaseDataDAO;
import com.group7.entities.BaseData;


@NamedQueries({
	@NamedQuery(name="BaseData.getAll", query="select bd from baseData bd")
}
)

public class BaseDataDAOImpl implements BaseDataDAO {

	@PersistenceContext
	EntityManager em;
	
	public Collection<BaseData> getAllBaseData() {
		// TODO Auto-generated method stub
		return (Collection<BaseData>)em.createQuery("select bd from BaseData bd").getResultList();
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void addBaseData(BaseData basedata){
		em.persist(basedata);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void putData(Collection<BaseData> bd) {
		
		
		for(BaseData basedata : bd){
			//em.persist(basedata);
			
			BaseData base=new BaseData();
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

}