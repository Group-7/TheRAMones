package com.group7.rest;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.group7.entities.TACAccessCapability;
import com.group7.serviceInterface.TACAccessCapabilityServiceI;

@Path("/TACAccessCap")
public class TACAccessCapabilityREST {
	
	@EJB
	private TACAccessCapabilityServiceI TACAccessCapabilityService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<TACAccessCapability> getAllTACAccessCapabilities(){
		return TACAccessCapabilityService.getAllTACAccessCapabilities();
		
	}
}
