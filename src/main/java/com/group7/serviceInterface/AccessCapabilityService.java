package com.group7.serviceInterface;

import java.util.Collection;

import javax.ejb.Local;

import com.group7.entities.AccessCapability;

@Local
public interface AccessCapabilityService {
	Collection<AccessCapability> getAllAccessCapability();
}
