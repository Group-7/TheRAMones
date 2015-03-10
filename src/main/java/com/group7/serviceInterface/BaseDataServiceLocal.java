package com.group7.serviceInterface;

import java.math.BigInteger;
import java.util.Collection;

import javax.ejb.Local;
import javax.ejb.Stateless;

import com.group7.entities.BaseData;


public interface BaseDataServiceLocal {

	public Collection<BaseData> getAllBasedata();
	public void addBaseData(BaseData basedata);
	public void putData(Collection<BaseData> bd);
	public Collection<Object> getAllEventIdAndCauseId(BigInteger Imsi);
	public Collection<BigInteger> getUniqueAffectedImsi();
	public Collection<BigInteger> getImsiFailureOverTime(String from, String to);
	public Collection<Object> getAllCasueCodeAndEventId(BigInteger imsi);
}