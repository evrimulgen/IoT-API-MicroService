package io.pivotal.sensor.service;

import org.springframework.web.client.RestTemplate;

import io.pivotal.sensor.model.User;

public class UsersAPIServiceImpl implements UsersAPIService {

	RestTemplate rest = new RestTemplate();
	
	@Override
	public Iterable<User> getAllUsers() {
		
		Iterable<User> users = rest.getForObject("http://localhost:2225/get-all-users-ms", Iterable.class);
		return users;
	}

}
