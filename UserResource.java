package com.techm.ms.resource;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Service;

import com.techm.ms.model.User;

import io.swagger.annotations.Api;

/**
 * This is the Interface definition for User Resource
 * 
 */

@Api("User")
@Path("/users")
public interface UserResource {
	
	@GET
	@Path("/users")
	@Produces("application/json")
	List<User>getUsers();
	
	
	@GET
	@Path("{id}")
	@Produces("application/json")
	Response getUser(@PathParam("id") long id);
	
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	Response createUser(User u) throws URISyntaxException;
	
	
}