package fr.esiag.isies.pds.dao.referential.person;

import java.util.List;

import org.hibernate.Session;

import fr.esiag.isies.pds.dao.AbstractEntityDao;
import fr.esiag.isies.pds.model.Person;
import fr.esiag.isies.pds.utils.HibernateUtil;

public class PersonDao extends AbstractEntityDao<Person> {

	@Override
	public Person getById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Person pers = (Person) session.get(Person.class, id);
		session.close();
		return pers;
	}

	@Override
	public List<Person> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Person> list = (List<Person>) session.createCriteria(Person.class).list();
		session.close();
		return list;
	}

}
