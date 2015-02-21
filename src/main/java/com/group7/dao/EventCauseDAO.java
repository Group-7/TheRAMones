package com.group7.dao;

import java.util.Collection;




import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.group7.daoInterface.EventCauseDAOInterface;
import com.group7.entities.EventCause;

@Stateless
@Local
public class EventCauseDAO implements EventCauseDAOInterface{
 
	@PersistenceContext
	private EntityManager em;

	
	public Collection<EventCause> getAllEventCauses() {
			Query query = em.createQuery("from Event_Cause_Table");
			return query.getResultList();
		}


	@Override
	public String testRun() {
		// TODO Auto-generated method stub
		return "just testing the container";
	}
		
}
