package fr.esiag.isies.pds.dao.hospital.logistics;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import fr.esiag.isies.pds.dao.AbstractEntityDao;
import fr.esiag.isies.pds.dao.IDao;
import fr.esiag.isies.pds.model.hospital.logistics.EquipementAgenda;
import fr.esiag.isies.pds.model.hospital.logistics.StaffAgenda;
import fr.esiag.isies.pds.model.referential.infrastructure.Equipment;
import fr.esiag.isies.pds.model.referential.infrastructure.TypeRefInfra;
import fr.esiag.isies.pds.model.referential.person.staff.Profession;
import fr.esiag.isies.pds.utils.HibernateUtil;

public class StaffAgendaDao implements IDao<StaffAgenda>{

	public StaffAgenda create(StaffAgenda item) {
		// TODO Auto-generated method stub
		return null;
	}

	public StaffAgenda deleteById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public StaffAgenda getBySlotTimeAndTypeInfra(int slotStart,Date bookedDate,Profession profession) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session
				.createQuery("from StaffAgenda where profession = :profession and bookedDate = :bookedDate  and taken = false and slotStart = :slotStart");
		query.setParameter("profession", profession);
		query.setParameter("bookedDate", bookedDate);
		query.setParameter("slotStart", slotStart);
		List<StaffAgenda> lst = (List<StaffAgenda>) query.list();
		session.close();
		if(lst!=null && lst.size()!=0)
		return lst.get(0);
		else return null;
	}

	public StaffAgenda getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
