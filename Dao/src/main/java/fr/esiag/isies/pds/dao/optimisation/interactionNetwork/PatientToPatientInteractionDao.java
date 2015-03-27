package fr.esiag.isies.pds.dao.optimisation.interactionNetwork;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import fr.esiag.isies.pds.dao.AbstractEntityDao;
import fr.esiag.isies.pds.model.optimisation.interactionNetwork.PatientToPatientInteraction;
import fr.esiag.isies.pds.model.optimisation.interactionNetwork.PatientToStaffInteraction;
import fr.esiag.isies.pds.utils.HibernateUtil;

public class PatientToPatientInteractionDao extends AbstractEntityDao<PatientToPatientInteraction> {

	@Override
	public PatientToPatientInteraction getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PatientToPatientInteraction> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<PatientToPatientInteraction> list = (List<PatientToPatientInteraction>) session.createCriteria(PatientToPatientInteraction.class).list();
		session.close();
		return list;
	}

}
