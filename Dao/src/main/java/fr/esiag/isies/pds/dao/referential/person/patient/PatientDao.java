package fr.esiag.isies.pds.dao.referential.person.patient;

import java.util.List;

import org.hibernate.Session;

import fr.esiag.isies.pds.dao.AbstractEntityDao;
import fr.esiag.isies.pds.model.referential.person.patient.Patient;
import fr.esiag.isies.pds.utils.HibernateUtil;


public class PatientDao  extends AbstractEntityDao<Patient>{

	@Override
	public Patient getById(int id) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Patient patient = (Patient) session.get(Patient.class, id);
		session.close();
		return patient;
	}

	@Override
	public List<Patient> getAll() {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Patient> list = (List<Patient>) session.createCriteria(Patient.class).list();
		session.close();
		return list;
	}
	/*		
	public Patient getByAttribute(String firstName, String lastName, Date birthDate) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Patient patient = (Patient) session.get(Patient.class, id);
		
		List mothers = session.createQuery(
			    "select mother from Cat as cat join cat.mother as mother where cat.name = ?")
			    .setString(0, name)
			    .list();
			
		
		session.close();
		return patient;
	}
*/
	
}
