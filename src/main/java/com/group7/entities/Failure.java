package com.group7.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name ="Failure_Class_Table")
public class Failure implements Serializable{

	@Id
	@Column(name = "Failure_Class")
	private Integer FailureCode;
	
	
	@Column(name = "Description")
	private String description;

	@OneToMany(mappedBy="failureMap")
	private List<BaseData> failureBD = new ArrayList<>();
	
	
	
	
	
	
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


	public List<BaseData> getFailureBD() {
		return failureBD;
	}


	public void setFailureBD(List<BaseData> failureBD) {
		this.failureBD = failureBD;
	}
	
	
	
	
}
