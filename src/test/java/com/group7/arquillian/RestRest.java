package com.group7.arquillian;

import static org.junit.Assert.*;

import java.math.BigInteger;

import java.util.List;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientRequestFactory;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.util.GenericType;

import javax.ws.rs.core.UriBuilder;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.group7.dao.BaseDataDAO;
import com.group7.dao.jpa.BaseDataDAOImpl;
import com.group7.databases.DataBaseProducer;
import com.group7.entities.BaseData;
import com.group7.entities.BaseDataId;
import com.group7.importBaseData.BaseDataValidation;
import com.group7.rest.BaseDataREST;
import com.group7.service.BaseDataServiceEJB;
import com.group7.serviceInterface.BaseDataServiceLocal;


@RunWith(Arquillian.class)
public class RestRest {

	
	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap
				.create(JavaArchive.class, "rest.jar")
				.addClasses(BaseData.class,
						BaseDataId.class, 
						BaseDataDAO.class,
						BaseDataDAOImpl.class,
						BaseDataValidation.class,
						BaseDataREST.class,
						BaseDataServiceEJB.class,
						BaseDataServiceLocal.class,
						RestRest.class)
						.addPackage(BaseData.class.getPackage())
						.addPackage(DataBaseProducer.class.getPackage())
				.addAsResource("META-INF/persistence.xml")
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");

	}
	
	
	//@ArquillianResource
	//private URL webappurl;
	
	@Test
	public void test() throws Exception {
		
		
		ClientRequest cliRec=new ClientRequest("http://localhost:8080"
				+ "/TeamProject-0.0.1-SNAPSHOT/rest/baseData/uniqueIMSI");
		int status=cliRec.get().getStatus();
		assertEquals(200,status);
		
		ClientRequestFactory crf =new ClientRequestFactory(
				UriBuilder.fromUri("http://localhost:8080"
						+ "/TeamProject-0.0.1-SNAPSHOT/rest/baseData/uniqueIMSI").build());
		
		//ClientRequest req=crf.createRelativeRequest("/rest/baseData/uniqueIMSI");
		
		ClientRequest req=new ClientRequest("http://localhost:8080"
				+ "/TeamProject-0.0.1-SNAPSHOT/rest/baseData/uniqueIMSI");
		

		ClientResponse<List<BigInteger>> res=
				req.get(new GenericType<List<BigInteger>>(){});
				
		List<BigInteger> imsis=res.getEntity();
		
		assertEquals(imsis.size(),12275);
		//res.close();
		
		
		
		//get
			/*Client client=ClientBuilder.newClient();
			WebTarget target = client.target("http://localhost:8080");
			
			Response response=target.request().get();
			String value=response.readEntity(String.class);
			System.out.println(value);
			assertEquals(2,2);*/
			//final WebClient webClient =WebClient.create("http://localhost:8080/");
			//final Response response=webClient.path("/rest/baseData/uniqueIMSI").get();
			
			//assertEquals(200,response.getStatus());
		
		
		/*java.net.URI uri = UriBuilder.fromUri("http://localhost").port(8080).build();
		
		HttpServer server=HttpServer.create(new InetSocketAddress(uri.getPort()),0);
		HttpHandler handler = RuntimeDelegate.getInstance().createEndpoint(new Application(),  HttpHandler.class);
	
		server.createContext(uri.getPath(),handler);
		server.start();
		
		Client client = ClientBuilder.newClient();
		
		assertEquals(200,client.target("http://localhost:8080/TeamProject-0.0.1-SNAPSHOT/rest/baseData/uniqueIMSI").request().get().getStatus());
		*/
	}

}
