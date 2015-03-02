package com.group7.serviceInterface;

import java.util.Collection;

import com.group7.entities.BaseData;

public interface BaseDataServiceLocal {

	public Collection<BaseData> getAllBasedata();
	public void addBaseData(BaseData basedata);
	public void putData(Collection<BaseData> bd);
	public Collection<BaseData> getAllEventIdAndCauseId();
	
}