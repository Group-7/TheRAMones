package com.group7.daoInterface;

import java.util.Collection;

import javax.ejb.Local;

import com.group7.entities.TacAccessCapability;

@Local
public interface TacAccessCapabilityDao {
	Collection<TacAccessCapability> getTacAccessCapability();
}
