package fr.esiag.isies.pds.dao.referential.person.patient;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

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
	
	public Patient getByNIR(String nir) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Criteria cr = session.createCriteria(Patient.class);
		cr.add(Restrictions.eq("nir", nir));
		Patient patientFound = (Patient) cr.list().get(0);
		session.close();
		return patientFound;
	}
	
	public List<Patient> getByOrgaID(int OrgaID) {
		// TODO Auto-generated method stub
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Criteria cr = session.createCriteria(Patient.class);
		cr.add(Restrictions.eq("idOrganization", OrgaID));
		List<Patient> patientList = cr.list();
		session.close();
		return patientList;
	}
	
	public void update(Patient patient){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.merge(patient);
		session.close();
		
	}
}
