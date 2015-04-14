package com.group7.validation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.Collection;

import jxl.read.biff.BiffException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.group7.entities.BaseData;
import com.group7.entities.BaseDataError;
import com.group7.entities.EventCause;
import com.group7.entities.Failure;
import com.group7.entities.Network;
import com.group7.entities.UE;
import com.group7.importBaseData.BaseDataExcelRead;
import com.group7.importBaseData.BaseDataValidation;

public class ExcelReadTest {

	BaseDataExcelRead bdxr=new BaseDataExcelRead(""
			+ "src/main/resources/DIT Group Project - Sample Dataset.xls");
	BaseDataValidation bvd = BaseDataValidation.getInstance();
	
	
	
	@Test
	public void test() throws BiffException, IOException {
		
		
		
		
		Collection<Network> networkData = bdxr.readNetworkTable();
		Collection<UE> ueData = bdxr.readUETable();
		Collection<EventCause> eventCauseData = bdxr.readEventCauseTable();
		Collection<Failure> failureData = bdxr.readFailureClassTable();

		bvd.setEventCauses(eventCauseData);
		bvd.setFailures(failureData);
		bvd.setNetworks(networkData);
		bvd.setUeObjects(ueData);
		

		Collection<BaseData> bd = bdxr.readExcelFile(0);
		Collection<BaseDataError> bderrors = bdxr.getBaseDataErrorList();
		
		assertEquals(800,bd.size());
		assertEquals(200,bderrors.size());
		
		networkData = null;
		ueData = null;
		eventCauseData = null;
		failureData = null;
		bd = null;
		bderrors = null;
		
		bdxr = new BaseDataExcelRead(
				"src/main/resources/Group Project - Dataset 3B.xls");
		
		networkData = bdxr.readNetworkTable();
		ueData = bdxr.readUETable();
		eventCauseData = bdxr.readEventCauseTable();
		failureData = bdxr.readFailureClassTable();

		bvd.setEventCauses(eventCauseData);
		bvd.setFailures(failureData);
		bvd.setNetworks(networkData);
		bvd.setUeObjects(ueData);
		
		bd = bdxr.readExcelFile(0);
		bderrors = bdxr.getBaseDataErrorList();
		
		
		assertEquals(29995,bd.size());
		assertEquals(3,bderrors.size());
		
		networkData = null;
		ueData = null;
		eventCauseData = null;
		failureData = null;@Test
		public void putNetworkDataTest(){
			
			service.putNetworkData(new ArrayList<Network>());
		}@Test
		public void putNetworkDataTest(){
			
			service.putNetworkData(new ArrayList<Network>());
		}@Test
		public void putNetworkDataTest(){
			
			service.putNetworkData(new ArrayList<Network>());
		}
		bd = null;
		bderrors = null;
		
		bdxr = new BaseDataExcelRead(
				"src/main/resources/ErrorDataSheet.xls");
		
		networkData = bdxr.readNetworkTable();
		ueData = bdxr.readUETable();
		eventCauseData = bdxr.readEventCauseTable();
		failureData = bdxr.readFailureClassTable();

		bvd.setEventCauses(eventCauseData);
		bvd.setFailures(failureData);
		bvd.setNetworks(networkData);
		bvd.setUeObjects(ueData);
		
		bd = bdxr.readExcelFile(0);
		bderrors = bdxr.getBaseDataErrorList();
		
		
		assertEquals(1,bd.size());
		assertEquals(0,bderrors.size());
		networkData = null;
		ueData = null;
		eventCauseData = null;
		failureData = null;
		bd = null;
		bderrors = null;
		
		
		
		
		
	}
	
	@Rule
	public ExpectedException exception=ExpectedException.none();
	
	@Test
	public void biffTest(){
		
		bdxr = new BaseDataExcelRead(
				"src/main/resources/nullSheet.xls");
		
		//exception.expect(BiffException.class);
		
		try{
			bdxr.readExcelFile(0);
			fail("");
		}
		catch(BiffException e){
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
		}
		
	}


}
