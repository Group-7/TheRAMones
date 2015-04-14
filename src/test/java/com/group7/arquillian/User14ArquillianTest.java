package com.group7.arquillian;

import static org.junit.Assert.assertTrue;

import java.math.BigInteger;
import java.util.Collection;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.group7.serviceInterface.BaseDataServiceLocal;

@RunWith(Arquillian.class)
public class User14ArquillianTest {

	
	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap.create(JavaArchive.class, "test2.jar")

				.addPackages(true,"com.group7")
				.addAsResource("META-INF/persistence.xml")
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
  
  }
	
	@EJB
	BaseDataServiceLocal serv;
	
	@Test
	public void test() {
		Collection<BigInteger> returnedInfo = serv.imsiEffectedByAFailureCauseClass("EMERGENCY");
		assertTrue(returnedInfo.size()>0);
		assertTrue(returnedInfo.size()==3);
		
		
		 returnedInfo = serv.imsiEffectedByAFailureCauseClass("HIGH PRIORITY ACCESS");
		 assertTrue(returnedInfo.size()==6);
		 returnedInfo = serv.imsiEffectedByAFailureCauseClass("MT ACCESS");
		 assertTrue(returnedInfo.size()==3);
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
