package fr.esiag.isies.pds.dao.referential.infrastructure;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import fr.esiag.isies.pds.dao.AbstractEntityDao;
import fr.esiag.isies.pds.model.referential.infrastructure.Infrastructure;
import fr.esiag.isies.pds.utils.HibernateUtil;

/**
 * Dao for infrastructure class
 * 
 * @author ODI, MCH, GKA, PFR
 *
 */
public class InfrastructureDao extends AbstractEntityDao<Infrastructure> {

	/**
	 * will be developed later
	 */
	@Override
	public Infrastructure getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Get all infrastructure which are in an hospital
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Infrastructure>  getAllByIdHospital(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session
				.createQuery("from Infrastructure where hospital.id = :id ");
		query.setParameter("id", id);
		List<Infrastructure> lst = (List<Infrastructure>) query.list();
		session.close();
		return lst;
	}
	
	@Override
	public List<Infrastructure> getAll() {
		//TODO
		return null;
	}

}
