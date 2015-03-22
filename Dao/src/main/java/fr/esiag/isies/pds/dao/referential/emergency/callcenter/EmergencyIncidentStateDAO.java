package fr.esiag.isies.pds.dao.referential.emergency.callcenter;

import java.util.List;

import org.hibernate.Criteria;
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
		Criteria criteria =session.createCriteria(IncidentState.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		@SuppressWarnings("unchecked")
		List<IncidentState> list = (List<IncidentState>) criteria.list();
		session.close();
		return list;
	}

}
