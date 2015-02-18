package com.group7.importBaseData;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import com.group7.entities.BaseData;

public class BaseDataExcelRead {

	private String fileName;
	
	public BaseDataExcelRead(String fileName) {
		this.fileName=fileName;
	}
	
	public Collection<BaseData> readExcelFile() throws BiffException, IOException{
		
		File inputFile= new File(fileName);
		
		Workbook workbook;
		workbook=Workbook.getWorkbook(inputFile);
		Sheet errorData=workbook.getSheet(0);
		Collection<BaseData> base =new ArrayList<BaseData>();
		
		
		for(int i=1;i<errorData.getRows();i++){
			
			String date=errorData.getCell(0,i).getContents();
			String[] dayTime=date.split(" ",-1);
			String[] dates=dayTime[0].split("/",-1);
			String[] time=dayTime[1].split(":",-1);
			
			Calendar c= Calendar.getInstance();
			c.set(Integer.parseInt(dates[2]),
					Integer.parseInt(dates[1]),
					Integer.parseInt(dates[0]));
			
			c.set(Calendar.HOUR_OF_DAY, Integer.parseInt(time[0]));
			c.set(Calendar.MINUTE, Integer.parseInt(time[1]));
			
			java.util.Date edate=c.getTime();
			
			Timestamp errorTime=new Timestamp(edate.getTime());
			boolean ok=true;
			for(int j=0;j<errorData.getColumns();j++){
				if(errorData.getCell(j,i).equals("(null)")){
					ok=false;
				}
			}
			
			if(ok){
			BaseData error=new BaseData();
			error.setDateAndTime(errorTime);
			
			error.setEventId(parseInteger(errorData.getCell(1, i).getContents()));
			error.setFailureClass(parseInteger(errorData.getCell(2, i).getContents()));
			error.setTac(parseInteger(errorData.getCell(3, i).getContents()));
			error.setMcc(parseInteger(errorData.getCell(4, i).getContents()));
			error.setMnc(parseInteger(errorData.getCell(5, i).getContents()));
			error.setDuration(parseInteger(errorData.getCell(7, i).getContents()));
			error.setCellid(parseInteger(errorData.getCell(6,i).getContents()));
			error.setCauseCode(parseInteger(errorData.getCell(8, i).getContents()));
			error.setNeVersion(parseString(errorData.getCell(9,i).getContents()));
			error.setImsi(Long.parseLong(errorData.getCell(10, i).getContents()));
			error.setHeir3ID(parseString(errorData.getCell(11, i).getContents()));
			error.setHeir32ID(parseString(errorData.getCell(12, i).getContents()));
			error.setHeir321ID(parseString(errorData.getCell(13, i).getContents()));
				if(error.getCauseCode()!=null){
					base.add(error);
				}
			}
		}
	return base;

}
	
	public static boolean isNullString(String cell){
		return cell.equals("(null)");
		
	}
	
	public static String parseString(String cell){
		if(isNullString(cell))
			return null;
		else
			return cell;
	}
	
	public static Integer parseInteger(String cell){
		if(isNullString(cell))
			return null;
		else
			return Integer.parseInt(cell);
		
	}
}
	
