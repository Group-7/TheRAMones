package com.group7.dao.jpa;

import java.util.Collection;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.group7.dao.FailureCauseDAO;
import com.group7.entities.Failure;
@Stateless
@Local
public class FailureDAOImpl implements FailureCauseDAO{
	
	@PersistenceContext
	private EntityManager em;

	public Collection<Failure> getAllFailureCauses() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("from Failure_Class_Table");
		return query.getResultList();
	}

}
