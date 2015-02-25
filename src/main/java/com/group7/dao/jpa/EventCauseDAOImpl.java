package com.group7.dao.jpa;

import java.util.Collection;




import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.group7.dao.EventCauseDAO;
import com.group7.entities.EventCause;

@Stateless
@Local
public class EventCauseDAOImpl implements EventCauseDAO{
 
	@PersistenceContext
	private EntityManager em;

	
	public Collection<EventCause> getAllEventCauses() {
			Query query = em.createQuery("from Event_Cause_Table");
			return query.getResultList();
		}
		
}