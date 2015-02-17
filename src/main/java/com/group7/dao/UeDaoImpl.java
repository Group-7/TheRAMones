package com.group7.dao;

import java.util.Collection;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.group7.daoInterface.UeDao;
import com.group7.entities.UE;

@Stateless
@Local
public class UeDaoImpl implements UeDao{

	@PersistenceContext
	private EntityManager em;

	public Collection<UE> getEU() {
		Query q = em.createQuery("from UE_Table");		
		return q.getResultList();
	}

}
