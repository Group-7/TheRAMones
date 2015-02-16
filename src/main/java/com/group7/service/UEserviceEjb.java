package com.group7.service;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Stateless;

import com.group7.daoInterface.UEdao;
import com.group7.entities.UE;
import com.group7.serviceInterface.UEserviceLocal;

@Stateless
@Local
public class UEserviceEjb implements UEserviceLocal{

	@EJB
	private UEdao dao;
	
	@Override
	public Collection<UE> getEU() {
				
		return dao.getAllEU();
	}
	

}
