package com.group7.junit;

import static org.junit.Assert.*;

import java.security.spec.ECField;

import org.junit.Before;
import org.junit.Test;

import com.group7.entities.EventCauseID;

public class EventCauseIDTest {
	
	EventCauseID ecID = new EventCauseID();
	
	@Before
	public void init(){
		ecID.setEventId(new Integer(4098));
		ecID.setCauseCode(new Integer(1234));
		
	}

	@Test
	public void test() {
		EventCauseID ecID2 = new EventCauseID();
		
		assertEquals(ecID.getEventId(),new Integer(4098));
		assertEquals(ecID.getCauseCode(), new Integer(1234));
		assertFalse(ecID.equals(ecID2));
		assertTrue(ecID.getEventId().equals(new Integer(4098)));
		assertFalse(ecID.hashCode() == ecID2.hashCode());

	}

}
