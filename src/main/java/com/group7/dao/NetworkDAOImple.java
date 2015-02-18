package com.group7.dao;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.group7.daoInterface.NetworkDAOLocal;
import com.group7.entities.Network;

@Stateless
@Local
public class NetworkDAOImple implements NetworkDAOLocal{
	
	@PersistenceContext
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