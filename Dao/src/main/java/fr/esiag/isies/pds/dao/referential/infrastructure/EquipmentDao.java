package fr.esiag.isies.pds.dao.referential.infrastructure;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import fr.esiag.isies.pds.dao.AbstractEntityDao;
import fr.esiag.isies.pds.model.referential.infrastructure.Equipment;
import fr.esiag.isies.pds.utils.HibernateUtil;

/**
 * Dao for equipment item
 * 
 * @author ODI, MCH, GKA, PFR
 *
 */
public class EquipmentDao extends AbstractEntityDao<Equipment> {

	@Override
	public Equipment getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Equipment> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Get all equipment which are in an hospital
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Equipment>  getAllByIdHospital(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session
				.createQuery("from Equipment where hospital.id = :id ");
		query.setParameter("id", id);
		List<Equipment> lst = (List<Equipment>) query.list();
		session.close();
		return lst;
	}

}
