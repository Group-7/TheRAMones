package com.group7.importBaseData;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.group7.entities.EventCause;
import com.group7.entities.Failure;
import com.group7.entities.Network;
import com.group7.entities.UE;

public class BaseDataValidation {

	private static Collection<EventCause> eventCauses = new ArrayList<>();
	private static Collection<Network> networks = new ArrayList<>();
	private static Collection<Failure> failures = new ArrayList<>();
	private static Collection<UE> ueObjects = new ArrayList<>();

	private static List<Integer> eventId = new ArrayList<Integer>(); // done
	private static List<Integer> mcc = new ArrayList<Integer>();
	private static List<Integer> mnc = new ArrayList<Integer>();
	private static List<String> cellId = new ArrayList<String>();
	private static List<String> neVersion = new ArrayList<String>();
	private static List<String> ueTypeTac = new ArrayList<String>();
	private static List<String> networkCompositeKeys = new ArrayList<String>();
	private static List<String> eventCauseCompositeKeys = new ArrayList<String>();
	private static String refDuration;

	private static BaseDataValidation instance = null;

	private BaseDataValidation() {
	}

	public static BaseDataValidation getInstance() {
		if (instance == null)
			instance = new BaseDataValidation();
		return instance;
	}

	/*
	 * public BaseDataValidation(){
	 * 
	 * buildValidValidationData(); }
	 */
	public void fillListsWithObjects() {
		buildValidValidationData();
		for (EventCause e : eventCauses){
			eventId.add(e.getEventId());
			eventCauseCompositeKeys.add(""+e.getCauseCode()+e.getEventId());
		}
		for (Network n : networks) {
			mcc.add(n.getMcc());
			mnc.add(n.getMnc());
			networkCompositeKeys.add(""+n.getMcc()+n.getMnc());
			
			
		}
		/*System.out.println();
		System.out.println();
		System.out.println("*************************************************************************");
		System.out.println("Size: " + networkCompositeKeys.size());
		System.out.println(networkCompositeKeys.get(0));
		System.out.println(networkCompositeKeys.get(1));
		System.out.println("*************************************************************************");
		System.out.println();
		System.out.println();
		System.out.println("*************************************************************************");
		System.out.println("Size: " + eventCauseCompositeKeys.size());
		System.out.println(eventCauseCompositeKeys.get(0));
		System.out.println(eventCauseCompositeKeys.get(1));
		System.out.println("*************************************************************************");*/
	}

	public Collection<EventCause> getEventCauses() {
		return eventCauses;
	}

	public void setEventCauses(Collection<EventCause> eventCauseData) {
		this.eventCauses = eventCauseData;
	}

	public Collection<Network> getNetworks() {
		return networks;
	}

	public void setNetworks(Collection<Network> networks) {
		this.networks = networks;
	}

	public Collection<Failure> getFailures() {
		return failures;
	}

	public void setFailures(Collection<Failure> failures) {
		this.failures = failures;
	}

	public Collection<UE> getUeObjects() {
		return ueObjects;
	}

	public void setUeObjects(Collection<UE> ueObjects) {
		this.ueObjects = ueObjects;
	}

	public static void setInstance(BaseDataValidation instance) {
		BaseDataValidation.instance = instance;
	}

	/**
	 * method that checks for a valid mnc code
	 * 
	 * @param mnc
	 *            (incoming value that needs to be validated).
	 * @return true if found/valid.
	 * @throws Exception
	 */
	public String mncValidation(String mnc) throws Exception {
		if (!(mnc == null) && mnc.contains(mnc)) {
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
	 * @throws Exception
	 */
	public String cellIdValidation(String cellId) throws Exception {
		if (!(cellId == null) && cellId.contains(cellId)) {
			return cellId;
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
		if (!(duration == null) && duration.equals(refDuration)){
		
			return duration;
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

		if (dateToValidate == null) {
			return false;
		}

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
	 * and the arraylist'eventId'
	 * 
	 * @param eventId
	 * @return true/false
	 * @throws Exception
	 */
	public String isEventIdValid(String eventId) throws Exception {
		if (eventId == null || !eventId.matches("^[0-9]+"))
			throw new Exception();
		if (eventId.contains(eventId))
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
		if (mcc.contains(mcc))
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
	 * Mehtod to check that all composite keys match a country and operaotr
	 * description.
	 * 
	 * @param value
	 * @throws Exception
	 */
	public void validateCompositeKeysInNetwork(String value) throws Exception {
		if (!networkCompositeKeys.contains(value)) {
			throw new Exception();
		}
	}

	/**
	 * Mehtod to check that all composite keys match eventid and cause code
	 * description.
	 * 
	 * @param value
	 * @throws Exception
	 */
	public void validateCompositeInEventCause(String value) throws Exception {
		if (!eventCauseCompositeKeys.contains(value)) {
			throw new Exception();
		}
	}

	public void buildValidValidationData() {
		cellId.add("4");
		cellId.add("5");
		cellId.add("3842");
		neVersion.add("11B");
		neVersion.add("12A");
		refDuration = "1000";
		ueTypeTac.add("21060800");
		ueTypeTac.add("33000153");
		ueTypeTac.add("33000253");
	}
}