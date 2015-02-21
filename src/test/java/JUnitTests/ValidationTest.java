package JUnitTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.group7.vadidation.BaseDataValidation;

/**
 * Tests if the validation methods for validating the baseData
 * are correctly functioning.
 * Test cases are deployed for valid data as for invalid data.
 *
 */
public class ValidationTest {
	
	private BaseDataValidation validator;
	
	@Before
	public void init() {
		validator = new BaseDataValidation();
	}

	
	/**
	 * Test the mnc Validation method on invalid mnc data.
	 * @throws Exception 
	 */
	@Test(expected=Exception.class)
	public void testMncValidation() throws Exception {
		String[] inValidMncTestData = new String[]{"-0", "-1", "-777", "null", "dummy", "69", null, "-25599"};

		for(int j=0; j<inValidMncTestData.length; j++){
			String inValidMncTest = validator.mncValidation(inValidMncTestData[j]);
		}
	}
	
	
	/**
	 * Test the mnc Validation method on valid mnc data.
	 * @throws Exception 
	 */
	@Test
	public void ValidMncValidationTest() throws Exception{
		String[] validMncTestData = new String[]{"0", "1", "2", "62", "560", "570"};

		for(int i=0; i<validMncTestData.length; i++){
			assertEquals(validMncTestData[i], validator.mncValidation(validMncTestData[i]));
			assertTrue(validator.getMnc().contains(validMncTestData[i]));
		}
	}
	
	
	/**
	 * Test the cellId Validation method with invalid cellId data.
	 * 
	 * @throws Exception
	 */
	@Test(expected=Exception.class)
	public void invalidCellIdValidationTest() throws Exception {
		String[] inValidCellIdTestData = new String[]{"-0", "-1", "-777", "null", "dummy", "69", null, "-25599"};
		
		for(int j=0; j<inValidCellIdTestData.length; j++){
			String inValidCellIdTest = validator.cellIdValidation(inValidCellIdTestData[j]);
		}
	}
	
	
	/**
	 * Test the cellId Validation method with valid cellId data.
	 */
	@Test
	public void validCellIdValidationTest() throws Exception {
		String[] validCellIdTestData = new String[]{"4", "5", "3842"};

		for(int i=0; i<validCellIdTestData.length; i++){
			assertEquals(validCellIdTestData[i], validator.cellIdValidation(validCellIdTestData[i]));
			assertTrue(validator.getCellId().contains(validCellIdTestData[i]));

		}
	}
	
	
	/**
	 * Test the duration Validation method with invalid duration data.
	 * @throws Exception 
	 */
	@Test(expected=Exception.class)
	public void invalidDurationValidationTest() throws Exception {
		String[] inValidDurationTestData = new String[]{"-0", "-1", "-777", "null", "dummy", "69", null, "-25599"};

		for(int j=0; j<inValidDurationTestData.length; j++){
			String inValidDurationTest = validator.durationValidation(inValidDurationTestData[j]);
		}
	}
	
	

	/**
	 * Test the duration Validation method with valid data. 
	 */
	@Test
	public void ValidDurationValidationTest() throws Exception {
		String[] validDurationTestData = new String[]{"1000"};

		for(int i=0; i<validDurationTestData.length; i++){
			assertEquals(validDurationTestData[i], validator.durationValidation(validDurationTestData[i]));
			assertTrue(validator.getRefDuration().contains(validDurationTestData[i]));
		}
	}
	
	
	/**
	 * Test the ismi Validation method with invalid ismi data.
	 * (15 digit length)
	 * @throws Exception 
	 */
	@Test(expected=Exception.class)
	public void invalidImsiValidationTest() throws Exception {
		String[] inValidImsiTestData = new String[]{"99098765423452", "77863542345678", "-7779876542432234", "null", "dummy", "69", null};
		
		for(int j=0; j<inValidImsiTestData.length; j++){
			String inValidIsmiTest = validator.imsiValidation(inValidImsiTestData[j]);
		}
	}
	
	
	/**
	 * Test the ismi Validation method with valid ismi data.
	 * (15 digit length)
	 */
	@Test
	public void testImsiValidation() throws Exception {
		String[] validImsiTestData = new String[]{"176598763454267"};

		for(int i=0; i<validImsiTestData.length; i++){
			assertEquals(validImsiTestData[i], validator.imsiValidation(validImsiTestData[i]));
		}
	}
	
	
	/**
	 * Test the NE Validation method with invalid NE data.
	 * 
	 * @throws Exception 
	 */
	@Test(expected=Exception.class)
	public void invalidNeValidationTest() throws Exception {
		String[] inValidNeTestData = new String[]{"14D", "-18U", "777366", "null", "dummy", "69", null};

		for(int j=0; j<inValidNeTestData.length; j++){
			String inValidNeTest = validator.neVersionValidation(inValidNeTestData[j]);
		}
	}
	
	
	/**
	 * Test the NE Validation method with valid NE data.
	 */
	public void validNeValidationTest() throws Exception {
		String[] validNeTestData = new String[]{"11B", "12A"};

		for(int i=0; i<validNeTestData.length; i++){
			assertEquals(validNeTestData[i], validator.neVersionValidation(validNeTestData[i]));
		}
	}
	
	
	/**
	 * Test the UE Validation method with invalid UE data.
	 * 
	 * @throws Exception 
	 */
	@Test(expected=Exception.class)
	public void invalidUeValidationTest() throws Exception {
		String[] inValidUeTestData = new String[]{"21064546", "-21060800", "0", "null", "dummy", "-0", null};

		for(int j=0; j<inValidUeTestData.length; j++){
			String inValidUeTest = validator.ueTypeTacValidation(inValidUeTestData[j]);
		}
	}
	
	
	/**
	 * Test the UE Validation method with valid UE data.			
	 */
	public void validUeValidationTest() throws Exception {
		String[] validUeTestData = new String[]{"21060800", "33000153", "33000253"};

		for(int i=0; i<validUeTestData.length; i++){
			assertEquals(validUeTestData[i], validator.ueTypeTacValidation(validUeTestData[i]));
			assertTrue(validator.getUeTypeTac().contains(validUeTestData[i]));
		}
	}
	
