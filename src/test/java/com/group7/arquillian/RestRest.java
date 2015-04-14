package com.group7.arquillian;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

import org.jboss.resteasy.client.ClientRequest;
import org.jboss.resteasy.client.ClientRequestFactory;
import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.util.GenericType;

import javax.ws.rs.core.UriBuilder;

import jxl.read.biff.BiffException;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.group7.dao.BaseDataDAO;
import com.group7.dao.jpa.BaseDataDAOImpl;
import com.group7.databases.DataBaseProducer;
import com.group7.entities.BaseData;
import com.group7.importBaseData.BaseDataExcelRead;
import com.group7.importBaseData.BaseDataValidation;
import com.group7.rest.BaseDataREST;
import com.group7.service.BaseDataServiceEJB;
import com.group7.serviceInterface.BaseDataServiceLocal;


@RunWith(Arquillian.class)
public class RestRest {

	
	@Deployment
	public static WebArchive createDeployment() {
		File[] libs=Maven.resolver().resolve("net.sourceforge.jexcelapi:jxl:2.6.10")
				.withTransitivity().as(File.class);
		
		WebArchive web= ShrinkWrap
				.create(WebArchive.class, "rest.war")
				.addClasses(BaseData.class,
						BaseDataDAO.class,
						BaseDataDAOImpl.class,
						BaseDataValidation.class,
						BaseDataREST.class,
						BaseDataServiceEJB.class,
						BaseDataServiceLocal.class,
						RestRest.class)
						//BaseDataExcelRead.class,
						//BaseDataValidation.class)
						.addPackage(BaseDataExcelRead.class.getPackage())
						.addPackage(BaseData.class.getPackage())
						.addPackage(DataBaseProducer.class.getPackage())
				.addAsResource("META-INF/persistence.xml")
				.setWebXML(new File("src/main/webapp/WEB-INF/web.xml"))
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");

		
		web.addAsLibraries(libs);
		return web;
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
		
		ClientRequest req=new ClientRequest("http://localhost:8080"
				+ "/TeamProject-0.0.1-SNAPSHOT/rest/baseData/uniqueIMSI");
		
		ClientResponse<List<BigInteger>> res=
				req.get(new GenericType<List<BigInteger>>(){});
				
		List<BigInteger> imsis=res.getEntity();
		
		assertEquals(imsis.size(),12275);
		
		
		ClientRequest IMPreq=new ClientRequest("http://localhost:8080"
				+ "/TeamProject-0.0.1-SNAPSHOT/rest/baseData/imsi?dates="
				+ "01/01/0013 00:00:00,01/01/0015 00:00:00");
		
		ClientResponse<List<BigInteger>> impRes=IMPreq.get(new GenericType<List<BigInteger>>(){});
		
		imsis=impRes.getEntity();
		assertEquals(impRes.getStatus(),200);
		
		ClientRequest us11req=new ClientRequest("http://localhost:8080"
				+ "/TeamProject-0.0.1-SNAPSHOT/rest/baseData/imsi?dates="
				+ "01/01/0013 00:00:00,01/01/0015 00:00:00");
		
		ClientResponse<List<BigInteger>> us11Res=us11req.get(new GenericType<List<BigInteger>>(){});
		
		imsis=us11Res.getEntity();
		assertEquals(us11Res.getStatus(),200);
		
		
		/*try{
		ClientRequest IMPreq=new ClientRequest("http://localhost:8080"
				+ "/TeamProject-0.0.1-SNAPSHOT/rest/baseData/import");
		
		ClientResponse impRes=IMPreq.post();
		
		
		assertEquals(impRes.getStatus(),200);
		}
		catch(IOException | BiffException e){
			
			System.out.println(e.toString());
			
		}*/
		
		
		
		
	}

}
