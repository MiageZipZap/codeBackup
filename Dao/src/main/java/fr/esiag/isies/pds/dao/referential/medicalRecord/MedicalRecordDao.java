package fr.esiag.isies.pds.dao.referential.medicalRecord;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import fr.esiag.isies.pds.dao.AbstractEntityDao;
import fr.esiag.isies.pds.model.referential.medicalRecord.MedicalRecord;
import fr.esiag.isies.pds.model.referential.person.patient.Patient;
import fr.esiag.isies.pds.utils.HibernateUtil;

public class MedicalRecordDao extends AbstractEntityDao<MedicalRecord> {

	@Override
	public MedicalRecord getById(int id) {		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		MedicalRecord mrec = (MedicalRecord) session.get(MedicalRecord.class, id);
		session.close();
		return mrec;
	}
	
	public MedicalRecord getByPatientId(int patientID) {		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Criteria cr = session.createCriteria(MedicalRecord.class);
		cr.add(Restrictions.eq("patient.id", patientID));
		MedicalRecord mdr = (MedicalRecord) cr.uniqueResult();
		session.close();
		return mdr;
	}

	@Override
	public List<MedicalRecord> getAll() {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<MedicalRecord> list = (List<MedicalRecord>) session.createCriteria(MedicalRecord.class).list();
			session.close();
			return list;
	}
	
	public void update(MedicalRecord medicalRecord){
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.merge(medicalRecord);
		session.close();
		
	}

}