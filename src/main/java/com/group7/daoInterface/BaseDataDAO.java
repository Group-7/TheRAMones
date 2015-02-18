package com.group7.daoInterface;

import java.util.Collection;

import com.group7.entities.BaseData;

public interface BaseDataDAO {

	public Collection<BaseData> getAllBaseData();
	public void addBaseData(BaseData basedata);
}
