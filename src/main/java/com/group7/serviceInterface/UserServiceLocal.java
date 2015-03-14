package com.group7.serviceInterface;

import java.util.Collection;

import javax.ejb.Local;

import com.group7.entities.User;

@Local
public interface UserServiceLocal {

	Collection<User> showAllUsers();
	User getUserByEmail(String email,String password, int i);
	//User addUser(String email, String password, int position);
  User addUser(String email,String password, int type);
}