package fr.esiag.isies.pds.dao.hospital.logistics;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import fr.esiag.isies.pds.dao.AbstractEntityDao;
import fr.esiag.isies.pds.dao.IDao;

import fr.esiag.isies.pds.model.hospital.logistics.EquipementAgenda;
import fr.esiag.isies.pds.model.referential.infrastructure.Equipment;
import fr.esiag.isies.pds.model.referential.infrastructure.TypeRefInfra;
import fr.esiag.isies.pds.utils.HibernateUtil;

public class EquipementAgendaDao implements IDao<EquipementAgenda>{

	public EquipementAgenda create(EquipementAgenda item) {
		// TODO Auto-generated method stub
		return null;
	}

	public EquipementAgenda deleteById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public EquipementAgenda getBySlotTimeAndTypeInfra(int slotStart,Date bookedDate,TypeRefInfra typeRefInfra) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Query query = session
				.createQuery("from EquipementAgenda where equipement.typeRefInfra = :typeRefInfra and bookedDate = :bookedDate  and taken = false and slotStart = :slotStart");
		query.setParameter("typeRefInfra", typeRefInfra);
		query.setParameter("bookedDate", bookedDate);
		query.setParameter("slotStart", slotStart);
		List<EquipementAgenda> lst = (List<EquipementAgenda>) query.list();
		session.close();
		if(lst!=null && lst.size()!=0)
		return lst.get(0);
		else return null;
	}

	public EquipementAgenda getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
