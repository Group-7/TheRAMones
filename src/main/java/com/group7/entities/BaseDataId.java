package com.group7.entities;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

public class BaseDataId implements Serializable {

	private Timestamp dateAndTime;
	private Long imsi;
	private Integer eventId;
	private Integer cellid;
	public BaseDataId(){
	
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
	public Integer getEventId() {
		return eventId;
	}
	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}
	
	
	
	public Integer getCellid() {
		return cellid;
	}
	public void setCellid(Integer cellid) {
		this.cellid = cellid;
	}
	public void setImsi(Long imsi) {
		this.imsi = imsi;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cellid == null) ? 0 : cellid.hashCode());
		result = prime * result
				+ ((dateAndTime == null) ? 0 : dateAndTime.hashCode());
		result = prime * result + ((eventId == null) ? 0 : eventId.hashCode());
		result = prime * result + ((imsi == null) ? 0 : imsi.hashCode());
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
		if (cellid == null) {
			if (other.cellid != null)
				return false;
		} else if (!cellid.equals(other.cellid))
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
		if (imsi == null) {
			if (other.imsi != null)
				return false;
		} else if (!imsi.equals(other.imsi))
			return false;
		return true;
	}
	
	
}