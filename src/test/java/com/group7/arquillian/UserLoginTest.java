package com.group7.arquillian;

import static org.junit.Assert.*;

import javax.inject.Inject;

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
import com.group7.databases.ProdDB;
import com.group7.entities.User;
import com.group7.rest.UserREST;
import com.group7.service.UserServiceEJB;
import com.group7.serviceInterface.UserServiceLocal;



@RunWith(Arquillian.class)
public class UserLoginTest {

	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap
				.create(JavaArchive.class, "US7.jar")
				.addClasses(UserDAO.class,
						UserDAOImpl.class,
						DataBaseProducer.class,
						ProdDB.class,
						User.class,
						UserREST.class,
						UserServiceEJB.class,
						UserServiceLocal.class)
				.addAsResource("META-INF/persistence.xml")
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");

	}
	
	@Inject
	UserServiceLocal service;
	
	@Test
	public void test() {
		assertNotNull(service);
	}
	
	@Test
	public void testUserLogins(){
		
		assertTrue(service.showAllUsers().isEmpty());
		
		User user =new User();
		String email="johnnyB@yahoo.co.uk";
		
		String password="password";
		int type=1;
		
		service.addUser(email, password, type);
		assertFalse(service.showAllUsers().isEmpty());
		assertEquals(1,service.showAllUsers().size());
		
		
		assertNotNull(service.getUserByEmail(email, password));
		assertNull(service.getUserByEmail("ggg", "eee"));
		
	}

}
