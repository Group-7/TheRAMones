package com.group7.arquillian;

import static com.jayway.restassured.RestAssured.config;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.POST;

import org.apache.commons.io.FileUtils;
import org.apache.tools.ant.taskdefs.Get;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ArchivePaths;
import org.jboss.shrinkwrap.api.Filters;
import org.jboss.shrinkwrap.api.GenericArchive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.importer.ExplodedImporter;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.group7.dao.BaseDataDAO;
import com.group7.dao.jpa.BaseDataDAOImpl;
import com.group7.entities.BaseData;
import com.group7.importBaseData.BaseDataValidation;
import com.group7.rest.BaseDataREST;
import com.group7.rest.RestTest;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.authentication.FormAuthConfig;
import com.jayway.restassured.config.LogConfig;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.internal.http.Status;
import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;



@RunWith(Arquillian.class)
public class TestRestAssured {
	
	
	
	@Deployment
    public static Archive<?> createDeployment() {
		/*@Deployment
	    public static WebArchive create() {*/
			 WebArchive archive = ShrinkWrap
			.create(WebArchive.class, "test.war")
		    .addClasses(RestTest.class)
	       // .addPackages(true, "com.group7.rest")
			.addAsResource("META-INF/persistence.xml")
			.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
            
     /*          
        File[] files = Maven.resolver()
                .resolve("com.jayway.restassured:rest-assured:2.4.0")
                .withTransitivity().as(File.class);
        archive.addAsLibraries(files);

        files = Maven.resolver().resolve("org.apache.poi:poi:3.11")
                .withTransitivity().as(File.class);
        archive.addAsLibraries(files);

        files = Maven.resolver().resolve("org.apache.commons:commons-io:1.3.2")
                .withTransitivity().as(File.class);
        archive.addAsLibraries(files);

        files = Maven.resolver()
                .resolve("commons-logging:commons-logging:1.1.3")
                .withTransitivity().as(File.class);
        archive.addAsLibraries(files);*/

        return archive;
    }
    
    @Before
    public void setUp() throws InterruptedException{
    	
	        RestAssured.config = config()
	                .logConfig(new LogConfig(System.out, true));
	        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
	        RestAssured.basePath = "http://localhost:8080/TeamProject-0.0.1-SNAPSHOT/rest/TestRest";
	        RestAssured.port = 8080;
	      
    	

    }
    
    @Test
    public void testEndPoint() {
    	
    }
	
	
	/*@Deployment
    public static WebArchive create() {
		  WebArchive archive = ShrinkWrap
	    .create(WebArchive.class, "test.war")
	    .addClasses(TestRestAssured.class, BaseDataValidation.class, BaseDataREST.class, BaseDataDAOImpl.class, BaseData.class, BaseDataDAO.class)
        .addPackages(true, "com.group7.rest", "com.group7.service", "com.group7.validation", "com.group7.importBaseData", "com.group.dao.jpa", "com.group7.databases", "com.group7.entities")
		.addAsResource("META-INF/persistenceTEST.xml")
		.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
        
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
	
	@Before
    public void setUp() throws Exception{
        RestAssured.config = config()
                .logConfig(new LogConfig(System.out, true));
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
        RestAssured.basePath = "http://localhost:8080/TeamProject-0.0.1-SNAPSHOT/rest/baseData";
        RestAssured.port = 8080;
    }
	
	@Test
    public void testEndPoint() {
		Response res = get("/test");
		  assertEquals(200, res.getStatusCode());
		  String json = res.asString();
		  JsonPath jp = new JsonPath(json);
		  assertEquals("test@hascode.com", jp.get("email"));
    }
        assertEquals(1, book.getId());
        assertEquals("Leo Tolstoy", book.getAuthor());

	}
*/
}
