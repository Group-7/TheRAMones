package com.group7.arquillian;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.Collection;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.group7.dao.EventCauseDAO;
import com.group7.dao.jpa.EventCauseDAOImpl;
import com.group7.databases.DataBaseProducer;
import com.group7.entities.EventCause;
import com.group7.entities.EventCauseID;
import com.group7.serviceInterface.EventCauseServiceLocal;

@RunWith(Arquillian.class)
public class EventCauseEJBTest {
	
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
	private EventCauseServiceLocal local;
	
	
	@Test
	public void EventCauseTest(){
		Collection<EventCause> data = local.getAllEventCauses();
		assertEquals(data.size(),0);
	}
		
	
}
 
