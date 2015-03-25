package fr.esiag.isies.pds.dao.optimisation.emergency;

import java.text.ParseException;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import fr.esiag.isies.pds.dao.AbstractEntityDao;
import fr.esiag.isies.pds.model.optimisation.EmergencyFrequentationTrafficLog;
import fr.esiag.isies.pds.utils.HibernateUtil;
/**
 * DAO Class to communicate with DB for frequentation emmergency
 * @author Oriel Samama
 *
 */
public class EmergencyFrequentationTrafficLogDao extends AbstractEntityDao<EmergencyFrequentationTrafficLog>{

	/**
	 * Method to recovery all ids of Emergency Service wich concern by history
	 * @return List<Integer> of ids
	 */
	public List<Integer>  getIdOfAllOrganizationInEmergencyTrafficLog() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("SELECT DISTINCT hospital.id FROM EmergencyFrequentationTrafficLog");
		List<Integer> lst = (List<Integer>) query.list();
		session.close();
		return lst;
	}
	/**
	 * Method to recovery Minimum date of history frequentation about emergency service
	 * @param orga
	 * @return List date
	 * @throws ParseException
	 */
	public List getMinDateOfHistory(int orga) throws ParseException{
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("SELECT MIN(dateInputPatient) from EmergencyFrequentationTrafficLog where hospital.id = :id ");
		query.setParameter("id", orga);
		List result = query.list();
		session.close();
		return result;
	}
	/**
	 * Method to recovery Maximum date of history frequentation about emergency service
	 * @param orga
	 * @return List Date
	 * @throws ParseException
	 */
	public List getMaxDateOfHistory(int orga) throws ParseException{
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("SELECT MAX(dateInputPatient) from EmergencyFrequentationTrafficLog where hospital.id = :id ");
		query.setParameter("id", orga);
		List result = query.list();
		session.close();
		return result;
	}
	/**
	 * Method wich return for a date the patient wich attending in emergency service
	 * @param orga
	 * @param minDate
	 * @return List Integer
	 * @throws ParseException
	 */
	public List getWaitingPatientAtDate(int orga, java.util.Date Date) throws ParseException{
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("SELECT count(*) from EmergencyFrequentationTrafficLog where dateInputPatient < :date AND dateExitBox > :date AND hospital.id = :idorga ");
		query.setParameter("date", Date);
		query.setParameter("idorga", orga);
		List result = query.list();
		session.close();
		return result;
	}


	@Override
	public EmergencyFrequentationTrafficLog getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<EmergencyFrequentationTrafficLog> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
