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
@Table(name="base_data")
public class BaseData {

	@Id
	@Column(name="DateTime")
	private Timestamp dateAndTime;
	
	@Column(name="Cell_ID")
	private Integer cellid;
	@Id
	@Column(name="Cause_Code")
	private int causeCode;
	@Id
	@Column(name="EventID")
	private Integer eventId;
	
	//@Id
	//private EventCause eventCause;
	
	@Column(name="Failure_Class")
	private int failureClass;
	
	//private Failure failure;
	
	
	@Column(name="TAC")
	private long tac;
	
	//private UEType ue;
	
	@Column(name="MCC")
	private int mcc;
	
	@Column(name="MNC")
	private int mnc;
	
	//private Network network;
	
	@Column(name="Duration")
	private long duration;
	
	@Column(name="NE_Version")
	private String neVersion;
	
	@Id
	@Column(name="IMSI")
	private long imsi;
	
	@Column(name="Hier3_ID")
	private long heir3ID;
	
	@Column(name="Hier32_ID")
	private long heir32ID;
	
	@Column(name="Hier321_ID")
	private long heir321ID;

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

	public int getFailureClass() {
		return failureClass;
	}

	public void setFailureClass(int failureClass) {
		this.failureClass = failureClass;
	}

	public long getTac() {
		return tac;
	}

	public void setTac(long tac) {
		this.tac = tac;
	}

	public int getMcc() {
		return mcc;
	}

	public void setMcc(int mcc) {
		this.mcc = mcc;
	}

	public int getMnc() {
		return mnc;
	}

	public void setMnc(int mnc) {
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

	public long getHeir3ID() {
		return heir3ID;
	}

	public void setHeir3ID(long heir3id) {
		heir3ID = heir3id;
	}

	public long getHeir32ID() {
		return heir32ID;
	}

	public void setHeir32ID(long heir32id) {
		heir32ID = heir32id;
	}

	public long getHeir321ID() {
		return heir321ID;
	}

	public void setHeir321ID(long heir321id) {
		heir321ID = heir321id;
	}
	
	
	
	
	
}

