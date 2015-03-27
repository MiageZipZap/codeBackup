package fr.esiag.isies.pds.dao.optimisation.interactionNetwork;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import fr.esiag.isies.pds.dao.AbstractEntityDao;
import fr.esiag.isies.pds.model.optimisation.interactionNetwork.PatientToStaffInteraction;
import fr.esiag.isies.pds.utils.HibernateUtil;

public class PatientToStaffInteractionDao extends AbstractEntityDao<PatientToStaffInteraction> {

	@Override
	public PatientToStaffInteraction getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PatientToStaffInteraction> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<PatientToStaffInteraction> list = (List<PatientToStaffInteraction>) session.createCriteria(PatientToStaffInteraction.class).list();
		session.close();
		return list;
	}

}
