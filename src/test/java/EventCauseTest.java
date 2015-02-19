import static org.junit.Assert.*;

import java.util.Collection;

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

@RunWith(Arquillian.class)
public class EventCauseTest {

	@EJB
	private EventCauseDAOInterface eventCause;
	
	
	@Test
	public void testEJBEventCauseReturn() {	
		assertTrue(!eventCause.getAllEventCauses().isEmpty());
		
	}
	
	@Deployment
	public static JavaArchive createDeployment() {
	return ShrinkWrap.create(JavaArchive.class, "test.jar")
	.addClasses(EventCauseDAO.class, EventCauseDAOInterface.class)
	.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
	}

}
