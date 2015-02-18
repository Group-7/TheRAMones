
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
 * Stores the records that did not pass the validation test
 *
 * @author giovanni
 *
 */

@Entity 
@Table(name="error_table")
public class ErrorTable implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private long id;
	
	@Column(name="DateTime")
	private Timestamp dateAndTime;
	
	@Column(name="Cell_ID")
	private Integer cellid;
	
	@Column(name="Cause_Code")
	private Integer causeCode;
	
	@Column(name="EventID")
	private Integer eventId;
	
	@Column(name="Failure_Class")
	private Integer failureClass;
	
	@Column(name="TAC")
	private long tac;
	
	@Column(name="MCC")
	private Integer mcc;
	
	@Column(name="MNC")
	private Integer mnc;
	
	@Column(name="Duration")
	private long duration;
	
	@Column(name="NE_Version")
	private String neVersion;
	
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

}
