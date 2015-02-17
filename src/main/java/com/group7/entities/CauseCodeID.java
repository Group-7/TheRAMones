package com.group7.entities;

import java.io.Serializable;

public class CauseCodeID implements Serializable{
	
	private int causeCode;
	private Integer eventId;
	
		
	public CauseCodeID(int causeCode, Integer eventId) {
		this.causeCode = causeCode;
		this.eventId = eventId;
		}
	
	
	public CauseCodeID(){
		
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
