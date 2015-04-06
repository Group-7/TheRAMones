package com.group7.dao;

import java.math.BigInteger;
import java.util.Collection;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.group7.entities.BaseData;
import com.group7.entities.EventCause;
import com.group7.entities.Failure;
import com.group7.entities.Network;
import com.group7.entities.UE;

@Local
@Stateless
public interface BaseDataDAO {

	public Collection<BaseData> getAllBaseData();
	public void addBaseData(BaseData basedata);
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void putData(Collection<BaseData> bd);
	public Collection<Object> getAllCauseCodeAndEventIdByIMSI(BigInteger Imsi);
	public Collection<BigInteger> getUniqueAffectedImsi();
	public Collection<BigInteger> getImsiFailureOverTime(String from, String to);
	public void putNetworkData(Collection<Network> networkData);
	public void putUEData(Collection<UE> ueData);
	public void putEventCauseData(Collection<EventCause> eventCauseData);
	public void putFailureData(Collection<Failure> failureData);
	public Collection<Long> getTotalFailuresOfSpecificPhone(int phoneType, String startDate, String endDate);
	public Collection<Long> getTotalFailuresOfSpecificIMSI(BigInteger imsi, String startDate, String endDate);
	public Collection<Object> getAllCallFailuresAndTotalDurationPerIMSI(BigInteger imsi, String startDate, String endDate);
	public Collection<Object> getAllUniqueEventCausecodeCombinations(String model);
	public Collection<BigInteger> getAllPhoneTypes();
	public Collection<String> getAllDistinctPhoneModels();
	public long getLastRowId();
	public Collection<BaseData> getTopTenImsiDuringPeriod(String startDate, String endDate);
	Collection<BaseData> imsiEffectedByAFailureCauseClass(int failureClass);


}