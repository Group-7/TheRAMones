package com.group7.dao;

import java.util.Collection;

import javax.ejb.Local;

import com.group7.entities.UE;

@Local
public interface UeDAO {
	Collection<UE> getEU();
}
