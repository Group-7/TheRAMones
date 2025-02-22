package com.group7.service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.group7.dao.UeDAO;
import com.group7.entities.UE;
import com.group7.serviceInterface.UeServiceLocal;

@Stateless
@Local
public class UeServiceEJB implements UeServiceLocal {

	@EJB
	private UeDAO dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<UE> getAllEU() {
		return dao.getEU();
	}

}
