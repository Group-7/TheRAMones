package com.group7.importBaseData;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javassist.bytecode.SignatureAttribute.BaseType;

import javax.persistence.PersistenceUtil;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;


import com.group7.entities.BaseData;

public class BaseDataExcelRead {

	private String fileName;
	int len = 13;
	private String stringInput;
	String[] strings = new String[len];

	DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	Date date = null;
	String convertedDate = null;
	//BaseData entity;
	ArrayList<BaseData> bsList = new ArrayList<BaseData>();
	BaseDataValidation validation = new BaseDataValidation();
	
	public BaseDataExcelRead(String fileName) {
		this.fileName=fileName;
	}
	
	public Collection<BaseData> readExcelFile() throws BiffException, IOException{
		
		//File inputFile= new File(fileName);
		
		int sIndex = 0;
		File inputWorkBook = new File(fileName);
		Workbook w;
		int count = 0;
		try {
			w = Workbook.getWorkbook(inputWorkBook);
			Sheet sheet = w.getSheet(0);
			System.out.println("Amount of Rows: " + sheet.getRows());
			for (int j = 1; j <  sheet.getRows() ; j++) {
				for (int i = 0; i < sheet.getColumns() ; i++) {
					Cell cell = sheet.getCell(i, j);
					if (i==0) {
						try{
						date = format.parse(cell.getContents());
						convertedDate = format.format(date);
						}catch(Exception e){
							break;
						}
					} else {
						strings[sIndex] = cell.getContents();
						sIndex++;
					}	
				}
				sIndex = 0;
				try{
				validation.isThisDateValid(convertedDate,"dd/MM/yyyy HH:mm");
				Timestamp dateDB=new Timestamp(date.getTime());
				int event_id = Integer.parseInt(validation.isEventDateValid(strings[0]));
				int failure_class = Integer.parseInt(validation.isFailureClassValid(strings[1]));
				BigInteger ueTypeTac = new BigInteger(validation.ueTypeTacValidation(strings[2]));
				int market = Integer.parseInt(validation.isMCCValid(strings[3]));
				int mnc = Integer.parseInt(validation.mncValidation(strings[4]));
				int cell_id = Integer.parseInt(validation.cellIdValidation(strings[5]));
				int duration = Integer.parseInt(validation.durationValidation(strings[6]));
				int cause_code = Integer.parseInt(validation.isCauseCodeValid(strings[7]));
				String neVersion = validation.neVersionValidation(strings[8]);			
				BigInteger imsi = new BigInteger(validation.imsiValidation(strings[9]));
				
				
				//System.out.println("Ok!! " + count);
				
				/*BaseData entity = new BaseData(dateDB, event_id, failure_class, market, cause_code,imsi,cell_id,duration,mnc,neVersion,ueTypeTac,
						strings[10],strings[11],strings[12]);*/
				BaseData entity = new BaseData();
				
				entity.setDateAndTime(dateDB);
				
				entity.setEventId(event_id);
				entity.setFailureClass(failure_class);
				entity.setTac(ueTypeTac);
				entity.setMcc(market);
				entity.setMnc(mnc);
				entity.setDuration(duration);
				entity.setCellid(cell_id);
				entity.setCauseCode(cause_code);
				entity.setNeVersion(neVersion);
				entity.setImsi(imsi);
				entity.setHeir3ID(strings[10]);
				entity.setHeir32ID(strings[11]);
				entity.setHeir321ID(strings[12]);
				
				bsList.add(entity);
				convertedDate = null;
				}catch(Exception e){
					System.out.println("fail!! " + count);
					count++;
					//writeToLogError();
				}
				
				
			}
		} catch (BiffException e) {
			e.printStackTrace();
		}
		return bsList;

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
	
