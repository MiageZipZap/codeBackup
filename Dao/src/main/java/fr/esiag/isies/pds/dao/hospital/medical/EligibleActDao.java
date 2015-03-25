package fr.esiag.isies.pds.dao.hospital.medical;

import java.util.List;

import org.hibernate.Session;

import fr.esiag.isies.pds.dao.AbstractEntityDao;
import fr.esiag.isies.pds.model.hospital.medical.EligibleAct;
import fr.esiag.isies.pds.utils.HibernateUtil;

public class EligibleActDao extends AbstractEntityDao<EligibleAct>{

	@Override
	public EligibleAct getById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		EligibleAct elA=  (EligibleAct) session.get(EligibleAct.class, id);
		session.close();
		return elA;
	}

	@Override
	public List<EligibleAct> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<EligibleAct> getAllByIdPrincipal() {
		return null;
	}
}
