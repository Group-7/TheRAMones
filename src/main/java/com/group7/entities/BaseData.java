/*package com.group7.entities;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.jboss.logging.Cause;

*//**
 *
 *	Basedata , pojo for the base data 
 *  coming in from the excel sheet
 *
 * @author niall
 *
 *//*

	//@NamedQueries({
	//Niall's named query @NamedQuery(name = "BaseData.getAll", query = "select bd from baseData bd"),
	//@NamedQuery(name = "BaseData.displayCauseCodeANDEventID", query = "SELECT bd.imsi, bd.causeCode, bd.eventId FROM BaseData bd ORDER BY bd.imsi") })
	//@NamedQuery(name = "BaseData.displayCauseCodeANDEventID", query = "SELECT NEW com.group7.dao.BaseData(bs.imsi, bd.causeCode, bd.eventId) FROM BaseData bs") }) 

@Entity @IdClass(BaseDataId.class)
@Table(name="Base_Data")
public class BaseData {

	@Id
	@Column(name="DateTime")
	private Timestamp dateAndTime;
	
	@Id
	@Column(name="Cell_ID")
	private Integer cellid;
	
	@Id
	@Column(name="Cause_Code")
	private Integer causeCode;
	@Id
	@Column(name="EventID")
	private Integer eventId;

	
	@Column(name="Failure_Class")
	private Integer failureClass;
	

	@Column(name="TAC")
	private BigInteger tac;
	
	
	@Column(name="MCC")
	private Integer mcc;
	
	@Column(name="MNC")
	private Integer mnc;
	
	@Column(name="Duration")
	private int duration;
	
	@Column(name="NE_Version")
	private String neVersion;
	
	@Id
	@Column(name="IMSI")
	private BigInteger imsi;
	
	@Column(name="Hier3_ID")
	private String heir3ID;
	
	@Column(name="Hier32_ID")
	private String heir32ID;
	
	@Column(name="Hier321_ID")
	private String heir321ID;

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

	public Integer getCauseCode() {
		return causeCode;
	}

	public void setCauseCode(Integer causeCode) {
		this.causeCode = causeCode;
	}

	public Integer getEventId() {
		return eventId;
	}

	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}

	public Integer getFailureClass() {
		return failureClass;
	}

	public void setFailureClass(Integer failureClass) {
		this.failureClass = failureClass;
	}


	public Integer getMcc() {
		return mcc;
	}

	public void setMcc(Integer mcc) {
		this.mcc = mcc;
	}

	public Integer getMnc() {
		return mnc;
	}

	public void setMnc(Integer mnc) {
		this.mnc = mnc;
	}

	public int getDuration() {
		return duration;
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

	public BigInteger getTac() {
		return tac;
	}

	public void setTac(BigInteger tac) {
		this.tac = tac;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((causeCode == null) ? 0 : causeCode.hashCode());
		result = prime * result + ((cellid == null) ? 0 : cellid.hashCode());
		result = prime * result
				+ ((dateAndTime == null) ? 0 : dateAndTime.hashCode());
		result = prime * result + duration;
		result = prime * result + ((eventId == null) ? 0 : eventId.hashCode());
		result = prime * result
				+ ((failureClass == null) ? 0 : failureClass.hashCode());
		result = prime * result
				+ ((heir321ID == null) ? 0 : heir321ID.hashCode());
		result = prime * result
				+ ((heir32ID == null) ? 0 : heir32ID.hashCode());
		result = prime * result + ((heir3ID == null) ? 0 : heir3ID.hashCode());
		result = prime * result + ((imsi == null) ? 0 : imsi.hashCode());
		result = prime * result + ((mcc == null) ? 0 : mcc.hashCode());
		result = prime * result + ((mnc == null) ? 0 : mnc.hashCode());
		result = prime * result
				+ ((neVersion == null) ? 0 : neVersion.hashCode());
		result = prime * result + ((tac == null) ? 0 : tac.hashCode());
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
		BaseData other = (BaseData) obj;
		if (causeCode == null) {
			if (other.causeCode != null)
				return false;
		} else if (!causeCode.equals(other.causeCode))
			return false;
		if (cellid == null) {
			if (other.cellid != null)
				return false;
		} else if (!cellid.equals(other.cellid))
			return false;
		if (dateAndTime == null) {
			if (other.dateAndTime != null)
				return false;
		} else if (!dateAndTime.equals(other.dateAndTime))
			return false;
		if (duration != other.duration)
			return false;
		if (eventId == null) {
			if (other.eventId != null)
				return false;
		} else if (!eventId.equals(other.eventId))
			return false;
		if (failureClass == null) {
			if (other.failureClass != null)
				return false;
		} else if (!failureClass.equals(other.failureClass))
			return false;
		if (heir321ID == null) {
			if (other.heir321ID != null)
				return false;
		} else if (!heir321ID.equals(other.heir321ID))
			return false;
		if (heir32ID == null) {
			if (other.heir32ID != null)
				return false;
		} else if (!heir32ID.equals(other.heir32ID))
			return false;
		if (heir3ID == null) {
			if (other.heir3ID != null)
				return false;
		} else if (!heir3ID.equals(other.heir3ID))
			return false;
		if (imsi == null) {
			if (other.imsi != null)
				return false;
		} else if (!imsi.equals(other.imsi))
			return false;
		if (mcc == null) {
			if (other.mcc != null)
				return false;
		} else if (!mcc.equals(other.mcc))
			return false;
		if (mnc == null) {
			if (other.mnc != null)
				return false;
		} else if (!mnc.equals(other.mnc))
			return false;
		if (neVersion == null) {
			if (other.neVersion != null)
				return false;
		} else if (!neVersion.equals(other.neVersion))
			return false;
		if (tac == null) {
			if (other.tac != null)
				return false;
		} else if (!tac.equals(other.tac))
			return false;
		return true;
	}

	public BaseData deepCopy(){
		
		
		BaseData base=new BaseData();
		
		
		base.setDateAndTime(this.getDateAndTime());
		base.setEventId(this.getEventId());
		base.setFailureClass(this.getFailureClass());
		base.setTac(this.getTac());
		base.setMcc(this.getMcc());
		base.setMnc(this.getMnc());
		base.setCellid(this.getCellid());
		base.setDuration(this.getDuration());
		base.setCauseCode(this.getCauseCode());
		base.setNeVersion(this.getNeVersion());
		base.setImsi(this.getImsi());
		base.setHeir3ID(this.getHeir3ID());
		base.setHeir32ID(this.getHeir32ID());
		base.setHeir321ID(this.getHeir321ID());
		
		
		
		return base;
		
	}
	
}

*/

