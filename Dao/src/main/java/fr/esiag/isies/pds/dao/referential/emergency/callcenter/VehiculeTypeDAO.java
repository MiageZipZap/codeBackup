package fr.esiag.isies.pds.dao.referential.emergency.callcenter;

import java.util.List;

import org.hibernate.Session;

import fr.esiag.isies.pds.dao.AbstractTypeDao;
import fr.esiag.isies.pds.model.emergency.callcenter.VehiculeType;
import fr.esiag.isies.pds.utils.HibernateUtil;

public class VehiculeTypeDAO extends AbstractTypeDao<VehiculeType>{

	@Override
	public VehiculeType getById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		VehiculeType item = (VehiculeType) session.get(VehiculeType.class, id);
		session.close();
		return item;
	}

	@Override
	public List<VehiculeType> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<VehiculeType> list = (List<VehiculeType>) session.createCriteria(VehiculeType.class).list();
		session.close();
		return list;
	}

}
