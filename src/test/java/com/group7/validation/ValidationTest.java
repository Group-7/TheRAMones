package com.group7.validation;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import com.group7.importBaseData.BaseDataValidation;

/**
 * Tests if the validation methods for validating the baseData are correctly
 * functioning. Test cases are deployed for valid data as for invalid data.
 * 
 */
public class ValidationTest {

	private BaseDataValidation validator;

	@Before
	public void init() {
		validator = BaseDataValidation.getInstance();
		fillSets();
	}

	/**
	 * Method to test that the method mncValiation is working
	 * 
	 * @throws Exception
	 */
	@Test
	public void testMNC() throws Exception {
		assertEquals("1", validator.mncValidation("1"));
		assertEquals("580", validator.mncValidation("580"));
		assertEquals("10", validator.mncValidation("10"));
		assertEquals("68", validator.mncValidation("68"));
		assertEquals("930", validator.mncValidation("930"));
		assertThat("1000", not(validator.mncValidation("1")));
		assertThat("41", not(validator.mncValidation("580")));

	}

	/** 
	 * Test the mnc Validation method on INVALID mnc data.
	 * 
	 * @throws Exception
	 */
	@Test(expected = Exception.class)
	public void testMncValidation() throws Exception {
		assertEquals("1", validator.mncValidation(null));
		assertEquals("1", validator.mncValidation(""));
		assertEquals("1", validator.mncValidation("apples"));

	}

	/**
	 * A method to test that cellIdValidation() is working
	 * 
	 */
	@Test
	public void testCellIdValidation() throws Exception {
		assertEquals("0", validator.cellIdValidation("0"));
		assertEquals("1000", validator.cellIdValidation("1000"));
		assertEquals("10", validator.cellIdValidation("10"));
		assertEquals("550", validator.cellIdValidation("550"));
		assertEquals("763", validator.cellIdValidation("763"));
		assertThat("1000", not(validator.cellIdValidation("1001")));
		assertThat("300", not(validator.cellIdValidation("23")));
		assertThat("590", not(validator.cellIdValidation("650")));
	}

	/**
	 * A method to test cellId on INVALID cell data info
	 */
	@Test(expected = Exception.class)
	public void testInvaldCellId() throws Exception {
		assertEquals("1000", validator.cellIdValidation("-1"));
		assertEquals("1000", validator.cellIdValidation(null));
		assertEquals("1000", validator.cellIdValidation(" "));
		assertEquals("1000", validator.cellIdValidation("apples"));
	}

	/**
	 * A method to test that durationValidation() is working
	 * 
	 */
	@Test
	public void testDurationValidation() throws Exception {
		assertEquals("0", validator.durationValidation("0"));
		assertEquals("50", validator.durationValidation("50"));
		assertEquals("246", validator.durationValidation("246"));
		assertEquals("1150", validator.durationValidation("1150"));
		assertEquals("2200", validator.durationValidation("2200"));
	}

	/**
	 * A method to test Duration with Invalid Information
	 */
	@Test(expected = Exception.class)
	public void testDurationInvalid() throws Exception {
		assertEquals("0", validator.durationValidation("-1"));
		assertEquals("0", validator.durationValidation(null));
		assertEquals("0", validator.durationValidation(" "));
		assertEquals("0", validator.durationValidation(" apples "));
	}

	/**
	 * A method to test imsiValidation(String)
	 */
	@Test
	public void testImsiValiation() throws Exception {
		assertEquals("123456789012345",
				validator.imsiValidation("123456789012345"));
		assertEquals("310560000000012",
				validator.imsiValidation("310560000000012"));
		assertEquals("344930000000011",
				validator.imsiValidation("344930000000011"));
		assertEquals("240210000000013",
				validator.imsiValidation("240210000000013"));
	}

	/**
	 * A method to test imsiValidation(String) with Invalid Information
	 */
	@Test(expected = Exception.class)
	public void testimsiinvalidValidation() throws Exception {
		assertEquals("", validator.imsiValidation(null));
		assertEquals("", validator.imsiValidation("12"));
		assertEquals("", validator.imsiValidation("1234"));
		assertEquals("", validator.imsiValidation("123456"));
		assertEquals("", validator.imsiValidation("1234678"));
		assertEquals("12345678901234",
				validator.imsiValidation("12345678901234"));
		assertEquals("1234567890123456",
				validator.imsiValidation("1234567890123456"));
	}

