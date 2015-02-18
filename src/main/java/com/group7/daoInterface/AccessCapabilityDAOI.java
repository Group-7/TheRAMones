package com.group7.daoInterface;

import java.util.Collection;


import javax.ejb.Local;

import com.group7.entities.AccessCapability;

@Local
public interface AccessCapabilityDAOI {

	public Collection<AccessCapability> getAllAccessCapabilities();
}
