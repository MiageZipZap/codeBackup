package fr.esiag.isies.pds.dao.referential.organization;

import java.util.List;

import org.hibernate.Session;

import fr.esiag.isies.pds.dao.AbstractEntityDao;
import fr.esiag.isies.pds.model.referential.organization.OrgaType;
import fr.esiag.isies.pds.model.referential.organization.Organization;
import fr.esiag.isies.pds.utils.HibernateUtil;

public class OrgaTypeDao extends AbstractEntityDao<OrgaType> {

	@Override
	public OrgaType getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrgaType> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<OrgaType> list = (List<OrgaType>) session.createCriteria(OrgaType.class).list();
		return list;
	}

}
