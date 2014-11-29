package fr.esiag.isies.pds.businessRules;

import fr.esiag.isies.pds.model.actor.Doctor;

/**
 * 
 * @author PFR & JLA
 *
 */
public class DoctorBusinessRules implements IBusinessRules<Doctor> {
	
	/**
	 * Verify the integrity of data included in the Doctor object
	 * @param doctor
	 * 
	 */
	public boolean verify(Doctor item) {
		if (item.getFirstname() == null) {
			return false;
		}
		
		return true;
	}



}
