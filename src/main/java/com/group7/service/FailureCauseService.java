package com.group7.service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.group7.daoInterface.FailureCauseDAOInterface;
import com.group7.entities.Failure;
import com.group7.serviceInterface.FailureCauseServiceInterface;

@Stateless
@Local
public class FailureCauseService implements FailureCauseServiceInterface{
	
	@EJB
	private FailureCauseDAOInterface failurecauseinterface;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<Failure> getAllFailureCauses() {
		// TODO Auto-generated method stub
		return failurecauseinterface.getAllFailureCauses();
	}

}
