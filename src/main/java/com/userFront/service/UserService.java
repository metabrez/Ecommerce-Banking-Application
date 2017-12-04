package com.userFront.service;

import com.userFront.domain.User;

public interface UserService {
	
	User findByUsername(String username);

	User findByEmail(String email);
	boolean checkUserExists(String username,String email);
	boolean checkUsernameExists(String username);
	boolean checkUserEmailExists(String email);
	void save(User user);

}
