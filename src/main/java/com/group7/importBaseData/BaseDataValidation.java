package com.group7.importBaseData;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class BaseDataValidation {

	private List<String> definedEventIds = new ArrayList<String>();
	private List<String> allAllowedMCC = new ArrayList<String>();
	private List<String> mncData = new ArrayList<String>();
	private List<String> cellIdData = new ArrayList<String>();
	private List<String> neVersion = new ArrayList<String>();
	private List<String> ueTypeTac = new ArrayList<String>();
	private String refDuration;

	public BaseDataValidation() {
		buildValidValidationData();

	}

	/**
	 * 
	 * Method to Validate a Date of type String. It ensures all days,months and
	 * time are valid. It also checks to see the date in not before the year
	 * 2000 and now greater than the current time.
	 * 
	 * The format written in from Excel is dd/M/yyyy HH:mm:ss so thats whats
	 * tested
	 * 
	 * @param dateToValidate
	 * @param dateFromat
	 * @return true/false
	 */
	public boolean isThisDateValid(String dateToValidate, String dateFromat) {
		/*
		 * if (dateToValidate == null) { return false; }
		 */

		SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
		sdf.setLenient(false);

		try {
			Date date = sdf.parse(dateToValidate);
			/**
			 * In here is checking for future and past dates!!
			 * 
			 * Date now = new Date(); Calendar cal = Calendar.getInstance();
			 * cal.setTime(now); SimpleDateFormat format = new
			 * SimpleDateFormat("MM/dd/yyyy HH:mm"); String dateInString =
			 * "01/01/2000  00:00"; Date year2000 = format.parse(dateInString);
			 * if (date.after(now) || date.before(year2000)) return false;
			 **/
		} catch (ParseException e) {
			// e.printStackTrace();
			return false;
		}

		return true;
	}

	/**
	 * Method to check if the param is within a defined set of values which are
	 * set in the constructor and that each character is a digit See constructor
	 * and the arraylist'definedEventIds'
	 * 
	 * @param eventId
	 * @return true/false
	 * @throws Exception
	 */
	public String isEventDateValid(String eventId) throws Exception {
		if (eventId == null || !eventId.matches("^[0-9]+"))
			throw new Exception();
		if (definedEventIds.contains(eventId))
			return eventId;
		throw new Exception();

	}

	/**
	 * A method to check the Failure String. It also checks if each character is
	 * a digit between 0-9.
	 * 
	 * @param failureClass
	 * @return true/false
	 * @throws Exception
	 */
	public String isFailureClassValid(String failureClass) throws Exception {
		if (failureClass == null || !failureClass.matches("^[0-9]+"))
			throw new Exception();
		int convertedFailClass = Integer.parseInt(failureClass);
		if (convertedFailClass >= 0 && convertedFailClass < 5)
			return failureClass;
		throw new Exception();
	}

	/**
	 * A method to check that the MCC is within a defined value set. See
	 * constructor for the set. It also checks if each character is between 0-9.
	 * 
	 * @param mcc
	 * @return true/false
	 * @throws Exception
	 */
	public String isMCCValid(String mcc) throws Exception {
		if (mcc == null || !mcc.matches("^[0-9]+"))
			throw new Exception();
		if (allAllowedMCC.contains(mcc))
			return mcc;
		throw new Exception();

	}

	/**
	 * method to check the cause code is between 0-33 and also that each
	 * character is a digit between 0-9.
	 * 
	 * @param causeCode
	 * @return
	 * @throws Exception
	 */
	public String isCauseCodeValid(String causeCode) throws Exception {
		if (causeCode == null || !causeCode.matches("^[0-9]+"))
			throw new Exception();
		int convertedCauseCode = Integer.parseInt(causeCode);
		if (convertedCauseCode >= 0 && convertedCauseCode < 34)
			return causeCode;
		throw new Exception();
	}

	// ///////////////////////////////////////////////////////////////
	// Gio methods
	/**
	 * method that checks for a valid mnc code
	 * 
	 * @param mnc
	 *            (incoming value that needs to be validated).
	 * @return true if found/valid.
	 */
	public String mncValidation(String mnc) throws Exception {
		if (!(mnc == null) && mncData.contains(mnc)) {
			return mnc;
		}
		throw new Exception();
	}

	/**
	 * method that checks for a valid Cell-Id value.
	 * 
	 * @param cell
	 *            -Id (incoming value that needs to be validated).
	 * @return true if found/valid.
	 */
	public String cellIdValidation(String cellId) throws Exception {
		if (!(cellId == null) && cellIdData.contains(cellId)) {
			return cellId;
		}
		throw new Exception();
	}

	/**
	 * method that checks for a valid NE-Version value.
	 * 
	 * @param NEVersion
	 *            (incoming value that needs to be validated).
	 * @return true if found/valid.
	 * @throws Exception
	 */
	public String neVersionValidation(String NEVersion) throws Exception {
		if (!(NEVersion == null) && neVersion.contains(NEVersion)) {
			return NEVersion;
		}
		throw new Exception();
	}

	/**
	 * method that checks if the duration is 1000ms.
	 * 
	 * @param duration
	 *            (incoming value that needs to be validated).
	 * @return true if found/valid.
	 * @throws Exception
	 */
	public String durationValidation(String duration) throws Exception {
		if (!(duration == null) && duration.equals(refDuration)) {
			return duration;
		}
		throw new Exception();
	}

	/**
	 * A method to validate the UE Type/TAC
	 * 
	 * @param tacNum
	 * @return the validated tac number
	 * @throws Exception
	 */
	public String ueTypeTacValidation(String tacNum) throws Exception {
		if (!(tacNum == null) && ueTypeTac.contains(tacNum)) {
			return tacNum;
		}
		throw new Exception();
	}

	/**
	 * method that checks if the incoming imsi data is valid
	 * 
	 * @param testObject
	 *            (incoming value that needs to be validated).
	 * @return true if found/valid.
	 * @throws Exception
	 */
	public String imsiValidation(String imsi) throws Exception {
		if (!(imsi == null) && imsi.length() == 15) {
			return imsi;
		}
		throw new Exception();
	}

	// ///////////////////////////////////////////////////////////////
	// /////Getters and setters here
	public List<String> getDefinedEventIds() {
		return definedEventIds;
	}

	public List<String> getAllAllowedMCC() {
		return allAllowedMCC;
	}

	private void buildValidValidationData() {
		mncData.add("0");
		mncData.add("1");
		mncData.add("2");
		mncData.add("3");
		mncData.add("20");
		mncData.add("21");
		mncData.add("36");
		mncData.add("37");
		mncData.add("62");
		mncData.add("63");
		mncData.add("10");
		mncData.add("12");
		mncData.add("15");
		mncData.add("540");
		mncData.add("550");
		mncData.add("560");
		mncData.add("570");
		mncData.add("580");
		mncData.add("590");
		mncData.add("30");
		mncData.add("920");
		mncData.add("930");
		mncData.add("459");
		mncData.add("11");
		mncData.add("68");
		mncData.add("71");
		mncData.add("72");
		mncData.add("88");
		mncData.add("90");
		definedEventIds.add("4097");
		definedEventIds.add("4098");
		definedEventIds.add("4125");
		definedEventIds.add("4106");
		allAllowedMCC.add("238");
		allAllowedMCC.add("240");
		allAllowedMCC.add("302");
		allAllowedMCC.add("310");
		allAllowedMCC.add("340");
		allAllowedMCC.add("344");
		allAllowedMCC.add("405");
		allAllowedMCC.add("440");
		allAllowedMCC.add("505");

		cellIdData.add("4");
		cellIdData.add("5");
		cellIdData.add("3842");
		neVersion.add("11B");
		neVersion.add("12A");
		refDuration = "1000";
		ueTypeTac.add("21060800");
		ueTypeTac.add("33000153");
		ueTypeTac.add("33000253");
	}

}

