package com.group7.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * 
 * @author marc grogan
 *
 *	A Test comment but also, named queries to go here!!
 */

@NamedQueries( {
	@NamedQuery(name = "Network.getMNC", query = "select distinct o.mnc from Network o order by o.mnc"),
	@NamedQuery(name = "Network.getMCC", query = "select distinct a.mcc from Network a order by a.mcc")
})
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