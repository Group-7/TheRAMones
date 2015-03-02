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
		// TODO Auto-generated method stub
		
		
		return dao.getAllBaseData();
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void addBaseData(BaseData basedata){
		dao.addBaseData(basedata);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void putData(Collection<BaseData> bd) {
		// TODO Auto-generated method stub
		dao.putData(bd);
	}

	@Override
	public Collection<BigInteger> getImsiFailureOverTime(String dateFrom, String dateTo) {
		// TODO Auto-generated method stub
		return dao.getImsiFailureOverTime(dateFrom,dateTo);
	}
	
}