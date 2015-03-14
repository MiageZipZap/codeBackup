package fr.esiag.isies.pds.dao.congestion;

import java.util.List;

import org.hibernate.Session;

import fr.esiag.isies.pds.dao.AbstractEntityDao;
import fr.esiag.isies.pds.model.congestion.EmergencyActivity;
import fr.esiag.isies.pds.utils.HibernateUtil;

public class EmergencyActivityDao extends AbstractEntityDao<EmergencyActivity>{

	@Override
	public EmergencyActivity getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmergencyActivity> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void updatePatientStatus(EmergencyActivity ea){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(ea);
		session.getTransaction().commit();
		session.close();
		
		
	}
	
	

}
