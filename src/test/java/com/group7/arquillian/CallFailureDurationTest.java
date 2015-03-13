package com.group7.arquillian;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.ArrayList;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.group7.dao.BaseDataDAO;
import com.group7.dao.jpa.BaseDataDAOImpl;
import com.group7.databases.DataBaseProducer;
import com.group7.entities.BaseData;
import com.group7.entities.BaseDataId;
import com.group7.importBaseData.BaseDataExcelRead;
import com.group7.importBaseData.BaseDataValidation;
import com.group7.rest.BaseDataREST;
import com.group7.service.BaseDataServiceEJB;
import com.group7.serviceInterface.BaseDataServiceLocal;

@RunWith(Arquillian.class)
public class CallFailureDurationTest {

	
	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap
				.create(JavaArchive.class, "CallFailure.jar")
				.addClasses(BaseDataREST.class,
						BaseDataServiceEJB.class,
						BaseDataServiceLocal.class,
						BaseDataDAO.class,
						BaseDataDAOImpl.class)
						.addPackage(BaseDataExcelRead.class.getPackage())
						.addPackage(BaseData.class.getPackage())
						.addPackage(DataBaseProducer.class.getPackage())
				.addAsResource("META-INF/persistence.xml")
				.addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");

	}
	@Inject
	BaseDataServiceLocal service;
	
	
	
	@Test
	public void test() {
		
		ArrayList<BigInteger> imsis=(ArrayList<BigInteger>)service.getUniqueAffectedImsi();
		
		for(int i=0;i<imsis.size();i++){
		
			assertFalse(service.getAllCallFailuresAndTotalDurationPerIMSI(imsis.get(i), "01/01/0013 12:40:20","12/12/0015 12:40:20").isEmpty());
		}
		
		
		assertFalse(service.getAllUniqueEventCausecodeCombinations("VEA3").isEmpty());
	}

}
