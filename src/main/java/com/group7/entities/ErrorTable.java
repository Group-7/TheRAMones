
package com.group7.entities;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * Basedata error records. 
 * Stores the records that did not pass the validation test as Strings
 *
 * @author giovanni
 *
 */

@Entity
@Table(name="error_table")
public class ErrorTable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private long id;
	
	@Column(name="DateTime")
	private String dateAndTime;
	
	@Column(name="Cell_ID")
	private String cellid;
	
	@Column(name="Cause_Code")
	private String causeCode;
	
	@Column(name="EventID")
	private String eventId;
	
	@Column(name="Failure_Class")
	private String failureClass;
	
	@Column(name="TAC")
	private String tac;
	
	@Column(name="MCC")
	private String mcc;
	
	@Column(name="MNC")
	private String mnc;
	
	@Column(name="Duration")
	private String duration;
	
	@Column(name="NE_Version")
	private String neVersion;
	
	@Column(name="IMSI")
	private String imsi;
	
	@Column(name="Hier3_ID")
	private String heir3ID;
	
	@Column(name="Hier32_ID")
	private String heir32ID;
	
	@Column(name="Hier321_ID")
	private String heir321ID;

	public String getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(String dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public String getCellid() {
		return cellid;
	}

	public void setCellid(String cellid) {
		this.cellid = cellid;
	}

	public String getCauseCode() {
		return causeCode;
	}

	public void setCauseCode(String causeCode) {
		this.causeCode = causeCode;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getFailureClass() {
		return failureClass;
	}

	public void setFailureClass(String failureClass) {
		this.failureClass = failureClass;
	}

	public String getTac() {
		return tac;
	}

	public void setTac(String tac) {
		this.tac = tac;
	}

	public String getMcc() {
		return mcc;
	}

	public void setMcc(String mcc) {
		this.mcc = mcc;
	}

	public String getMnc() {
		return mnc;
	}

	public void setMnc(String mnc) {
		this.mnc = mnc;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getNeVersion() {
		return neVersion;
	}

	public void setNeVersion(String neVersion) {
		this.neVersion = neVersion;
	}

	public String getImsi() {
		return imsi;
	}

	public void setImsi(String imsi) {
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

}
