package com.techm.ms.resource;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import com.techm.ms.model.User;

@Controller

public class UserResourceImpl implements UserResource {

	static Map<Long,User> userList=new HashMap<>();
	
	public UserResourceImpl(){
		
		User u= new User(123,"Nancy", 35, 345);
		userList.put(u.getId(),u);
		User u1= new User(124,"Rose", 25, 34445);
		userList.put(u1.getId(),u1);
		System.out.println("userResourceImpl:"+userList.size());
	}
	
	
	@Override
	public List<User> getUsers() {
		System.out.println("In getUser()");
		Collection<User> c=userList.values();
		List<User> u=new ArrayList<User>(c);
		
		return u;
	}

	@Override
	public Response createUser(User u) throws URISyntaxException {		
		userList.put(u.getId(), u);
		return Response.status(201).entity(u).build();
	}


	


	@Override
	public Response getUser(long id)  {
		if(userList.get(id)==null) {
			System.out.println("Id is null");
		}
		User user=userList.get(id);
		return Response.status(Status.OK).entity(user).build();
	}
	
}
