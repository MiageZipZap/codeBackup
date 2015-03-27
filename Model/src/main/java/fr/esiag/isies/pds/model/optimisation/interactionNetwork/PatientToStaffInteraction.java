package fr.esiag.isies.pds.model.optimisation.interactionNetwork;

import fr.esiag.isies.pds.model.referential.person.patient.Patient;
import fr.esiag.isies.pds.model.referential.person.staff.StaffMember;

/**
 * Patient to staff interaction type
 * @author PFR
 *
 */
public class PatientToStaffInteraction extends AbstractInteraction<Patient,StaffMember> {
	//For denormalization state
	public PatientToStaffInteraction() {
		super();
		this.setPersonInteract(new Patient());
		this.setPerson2Interact(new StaffMember());
	}
}
