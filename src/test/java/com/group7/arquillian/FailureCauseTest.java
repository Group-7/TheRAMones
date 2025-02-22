package com.group7.arquillian;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Collection;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.group7.entities.EventCause;
import com.group7.entities.Failure;
import com.group7.serviceInterface.EventCauseServiceLocal;
import com.group7.serviceInterface.FailureCauseServiceLocal;

@RunWith(Arquillian.class)
public class FailureCauseTest {

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
	private FailureCauseServiceLocal local;
	
	
	@Test
	public void FailureCauseTest(){
		Collection<Failure> data = local.getAllFailureCauses();
		assertEquals(data.size(),0);
	}
		

}
