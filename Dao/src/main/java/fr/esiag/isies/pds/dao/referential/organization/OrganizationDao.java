package fr.esiag.isies.pds.dao.referential.organization;

import java.util.List;

import org.hibernate.Session;

import fr.esiag.isies.pds.dao.AbstractEntityDao;
import fr.esiag.isies.pds.model.Doctor;
import fr.esiag.isies.pds.model.referential.organization.Organization;
import fr.esiag.isies.pds.utils.HibernateUtil;

public class OrganizationDao extends AbstractEntityDao<Organization> {

	@Override
	public Organization getById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Organization item = (Organization) session.get(Organization.class, id);
		session.close();
		return item;
	}

	@Override
	public List<Organization> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Organization> list = (List<Organization>) session.createCriteria(Organization.class).list();
		return list;
	}

}
