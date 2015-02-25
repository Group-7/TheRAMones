package com.group7.rest;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.group7.entities.Network;
import com.group7.serviceInterface.NetworkServiceLocal;

@Path("/network")
public class NetworkREST {

	@EJB
	private NetworkServiceLocal service;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Network> getNetwork(){
		return service.getAllNetworkInfo();
	}
	
}