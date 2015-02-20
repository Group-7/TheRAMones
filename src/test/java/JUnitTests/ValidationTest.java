package JUnitTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.group7.vadidation.BaseDataValidation;

public class ValidationTest {
	
	private BaseDataValidation val;
	
	@Before
	public void init() {
		val = new BaseDataValidation();
	}

	
	/**
	 * Test the mncValidation method that validates the incoming mnc data.
	 */
	@Test
	public void testMncValidation() {
		String[] validMncTestData = new String[]{"0", "1", "2", "62", "560", "570"};
		String[] inValidMncTestData = new String[]{"-0", "-1", "-777", "null", "dummy", "69", null, "-25599"};

		for(int i=0; i<validMncTestData.length; i++){
			assertTrue(val.mncValidation(validMncTestData[i]));
		}
		
		for(int j=0; j<inValidMncTestData.length; j++){
			assertFalse(val.mncValidation(inValidMncTestData[j]));
		}
	}
	
	
	/**
	 * Test the cellIdValidation method that validates the incoming cellId data.
	 */
	@Test
	public void testCellIdValidation() {
		String[] validCellIdTestData = new String[]{"4", "5", "3842"};
		String[] inValidCellIdTestData = new String[]{"-0", "-1", "-777", "null", "dummy", "69", null, "-25599"};

		for(int i=0; i<validCellIdTestData.length; i++){
			assertTrue(val.cellIdValidation(validCellIdTestData[i]));
		}
		
		for(int j=0; j<inValidCellIdTestData.length; j++){
			assertFalse(val.cellIdValidation(inValidCellIdTestData[j]));
		}
	}
	
	
	/**
	 * Test the durationValidation method that validates the incoming duration data.
	 */
	@Test
	public void testDurationValidation() {
		String[] validDurationTestData = new String[]{"1000"};
		String[] inValidDurationTestData = new String[]{"-0", "-1", "-777", "null", "dummy", "69", null, "-25599"};

		for(int i=0; i<validDurationTestData.length; i++){
			assertTrue(val.durationValidation(validDurationTestData[i]));
		}
		
		for(int j=0; j<inValidDurationTestData.length; j++){
			assertFalse(val.durationValidation(inValidDurationTestData[j]));
		}
	}
	
	
	/**
	 * Test the ismiValidation method that validates the incoming ismi data.
	 * (15 digit length)
	 */
	@Test
	public void testImsiValidation() {
		String[] validImsiTestData = new String[]{"176598763454267"};
		String[] inValidImsiTestData = new String[]{"99098765423452", "77863542345678", "-7779876542432234", "null", "dummy", "69", null};

		for(int i=0; i<validImsiTestData.length; i++){
			assertTrue(val.imsiValidation(validImsiTestData[i]));
		}
		
		for(int j=0; j<inValidImsiTestData.length; j++){
			assertFalse(val.imsiValidation(inValidImsiTestData[j]));
		}
	}

}
