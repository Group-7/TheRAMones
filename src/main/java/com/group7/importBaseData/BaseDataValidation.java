package com.group7.importBaseData;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BaseDataValidation { 

	private List<String> eventId = new ArrayList<String>();
	private List<String> mcc = new ArrayList<String>();
	private List<String> mnc = new ArrayList<String>();
	private List<String> cellId = new ArrayList<String>();
	private List<String> neVersion = new ArrayList<String>();
	private List<String> ueTypeTac = new ArrayList<String>();
	private List<String> networkCompositeKeys = new ArrayList<String>();
	private List<String> eventCauseCompositeKeys = new ArrayList<String>();
	private String refDuration;
	 
	public BaseDataValidation(){
		
		// populate the lists with valid lookupTable data
		buildValidValidationData();
		
	}
		
		/**
		 * method that checks for a valid mnc code
		 * 
		 * @param mnc (incoming value that needs to be validated).
		 * @return true if found/valid.
		 * @throws Exception 
		 */ 
		public String mncValidation(String mnc) throws Exception {
			if (!(mnc == null) && mnc.contains(mnc)){
				return mnc;
			}
			throw new Exception();
		}
	
		
	
		/**
		 * method that checks for a valid Cell-Id value.
		 * 
		 * @param cell-Id (incoming value that needs to be validated).
		 * @return true if found/valid.
		 * @throws Exception 
		 */
		public String cellIdValidation(String cellId) throws Exception {
			if (!(cellId == null) && cellId.contains(cellId)){
				return cellId;
			}
			throw new Exception();		
		}
		
		
		
		/**
		 * method that checks if the duration is 1000ms.
		 * 
		 * @param duration (incoming value that needs to be validated).
		 * @return true if found/valid.
		 * @throws Exception 
		 */
		public String durationValidation(String duration) throws Exception{
			if(!(duration == null) && duration.equals(refDuration)){
					return duration;
				}
			throw new Exception();
		}	
		

		
		/**
		 * method that checks if the incoming imsi data is valid
		 * 
		 * @param testObject (incoming value that needs to be validated).
		 * @return true if found/valid.
		 * @throws Exception 
		 */
		public String imsiValidation(String imsi) throws Exception{
			if(!(imsi == null) && imsi.length() == 15){
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
			
			 if (dateToValidate == null) { return false; }
			

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
		public void validateCompositeInEventCause(String value) throws Exception{
			if (!eventCauseCompositeKeys.contains(value)) {
				throw new Exception();
			}
		}

		public void buildValidValidationData(){
			mnc.add("0");
			mnc.add("1");
			mnc.add("2");
			mnc.add("3");
			mnc.add("20");
			mnc.add("21");
			mnc.add("36");
			mnc.add("37");
			mnc.add("62");
			mnc.add("63");
			mnc.add("10");
			mnc.add("12");
			mnc.add("15");
			mnc.add("540");
			mnc.add("550");
			mnc.add("560");
			mnc.add("570");
			mnc.add("580");
			mnc.add("590");
			mnc.add("30");
			mnc.add("920");
			mnc.add("930");
			mnc.add("459");
			mnc.add("11");;
			mnc.add("68");
			mnc.add("71");
			mnc.add("72");
			mnc.add("88");
			mnc.add("90");
			
			cellId.add("4");
			cellId.add("5");
			cellId.add("3842");
			
			eventId.add("4097");
			eventId.add("4098");
			eventId.add("4125");
			eventId.add("4106");
			
			mcc.add("238");
			mcc.add("240");
			mcc.add("302");
			mcc.add("310");
			mcc.add("340");
			mcc.add("344");
			mcc.add("405");
			mcc.add("440");
			mcc.add("505");

			cellId.add("4");
			cellId.add("5");
			cellId.add("3842");
			
			neVersion.add("11B");
			neVersion.add("12A");
			
			refDuration = "1000";
			
			ueTypeTac.add("21060800");
			ueTypeTac.add("33000153");
			ueTypeTac.add("33000253");
			networkCompositeKeys.add("2381");
			networkCompositeKeys.add("2382");
			networkCompositeKeys.add("2383");
			networkCompositeKeys.add("2401");
			networkCompositeKeys.add("2402");
			networkCompositeKeys.add("2403");
			networkCompositeKeys.add("24020");
			networkCompositeKeys.add("24021");
			networkCompositeKeys.add("30236");
			networkCompositeKeys.add("30237");
			networkCompositeKeys.add("30262");
			networkCompositeKeys.add("30263");
			networkCompositeKeys.add("31010");
			networkCompositeKeys.add("31012");
			networkCompositeKeys.add("31013");
			networkCompositeKeys.add("310540");
			networkCompositeKeys.add("310550");
			networkCompositeKeys.add("310560");
			networkCompositeKeys.add("310570");
			networkCompositeKeys.add("310580");
			networkCompositeKeys.add("310590");
			networkCompositeKeys.add("3401");
			networkCompositeKeys.add("3402");
			networkCompositeKeys.add("3403");
			networkCompositeKeys.add("34430");
			networkCompositeKeys.add("344920");
			networkCompositeKeys.add("344930");
			networkCompositeKeys.add("4050");
			networkCompositeKeys.add("4051");
			networkCompositeKeys.add("4053");
			networkCompositeKeys.add("4054");
			networkCompositeKeys.add("4055");
			networkCompositeKeys.add("4409");
			networkCompositeKeys.add("44010");
			networkCompositeKeys.add("44011");
			networkCompositeKeys.add("50562");
			networkCompositeKeys.add("50568");
			networkCompositeKeys.add("50571");
			networkCompositeKeys.add("50572");
			networkCompositeKeys.add("50588");
			networkCompositeKeys.add("50590");
			fillEventCauseArraylist(0,17,"4097");
			fillEventCauseArraylist(0,4,"4098");
			fillEventCauseArraylist(0,34,"4125");
			fillEventCauseArraylist(0,25,"4106");
		}

		private void fillEventCauseArraylist(int start, int end, String num){
			for(int i = start ; i< end; i++){
				eventCauseCompositeKeys.add(""+i+num);
			}
		}

		public String getRefDuration() {
			return refDuration;
		}

		public List<String> getEventId() {
			return eventId;
		}

		public List<String> getMcc() {
			return mcc;
		}

		public List<String> getMnc() {
			return mnc;
		}

		public List<String> getCellId() {
			return cellId;
		}

		public List<String> getNeVersion() {
			return neVersion;
		}

		public List<String> getUeTypeTac() {
			return ueTypeTac;
		}
		
		
		
		
}