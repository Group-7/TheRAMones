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
	
	
	public Collection<Long> getTotalFailuresOfSpecificPhone(BigInteger phoneType, 
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
	
}