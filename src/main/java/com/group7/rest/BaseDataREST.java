package com.group7.rest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Collection;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;







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
				"/home/niall/Data.xls");
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

		String filename = "/home/niall/Data.xls";
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
	@Path("/failureDescriptions")
	public Collection<Object> getAllCauseCodeAndEventId(@QueryParam("imsi") BigInteger imsi){
		return service.getAllCasueCodeAndEventId(imsi);
	}
	
	@GET
	@Path("/imsi")
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<BigInteger> getImsiFailureOverTime(@QueryParam("dates") String dates){
		
		String[] splitDates=dates.split(",",-1);
		
		return service.getImsiFailureOverTime(splitDates[0],splitDates[1]);
	}
}