package com.group7.service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import com.group7.daoInterface.NetworkDAOLocal;
import com.group7.entities.Network;
import com.group7.serviceInterface.NetworkServiceLocal;

@Stateless	
@Local
public class NetworkService implements NetworkServiceLocal {

	@EJB
	private NetworkDAOLocal dao;
	
	public Collection<Network> getAllNetworkInfo() {
		return dao.getAllNetworkInfo();
	}

}