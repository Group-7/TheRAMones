package com.group7.serviceInterface;

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

@Stateless
@Local
@TransactionManagement(TransactionManagementType.CONTAINER)
public interface BaseDataServiceLocal {

	public Collection<BaseData> getAllBasedata();
	public void addBaseData(BaseData basedata);
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void putData(Collection<BaseData> bd);
	public void putNetworkData(Collection<Network> networkList);
	public void putUEData(Collection<UE> ueList);
	public void putEventCauseData(Collection<EventCause> eventCauseList);
	public void putFailureData(Collection<Failure>failureList);
}