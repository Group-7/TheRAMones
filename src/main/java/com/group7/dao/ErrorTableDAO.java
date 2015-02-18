package com.group7.dao;

import java.util.Collection;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.group7.daoInterface.ErrorTableDAOInterface;
import com.group7.entities.ErrorTable;

@Local
@Stateless
public class ErrorTableDAO implements ErrorTableDAOInterface{

	@PersistenceContext
	private EntityManager em;
	
	public Collection<ErrorTable> getAllErrorRecords() {
		Query q = em.createQuery("from error_table");
		return q.getResultList();
	}


	
	

}
