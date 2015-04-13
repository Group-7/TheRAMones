package com.group7.arquillian;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.ArrayList;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.group7.dao.BaseDataDAO;
import com.group7.dao.jpa.BaseDataDAOImpl;
import com.group7.databases.DataBaseProducer;
import com.group7.entities.BaseData;
import com.group7.entities.BaseDataId;
import com.group7.entities.EventCause;
import com.group7.importBaseData.BaseDataExcelRead;
import com.group7.importBaseData.BaseDataValidation;
import com.group7.rest.BaseDataREST;
import com.group7.service.BaseDataServiceEJB;
import com.group7.serviceInterface.BaseDataServiceLocal;

@RunWith(Arquillian.class)
public class User4 {

	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap
				.create(JavaArchive.class, "US7.jar")
				.addClasses(BaseDataExcelRead.class,BaseDataValidation.class)
				.addPackage(BaseDataDAO.class.getPackage())
				.addPackage(BaseDataDAOImpl.class.getPackage())
				.addPackage(BaseDataREST.class.getPackage())
				.addPackage(BaseDataServiceEJB.class.getPackage())
				.addPackage(BaseDataServiceLocal.class.getPackage())
				.addPackage(BaseData.class.getPackage())
				//.addPackage(BaseDataValidation.class.getPackage())
				.addPackage(DataBaseProducer.class.getPackage())
				.addAsResource("META-INF/persistence.xml")
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");

	}
	
	@Inject
	BaseDataServiceLocal service;
	
	@Test
	public void test() {
		assertNotNull(service);
	}
	
	@Test
	public void testUniqueImsi(){
		
		ArrayList<BigInteger> UImsi=(ArrayList<BigInteger>)service.getUniqueAffectedImsi();
		
		for(int i=0;i<UImsi.size();i++){
			
			for(int j=i+1;j<UImsi.size();j++){
				assertNotSame(UImsi.get(i),UImsi.get(j));
			}
			
			assertFalse(service.getAllEventIdAndCauseId(UImsi.get(i)).isEmpty());
		}
		
		assertEquals(6,UImsi.size());
	}
	
	@Test
	public void testQuery(){
		
		
		assertEquals(256,service.getAllEventIdAndCauseId(new BigInteger("344930000000011")).size());
		
	}

}
