package fr.esiag.isies.pds.dao.hospital.medical;

import java.util.List;

import org.hibernate.Session;

import fr.esiag.isies.pds.dao.AbstractEntityDao;
import fr.esiag.isies.pds.model.hospital.medical.BiologicalAct;
import fr.esiag.isies.pds.utils.HibernateUtil;

public class BiologicalActDao extends AbstractEntityDao <BiologicalAct>{

	@Override
	public BiologicalAct getById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		BiologicalAct bioA=  (BiologicalAct) session.get(BiologicalAct.class, id);
		session.close();
		return bioA;
	}

	@Override
	@SuppressWarnings("unchecked")

	public List<BiologicalAct> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<BiologicalAct> lst = (List<BiologicalAct>) session.createCriteria(BiologicalAct.class).list();
		session.close();
		return lst;
	}

}
