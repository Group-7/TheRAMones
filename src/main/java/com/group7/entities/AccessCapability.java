package com.group7.entities;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity(name = "Access_Capability")
public class AccessCapability {

	@Id
	@Column(name = "Capability")
	private String capability;
	
	@Column( name = "TAC")
	private BigInteger tac;

	public String getCapability() {
		return capability;
	}

	public void setCapability(String capability) {
		this.capability = capability;
	}

	public BigInteger getTac() {
		return tac;
	}

	public void setTac(BigInteger tac) {
		this.tac = tac;
	}
	
	
	
	
}
