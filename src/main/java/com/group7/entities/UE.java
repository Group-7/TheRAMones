package com.group7.entities;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "UE_Table")
public class UE {
	
	@Id
	@Column(name = "TAC")
	private int tac;
	
	@Column(name = "Marketing_Name")
	private String marketingName;
	
	@Column(name = "Manufacturer")
	private String manufacturer;
	
	@Column(name = "Access_Capability")
	private String accessCapability;
	
	@Column(name = "Model")
	private String model;
	
	@Column(name = "Vendor_Name")
	private String vendorName;
	
		
	public String getMarketingName() {
		return marketingName;
	}

	public void setMarketingName(String marketingName) {
		this.marketingName = marketingName;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getAccessCapability() {
		return accessCapability;
	}

	public void setAccessCapability(String accessCapability) {
		this.accessCapability = accessCapability;
	}

	@Column(name = "UE_Type")
	private String ueType;
	
	@Column(name = "Operating_System")
	private String operatingSystem;
	
	@Column(name = "Input_Mode")
	private String inputMode;

	
	public int getTac() {
		return tac;
	}

	public void setTac(int tac) {
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