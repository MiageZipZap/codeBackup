package fr.esiag.isies.pds.dao.referential.emergency.callcenter;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import fr.esiag.isies.pds.dao.AbstractEntityDao;
import fr.esiag.isies.pds.model.emergency.callcenter.EmergencyIncidentIntervention;
import fr.esiag.isies.pds.utils.HibernateUtil;

public class EmergencyIncidentInterventionDao extends AbstractEntityDao<EmergencyIncidentIntervention> {

	@Override
	public EmergencyIncidentIntervention getById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		EmergencyIncidentIntervention item = (EmergencyIncidentIntervention) session.get(EmergencyIncidentIntervention.class, id);
		session.close();
		return item;
	}

	@Override
	public List<EmergencyIncidentIntervention> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Criteria criteria =session.createCriteria(EmergencyIncidentIntervention.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		@SuppressWarnings("unchecked")
		List<EmergencyIncidentIntervention> list = (List<EmergencyIncidentIntervention>) criteria.list();
		session.close();
		return list;
	}

		/**
	 * get by type
	 * @return get All EmergencyIncident which are of T Type
	 */
	public <T> List<T> getAllByType(Class<T> clazz){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<T> list  =(List<T>) session.createCriteria(clazz).list();
		session.close();
		return list;
	}
}