package com.group7.service;

import java.math.BigInteger;
import java.util.Collection;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;

import com.group7.dao.BaseDataDAO;
import com.group7.entities.BaseData;
import com.group7.entities.EventCause;
import com.group7.entities.Failure;
import com.group7.entities.Network;
import com.group7.entities.UE;
import com.group7.serviceInterface.BaseDataServiceLocal;


@Stateless
@Local
@TransactionManagement(TransactionManagementType.CONTAINER)
public class BaseDataServiceEJB implements BaseDataServiceLocal {

	@Inject
	private BaseDataDAO dao;

	public Collection<BaseData> getAllBasedata() {

		return dao.getAllBaseData();
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void addBaseData(BaseData basedata){
		dao.addBaseData(basedata);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void putData(Collection<BaseData> bd) {
		dao.putData(bd);
	}

	@Override
	public Collection<BigInteger> getImsiFailureOverTime(String from, String to) {
		// TODO Auto-generated method stub
		return dao.getImsiFailureOverTime(from,to);
	}

	/*@Override
	public Collection<Object> getAllCasueCodeAndEventId(BigInteger imsi) {
		// TODO Auto-generated method stub
		return dao.getAllCauseCodeAndEventIdByIMSI(imsi);
	}*/
	
	

	//The TransactionAttribute annotation specifies whether the container is to invoke a business method within 
    //a transaction context. The TransactionAttribute annotation can be used for session beans and message driven beans. 
	//It can only be specified if container managed transaction demarcation is used. 
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<Object> getAllEventIdAndCauseId(BigInteger Imsi) {
		return dao.getAllCauseCodeAndEventIdByIMSI( Imsi);
	}

	@Override
	public Collection<BigInteger> getUniqueAffectedImsi() {
		// TODO Auto-generated method stub
		return dao.getUniqueAffectedImsi();
	}

	@Override
	public void putNetworkData(Collection<Network> networkList) {
		dao.putNetworkData(networkList);
		
	}

	@Override
	public void putUEData(Collection<UE> ueList) {
		dao.putUEData(ueList);
		
	}

	@Override
	public void putEventCauseData(Collection<EventCause> eventCauseList) {
		dao.putEventCauseData(eventCauseList);
		
	}

	@Override
	public void putFailureData(Collection<Failure> failureList) {
		dao.putFailureData(failureList);
		
	}
	


	public Collection<Long> getTotalFailuresOfSpecificPhone(int phoneType, 
			String startDate, String endDate) {
		
		return dao.getTotalFailuresOfSpecificPhone(phoneType, startDate, endDate);
	}

	
	
	public Collection<Long> getTotalFailuresOfSpecificIMSI(BigInteger imsi,
			String startDate, String endDate) {
		
		return dao.getTotalFailuresOfSpecificIMSI(imsi, startDate, endDate);
	}


	public Collection<Object> getAllCallFailuresAndTotalDurationPerIMSI(
			BigInteger imsi, String startDate, String endDate) {
		// 
		return dao.getAllCallFailuresAndTotalDurationPerIMSI(imsi, startDate, endDate);
	}
	
	public Collection<Object> getAllUniqueEventCausecodeCombinations(String model){
		return dao.getAllUniqueEventCausecodeCombinations(model);
	}
	
	public Collection<BigInteger> getAllPhoneTypes(){
		return dao.getAllPhoneTypes();
	}
	public Collection<String> getAllDistinctPhoneModels(){
		return dao.getAllDistinctPhoneModels();
	}
}

