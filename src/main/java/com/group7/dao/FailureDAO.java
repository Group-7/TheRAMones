package com.group7.dao;

import java.util.Collection;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.group7.daoInterface.FailureCauseDAOInterface;
import com.group7.entities.Failure;
@Stateless
@Local
public class FailureDAO implements FailureCauseDAOInterface{
	
	@PersistenceContext
	private EntityManager em;

	public Collection<Failure> getAllFailureCauses() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("from Failure_Class_Table");
		return query.getResultList();
	}

}
