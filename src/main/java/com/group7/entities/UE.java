package com.group7.entities;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "UE_Table")
public class UE {
	
	@Id
	@Column(name = "TAC")
	private BigInteger tac;
	
	@Column(name = "Vendor_Name")
	private String vendorName;
	
	@Column(name = "Model")
	private String model;
	
	
	
	//missing in erd model
	@Column(name = "manufacturer")	
	private String manufacturer;
	
	//missing in erd model
	@Column(name = "Marketing_Name")
	private String marketingName;
	
	
	@Column(name = "UE_Type")
	private String ueType;
	
	@Column(name = "Operating_System")
	private String operatingSystem;
	
	@Column(name = "Input_Mode")
	private String inputMode;

	
	public BigInteger getTac() {
		return tac;
	}

	public void setTac(BigInteger tac) {
		this.tac = tac;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getMarketingName() {
		return marketingName;
	}
	public void setMarketingName(String marketingName) {
		this.marketingName = marketingName;
	}

	public String getUeType() {
		return ueType;
	}

	public void setUeType(String ueType) {
		this.ueType = ueType;
	}

	public String getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}

	public String getInputMode() {
		return inputMode;
	}

	public void setInputMode(String inputMode) {
		this.inputMode = inputMode;
	}
	
}
