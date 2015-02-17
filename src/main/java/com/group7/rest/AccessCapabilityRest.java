package com.group7.rest;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ws.rs.Path;

import com.group7.entities.AccessCapability;
import com.group7.serviceInterface.AccessCapabilityService;

@Path("/Access_Capability")
public class AccessCapabilityRest {
	
	@EJB
	AccessCapabilityService service;

	public Collection<AccessCapability> getAccessCapability() {
		return service.getAllAccessCapability();
	}
}