//-------------------------------------MARC PART-----------------------------------

package com.group7.entities;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	//@Id
	@Column(name="DateTime")
	private Timestamp dateAndTime;
	
	//@Id
	@Column(name="Cell_ID")
	private Integer cellid;
	
	//@Id
	@Column(name="Cause_Code")
	private Integer causeCode;
	
	//@Id
	@Column(name="EventID")
	private Integer eventId;

	
	@Column(name="Failure_Class")
	private Integer failureClass;
	

	@Column(name="TAC")
	private BigInteger tac;
	
	
	@Column(name="MCC")
	private Integer mcc;
	
	@Column(name="MNC")
	private Integer mnc;
	
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
	
	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
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



	public Integer getCauseCode() {
		return causeCode;
	}



	public void setCauseCode(Integer causeCode) {
		this.causeCode = causeCode;
	}



	public Integer getEventId() {
		return eventId;
	}



	public void setEventId(Integer eventId) {
		this.eventId = eventId;
	}



	public Integer getFailureClass() {
		return failureClass;
	}



	public void setFailureClass(Integer failureClass) {
		this.failureClass = failureClass;
	}



	public BigInteger getTac() {
		return tac;
	}



	public void setTac(BigInteger tac) {
		this.tac = tac;
	}



	public Integer getMcc() {
		return mcc;
	}



	public void setMcc(Integer mcc) {
		this.mcc = mcc;
	}



	public Integer getMnc() {
		return mnc;
	}



	public void setMnc(Integer mnc) {
		this.mnc = mnc;
	}



	public int getDuration() {
		return duration;
	}



	public void setDuration(int duration) {
		this.duration = duration;
	}



	public String getNeVersion() {
		return neVersion;
	}



	public void setNeVersion(String neVersion) {
		this.neVersion = neVersion;
	}



	public BigInteger getImsi() {
		return imsi;
	}



	public void setImsi(BigInteger imsi) {
		this.imsi = imsi;
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

	


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((causeCode == null) ? 0 : causeCode.hashCode());
		result = prime * result + ((cellid == null) ? 0 : cellid.hashCode());
		result = prime * result
				+ ((dateAndTime == null) ? 0 : dateAndTime.hashCode());
		result = prime * result + duration;
		result = prime * result + ((eventId == null) ? 0 : eventId.hashCode());
		result = prime * result
				+ ((failureClass == null) ? 0 : failureClass.hashCode());
		result = prime * result
				+ ((heir321ID == null) ? 0 : heir321ID.hashCode());
		result = prime * result
				+ ((heir32ID == null) ? 0 : heir32ID.hashCode());
		result = prime * result + ((heir3ID == null) ? 0 : heir3ID.hashCode());
		result = prime * result + id;
		result = prime * result + ((imsi == null) ? 0 : imsi.hashCode());
		result = prime * result + ((mcc == null) ? 0 : mcc.hashCode());
		result = prime * result + ((mnc == null) ? 0 : mnc.hashCode());
		result = prime * result
				+ ((neVersion == null) ? 0 : neVersion.hashCode());
		result = prime * result + ((tac == null) ? 0 : tac.hashCode());
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
		BaseData other = (BaseData) obj;
		if (causeCode == null) {
			if (other.causeCode != null)
				return false;
		} else if (!causeCode.equals(other.causeCode))
			return false;
		if (cellid == null) {
			if (other.cellid != null)
				return false;
		} else if (!cellid.equals(other.cellid))
			return false;
		if (dateAndTime == null) {
			if (other.dateAndTime != null)
				return false;
		} else if (!dateAndTime.equals(other.dateAndTime))
			return false;
		if (duration != other.duration)
			return false;
		if (eventId == null) {
			if (other.eventId != null)
				return false;
		} else if (!eventId.equals(other.eventId))
			return false;
		if (failureClass == null) {
			if (other.failureClass != null)
				return false;
		} else if (!failureClass.equals(other.failureClass))
			return false;
		if (heir321ID == null) {
			if (other.heir321ID != null)
				return false;
		} else if (!heir321ID.equals(other.heir321ID))
			return false;
		if (heir32ID == null) {
			if (other.heir32ID != null)
				return false;
		} else if (!heir32ID.equals(other.heir32ID))
			return false;
		if (heir3ID == null) {
			if (other.heir3ID != null)
				return false;
		} else if (!heir3ID.equals(other.heir3ID))
			return false;
		if (id != other.id)
			return false;
		if (imsi == null) {
			if (other.imsi != null)
				return false;
		} else if (!imsi.equals(other.imsi))
			return false;
		if (mcc == null) {
			if (other.mcc != null)
				return false;
		} else if (!mcc.equals(other.mcc))
			return false;
		if (mnc == null) {
			if (other.mnc != null)
				return false;
		} else if (!mnc.equals(other.mnc))
			return false;
		if (neVersion == null) {
			if (other.neVersion != null)
				return false;
		} else if (!neVersion.equals(other.neVersion))
			return false;
		if (tac == null) {
			if (other.tac != null)
				return false;
		} else if (!tac.equals(other.tac))
			return false;
		return true;
	}



	public BaseData deepCopy(){
		
		
		BaseData base=new BaseData();
		
		
		base.setDateAndTime(this.getDateAndTime());
		base.setEventId(this.getEventId());
		base.setFailureClass(this.getFailureClass());
		base.setTac(this.getTac());
		base.setMcc(this.getMcc());
		base.setMnc(this.getMnc());
		base.setCellid(this.getCellid());
		base.setDuration(this.getDuration());
		base.setCauseCode(this.getCauseCode());
		base.setNeVersion(this.getNeVersion());
		base.setImsi(this.getImsi());
		base.setHeir3ID(this.getHeir3ID());
		base.setHeir32ID(this.getHeir32ID());
		base.setHeir321ID(this.getHeir321ID());
		
		
		
		return base;
		
	}
	
}
