package com.group7.arquillian;

import static org.junit.Assert.*;

import java.util.List;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.group7.dao.UserDAO;
import com.group7.dao.jpa.UserDAOImpl;
import com.group7.databases.DataBaseProducer;
import com.group7.entities.User;
import com.group7.rest.UeREST;
import com.group7.service.UserServiceEJB;
import com.group7.serviceInterface.UserServiceLocal;

@RunWith(Arquillian.class)
public class UserServiceEJBTest {

	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap.create(JavaArchive.class, "test.jar")
				.addClasses(User.class, UserDAO.class, UserDAOImpl.class,
						UeREST.class,UserServiceLocal.class,UserServiceEJB.class)
				.addPackage(DataBaseProducer.class.getPackage())
				.addAsResource("META-INF/persistence.xml")
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
				

  }

	@Inject
	private UserServiceLocal dao;

	@Test
	public void notNullTest(){
		assertNotNull(dao);
	}
	
	//this test will work just there is some issue with database which needs to be fixed win the final update
	@Test
	public void isUserServiceTableEmpty() throws Exception {
		
		assertFalse(dao.showAllUsers().isEmpty());	
	}
	
	public void isCorrectUserLoggedIn() throws Exception {
		
		
		
	
	}

	//Assert.assertEquals(dao.getEU().size(),);
			//assertEquals(dao.getEU().size(), 1);
			//assertFalse(!dao.getEU().isEmpty());
			//assertFalse(dao.getEU().isEmpty());	
	
	/*public User isSearchUserByEmailCorrect(String email,String password) {
		
		EntityManager em;
		System.out.println("Validating user "+email);
		Query q = em.createQuery("from User u where u.email = :email");
		q.setParameter("email", email);
		List<User> returnedUser = q.getResultList();
		if (returnedUser.size() > 0 && validatePassword(returnedUser.get(0), password))
			return returnedUser.get(0);
		return null;
	}*/
}
	
	
	
	
	
	
	
	
	
	
	
	
	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//	
//
//

