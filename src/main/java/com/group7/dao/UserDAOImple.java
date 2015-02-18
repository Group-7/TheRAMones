package com.group7.dao;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.group7.daoInterface.UserDAOLocal;
import com.group7.entities.User;

@Local
@Stateless
public class UserDAOImple implements UserDAOLocal {

	@PersistenceContext
	private EntityManager em;

	/**
	 * A method to run all the users in the system.
	 * 
	 * @return A Collection of User objects from the DB
	 * @param None
	 */
	public Collection<User> showAllUsers() {
		Query q = em.createQuery("from Users");
		return q.getResultList();
	}

	public User searchUserByEmail(String email,String password) {
		System.out.println("Validating user "+email);
		Query q = em.createQuery("from User u where u.email = :email");
		q.setParameter("email", email);
		List<User> returnedUser = q.getResultList();
		if (returnedUser.size() > 0 && validatePassword(returnedUser.get(0), password))
			return returnedUser.get(0);
		return null;
	}
	
	public boolean validatePassword(User user, String password){
		return user.getPassword().equals(password);
	}

}