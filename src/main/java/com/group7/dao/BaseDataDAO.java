package com.group7.dao;

import java.util.Collection;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import com.group7.entities.BaseData;
import com.group7.entities.EventCause;
import com.group7.entities.Failure;
import com.group7.entities.Network;
import com.group7.entities.UE;

@Local
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public interface BaseDataDAO {

	public Collection<BaseData> getAllBaseData();
	public void addBaseData(BaseData basedata);
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void putData(Collection<BaseData> bd);
	public void putNetworkData(Collection<Network> networkData);
	public void putUEData(Collection<UE> ueData);
	public void putEventCauseData(Collection<EventCause> eventCauseData);
	public void putFailureData(Collection<Failure> failureData);
}