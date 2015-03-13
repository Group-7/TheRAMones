/*package com.group7.arquillian;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.group7.dao.EventCauseDAO;
import com.group7.dao.jpa.EventCauseDAOImpl;
import com.group7.entities.EventCause;
import com.group7.entities.EventCauseID;

@RunWith(Arquillian.class)
public class EventCauseEJBTest {
	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap.create(JavaArchive.class, "test2.jar")
				.addClasses(EventCauseDAOImpl.class, EventCause.class, EventCauseDAO.class,EventCauseID.class)
				.addAsResource("META-INF/persistence.xml")
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
  
  }

	//check
	@EJB
	private EventCauseDAO dao;

	@Test
	public void notNullTest(){
		assertNotNull(dao);
	}
	
	// here create simple test which check method of ejb
	@Test
	public void isEventCauseTableEmpty() throws Exception {
		//Assert.assertEquals(dao.getEU().size(),);
		//assertEquals(dao.getEU().size(), 1);
		//assertFalse(!dao.getEU().isEmpty());
		//assertTrue(dao.getAllEventCauses().isEmpty());	
		
	}
}
 */