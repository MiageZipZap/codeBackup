package fr.esiag.isies.pds.dao.hospital.administrative;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import fr.esiag.isies.pds.dao.AbstractTypeDao;
import fr.esiag.isies.pds.model.hospital.administrative.AppointmentType;
import fr.esiag.isies.pds.model.hospital.administrative.AppointmentTypeSpeciality;
import fr.esiag.isies.pds.utils.HibernateUtil;
/**
 * DAO class for appointment type
 * @author Glawdys
 *
 */
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

	
	/*public List<AppointmentType> getAllBySpeciality(AppointmentTypeSpeciality appointmentTS) {
		List<AppointmentType> lstAppointmentType = new ArrayList<AppointmentType>();
		List<AppointmentType> tmp = getAll();
		for (AppointmentType item : tmp) {
			if (item.getAppointTS().getCode().equals(appointmentTS.getCode())) {
				lstAppointmentType.add(item);
			}
		}
		return lstAppointmentType;
	}*/


}
