package com.group7.serviceInterface;

import java.util.Collection;

import com.group7.entities.BaseData;

public interface BaseDataService {

	public Collection<BaseData> getAllBasedata();
	public void addBaseData(BaseData basedata);
	public void putData(Collection<BaseData> bd);
}