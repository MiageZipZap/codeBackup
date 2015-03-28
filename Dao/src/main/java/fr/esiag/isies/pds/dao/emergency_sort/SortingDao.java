package fr.esiag.isies.pds.dao.emergency_sort;

import java.util.List;

import org.hibernate.Session;

import fr.esiag.isies.pds.dao.AbstractEntityDao;
import fr.esiag.isies.pds.model.emergency.sort.*;
import fr.esiag.isies.pds.utils.HibernateUtil;
/**
 * This class provide persistence methods for Sorting
 * @author Meriem 
 * 
 */
public class SortingDao extends AbstractEntityDao<Sorting>{
	
	public Sorting getById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Sorting S=  (Sorting) session.get(Sorting.class, id);
		session.close();
		return S;
	}

	@Override
	public List<Sorting> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}

