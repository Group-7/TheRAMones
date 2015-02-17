package com.group7.dao;

import java.util.Collection;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.group7.daoInterface.EventCauseDAOInterface;
import com.group7.entities.EventCause;

@Local
@Stateless
public class EventCauseDAO implements EventCauseDAOInterface{
 
	@PersistenceContext
	private EntityManager entitymanager;

	public Collection<EventCause> getAllEventCauses() {
			Query query = entitymanager.createQuery("from Event_Cause_Table");
			return query.getResultList();
		}
		
}
