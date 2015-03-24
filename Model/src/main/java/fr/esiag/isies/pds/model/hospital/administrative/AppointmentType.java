package fr.esiag.isies.pds.model.hospital.administrative;

import fr.esiag.isies.pds.model.AbstractType;
/**
 * This class is the model class to design different type  (reasons )of appointment (EXAMEN,CONSULTATION,HOSPITALISATION)
 * @author Glawdys
 *
 */
public class AppointmentType extends AbstractType {

	@Override
	public String toString() {
		return  getLabel();
	}
	
	
}
