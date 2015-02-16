package com.group7.serviceInterface;

import java.util.Collection;

import javax.ejb.Local;

import com.group7.entities.UE;

@Local
public interface UEserviceLocal {
	
	Collection<UE> getEU();
}
