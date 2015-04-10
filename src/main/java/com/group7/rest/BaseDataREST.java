package com.group7.rest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Collection;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import jxl.read.biff.BiffException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.apache.commons.httpclient.URI;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import com.group7.dao.BaseDataDAO;
import com.group7.entities.BaseData;
import com.group7.entities.BaseDataError;
import com.group7.entities.EventCause;
import com.group7.entities.Failure;
import com.group7.entities.FileUploadForm;
import com.group7.entities.Network;
import com.group7.entities.UE;
import com.group7.importBaseData.BaseDataExcelRead;
import com.group7.importBaseData.BaseDataValidation;
import com.group7.serviceInterface.BaseDataServiceLocal;


@Path("/baseData")
public class BaseDataREST {

	@Inject
	private BaseDataServiceLocal service;
	
	private BaseDataValidation bvd = BaseDataValidation.getInstance();

	public BaseDataREST() {

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<BaseData> getAllbaseData() throws BiffException,
			IOException {

		return service.getAllBasedata();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/eventid_causeid")
	public Collection<Object> getAllEventIdAndCauseIdREST(@QueryParam("imsi") BigInteger Imsi)  {
		return service.getAllEventIdAndCauseId(Imsi);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/causeid_per_imsi")
	public Collection<Object> getAllCauseIdAndDescREST(@QueryParam("imsi") BigInteger Imsi)  {
		return service.getAllCauseCodeAndDescByIMSI(Imsi);
	}

	@POST
	@Path("/import")
	public void importData() throws BiffException, IOException {

		BaseDataExcelRead bdxr = new BaseDataExcelRead("C:/Users/marc/Documents/sample_dataset.xls");
		Collection<Network> networkData = bdxr.readNetworkTable();
		Collection<UE> ueData = bdxr.readUETable();
		Collection<EventCause> eventCauseData = bdxr.readEventCauseTable();
		Collection<Failure> failureData = bdxr.readFailureClassTable();
		
		
		//Filling the cache
		bvd.setEventCauses(eventCauseData);
		bvd.setFailures(failureData);
		bvd.setNetworks(networkData);
		bvd.setUeObjects(ueData);

		Collection<BaseData> bd = bdxr.readExcelFile(service.getLastRowId());
		Collection<BaseDataError> bderrors = bdxr.getBaseDataErrorList();
		//Filling the Database
		service.putNetworkData(networkData);
		service.putUEData(ueData);
		service.putEventCauseData(eventCauseData);
		service.putFailureData(failureData);
		service.putData(bd);
		service.putErrorData(bderrors);
		
		//Should I make these Collection null now??
		networkData = null;
		ueData = null;
		eventCauseData = null;
		failureData = null;
		bd = null;
		bderrors = null;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addBaseData(BaseData basedata) {
		service.addBaseData(basedata);
	}

	@POST
	@Path("/upload")
	@Consumes("multipart/form-data")
	public void uploadFile(@MultipartForm FileUploadForm form) {
		//Downloads/Group Project - Dataset 3A.xls";
		String filename = "C:/Users/marc/Documents/sample_dataset.xls";
		if (form == null)
			filename = "null.txt";

		try {
			writeFile(form.getData(), filename);
		} catch (IOException e) {
			e.printStackTrace();

		}

		System.out.println("done");

	}

	private void writeFile(byte[] content, String fileName) throws IOException {
		File file = new File(fileName);

		if (file.exists() == false) {
			file.createNewFile();
		}

		FileOutputStream fop = new FileOutputStream(file);
		fop.write(content);

		fop.flush();
		fop.close();

	}
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/uniqueIMSI")
	public Collection<BigInteger> getUniqueAffectedImsi() throws IOException {
		return service.getUniqueAffectedImsi();
	}

	@GET
	@Path("/imsi")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<BigInteger> getImsiFailureOverTime(@QueryParam("dates") String dates){
		
		String[] splitDates=dates.split(",",-1);
		
		return service.getImsiFailureOverTime(splitDates[0],splitDates[1]);
	}
	
	@GET
	@Path("/us11")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<BigInteger> getUS11(@QueryParam("dates") String dates){
		
		String[] splitDates=dates.split(",",-1);
		
		return service.getUS11(splitDates[0],splitDates[1]);
	}

	
	/**
	 * Returns for a given model of phone, 
	 * the number of call failures it has had during a given time period.
	 * @param tacCode
	 * @param startDate
	 * @param endDate
	 */
	@GET
	@Path("/tacFailures")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Long> getTotalFailuresOfSpecificPhone(
			@QueryParam("TAC") int tacCode,
			//@QueryParam("dates") String dates){
			@QueryParam("startDate") String startDate,
			@QueryParam("endDate") String endDate){
		
		return service.getTotalFailuresOfSpecificPhone(tacCode, startDate, endDate);
	
	}
	
	
	/**
	 * Returns for a given IMSI, the number of failures they have had during a given time period.
	 * @param imsi
	 * @param startDate
	 * @param endDate
	 */
	@GET
	@Path("/imsiFailures")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Long> getTotalFailuresOfSpecificIMSI(
			@QueryParam("imsi") BigInteger imsi
			,@QueryParam("startDate") String startDate
			,@QueryParam("endDate") String endDate){
		return service.getTotalFailuresOfSpecificIMSI(imsi, startDate, endDate);
	
	}
	
	
	/** 
	 * Returns for each IMSI, the number of call failures and their total duration 
	 * during a given time period
	 * @param imsi
	 * @param startDate
	 * @param endDate
	 */
	@GET
	@Path("/imsiTotalDuration")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Object> getTotalDurationOfSpecificIMSI(
			@QueryParam("imsi") BigInteger imsi
			,@QueryParam("startDate") String startDate
			,@QueryParam("endDate") String endDate){
		return service.getAllCallFailuresAndTotalDurationPerIMSI(imsi, startDate, endDate);
	}
	
	
	@GET
	@Path("/modelFailure")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<Object> getAllUniqueEventCausecodeCombinations(
			@QueryParam("model") String model){
		return service.getAllUniqueEventCausecodeCombinations(model);
	}
	
	@GET
	@Path("/uniqueTAC")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<BigInteger> getAllPhoneTypes(){
		return service.getAllPhoneTypes();
	}
	
	/**
	 * returns all unique model numbers.
	 * Used to populate the drop-down menus.
	 */
	@GET
	@Path("/uniqueModels")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<String> getAllDistictPhoneModels(){
		return service.getAllDistinctPhoneModels();
	}
	
	@GET
	@Path("/toptenimsi")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<BaseData> getTopTenImsiDuringPeriod(@QueryParam("startDate") String startDate, @QueryParam("endDate")String endDate){
		return service.getTopTenImsiDuringPeriod(startDate, endDate);
	}
	
	@GET
	@Path("/imsifailureclass")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<BaseData> imsiEffectedByAFailureCauseClass(@QueryParam("failure")String failureClass){
		return service.imsiEffectedByAFailureCauseClass(failureClass);
	}

	@GET
	@Path("/failuredropdown")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<String> getFailureDescriptionForDropDown(){
		return service.getFailureDescriptionForDropDown();
		
	}
	
}