	/**
	 * Test the FailureClass Validation method with valid FailureClass data.			
	 */
	@Test
	public void testFailureClassIsValid() throws Exception {
		assertEquals("0", validator.isFailureClassValid("0"));
		assertEquals("1", validator.isFailureClassValid("1"));
		assertEquals("2", validator.isFailureClassValid("2"));
		assertEquals("3", validator.isFailureClassValid("3"));
		assertEquals("4", validator.isFailureClassValid("4"));
	}
	
	
	/**
	 * Test the FailureClass Validation method with valid FailureClass data.			
	 */
	@Test(expected=Exception.class)
	public void testFailureClassIsInvalid() throws Exception {
 String inValidFailuireClass=  validator.isFailureClassValid("-1");
		inValidFailuireClass = validator.isFailureClassValid(null);
		inValidFailuireClass = validator.isFailureClassValid("25");
		inValidFailuireClass = validator.isFailureClassValid("a");
		inValidFailuireClass = validator.isFailureClassValid("banana");
	}
	
	
	/**
	 * Test the EventId Validation method with valid EVentId data.			
	 */
	@Test
	public void testValidEventidInputs() throws Exception {
		assertEquals("4097", validator.isEventIdValid("4097"));
		assertEquals("4098", validator.isEventIdValid("4098"));
		assertEquals("4125", validator.isEventIdValid("4125"));
		assertEquals("4106", validator.isEventIdValid("4106"));
	}

	
	/**
	 * Test the EventId Validation method with invalid EventId data.			
	 */
	@Test(expected=Exception.class)
	public void testInvalidEventIdInputs() throws Exception {
 String inValidIDs = validator.isEventIdValid("4099");
		inValidIDs = validator.isEventIdValid("4230");
		inValidIDs = validator.isEventIdValid("4555");
		inValidIDs = validator.isEventIdValid("467");
		inValidIDs = validator.isEventIdValid(null);
		inValidIDs = validator.isEventIdValid("apples");
		inValidIDs = validator.isEventIdValid(" 1 ");
	}
	
	/**
	 * Test the CauseCode Validation method with valid CauseCode data.			
	 */
	@Test
	public void testCauseCodeValid() throws Exception {
		for(int i = 0; i< 34;i++){
			String iConvert  = Integer.toString(i);
			assertEquals(iConvert, validator.isCauseCodeValid(iConvert));
		}
	}
	
	/**
	 * Test the CauseCode validation method with invalid CauseCode data.			
	 */
	@Test(expected=Exception.class)
	public void testInvalidCauseCode() throws Exception {
 String inValidCauseCode = validator.isCauseCodeValid(null);
		inValidCauseCode = validator.isCauseCodeValid("-1");
		inValidCauseCode = validator.isCauseCodeValid("34");
		inValidCauseCode = validator.isCauseCodeValid("100");
		inValidCauseCode = validator.isCauseCodeValid("a");
		inValidCauseCode = validator.isCauseCodeValid("apple");
	}
	
	
	/**
	 * Test the Mcc Validation method with valid mcc data.			
	 */
	@Test
	public void testAllValid() throws Exception {
		String validMccTest;
		for(String mccInput : validator.getMcc()){
		validMccTest = validator.isMCCValid(mccInput);
		}
	}
	
	/**
	 * Test the mcc Validation method with invalid mcc data.			
	 */
	@Test(expected=Exception.class)
	public void testNonValidMcc() throws Exception{
		String inValidMccTest = validator.isMCCValid(null);
			   inValidMccTest = validator.isMCCValid("a");
			   inValidMccTest = validator.isMCCValid("23455");
			   inValidMccTest = validator.isMCCValid("");
			   inValidMccTest = validator.isMCCValid("  ");
	}
	
	
	/**
	 * Test the Date Validation method with valid date's.			
	 */
	@Test
	public void testAValidDateFromSpeadSheet(){
		assertTrue(validator.isThisDateValid("11/01/2013  08:15", "dd/M/yyyy HH:mm"));
		assertTrue(validator.isThisDateValid("12/02/2013  13:18", "dd/M/yyyy HH:mm"));
		assertTrue(validator.isThisDateValid("22/03/2013  17:17", "dd/M/yyyy HH:mm"));
		assertTrue(validator.isThisDateValid("18/04/2013  23:05", "dd/M/yyyy HH:mm"));
		assertTrue(validator.isThisDateValid("29/05/2013  01:15", "dd/M/yyyy HH:mm"));
	}
	
	
	/**
	 * Test the time Validation method for null,s.			
	 */
	@Test
	public void testIfTimeIsNull(){
		assertFalse(validator.isThisDateValid(null, "dd/M/yyyy HH:mm"));
	}
 
	/**
	 * Test the datValidation method for date in the past.			
	 */	
	@Test
	public void testThatDateInThePast(){
		assertFalse(validator.isThisDateValid("31/31/1999  23:59:59", "dd/M/yyyy HH:mm:ss"));
		assertTrue(validator.isThisDateValid("01/01/2000  00:00:01", "dd/M/yyyy HH:mm:ss"));
	}
	
}
