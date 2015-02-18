package com.group7.rest;

import java.util.Collection;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.group7.entities.BaseData;
import com.group7.serviceInterface.BaseDataService;

@Path("/baseData")
public class BaseDataRestService {

	@Inject
	private BaseDataService service;
	
	public BaseDataRestService(){
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<BaseData> getAllbaseData(){
		return service.getAllBasedata();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addBaseData(BaseData basedata){
		service.addBaseData(basedata);
	}
}
