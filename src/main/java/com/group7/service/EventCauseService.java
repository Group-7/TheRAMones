package com.group7.service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.group7.daoInterface.EventCauseDAOInterface;
import com.group7.entities.EventCause;
import com.group7.serviceInterface.EventCauseServiceInterface;


@Stateless
@Local
public class EventCauseService implements EventCauseServiceInterface {

	@EJB
	private EventCauseDAOInterface eventCauseDAOInterface;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<EventCause> getAllEventCauses() {
		
		return eventCauseDAOInterface.getAllEventCauses();
	}

}
