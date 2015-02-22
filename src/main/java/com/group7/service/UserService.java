package com.group7.service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import com.group7.daoInterface.UserDAOLocal;
import com.group7.entities.User;
import com.group7.serviceInterface.UserServiceLocal;

@Stateless
@Local
public class UserService implements UserServiceLocal {

	
	@EJB
	private UserDAOLocal dao;
	
	/**
	 * Method to return all users
	 */
	public Collection<User> showAllUsers() {
		return dao.showAllUsers();
	}

	public User getUserByEmail(String email,String password) {
		return dao.searchUserByEmail(email, password);
	}

}