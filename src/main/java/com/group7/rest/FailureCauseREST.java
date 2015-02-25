package com.group7.rest;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.group7.entities.Failure;
import com.group7.serviceInterface.FailureCauseServiceLocal;

@Path("/failureCause")
public class FailureCauseREST {

	@EJB
	private FailureCauseServiceLocal evsl;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Failure> getAllFailureCauses() {
		return evsl.getAllFailureCauses();

	}
}
