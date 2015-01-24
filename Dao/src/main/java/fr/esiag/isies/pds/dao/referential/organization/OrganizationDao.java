package fr.esiag.isies.pds.dao.referential.organization;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import fr.esiag.isies.pds.dao.AbstractEntityDao;
import fr.esiag.isies.pds.model.referential.organization.Organization;
import fr.esiag.isies.pds.utils.HibernateUtil;
/**
 * This class provide persistence methods for Organization entity 
 * @author JLA SKO OSA ADA JSB
 * 
 */
public class OrganizationDao extends AbstractEntityDao<Organization> {

	@Override
	public Organization getById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Organization item = (Organization) session.get(Organization.class, id);
		item.getServicesSet();
		session.close();
		return item;
	}

	@Override
	public List<Organization> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Criteria criteria =session.createCriteria(Organization.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		@SuppressWarnings("unchecked")
		List<Organization> list = (List<Organization>) criteria.list();
		return list;
	}

	public Organization getBySiret(String mySiret){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Organization myOrganization = (Organization) session.get(Organization.class, mySiret);
		return myOrganization;	
	}
}
