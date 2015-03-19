package fr.esiag.isies.pds.dao.optimisation.Emergency;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import fr.esiag.isies.pds.utils.HibernateUtil;

public class EmergencyFrequentationTrafficLogDao{

	
	public List<Integer>  getAllOrganizationInEmergencyTrafficLog() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Query query = session.createQuery("SELECT DISTINCT hospital.id FROM EmergencyFrequentationTrafficLog");
		List<Integer> lst = (List<Integer>) query.list();
		session.close();
		return lst;
	}
	
}
