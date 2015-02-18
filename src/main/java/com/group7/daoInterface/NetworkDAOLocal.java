package com.group7.daoInterface;

import java.util.Collection;

import javax.ejb.Local;

import com.group7.entities.Network;

@Local
public interface NetworkDAOLocal {
	
	Collection<Network> getAllNetworkInfo();

}