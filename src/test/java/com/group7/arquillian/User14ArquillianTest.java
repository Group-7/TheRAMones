package com.group7.arquillian;

import static org.junit.Assert.*;

import java.util.Collection;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.group7.entities.BaseData;
import com.group7.importBaseData.BaseDataExcelRead;
import com.group7.importBaseData.BaseDataValidation;
import com.group7.serviceInterface.BaseDataServiceLocal;

@RunWith(Arquillian.class)
public class User14ArquillianTest {

	
	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap.create(JavaArchive.class, "test2.jar")

				.addClasses(BaseDataExcelRead.class,
						BaseDataValidation.class)
				.addPackages(true,"com.group7.dao",
						"com.group7.databases",
						"com.group7.entities",
						"com.group7.rest",
						"com.group7.service",
						"com.group7.serviceInterface")
				
				.addAsResource("META-INF/persistence.xml")
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
  
  }
	
	@EJB
	BaseDataServiceLocal serv;
	
	@Test
	public void test() {
		Collection<BaseData> returnedInfo = serv.imsiEffectedByAFailureCauseClass("EMERGENCY");
		assertTrue(returnedInfo.size()>0);
		assertTrue(returnedInfo.size()==160);
		
		
		 returnedInfo = serv.imsiEffectedByAFailureCauseClass("HIGH PRIORITY ACCESS");
		 assertTrue(returnedInfo.size()==600);
		 returnedInfo = serv.imsiEffectedByAFailureCauseClass("MT ACCESS");
		 assertTrue(returnedInfo.size()==40);
		 returnedInfo = serv.imsiEffectedByAFailureCauseClass("MO SIGNALLING");
		 assertTrue(returnedInfo.size()==0);
		 returnedInfo = serv.imsiEffectedByAFailureCauseClass("MO DATA");
		 assertTrue(returnedInfo.size()==0);
	}
	
	@Test
	public void testDropDown(){
		Collection<String> stringsReturned = serv.getFailureDescriptionForDropDown();
		assertTrue(stringsReturned.size()==5);
	}

}
