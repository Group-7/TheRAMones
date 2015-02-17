package com.group7.rest;


import java.util.Collection;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.group7.entities.UE;
import com.group7.serviceInterface.UeService;

@Path("/UE_Table")
public class UeRest {

	@EJB
	UeService service;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<UE> getEU() {
		return service.getAllEU();
	}
		
}
	
	

