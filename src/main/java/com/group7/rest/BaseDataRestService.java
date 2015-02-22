package com.group7.rest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.httpclient.URI;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

import com.group7.entities.BaseData;
import com.group7.entities.FileUploadForm;
import com.group7.importBaseData.BaseDataExcelRead;
import com.group7.serviceInterface.BaseDataService;

import jxl.read.biff.BiffException;



@Path("/baseData")
public class BaseDataRestService {

	@Inject
	private BaseDataService service;

	
	
	
	public BaseDataRestService(){
		
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Collection<BaseData> getAllbaseData() throws BiffException, IOException{
		
		
		
		return service.getAllBasedata();
	}
	
	@POST
	@Path("/import")
	public void importData() throws BiffException, IOException{
		BaseDataExcelRead bdxr=new BaseDataExcelRead("/home/bmj/Documents/Ericsson_Files/sample_dataset.xls");
		Collection<BaseData> bd=bdxr.readExcelFile();
		service.putData(bd);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void addBaseData(BaseData basedata){
		service.addBaseData(basedata);
	}
	
	@POST
	@Path("/upload")
	@Consumes("multipart/form-data")
	public void uploadFile(@MultipartForm FileUploadForm form){
		
		
		
		String filename="/home/bmj/Documents/Ericsson_Files/sample_dataset.xls";
		if(form==null)
			filename="null.txt";
		
		
		try{
			writeFile(form.getData(),filename);
		} catch (IOException e) {
			e.printStackTrace();
			
		}
		
		
		System.out.println("done");
		
		
	}
	
	private void writeFile(byte[] content, String fileName) throws IOException {
		File file=new File(fileName);
		
		if(file.exists() == false){
			file.createNewFile();
		}
		
		
		FileOutputStream fop = new FileOutputStream(file);
		fop.write(content);
		
		fop.flush();
		fop.close();
		
		
		
	}
}