package fr.esiag.isies.pds.dao.referential.medicalRecord;

import java.util.List;

import org.hibernate.Session;

import fr.esiag.isies.pds.dao.AbstractEntityDao;
import fr.esiag.isies.pds.model.referential.medicalRecord.MedicalRecord;
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

	@Override
	public List<MedicalRecord> getAll() {
			Session session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<MedicalRecord> list = (List<MedicalRecord>) session.createCriteria(MedicalRecord.class).list();
			session.close();
			return list;
	}

}
