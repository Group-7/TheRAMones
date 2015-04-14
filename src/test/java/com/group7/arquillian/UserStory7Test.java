/*package com.group7.arquillian;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.extension.rest.client.ArquillianResteasyResource;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.group7.dao.BaseDataDAO;
import com.group7.entities.BaseData;
import com.group7.rest.BaseDataREST;
import com.group7.serviceInterface.BaseDataServiceLocal;

@RunWith(Arquillian.class)
public class UserStory7Test {

	@Deployment
    public static WebArchive createDeployment() {
        WebArchive archive = ShrinkWrap
                .create(WebArchive.class, "test.war")
                //.addClasses(BaseDataRESTtests.class)
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

	//@EJB
	//private BaseDataDAO service;
	
	@EJB
	private BaseDataServiceLocal service;

	@Test
	public void notNullTest(){
		assertNotNull(service);
	}
	
	@Test
	public void testUnique(){
		
	//	ArrayList<BigInteger> imsis=(ArrayList<BigInteger>)service.getImsiFailureOverTime("01/01/0013 12:40:20", "12/12/0015 12:40:20");
	
	
		
		for(int i=0;i<imsis.size();i++){
			
			for(int j=i+1;j<imsis.size();j++){
				assertNotSame(imsis.get(i),imsis.get(j));
			}
			System.out.println("\n\n\n\n"+i);}
		
		
	}
	
	@Test
	public void getAllCauseIdAndDescRESTTest(@ArquillianResteasyResource BaseDataREST brt) throws IOException {
		
		List<Object> bdl = (List<Object>) brt.getAllEventIdAndCauseIdREST(new BigInteger("240210000000013"));
		ArrayList<BigInteger> imsis=(ArrayList<BigInteger>)brt.getImsiFailureOverTime("01/01/0013 12:40:20,12/12/0015 12:40:20");

	}
	
	@Test
	public void getImsiFailureOverTime() {
	
		Collection<BigInteger> imsis=service.getImsiFailureOverTime("01/01/0012 12:40:20", "12/12/0015 12:40:20");
		assertEquals(imsis.size(),0);
		
		imsis=service.getImsiFailureOverTime("0014/01/01 12:40:20", "0014/12/12 12:40:20");
		assertEquals(imsis.size(),0);
	}
	

	
}
*/