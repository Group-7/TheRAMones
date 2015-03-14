package com.group7.importBaseData;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.group7.entities.EventCause;
import com.group7.entities.Failure;
import com.group7.entities.Network;
import com.group7.entities.UE;

public class BaseDataValidation {

	private static Collection<EventCause> eventCauses = new ArrayList<>();
	private static Collection<Network> networks = new ArrayList<>();
	private static Collection<Failure> failures = new ArrayList<>();
	private static Collection<UE> ueObjects = new ArrayList<>();
	//TODO
	private static Set<String> eventId = new HashSet<String>(); 
	private static Set<String> mcc = new HashSet<String>(); 
	private static Set<String> mnc = new HashSet<String>();
	private static Set<String> causeCode = new HashSet<String>(); 
	private static Set<String> failureList = new HashSet<String>();
	private static Set<String> ueTypeTac = new HashSet<String>();
	private static Set<String> networkCompositeKeys = new HashSet<String>();
	private static Set<String> eventCauseCompositeKeys = new HashSet<String>();
	//private static String refDuration = "1000";
	private boolean ueFirst = true, failureFirst = true, networkFirst = true, eventCauseFirst = true;

	private static BaseDataValidation instance = null;

	private BaseDataValidation() {
	}

	public static BaseDataValidation getInstance() {
		if (instance == null)
			instance = new BaseDataValidation();
		return instance;
	}


	public void fillListsWithObjects() {
		for (EventCause e : eventCauses){
			eventId.add(Integer.toString(e.getEventId()));
			eventCauseCompositeKeys.add(""+e.getCauseCode()+e.getEventId());
			causeCode.add(Integer.toString(e.getCauseCode()));
		}
		for (Network n : networks) {
			mcc.add(Integer.toString(n.getMcc()));
			mnc.add(Integer.toString(n.getMnc()));
			networkCompositeKeys.add(""+n.getMcc()+n.getMnc());
		}
		for(UE u : ueObjects){
			ueTypeTac.add(Integer.toString(u.getTac()));
		}
		for(Failure f : failures){
			failureList.add(Integer.toString(f.getFailureCode()));
		}
		
	}

