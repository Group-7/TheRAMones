package com.group7.junit;

import static org.junit.Assert.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import jxl.read.biff.BiffException;

import org.junit.Before;
import org.junit.Test;

import com.group7.entities.BaseData;
import com.group7.importBaseData.BaseDataExcelRead;
import com.group7.importBaseData.BaseDataValidation;

public class XlsReadTest {
	
	private String fileName = "/home/giovanni/Documents/sample_datasetTestFile.xls";
	int len = 13;
	private String stringInput;
	String[] strings = new String[len];

	DateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm");
	Date date = null;
	String convertedDate = null;
	//BaseData entity;
	ArrayList<BaseData> bsList = new ArrayList<BaseData>();
	BaseDataValidation validation = new BaseDataValidation();
	
	
	
	@Before
	public Collection<Object> init() throws BiffException, IOException{
		BaseDataExcelRead exelReader = new BaseDataExcelRead("/home/giovanni/Documents/sample_datasetTestFile.xls");
		exelReader.readExcelFile();
		return null;
		
		
	}

	@Test
	public void test() throws BiffException, IOException {
		BaseDataExcelRead exelReader = new BaseDataExcelRead("/home/giovanni/Documents/sample_datasetTestFile.xls");
		assertTrue(exelReader.readExcelFile().contains("com.group7.entities.BaseData@f7ff7274"));
	}

}
