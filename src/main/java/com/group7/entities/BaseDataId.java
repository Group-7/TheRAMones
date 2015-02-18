package com.group7.entities;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class BaseDataId implements Serializable {

	private Timestamp dateAndTime;
	private long imsi;
	private int causeCode;
	private Integer eventId;
	public BaseDataId(){
		
	}
	public BaseDataId(Timestamp dateAndTime, long imsi, int causeCode,
			Integer eventId) {
		super();
		this.dateAndTime = dateAndTime;
		this.imsi = imsi;
		this.causeCode = causeCode;
		this.eventId = eventId;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + causeCode;
		result = prime * result
				+ ((dateAndTime == null) ? 0 : dateAndTime.hashCode());
		result = prime * result + ((eventId == null) ? 0 : eventId.hashCode());
		result = prime * result + (int) (imsi ^ (imsi >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseDataId other = (BaseDataId) obj;
		if (causeCode != other.causeCode)
			return false;
		if (dateAndTime == null) {
			if (other.dateAndTime != null)
				return false;
		} else if (!dateAndTime.equals(other.dateAndTime))
			return false;
		if (eventId == null) {
			if (other.eventId != null)
				return false;
		} else if (!eventId.equals(other.eventId))
			return false;
		if (imsi != other.imsi)
			return false;
		return true;
	}
	public Timestamp getDateAndTime() {
		return dateAndTime;
	}
	public void setDateAndTime(Timestamp dateAndTime) {
		this.dateAndTime = dateAndTime;
	}
	public long getImsi() {
		return imsi;
	}
	public void setImsi(long imsi) {
		this.imsi = imsi;
	}
	public int getCauseCode() {
		return causeCode;
	}
	public void setCauseCode(int causeCode) {
		this.causeCode = causeCode;
	}
	public Integer getEventId() {
		return eventId;
	}
	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}
	
	
}
