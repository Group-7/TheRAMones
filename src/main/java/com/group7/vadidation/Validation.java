package com.group7.vadidation;

import java.lang.reflect.Array;
import java.util.Collection;

import com.group7.entities.BaseData;

public class Validation { 
	
	private boolean fail;
	
	private static String[] mccArray = new String[]{"238", "240", "302", "310", "340", "344", "405", "440", "505"};
	private static String[] mncArray = new String[]{"0", "1", "2", "3", "20", "21", "36", "37", "62", "63", "10", "12", "15", "540", "550", "560", "570", 
													"580", "590", "30", "920", "930", "459", "11", "68", "71", "72", "88", "90"};
	private static String[] cellId = new String[]{"4", "5", "3842"};
	 
	
	
	
		/**
		 * method that checks for a valid mnc code
		 * 
		 * @param mnc (incoming value that needs to be validated).
		 * @return true if found/valid.
		 */
		public boolean mncValidation(String mnc) {
			if (!(mnc == null) || contains(mncArray, mnc)){
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
			if (!(cellId == null) || contains(mncArray, cellId)){
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
			if(duration == "1000"){
					return true;
				}
			return false;
		}	
		

		/**
		 * method that checks if the duration is 1000ms.
		 * 
		 * @param testObject (incoming value that needs to be validated).
		 * @return true if found/valid.
		 */
		public boolean imsiValidation(String testObject){
			if(testObject.length() == 15 ){
					return true;
				}
			return false;
		}	
		
		
		
		
		///// LOCAL CONTAINS METHOD /////
		
		/**
		 * method that checks if the testObject is contained by the array.
		 * 
		 * @param arrayName (column name of a lookup table).
		 * @param testObject (incoming code that needs to be validated).
		 * @return true if found.
		 */
		private boolean contains(String[] arrayName, String testObject){
			for(int i = 0; i<arrayName.length; i++){
				if(arrayName[i] == testObject){
					return true;
				}
			}
			return false;
		}
		
		
	
			
			
			
		public boolean BaseDataValidation(Collection<BaseData> data){
		return fail;
	}
}
