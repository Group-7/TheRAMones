package com.group7.importBaseData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import com.group7.entities.BaseData;
import com.group7.entities.BaseDataError;
import com.group7.entities.EventCause;
import com.group7.entities.Failure;
import com.group7.entities.Network;
import com.group7.entities.UE;

public class BaseDataExcelRead {

	private String stringInput;

	// String[] strings = new String[len];

	DateFormat format = new SimpleDateFormat("MM/dd/yy HH:mm");
	Date date = null;
	String convertedDate = null;
	// TODO
	ArrayList<BaseData> bsList;// = new ArrayList<BaseData>();
	ArrayList<Network> networkTableList;// = new ArrayList<Network>();
	ArrayList<UE> ueTableList;// = new ArrayList<>();
	ArrayList<EventCause> eventCauseList;// = new ArrayList<EventCause>();
	ArrayList<Failure> failureClassList;// = new ArrayList<>();
	ArrayList<BaseDataError> baseDataErrorList;

	BaseDataValidation validation = BaseDataValidation.getInstance();

	/**
	 * Constructor
	 * 
	 * @param fileName
	 */
	public BaseDataExcelRead(String fileName) {
		this.stringInput = fileName;
	}

	public BaseDataExcelRead() {
		stringInput = "C:/Users/marc/Documents/sample_dataset.xls";
	}

	/***
	 * Method that reads in the information from The Base Data Excel Spread
	 * Sheet
	 * 
	 * @return
	 * @throws BiffException
	 * @throws IOException
	 */
	public Collection<BaseData> readExcelFile(long id) throws BiffException,
			IOException {
		validation.fillListsWithObjects();
		bsList = new ArrayList<BaseData>();
		baseDataErrorList = new ArrayList<BaseDataError>();
		String[] strings = new String[13];
		String dateAsString = "";
		int sIndex = 0;
		File inputWorkBook = new File(stringInput);
		Workbook w;
		int count = 0;
		try {
			w = Workbook.getWorkbook(inputWorkBook);
			Sheet sheet = w.getSheet(0);
			for (int j = 1; j < sheet.getRows(); j++) {
				for (int i = 0; i < sheet.getColumns(); i++) {
					Cell cell = sheet.getCell(i, j);
					if (i == 0) {
						dateAsString = "";
						dateAsString = cell.getContents();
						try {
							date = format.parse(cell.getContents());
							convertedDate = format.format(date);
						} catch (Exception e) {
							break;
						}
					} else {
						strings[sIndex] = cell.getContents();
						sIndex++;
					}
				}
				sIndex = 0;
				try {
					validation.isThisDateValid(convertedDate,	"MM/dd/yy HH:mm");
					Timestamp dateDB = new Timestamp(date.getTime());
					int event_id = Integer.parseInt(validation.isEventIdValid(strings[0]));
					int failure_class = Integer.parseInt(validation.isFailureClassValid(strings[1]));
					int ueTypeTac = Integer.parseInt(validation
							.ueTypeTacValidation(strings[2]));
					int mcc = Integer.parseInt(validation
							.isMCCValid(strings[3]));
					int mnc = Integer.parseInt(validation
							.mncValidation(strings[4]));
					int cell_id = Integer.parseInt(validation
							.cellIdValidation(strings[5]));
					int duration = Integer.parseInt(validation
							.durationValidation(strings[6]));
					int cause_code = Integer.parseInt(validation
							.isCauseCodeValid(strings[7]));
					String neVersion = validation
							.neVersionValidation(strings[8]);
					BigInteger imsi = new BigInteger(
							validation.imsiValidation(strings[9]));
					validation.validateCompositeKeysInNetwork(strings[3]
							+ strings[4]);
					validation.validateCompositeInEventCause(strings[7]
							+ strings[0]);

					// create the object
					id++;
					BaseData entity = new BaseData(id, dateDB, cell_id,
							duration, neVersion, imsi, strings[10],
							strings[11], strings[12], failure_class, ueTypeTac,
							event_id, cause_code, mcc, mnc);

					bsList.add(entity);
				} catch (Exception e) {
					// writeToLogError(count);
					BaseDataError bderror = new BaseDataError(dateAsString,
							strings[5], strings[6], strings[8], strings[9],
							strings[10], strings[11], strings[12], strings[1],
							strings[2], strings[7], strings[0], strings[3],
							strings[4]);
					baseDataErrorList.add(bderror);
					count++;
				}
			}
		} catch (BiffException e) {
			e.printStackTrace();
		}
		return bsList;
	} // end of read Base Data Method

	/**
	 * Method to read in the information about the Network Table from the Excel
	 * Spread sheet
	 * 
	 * @param errorLineNo
	 * 
	 */
	public Collection<Network> readNetworkTable() {
		networkTableList = new ArrayList<Network>();
		String[] dataIn = new String[4];
		int arrayIndex = 0;
		File inputWorkBook = new File(stringInput);
		Workbook w;
		int count = 0;
		try {
			w = Workbook.getWorkbook(inputWorkBook);
			Sheet sheet = w.getSheet(4);
			for (int i = 1; i < sheet.getRows(); i++) {
				for (int j = 0; j < sheet.getColumns(); j++) {
					Cell cell = sheet.getCell(j, i);
					dataIn[arrayIndex] = cell.getContents();
					arrayIndex++;
				}
				arrayIndex = 0;
				// create the object
				int mcc = Integer.parseInt(dataIn[0]);
				int mnc = Integer.parseInt(dataIn[1]);
				String country = dataIn[2];
				String operator = dataIn[3];
				Network network = new Network();
				network.setMcc(mcc);
				network.setMnc(mnc);
				network.setCountry(country);
				network.setOperator(operator);
				networkTableList.add(network);
				count++;
			}

		} catch (BiffException e) {
			writeToLogError(count);
			count++;
		} catch (IOException e) {
			e.printStackTrace();
		}

		return networkTableList;
	}

