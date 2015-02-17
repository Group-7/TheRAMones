package com.group7.dao;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.group7.daoInterface.TacAccessCapabilityDao;
import com.group7.entities.TacAccessCapability;

@EJB
@Local
public class TacAccessCapabilityDaoImpl implements TacAccessCapabilityDao {

	@PersistenceContext
	private EntityManager em;

	public Collection<TacAccessCapability> getTacAccessCapability() {

		Query q = em.createNamedQuery("TAC_Access_Capability");
		return q.getResultList();
	}

}
