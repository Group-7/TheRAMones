/*package com.group7.arquillian;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.math.BigInteger;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;

import com.group7.dao.BaseDataDAO;
import com.group7.dao.EventCauseDAO;
import com.group7.dao.jpa.BaseDataDAOImpl;
import com.group7.dao.jpa.EventCauseDAOImpl;
import com.group7.databases.DataBaseProducer;
import com.group7.entities.BaseData;
import com.group7.entities.EventCause;
import com.group7.entities.EventCauseID;
import com.group7.entities.Failure;
import com.group7.entities.Network;
import com.group7.importBaseData.BaseDataExcelRead;

public class BaseDataRestAssured {

//	@Deployment
//	public static JavaArchive createDeployment() {
//		return ShrinkWrap
//				.create(JavaArchive.class, "test2.jar")
//				.addClasses(BaseData.class, Network.class, Failure.class,
//						EventCauseDAOImpl.class, EventCause.class,
//						EventCauseDAO.class, EventCauseID.class)
//				.addPackage(BaseDataDAOImpl.class.getPackage())
//				.addPackage(BaseDataDAO.class.getPackage())
//				.addPackage(BaseData.class.getPackage())
//				.addPackage(BaseDataExcelRead.class.getPackage())
//				.addPackage(DataBaseProducer.class.getPackage())
//				.addAsResource("META-INF/persistence.xml")
//				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
//
//	}

	@Test
	public void testgetAllEventIdAndCauseIdREST() {
		Object[] o = given()
				.when()
				.get("http://localhost:8080/TeamProject-0.0.1-SNAPSHOT/rest/baseData/eventid_causeid?imsi=191911000456426")
				.as(Object[].class);
		assertEquals(4, o.length);
		String[] first = myTrim(o[0].toString());
		assertEquals("191911000456426", first[0]);
		assertEquals("1", first[1].trim());
		assertEquals("4098", first[2].trim());
		assertEquals("S1 SIG CONN SETUP-S1 INTERFACE DOWN", first[3].trim());

		String[] second = myTrim(o[1].toString());
		assertEquals("191911000456426", second[0]);
		assertEquals("1", second[1].trim());
		assertEquals("4098", second[2].trim());
		assertEquals("S1 SIG CONN SETUP-S1 INTERFACE DOWN", second[3].trim());

		String[] third = myTrim(o[2].toString());
		assertEquals("191911000456426", third[0]);
		assertEquals("1", third[1].trim());
		assertEquals("4098", third[2].trim());
		assertEquals("S1 SIG CONN SETUP-S1 INTERFACE DOWN", third[3].trim());

		String[] fourth = myTrim(o[2].toString());
		assertEquals("191911000456426", fourth[0]);
		assertEquals("1", fourth[1].trim());
		assertEquals("4098", fourth[2].trim());
		assertEquals("S1 SIG CONN SETUP-S1 INTERFACE DOWN", fourth[3].trim());
	}

	@Test
	public void testgetAllCauseIdAndDescREST() {
		Object[] imsis = given()
				.when()
				.get("http://localhost:8080/TeamProject-0.0.1-SNAPSHOT/rest/baseData/causeid_per_imsi?imsi=191911000147151")
				.as(Object[].class);
		assertEquals(1, imsis.length);
		String[] imsiAsArray = myTrim(imsis[0].toString());
		assertEquals("17", imsiAsArray[0].trim());
		assertEquals("INITIAL CTXT SETUP-SRB2 SETUP FAILURE",
				imsiAsArray[1].trim());
	}

	@Test
	public void testgetUniqueAffectedImsi() {
		BigInteger[] iniqueImsis = given()
				.when()
				.get("http://localhost:8080/TeamProject-0.0.1-SNAPSHOT/rest/baseData/uniqueIMSI")
				.as(BigInteger[].class);
		assertEquals(6313, iniqueImsis.length);
	}

	@Test
	public void testgetTotalFailuresOfSpecificPhone() {
		Long[] numberOfTacs = given()
				.when()
				.get("http://localhost:8080/TeamProject-0.0.1-SNAPSHOT/rest/baseData/tacFailures?TAC=33001735&startDate=01/01/2011 17:00:00&endDate=01/01/2015 17:00:00")
				.as(Long[].class);
		assertEquals(3508, numberOfTacs[0].longValue());
	}

	@Test
	public void getTotalFailuresOfSpecificIMSI() {
		Long[] numberOfimsis = given()
				.when()
				.get("http://localhost:8080/TeamProject-0.0.1-SNAPSHOT/rest/baseData/imsiFailures?imsi=191911000284589&startDate=01/01/2011 17:00:00&endDate=01/01/2015 17:00:00")
				.as(Long[].class);
		assertEquals(8, numberOfimsis[0].longValue());
		assertFalse(numberOfimsis[0].longValue() == 7);

	}
 
	@Test
	public void testgetTotalDurationOfSpecificIMSI() {
		Object[] imsis = given()
				.when()
				.get("http://localhost:8080/TeamProject-0.0.1-SNAPSHOT/rest/baseData/imsiTotalDuration?imsi=191911000284589&startDate=01/01/2011 17:00:00&endDate=01/01/2015 17:00:00")
				.as(Object[].class);
		assertEquals(1, imsis.length);
		String[] imsisAsArray = myTrim(imsis[0].toString());
		assertEquals("191911000284589", imsisAsArray[0]);
		assertEquals("8", imsisAsArray[1].trim());
		assertEquals("8040", imsisAsArray[2].trim());
	}

	@Test
	public void testgetAllUniqueEventCausecodeCombinations() {
		Object[] modelWithFaliures = given()
				.when()
				.get("http://localhost:8080/TeamProject-0.0.1-SNAPSHOT/rest/baseData/modelFailure?model=9109 PA")
				.as(Object[].class);
		assertEquals(16, modelWithFaliures.length);
		String[] modelsAsArray = myTrim(modelWithFaliures[0].toString());
		assertEquals("9109 PA", modelsAsArray[0]);
		assertEquals("4106", modelsAsArray[1].trim());
		assertEquals("INITIAL CTXT SETUP-CSFB LICENSE MISSING",
				modelsAsArray[2].trim());
		assertEquals("22", modelsAsArray[3].trim());
		assertEquals("152", modelsAsArray[4].trim());

		String[] modelsAsArray2 = myTrim(modelWithFaliures[1].toString());
		assertEquals("9109 PA", modelsAsArray2[0]);
		assertEquals("4125", modelsAsArray2[1].trim());
		assertEquals("UE CTXT RELEASE-AUTHENTICATION FAILURE",
				modelsAsArray2[2].trim());
		assertEquals("2", modelsAsArray2[3].trim());
		assertEquals("88", modelsAsArray2[4].trim());
	}

	@Test
	public void testgetAllPhoneTypes() {
		BigInteger[] phoneTypes = given()
				.when()
				.get("http://localhost:8080/TeamProject-0.0.1-SNAPSHOT/rest/baseData/uniqueTAC")
				.as(BigInteger[].class);
		assertEquals(19, phoneTypes.length);
	}

	@Test
	public void testgetAllDistictPhoneModels() {
		String[] phoneModels = given()
				.when()
				.get("http://localhost:8080/TeamProject-0.0.1-SNAPSHOT/rest/baseData/uniqueModels")
				.as(String[].class);
		assertEquals(91, phoneModels.length);
	}

	@Test
	public void testgetTopTenImsiDuringPeriod() {
		Object[] topTenImsi = given()
				.when()
				.get("http://localhost:8080/TeamProject-0.0.1-SNAPSHOT/rest/baseData/toptenimsi?startDate=01/01/2011 17:00:00&endDate=01/01/2015 17:00:00")
				.as(Object[].class);
		assertEquals(10, topTenImsi.length);
		String[] firstIntTopTen = myTrim(topTenImsi[0].toString());
		assertEquals("191911000049149", firstIntTopTen[0]);
		assertEquals("40", firstIntTopTen[1].trim());

		String[] lastInTopTen = myTrim(topTenImsi[9].toString());
		assertEquals("191911000071723", lastInTopTen[0]);
		assertEquals("32", lastInTopTen[1].trim());
	}

	@Test
	public void testimsiEffectedByAFailureCauseClass() {
		Object[] imsis = given()
				.when()
				.get("http://localhost:8080/TeamProject-0.0.1-SNAPSHOT/rest/baseData/imsifailureclass?failure=EMERGENCY")
				.as(Object[].class);
		assertEquals(7986, imsis.length);
	}

	@Test
	public void testgetFailureDescriptionForDropDown() {
		Object[] failures = given()
				.when()
				.get("http://localhost:8080/TeamProject-0.0.1-SNAPSHOT/rest/baseData/failuredropdown")
				.as(Object[].class);
		assertEquals(5, failures.length);
		assertEquals("EMERGENCY", failures[0]);
		assertEquals("HIGH PRIORITY ACCESS", failures[1]);
		assertEquals("MT ACCESS", failures[2]);
		assertEquals("MO SIGNALLING", failures[3]);
		assertEquals("MO DATA", failures[4]);
	}

	private String[] myTrim(String word) {
		word = word.substring(1, word.length() - 1);
		return word.split(",");

	}

}
*/