package com.group7.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * Presents the failure cause within the Event Type.
 * 
 * @author giovanni
 */

@Entity(name="Event_Cause_Table")
@IdClass(CauseCodeID.class)
public class EventCause {

	@Id
	@Column(name="Cause_Code")
	private int causeCode;

	@Id
	@Column(name="Event_ID")
	private Integer eventId;

	@Column(name="Description")
	private String description;

	
	
	public int getCauseCode() {
		return causeCode;
	}

	public void setCauseCode(int causeCode) {
		this.causeCode = causeCode;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventID(Integer eventId) {
		this.eventId = eventId;
	}

	public String getDescription() {
		return description;
	}

	public void setDiscription(String description) {
		this.description = description;
	}

}