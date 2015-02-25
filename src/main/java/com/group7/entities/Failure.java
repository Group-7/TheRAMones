package com.group7.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name ="Failure_Class_Table")
public class Failure implements Serializable{

	@Id
	@Column(name = "Failure_Class")
	private Integer FailureCode;
	
	
	@Column(name = "Description")
	private String description;


	public Integer getFailureCode() {
		return FailureCode;
	}


	public void setFailureCode(Integer failureCode) {
		FailureCode = failureCode;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
