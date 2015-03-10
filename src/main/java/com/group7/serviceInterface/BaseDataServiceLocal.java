package com.group7.serviceInterface;

import java.math.BigInteger;
import java.util.Collection;

import com.group7.entities.BaseData;

public interface BaseDataServiceLocal {

	public Collection<BaseData> getAllBasedata();
	public void addBaseData(BaseData basedata);
	public void putData(Collection<BaseData> bd);
	public Collection<Long> getTotalFailuresOfSpecificPhone(BigInteger phoneType, String startDate, String endDate);
	public Collection<Long> getTotalFailuresOfSpecificIMSI(BigInteger imsi, String startDate, String endDate);
	public Collection<Object> getAllCallFailuresAndTotalDurationPerIMSI(BigInteger imsi, String startDate, String endDate);
	public Collection<Object> getAllUniqueEventCausecodeCombinations(String model);
}