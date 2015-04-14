package com.Group7.test.basedata;

import static org.junit.Assert.*;

import javax.ejb.EJB;
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
import com.group7.importBaseData.BaseDataValidation;
import com.group7.service.BaseDataServiceEJB;
import com.group7.serviceInterface.BaseDataServiceLocal;

//import com.group7.serviceInterface.BaseDataService;

@RunWith(Arquillian.class)
public class BaseDataTest {

	@Deployment
	public static JavaArchive createDeployment() {

		return ShrinkWrap
				.create(JavaArchive.class, "BaseTest.jar")
				.addClasses(BaseData.class, 
						BaseDataDAO.class,BaseDataDAOImpl.class,
						BaseDataServiceLocal.class,BaseDataServiceEJB.class,
						BaseDataValidation.class)
						.addPackage(BaseData.class.getPackage())
						.addPackage(DataBaseProducer.class.getPackage())
						.addAsResource("META-INF/persistence.xml")
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}

	@Inject
	private BaseDataDAO service;

	@Test
	public void checkBaseDataSizeTest() {

		assertFalse(service.getAllBaseData().isEmpty());	

	}

}
