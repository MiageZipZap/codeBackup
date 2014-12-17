package fr.esiag.isies.pds.model.referential.staff;

import fr.esiag.isies.pds.model.AbstractEntity;

public class Staff extends AbstractEntity {
	/**
	 * Surname of the staff
	 */
	private String surname;
	/**
	 * First name of the staff member
	 */
	private String firstname;
	/**
	 * Adress of the staff member
	 */
	private String address;
	/**
	 * The birth date of the staff
	 */
	private String birthDate;
	
//	private CPECard cpeCard;
	
	public Staff(){
		
	}
	
	public Staff(String surname, String firstname, String birhDate){
		this.surname = surname;
		this.firstname = firstname;
		this.birthDate = birhDate;
	}
	
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
}
