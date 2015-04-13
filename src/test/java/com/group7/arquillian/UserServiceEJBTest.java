/*package com.group7.arquillian;

import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.group7.dao.UserDAO;
import com.group7.dao.jpa.UserDAOImpl;
import com.group7.databases.DataBaseProducer;
import com.group7.entities.User;

@RunWith(Arquillian.class)
public class UserServiceEJBTest {

	@Deployment
	public static WebArchive createDeployment() {
		WebArchive archive = ShrinkWrap
                .create(WebArchive.class, "test.war")
                .addPackages(true, "com.group7")
                        .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                        .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");

       File[] libs;

        libs = Maven.resolver()
                .resolve("com.jayway.restassured:rest-assured:2.4.0")
                .withTransitivity().as(File.class);
        archive.addAsLibraries(libs);

        libs = Maven.resolver().resolve("org.apache.poi:poi:3.11")
                .withTransitivity().as(File.class);
        archive.addAsLibraries(libs);
        
        return archive;
	}

	@EJB
	private UserDAO dao;

	@Test
	public void notNullTest(){
		assertNotNull(dao);
	}
	
	//this test will work just there is some issue with database which needs to be fixed win the final update
	@Test
	public void isUserServiceTableEmpty() throws Exception {
		
		assertTrue(dao.showAllUsers().isEmpty());	
	}
	
	public void isCorrectUserLoggedIn() throws Exception {
		
		
		
	}
	
	//Assert.assertEquals(dao.getEU().size(),);
			//assertEquals(dao.getEU().size(), 1);
			//assertFalse(!dao.getEU().isEmpty());
			//assertFalse(dao.getEU().isEmpty());	
	
	public User isSearchUserByEmailCorrect(String email,String password) {
		
		EntityManager em = null;
		System.out.println("Validating user "+email);
		Query q = em.createQuery("from User u where u.email = :email");
		q.setParameter("email", email);
		List<User> returnedUser = q.getResultList();
		if (returnedUser.size() > 0 && validatePassword(returnedUser.get(0), password))
			return returnedUser.get(0);
		return null;
	}
}
*/