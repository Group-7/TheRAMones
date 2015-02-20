package arquilianTests;



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
import com.group7.daoInterface.EventCauseDAOInterface;
import com.group7.entities.EventCause;
import com.group7.rest.EventCauseREST;
import com.group7.service.EventCauseService;
import com.group7.serviceInterface.EventCauseServiceInterface;

@RunWith(Arquillian.class)
public class EventCauseTest {

	@EJB
	private EventCauseDAOInterface eventCause;
	
	@EJB
	private EventCauseServiceInterface evsi;
	
	@EJB
	private EventCauseREST ecr;
	
	
	@Test
	public void testEJBEventCauseReturn() {	
		assertTrue(!eventCause.getAllEventCauses().isEmpty());
		
	}
	
	@Deployment
	public static JavaArchive createDeployment() {
	return ShrinkWrap.create(JavaArchive.class, "test.jar")
	.addClasses( EventCause.class,EventCauseDAO.class, EventCauseDAOInterface.class, EventCauseServiceInterface.class, EventCauseService.class, EventCauseREST.class)
	.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}

}
