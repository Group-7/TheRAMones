package com.group7.entities;

import java.math.BigInteger;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonBackReference;

/**
 *
 *	Basedata , Pojo for the base data 
 *  coming in from the excel sheet
 *
 * @author niall 
 *
 */

	//@NamedQueries({
	//Niall's named query @NamedQuery(name = "BaseData.getAll", query = "select bd from baseData bd"),
	//@NamedQuery(name = "BaseData.displayCauseCodeANDEventID", query = "SELECT bd.imsi, bd.causeCode, bd.eventId FROM BaseData bd ORDER BY bd.imsi") })
	//@NamedQuery(name = "BaseData.displayCauseCodeANDEventID", query = "SELECT NEW com.group7.dao.BaseData(bs.imsi, bd.causeCode, bd.eventId) FROM BaseData bs") }) 

@Entity //@IdClass(BaseDataId.class)
@Table(name="Base_Data")
public class BaseData {
	
	@Id
	@Column(name="Base_ID")
	//@GeneratedValue(strategy=GenerationType.TABLE)
	private long id;

	//@Id
	@Column(name="DateTime")
	private Timestamp dateAndTime;
	
	//@Id
	@Column(name="Cell_ID")
	private Integer cellid;
		
	
	@Column(name="Duration")
	private int duration;
	
	@Column(name="NE_Version")
	private String neVersion;
	
	//@Id
	@Column(name="IMSI")
	private BigInteger imsi;
	
	@Column(name="Hier3_ID")
	private String heir3ID;
	
	@Column(name="Hier32_ID")
	private String heir32ID;
	
	@Column(name="Hier321_ID")
	private String heir321ID;
	
	//Joins
	@ManyToOne
	@JoinColumn(name="Failure_Class")
	@JsonBackReference
	private Failure failureMap;
	
	@ManyToOne
	@JoinColumn(name="TAC")
	@JsonBackReference
	private UE ueMap;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="Cause_Code",referencedColumnName="Cause_Code"),
		@JoinColumn(name="EventID",referencedColumnName="EventID")
	})
	private EventCause eventCauseMap;
	
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="MCC",referencedColumnName="MCC"),
		@JoinColumn(name="MNC",referencedColumnName="MNC")
	})
	private Network networkMap;
	
	////
	
	public BaseData(){}
	
	
	public BaseData(long id, Timestamp dateAndTime, Integer cellid,
			int duration, String neVersion, BigInteger imsi, String heir3id,
			String heir32id, String heir321id, int failure, int tac,
			int eventID,int causeCodeID, int mcc, int mnc) {
		super();
		this.id = id;
		this.dateAndTime = dateAndTime;
		this.cellid = cellid;
		this.duration = duration;
		this.neVersion = neVersion;
		this.imsi = imsi;
		heir3ID = heir3id;
		heir32ID = heir32id;
		heir321ID = heir321id;
		this.failureMap = new Failure();
		failureMap.setFailureCode(failure);
		this.ueMap = new UE();
		this.ueMap.setTac(tac);
		this.eventCauseMap = new EventCause();
		this.eventCauseMap.setCauseCode(causeCodeID);
		this.eventCauseMap.setEventId(eventID);
		this.networkMap = new Network();
		this.networkMap.setMcc(mcc);
		this.networkMap.setMnc(mnc);
	}
	
	


	public Timestamp getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(Timestamp dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public Integer getCellid() {
		return cellid;
	}

	public void setCellid(Integer cellid) {
		this.cellid = cellid;
	}

	
	
	public EventCause getEventCauseMap() {
		return eventCauseMap;
	}

	public void setEventCauseMap(EventCause eventCauseMap) {
		this.eventCauseMap = eventCauseMap;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getDuration() {
		return duration;
	}


	public Network getNetworkMap() {
		return networkMap;
	}

	public void setNetworkMap(Network networkMap) {
		this.networkMap = networkMap;
	}

	public String getNeVersion() {
		return neVersion;
	}

	public void setNeVersion(String neVersion) {
		this.neVersion = neVersion;
	}


	public String getHeir3ID() {
		return heir3ID;
	}

	public void setHeir3ID(String heir3id) {
		heir3ID = heir3id;
	}

	public String getHeir32ID() {
		return heir32ID;
	}

	public void setHeir32ID(String heir32id) {
		heir32ID = heir32id;
	}

	public String getHeir321ID() {
		return heir321ID;
	}

	public void setHeir321ID(String heir321id) {
		heir321ID = heir321id;
	}


	public BigInteger getImsi() {
		return imsi;
	}

	public void setImsi(BigInteger imsi) {
		this.imsi = imsi;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	
	public UE getUeMap() {
		return ueMap;
	}

	public void setUeMap(UE ueMap) {
		this.ueMap = ueMap;
	}

	public Failure getFailureMap() {
		return failureMap;
	}

	public void setFailureMap(Failure failureMap) {
		this.failureMap = failureMap;
	}

	
	
}
