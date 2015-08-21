package io.pivotal.sensor.service;

import io.pivotal.sensor.model.User;

public interface UsersAPIService {
	
	Iterable<User> getAllUsers();

}
