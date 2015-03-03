package com.group7.rest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collection;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import jxl.read.biff.BiffException;

import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import com.group7.dao.BaseDataDAO;
import com.group7.entities.BaseData;
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
	/*@Inject
	private BaseDataExcelRead bdxr;*/
	/*@EJB
	BaseDataDAO dao;*/
	private BaseDataValidation bvd = BaseDataValidation.getInstance();

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
		
		BaseDataExcelRead bdxr = new BaseDataExcelRead("/home/marc/Documents/sample_dataset.xls");
		Collection<Network> networkData = bdxr.readNetworkTable();
		Collection<UE> ueData = bdxr.readUETable();
		Collection<EventCause> eventCauseData = bdxr.readEventCauseTable();
		Collection<Failure> failureData = bdxr.readFailureClassTable();
		
		//Filling the cache
		bvd.setEventCauses(eventCauseData);
		bvd.setFailures(failureData);
		bvd.setNetworks(networkData);
		bvd.setUeObjects(ueData);
		Collection<BaseData> bd = bdxr.readExcelFile();
		//Filling the Datasbase
		service.putNetworkData(networkData);
		service.putUEData(ueData);
		service.putEventCauseData(eventCauseData);
		service.putFailureData(failureData);
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

		String filename = "/home/marc/Documents/sample_dataset.xls";
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
}