package com.group7.entities;

import java.io.Serializable;

import javax.persistence.Column;

public class NetworkId implements Serializable {

	private int mcc;	
	private int mnc;

	public NetworkId() {

	}

	public NetworkId(int mcc, int mnc) {
		super();
		this.mcc = mcc;
		this.mnc = mnc;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + mcc;
		result = prime * result + mnc;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NetworkId other = (NetworkId) obj;
		if (mcc != other.mcc)
			return false;
		if (mnc != other.mnc)
			return false;
		return true;
	}

}