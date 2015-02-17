package com.group7.service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.group7.daoInterface.AccessCapabilityDao;
import com.group7.entities.AccessCapability;
import com.group7.serviceInterface.AccessCapabilityService;

@Stateless
@Local
public class AccessCapabilityEjb implements AccessCapabilityService {

	@EJB
	private AccessCapabilityDao dao;

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<AccessCapability> getAllAccessCapability() {
		return dao.getAccessCapability();
	}

}
