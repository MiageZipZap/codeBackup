package fr.esiag.isies.pds.model.referential.person.patient;

import fr.esiag.isies.pds.model.Person;
import fr.esiag.isies.pds.model.referential.medicalRecord.MedicalRecord;

public class Patient extends Person{

	/**
	 * Social security number of patient 
	 */
	private String nir;
	/**
	 * Medical Record of patient
	 */
	private MedicalRecord medicalRecord;
	/**
	 * RPPS of the Phone Number Work
	 */
	private String phoneNumberHome;
	/**
	 * RPPS of the Phone Number Mobile
	 */
	private String phoneNumberMobile;
	/**
	 * RPPS of the Mail adress
	 */
	private String mailAdress;
	
	private int idOrganization;
	
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
	public String getPhoneNumberHome() {
		return phoneNumberHome;
	}
	public void setPhoneNumberHome(String phoneNumberHome) {
		this.phoneNumberHome = phoneNumberHome;
	}
	public String getPhoneNumberMobile() {
		return phoneNumberMobile;
	}
	public void setPhoneNumberMobile(String phoneNumberMobile) {
		this.phoneNumberMobile = phoneNumberMobile;
	}
	public String getMailAdress() {
		return mailAdress;
	}
	public void setMailAdress(String mailAdress) {
		this.mailAdress = mailAdress;
	}
	public int getIdOrganization() {
		return idOrganization;
	}
	public void setIdOrganization(int idOrganization) {
		this.idOrganization = idOrganization;
	}

}
