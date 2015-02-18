package com.group7.entities;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 *	Basedata , pojo for the base data 
 *  coming in from the excel sheet
 *
 * @author niall
 *
 */

@Entity @IdClass(BaseDataId.class)
@Table(name="Base_Data")
public class BaseData {

	@Id
	@Column(name="DateTime")
	private Timestamp dateAndTime;
	
	@Id
	@Column(name="Cell_ID")
	private Integer cellid;
	
	@Id
	@Column(name="Cause_Code")
	private Integer causeCode;
	@Id
	@Column(name="EventID")
	private Integer eventId;
	
	//@Id
	//private EventCause eventCause;
	
	@Column(name="Failure_Class")
	private Integer failureClass;
	
	//private Failure failure;
	
	
	@Column(name="TAC")
	private long tac;
	
	//private UEType ue;
	
	@Column(name="MCC")
	private Integer mcc;
	
	@Column(name="MNC")
	private Integer mnc;
	
	//private Network network;
	
	@Column(name="Duration")
	private long duration;
	
	@Column(name="NE_Version")
	private String neVersion;
	
	@Id
	@Column(name="IMSI")
	private long imsi;
	
	@Column(name="Hier3_ID")
	private String heir3ID;
	
	@Column(name="Hier32_ID")
	private String heir32ID;
	
	@Column(name="Hier321_ID")
	private String heir321ID;

	public Timestamp getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(Timestamp dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public Integer getCellid() {
		return cellid;
	}

	public void setCellid(Integer cellid) {
		this.cellid = cellid;
	}

	public Integer getCauseCode() {
		return causeCode;
	}

	public void setCauseCode(Integer causeCode) {
		this.causeCode = causeCode;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public Integer getFailureClass() {
		return failureClass;
	}

	public void setFailureClass(Integer failureClass) {
		this.failureClass = failureClass;
	}

	public long getTac() {
		return tac;
	}

	public void setTac(long tac) {
		this.tac = tac;
	}

	public Integer getMcc() {
		return mcc;
	}

	public void setMcc(Integer mcc) {
		this.mcc = mcc;
	}

	public Integer getMnc() {
		return mnc;
	}

	public void setMnc(Integer mnc) {
		this.mnc = mnc;
	}

	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public String getNeVersion() {
		return neVersion;
	}

	public void setNeVersion(String neVersion) {
		this.neVersion = neVersion;
	}

	public long getImsi() {
		return imsi;
	}

	public void setImsi(long imsi) {
		this.imsi = imsi;
	}

	public String getHeir3ID() {
		return heir3ID;
	}

	public void setHeir3ID(String heir3id) {
		heir3ID = heir3id;
	}

	public String getHeir32ID() {
		return heir32ID;
	}

	public void setHeir32ID(String heir32id) {
		heir32ID = heir32id;
	}

	public String getHeir321ID() {
		return heir321ID;
	}

	public void setHeir321ID(String heir321id) {
		heir321ID = heir321id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((causeCode == null) ? 0 : causeCode.hashCode());
		result = prime * result + ((cellid == null) ? 0 : cellid.hashCode());
		result = prime * result
				+ ((dateAndTime == null) ? 0 : dateAndTime.hashCode());
		result = prime * result + (int) (duration ^ (duration >>> 32));
		result = prime * result + ((eventId == null) ? 0 : eventId.hashCode());
		result = prime * result
				+ ((failureClass == null) ? 0 : failureClass.hashCode());
		result = prime * result
				+ ((heir321ID == null) ? 0 : heir321ID.hashCode());
		result = prime * result
				+ ((heir32ID == null) ? 0 : heir32ID.hashCode());
		result = prime * result + ((heir3ID == null) ? 0 : heir3ID.hashCode());
		result = prime * result + (int) (imsi ^ (imsi >>> 32));
		result = prime * result + ((mcc == null) ? 0 : mcc.hashCode());
		result = prime * result + ((mnc == null) ? 0 : mnc.hashCode());
		result = prime * result
				+ ((neVersion == null) ? 0 : neVersion.hashCode());
		result = prime * result + (int) (tac ^ (tac >>> 32));
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
		BaseData other = (BaseData) obj;
		if (causeCode == null) {
			if (other.causeCode != null)
				return false;
		} else if (!causeCode.equals(other.causeCode))
			return false;
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
		if (duration != other.duration)
			return false;
		if (eventId == null) {
			if (other.eventId != null)
				return false;
		} else if (!eventId.equals(other.eventId))
			return false;
		if (failureClass == null) {
			if (other.failureClass != null)
				return false;
		} else if (!failureClass.equals(other.failureClass))
			return false;
		if (heir321ID == null) {
			if (other.heir321ID != null)
				return false;
		} else if (!heir321ID.equals(other.heir321ID))
			return false;
		if (heir32ID == null) {
			if (other.heir32ID != null)
				return false;
		} else if (!heir32ID.equals(other.heir32ID))
			return false;
		if (heir3ID == null) {
			if (other.heir3ID != null)
				return false;
		} else if (!heir3ID.equals(other.heir3ID))
			return false;
		if (imsi != other.imsi)
			return false;
		if (mcc == null) {
			if (other.mcc != null)
				return false;
		} else if (!mcc.equals(other.mcc))
			return false;
		if (mnc == null) {
			if (other.mnc != null)
				return false;
		} else if (!mnc.equals(other.mnc))
			return false;
		if (neVersion == null) {
			if (other.neVersion != null)
				return false;
		} else if (!neVersion.equals(other.neVersion))
			return false;
		if (tac != other.tac)
			return false;
		return true;
	}

	
	
	
	
	
	
	
}

