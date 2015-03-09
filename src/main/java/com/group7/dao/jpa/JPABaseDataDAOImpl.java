package com.group7.dao.jpa;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.TemporalType;

import com.group7.dao.BaseDataDAO;
import com.group7.entities.BaseData;



@NamedQueries({
	@NamedQuery(name="BaseData.getAll", query="select bd from baseData bd")
}
)

public class JPABaseDataDAOImpl implements BaseDataDAO {

	@PersistenceContext
	EntityManager em;
	
	public Collection<BaseData> getAllBaseData() {
		// TODO Auto-generated method stub
		return (Collection<BaseData>)em.createQuery("select bd from BaseData bd").getResultList();
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void addBaseData(BaseData basedata){
		em.persist(basedata);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void putData(Collection<BaseData> bd) {
		
		
		for(BaseData basedata : bd){
			//em.persist(basedata);
			
			BaseData base=new BaseData();
			base.setDateAndTime(basedata.getDateAndTime());
			base.setEventId(basedata.getEventId());
			base.setFailureClass(basedata.getFailureClass());
			base.setTac(basedata.getTac());
			base.setMcc(basedata.getMcc());
			base.setMnc(basedata.getMnc());
			base.setCellid(basedata.getCellid());
			base.setDuration(basedata.getDuration()); 
			base.setCauseCode(basedata.getCauseCode());
			base.setNeVersion(basedata.getNeVersion());
			base.setImsi(basedata.getImsi());
			base.setHeir3ID(basedata.getHeir3ID());
			base.setHeir32ID(basedata.getHeir32ID());
			base.setHeir321ID(basedata.getHeir321ID());
			em.persist(base);
		}
		
	}

	
	/**
	 * Returns the total number of call failures within a certain
	 * time period based on the phoneType.
	 */
	public Collection<Long> getTotalFailuresOfSpecificPhone(BigInteger phoneType, String startDate, String endDate) {
		
		Timestamp dbStartDate=new Timestamp(dateFormatter(startDate).getTime());
		Timestamp dbEndDate=new Timestamp(dateFormatter(endDate).getTime());
	
		return em.createQuery("SELECT COUNT(*) FROM BaseData bd WHERE bd.tac LIKE :tac AND bd.dateAndTime > :startdate AND bd.dateAndTime < :enddate")
				.setParameter("tac", phoneType)
				.setParameter("startdate", dbStartDate, TemporalType.TIMESTAMP)
				.setParameter("enddate", dbEndDate, TemporalType.TIMESTAMP)
				.getResultList();
	
		}

	
	/**
	 * Returns the total number of call failures within a certain
	 * time period based on the imsi number.
	 */
	public Collection<Long> getTotalFailuresOfSpecificIMSI(BigInteger imsi, String startDate, String endDate) {
		
		Timestamp dbStartDate=new Timestamp(dateFormatter(startDate).getTime());
		Timestamp dbEndDate=new Timestamp(dateFormatter(endDate).getTime());
				
		return em.createQuery("SELECT COUNT(*) FROM BaseData bd WHERE bd.imsi LIKE :imsi AND bd.dateAndTime > :startdate AND bd.dateAndTime < :enddate")
				.setParameter("imsi", imsi)
				.setParameter("startdate", dbStartDate, TemporalType.TIMESTAMP)
				.setParameter("enddate", dbEndDate, TemporalType.TIMESTAMP)
				.getResultList();
			}
	
	
	/** 
	 * Returns for a given phone type all the unique failure Event Id and Cause Code combinations 
	 * they have exhibited and the number of occurrences.
	 */
	public Collection<Object> getAllCallFailuresAndTotalDurationPerIMSI(BigInteger imsi, String startDate, String endDate) {
		
		Timestamp dbStartDate=new Timestamp(dateFormatter(startDate).getTime());
		Timestamp dbEndDate=new Timestamp(dateFormatter(endDate).getTime());
				
		return em.createQuery("SELECT imsi, COUNT(*), SUM(duration) FROM BaseData bd WHERE bd.imsi LIKE :imsi AND bd.dateAndTime > :startdate AND bd.dateAndTime < :enddate")
				.setParameter("imsi", imsi)
				.setParameter("startdate", dbStartDate, TemporalType.TIMESTAMP)
				.setParameter("enddate", dbEndDate, TemporalType.TIMESTAMP)
				.getResultList();
			}
	
	
	/**
	 * Formats the date so the DataBase can use read it
	 * @param date
	 * @return formated date object
	 */
	public Date dateFormatter(String date){
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date newDate = null;
		try {
			newDate = format.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return newDate;
//		DateTimeFormatter parser = DateTimeFormat.forPattern("MM/dd/yyyy HH:mm:ss");
//	    dt = DateTime.parse("10/02/2013 20:00:00", parser); 
	}
}