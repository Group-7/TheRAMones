package com.group7.dao;

import java.util.Collection;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.group7.daoInterface.AccessCapabilityDAOI;
import com.group7.entities.AccessCapability;

@Local
@Stateless
public class AccessCapabilityDAO implements AccessCapabilityDAOI{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Collection<AccessCapability> getAllAccessCapabilities() {
		Query  query = em.createQuery("from TAC_Access_Capability");
		return query.getResultList();
	}

}
