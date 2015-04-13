/*package com.group7.arquillian;

import static com.jayway.restassured.RestAssured.expect;
import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import jxl.read.biff.BiffException;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.extension.rest.client.ArquillianResteasyResource;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.group7.rest.BaseDataREST;
import com.group7.serviceInterface.BaseDataServiceLocal;
import com.jayway.restassured.http.ContentType;

@RunWith(Arquillian.class)
public class BaseDataRESTtests {
	
//	@Deployment
//    public static WebArchive createDeployment() {
//        WebArchive archive = ShrinkWrap
//                .create(WebArchive.class, "test.war")
//                //.addClasses(BaseDataRESTtests.class)
//                .addPackages(true, "com.group7")
//                        .addAsResource("META-INF/persistence.xml")
//                        .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
//
//       File[] libs;
//
//        libs = Maven.resolver()
//                .resolve("com.jayway.restassured:rest-assured:2.4.0")
//                .withTransitivity().as(File.class);
//        archive.addAsLibraries(libs);
//
//        libs = Maven.resolver().resolve("org.apache.poi:poi:3.11")
//                .withTransitivity().as(File.class);
//        archive.addAsLibraries(libs);
//        
//        return archive;
//	}
//	
//	
//	
//	@PersistenceContext
//	EntityManager em;
//	
//	@Inject
//	UserTransaction tx;
//	
//	@Inject
//	BaseDataREST brt;
//	
//	@Before
//	public void init() throws Exception{
//	tx.begin();
//	em.joinTransaction();
//		
//	}
//	
//	@After
//	public void finalise() throws Exception{
//		tx.commit();
//		
//		
//	}
	

	BaseData[] bd = expect()
	         .statusCode(200)
	         .contentType(ContentType.JSON)
	         .log().ifError()
	         .when()
	         .get("http://localhost:8080/TeamProject-0.0.1-SNAPSHOT/rest/baseData")
	         .as(BaseData[].class);	
	    	 assertEquals("240210000000013", bd[0].getImsi());



	@Test
	public void getAllEventIdAndCauseIdRESTTest() {
		Object[][] result = given()
				.parameter("imsi", "240210000000013")
				.when()
				.get("http://localhost:8080/TeamProject-0.0.1-SNAPSHOT/rest/baseData/eventid_causeid")
				.as(Object[][].class);
			assertEquals(4098, result[0][2]);
	}
	
	@Inject
	BaseDataServiceLocal bdl;
	
	@Test
	public void getAllCauseIdAndDescRESTTest(@ArquillianResteasyResource BaseDataREST brt) throws IOException {
		
		//List<Object> bdl = (List<Object>) brt.getAllEventIdAndCauseIdREST(new BigInteger("240210000000013"));
		ArrayList<BigInteger> imsis=(ArrayList<BigInteger>)brt.getImsiFailureOverTime("01/01/0013 12:40:20,12/12/0015 12:40:20");

		
		
		Object[][] result = given()
				.parameter("imsi", "240210000000013")
				.when()
				.get("http://localhost:8080/TeamProject-0.0.1-SNAPSHOT/rest/baseData/eventid_causeid")
				.as(Object[][].class);
			assertEquals(4098, result[0][2]);
	}

	
	@Test
	public void getUniqueAffectedImsiTest() {
		BigInteger[] result = given()
				.when()
				.get("http://localhost:8080/TeamProject-0.0.1-SNAPSHOT/rest/baseData/uniqueIMSI")
				.as(BigInteger[].class);
			assertEquals(new BigInteger("240210000000013"), result[0]);
	}
	
	
	@Test
	public void getImsiFailureOverTimeTest() {
		BigInteger[] result = given()
				.parameter("dates", "11/11/0012 17:00:00,11/11/0015 17:30:00")
				.when()
				.get("http://localhost:8080/TeamProject-0.0.1-SNAPSHOT/rest/baseData/imsi")
				.as(BigInteger[].class);
			assertEquals(new BigInteger("240210000000013"), result[0]);
	}
	
	
	
	

}*/