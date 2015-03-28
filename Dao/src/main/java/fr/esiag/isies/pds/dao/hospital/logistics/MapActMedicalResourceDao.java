package fr.esiag.isies.pds.dao.hospital.logistics;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import fr.esiag.isies.pds.dao.IDao;
import fr.esiag.isies.pds.model.hospital.logistics.MapActMedicalResource;
import fr.esiag.isies.pds.model.hospital.logistics.StaffAgenda;
import fr.esiag.isies.pds.utils.HibernateUtil;

public class MapActMedicalResourceDao implements IDao<MapActMedicalResource>{

	public MapActMedicalResource create(MapActMedicalResource item) {
		// TODO Auto-generated method stub
		return null;
	}

	public MapActMedicalResource deleteById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public MapActMedicalResource getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	public MapActMedicalResource getByActMedical(String actMedical) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session
				.createQuery("from MapActMedicalResource where actMedical = :actMedical");
		query.setParameter("actMedical", actMedical);
		List<MapActMedicalResource> lst = (List<MapActMedicalResource>) query.list();
		session.close();
		if(lst!=null && lst.size()!=0)
		return lst.get(0);
		else return null;

	}

}
