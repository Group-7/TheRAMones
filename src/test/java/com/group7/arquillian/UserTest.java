package com.group7.arquillian;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Collection;
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
import com.group7.entities.UE;
import com.group7.entities.User;
import com.group7.serviceInterface.UeServiceLocal;
import com.group7.serviceInterface.UserServiceLocal;

@RunWith(Arquillian.class)
public class UserTest {

	@Deployment
	public static WebArchive createDeployment() {
        WebArchive archive = ShrinkWrap
                .create(WebArchive.class, "test.war")
                .addClasses(EventCauseEJBTest.class)
                .addPackages(true, "com.group7")
                        .addAsResource("META-INF/persistence.xml")
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
	private UserServiceLocal local;
	
	
	@Test
	public void showAllUsersTest(){
		Collection<User> data = local.showAllUsers();
		assertEquals(data.size(),1);
	}
	
	@Test
	public void searchUserByEmail(){
		User data = local.getUserByEmail("a@b.c", "12345", 1);
		assertEquals(data.getEmail(), "a@b.c");
	}
	
	@Test
	public void addUserTest(){
		User user =  new User("marc@marc.com", "12345", 2);		
	}
}
