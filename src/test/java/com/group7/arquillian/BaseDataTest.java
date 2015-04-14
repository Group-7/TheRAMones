package com.group7.arquillian;

import static org.junit.Assert.*;

import java.io.File;
import java.math.BigInteger;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.group7.entities.BaseData;
import com.group7.entities.BaseDataError;
import com.group7.entities.EventCause;
import com.group7.entities.Failure;
import com.group7.entities.Network;
import com.group7.entities.UE;
import com.group7.serviceInterface.BaseDataServiceLocal;
import com.sun.jmx.snmp.Timestamp;


@RunWith(Arquillian.class)
public class BaseDataTest {
	
	
			@Deployment
		    public static WebArchive createDeployment() {
		        WebArchive archive = ShrinkWrap
		                .create(WebArchive.class, "test.war")
		                .addPackages(true, "com.group7")
		                        .addAsResource("META-INF/persistence.xml")
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
			
	@EJB
	private BaseDataServiceLocal service;

	@Test
	public void getAllBasedata() {
	
		Collection<BaseData> data = service.getAllBasedata();
		assertTrue(data.size() >= 0);
	}
	
	@Test
	public void getAllCauseCodeAndDescByIMSI() {
	
	Collection<Object> data = service.getAllCauseCodeAndDescByIMSI(new BigInteger("240210000000013"));
	assertEquals(data.size(),0);
	}
	
	@Test
	public void getAllDistinctPhoneModels() {
	
		Collection<String> data = service.getAllDistinctPhoneModels();
		assertEquals(data.size(),0);
	}
	
	@Test
	public void getAllEventIdAndCauseId() {
	
	Collection<Object> data = service.getAllEventIdAndCauseId(new BigInteger("240210000000013"));
	assertEquals(data.size(),0);
	}
	
	@Test
	public void getAllPhoneTypes() {
	
		Collection<BigInteger> data = service.getAllPhoneTypes();
		assertEquals(data.size(),1);
	}
	
	@Test
	public void getAllUniqueEventCausecodeCombinations() {
	
	Collection<Object> data = service.getAllUniqueEventCausecodeCombinations("VEA3");
	assertEquals(data.size(),0);
	}
	
	@Test
	public void getFailureDescriptionForDropDown() {
	
		Collection<String> data = service.getFailureDescriptionForDropDown();
		assertEquals(data.size(),0);	
	}
	
	@Test
	public void getImsiFailureOverTime() {
	
		Collection<BigInteger> imsis=service.getImsiFailureOverTime("01/01/0012 12:40:20", "12/12/0015 12:40:20");
		assertEquals(imsis.size(),0);	
	}
	
	@Test
	public void getTotalDurationOfSpecificIMSI() {
	
	Collection<Object> data = service.getAllCallFailuresAndTotalDurationPerIMSI(new BigInteger("240210000000013"), "01/01/0012 12:40:20", "12/12/0015 12:40:20");
	assertEquals(data.size(),1);
	}
	
	@Test
	public void getTotalFailuresOfSpecificIMSI() {
	
	Collection<Long> data = service.getTotalFailuresOfSpecificIMSI(new BigInteger("240210000000013"), "01/01/0012 12:40:20", "12/12/0015 12:40:20");
	assertEquals(data.size(),1);
	}
	
	@Test
	public void getTotalFailuresOfSpecificPhone() {
	
	Collection<Long> data = service.getTotalFailuresOfSpecificPhone(21060800, "01/01/0012 12:40:20", "12/12/0015 12:40:20");
	assertEquals(data.size(),1);
	}
	
	@Test
	public void getUniqueAffectedImsi() {
	
	Collection<BigInteger> data = service.getUniqueAffectedImsi();
	assertEquals(data.size(),2);
	}
	
	@Test
	public void getUS11() {
	
		Collection<BigInteger> imsis=service.getUS11("01/01/0012 12:40:20", "12/12/0015 12:40:20");
		assertEquals(imsis.size(),0);	
	}
	
	@Test
	public void imsiEffectedByAFailureCauseClass() {
	
		Collection<BaseData> data = service.imsiEffectedByAFailureCauseClass("1");
		assertEquals(data.size(),0);
	}
	
	@Test
	public void addBaseDataTest() {
	BaseData bd = new BaseData();
	Date date = new Date(99999999);
	java.sql.Timestamp time = new java.sql.Timestamp(date.getTime());

	EventCause ec = new EventCause();
	ec.setCauseCode(1212);
	ec.setDescription("invalid test description");
	ec.setEventId(12);
	
	Network nm = new Network();
/*	nm.setCountry("2334");
	nm.setMcc(34);
	nm.setMnc(33);
	nm.setOperator("5647");
	nm.setNetworkBD(new ArrayList<BaseData>());*/
	
	UE uem = new UE();
	uem.setAccessCapability("dummy");	
	uem.setInputMode("dummy");
	uem.setManufacturer("Manufacturer");
	uem.setMarketingName("name");
	uem.setModel("Model");
	uem.setOperatingSystem("OS");
	uem.setTac(123456);
	uem.setUeBD(new ArrayList<BaseData>());
	uem.setUeType("dummy");
	uem.setVendorName("vendor name");
	
	Failure fm = new Failure();
	fm.setDescription("description");
	fm.setFailureBD(new ArrayList<BaseData>());
	fm.setFailureCode((int) service.getLastRowId()+11);
	
	bd.setDateAndTime(new java.sql.Timestamp(date.getTime()));
	bd.setId(service.getLastRowId()+10);
	bd.setCellid(12);
	bd.setDuration(1000);
//	bd.setEventCauseMap(ec);
	bd.setImsi(new BigInteger("240210000000013"));
	bd.setNeVersion("23");
//	bd.setNetworkMap(nm);
//	bd.setUeMap(uem);
	bd.setHeir321ID("1324354657687980");
	bd.setHeir32ID("1324354657687980");
	bd.setHeir3ID("1324354657687980");
//	bd.setFailureMap(fm);

	service.addBaseData(bd);
	
	}
	
	@Test
	public void putErrorDataTest() {
	Date date = new Date(99999999);	
	java.sql.Timestamp time = new java.sql.Timestamp(date.getTime());
	Collection<BaseDataError> bdErrors = new ArrayList<BaseDataError>();
	
	BaseDataError bde = new BaseDataError("123", "time", "new Integer(13)", "1000", "223", "new BigInteger('240210000000013')", "1324354657687980", "1324354657687980", "1324354657687980", "34", "45", "56", "67", "78");
	bdErrors.add(bde);
	service.putErrorData(bdErrors);
	}
	
	
	
	@Test
	public void getTopTenImsiDuringPeriodTest(){
		service.getTopTenImsiDuringPeriod("01/01/0012 12:40:20", "12/12/0015 12:40:20");
	}
}
