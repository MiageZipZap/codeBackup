package fr.esiag.isies.pds.dao.hospital.administrative;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import fr.esiag.isies.pds.dao.AbstractTypeDao;
import fr.esiag.isies.pds.model.hospital.administrative.AppointmentTypeSpeciality;
import fr.esiag.isies.pds.model.referential.infrastructure.Infrastructure;
import fr.esiag.isies.pds.utils.HibernateUtil;

public class AppointmentTypeSpecialityDao extends AbstractTypeDao<AppointmentTypeSpeciality>{

	@Override
	public AppointmentTypeSpeciality getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<AppointmentTypeSpeciality> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<AppointmentTypeSpeciality> lst = (List<AppointmentTypeSpeciality>) session.createCriteria(AppointmentTypeSpeciality.class).list();
		session.close();
		return lst;
		
	}
	@SuppressWarnings("unchecked")

	public List<AppointmentTypeSpeciality>  getAllByIdSpeciality(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session
				.createQuery("from AppointmentTypeSpeciality where appointmentType.id = :id ");
		query.setParameter("id", id);
		List<AppointmentTypeSpeciality> lst = (List<AppointmentTypeSpeciality>) query.list();
		session.close();
		return lst;
	}
}
