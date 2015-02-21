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
import com.group7.entities.EventCauseID;

@RunWith(Arquillian.class)
public class EventCauseTest {

	
	
	@Deployment(testable=true)
	public static JavaArchive createDeployment() {
	JavaArchive jar = ShrinkWrap.create(JavaArchive.class)
	.addClasses( EventCause.class, EventCauseID.class, EventCauseDAOInterface.class, EventCauseDAO.class)
	.addAsResource("META-INF/persistence.xml")
	.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	 System.out.println(jar.toString(true));
	    return jar;
	}

	@EJB
	private EventCauseDAOInterface eventCause;
	

	
	
	@Test
	public void testEJBEventCauseReturn() {	
		assertEquals(eventCause.testRun(), "just testing the container");
		
	}

}
