package com.group7.dao.jpa;

import java.util.Collection;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.group7.dao.UeDAO;
import com.group7.entities.UE;

@Stateless
@Local
public class UeDAOImpl implements UeDAO{

	@PersistenceContext
	private EntityManager em;

	public Collection<UE> getEU() {
		Query q = em.createQuery("from UE_Table");		
		return q.getResultList();
	}

}
