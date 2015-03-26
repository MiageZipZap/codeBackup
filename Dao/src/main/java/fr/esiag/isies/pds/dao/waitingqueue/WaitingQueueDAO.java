package fr.esiag.isies.pds.dao.waitingqueue;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import fr.esiag.isies.pds.dao.AbstractEntityDao;
import fr.esiag.isies.pds.model.congestion.EmergencyActivity;
import fr.esiag.isies.pds.model.waitingqueue.WaitingQueue;
import fr.esiag.isies.pds.utils.HibernateUtil;

public class WaitingQueueDAO extends AbstractEntityDao<WaitingQueue>{
	
	
	public List<WaitingQueue> getPatientsByCriteria(int idService, int idOrganization, int priority, boolean inQueue, boolean inBoxs, boolean exits) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		DetachedCriteria dc = DetachedCriteria.forClass(WaitingQueue.class, "table0");
		dc.add(Restrictions.eq("idService", idService));
		dc.add(Restrictions.eq("idOrganization", idOrganization));
		dc.add(Restrictions.gt("idPatient", 0));	
        dc.add(Restrictions.between("timeQueueState", new Date(System.currentTimeMillis() - 60 * 60 * 12 * 1000), new Date()));
		dc.setProjection(Projections.projectionList()
		        	.add(Projections.groupProperty("idPatient"))
		            .add(Projections.max("timeQueueState"))
		);		
		
		Criteria criteria =session.createCriteria(WaitingQueue.class, "table2").setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		criteria.add(Subqueries.propertiesIn(new String[] {"idPatient","timeQueueState"}, dc));
		
		criteria.addOrder(Order.desc("timeQueueState"));
		if(priority >= 1) {
			criteria.add(Restrictions.eq("priority", priority));
		}
		
		if(inQueue) {
			criteria.add(Restrictions.eq("idBox", 0));
			criteria.add(Restrictions.eq("idDoctor", -1));
		}
		else if(inBoxs) {
			criteria.add(Restrictions.not(Restrictions.eq("idBox", 0)));	
			criteria.add(Restrictions.not(Restrictions.eq("idDoctor", -1)));	
		}
		else if(exits) {
			criteria.add(Restrictions.eq("idBox", -1));
			criteria.add(Restrictions.eq("idDoctor", -1));
		}
		
		return criteria.list();
	}
	
	public void updatePatientStatus(EmergencyActivity ea){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(ea);
		session.getTransaction().commit();
		session.close();
	}
	
	@Override
	public WaitingQueue getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WaitingQueue> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	public List<WaitingQueue> getWaitingPatient(int idOrganisation,
			int idService) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String hql = "FROM WaitingQueue WHERE tp_waiting_queue_id_organization = "
				+ idOrganisation
				+ " AND tp_waiting_queue_id_service = "
				+ idService + " AND tp_waiting_queue_id_box = 0 AND tp_waiting_queue_id_patient NOT IN (SELECT idPatient FROM WaitingQueue WHERE idOrganization = "
				+ idOrganisation
				+ " AND idService = "
				+ idService
				+ " AND idBox = 999)";
		Query query = session.createQuery(hql);
		@SuppressWarnings("unchecked")
		List<WaitingQueue> results = (List<WaitingQueue>) query.list();
		session.close();
		return results;

	}

	public List<WaitingQueue> getTreatedPatient(int idOrganisation,
			int idService) {
		GregorianCalendar date = new GregorianCalendar();
		date.add(Calendar.DAY_OF_MONTH, -1);
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String hql = "FROM WaitingQueue WHERE tp_waiting_queue_id_organization = "
				+ idOrganisation
				+ " AND tp_waiting_queue_id_service = "
				+ idService
				+ " AND tp_waiting_queue_id_box = 999 AND tp_waiting_queue_time_queue_state > :date";
		Query query = session.createQuery(hql);
		query.setTimestamp("date", date.getTime());
		@SuppressWarnings("unchecked")
		List<WaitingQueue> results = (List<WaitingQueue>) query.list();
		session.close();

		return results;
	}
	
	public List<WaitingQueue> getDayPatients(int idOrganisation,
			int idService) {
		GregorianCalendar date = new GregorianCalendar();
		date.add(Calendar.DAY_OF_MONTH, -1);
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		String hql1 = "FROM WaitingQueue WHERE (idPatient,timeQueueState) IN (SELECT idPatient, MAX(timeQueueState) FROM WaitingQueue WHERE idOrganization = "
				+ idOrganisation
				+ " AND idService = "
				+ idService
				+ "GROUP BY idPatient)";
		Query query1 = session.createQuery(hql1);
		@SuppressWarnings("unchecked")
		List<WaitingQueue> results = (List<WaitingQueue>) query1.list();
		session.close();

		return results;
	}

	public int getNbrPatientInQueue(int idOrganisation, int idService) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session
				.createQuery("select count(*) from WaitingQueue where idOrganization = "
				+ idOrganisation
				+ " AND idService = "
				+ idService
				+ " AND idBox = :idBox");
		query.setString("idBox", "0");

		int nbr = ((Long) query.uniqueResult()).intValue();
		session.close();
		return nbr;
	}
}
