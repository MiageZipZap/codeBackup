package fr.esiag.isies.pds.dao.referential.infrastructure;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import fr.esiag.isies.pds.dao.AbstractEntityDao;
import fr.esiag.isies.pds.model.referential.infrastructure.Medicine;
import fr.esiag.isies.pds.utils.HibernateUtil;

public class MedicineDao extends AbstractEntityDao<Medicine> {

	@Override
	public Medicine getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Medicine> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Get all medicine which are in an hospital
	 * @param id
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Medicine>  getAllByIdHospital(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session
				.createQuery("from Medicine where hospital.id = :id ");
		query.setParameter("id", id);
		List<Medicine> lst = (List<Medicine>) query.list();
		session.close();
		return lst; 
	}
}
