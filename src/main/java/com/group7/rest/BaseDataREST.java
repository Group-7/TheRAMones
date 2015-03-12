package com.group7.rest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Collection;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.apache.commons.httpclient.URI;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import com.group7.entities.BaseData;
import com.group7.entities.FileUploadForm;
import com.group7.importBaseData.BaseDataExcelRead;
import com.group7.serviceInterface.BaseDataServiceLocal;

import jxl.read.biff.BiffException;

@Path("/baseData")
public class BaseDataREST {

	@Inject
	private BaseDataServiceLocal service;

	public BaseDataREST() {

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<BaseData> getAllbaseData() throws BiffException,
			IOException {

		return service.getAllBasedata();
	}

	@POST
	@Path("/import")
	public void importData() throws BiffException, IOException {
		BaseDataExcelRead bdxr = new BaseDataExcelRead(
				"/home/giovanni/Documents/sample_dataset.xls");
		Collection<BaseData> bd = bdxr.readExcelFile();
		service.putData(bd);
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
		String filename = "/home/giovanni/Documents/sample_dataset.xls";
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
			@QueryParam("TAC") BigInteger tacCode
			,@QueryParam("startDate") String startDate
			,@QueryParam("endDate") String endDate){
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
	@Path("/uniqueIMSI")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<BigInteger> getAllUniqueAffectedImsi(){
		return service.getUniqueAffectedImsi();
	}
	
	
	@GET
	@Path("/uniqueTAC")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<BigInteger> getAllPhoneTypes(){
		return service.getAllPhoneTypes();
	}
	
}