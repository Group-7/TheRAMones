/*package com.group7.arquillian;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

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
import com.group7.importBaseData.BaseDataExcelRead;
import com.group7.rest.BaseDataREST;
import com.group7.service.BaseDataServiceEJB;
import com.group7.serviceInterface.BaseDataServiceLocal;

@RunWith(Arquillian.class)
public class ImportTestCase {

	
	@Deployment
	public static JavaArchive createDeployment() {
		return ShrinkWrap
				.create(JavaArchive.class, "ImportTest.jar")
				.addClasses(BaseDataREST.class, BaseDataServiceEJB.class,
						BaseDataServiceLocal.class, BaseDataDAO.class,
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
		
		long countAtBeginning=service.getLastRowId();
		
		File file =new File("/home/niall/DIT Group Project - Sample Dataset.xls");
		File dest=new File("/home/niall/RemoteUploads/testSheet.xls");
		
		file.renameTo(dest);

		long countAtEnd=service.getLastRowId();
		
		assertTrue(countAtEnd>countAtBeginning);
		
		
	}

	




	
}
*/