package fr.esiag.isies.pds.dao.hospital.medical;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import fr.esiag.isies.pds.dao.AbstractEntityDao;
import fr.esiag.isies.pds.model.hospital.medical.CcamAct;
import fr.esiag.isies.pds.utils.HibernateUtil;
/**
 * Dao class for a ccam act
 * @author Glawdys
 *
 */
public class CcamActDao  extends AbstractEntityDao <CcamAct> {

	@Override
	public CcamAct getById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		CcamAct ccamA=  (CcamAct) session.get(CcamAct.class, id);
		session.close();
		return ccamA;
	}
	/**
	 * use to retrieve ccam act by well known code
	 * @param code
	 * @return
	 */
	public CcamAct getByCode(String code) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		CcamAct ccamA=  (CcamAct) session.get(CcamAct.class, code);
		session.close();
		return ccamA;
	}
		/**
		 * method to get all the act from ccam referential
		 */
	@SuppressWarnings("unchecked")
	@Override
	public List<CcamAct> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<CcamAct> lst = (List<CcamAct>) session.createCriteria(CcamAct.class).list();
		session.close();
		return lst;
		
	}
	/**
	 * method used to search the primary act 
	 * @param model
	 * @return
	 */
	
	@SuppressWarnings("unchecked")
	public List<CcamAct> getActFromModel(String model){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List <CcamAct> lst =(List<CcamAct>) session.createCriteria(CcamAct.class)
							.add(Restrictions.eq("isPrincipal", 1))
							.add((Restrictions.like("nameAct", "%"+model+"%")))
							.list();
		session.close();
		return lst;
	}
	

}