	@Test
	public void testAValidDateFromSpeadSheet() {
		assertTrue(validator.isThisDateValid("11/01/2013  08:15",
				"dd/M/yyyy HH:mm"));
		assertTrue(validator.isThisDateValid("12/02/2013  13:18",
				"dd/M/yyyy HH:mm"));
		assertTrue(validator.isThisDateValid("22/03/2013  17:17",
				"dd/M/yyyy HH:mm"));
		assertTrue(validator.isThisDateValid("18/04/2013  23:05",
				"dd/M/yyyy HH:mm"));
		assertTrue(validator.isThisDateValid("29/05/2013  01:15",
				"dd/M/yyyy HH:mm"));
	}

	@Test
	public void testIfTimeIsNull() {
		assertFalse(validator.isThisDateValid(null, "dd/M/yyyy HH:mm"));
		assertFalse(validator.isThisDateValid("111/01/2013  17:30:00",
				"dd/M/yyyy HH:mm"));
		assertFalse(validator.isThisDateValid("-10/01/2013  17:30:00",
				"dd/M/yyyy HH:mm"));
		assertFalse(validator.isThisDateValid("10/00/2013  17:30:00",
				"dd/M/yyyy HH:mm"));
		assertFalse(validator.isThisDateValid("10/13/2013  17:30:00",
				"dd/M/yyyy HH:mm"));
		assertFalse(validator.isThisDateValid("10/13/2013  25:30:00",
				"dd/M/yyyy HH:mm"));
		assertFalse(validator.isThisDateValid("10/13/2013  -12:30:00",
				"dd/M/yyyy HH:mm"));
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
	 * A method to test for Invalid event id information
	 * 
	 * @throws Exception
	 */
	@Test(expected = Exception.class)
	public void testInvalidEventIdInputs() throws Exception {
		assertEquals("1", validator.isEventIdValid("4099"));
		assertEquals("2", validator.isEventIdValid("4230"));
		assertEquals("3", validator.isEventIdValid("4555"));
		assertEquals("4", validator.isEventIdValid("467"));
		assertEquals("5", validator.isEventIdValid(null));
		assertEquals("6", validator.isEventIdValid("apples"));
		assertEquals("7", validator.isEventIdValid(" 1 "));
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
	@Test(expected = Exception.class)
	public void testFailureClassIsInvalid() throws Exception {
		assertEquals("", validator.isFailureClassValid("-1"));
		assertEquals("", validator.isFailureClassValid(null));
		assertEquals("", validator.isFailureClassValid("25"));
		assertEquals("", validator.isFailureClassValid("a"));
		assertEquals("", validator.isFailureClassValid("banana"));
	}

	/**
	 * Test the Mcc Validation method with valid mcc data.
	 */
	@Test
	public void testMccValidation() throws Exception {
		assertEquals("238", validator.isMCCValid("238"));
		assertEquals("240", validator.isMCCValid("240"));
		assertEquals("302", validator.isMCCValid("302"));
		assertEquals("310", validator.isMCCValid("310"));
		assertEquals("440", validator.isMCCValid("440"));
	}

	/**
	 * A method to test invalid mcc data
	 */
	@Test(expected = Exception.class)
	public void testNonValidMcc() throws Exception {
		assertEquals("238", validator.isMCCValid(null));
		assertEquals("238", validator.isMCCValid("a"));
		assertEquals("238", validator.isMCCValid("23455"));
		assertEquals("238", validator.isMCCValid(""));
		assertEquals("238", validator.isMCCValid("  "));
	}

	/**
	 * Test the CauseCode Validation method with valid CauseCode data.
	 */
	@Test
	public void testCauseCodeValid() throws Exception {
		assertEquals("0", validator.isCauseCodeValid("0"));
		assertEquals("5", validator.isCauseCodeValid("5"));
		assertEquals("12", validator.isCauseCodeValid("12"));
		assertEquals("23", validator.isCauseCodeValid("23"));
		assertEquals("28", validator.isCauseCodeValid("28"));
		assertEquals("33", validator.isCauseCodeValid("33"));
	}

	/**
	 * A method to test Invalid CauseCode data
	 */
	@Test(expected = Exception.class)
	public void testInvalidCauseCode() throws Exception {
		assertEquals("0", validator.isCauseCodeValid(null));
		assertEquals("0", validator.isCauseCodeValid("-1"));
		assertEquals("0", validator.isCauseCodeValid("34"));
		assertEquals("0", validator.isCauseCodeValid("100"));
		assertEquals("0", validator.isCauseCodeValid("a"));
		assertEquals("0", validator.isCauseCodeValid("apple"));
	}

	/**
	 * A method to test valid TAC data
	 */
	@Test
	public void testTACData() throws Exception {
		assertEquals("100100", validator.ueTypeTacValidation("100100"));
		assertEquals("103200", validator.ueTypeTacValidation("103200"));
		assertEquals("21060800", validator.ueTypeTacValidation("21060800"));
		assertEquals("107900", validator.ueTypeTacValidation("107900"));
		assertEquals("33001235", validator.ueTypeTacValidation("33001235"));
		assertEquals("33002535", validator.ueTypeTacValidation("33002535"));
	}

	/**
	 * A method to test Invalid TAC data
	 */
	@Test(expected = Exception.class)
	public void testInvalidTACData() throws Exception {
		assertEquals("0", validator.ueTypeTacValidation(null));
		assertEquals("0", validator.ueTypeTacValidation("21064546"));
		assertEquals("0", validator.ueTypeTacValidation("-21060800"));
		assertEquals("0", validator.ueTypeTacValidation("dummy"));
		assertEquals("0", validator.ueTypeTacValidation("0"));
	}

	/**
	 * A method to test neVersionValidation()
	 * 
	 * @throws Exception
	 */
	@Test
	public void testNeVersionValidation() throws Exception {
		assertEquals("11B", validator.neVersionValidation("11B"));
		assertEquals("12B", validator.neVersionValidation("12B"));
		assertEquals("13A", validator.neVersionValidation("13A"));
	}

	/**
	 * A method to test validateCompositeKeysInNetwork(String)
	 */
	@Test
	public void testNetworkCompostieKeys() throws Exception{
		assertTrue(validator.validateCompositeKeysInNetwork("2381"));
		assertTrue(validator.validateCompositeKeysInNetwork("240580"));
		assertTrue(validator.validateCompositeKeysInNetwork("30210"));
		assertTrue(validator.validateCompositeKeysInNetwork("31068"));
		assertTrue(validator.validateCompositeKeysInNetwork("340930"));
	}
	
	/**
	 * A method to test invalid data for validateCompositeKeysInNetwork
	 */
	@Test(expected = Exception.class)
	public void testNetworkInvalidCompostieKeys() throws Exception{
		assertTrue(validator.validateCompositeKeysInNetwork(null));
		assertTrue(validator.validateCompositeKeysInNetwork("apples"));
		assertTrue(validator.validateCompositeKeysInNetwork("000000"));
	}
	
	/**
	 * A method to test validateCompositeInEventCause(String)
	 */
	@Test
	public void testEventCauseCompostieKeys() throws Exception{
		assertTrue(validator.validateCompositeInEventCause("40970"));
		assertTrue(validator.validateCompositeInEventCause("40985"));
		assertTrue(validator.validateCompositeInEventCause("412512"));
		assertTrue(validator.validateCompositeInEventCause("410623"));
	}
	
	/**
	 * A method to test invalid data for validateCompositeInEventCause(String)
	 */
	@Test (expected = Exception.class)
	public void testEventCauseInvalidCompositeKeys() throws Exception{
		assertTrue(validator.validateCompositeInEventCause(null));
		assertTrue(validator.validateCompositeInEventCause("apples"));
		assertTrue(validator.validateCompositeInEventCause("000000"));
	}
	
	// /=====================================
	/**
	 * Method to fill the ArrayLists
	 */
	private void fillSets() {
		Set<String> mncTestList = new HashSet<>();
		Set<String> eventIdTestList = new HashSet<>();
		Set<String> failureListTest = new HashSet<>();
		Set<String> mccListTest = new HashSet<>();
		Set<String> causeCodeTestList = new HashSet<>();
		Set<String> tacTestList = new HashSet<>();
		Set<String> networkCompositeKeys = new HashSet<>();
		Set<String> eventCauseCompositeKeys = new HashSet<>();

		mncTestList.add("1");
		mncTestList.add("580");
		mncTestList.add("10");
		mncTestList.add("68");
		mncTestList.add("930");

		validator.setMnc(mncTestList);
		// eventId
		eventIdTestList.add("4097");
		eventIdTestList.add("4098");
		eventIdTestList.add("4125");
		eventIdTestList.add("4106");
		validator.setEventId(eventIdTestList);
		// failure List
		failureListTest.add("0");
		failureListTest.add("1");
		failureListTest.add("2");
		failureListTest.add("3");
		failureListTest.add("4");
		validator.setFailureList(failureListTest);
		mccListTest.add("238");
		mccListTest.add("240");
		mccListTest.add("302");
		mccListTest.add("310");
		mccListTest.add("440");
		validator.setMcc(mccListTest);
		causeCodeTestList.add("0");
		causeCodeTestList.add("5");
		causeCodeTestList.add("12");
		causeCodeTestList.add("23");
		causeCodeTestList.add("28");
		causeCodeTestList.add("33");
		validator.setCauseCode(causeCodeTestList);
		tacTestList.add("100100");
		tacTestList.add("103200");
		tacTestList.add("21060800");
		tacTestList.add("107900");
		tacTestList.add("33001235");
		tacTestList.add("33002535");
		validator.setUeTypeTac(tacTestList);
		networkCompositeKeys.add("2381");
		networkCompositeKeys.add("240580");
		networkCompositeKeys.add("30210");
		networkCompositeKeys.add("31068");
		networkCompositeKeys.add("340930");
		validator.setNetworkCompositeKeys(networkCompositeKeys);
		eventCauseCompositeKeys.add("40970");
		eventCauseCompositeKeys.add("40985");
		eventCauseCompositeKeys.add("412512");
		eventCauseCompositeKeys.add("410623");
		validator.setEventCauseCompositeKeys(eventCauseCompositeKeys);
		
		
	}
	// Test the mnc Validation method on invalid mnc data.
	// @throws Exception
	/*
	 * @Test(expected=Exception.class) public void testMncValidation() throws
	 * Exception { String[] inValidMncTestData = new String[]{"-0", "-1",
	 * "-777", "null", "dummy", "69", null, "-25599"};
	 * 
	 * 
	 * 
	 * for(int j=0; j<inValidMncTestData.length; j++){ String inValidMncTest =
	 * validator.mncValidation(inValidMncTestData[j]); } }
	 */

}
/*
 * //** Test the mnc Validation method on valid mnc data.
 * 
 * @throws Exception
 *//*
	 * @Test public void ValidMncValidationTest() throws Exception{ String[]
	 * validMncTestData = new String[]{"0"};
	 * 
	 * for(int i=0; i<validMncTestData.length; i++){
	 * assertEquals(validMncTestData[i],
	 * validator.mncValidation(validMncTestData[i])); List<String> mncs = new
	 * ArrayList<>(); mncs.add("0");
	 * assertTrue(mncs.contains(validMncTestData[i])); } }
	 *//**
 * Test the cellId Validation method with invalid cellId data.
 * 
 * @throws Exception
 */
/*
 * @Test(expected=Exception.class) public void invalidCellIdValidationTest()
 * throws Exception { String[] inValidCellIdTestData = new String[]{"-0", "-1",
 * "-777", "null", "dummy", "69", null, "-25599"};
 * 
 * for(int j=0; j<inValidCellIdTestData.length; j++){ String inValidCellIdTest =
 * validator.cellIdValidation(inValidCellIdTestData[j]); } }
 *//**
 * Test the cellId Validation method with valid cellId data.
 */
/*
 * @Test public void validCellIdValidationTest() throws Exception { String[]
 * validCellIdTestData = new String[]{"4", "5", "3842"};
 * 
 * for(int i=0; i<validCellIdTestData.length; i++){
 * assertEquals(validCellIdTestData[i],
 * validator.cellIdValidation(validCellIdTestData[i])); List<String> cellIds =
 * validator.getCellId(); assertTrue(cellIds.contains(validCellIdTestData[i]));
 * 
 * } }
 *//**
 * Test the duration Validation method with invalid duration data.
 * 
 * @throws Exception
 */
/*
 * @Test(expected=Exception.class) public void invalidDurationValidationTest()
 * throws Exception { String[] inValidDurationTestData = new String[]{"-0",
 * "-1", "-777", "null", "dummy", "69", null, "-25599"};
 * 
 * for(int j=0; j<inValidDurationTestData.length; j++){ String
 * inValidDurationTest =
 * validator.durationValidation(inValidDurationTestData[j]); } }
 *//**
 * Test the duration Validation method with valid data.
 */
/*
 * @Test public void ValidDurationValidationTest() throws Exception { String[]
 * validDurationTestData = new String[]{"1000"};
 * 
 * for(int i=0; i<validDurationTestData.length; i++){
 * assertEquals(validDurationTestData[i],
 * validator.durationValidation(validDurationTestData[i]));
 * //assertTrue(validator.getRefDuration().contains(validDurationTestData[i]));
 * } }
 *//**
 * Test the ismi Validation method with invalid ismi data. (15 digit length)
 * 
 * @throws Exception
 */
/*
 * @Test(expected=Exception.class) public void invalidImsiValidationTest()
 * throws Exception { String[] inValidImsiTestData = new
 * String[]{"99098765423452", "77863542345678", "-7779876542432234", "null",
 * "dummy", "69", null};
 * 
 * for(int j=0; j<inValidImsiTestData.length; j++){ String inValidIsmiTest =
 * validator.imsiValidation(inValidImsiTestData[j]); } }
 *//**
 * Test the ismi Validation method with valid ismi data. (15 digit length)
 */
/*
 * @Test public void testImsiValidation() throws Exception { String[]
 * validImsiTestData = new String[]{"176598763454267"};
 * 
 * for(int i=0; i<validImsiTestData.length; i++){
 * assertEquals(validImsiTestData[i],
 * validator.imsiValidation(validImsiTestData[i])); } }
 *//**
 * Test the NE Validation method with invalid NE data.
 * 
 * @throws Exception
 */
/*
 * @Test(expected=Exception.class) public void invalidNeValidationTest() throws
 * Exception { String[] inValidNeTestData = new String[]{"14D", "-18U",
 * "777366", "null", "dummy", "69", null};
 * 
 * for(int j=0; j<inValidNeTestData.length; j++){ String inValidNeTest =
 * validator.neVersionValidation(inValidNeTestData[j]); } }
 *//**
 * Test the NE Validation method with valid NE data.
 */
/*
 * public void validNeValidationTest() throws Exception { String[]
 * validNeTestData = new String[]{"11B", "12A"};
 * 
 * for(int i=0; i<validNeTestData.length; i++){ assertEquals(validNeTestData[i],
 * validator.neVersionValidation(validNeTestData[i])); } }
 *//**
 * Test the UE Validation method with invalid UE data.
 * 
 * @throws Exception
 */
/*
 * @Test(expected=Exception.class) public void invalidUeValidationTest() throws
 * Exception { String[] inValidUeTestData = new String[]{"21064546",
 * "-21060800", "0", "null", "dummy", "-0", null};
 * 
 * for(int j=0; j<inValidUeTestData.length; j++){ String inValidUeTest =
 * validator.ueTypeTacValidation(inValidUeTestData[j]); } }
 *//**
 * Test the UE Validation method with valid UE data.
 */
/*
 * public void validUeValidationTest() throws Exception { String[]
 * validUeTestData = new String[]{"21060800", "33000153", "33000253"};
 * 
 * for(int i=0; i<validUeTestData.length; i++){ assertEquals(validUeTestData[i],
 * validator.ueTypeTacValidation(validUeTestData[i]));
 * assertTrue(validator.getUeTypeTac().contains(validUeTestData[i])); } }
 *//**
 * Test the FailureClass Validation method with valid FailureClass data.
 */
/*
 * @Test public void testFailureClassIsValid() throws Exception {
 * assertEquals("0", validator.isFailureClassValid("0")); assertEquals("1",
 * validator.isFailureClassValid("1")); assertEquals("2",
 * validator.isFailureClassValid("2")); assertEquals("3",
 * validator.isFailureClassValid("3")); assertEquals("4",
 * validator.isFailureClassValid("4")); }
 *//**
 * Test the FailureClass Validation method with valid FailureClass data.
 */
/*
 * @Test(expected=Exception.class) public void testFailureClassIsInvalid()
 * throws Exception { String inValidFailuireClass=
 * validator.isFailureClassValid("-1"); inValidFailuireClass =
 * validator.isFailureClassValid(null); inValidFailuireClass =
 * validator.isFailureClassValid("25"); inValidFailuireClass =
 * validator.isFailureClassValid("a"); inValidFailuireClass =
 * validator.isFailureClassValid("banana"); }
 *//**
 * Test the EventId Validation method with valid EVentId data.
 */
/*
 * @Test public void testValidEventidInputs() throws Exception {
 * assertEquals("4097", validator.isEventIdValid("4097")); assertEquals("4098",
 * validator.isEventIdValid("4098")); assertEquals("4125",
 * validator.isEventIdValid("4125")); assertEquals("4106",
 * validator.isEventIdValid("4106")); }
 *//**
 * Test the EventId Validation method with invalid EventId data.
 */
/*
 * @Test(expected=Exception.class) public void testInvalidEventIdInputs() throws
 * Exception { String inValidIDs = validator.isEventIdValid("4099"); inValidIDs
 * = validator.isEventIdValid("4230"); inValidIDs =
 * validator.isEventIdValid("4555"); inValidIDs =
 * validator.isEventIdValid("467"); inValidIDs = validator.isEventIdValid(null);
 * inValidIDs = validator.isEventIdValid("apples"); inValidIDs =
 * validator.isEventIdValid(" 1 "); }
 *//**
 * Test the CauseCode Validation method with valid CauseCode data.
 */
/*
 * @Test public void testCauseCodeValid() throws Exception { for(int i = 0; i<
 * 34;i++){ String iConvert = Integer.toString(i); assertEquals(iConvert,
 * validator.isCauseCodeValid(iConvert)); } }
 *//**
 * Test the CauseCode validation method with invalid CauseCode data.
 */
/*
 * @Test(expected=Exception.class) public void testInvalidCauseCode() throws
 * Exception { String inValidCauseCode = validator.isCauseCodeValid(null);
 * inValidCauseCode = validator.isCauseCodeValid("-1"); inValidCauseCode =
 * validator.isCauseCodeValid("34"); inValidCauseCode =
 * validator.isCauseCodeValid("100"); inValidCauseCode =
 * validator.isCauseCodeValid("a"); inValidCauseCode =
 * validator.isCauseCodeValid("apple"); }
 *//**
 * Test the Mcc Validation method with valid mcc data.
 */
/*
 * @Test public void testAllValid() throws Exception { String validMccTest;
 * for(String mccInput : validator.getMnc()){ validMccTest =
 * validator.isMCCValid(mccInput); } }
 *//**
 * Test the mcc Validation method with invalid mcc data.
 */
/*
 * @Test(expected=Exception.class) public void testNonValidMcc() throws
 * Exception{ String inValidMccTest = validator.isMCCValid(null); inValidMccTest
 * = validator.isMCCValid("a"); inValidMccTest = validator.isMCCValid("23455");
 * inValidMccTest = validator.isMCCValid(""); inValidMccTest =
 * validator.isMCCValid("  "); }
 * 
 * 
 * // Test the Date Validation method with valid date's.
 * 
 * @Test public void testAValidDateFromSpeadSheet(){
 * assertTrue(validator.isThisDateValid("11/01/2013  08:15",
 * "dd/M/yyyy HH:mm"));
 * assertTrue(validator.isThisDateValid("12/02/2013  13:18",
 * "dd/M/yyyy HH:mm"));
 * assertTrue(validator.isThisDateValid("22/03/2013  17:17",
 * "dd/M/yyyy HH:mm"));
 * assertTrue(validator.isThisDateValid("18/04/2013  23:05",
 * "dd/M/yyyy HH:mm"));
 * assertTrue(validator.isThisDateValid("29/05/2013  01:15",
 * "dd/M/yyyy HH:mm")); }
 * 
 * 
 * 
 * // Test the time Validation method for null,s.
 * 
 * @Test public void testIfTimeIsNull(){
 * assertFalse(validator.isThisDateValid(null, "dd/M/yyyy HH:mm")); }
 *//**
 * Test the datValidation method for date in the past.
 */
/*
 * @Test public void testThatDateInThePast(){
 * assertFalse(validator.isThisDateValid("31/31/1999  23:59:59",
 * "dd/M/yyyy HH:mm:ss"));
 * assertTrue(validator.isThisDateValid("01/01/2000  00:00:01",
 * "dd/M/yyyy HH:mm:ss")); }
 * 
 * }
 */