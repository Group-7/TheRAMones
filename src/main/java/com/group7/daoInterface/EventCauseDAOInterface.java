package com.group7.daoInterface;


import java.util.Collection;



import javax.ejb.Local;
import com.group7.entities.EventCause;

@Local
public interface EventCauseDAOInterface {
	Collection<EventCause> getAllEventCauses();

	String testRun();
		
	
}
