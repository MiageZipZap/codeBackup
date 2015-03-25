package fr.esiag.isies.pds.dao.hospital.medical;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import fr.esiag.isies.pds.dao.AbstractEntityDao;
import fr.esiag.isies.pds.model.hospital.medical.SubAct;
import fr.esiag.isies.pds.utils.HibernateUtil;
/**
 * Dao class for a sub act
 * @author Glawdys
 *
 */
public class SubActDao extends AbstractEntityDao<SubAct> {

	@Override
	public SubAct getById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		SubAct subA=  (SubAct) session.get(SubAct.class, id);
		session.close();
		return subA;
		
	}

	@Override
	public List<SubAct> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/*@SuppressWarnings("unchecked")
	public List<SubAct> getAllByIdPrimaryAct(int id){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session
				.createQuery("from SubAct where idPrimaryAct = :id ");
		query.setParameter("id", id);
		List<SubAct> lst = (List<SubAct>) query.list();
		session.close();
		return lst;
	}*/

}
