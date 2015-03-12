/*package com.group7.arquillian;

import static org.junit.Assert.*;

import javax.ejb.EJB;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.group7.dao.NetworkDAO;
import com.group7.dao.jpa.NetworkDAOImpl;
import com.group7.entities.Network;
import com.group7.entities.NetworkId;
import com.group7.rest.NetworkREST;
import com.group7.service.NetworkServiceEJB;
import com.group7.serviceInterface.NetworkServiceLocal;

@RunWith(Arquillian.class)
public class NetworkTest {
	

	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap.create(JavaArchive.class, "NetworkTest.jar")
				.addClasses(NetworkId.class, NetworkREST.class, NetworkServiceEJB.class, NetworkServiceLocal.class, 
						NetworkDAOImpl.class, Network.class, NetworkDAO.class)
				.addAsResource("META-INF/persistence.xml")
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
			}

	
	@EJB
	private NetworkDAO dao;
	
	@EJB
	private NetworkServiceLocal local;
	

	@Test
	public void isNetworkTableEmpty() throws Exception {
		
		assertFalse(dao.getAllNetworkInfo().isEmpty());	
		assertFalse(local.getAllNetworkInfo().isEmpty());	
	}
}
*/