package com.group7.dao.jpa;

import java.math.BigInteger;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import com.group7.dao.BaseDataDAO;
import com.group7.entities.BaseData;
import com.group7.entities.BaseDataError;
import com.group7.entities.EventCause;
import com.group7.entities.Failure;
import com.group7.entities.Network;
import com.group7.entities.UE;
import com.group7.importBaseData.BaseDataValidation;

@Named
@NamedQueries({ @NamedQuery(name = "BaseData.getAll", query = "select bd from baseData bd") })
@Local
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class BaseDataDAOImpl implements BaseDataDAO {

	@Inject
	EntityManager em;

	BaseDataValidation bdv = BaseDataValidation.getInstance();

	public Collection<BaseData> getAllBaseData() {
		return (Collection<BaseData>) em.createQuery(
				"select bd from BaseData bd").getResultList();
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void addBaseData(BaseData basedata) {
		em.persist(basedata);
	}

	//@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void putData(Collection<BaseData> bd) {
		// System.out.println("valid size "+bd.size());
		int count = 0;
		int inserted = 0;
		for (BaseData basedata : bd) {
			/*
			 * try{ em.merge(basedata.deepCopy()); inserted++; }
			 * catch(EntityExistsException eee){
			 * //System.out.println("***************\nEntity exixts exception "
			 * +"\n**************"); count++; }
			 */

			System.out.println("inserting: " + inserted);
			em.persist(basedata);
			inserted++;
		}
		// System.out.println("dupicates "+count);

	}


	//DONE
	public Collection<Object> getAllCauseCodeAndEventIdByIMSI(BigInteger imsi) {
		return em
				.createQuery("SELECT DISTINCT bd.imsi, bd.eventCauseMap.causeCode, bd.eventCauseMap.eventId, ec.description FROM EventCause ec, BaseData bd WHERE bd.eventCauseMap.causeCode = ec.causeCode AND bd.eventCauseMap.eventId = ec.eventId AND bd.imsi = :imsi")
				.setParameter("imsi", imsi).getResultList();
	}

	public Collection<BigInteger> getUniqueAffectedImsi() {
		return (Collection<BigInteger>) em.createQuery(
				"SELECT DISTINCT bd.imsi FROM BaseData bd").getResultList();

	}
	//works
	@Override
	public Collection<BigInteger> getImsiFailureOverTime(String from, String to) {
		// TODO Auto-generated method stub
		Timestamp start = new Timestamp(dateFormatter(from).getTime());
		Timestamp end = new Timestamp(dateFormatter(to).getTime());

		return (Collection<BigInteger>) em
				.createQuery(
						"select DISTINCT bd.imsi from BaseData bd "
								+ "where bd.dateAndTime between :from and :to")
				.setParameter("from", start, TemporalType.TIMESTAMP)
				.setParameter("to", end, TemporalType.TIMESTAMP)
				.getResultList();
	}

	@Override
	public void putNetworkData(Collection<Network> networkData) {
		Query q = em.createQuery("from Network");
		List<Network> networkList = q.getResultList();
		for (Network n : networkData) {
			// if (!bdv.persistCandidateKeysToNetworkTable("" + n.getMcc() +
			// n.getMnc())) // works
			if (networkList.size()==0 || (!bdv.persistCandidateKeysToNetworkTable("" + n.getMcc() + n.getMnc())))
				em.merge(n);
		}
	}

	@Override
	public void putUEData(Collection<UE> ueData) {
		Query q = em.createQuery("from UE_Table");
		List<UE> ueList = q.getResultList();
		for (UE u : ueData) {
			// if ((bdv.isUeFirst())||
			// (!bdv.persistEventCausePrimaryKey(Integer.toString(u.getTac()))))
			// // Failed
			if (ueList.size()==0 || !bdv.persistEventCausePrimaryKey(Integer.toString(u.getTac()))) {
				em.merge(u);
			}
		}
		// bdv.setUeFirst(false);
	}

	@Override
	public void putEventCauseData(Collection<EventCause> eventCauseData) {
		Query q = em.createQuery("from EventCause");
		List<EventCause> eventcauseList = q.getResultList();
		for (EventCause e : eventCauseData) {
			// if ((bdv.isEventCauseFirst()) ||
			// !bdv.persistCandidateKeysToEventCauseTable(""+ e.getCauseCode() +
			// e.getEventId()))
			if (eventcauseList.size()==0 || !bdv.persistCandidateKeysToEventCauseTable(""+ e.getCauseCode() + e.getEventId()))
				em.merge(e);
		}
		// bdv.setEventCauseFirst(false);
	}

	@Override
	public void putFailureData(Collection<Failure> failureData) {
		Query q = em.createQuery("from Failure_Class_Table");
		List<Failure> failureList = q.getResultList();
		for (Failure f : failureData) {
			// if ((bdv.isFailureFirst())||
			// !bdv.persistFailurePrimaryKey(Integer.toString(f.getFailureCode())))
			// // failed
			if (failureList.size()==0 || !bdv.persistFailurePrimaryKey(Integer.toString(f.getFailureCode())))
				em.merge(f);
		}
		// bdv.setFailureFirst(false);
	}

	/**
	 * Returns the total number of call failures within a certain time period
	 * based on the phoneType.
	 */
	//DONE!!
	public Collection<Long> getTotalFailuresOfSpecificPhone(String phoneType, String startDate, String endDate) {

		Timestamp dbStartDate = new Timestamp(dateFormatter(startDate)
				.getTime());
		Timestamp dbEndDate = new Timestamp(dateFormatter(endDate).getTime());

		return em
				.createQuery("SELECT COUNT(*) FROM BaseData bd WHERE bd.ueMap.tac in (select ue2.tac from UE_Table ue2 where ue2.model = :tac)  AND bd.dateAndTime > :startdate AND bd.dateAndTime < :enddate")
				.setParameter("tac", phoneType)
				.setParameter("startdate", dbStartDate, TemporalType.TIMESTAMP)
				.setParameter("enddate", dbEndDate, TemporalType.TIMESTAMP)
				.getResultList();

	}

	/**
	 * Returns the total number of call failures within a certain time period
	 * based on the imsi number.
	 */
	//works
	public Collection<Long> getTotalFailuresOfSpecificIMSI(BigInteger imsi,
			String startDate, String endDate) {

		Timestamp dbStartDate = new Timestamp(dateFormatter(startDate)
				.getTime());
		Timestamp dbEndDate = new Timestamp(dateFormatter(endDate).getTime());

		return em.createQuery(
						"SELECT COUNT(*) FROM BaseData bd WHERE bd.imsi = :imsi AND bd.dateAndTime > :startdate AND bd.dateAndTime < :enddate")
				.setParameter("imsi", imsi)
				.setParameter("startdate", dbStartDate)
				.setParameter("enddate", dbEndDate).getResultList();
	}

	/**
	 * Returns for a given phone type all the unique failure Event Id and Cause
	 * Code combinations they have exhibited and the number of occurrences.
	 */
//done
	public Collection<Object> getAllCallFailuresAndTotalDurationPerIMSI(BigInteger imsi, String startDate, String endDate) {

		Timestamp dbStartDate = new Timestamp(dateFormatter(startDate).getTime());
		Timestamp dbEndDate = new Timestamp(dateFormatter(endDate).getTime());

		return em.createQuery("SELECT imsi, COUNT(*), SUM(duration) FROM BaseData bd WHERE bd.imsi = :imsi AND bd.dateAndTime > :startdate AND bd.dateAndTime < :enddate")
				.setParameter("imsi", imsi)
				.setParameter("startdate", dbStartDate, TemporalType.TIMESTAMP)
				.setParameter("enddate", dbEndDate, TemporalType.TIMESTAMP)
				.getResultList();
	}

	public Collection<Object> getAllUniqueEventCausecodeCombinations(String model) {

		return em.createQuery("select u.model, b.eventCauseMap.eventId, ec.description, b.eventCauseMap.causeCode , count(*) as occurences  FROM BaseData b, EventCause ec, UE_Table u where b.ueMap.tac = u.tac AND ec.eventId = b.eventCauseMap.eventId AND ec.causeCode = b.eventCauseMap.causeCode AND u.model = :phoneModel group by b.eventCauseMap.eventId, b.eventCauseMap.causeCode, ec.description order by occurences desc")
				.setParameter("phoneModel", model).getResultList();
	}

	public Collection<BigInteger> getAllPhoneTypes() {
		return em.createQuery("SELECT DISTINCT bd.ueMap.tac from BaseData bd").getResultList();
	}

	public Date dateFormatter(String date) {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date newDate = null;
		try {
			newDate = format.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return newDate;
		// DateTimeFormatter parser =
		// DateTimeFormat.forPattern("MM/dd/yyyy HH:mm:ss");
		// dt = DateTime.parse("10/02/2013 20:00:00", parser);
	}

	public Collection<String> getAllDistinctPhoneModels() {

		return em.createQuery("SELECT DISTINCT u.model FROM UE_Table u").getResultList();
	}
	
	public long getLastRowId(){
		 List<Long> listofBds = (List<Long>) em.createQuery("SELECT count(*) FROM BaseData b").getResultList();
		 return listofBds.get(0);
	}
	
	/**
	 * 
	 */
	public Collection<BaseData> getTopTenImsiDuringPeriod(String startDate, String endDate){
		Timestamp dbStartDate = new Timestamp(dateFormatter(startDate).getTime());
		Timestamp dbEndDate = new Timestamp(dateFormatter(endDate).getTime());
		return em.createQuery("SELECT imsi, COUNT(bd.imsi) FROM BaseData bd WHERE bd.dateAndTime > :startdate AND bd.dateAndTime < :enddate group by bd.imsi order by count(bd.imsi) DESC")
				.setMaxResults(10)
				.setParameter("startdate", dbStartDate, TemporalType.TIMESTAMP)
				.setParameter("enddate", dbEndDate, TemporalType.TIMESTAMP)
				.getResultList();
	
	}
	
	public Collection<BaseData> getTopTenImsiDuringPeriodDetails(String startDate, String endDate, BigInteger imsi){
		Timestamp dbStartDate = new Timestamp(dateFormatter(startDate).getTime());
		Timestamp dbEndDate = new Timestamp(dateFormatter(endDate).getTime());
		return em.createQuery("SELECT DISTINCT bd.eventCauseMap.description, COUNT(bd.imsi) FROM BaseData bd WHERE bd.dateAndTime > :startdate AND bd.dateAndTime < :enddate AND"
				+ " bd.imsi=:imsi GROUP BY bd.eventCauseMap.description ORDER BY COUNT(bd.imsi) DESC")
				.setMaxResults(10)
				.setParameter("startdate", dbStartDate, TemporalType.TIMESTAMP)
				.setParameter("enddate", dbEndDate, TemporalType.TIMESTAMP)
				.setParameter("imsi",imsi)
				.getResultList();
		
		
	}

	/**
	 * #14 Me and Gio
	 */
	@Override
	public Collection<BigInteger> imsiEffectedByAFailureCauseClass(String failureClass) {
		Query q = em.createQuery("select DISTINCT bd.imsi from BaseData bd,Failure_Class_Table f where bd.failureMap.FailureCode = f.FailureCode AND bd.failureMap.description = :failureClass");
		q.setParameter("failureClass", failureClass);
		return (Collection<BigInteger>) q.getResultList();
	}

	/**
	 * #14 Me and Gio
	 */
	@Override
	public Collection<String> getFailureDescriptionForDropDown() {
		Query q = em.createQuery("Select f.description from Failure_Class_Table f");
		return q.getResultList();
	}

	//TODO
	public Collection<Object> getAllCauseCodeAndDescByIMSI(BigInteger imsi) {
		return em
				.createQuery(
						"SELECT DISTINCT bd.eventCauseMap.causeCode, ec.description FROM EventCause ec, BaseData bd WHERE bd.eventCauseMap.causeCode = ec.causeCode AND bd.eventCauseMap.eventId = ec.eventId AND bd.imsi = :imsi")
				.setParameter("imsi", imsi).getResultList();
	}

	@Override
	public void putErrorData(Collection<BaseDataError> bderrors) {
		int inserted=0;
		for (BaseDataError basedata : bderrors) {
			
			System.out.println("Errors inserting: " + inserted);
			em.persist(basedata);
			inserted++;
		}
		
	}

	@Override
	public Collection<BigInteger> getUS11(String start, String end) {
		// TODO Auto-generated method stub
		Timestamp dbStartDate = new Timestamp(dateFormatter(start).getTime());
		Timestamp dbEndDate = new Timestamp(dateFormatter(end).getTime());
		Query q = em.createNativeQuery("select count(*) as occurences, b.Cell_ID, n.Country, n.Operator from Base_Data b, Network n where b.MCC = n.MCC AND b.MNC = n.MNC AND DateTime between ? and ? group by b.MCC,b.MNC,b.Cell_ID order by occurences desc limit 10;");
		q.setParameter(1, dbStartDate);
		q.setParameter(2, dbEndDate);
		return q.getResultList();
	}
	

}

// -------------------------------------MARC NEW
// PART---------------------------------------------------

/*
 * package com.group7.dao.jpa;
 * 
 * import java.math.BigInteger; import java.sql.Timestamp; import
 * java.text.DateFormat; import java.text.ParseException; import
 * java.text.SimpleDateFormat; import java.util.Collection; import
 * java.util.Date;
 * 
 * import javax.ejb.Local; import javax.ejb.Stateless; import
 * javax.ejb.TransactionAttribute; import javax.ejb.TransactionAttributeType;
 * import javax.ejb.TransactionManagement; import
 * javax.ejb.TransactionManagementType; import javax.inject.Inject; import
 * javax.inject.Named; import javax.persistence.EntityManager; import
 * javax.persistence.NamedQueries; import javax.persistence.NamedQuery; import
 * javax.persistence.TemporalType;
 * 
 * import com.group7.dao.BaseDataDAO; import com.group7.entities.BaseData;
 * import com.group7.entities.EventCause; import com.group7.entities.Failure;
 * import com.group7.entities.Network; import com.group7.entities.UE; import
 * com.group7.importBaseData.BaseDataValidation;
 * 
 * @Named
 * 
 * @NamedQueries({ @NamedQuery(name = "BaseData.getAll", query =
 * "select bd from baseData bd") })
 * 
 * @Local
 * 
 * @Stateless
 * 
 * @TransactionManagement(TransactionManagementType.CONTAINER) public class
 * BaseDataDAOImpl implements BaseDataDAO {
 * 
 * // @PersistenceContext
 * 
 * @Inject EntityManager em;
 * 
 * BaseDataValidation bdv = BaseDataValidation.getInstance();
 * 
 * public Collection<BaseData> getAllBaseData() { return (Collection<BaseData>)
 * em.createQuery( "select bd from BaseData bd").getResultList(); }
 * 
 * @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW) public void
 * addBaseData(BaseData basedata) { em.persist(basedata); }
 * 
 * @TransactionAttribute(TransactionAttributeType.REQUIRES_NEW) public void
 * putData(Collection<BaseData> bd) { //
 * System.out.println("valid size "+bd.size()); int count = 0; int inserted = 0;
 * for (BaseData basedata : bd) {
 * 
 * try{ em.merge(basedata.deepCopy()); inserted++; } catch(EntityExistsException
 * eee){ //System.out.println("***************\nEntity exixts exception "
 * +"\n**************"); count++; }
 * 
 * 
 * System.out.println("inserting: " + inserted);
 * em.persist(basedata.deepCopy()); inserted++; } //
 * System.out.println("dupicates "+count);
 * 
 * }
 * 
 * 
 * SELECT Base_Data.IMSI, Base_Data.Cause_Code, Base_Data.EventID,
 * Event_Cause_Table.Description FROM Base_Data, Event_Cause_Table WHERE
 * Base_Data.Cause_Code = Event_Cause_Table.Cause_Code AND Base_Data.EventID =
 * Event_Cause_Table.EventID AND Base_Data.IMSI = 344930000000001;
 * 
 * public Collection<Object> getAllCauseCodeAndEventIdByIMSI(BigInteger imsi) {
 * return em .createQuery(
 * "SELECT bd.imsi, bd.causeCode, bd.eventId, ec.description FROM EventCause ec, BaseData bd WHERE bd.causeCode = ec.causeCode AND bd.eventId = ec.eventId AND bd.imsi = :imsi"
 * ) .setParameter("imsi", imsi).getResultList(); }
 * 
 * public Collection<BigInteger> getUniqueAffectedImsi() { return
 * (Collection<BigInteger>) em.createQuery(
 * "SELECT DISTINCT bd.imsi FROM BaseData bd").getResultList();
 * 
 * }
 * 
 * @Override public Collection<BigInteger> getImsiFailureOverTime(String from,
 * String to) { // TODO Auto-generated method stub Timestamp start = new
 * Timestamp(dateFormatter(from).getTime()); Timestamp end = new
 * Timestamp(dateFormatter(to).getTime());
 * 
 * return (Collection<BigInteger>) em .createQuery(
 * "select DISTINCT bd.imsi from BaseData bd " +
 * "where bd.dateAndTime between :from and :to") .setParameter("from", start,
 * TemporalType.TIMESTAMP) .setParameter("to", end, TemporalType.TIMESTAMP)
 * .getResultList(); }
 * 
 * @Override public void putNetworkData(Collection<Network> networkData) { for
 * (Network n : networkData) { if ((bdv.isNetworkFirst()) ||
 * !bdv.persistCandidateKeysToNetworkTable("" + n.getMcc() + n.getMnc())) //
 * works em.persist(n); } bdv.setNetworkFirst(false); }
 * 
 * @Override public void putUEData(Collection<UE> ueData) { for (UE u : ueData)
 * { if ((bdv.isUeFirst()) ||
 * (!bdv.persistEventCausePrimaryKey(Integer.toString(u .getTac())))) // Failed
 * em.persist(u);
 * 
 * } bdv.setUeFirst(false); }
 * 
 * @Override public void putEventCauseData(Collection<EventCause>
 * eventCauseData) { for (EventCause e : eventCauseData) { if
 * ((bdv.isEventCauseFirst()) || !bdv.persistCandidateKeysToEventCauseTable("" +
 * e.getCauseCode() + e.getEventId())) em.persist(e); }
 * bdv.setEventCauseFirst(false); }
 * 
 * @Override public void putFailureData(Collection<Failure> failureData) { for
 * (Failure f : failureData) { if ((bdv.isFailureFirst()) ||
 * !bdv.persistFailurePrimaryKey(Integer.toString(f .getFailureCode()))) //
 * failed em.persist(f); } bdv.setFailureFirst(false); }
 *//**
 * Returns the total number of call failures within a certain time period
 * based on the phoneType.
 */
/*
 * public Collection<Long> getTotalFailuresOfSpecificPhone( BigInteger
 * phoneType, String startDate, String endDate) {
 * 
 * Timestamp dbStartDate = new Timestamp(dateFormatter(startDate) .getTime());
 * Timestamp dbEndDate = new Timestamp(dateFormatter(endDate).getTime());
 * 
 * return em .createQuery(
 * "SELECT COUNT(*) FROM BaseData bd WHERE bd.tac LIKE :tac AND bd.dateAndTime > :startdate AND bd.dateAndTime < :enddate"
 * ) .setParameter("tac", phoneType) .setParameter("startdate", dbStartDate,
 * TemporalType.TIMESTAMP) .setParameter("enddate", dbEndDate,
 * TemporalType.TIMESTAMP) .getResultList();
 * 
 * }
 *//**
 * Returns the total number of call failures within a certain time period
 * based on the imsi number.
 */
/*
 * public Collection<Long> getTotalFailuresOfSpecificIMSI(BigInteger imsi,
 * String startDate, String endDate) {
 * 
 * Timestamp dbStartDate = new Timestamp(dateFormatter(startDate) .getTime());
 * Timestamp dbEndDate = new Timestamp(dateFormatter(endDate).getTime());
 * 
 * return em .createQuery(
 * "SELECT COUNT(*) FROM BaseData bd WHERE bd.imsi LIKE :imsi AND bd.dateAndTime > :startdate AND bd.dateAndTime < :enddate"
 * ) .setParameter("imsi", imsi) .setParameter("startdate", dbStartDate,
 * TemporalType.TIMESTAMP) .setParameter("enddate", dbEndDate,
 * TemporalType.TIMESTAMP) .getResultList(); }
 *//**
 * Returns for a given phone type all the unique failure Event Id and Cause
 * Code combinations they have exhibited and the number of occurrences.
 */
/*
 * public Collection<Object> getAllCallFailuresAndTotalDurationPerIMSI(
 * BigInteger imsi, String startDate, String endDate) {
 * 
 * Timestamp dbStartDate = new Timestamp(dateFormatter(startDate) .getTime());
 * Timestamp dbEndDate = new Timestamp(dateFormatter(endDate).getTime());
 * 
 * return em .createQuery(
 * "SELECT imsi, COUNT(*), SUM(duration) FROM BaseData bd WHERE bd.imsi LIKE :imsi AND bd.dateAndTime > :startdate AND bd.dateAndTime < :enddate"
 * ) .setParameter("imsi", imsi) .setParameter("startdate", dbStartDate,
 * TemporalType.TIMESTAMP) .setParameter("enddate", dbEndDate,
 * TemporalType.TIMESTAMP) .getResultList(); }
 * 
 * public Collection<Object> getAllUniqueEventCausecodeCombinations( String
 * model) {
 * 
 * return em .createQuery(
 * "select u.model, b.failureClass, b.causeCode , count(*) as occurences from BaseData b, UE_Table u where b.tac = u.tac and u.model = :phoneModel group by b.failureClass, b.causeCode"
 * ) .setParameter("phoneModel", model).getResultList(); }
 * 
 * public Date dateFormatter(String date) { DateFormat format = new
 * SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); Date newDate = null; try { newDate =
 * format.parse(date); } catch (ParseException e) { e.printStackTrace(); }
 * return newDate; // DateTimeFormatter parser = //
 * DateTimeFormat.forPattern("MM/dd/yyyy HH:mm:ss"); // dt =
 * DateTime.parse("10/02/2013 20:00:00", parser); }
 * 
 * public Collection<BigInteger> getAllPhoneTypes() { return
 * em.createQuery("SELECT DISTINCT bd.tac from BaseData bd") .getResultList(); }
 * 
 * public Collection<String> getAllDistinctPhoneModels() {
 * 
 * return em.createQuery("SELECT DISTINCT u.model FROM UE_Table u")
 * .getResultList(); }
 * 
 * }
 */