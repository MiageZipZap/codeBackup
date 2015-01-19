package fr.esiag.isies.pds.dao.referential.organization;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.metadata.ClassMetadata;

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

	public Organization getBySiret(String mySiret){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Organization myOrganization = (Organization) session.get(Organization.class, mySiret);
		return myOrganization;	
	}
	
	public ArrayList<String> getFieldsNames(){
		ArrayList<String> list = new ArrayList<String>();
		String[] listFields = null;
		Session session = HibernateUtil.getSessionFactory().openSession();
		ClassMetadata classMetadata = session.getSessionFactory().getClassMetadata(Organization.class);
		listFields = classMetadata.getPropertyNames();
		for(int i=0;i<listFields.length;i++){
			list.add(listFields[i]);
		}
		return list;
	}
	

}
