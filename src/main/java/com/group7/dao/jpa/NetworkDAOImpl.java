package com.group7.dao.jpa;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.group7.dao.NetworkDAO;
import com.group7.entities.Network;

@Stateless
@Local
public class NetworkDAOImpl implements NetworkDAO{
	
	//@PersistenceContext
	@Inject
	private EntityManager em;

	/**
	 * Method to run all the information
	 * from the Network Table
	 * 
	 * @Returns a Collection of Network objects
	 * @param none
	 */
	public Collection<Network> getAllNetworkInfo() {
		Query q = em.createQuery("from Network");
		return q.getResultList();
	}

}