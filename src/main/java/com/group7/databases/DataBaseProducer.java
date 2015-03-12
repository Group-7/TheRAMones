package com.group7.databases;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class DataBaseProducer {

	
	@Produces
	@PersistenceContext(unitName="TEST")
	private EntityManager test;
	
	@Produces
	@Alternative
	@ProdDB
	@PersistenceContext(unitName="dt340a")
	private EntityManager production;
	
}
