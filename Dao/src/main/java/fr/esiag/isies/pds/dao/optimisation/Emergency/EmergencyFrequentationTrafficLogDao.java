package fr.esiag.isies.pds.dao.optimisation.Emergency;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import fr.esiag.isies.pds.dao.AbstractEntityDao;
import fr.esiag.isies.pds.model.AbstractEntity;
import fr.esiag.isies.pds.model.optimisation.EmergencyFrequentationTrafficLog;
import fr.esiag.isies.pds.model.referential.organization.Organization;
import fr.esiag.isies.pds.model.referential.organization.ServiceType;
import fr.esiag.isies.pds.utils.HibernateUtil;

public class EmergencyFrequentationTrafficLogDao{

	
	public List<Integer>  getAllOrganizationInEmergencyTrafficLog() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("SELECT DISTINCT hospital.id FROM EmergencyFrequentationTrafficLog");
		List<Integer> lst = (List<Integer>) query.list();
		session.close();
		return lst;
	}
	

	public ArrayList<EmergencyFrequentationTrafficLog> getById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("from EmergencyFrequentationTrafficLog where hospital.id = :id ");
		query.setParameter("id", id);
		ArrayList<EmergencyFrequentationTrafficLog> lst = (ArrayList<EmergencyFrequentationTrafficLog>) query.list();
		session.close();
		return lst;
	}
	
	public List minDateOfHistory(int orga) throws ParseException{
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("SELECT MIN(dateInputPatient) from EmergencyFrequentationTrafficLog where hospital.id = :id ");
		query.setParameter("id", orga);
		List result = query.list();
		session.close();
		return result;
	}
	
	public List maxDateOfHistory(int orga) throws ParseException{
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("SELECT MAX(dateInputPatient) from EmergencyFrequentationTrafficLog where hospital.id = :id ");
		query.setParameter("id", orga);
		List result = query.list();
		session.close();
		return result;
	}
	public List waitingPatient(int orga, java.util.Date minDate) throws ParseException{
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session.createQuery("SELECT count(*) from EmergencyFrequentationTrafficLog where dateInputPatient < :date AND dateExitBox > :date AND hospital.id = :idorga ");
		query.setParameter("date", minDate);
		query.setParameter("idorga", orga);
		List result = query.list();
		session.close();
		return result;
	}
}
