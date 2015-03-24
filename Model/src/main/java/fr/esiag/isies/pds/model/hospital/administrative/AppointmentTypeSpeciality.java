package fr.esiag.isies.pds.model.hospital.administrative;

import fr.esiag.isies.pds.model.AbstractType;
/**
 * This class is a model class for an appointmentType spéciality ( Cardiologie, psychatrie..)
 * @author Glawdys
 *
 */
public class AppointmentTypeSpeciality extends AbstractType{
	
	private AppointmentType appointmentType;

	public AppointmentType getAppointmentType() {
		return appointmentType;
	}

	public void setAppointmentType(AppointmentType appointmentType) {
		this.appointmentType = appointmentType;
	}

}
