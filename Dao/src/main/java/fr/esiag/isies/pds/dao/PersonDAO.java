package fr.esiag.isies.pds.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import fr.esiag.isies.pds.model.Person;
import fr.esiag.isies.pds.utils.HibernateUtil;

public class PersonDAO extends AbstractEntityDao<Person> {

	@Override
	public Person getById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Person item = (Person) session.get(Person.class, id);
		session.close();
		return item;
	}

	@Override
	public List<Person> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Criteria criteria =session.createCriteria(Person.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		@SuppressWarnings("unchecked")
		List<Person> list = (List<Person>) criteria.list();
		session.close();
		return list;
	}

}
