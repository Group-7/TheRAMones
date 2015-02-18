package com.group7.rest;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.group7.entities.ErrorTable;
import com.group7.serviceInterface.ErrorTableServiceInterface;

@Path("/ErrorTable")
public class ErrorTableREST {

	@EJB
	private ErrorTableServiceInterface etsi;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<ErrorTable>getAllErrorRecords(){
		return etsi.getAllErrorRecords();
		
	}
}
