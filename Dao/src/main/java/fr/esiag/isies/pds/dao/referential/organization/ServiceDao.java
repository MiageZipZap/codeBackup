package fr.esiag.isies.pds.dao.referential.organization;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;

import fr.esiag.isies.pds.dao.AbstractEntityDao;
import fr.esiag.isies.pds.model.referential.organization.Organization;
import fr.esiag.isies.pds.model.referential.organization.Service;
import fr.esiag.isies.pds.model.referential.organization.ServiceType;
import fr.esiag.isies.pds.utils.HibernateUtil;

public class ServiceDao extends AbstractEntityDao<Service>{

	@Override
	public Service getById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Service srv=  (Service) session.get(Service.class, id);
		session.close();
		return srv;
	}

	@Override
	public List<Service> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Service> list = (List<Service>) session.createCriteria(Service.class).list();
		session.close();
		return list;
	}
	
	public Service addServices(Service service){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Organization orga = (Organization)new OrganizationDao().getById(service.getIdOrganizaton());
		orga.setServicesSet(service.getServices());
		session.update(orga);
		session.close();
		return service;
	}

}
