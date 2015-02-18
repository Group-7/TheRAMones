package com.group7.serviceInterface;
import java.util.Collection;


import javax.ejb.Local;

import com.group7.entities.EventCause;


@Local
public interface EventCauseServiceInterface {
	
	Collection<EventCause> getAllEventCauses();

}
