package com.group7.dao;


import java.util.Collection;



import javax.ejb.Local;
import com.group7.entities.EventCause;

@Local
public interface EventCauseDAO {
	Collection<EventCause> getAllEventCauses();

}