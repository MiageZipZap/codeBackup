package fr.esiag.isies.pds.dao;

import org.hibernate.Session;

import fr.esiag.isies.pds.model.Doctor;
import fr.esiag.isies.pds.utils.HibernateUtil;

/**
 * Dao for Doctor Class
 * @author PFR
 *
 */
public class DoctorDao extends AbstractEntityDao<Doctor> {

	public Doctor getById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Doctor item = (Doctor) session.get(Doctor.class, id);
		session.close();
		return item;
	}
}
