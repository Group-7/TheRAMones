package com.group7.rest;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.group7.entities.User;
import com.group7.serviceInterface.UserServiceLocal;

@Path("/users")
public class UserREST {
	
	@EJB
	private UserServiceLocal service;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<User> getUsers(){
		return service.showAllUsers();
	}

	/*@GET
	@Path("/{email}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getbyEmail(@PathParam("email") String email){
		return service.getUserByEmail(email);
	}*/
	
	@POST
	@Path("/auth")
	@Produces(MediaType.APPLICATION_JSON)
	public User authenticateUser(User user){
		
		/*user=new User();
		user.setEmail("ns@c.com");
		user.setPassword("fggg");
		user.setType(1);
		return user;*/
		return service.getUserByEmail(user.getEmail(),user.getPassword());
	}
	
	

}