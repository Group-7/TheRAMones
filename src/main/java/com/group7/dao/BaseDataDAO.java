package com.group7.dao;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Date;

import com.group7.entities.BaseData;

public interface BaseDataDAO {

	public Collection<BaseData> getAllBaseData();
	public void addBaseData(BaseData basedata);
	public void putData(Collection<BaseData> bd);
	public Collection<Long> getTotalFailuresOfSpecificPhone(BigInteger phoneType, String startDate, String endDate);
	public Collection<Long> getTotalFailuresOfSpecificIMSI(BigInteger imsi, String startDate, String endDate);
	public Collection<Object> getAllCallFailuresAndTotalDurationPerIMSI(BigInteger imsi, String startDate, String endDate);
	public Collection<Object> getAllUniqueEventCausecodeCombinations(String model);
	public Collection<BigInteger> getUniqueAffectedImsi();
	public Collection<BigInteger> getAllPhoneTypes();
	public Collection<String> getAllDistinctPhoneModels();
	
}