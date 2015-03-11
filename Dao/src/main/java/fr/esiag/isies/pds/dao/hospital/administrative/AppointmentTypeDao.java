package fr.esiag.isies.pds.dao.hospital.administrative;

import java.util.List;

import org.hibernate.Session;

import fr.esiag.isies.pds.dao.AbstractTypeDao;
import fr.esiag.isies.pds.model.hospital.administrative.AppointmentType;
import fr.esiag.isies.pds.utils.HibernateUtil;

public class AppointmentTypeDao extends AbstractTypeDao<AppointmentType> {

	@Override
	public AppointmentType getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<AppointmentType> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<AppointmentType> lst = (List<AppointmentType>) session.createCriteria(AppointmentType.class).list();
		session.close();
		return lst;
	}

	public AppointmentType getTypeNormal() {
		return findByCode("normal");
	}
	
	public AppointmentType getTypeExamen() {
		return findByCode("exament");
	}
	public AppointmentType getTypeHospitalization() {
		return findByCode("hospitalization");
	}
	
	/**
	 * Get Appointment by code
	 * @param code
	 * @return
	 */
	public AppointmentType findByCode(String code) {
		List<AppointmentType> tmp = getAll();
		for (AppointmentType item : tmp) {
			if (item.getCode().equals(code)) {
				return item;
			}
		}
		return null;
	}
}
