package com.group7.arquillian;

import static org.junit.Assert.*;

import java.io.File;
import java.math.BigInteger;
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

import com.group7.serviceInterface.BaseDataServiceLocal;

@RunWith(Arquillian.class)
public class GetTotalFailuresOfSpecificIMSITest {

	@Deployment
    public static WebArchive createDeployment() {
        WebArchive archive = ShrinkWrap
                .create(WebArchive.class, "test.war")
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
	private BaseDataServiceLocal service;
	
	@Test
	public void getTotalFailuresOfSpecificIMSI() {
	
	Collection<Long> data = service.getTotalFailuresOfSpecificIMSI(new BigInteger("240210000000013"), "01/01/0012 12:40:20", "12/12/0015 12:40:20");
	assertEquals(data.size(),1);
	
	}

}
