package com.group7.daoInterface;

import java.util.Collection;

import javax.ejb.Local;

import com.group7.entities.TACAccessCapability;

@Local
public interface TACAccessCapabilityDAOI {

	public Collection<TACAccessCapability> getAllTACAccessCapabilities();
}
