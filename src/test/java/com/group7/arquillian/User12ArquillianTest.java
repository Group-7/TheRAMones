package com.group7.arquillian;

import static org.junit.Assert.*;

import java.util.Collection;

import javax.ejb.EJB;
import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.group7.entities.BaseData;
import com.group7.serviceInterface.BaseDataServiceLocal;

@RunWith(Arquillian.class)
public class User12ArquillianTest {
	
	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap.create(JavaArchive.class, "test2.jar")

				.addPackages(true,"com.group7")
				.addAsResource("META-INF/persistence.xml")
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
  
  }
	
	@EJB
	BaseDataServiceLocal serv;

	@Test
	public void test() {
		Collection<BaseData> result=serv.getTopTenImsiDuringPeriod("01/01/2013 00:00:00", "01/01/2015 00:00:00");
		assertTrue(result.size()<=10);
		assertTrue(result.size()>=0);
	}

}
