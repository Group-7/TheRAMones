package com.group7.arquillian;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.validation.constraints.AssertTrue;

import junit.framework.Assert;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import com.group7.dao.UeDAO;
import com.group7.dao.jpa.UeDAOImpl;
import com.group7.databases.DataBaseProducer;
import com.group7.entities.BaseData;
import com.group7.entities.UE;
import com.group7.rest.UeREST;
import com.group7.service.UeServiceEJB;
import com.group7.serviceInterface.UeServiceLocal;

@RunWith(Arquillian.class)
public class UeServiceEJBTest {

	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap.create(JavaArchive.class, "test.jar")
				.addClasses(UeDAO.class, UE.class, UeDAOImpl.class,
						UeServiceLocal.class,UeServiceEJB.class,UeREST.class)
				.addPackage(DataBaseProducer.class.getPackage())
				.addPackage(BaseData.class.getPackage())
				.addAsResource("META-INF/persistence.xml")
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
		

  }

	@Inject
	private UeServiceLocal dao;

	
	@Test
	public void notNullTest(){
		assertNotNull(dao);
	}
	
	// here create simple test which check method of ejb
	@Test
	public void isUETableEmpty() throws Exception {
		//Assert.assertEquals(dao.getEU().size(),);
		//assertEquals(dao.getEU().size(), 1);
		assertFalse(dao.getAllEU().isEmpty());
		//assertTrue(dao.getEU().isEmpty());	
		
	}
}

