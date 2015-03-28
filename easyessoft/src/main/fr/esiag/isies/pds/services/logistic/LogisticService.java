package fr.esiag.isies.pds.services.logistic;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import fr.esiag.isies.pds.dao.hospital.logistics.EquipementAgendaDao;
import fr.esiag.isies.pds.dao.hospital.logistics.InfrastructureAgendaDao;
import fr.esiag.isies.pds.dao.hospital.logistics.MapActMedicalResourceDao;
import fr.esiag.isies.pds.dao.hospital.logistics.StaffAgendaDao;
import fr.esiag.isies.pds.model.hospital.logistics.Agenda;
import fr.esiag.isies.pds.model.hospital.logistics.EquipementAgenda;
import fr.esiag.isies.pds.model.hospital.logistics.InfrastructureAgenda;
import fr.esiag.isies.pds.model.hospital.logistics.MapActMedicalResource;
import fr.esiag.isies.pds.model.hospital.logistics.StaffAgenda;
import fr.esiag.isies.pds.model.referential.infrastructure.TypeRefInfra;
import fr.esiag.isies.pds.model.referential.person.staff.Profession;

public class LogisticService {
	private StaffAgendaDao staffAgendaDao;
	private InfrastructureAgendaDao infrastructureAgendaDao;
	private EquipementAgendaDao equipementAgendaDao;
	private MapActMedicalResourceDao mapActMedicalResourceDao;

	public LogisticService() {
		super();
		staffAgendaDao = new StaffAgendaDao();
		infrastructureAgendaDao = new InfrastructureAgendaDao();
		equipementAgendaDao = new EquipementAgendaDao();
		mapActMedicalResourceDao = new MapActMedicalResourceDao();
	}

	public List<Agenda> getResourceForAnActMedical(String actMedical) {
		MapActMedicalResource mapMedicalResource = mapActMedicalResourceDao
				.getByActMedical(actMedical);
		List<Agenda> list = getResourceForAnAct(
				mapMedicalResource.getProfession(),
				mapMedicalResource.getTypeRefInfraInfra(),
				mapMedicalResource.getTypeRefInfraEquipment());
		return list;
	}

	private List<Agenda> getResourceForAnAct(Profession profession,
			TypeRefInfra typeRefInfraInfrastructure,
			TypeRefInfra typeRefInfraEquipement) {
		List<Agenda> list = new ArrayList<Agenda>();
		Date bookedDate = new Date();
		for (int j = 0; j < 10; j++) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Calendar c = Calendar.getInstance();
			c.setTime(bookedDate);
			c.add(Calendar.DATE, j);

			for (int slotStart = 0; slotStart < 23; slotStart++) {
				StaffAgenda staffAgenda = staffAgendaDao
						.getBySlotTimeAndTypeInfra(slotStart, c.getTime(),
								profession);
				EquipementAgenda equipementAgenda = equipementAgendaDao
						.getBySlotTimeAndTypeInfra(slotStart, c.getTime(),
								typeRefInfraEquipement);
				InfrastructureAgenda infrastructureAgenda = infrastructureAgendaDao
						.getBySlotTimeAndTypeInfra(slotStart, c.getTime(),
								typeRefInfraInfrastructure);
				if (equipementAgenda != null && infrastructureAgenda != null
						&& staffAgenda != null) {
					Agenda agenda = new Agenda();
					agenda.setEquipementAgenda(equipementAgenda);
					agenda.setStaffAgenda(staffAgenda);
					agenda.setInfrastructureAgenda(infrastructureAgenda);
					list.add(agenda);
				}
			}
		}
		return list;
	}
}