	/**
	 * Method to read in the Ue_Tbale from Excel
	 * 
	 * @param errorLineNo
	 */
	public Collection<UE> readUETable() {
		ueTableList = new ArrayList<UE>();
		String[] dataIn = new String[9];
		int arrayIndex = 0;
		File inputWorkBook = new File(stringInput);
		Workbook w;
		int count = 0;
		try {
			w = Workbook.getWorkbook(inputWorkBook);
			Sheet sheet = w.getSheet(3);
			for (int i = 1; i < sheet.getRows(); i++) {
				for (int j = 0; j < sheet.getColumns(); j++) {
					Cell cell = sheet.getCell(j, i);
					dataIn[arrayIndex] = cell.getContents();
					arrayIndex++;
				}
				arrayIndex = 0;
				// Put the value in variables
				int tac = Integer.parseInt(dataIn[0]);
				String marketingName = dataIn[1];
				String manufacturer = dataIn[2];
				String accessCapability = dataIn[3];
				String model = dataIn[4];
				String vendorName = dataIn[5];
				String ueType = dataIn[6];
				String os = dataIn[7];
				String inputMode = dataIn[8];
				// create the object
				UE ueEntity = new UE();
				ueEntity.setTac(tac);
				ueEntity.setMarketingName(marketingName);
				ueEntity.setManufacturer(manufacturer);
				ueEntity.setAccessCapability(accessCapability);
				ueEntity.setModel(model);
				ueEntity.setVendorName(vendorName);
				ueEntity.setUeType(ueType);
				ueEntity.setOperatingSystem(os);
				ueEntity.setInputMode(inputMode);
				// Add to the arraylist
				ueTableList.add(ueEntity);
				count++;
			}
		} catch (Exception e) {
			writeToLogError(count);
			count++;
		}

		return ueTableList;
	}

	/**
	 * Method to read in the Event Cause Method
	 * 
	 * @param errorLineNo
	 */
	public Collection<EventCause> readEventCauseTable() {
		eventCauseList = new ArrayList<EventCause>();
		String[] dataIn = new String[3];
		int arrayIndex = 0;
		int count = 0;
		File inputWorkBook = new File(stringInput);
		Workbook w;
		try {
			w = Workbook.getWorkbook(inputWorkBook);
			Sheet sheet = w.getSheet(1);
			for (int i = 1; i < sheet.getRows(); i++) {
				for (int j = 0; j < sheet.getColumns(); j++) {
					Cell cell = sheet.getCell(j, i);
					dataIn[arrayIndex] = cell.getContents();
					arrayIndex++;
				}
				arrayIndex = 0;
				// create the object
				Integer causeCode = Integer.parseInt(dataIn[0]);
				Integer eventId = Integer.parseInt(dataIn[1]);
				String description = dataIn[2];
				EventCause eventCauseObj = new EventCause();
				eventCauseObj.setCauseCode(causeCode);
				eventCauseObj.setEventID(eventId);
				eventCauseObj.setDiscription(description);
				eventCauseList.add(eventCauseObj);
				count++;
			}

		} catch (BiffException e) {
			writeToLogError(count);
			count++;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return eventCauseList;

	}

	/**
	 * Method to read in the Failure Class Table
	 * 
	 * @param errorLineNo
	 */
	public Collection<Failure> readFailureClassTable() {
		failureClassList = new ArrayList<Failure>();
		String[] dataIn = new String[2];
		int arrayIndex = 0;
		File inputWorkBook = new File(stringInput);
		Workbook w;
		int count = 0;
		try {
			w = Workbook.getWorkbook(inputWorkBook);
			Sheet sheet = w.getSheet(2);
			for (int i = 1; i < sheet.getRows(); i++) {
				for (int j = 0; j < sheet.getColumns(); j++) {
					Cell cell = sheet.getCell(j, i);
					dataIn[arrayIndex] = cell.getContents();
					arrayIndex++;
				}
				arrayIndex = 0;
				// create the object

				Integer FailureCode = Integer.parseInt(dataIn[0]);
				String description = dataIn[1];
				Failure failureObj = new Failure();
				failureObj.setFailureCode(FailureCode);
				failureObj.setDescription(description);
				failureClassList.add(failureObj);
				count++;
			}

		} catch (BiffException e) {
			writeToLogError(count);
			count++;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return failureClassList;
	}

	public void writeToLogError(int errorLineNo) {
		final String FILE_PATH = "C:/Users/marc/Documents/errorlog.txt";

		try {

			File file = new File(FILE_PATH);

			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			PrintWriter out = new PrintWriter(new FileWriter(file, true));
			out.append("Line: " + errorLineNo);
			out.append("\n");
			out.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static boolean isNullString(String cell) {
		return cell.equals("(null)");

	}

	public static String parseString(String cell) {
		if (isNullString(cell))
			return null;
		else
			return cell;
	}

	public static Integer parseInteger(String cell) {
		if (isNullString(cell))
			return null;
		else
			return Integer.parseInt(cell);

	}

	public ArrayList<BaseDataError> getBaseDataErrorList() {
		return baseDataErrorList;
	}

	public void setBaseDataErrorList(ArrayList<BaseDataError> baseDataErrorList) {
		this.baseDataErrorList = baseDataErrorList;
	}

}