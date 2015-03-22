package fr.esiag.isies.pds.model.referential.person.patient;

import fr.esiag.isies.pds.model.Person;
import fr.esiag.isies.pds.model.referential.medicalRecord.MedicalRecord;

public class Patient extends Person{
	/**
	 * Type of patient
	 */
	private String typePatient;
	/**
	 * Status of patient 
	 */
	private String statusPatient;
	/**
	 * Social security number of patient 
	 */
	private String nir;
	/**
	 * Medical Record of patient
	 */
	private MedicalRecord medicalRecord;
	
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
	public String getNir() {
		return nir;
	}
	public void setNir(String nir) {
		this.nir = nir;
	}
	public MedicalRecord getMedicalRecord() {
		return medicalRecord;
	}
	public void setMedicalRecord(MedicalRecord medicalRecord) {
		this.medicalRecord = medicalRecord;
	}

}
