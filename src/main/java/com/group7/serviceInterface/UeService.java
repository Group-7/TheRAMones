package com.group7.serviceInterface;

import java.util.Collection;

import javax.ejb.Local;

import com.group7.entities.UE;

@Local
public interface UeService {
	
	Collection<UE> getAllEU();
}
