package fr.esiag.isies.pds.dao.hospital.administrative;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import fr.esiag.isies.pds.dao.AbstractEntityDao;
import fr.esiag.isies.pds.model.hospital.administrative.Appointment;
import fr.esiag.isies.pds.utils.HibernateUtil;


public class AppointmentDao extends AbstractEntityDao<Appointment>{

	@Override
	public Appointment getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Appointment> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Appointment>  getAllByIdHospital(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session
				.createQuery("from Appointment where hospital.id = :id ");
		query.setParameter("id", id);
		List<Appointment> lst = (List<Appointment>) query.list();
		session.close();
		return lst;
	}
}
