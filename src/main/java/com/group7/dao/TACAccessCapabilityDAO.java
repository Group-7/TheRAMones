package com.group7.dao;

import java.util.Collection;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.group7.daoInterface.TACAccessCapabilityDAOI;
import com.group7.entities.TACAccessCapability;

@Local
@Stateless
public class TACAccessCapabilityDAO implements TACAccessCapabilityDAOI{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Collection<TACAccessCapability> getAllTACAccessCapabilities() {
		Query  query = em.createQuery("from TAC_Access_Capability");
		return query.getResultList();
	}

}
