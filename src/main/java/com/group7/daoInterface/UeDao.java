package com.group7.daoInterface;

import java.util.Collection;

import javax.ejb.Local;

import com.group7.entities.UE;

@Local
public interface UeDao {
	Collection<UE> getEU();
}
