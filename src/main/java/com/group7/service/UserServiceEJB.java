package com.group7.service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import com.group7.dao.UserDAO;
import com.group7.entities.User;
import com.group7.serviceInterface.UserServiceLocal;

@Stateless
@Local
public class UserServiceEJB implements UserServiceLocal {

	
	@EJB
	private UserDAO dao;
	
	/**
	 * Method to return all users
	 */
	public Collection<User> showAllUsers() {
		return dao.showAllUsers();
	}

	public User getUserByEmail(String email,String password, int type) {
		return dao.searchUserByEmail(email, password, type);
	}
	
	public User addUser(String email,String password, int type){
		//System.out.println(user.getEmail());
	
		return dao.addUser(email,password,type);
	}

//	@Override
//	public User addUser(String email, String password, int position) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}