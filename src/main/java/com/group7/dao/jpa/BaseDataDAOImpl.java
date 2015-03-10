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

public class BaseDataDAOImpl implements BaseDataDAO {

	@PersistenceContext
	EntityManager em;

	public Collection<BaseData> getAllBaseData() {
		return (Collection<BaseData>) em.createQuery(
				"select bd from BaseData bd").getResultList();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void addBaseData(BaseData basedata) {
		em.persist(basedata);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void putData(Collection<BaseData> bd) {

		for (BaseData basedata : bd) {
			// em.persist(basedata);

			BaseData base = new BaseData();
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


	/*
	 * SELECT Base_Data.IMSI, Base_Data.Cause_Code, Base_Data.EventID,
	 * Event_Cause_Table.Description FROM Base_Data, Event_Cause_Table WHERE
	 * Base_Data.Cause_Code = Event_Cause_Table.Cause_Code AND Base_Data.EventID
	 * = Event_Cause_Table.EventID AND Base_Data.IMSI = 344930000000001;
	 */
	public Collection<Object> getAllCauseCodeAndEventIdByIMSI(BigInteger imsi) {
		return em
				.createQuery(
						"SELECT bd.imsi, bd.causeCode, bd.eventId, ec.description FROM Event_Cause_Table ec, BaseData bd WHERE bd.causeCode = ec.causeCode AND bd.eventId = ec.eventId AND bd.imsi = :imsi").setParameter("imsi", imsi).getResultList();
	}

	public Collection<BigInteger> getUniqueAffectedImsi() {
		return (Collection<BigInteger>) em.createQuery(
				"SELECT DISTINCT bd.imsi FROM BaseData bd").getResultList();

	}
	

	@Override
	public Collection<BigInteger> getImsiFailureOverTime(String from, String to) {
		// TODO Auto-generated method stub
		Timestamp start=new Timestamp(dateFormatter(from).getTime());
		Timestamp end=new Timestamp(dateFormatter(to).getTime());
		
		return (Collection<BigInteger>)em.createQuery("select DISTINCT bd.imsi from BaseData bd "
				+ "where bd.dateAndTime between :from and :to"
				).setParameter("from", start, TemporalType.TIMESTAMP)
				.setParameter("to", end, TemporalType.TIMESTAMP)
				.getResultList();
	}
	
	
	private Date dateFormatter(String date){
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
