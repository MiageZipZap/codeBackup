
package fr.esiag.isies.pds.dao.referential.emergency.callcenter;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import fr.esiag.isies.pds.dao.AbstractEntityDao;
import fr.esiag.isies.pds.model.emergency.callcenter.IncidentLocalization;
import fr.esiag.isies.pds.utils.HibernateUtil;

public class IncidentLocalizationDAO extends AbstractEntityDao<IncidentLocalization> {

	@Override
	public IncidentLocalization create(IncidentLocalization item) {
		item.setCreateDate(new Date());
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.saveOrUpdate(item);
		session.getTransaction().commit();
		session.close();
		return item;
	}
	@Override
	public IncidentLocalization getById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		IncidentLocalization item = (IncidentLocalization) session.get(IncidentLocalization.class, id);
		session.close();
		return item;
	}

	@Override
	public List<IncidentLocalization> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Criteria criteria =session.createCriteria(IncidentLocalization.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		@SuppressWarnings("unchecked")
		List<IncidentLocalization> list = (List<IncidentLocalization>) criteria.list();
		session.close();
		return list;
	}
	
}
