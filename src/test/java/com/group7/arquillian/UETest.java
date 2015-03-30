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

import com.group7.dao.EventCauseDAO;
import com.group7.dao.UeDAO;
import com.group7.dao.jpa.EventCauseDAOImpl;
import com.group7.dao.jpa.UeDAOImpl;
import com.group7.entities.EventCause;
import com.group7.entities.EventCauseID;
import com.group7.entities.UE;
import com.group7.rest.EventCauseREST;
import com.group7.rest.UeREST;
import com.group7.service.EventCauseServiceEJB;
import com.group7.service.UeServiceEJB;
import com.group7.serviceInterface.EventCauseServiceLocal;
import com.group7.serviceInterface.UeServiceLocal;


@RunWith(Arquillian.class)
public class UETest {
		
		@Deployment
		public static JavaArchive createDeployment() {
			return ShrinkWrap.create(JavaArchive.class, "UETest.jar")
					.addClasses(UeREST.class, UeServiceEJB.class, UeServiceLocal.class, UeDAOImpl.class, UE.class, UeDAO.class)
					.addAsResource("META-INF/persistence.xml")
					.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	  
	  }

		
		@EJB
		private UeDAO dao;
		
		@EJB
		private UeServiceLocal local;
		
		

		@Test
		public void isUETableEmpty() throws Exception {
			
			assertFalse(dao.getEU().isEmpty());	
			assertFalse(local.getAllEU().isEmpty());	
		}
}
