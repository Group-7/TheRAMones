package com.group7.vadidation;

import java.util.ArrayList;
import java.util.List;

public class BaseDataValidation { 
		
	//private static String[] mccArray = new String[]{"238", "240", "302", "310", "340", "344", "405", "440", "505"};
	private List<String> mncData = new ArrayList<String>();
	private List<String> cellIdData = new ArrayList<String>();
	
	 
	public BaseDataValidation(){
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
		mncData.add("11");;
		mncData.add("68");
		mncData.add("71");
		mncData.add("72");
		mncData.add("88");
		mncData.add("90");
		
		cellIdData.add("4");
		cellIdData.add("5");
		cellIdData.add("3842");

		
	}
	
	
		/**
		 * method that checks for a valid mnc code
		 * 
		 * @param mnc (incoming value that needs to be validated).
		 * @return true if found/valid.
		 */
		public boolean mncValidation(String mnc) {
			if (!(mnc == null) && mncData.contains(mnc)){
				return true;
			}
			return false;
		}
	
	
		/**
		 * method that checks for a valid Cell-Id value.
		 * 
		 * @param cell-Id (incoming value that needs to be validated).
		 * @return true if found/valid.
		 */
		public boolean cellIdValidation(String cellId) {
			if (!(cellId == null) && cellIdData.contains(cellId)){
				return true;
			}
			return false;
		}
			
		
		/**
		 * method that checks if the duration is 1000ms.
		 * 
		 * @param duration (incoming value that needs to be validated).
		 * @return true if found/valid.
		 */
		public boolean durationValidation(String duration){
			if(!(duration == null) && duration == "1000"){
					return true;
				}
			return false;
		}	
		

		/**
		 * method that checks if the incoming imsi data is valid
		 * 
		 * @param testObject (incoming value that needs to be validated).
		 * @return true if found/valid.
		 */
		public boolean imsiValidation(String imsi){
			if(!(imsi == null) && imsi.length() == 15){
					return true;
				}
			return false;
		}	
		
		
}
