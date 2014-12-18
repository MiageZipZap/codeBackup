package fr.esiag.isies.pds.dao.referential.organization;

import java.util.List;

import org.hibernate.Session;

import fr.esiag.isies.pds.dao.AbstractTypeDao;
import fr.esiag.isies.pds.model.referential.organization.OrgaType;
import fr.esiag.isies.pds.utils.HibernateUtil;

public class OrgaTypeDao extends AbstractTypeDao<OrgaType> {

	@Override
	public OrgaType getById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
        OrgaType orgT=  (OrgaType) session.get(OrgaType.class, id);
		session.close();
		return orgT;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrgaType> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<OrgaType> list = (List<OrgaType>) session.createCriteria(OrgaType.class).list();
		session.close();
		return list;
	}

}
