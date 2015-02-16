package com.group7.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.group7.daoInterface.FailureDAOInterface;
import com.group7.entities.Failure;

public class FailureDAO implements FailureDAOInterface{
	
	@PersistenceContext
	private EntityManager em;

	public Failure getFailure(Integer FailureCode) {
		// TODO Auto-generated method stub
		Query query = em.createQuery("from Failure_Class_Table f where f.Failure_Class = :FailureCode");
		query.setParameter("FailureCode", FailureCode);
		List<Failure> result = query.getResultList();
		
		return result.get(0);
	}

	public Collection<Failure> getAllFailures() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("from Failure_Class_Table");
		List<Failure> failures = query.getResultList();
		return failures;
	}

}
