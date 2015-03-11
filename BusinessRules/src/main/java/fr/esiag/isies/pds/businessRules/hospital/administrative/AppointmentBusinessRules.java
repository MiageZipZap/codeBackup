package fr.esiag.isies.pds.businessRules.hospital.administrative;

import fr.esiag.isies.pds.businessRules.IBusinessRules;
import fr.esiag.isies.pds.model.hospital.administrative.Appointment;


public class AppointmentBusinessRules implements IBusinessRules<Appointment> {

	public boolean verify(Appointment item) {
		if (item == null) {
			return false;
		}	

		if (item.getPatientFirstName().length()> 255 || item.getPatientFirstName().length()< 2) {
			return false;
		}

		if (item.getPatientLastName().length()> 255 || item.getPatientLastName().length()< 2) {
			return false;
		}
		
		if (item.getPatientGender()!="M" || item.getPatientGender()!="F") {
			return false;
		}
		 
		if (item.getDoctorName().length()> 255 || item.getDoctorName().length()< 2) {
			return false;
		}
				
		
		return true;
	}

}
