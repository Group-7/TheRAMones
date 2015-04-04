package com.group7.junit;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.group7.entities.BaseData;
import com.group7.entities.EventCause;
import com.group7.entities.Failure;
import com.group7.entities.Network;
import com.group7.entities.UE;

public class BaseDataTest {

	BaseData bd1;
	BaseData bd2;
	
	Timestamp ts1;
	Timestamp ts2;
	
	@Before
	public void beforEqualsTest(){
		
		bd1=new BaseData();
		bd2=new BaseData();
		
		Calendar c1=Calendar.getInstance();
		Calendar c2=Calendar.getInstance();
	
		
		c1.set(2013, 5, 21, 15, 50, 23);
		c2.set(2013, 6, 21, 15, 50, 23);
		
		Date d1=c1.getTime();
		Date d2=c2.getTime();
		
		ts1 = new Timestamp(d1.getTime());
		ts2 = new Timestamp(d2.getTime());
		
		bd1.setDateAndTime(ts1);
		bd2.setDateAndTime(ts1);
		
		Failure failure=new Failure();
		failure.setFailureCode(1);
		bd1.setFailureMap(failure);
		UE ue=new UE();
		ue.setTac(new Integer("21060800"));
		bd1.setUeMap(ue);
		EventCause ec=new EventCause();
		ec.setCauseCode(0);
		ec.setEventId(4098);
		
		bd1.setEventCauseMap(ec);
		Network network= new Network();
		network.setMcc(340);
		network.setMnc(930);
		bd1.setNetworkMap(network);
		bd1.setCellid(4);
		bd1.setDuration(1000);
		bd1.setNeVersion("11B");
		bd1.setImsi(new BigInteger("344930000000011"));
		bd1.setHeir321ID("1150444940909480000");
		bd1.setHeir32ID("8226896360947470000");
		bd1.setHeir3ID("4809532081614990000");
		
		Failure f2=new Failure();
		f2.setFailureCode(1);
		bd2.setFailureMap(f2);
		UE ue2=new UE();
		ue2.setTac(21060800);
		bd2.setUeMap(ue2);
		EventCause ec2=new EventCause();
		ec2.setCauseCode(0);
		ec2.setEventId(4098);
		bd2.setEventCauseMap(ec2);
		Network n1=new Network();
		n1.setMcc(340);
		n1.setMnc(930);
		bd2.setNetworkMap(n1);
		bd2.setCellid(4);
		bd2.setDuration(1000);
		bd2.setNeVersion("11B");
		bd2.setImsi(new BigInteger("344930000000011"));
		bd2.setHeir321ID("1150444940909480000");
		bd2.setHeir32ID("8226896360947470000");
		bd2.setHeir3ID("4809532081614990000");
		
	}
	
	
	@Test
	public void equalsTestDate() {
		
		assertTrue(bd1.equals(bd2));
		bd2.setDateAndTime(ts2);
		
		
		assertFalse(bd1.equals(bd2));
	}
	
	@Test
	public void equalsTestCaseCode() {
		assertTrue(bd1.equals(bd2));
		bd2.getEventCauseMap().setCauseCode(7);
		
		assertFalse(bd1.equals(bd2));
	}

	
	
	@Test
	public void equalsTestFailure() {
		assertTrue(bd1.equals(bd2));
		bd2.getFailureMap().setFailureCode(3);
		
		assertFalse(bd1.equals(bd2));
	}
	
	@Test
	public void equalsTestEventId() {
		assertTrue(bd1.equals(bd2));
		bd2.getEventCauseMap().setEventId(4097);
		assertFalse(bd1.equals(bd2));
	}
	
	@Test
	public void equalsTestTAC() {
		assertTrue(bd1.equals(bd2));
		bd2.getUeMap().setTac(333672837);
		assertFalse(bd1.equals(bd2));
	}
	
	@Test
	public void equalsTestMCC() {
		assertTrue(bd1.equals(bd2));
		bd2.getNetworkMap().setMnc(920);
		assertFalse(bd1.equals(bd2));
	}
	
	@Test
	public void equalsTestDuration() {
		assertTrue(bd1.equals(bd2));
		bd2.setDuration(1001);
		
		assertFalse(bd1.equals(bd2));
	}
	
	@Test
	public void equalsTestNEVersion() {
		assertTrue(bd1.equals(bd2));
		bd2.setNeVersion("11c");
		
		assertFalse(bd1.equals(bd2));
	}
	
	@Test
	public void equalsTestIMSI() {
		assertTrue(bd1.equals(bd2));
		bd2.setImsi(new BigInteger("344990000000012"));
		
		assertFalse(bd1.equals(bd2));
	}
	
	@Test
	public void equalsTestHEIR3() {
		assertTrue(bd1.equals(bd2));
		bd2.setHeir3ID("666346847920");
		
		assertFalse(bd1.equals(bd2));
	}
	
	@Test
	public void equalsTestHEIR32() {
		assertTrue(bd1.equals(bd2));
		bd2.setHeir3ID("67483942794");
		
		assertFalse(bd1.equals(bd2));
	}
	
	@Test
	public void equalsTestHEIR321() {
		assertTrue(bd1.equals(bd2));
		bd2.setHeir3ID("5678364829374");
		
		assertFalse(bd1.equals(bd2));
	}
}