package com.group7.service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.group7.dao.EventCauseDAO;
import com.group7.entities.EventCause;
import com.group7.serviceInterface.EventCauseServiceLocal;


@Stateless
@Local
public class EventCauseServiceEJB implements EventCauseServiceLocal {

	@EJB
	private EventCauseDAO eventCauseDAOInterface;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<EventCause> getAllEventCauses() {
		
		return eventCauseDAOInterface.getAllEventCauses();
	}

}