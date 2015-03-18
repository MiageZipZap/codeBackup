package fr.esiag.isies.pds.dao.referential.emergency.callcenter;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import fr.esiag.isies.pds.dao.AbstractEntityDao;
import fr.esiag.isies.pds.model.Address;
import fr.esiag.isies.pds.model.emergency.callcenter.EmergencyIncidentTicket;
import fr.esiag.isies.pds.utils.HibernateUtil;

public class EmergencyTicketDAO extends AbstractEntityDao<EmergencyIncidentTicket> {

	@Override
	public EmergencyIncidentTicket create(EmergencyIncidentTicket item) {
		item.setCreateDate(new Date());
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.saveOrUpdate(item);
		session.getTransaction().commit();
		session.close();
		return item;
	}
	@Override
	public EmergencyIncidentTicket getById(int id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		EmergencyIncidentTicket item = (EmergencyIncidentTicket) session.get(EmergencyIncidentTicket.class, id);
		session.close();
		return item;
	}

	@Override
	public List<EmergencyIncidentTicket> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Criteria criteria =session.createCriteria(EmergencyIncidentTicket.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		@SuppressWarnings("unchecked")
		List<EmergencyIncidentTicket> list = (List<EmergencyIncidentTicket>) criteria.list();
		session.close();
		return list;
	}

}
