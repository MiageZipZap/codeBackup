package fr.esiag.isies.pds.model;

/**
 * 
 * @author JLA & PFR
 * @version 0.0.1
 * 
 * This class is a model of a doctor
 *
 */
public class Doctor extends AbstractEntity {
	
	
	/**
	 * Surname of the doctor
	 */
	private String surname;
	/**
	 * First name of the doctor
	 */
	private String firstname;

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	
	

	

}
