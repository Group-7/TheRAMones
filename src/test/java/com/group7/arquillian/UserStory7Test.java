package com.group7.arquillian;

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
import com.group7.dao.jpa.BaseDataDAOImpl;
import com.group7.entities.BaseData;
import com.group7.entities.BaseDataId;
import com.group7.rest.BaseDataREST;
import com.group7.service.BaseDataServiceEJB;
import com.group7.serviceInterface.BaseDataServiceLocal;

@RunWith(Arquillian.class)
public class UserStory7Test {

	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap
				.create(JavaArchive.class, "US7.jar")
				.addClasses(BaseData.class,
						BaseDataId.class, 
						BaseDataDAO.class,
						BaseDataDAOImpl.class,
						BaseDataREST.class,
						BaseDataServiceEJB.class,
						BaseDataServiceLocal.class)
				.addAsResource("META-INF/persistence.xml")
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");

	}

	@EJB
	private BaseDataREST service;

	@Test
	public void isNetworkTableEmpty() throws Exception {
		//assertEquals(0,service.getImsiFailureOverTime("01/01/0015 12:34","56,04/03/0015 09:20:45").size());
		assertEquals(0,service.getImsiFailureOverTime("01/01/0015 12:34,56,04/03/0015 09:20:45").size());

	}
}
