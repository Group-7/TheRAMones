package com.group7.entities;

import java.math.BigInteger;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Access Capability is a 
 * subset of the User Equipment (UE) class
 */

@Entity
@Table(name="TAC_Access_Capability")
public class TACAccessCapability {
	
	@Id
	@Column(name="TAC")
	private BigInteger tac;
	
	@Column(name="Access_ID")
	private int AccessId;
	
/*	@ManyToOne
	private UE_Table ueTable;
	
	@OneToMany
	private AccessCapability accessCapability;

	*/
	
	
	public BigInteger getTac() {
		return tac;
	}

	public void setTac(BigInteger tac) {
		this.tac = tac;
	}

	public int getAccessId() {
		return AccessId;
	}

	public void setAccessId(int accessId) {
		AccessId = accessId;
	}

	/*public UEType getUeType() {
		return ueType;
	}

	public void setUeType(UEType ueType) {
		this.ueType = ueType;
	}

	public AccessCapability getAccessCapability() {
		return accessCapability;
	}

	public void setAccessCapability(AccessCapability accessCapability) {
		this.accessCapability = accessCapability;
	}
	*/
	
	
	

}
