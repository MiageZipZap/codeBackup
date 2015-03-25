package fr.esiag.isies.pds.dao.referential.emergency.callcenter;

import java.util.List;

import org.hibernate.Session;

import fr.esiag.isies.pds.dao.AbstractTypeDao;
import fr.esiag.isies.pds.model.emergency.callcenter.IncidentState;
import fr.esiag.isies.pds.utils.HibernateUtil;

public class EmergencyIncidentStateDAO extends AbstractTypeDao<IncidentState> {

	@Override
	public IncidentState getById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		IncidentState item = (IncidentState) session.get(IncidentState.class, id);
		session.close();
		return item;
	}

	@Override
	public List<IncidentState> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<IncidentState> list = (List<IncidentState>) session.createCriteria(IncidentState.class).list();
		session.close();
		return list;
	}

}
