package com.group7.serviceInterface;

import java.util.Collection;

import javax.ejb.Local;
import javax.ejb.Stateless;

import com.group7.entities.BaseData;
@Stateless
@Local
public interface BaseDataServiceLocal {

	public Collection<BaseData> getAllBasedata();
	public void addBaseData(BaseData basedata);
	public void putData(Collection<BaseData> bd);
}