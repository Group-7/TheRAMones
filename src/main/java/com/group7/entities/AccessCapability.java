package com.group7.entities;
import java.math.BigInteger;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Access_Capability")
public class AccessCapability {
	
	@Id
	@Column
	private String Capability;
	
	@Column(name="TAC")
	private BigInteger tac;

	
	
	public String getCapability() {
		return Capability;
	}

	public void setCapability(String capability) {
		Capability = capability;
	}

	public BigInteger getTac() {
		return tac;
	}

	public void setTac(BigInteger tac) {
		this.tac = tac;
	}

	
}
