/*package com.group7.arquillian;

import static com.jayway.restassured.RestAssured.*;

import com.group7.databases.DataBaseProducer;
import com.jayway.restassured.http.ContentType;

import java.net.URI;
import java.net.URL;

import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriBuilder;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;
 
@RunWith(Arquillian.class)
public class TestRest {
 
    @ArquillianResource
    URL deploymentUrl;
 
    @Deployment
    public static WebArchive create() {
        return ShrinkWrap.create(WebArchive.class, "rest-service.war")
      //  .addClasses(BookService.class, BookDao.class, Book.class, BookRequest.class)
        .addPackages(true, "com.group7.importBaseData", "com.group.dao.jpa", "com.group7.databases", "com.group7.entities")
		.addAsResource("META-INF/persistence.xml")
		.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }
 
    @Test
    public void testGetBookByTitle() {
        given()
            .body(new BookRequest("War and peace"))
            .contentType(ContentType.JSON)
        .expect()
            .contentType(ContentType.JSON)
            .statusCode(Status.OK.getStatusCode())
        .when()
            .post(buildUri("rest", "book", "by_title"));
    }
 
    URI buildUri(String... paths) {
        UriBuilder builder = UriBuilder.fromUri(deploymentUrl.toString());
        for (String path : paths) {
            builder.path(path);
        }
        return builder.build();
    }
}



*/