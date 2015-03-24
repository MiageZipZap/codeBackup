package fr.esiag.isies.pds.dao.waitingqueue;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.PropertiesSubqueryExpression;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.Subqueries;

import fr.esiag.isies.pds.dao.AbstractEntityDao;
import fr.esiag.isies.pds.model.congestion.EmergencyActivity;
import fr.esiag.isies.pds.model.referential.organization.Organization;
import fr.esiag.isies.pds.model.waitingqueue.WaitingQueue;
import fr.esiag.isies.pds.utils.HibernateUtil;

public class WaitingQueueDAO extends AbstractEntityDao<WaitingQueue>{
	
	/**
	 * Set the createDate at the date of today before inserted in database
	 * @return 
	 */
	public void insertPatientInQueue(WaitingQueue patientInQueue) {
		//
		//patientInQueue.
		patientInQueue.setTimeQueueState(new Date());
		patientInQueue.setIdBox((Integer) null);
		patientInQueue.setIdDoctor((Integer) null);
		this.create(patientInQueue);
	}

	/**
	 * Set the createDate at the date of today before inserted in database
	 * @return 
	 */
	public void movePatientToBox(WaitingQueue patientInQueue) {
		//
		patientInQueue.setIdBox((Integer) null);
		patientInQueue.setIdDoctor((Integer) null);
		//this.create(patientInQueue);
	}
	
	
	
	
	@Override
	public WaitingQueue getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<WaitingQueue> getAll() {
		
		System.out.println("getALl");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Criteria criteria =session.createCriteria(WaitingQueue.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		Criteria crit = session.createCriteria(WaitingQueue.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		
		
		DetachedCriteria dc = DetachedCriteria.forClass(WaitingQueue.class, "table0");
		dc.add(Restrictions.ge("idOrganization", 43));
		dc.add(Restrictions.ge("idService", 1));
		dc.add(Restrictions.gt("idPatient", 0) );
        dc.add(Restrictions.between("timeQueueState", new Date(System.currentTimeMillis() - 60 * 60 * 12 * 1000), new Date()));
      
		//dc.setProjection(Property.forName("timeQueueState").max());
		//dc.setProjection(Projections.groupProperty("idPatient"));
		dc.setProjection(Projections.projectionList()
		        	.add(Projections.groupProperty("idPatient"))
		            .add(Projections.max("timeQueueState")) 
		        );		
		
		


		DetachedCriteria dc2 = DetachedCriteria.forClass(WaitingQueue.class, "table0");
		//crit2.add(Property.forName("timeQueueState").eq(dc));
		dc2.setProjection(Projections.property("lastTimeQueueState"));
		
		Criteria crit1 = session.createCriteria(WaitingQueue.class, "table2").setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		//crit1.add(Property.forName("timeQueueState").in(dc2));
		//crit1.setProjection(Projections.property("lastTimeQueueState"));
		crit1.add(Subqueries.propertiesIn(new String[] {"idPatient","timeQueueState"}, dc));
		//crit.add(Subqueries.propertiesIn(new String[] {"timeQueueState"}, maxDateQuery));
		
		List<WaitingQueue> inList2 = crit1.list(); 
		
		
		System.out.println(inList2.size());
		
		//System.out.println(inList2.get(0).getTimeQueueState());
		//System.out.println(inList2.get(1).getTimeQueueState().toString());
		//System.out.println(inList2.get(2).getTimeQueueState().toString());
		
	
		
		return inList2;
		
		/*
	    
			
		crit.add(Restrictions.ge("idOrganization", 43));
		crit.add(Restrictions.ge("idService", 1));
        crit.add(Restrictions.between("timeQueueState", new Date(System.currentTimeMillis() - 60 * 60 * 12 * 1000), new Date()));
      
        
        crit.setProjection(Projections.projectionList()
        	.add(Projections.groupProperty("idPatient"))
            .add(Projections.max("timeQueueState"))   
        );		

 
        
        

        
		List<Object> inList = crit.list(); 
		
        //criteria.add(Restrictions.in("timeQueueState", inList));
		//criteria.add(Restrictions.in)
		System.out.println("RESULTAT IN " + crit.list().size());
		System.out.println("okok4ok4");
		System.out.println("ok " + inList.get(0).toString());
		System.out.println("ok " + inList.get(1).toString());
		System.out.println("ok " + inList.get(2).getClass());
		System.out.println("ok " + inList.get(3).toString());

		
		//crit.add(Subqueries.propertiesIn(new String[] {"timeQueueState"}, maxDateQuery));

		//System.out.println("getALl4");
		//@SuppressWarnings("unchecked")
		//List<WaitingQueue> dtlList = crit.list();
		//System.out.println(dtlList.size());
		//System.out.println("getALl5");
		
		//Criteria criteriaIn =session.createCriteria(WaitingQueue.class).setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		
		




		
		
		//List<WaitingQueue> listIn = (List<WaitingQueue>) criteria.list();
		
	    criteria.add(Restrictions.in("timeQueueState", inList));
	    
		@SuppressWarnings("unchecked")
		List<WaitingQueue> list = (List<WaitingQueue>) criteria.list();
		session.close();
		
		//System.out.println("RESULTAT ALL " + criteria.list().size());
		
		return list;
		
		
		/*
		 * 		List result = session.createCriteria(WaitingQueue.class)
                .add(Restrictions.ge("idOrganization", 43)) 
                .add(Restrictions.ge("idService", 1)) 
                .add(Restrictions.ge("idPatient", " > 1 ")) 
                .setProjection(Projections.projectionList()
                        .add(Projections.groupProperty("idPatient"))
                        .add(Projections.max("timeQueueState"))   
                ).list();
		 */
	}
	
	public void updatePatientStatus(EmergencyActivity ea){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.update(ea);
		session.getTransaction().commit();
		session.close();
	}
	
	/*
	 *

	//public List<?> getDoctors(String availabilityStatut) {
	//	SELECT id, firstName + lastName, availabilityStatut
    //    from tr_staff_member
    //    where ((id_service=X) AND (idOrga=X) AND (availabilityStatut=X));
	//}
	
	
	 * 
	 * 
	 */
}
