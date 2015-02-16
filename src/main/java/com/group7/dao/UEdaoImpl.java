package com.group7.dao;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.group7.daoInterface.UEdao;
import com.group7.entities.UE;

public class UEdaoImpl implements UEdao{

	private EntityManager em;
	
	@PersistenceContext
	public Collection<UE> getAllEU() {
		
		Query q = em.createQuery("from UE_Table");		
		return q.getResultList();
		
	}

}
