package fr.esiag.isies.pds.dao;

import java.util.Date;

import org.hibernate.Session;
import org.springframework.core.GenericTypeResolver;

import fr.esiag.isies.pds.model.actor.AbstractEntity;
import fr.esiag.isies.pds.model.actor.Doctor;
import fr.esiag.isies.pds.utils.HibernateUtil;

/**
 * 
 * @author JLA & PFR
 * @param <T extends AbstractEntity> Generic Class
 */
public class Dao<T extends AbstractEntity> {

	/**
	 * Insert item in DataBase
	 * 
	 * @param item
	 * @return item which is inserted
	 */
	public T create(T item) {
		item.setCreateDate(new Date());
		//item.setUpdateUser("WILL BE THE USER LOGIN");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.persist(item);
		session.getTransaction().commit();
		session.close();
		return item;
	}

	/**
	 * Get a doctor by an id
	 * @param id
	 * @return the doctor
	 */
	@SuppressWarnings("unchecked")
	public T getById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		org.hibernate.Query q = session.createQuery("from Doctor where id = "
				+ id);
		T item = (T) q.uniqueResult();
		session.close();
		return item;
	}
}
