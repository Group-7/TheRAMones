/*package com.group7.arquillian;

import static org.junit.Assert.assertFalse;

import java.math.BigInteger;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.group7.dao.BaseDataDAO;
import com.group7.dao.EventCauseDAO;
import com.group7.dao.jpa.EventCauseDAOImpl;
import com.group7.entities.EventCause;
import com.group7.entities.EventCauseID;
import com.group7.rest.EventCauseREST;
import com.group7.service.EventCauseServiceEJB;
import com.group7.serviceInterface.EventCauseServiceLocal;

@RunWith(Arquillian.class)
public class EventCauseEJBTest {
	
	
	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap.create(JavaArchive.class, "EventCause.jar")
				.addClasses(EventCauseREST.class, EventCauseServiceEJB.class, EventCauseServiceLocal.class, EventCauseDAOImpl.class, EventCause.class, EventCauseDAO.class,EventCauseID.class)
				.addAsResource("META-INF/persistence.xml")
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
  
  }

	
	@EJB
	private EventCauseDAO dao;
	
	@EJB
	private EventCauseServiceLocal local;
	
	
	

	@Test
	public void isEventCauseTableEmptyDAO() throws Exception {
		
		assertFalse(dao.getAllEventCauses().isEmpty());	
		
	}
	@Test
	public void isEventCauseTableEmptyLOCAL() throws Exception {

		assertFalse(local.getAllEventCauses().isEmpty());	
		
	}
	

	
}
 */