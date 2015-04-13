package com.group7.arquillian;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.Collection;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.group7.dao.BaseDataDAO;
import com.group7.dao.UeDAO;
import com.group7.dao.jpa.BaseDataDAOImpl;
import com.group7.dao.jpa.UeDAOImpl;
import com.group7.databases.DataBaseProducer;
import com.group7.entities.BaseData;
import com.group7.entities.BaseDataId;
import com.group7.entities.UE;
import com.group7.importBaseData.BaseDataValidation;
import com.group7.rest.BaseDataREST;
import com.group7.rest.UeREST;
import com.group7.service.BaseDataServiceEJB;
import com.group7.service.UeServiceEJB;
import com.group7.serviceInterface.BaseDataServiceLocal;
import com.group7.serviceInterface.UeServiceLocal;
@RunWith(Arquillian.class)
public class GetPhoneModelTest {

	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap
				.create(JavaArchive.class, "US7.jar")
				.addClasses(BaseData.class,
						BaseDataId.class, 
						BaseDataDAO.class,
						BaseDataDAOImpl.class,
						BaseDataValidation.class,
						BaseDataREST.class,
						BaseDataServiceEJB.class,
						BaseDataServiceLocal.class)
						.addPackage(BaseData.class.getPackage())
						.addPackage(DataBaseProducer.class.getPackage())
				.addAsResource("META-INF/persistence.xml")
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");

	}
	
	
	@Inject
	private BaseDataServiceLocal dao;

	
	@Test
	public void notNullTest(){
		assertNotNull(dao);
	}

	
	@Test
	public void testGetPhoneTypes(){
		
		Collection<BigInteger> phoneTypes=dao.getAllPhoneTypes();
		
		assertEquals(3,phoneTypes.size());
		
		
	}
	
	@Test
	public void testGetPhoneModels(){
		
		Collection<String> phoneTypes=dao.getAllDistinctPhoneModels();
		
		assertEquals(91,phoneTypes.size());
		
		
	}
}
