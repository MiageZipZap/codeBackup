package fr.esiag.isies.pds.model.referential.medicalRecord;

import fr.esiag.isies.pds.model.AbstractEntity;
import fr.esiag.isies.pds.model.referential.person.patient.Patient;

/**
 * This class is a model of a MedicalRecord
 * @author LAD
 */
public class MedicalRecord extends AbstractEntity{
	/**
	 * Height of patient
	 */
	private String height; 
	/**
	 * Weight of patient
	 */
	private String weight;
	/**
	 * Blood group of patient 
	 */
	private String bloodGroup;
	/**
	 * Type of patient
	 */
	private String typePatient;
	/**
	 * Status of patient 
	 */
	private String statusPatient;
	/**
	 * Patient which own the medical record 
	 */
	private Patient patient;

	public String getHeight() {
		return height;
	}
	
	public void setHeight(String height) {
		this.height = height;
	}
	
	public String getWeight() {
		return weight;
	}
	
	public void setWeight(String weight) {
		this.weight = weight;
	}
	
	public String getBloodGroup() {
		return bloodGroup;
	}
	
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getTypePatient() {
		return typePatient;
	}

	public void setTypePatient(String typePatient) {
		this.typePatient = typePatient;
	}

	public String getStatusPatient() {
		return statusPatient;
	}

	public void setStatusPatient(String statusPatient) {
		this.statusPatient = statusPatient;
	}
}
