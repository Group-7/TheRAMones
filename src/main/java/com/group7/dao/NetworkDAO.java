package com.group7.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.group7.entities.Network;

@Local
public interface NetworkDAO {
	
	Collection<Network> getAllNetworkInfo();

}