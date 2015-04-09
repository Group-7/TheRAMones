package com.group7.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Base_Data_Error")
public class BaseDataError {

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int id;
	
	private String dateAndTime,cellId,duration,neversion,imsi,heir3ID,heir32ID;
	private String heir321ID,failureClass, tac, causeCode,EventId,mcc,mnc;
	
	public BaseDataError(){}
	public BaseDataError(String dateAndTime, String cellId,
			String duration, String neversion, String imsi, String heir3id,
			String heir32id, String heir321id, String failureClass, String tac,
			String causeCode, String eventId, String mcc, String mnc) {
		super();
		this.dateAndTime = dateAndTime;
		this.cellId = cellId;
		this.duration = duration;
		this.neversion = neversion;
		this.imsi = imsi;
		heir3ID = heir3id;
		heir32ID = heir32id;
		heir321ID = heir321id;
		this.failureClass = failureClass;
		this.tac = tac;
		this.causeCode = causeCode;
		EventId = eventId;
		this.mcc = mcc;
		this.mnc = mnc;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDateAndTime() {
		return dateAndTime;
	}
	public void setDateAndTime(String dateAndTime) {
		this.dateAndTime = dateAndTime;
	}
	public String getCellId() {
		return cellId;
	}
	public void setCellId(String cellId) {
		this.cellId = cellId;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getNeversion() {
		return neversion;
	}
	public void setNeversion(String neversion) {
		this.neversion = neversion;
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
	public String getCauseCode() {
		return causeCode;
	}
	public void setCauseCode(String causeCode) {
		this.causeCode = causeCode;
	}
	public String getEventId() {
		return EventId;
	}
	public void setEventId(String eventId) {
		EventId = eventId;
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
	
	
	
	
	
}
