/*package com.group7.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

*//**
 * This class describe the failure cause within the Event Type.
 * 
 * @author giovanni
 *//*

@Entity
@Table(name = "Event_Cause")
public class EventCause {

	@Id
	@Column(name = "Cause Code")
	private int CauseCode;

	@Id
	@Column(name = "Event Id")
	private int eventId;

	@Column(name = "Description")
	private String discription;

	public int getEventCode() {
		return CauseCode;
	}

	public void setEventCode(int eventCode) {
		this.CauseCode = eventCode;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + CauseCode;
		result = prime * result + eventId;
		return result;
	}



}*/