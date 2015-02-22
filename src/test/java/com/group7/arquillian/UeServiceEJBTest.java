package com.group7.arquillian;

import javax.ejb.EJB;
import javax.validation.constraints.AssertTrue;

import junit.framework.Assert;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import com.group7.dao.UeDaoImpl;
import com.group7.daoInterface.UeDao;
import com.group7.entities.UE;
import com.group7.serviceInterface.UeService;

@RunWith(Arquillian.class)
public class UeServiceEJBTest {

	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap.create(JavaArchive.class, "test.jar")
				.addClasses(UeDao.class, UE.class, UeDaoImpl.class)
				.addAsResource("META-INF/persistence.xml")
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");

  }

	@EJB
	private UeDao dao;

	// here create simple test which check method of ejb
	@Test
	public void isUETableEmpty() throws Exception {
		//Assert.assertEquals(dao.getEU().size(),);
		//assertEquals(dao.getEU().size(), 1);
		//assertFalse(!dao.getEU().isEmpty());
		assertFalse(dao.getEU().isEmpty());	
	}
}

