/*package com.group7.arquillian;

import static org.junit.Assert.*;

import java.math.BigInteger;

import javax.ejb.EJB;

import junit.framework.Assert;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.group7.dao.BaseDataDAO;
import com.group7.dao.jpa.BaseDataDAOImpl;
import com.group7.databases.DataBaseProducer;
import com.group7.entities.BaseData;
import com.group7.importBaseData.BaseDataValidation;

@RunWith(Arquillian.class)
public class CallFailuresQueriesTest {
	
	
	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap.create(JavaArchive.class, "test2.jar")
				.addClasses(BaseDataDAOImpl.class, BaseDataDAO.class, BaseData.class,BaseDataValidation.class)
				.addPackage(BaseData.class.getPackage())
				.addPackage(DataBaseProducer.class.getPackage())
				.addAsResource("META-INF/persistence.xml")
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
  
  }

	//check
	@EJB
	private BaseDataDAO dao;

	@Test
	public void notNullTest(){
		assertNotNull(dao);
	}
	
	// here create simple test which check method of ejb
	@Test
	public void isBaseDataEmpty() throws Exception {
		BigInteger phoneTypeDummy = new BigInteger("33000153");
		String startDate =  "11/01/2013 17:09:00";
		String endDate = "11/01/2013 17:17:00";
		//Assert.assertEquals(dao.getEU().size(),);
		//assertEquals(dao.getEU().size(), 1);
		//assertFalse(!dao.getEU().isEmpty());
	//	assertFalse(dao.getTotalFailuresOfSpecificPhone(phoneTypeDummy, startDate, endDate).isEmpty());	
		
	}
	
	@Test
	public void isBaseDataEmptyIMSI() throws Exception {
		BigInteger IMSIDummy = new BigInteger("344930000000011");
		String startDate =  "11/01/2013 17:09:00";
		String endDate = "11/01/2013 17:17:00";
		assertFalse(dao.getTotalFailuresOfSpecificIMSI(IMSIDummy, startDate, endDate).isEmpty());	
		
	}
	

}*/