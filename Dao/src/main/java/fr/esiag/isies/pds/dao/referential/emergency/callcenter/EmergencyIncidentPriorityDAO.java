package fr.esiag.isies.pds.dao.referential.emergency.callcenter;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import fr.esiag.isies.pds.dao.AbstractTypeDao;
import fr.esiag.isies.pds.model.emergency.callcenter.IncidentPriority;
import fr.esiag.isies.pds.utils.HibernateUtil;

public class EmergencyIncidentPriorityDAO extends AbstractTypeDao<IncidentPriority>{

	@Override
	public IncidentPriority getById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		IncidentPriority item = (IncidentPriority) session.get(IncidentPriority.class, id);
		session.close();
		return item;
	}

	@Override
	public List<IncidentPriority> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Criteria criteria =session.createCriteria(IncidentPriority.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		@SuppressWarnings("unchecked")
		List<IncidentPriority> list = (List<IncidentPriority>) criteria.list();
		session.close();
		return list;
	}
	
}
