package fr.esiag.isies.pds.dao.optimisation.interactionNetwork;

import java.util.ArrayList;
import java.util.List;

import fr.esiag.isies.pds.model.optimisation.interactionNetwork.AbstractInteraction;
import fr.esiag.isies.pds.model.referential.person.patient.Patient;
import fr.esiag.isies.pds.model.referential.person.staff.StaffMember;

public class InteractionNetworkDao {
	public List<AbstractInteraction<?,?>> getInteractions() {
//		List<AbstractInteraction<?,?>> temp = new ArrayList<AbstractInteraction<?,?>>();
//		
//		Infrastructure i = new Infrastructure();
//		i.setLabel("Box1");
//		i.setId(2);
//		Infrastructure i2 = new Infrastructure();
//		i2.setLabel("Salle d'attente");
//		i2.setId(1);
//		Infrastructure i3 = new Infrastructure();
//		i3.setLabel("Box2");
//		i3.setId(3);
//		
//		Patient p = new Patient();
//		p.setFirstName("Annick");
//		p.setId(3);
//		StaffMember p2 = new StaffMember();
//		p2.setFirstName("Peter");
//		p2.setId(4);
//		Patient p3 = new Patient();
//		p3.setFirstName("Jacques");
//		p3.setId(1);
//		Patient p4 = new Patient();
//		p4.setFirstName("Frank");
//		p4.setId(2);
//		Patient p6 = new Patient();
//		p6.setFirstName("Camille");
//		p6.setId(6);
//		StaffMember p7 = new StaffMember();
//		p7.setFirstName("Guy");
//		p7.setId(7);
//		Patient p8 = new Patient();
//		p8.setFirstName("Johanna");
//		p8.setId(8);
//		Patient p9 = new Patient();
//		p9.setFirstName("Samuel");
//		p9.setId(9);
//		
//		AbstractInteraction<Patient, StaffMember> p2s1 = new PatientToStaffInteraction();
//		p2s1.setPersonInteract(p);
//		p2s1.setPerson2Interact(p2);
//		p2s1.setInfrastructure(i);
//		temp.add(p2s1);
//		AbstractInteraction<Patient, StaffMember> p2s2 = new PatientToStaffInteraction();
//		p2s2.setPersonInteract(p3);
//		p2s2.setPerson2Interact(p2);
//		p2s2.setInfrastructure(i);
//		temp.add(p2s2);
//		AbstractInteraction<Patient, StaffMember> p2s3 = new PatientToStaffInteraction();
//		p2s3.setPersonInteract(p4);
//		p2s3.setPerson2Interact(p2);
//		p2s3.setInfrastructure(i);
//		temp.add(p2s3);
//		AbstractInteraction<Patient, StaffMember> p2s4 = new PatientToStaffInteraction();
//		p2s4.setPersonInteract(p6);
//		p2s4.setPerson2Interact(p7);
//		p2s4.setInfrastructure(i3);
//		temp.add(p2s4);
//		AbstractInteraction<Patient, StaffMember> p2s5 = new PatientToStaffInteraction();
//		p2s5.setPersonInteract(p8);
//		p2s5.setPerson2Interact(p7);
//		p2s5.setInfrastructure(i3);
//		temp.add(p2s5);
//		AbstractInteraction<Patient, StaffMember> p2s6 = new PatientToStaffInteraction();
//		p2s6.setPersonInteract(p9);
//		p2s6.setPerson2Interact(p7);
//		p2s6.setInfrastructure(i3);
//		temp.add(p2s6);
//		
//		AbstractInteraction<Patient, Patient> p2p1 = new PatientToPatientInteraction();
//		p2p1.setPersonInteract(p);
//		p2p1.setPerson2Interact(p3);
//		p2p1.setInfrastructure(i2);
//		temp.add(p2p1);
//		AbstractInteraction<Patient, Patient> p2p2 = new PatientToPatientInteraction();
//		p2p2.setPersonInteract(p);
//		p2p2.setPerson2Interact(p4);
//		p2p2.setInfrastructure(i2);
//		temp.add(p2p2);
//		AbstractInteraction<Patient, Patient> p2p3 = new PatientToPatientInteraction();
//		p2p3.setPersonInteract(p4);
//		p2p3.setPerson2Interact(p6);
//		p2p3.setInfrastructure(i2);
//		temp.add(p2p3);
		List<AbstractInteraction<?,?>> interactions = new ArrayList<AbstractInteraction<?,?>>();
		PatientToStaffInteractionDao patientToStaffInteractionDao = new PatientToStaffInteractionDao();
		for (AbstractInteraction<Patient,StaffMember> item : patientToStaffInteractionDao.getAll()) {
			interactions.add(item);
		}
		PatientToPatientInteractionDao patientToPatientInteractionDao = new PatientToPatientInteractionDao();
		for (AbstractInteraction<Patient,Patient> item : patientToPatientInteractionDao.getAll()) {
			interactions.add(item);
		}
		return interactions;
	}
}
