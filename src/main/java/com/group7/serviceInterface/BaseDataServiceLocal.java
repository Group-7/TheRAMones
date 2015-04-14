package com.group7.serviceInterface;

import java.math.BigInteger;
import java.util.Collection;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.group7.entities.BaseData;
import com.group7.entities.BaseDataError;
import com.group7.entities.EventCause;
import com.group7.entities.Failure;
import com.group7.entities.Network;
import com.group7.entities.UE;


@Stateless
@Local
@TransactionManagement(TransactionManagementType.CONTAINER)

public interface BaseDataServiceLocal {

	public Collection<BaseData> getAllBasedata();
	public void addBaseData(BaseData basedata);
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void putData(Collection<BaseData> bd);

	public Collection<Object> getAllEventIdAndCauseId(BigInteger Imsi);
	public Collection<Object> getAllCauseCodeAndDescByIMSI(BigInteger Imsi);
	public Collection<BigInteger> getUniqueAffectedImsi();
	public Collection<BigInteger> getImsiFailureOverTime(String from, String to);
	public Collection<Object> getAllCasueCodeAndEventId(BigInteger imsi);
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void putNetworkData(Collection<Network> networkList);
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void putUEData(Collection<UE> ueList);
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void putEventCauseData(Collection<EventCause> eventCauseList);
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void putFailureData(Collection<Failure>failureList);

	public Collection<Long> getTotalFailuresOfSpecificPhone(String phoneType, String startDate, String endDate);
	public Collection<Long> getTotalFailuresOfSpecificIMSI(BigInteger imsi, String startDate, String endDate);
	public Collection<Object> getAllCallFailuresAndTotalDurationPerIMSI(BigInteger imsi, String startDate, String endDate);
	public Collection<Object> getAllUniqueEventCausecodeCombinations(String model);
	public Collection<BigInteger> getAllPhoneTypes();
	public Collection<String> getAllDistinctPhoneModels();
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public long getLastRowId();
	/**
	 */
	public Collection<BaseData> getTopTenImsiDuringPeriod(String startDate, String endDate);
	Collection<BigInteger> imsiEffectedByAFailureCauseClass(String failureClass);
	Collection<String>getFailureDescriptionForDropDown();
	public void putErrorData(Collection<BaseDataError> bderrors);
	public Collection<BigInteger> getUS11(String string, String string2);



}
