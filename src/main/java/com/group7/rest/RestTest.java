package com.group7.rest;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.group7.importBaseData.BaseDataValidation;
import com.group7.serviceInterface.BaseDataServiceLocal;

@Path("/resttest")
public class RestTest {

//	@Inject
//	private BaseDataServiceLocal service;

	public RestTest() {

	}
	@GET
	@Path("/test")
	@Produces(MediaType.APPLICATION_JSON)
	public String test(){
	//	String testString = "hello world";
		return "hello world";
	}
}