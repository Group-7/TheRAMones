package com.group7.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * 
 * @author marc
 *
 */
@Entity
@IdClass(NetworkId.class)
@Table(name="Network")
public class Network implements Serializable{

	@Id
	@Column(name = "MCC")
	private int mcc;
	
	@Id
	@Column(name = "MNC")
	private int mnc;
	
	@Column(name = "Country")
	private String country;
	
	@Column(name = "Operator")
	private String operator;
	
	//Getters and setters
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
	
}