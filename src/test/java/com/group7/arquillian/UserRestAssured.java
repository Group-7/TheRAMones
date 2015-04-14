/*package com.group7.arquillian;
import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.group7.dao.BaseDataDAO;
import com.group7.dao.jpa.BaseDataDAOImpl;
import com.group7.databases.DataBaseProducer;
import com.group7.entities.BaseData;
import com.group7.entities.User;
import com.group7.importBaseData.BaseDataExcelRead;

@RunWith(Arquillian.class)
public class UserRestAssured { 
	
	@Deployment
	public static WebArchive createDeployment() {
		return ShrinkWrap.create(WebArchive.class, "test2.war")
				.addClasses(User.class)
				.addClasses(BaseDataDAOImpl.class)
				.addPackages(true,"com.group7.entites","com.group7.dao.jpa.UserDAOImpl")
				//.addPackage(BaseDataDAO.class.getPackage())
				.addPackage(BaseData.class.getPackage())
				.addPackage(BaseDataExcelRead.class.getPackage())
				.addPackage(DataBaseProducer.class.getPackage())
				.addAsResource("META-INF/persistence.xml")
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
  
  }
	
	@Test
	public void testUserEmails() {
		User [] users =given().when().get("http://localhost:8080/TeamProject-0.0.1-SNAPSHOT/rest/users").as(User[].class);
		assertEquals("1@mail.com",users[0].getEmail());
		assertEquals("2@mail.com",users[1].getEmail());
		assertEquals("3@mail.com",users[2].getEmail());
		assertEquals("4@mail.com",users[3].getEmail());
	}
	
}
*/