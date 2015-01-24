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

	
	@SuppressWarnings("unchecked")
	public List<Infrastructure>  getAllByIdHospital(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session
				.createQuery("from tr_infra_infrastructure where idtr_organization = :id ");
		query.setParameter("id", id);
		return (List<Infrastructure>) query.list();
	}
	@Override
	public List<Infrastructure> getAll() {
		//TODO
		return null;
	}

}