	/**
	 * Method to return the single instance of the Object for the 
	 * Singleton Pattern
	 * 
	 * @param instance
	 */
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
	public String mncValidation(String mncInput) throws Exception {
		if (!(mncInput == null) && mnc.contains(mncInput)) {
			return mncInput;
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
		if (!(cellId == null) && Integer.parseInt(cellId)>=0) {
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
		if (!(duration == null) && Integer.parseInt(duration)>=0){
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
	public String isEventIdValid(String eventIdInput) throws Exception {
		if (!(eventIdInput == null)&& eventId.contains(eventIdInput))
			return eventIdInput;
		throw new Exception();

	}

	/**
	 * A method to check the Failure String. It also checks if each character is
	 * a digit between 0-4.
	 * 
	 * @param failureClass
	 * @return true/false
	 * @throws Exception
	 */
	public String isFailureClassValid(String failureClassInput) throws Exception {
		if ((failureClassInput != null) && (failureList.contains(failureClassInput)))
			return failureClassInput;
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
	public String isMCCValid(String mccInput) throws Exception {
		if ((mccInput != null) && mcc.contains(mccInput))
			return mccInput;
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
	public String isCauseCodeValid(String causeCodeInput) throws Exception {
		if ((causeCodeInput != null) && causeCode.contains(causeCodeInput))
			return causeCodeInput;
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
		if ((NEVersion != null)) {
			return NEVersion;
		}
		throw new Exception();
	}

	/**
	 * Method to check that all composite keys match a country and operator
	 * description.
	 * 
	 * @param value
	 * @throws Exception
	 */
	public boolean validateCompositeKeysInNetwork(String value) throws Exception {
		if (!networkCompositeKeys.contains(value)) {
			throw new Exception();
		}
		return true;
	}

	/**
	 * Method to check that all composite keys match eventid and cause code
	 * description.
	 * 
	 * @param value
	 * @throws Exception
	 */
	public boolean validateCompositeInEventCause(String value) throws Exception {
		if (!eventCauseCompositeKeys.contains(value)) {
			throw new Exception();
		}
		return true;
	}

	/**
	 * A method to determine if a composite key exists in the Cache
	 * for network Composite Keys, if so don't commit to database 
	 * @return boolean
	 */
	public boolean persistCandidateKeysToNetworkTable(String ComboKeys){
		return networkCompositeKeys.contains(ComboKeys);
	}

	/**
	 * A method to determine if a composite key exists in the Cache,
	 * for Event Cause composite keys if so don't commit to database 
	 * @return boolean
	 */
	public boolean persistCandidateKeysToEventCauseTable(String ComboKeys){
		return eventCauseCompositeKeys.contains(ComboKeys);
	}
	
	/**
	 * A method to determine if Failure Class has an emxisiting primary key
	 * @return boolean
	 */
	public boolean persistFailurePrimaryKey(String failureKey){
		return failureList.contains(failureKey);
	}
	
	/**
	 * A method to determine if the UE table has existing preimary keys
	 * 
	 * @return boolean
	 */
	public boolean persistEventCausePrimaryKey(String tac){
		return ueTypeTac.contains(tac);
	}

	
	
	
	//TODO
	/**
	 * 
	 * 
	 * Getters and Setter below here
	 * 
	 * 
	 * @return
	 */
	public static Set<String> getEventId() {
		return eventId;
	}

	public static Set<String> getMcc() {
		return mcc;
	}

	public static Set<String> getMnc() {
		return mnc;
	}

	public static Set<String> getUeTypeTac() {
		return ueTypeTac;
	}

	public static Set<String> getNetworkCompositeKeys() {
		return networkCompositeKeys;
	}

	public static Set<String> getEventCauseCompositeKeys() {
		return eventCauseCompositeKeys;
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

	public static Set<String> getCauseCode() {
		return causeCode;
	}

	public static void setCauseCode(Set<String> causeCode) {
		BaseDataValidation.causeCode = causeCode;
	}

	public static void setEventId(Set<String> eventId) {
		BaseDataValidation.eventId = eventId;
	}

	public static void setMcc(Set<String> mcc) {
		BaseDataValidation.mcc = mcc;
	}

	public static void setMnc(Set<String> mnc) {
		BaseDataValidation.mnc = mnc;
	}

	public static void setUeTypeTac(Set<String> ueTypeTac) {
		BaseDataValidation.ueTypeTac = ueTypeTac;
	}

	public static void setNetworkCompositeKeys(Set<String> networkCompositeKeys) {
		BaseDataValidation.networkCompositeKeys = networkCompositeKeys;
	}

	public static void setEventCauseCompositeKeys(
			Set<String> eventCauseCompositeKeys) {
		BaseDataValidation.eventCauseCompositeKeys = eventCauseCompositeKeys;
	}

	public static Set<String> getFailureList() {
		return failureList;
	}

	public static void setFailureList(Set<String> failureList) {
		BaseDataValidation.failureList = failureList;
	}

	public boolean isUeFirst() {
		return ueFirst;
	}

	public void setUeFirst(boolean ueFirst) {
		this.ueFirst = ueFirst;
	}

	public boolean isFailureFirst() {
		return failureFirst;
	}

	public void setFailureFirst(boolean failureFirst) {
		this.failureFirst = failureFirst;
	}

	public boolean isNetworkFirst() {
		return networkFirst;
	}

	public void setNetworkFirst(boolean networkFirst) {
		this.networkFirst = networkFirst;
	}

	public boolean isEventCauseFirst() {
		return eventCauseFirst;
	}

	public void setEventCauseFirst(boolean eventCauseFirst) {
		this.eventCauseFirst = eventCauseFirst;
	}
	

	
}

//---------------------------------MARC PART-----------------------------------


/*package com.group7.importBaseData;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.group7.entities.EventCause;
import com.group7.entities.Failure;
import com.group7.entities.Network;
import com.group7.entities.UE;

public class BaseDataValidation {

	private static Collection<EventCause> eventCauses = new ArrayList<>();
	private static Collection<Network> networks = new ArrayList<>();
	private static Collection<Failure> failures = new ArrayList<>();
	private static Collection<UE> ueObjects = new ArrayList<>();
	//TODO
	private static Set<String> eventId = new HashSet<String>(); 
	private static Set<String> mcc = new HashSet<String>(); 
	private static Set<String> mnc = new HashSet<String>();
	private static Set<String> causeCode = new HashSet<String>(); 
	private static Set<String> failureList = new HashSet<String>();
	private static Set<String> ueTypeTac = new HashSet<String>();
	private static Set<String> networkCompositeKeys = new HashSet<String>();
	private static Set<String> eventCauseCompositeKeys = new HashSet<String>();

	private boolean ueFirst = true, failureFirst = true, networkFirst = true, eventCauseFirst = true;

	private static BaseDataValidation instance = null;

	private BaseDataValidation() {
	}

	public static BaseDataValidation getInstance() {
		if (instance == null)
			instance = new BaseDataValidation();
		return instance;
	}


	public void fillListsWithObjects() {
		for (EventCause e : eventCauses){
			eventId.add(Integer.toString(e.getEventId()));
			eventCauseCompositeKeys.add(""+e.getCauseCode()+e.getEventId());
			causeCode.add(Integer.toString(e.getCauseCode()));
		}
		for (Network n : networks) {
			mcc.add(Integer.toString(n.getMcc()));
			mnc.add(Integer.toString(n.getMnc()));
			networkCompositeKeys.add(""+n.getMcc()+n.getMnc());
		}
		for(UE u : ueObjects){
			ueTypeTac.add(Integer.toString(u.getTac()));
		}
		for(Failure f : failures){
			failureList.add(Integer.toString(f.getFailureCode()));
		}
		
	}

	*//**
	 * Method to return the single instance of the Object for the 
	 * Singleton Pattern
	 * 
	 * @param instance
	 *//*
	public static void setInstance(BaseDataValidation instance) {
		BaseDataValidation.instance = instance;
	}

	*//**
	 * method that checks for a valid mnc code
	 * 
	 * @param mnc
	 *            (incoming value that needs to be validated).
	 * @return true if found/valid.
	 * @throws Exception
	 *//*
	public String mncValidation(String mncInput) throws Exception {
		if (!(mncInput == null) && mnc.contains(mncInput)) {
			return mncInput;
		}
		throw new Exception();
	}

	*//**
	 * method that checks for a valid Cell-Id value.
	 * 
	 * @param cell
	 *            -Id (incoming value that needs to be validated).
	 * @return true if found/valid.
	 * @throws Exception
	 *//*
	public String cellIdValidation(String cellId) throws Exception {
		if (!(cellId == null) && Integer.parseInt(cellId)>=0) {
			return cellId;
		}
		throw new Exception();
	}

	*//**
	 * method that checks if the duration is 1000ms.
	 * 
	 * @param duration
	 *            (incoming value that needs to be validated).
	 * @return true if found/valid.
	 * @throws Exception
	 *//*
	public String durationValidation(String duration) throws Exception {
		if (!(duration == null) && Integer.parseInt(duration)>=0){
			return duration;
		}
		throw new Exception();
	}

	*//**
	 * method that checks if the incoming imsi data is valid
	 * 
	 * @param testObject
	 *            (incoming value that needs to be validated).
	 * @return true if found/valid.
	 * @throws Exception
	 *//*
	public String imsiValidation(String imsi) throws Exception {
		if (!(imsi == null)) {
			return imsi;
		}
		throw new Exception();
	}

	*//**
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
	 *//*
	public boolean isThisDateValid(String dateToValidate, String dateFromat) {

		if (dateToValidate == null) {
			return false;
		}

		SimpleDateFormat sdf = new SimpleDateFormat(dateFromat);
		sdf.setLenient(false);

		try {
			Date date = sdf.parse(dateToValidate);
			*//**
			 * In here is checking for future and past dates!!
			 * 
			 * Date now = new Date(); Calendar cal = Calendar.getInstance();
			 * cal.setTime(now); SimpleDateFormat format = new
			 * SimpleDateFormat("MM/dd/yyyy HH:mm"); String dateInString =
			 * "01/01/2000  00:00"; Date year2000 = format.parse(dateInString);
			 * if (date.after(now) || date.before(year2000)) return false;
			 **//*
		} catch (ParseException e) {
			// e.printStackTrace();
			return false;
		}

		return true;
	}

	*//**
	 * Method to check if the param is within a defined set of values which are
	 * set in the constructor and that each character is a digit See constructor
	 * and the arraylist'eventId'
	 * 
	 * @param eventId
	 * @return true/false
	 * @throws Exception
	 *//*
	public String isEventIdValid(String eventIdInput) throws Exception {
		if (!(eventIdInput == null)&& eventId.contains(eventIdInput))
			return eventIdInput;
		throw new Exception();

	}

	*//**
	 * A method to check the Failure String. It also checks if each character is
	 * a digit between 0-4.
	 * 
	 * @param failureClass
	 * @return true/false
	 * @throws Exception
	 *//*
	public String isFailureClassValid(String failureClassInput) throws Exception {
		if ((failureClassInput != null) && (failureList.contains(failureClassInput)))
			return failureClassInput;
		throw new Exception();
	}

	*//**
	 * A method to check that the MCC is within a defined value set. See
	 * constructor for the set. It also checks if each character is between 0-9.
	 * 
	 * @param mcc
	 * @return true/false
	 * @throws Exception
	 *//*
	public String isMCCValid(String mccInput) throws Exception {
		if ((mccInput != null) && mcc.contains(mccInput))
			return mccInput;
		throw new Exception();

	}

	*//**
	 * method to check the cause code is between 0-33 and also that each
	 * character is a digit between 0-9.
	 * 
	 * @param causeCode
	 * @return
	 * @throws Exception
	 *//*
	public String isCauseCodeValid(String causeCodeInput) throws Exception {
		if ((causeCodeInput != null) && causeCode.contains(causeCodeInput))
			return causeCodeInput;
		throw new Exception();
	}

	*//**
	 * A method to validate the UE Type/TAC
	 * 
	 * @param tacNum
	 * @return the validated tac number
	 * @throws Exception
	 *//*
	public String ueTypeTacValidation(String tacNum) throws Exception {
		if (!(tacNum == null) && ueTypeTac.contains(tacNum)) {
			return tacNum;
		}
		throw new Exception();
	}

	*//**
	 * method that checks for a valid NE-Version value.
	 * 
	 * @param NEVersion
	 *            (incoming value that needs to be validated).
	 * @return true if found/valid.
	 * @throws Exception
	 *//*
	public String neVersionValidation(String NEVersion) throws Exception {
		if ((NEVersion != null)) {
			return NEVersion;
		}
		throw new Exception();
	}

	*//**
	 * Method to check that all composite keys match a country and operator
	 * description.
	 * 
	 * @param value
	 * @throws Exception
	 *//*
	public boolean validateCompositeKeysInNetwork(String value) throws Exception {
		if (!networkCompositeKeys.contains(value)) {
			throw new Exception();
		}
		return true;
	}

	*//**
	 * Method to check that all composite keys match eventid and cause code
	 * description.
	 * 
	 * @param value
	 * @throws Exception
	 *//*
	public boolean validateCompositeInEventCause(String value) throws Exception {
		if (!eventCauseCompositeKeys.contains(value)) {
			throw new Exception();
		}
		return true;
	}

	*//**
	 * A method to determine if a composite key exists in the Cache
	 * for network Composite Keys, if so don't commit to database 
	 * @return boolean
	 *//*
	public boolean persistCandidateKeysToNetworkTable(String ComboKeys){
		return networkCompositeKeys.contains(ComboKeys);
	}

	*//**
	 * A method to determine if a composite key exists in the Cache,
	 * for Event Cause composite keys if so don't commit to database 
	 * @return boolean
	 *//*
	public boolean persistCandidateKeysToEventCauseTable(String ComboKeys){
		return eventCauseCompositeKeys.contains(ComboKeys);
	}
	
	*//**
	 * A method to determine if Failure Class has an emxisiting primary key
	 * @return boolean
	 *//*
	public boolean persistFailurePrimaryKey(String failureKey){
		return failureList.contains(failureKey);
	}
	
	*//**
	 * A method to determine if the UE table has existing preimary keys
	 * 
	 * @return boolean
	 *//*
	public boolean persistEventCausePrimaryKey(String tac){
		return ueTypeTac.contains(tac);
	}

	
	
	
	//TODO
	*//**
	 * 
	 * 
	 * Getters and Setter below here
	 * 
	 * 
	 * @return
	 *//*
	public static Set<String> getEventId() {
		return eventId;
	}

	public static Set<String> getMcc() {
		return mcc;
	}

	public static Set<String> getMnc() {
		return mnc;
	}

	public static Set<String> getUeTypeTac() {
		return ueTypeTac;
	}

	public static Set<String> getNetworkCompositeKeys() {
		return networkCompositeKeys;
	}

	public static Set<String> getEventCauseCompositeKeys() {
		return eventCauseCompositeKeys;
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

	public static Set<String> getCauseCode() {
		return causeCode;
	}

	public static void setCauseCode(Set<String> causeCode) {
		BaseDataValidation.causeCode = causeCode;
	}

	public static void setEventId(Set<String> eventId) {
		BaseDataValidation.eventId = eventId;
	}

	public static void setMcc(Set<String> mcc) {
		BaseDataValidation.mcc = mcc;
	}

	public static void setMnc(Set<String> mnc) {
		BaseDataValidation.mnc = mnc;
	}

	public static void setUeTypeTac(Set<String> ueTypeTac) {
		BaseDataValidation.ueTypeTac = ueTypeTac;
	}

	public static void setNetworkCompositeKeys(Set<String> networkCompositeKeys) {
		BaseDataValidation.networkCompositeKeys = networkCompositeKeys;
	}

	public static void setEventCauseCompositeKeys(
			Set<String> eventCauseCompositeKeys) {
		BaseDataValidation.eventCauseCompositeKeys = eventCauseCompositeKeys;
	}

	public static Set<String> getFailureList() {
		return failureList;
	}

	public static void setFailureList(Set<String> failureList) {
		BaseDataValidation.failureList = failureList;
	}

	public boolean isUeFirst() {
		return ueFirst;
	}

	public void setUeFirst(boolean ueFirst) {
		this.ueFirst = ueFirst;
	}

	public boolean isFailureFirst() {
		return failureFirst;
	}

	public void setFailureFirst(boolean failureFirst) {
		this.failureFirst = failureFirst;
	}

	public boolean isNetworkFirst() {
		return networkFirst;
	}

	public void setNetworkFirst(boolean networkFirst) {
		this.networkFirst = networkFirst;
	}

	public boolean isEventCauseFirst() {
		return eventCauseFirst;
	}

	public void setEventCauseFirst(boolean eventCauseFirst) {
		this.eventCauseFirst = eventCauseFirst;
	}
	

	
}*/