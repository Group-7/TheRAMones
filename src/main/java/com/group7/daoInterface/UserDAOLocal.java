package com.group7.daoInterface;

import java.util.Collection;

import javax.ejb.Local;

import com.group7.entities.User;

@Local
public interface UserDAOLocal {

	Collection<User> showAllUsers();
	
	public User searchUserByEmail(String email,String password);
}