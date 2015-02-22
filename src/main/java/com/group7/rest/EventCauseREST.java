package com.group7.rest;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.group7.entities.EventCause;
import com.group7.serviceInterface.EventCauseServiceInterface;

@Path("/eventCause")
public class EventCauseREST {

	@EJB
	private EventCauseServiceInterface evsl;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<EventCause> getAllEventCauses() {
		return evsl.getAllEventCauses();

	}

	@GET
	@Path(value = "/String")
	@Produces(MediaType.TEXT_PLAIN)
	public String testString() {
		return "testing eventcause";

	}

}