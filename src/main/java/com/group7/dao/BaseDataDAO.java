package com.group7.dao;

import java.util.Collection;

import com.group7.entities.BaseData;
import com.group7.entities.EventCause;
import com.group7.entities.Failure;
import com.group7.entities.Network;
import com.group7.entities.UE;

public interface BaseDataDAO {

	public Collection<BaseData> getAllBaseData();
	public void addBaseData(BaseData basedata);
	public void putData(Collection<BaseData> bd);
	public void putNetworkData(Collection<Network> networkData);
	public void putUEData(Collection<UE> ueData);
	public void putEventCauseData(Collection<EventCause> eventCauseData);
	public void putFailureData(Collection<Failure> failureData);
}