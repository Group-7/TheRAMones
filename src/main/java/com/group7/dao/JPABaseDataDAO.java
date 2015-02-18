package com.group7.dao;

import java.util.Collection;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;

import com.group7.daoInterface.BaseDataDAO;
import com.group7.entities.BaseData;


@NamedQueries({
	@NamedQuery(name="BaseData.getAll", query="select bd from baseData bd")
}
)

public class JPABaseDataDAO implements BaseDataDAO {

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

}
