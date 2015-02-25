package com.group7.service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import com.group7.dao.NetworkDAO;
import com.group7.entities.Network;
import com.group7.serviceInterface.NetworkServiceLocal;

@Stateless	
@Local
public class NetworkServiceEJB implements NetworkServiceLocal {

	@EJB
	private NetworkDAO dao;
	
	public Collection<Network> getAllNetworkInfo() {
		return dao.getAllNetworkInfo();
	}

}