package com.group7.serviceInterface;

import java.util.Collection;

import javax.ejb.Local;

import com.group7.entities.TACAccessCapability;

@Local
public interface TACAccessCapabilityServiceI {
	
	Collection<TACAccessCapability> getAllTACAccessCapabilities();
}
