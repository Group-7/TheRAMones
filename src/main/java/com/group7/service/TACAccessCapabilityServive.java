package com.group7.service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.group7.daoInterface.TACAccessCapabilityDAOI;
import com.group7.entities.TACAccessCapability;
import com.group7.serviceInterface.TACAccessCapabilityServiceI;

@Local
@Stateless
public class TACAccessCapabilityServive implements TACAccessCapabilityServiceI{

	@EJB
	private TACAccessCapabilityDAOI tacAccessCapability;
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Collection<TACAccessCapability> getAllTACAccessCapabilities() {
		return tacAccessCapability.getAllAccessCapabilities();
	}
	
	
	
	
}