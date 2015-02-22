package com.group7.serviceInterface;

import java.util.Collection;

import javax.ejb.Local;

import com.group7.entities.Network;

@Local
public interface NetworkServiceLocal {
	
	Collection<Network> getAllNetworkInfo();
}