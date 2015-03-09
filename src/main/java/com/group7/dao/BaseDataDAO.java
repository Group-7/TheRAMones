package com.group7.dao;

import java.math.BigInteger;
import java.util.Collection;

import com.group7.entities.BaseData;

public interface BaseDataDAO {

	public Collection<BaseData> getAllBaseData();
	public void addBaseData(BaseData basedata);
	public void putData(Collection<BaseData> bd);
	public Collection<Object> getAllCauseCodeAndEventId(BigInteger imsi);
	public Collection<BigInteger> getImsiFailureOverTime(String from, String to);
}