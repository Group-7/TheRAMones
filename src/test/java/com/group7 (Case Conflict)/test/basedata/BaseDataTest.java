/*package com.Group7.test.basedata;

import static org.junit.Assert.*;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.group7.dao.BaseDataDAO;
import com.group7.dao.BaseDataDAO;
import com.group7.dao.jpa.BaseDataDAOImpl;
import com.group7.databases.DataBaseProducer;
import com.group7.entities.BaseData;
import com.group7.entities.BaseDataId;
import com.group7.importBaseData.BaseDataValidation;

//import com.group7.serviceInterface.BaseDataService;

@RunWith(Arquillian.class)
public class BaseDataTest {

	@Deployment
	public static JavaArchive createDeployment() {

		return ShrinkWrap

				.create(JavaArchive.class, "BaseTest.jar")
				.addClasses(BaseData.class, BaseDataId.class,
						BaseDataDAO.class, BaseDataDAOImpl.class)
				.addPackage(BaseDataValidation.class.getPackage())
				.addPackage(BaseData.class.getPackage())
				.addPackage(DataBaseProducer.class.getPackage())
				.addAsResource("META-INF/persistence.xml")
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}

	@EJB
	private BaseDataDAO service;

	@Test
	public void checkBaseDataSizeTest() {

		assertFalse(service.getAllBaseData().isEmpty());

	}

}
*/