/*package com.group7.arquillian;

import static org.junit.Assert.*;

import java.math.BigInteger;

import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import junit.framework.Assert;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.group7.dao.BaseDataDAO;
import com.group7.dao.jpa.JPABaseDataDAOImpl;
import com.group7.entities.BaseData;
import com.group7.entities.BaseDataId;
import com.group7.entities.EventCause;
import com.group7.entities.EventCauseID;
import com.group7.entities.Failure;
import com.group7.entities.Network;
import com.group7.entities.NetworkId;
import com.group7.entities.UE;
import com.group7.importBaseData.BaseDataValidation;

@RunWith(Arquillian.class)
public class CallFailuresPerPhoneTypeTest {
	
	public String startDate;
	public String endDate;
	public BigInteger IMSIDummy;
	



	
	@Before public void initialize() {
		 IMSIDummy = new BigInteger("344930000000011");
		 startDate =  "11/01/0013 17:09:00";
		 endDate = "11/01/0013 17:17:00";
	    }
	
	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap.create(JavaArchive.class, "BaseTest.jar")
		.addClasses(BaseData.class, BaseDataId.class,BaseDataDAO.class,JPABaseDataDAOImpl.class,
				Network.class,Failure.class,EventCause.class,
				EventCauseID.class, NetworkId.class,UE.class,BaseDataValidation.class)
		.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml")
		.addAsResource("META-INF/persistence.xml");
  
  }

	
	
	@EJB
	public BaseDataDAO bdDao;

	
	@Test
	public void isBaseDataEmpty() throws Exception {
		BigInteger phoneTypeDummy = new BigInteger("33000153");
		String startDate =  "11/01/0013 17:09:00";
		String endDate = "11/01/0013 17:17:00";
		//Assert.assertEquals(dao.getEU().size(),);
		//assertEquals(dao.getEU().size(), 1);
		//assertFalse(!dao.getEU().isEmpty());
		assertFalse(bdDao.getTotalFailuresOfSpecificPhone(phoneTypeDummy, startDate, endDate).isEmpty());	
		
	}
	
	@Test
	public void isBaseDataEmptyIMSI() {
		
		assertFalse(bdDao.getTotalFailuresOfSpecificIMSI(IMSIDummy, startDate, endDate).isEmpty());		
	}
	

}
*/