package com.group7.dao.jpa;

import java.util.Collection;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.group7.dao.UserDAO;
import com.group7.entities.User;

@Local
@Stateless
public class UserDAOImpl implements UserDAO {

	//@PersistenceContext
	@Inject
	private EntityManager em;

	/**
	 * A method to run all the users in the system.
	 * 
	 * @return A Collection of User objects from the DB
	 * @param None
	 */
	public Collection<User> showAllUsers() {
		Query q = em.createQuery("from User");
		return q.getResultList();
	}

	public User searchUserByEmail(String email, String password) {
		System.out.println("Validating user " + email);
		Query q = em.createQuery("from User u where u.email = :email");
		q.setParameter("email", email);
		List<User> returnedUser = q.getResultList();
		if (returnedUser.size() > 0
				&& validatePassword(returnedUser.get(0), password))
			return returnedUser.get(0);
		return null;
	}

	public User addUser(String email,String password, int type) {
		// User user1= new User(email,password,position);
//		em.getTransaction().begin();
//		Query query = em
//				.createNativeQuery("INSERT into Users (Email, Password, Usertype) "
//						+ " Values(?,?,?)");
//		query.setParameter(1, email);
//		query.setParameter(2, password);
//		query.setParameter(3, type);
//		query.executeUpdate();
//		em.getTransaction().commit();
		User u = new User(email,password,type);
		em.persist(u);
		//em.close();
		//em.flush();
		
//		Query q = em.createQuery("from User u where u.email = :email");
//		q.setParameter("email", user.getEmail());
//		List<User> returnedUser = q.getResultList();
		return u;
		
	}

	public boolean validatePassword(User user, String password) {
		return user.getPassword().equals(password);
	}

	

}