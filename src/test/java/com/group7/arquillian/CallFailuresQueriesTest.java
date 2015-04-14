/*package com.group7.arquillian;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.io.File;
import java.math.BigInteger;

import javax.ejb.EJB;

import junit.framework.Assert;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
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
	    public static WebArchive createDeployment() {
	        WebArchive archive = ShrinkWrap
	                .create(WebArchive.class, "test.war")
	                .addPackages(true, "com.group7")
	                        .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
	                        .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");

	       File[] libs;

	        libs = Maven.resolver()
	                .resolve("com.jayway.restassured:rest-assured:2.4.0")
	                .withTransitivity().as(File.class);
	        archive.addAsLibraries(libs);

	        libs = Maven.resolver().resolve("org.apache.poi:poi:3.11")
	                .withTransitivity().as(File.class);
	        archive.addAsLibraries(libs);
	        
	        return archive;
  
  }
		
		@Test
		public void getAllCauseIdAndDescRESTTest() {
			Object[][] result = given()
					.parameter("imsi", "240210000000013")
					.when()
					.get("http://localhost:8080/TeamProject-0.0.1-SNAPSHOT/rest/baseData/eventid_causeid")
					.as(Object[][].class);
				assertEquals(4098, result[0][2]);
		}

	
	@EJB
	private BaseDataDAO dao;

	@Test
	public void notNullTest(){
		assertNotNull(dao);
	}
	
	//here create simple test which check method of ejb
	@Test
	public void isBaseDataEmpty() throws Exception {
		int phoneTypeDummy = 33000153;
		String startDate =  "11/01/2013 17:09:00";
		String endDate = "11/01/2013 17:17:00";
		//Assert.assertEquals(dao.getEU().size(),);
		//assertEquals(dao.getEU().size(), 1);
		//assertFalse(!dao.getEU().isEmpty());
		assertFalse(dao.getTotalFailuresOfSpecificPhone(phoneTypeDummy, startDate, endDate).isEmpty());	
		
	}
	
	@Test
	public void isBaseDataEmptyIMSI() throws Exception {
		BigInteger IMSIDummy = new BigInteger("344930000000011");
		String startDate =  "11/01/2013 17:09:00";
		String endDate = "11/01/2013 17:17:00";
		assertFalse(dao.getTotalFailuresOfSpecificIMSI(IMSIDummy, startDate, endDate).isEmpty());	
		
	}
	

}

*/