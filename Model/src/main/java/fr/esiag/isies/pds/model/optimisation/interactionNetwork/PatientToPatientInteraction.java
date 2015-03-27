package fr.esiag.isies.pds.model.optimisation.interactionNetwork;

import fr.esiag.isies.pds.model.referential.person.patient.Patient;

/**
 * Patient to patient interaction type
 * @author PFR
 *
 */
public class PatientToPatientInteraction extends
		AbstractInteraction<Patient, Patient> {
	// For denormalization state
	public PatientToPatientInteraction() {
		super();
		this.setPersonInteract(new Patient());
		this.setPerson2Interact(new Patient());
	}
}
