package fr.esiag.isies.pds.dao.referential.emergency.callcenter;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import fr.esiag.isies.pds.dao.AbstractEntityDao;
import fr.esiag.isies.pds.model.emergency.callcenter.Caller;
import fr.esiag.isies.pds.utils.HibernateUtil;

public class CallerDAO extends AbstractEntityDao<Caller> {

	@Override
	public Caller getById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Caller item = (Caller) session.get(Caller.class, id);
		session.close();
		return item;
	}

	@Override
	public List<Caller> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Criteria criteria =session.createCriteria(Caller.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		@SuppressWarnings("unchecked")
		List<Caller> list = (List<Caller>) criteria.list();
		session.close();
		return list;
	}

}
