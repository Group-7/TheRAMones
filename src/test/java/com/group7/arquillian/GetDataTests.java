package com.group7.arquillian;

import static org.junit.Assert.*;

import javax.inject.Inject;

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
import com.group7.importBaseData.BaseDataExcelRead;
import com.group7.importBaseData.BaseDataValidation;
import com.group7.service.BaseDataServiceEJB;
import com.group7.serviceInterface.BaseDataServiceLocal;
import com.group7.serviceInterface.EventCauseServiceLocal;
import com.group7.serviceInterface.FailureCauseServiceLocal;
import com.group7.serviceInterface.NetworkServiceLocal;
import com.group7.serviceInterface.UeServiceLocal;
import com.group7.serviceInterface.UserServiceLocal;

@RunWith(Arquillian.class)
public class GetDataTests {

	@Deployment
	public static JavaArchive createDeployment() {

		return ShrinkWrap
				.create(JavaArchive.class, "BaseTest.jar")
				.addClasses(BaseDataExcelRead.class,BaseDataValidation.class)
				.addPackage(BaseData.class.getPackage())
				.addPackage(BaseDataDAO.class.getPackage())
				.addPackage(BaseDataDAOImpl.class.getPackage())
				.addPackage(BaseDataServiceLocal.class.getPackage())
				.addPackage(BaseDataServiceEJB.class.getPackage())
				.addPackage(DataBaseProducer.class.getPackage())
				//.addPackage(BaseDataExcelRead.class.getPackage())
						.addAsResource("META-INF/persistence.xml")
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}
	
	@Inject 
	BaseDataServiceLocal base;
	
	@Inject
	EventCauseServiceLocal eventcause;
	
	@Inject
	FailureCauseServiceLocal failurecause;
	
	@Inject
	NetworkServiceLocal network;
	
	@Inject
	UeServiceLocal ue;
	
	@Inject
	UserServiceLocal users;
	
	@Test
	public void test() {
		assertNotNull(base);
		assertNotNull(eventcause);
		assertNotNull(failurecause);
		assertNotNull(network);
		assertNotNull(ue);
		assertNotNull(users);
	}

	
	@Test
	public void testAccess(){
		
		assertFalse(base.getAllBasedata().isEmpty());
		assertFalse(eventcause.getAllEventCauses().isEmpty());
		assertFalse(failurecause.getAllFailureCauses().isEmpty());
		assertFalse(network.getAllNetworkInfo().isEmpty());
		assertFalse(ue.getAllEU().isEmpty());
		
		
		
		
	}
}
