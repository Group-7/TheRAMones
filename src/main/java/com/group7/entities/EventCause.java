package com.group7.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * Presents the failure cause within the Event Type.
 * 
 * @author giovanni
 */

@Entity
@IdClass(EventCauseID.class)
@Table(name="Event_Cause_Table")// does  not work with @Table
public class EventCause implements Serializable{
	
	@Id
	@Column(name="Cause_Code")
	private Integer causeCode;

	@Id
	@Column(name="EventID")
	private Integer eventId;
	
	
	@Column(name="Description")
	private String description;

	
	
	public Integer getCauseCode() {
		return causeCode;
	}

	public void setCauseCode(Integer causeCode) {
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