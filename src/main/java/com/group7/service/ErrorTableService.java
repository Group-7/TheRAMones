package com.group7.service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.group7.daoInterface.ErrorTableDAOInterface;
import com.group7.entities.ErrorTable;
import com.group7.serviceInterface.ErrorTableServiceInterface;

@Local
@Stateless
public class ErrorTableService implements ErrorTableServiceInterface {

	@EJB
	private ErrorTableDAOInterface etdi;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<ErrorTable> getAllErrorRecords() {
		return etdi.getAllErrorRecords();

	}

}
