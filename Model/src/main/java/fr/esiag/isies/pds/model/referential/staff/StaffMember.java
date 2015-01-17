package fr.esiag.isies.pds.model.referential.staff;

import fr.esiag.isies.pds.model.referential.organization.Service;
import fr.esiag.isies.pds.model.referential.staff.Profession;
import fr.esiag.isies.pds.model.referential.staff.Authorization;
import fr.esiag.isies.pds.model.Adress;
import fr.esiag.isies.pds.model.AbstractEntity;
import java.util.Date;

/**
 * This class is a model of a Staff Member
 * @author JASS KVI LAD YEL
 */

public class StaffMember extends AbstractEntity {
	/**
	 * Number ID of the Staff member
	 */
	private String staffNumber;
	/**
	 * First name of the Staff member
	 */
	private String firstName;
	/**
	 * Last name of the Staff member
	 */
	private String lastName;
	/**
	 * Birthdate of the Staff member
	 */
	private Date birthdate;
	/**
	 * Gender of the Staff member
	 */
	private Character gender;
	/**
	 * Adress of the Staff member
	 */
	private Adress adress;
	/**
	 * Work phone number of the Staff member
	 */
	private String phoneNumberWork;
	/**
	 * Mobile phone number of the Staff member
	 */
	private String phoneNumberMobile;
	/**
	 * Mail Adress of the Staff member
	 */
	private String mailAdress;	
	/**
	 * Profession of the Staff member
	 */
	private Profession profession;
	/**
	 * Service of the Staff member
	 */
	private Service service;
	/**
	 * Authorization of the Staff member
	 */
	private Authorization authorization;
	
	public String getStaffNumber() {
		return staffNumber;
	}

	public void setStaffNumber(String staffNumber) {
		this.staffNumber = staffNumber;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Date getBirthdate() {
		return birthdate;
	}
	
	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}
	
	public Character getGender() {
		return gender;
	}
	
	public void setGender(Character gender) {
		this.gender = gender;
	}
	
	public Adress getAdress() {
		return adress;
	}
	
	public void setAdress(Adress adress) {
		this.adress = adress;
	}
	
	public String getPhoneNumberWork() {
		return phoneNumberWork;
	}
	
	public void setPhoneNumberWork(String phoneNumberWork) {
		this.phoneNumberWork = phoneNumberWork;
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
	
	public Profession getProfession() {
		return profession;
	}
	
	public void setProfession(Profession profession) {
		this.profession = profession;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public Authorization getAuthorization() {
		return authorization;
	}

	public void setAuthorization(Authorization authorization) {
		this.authorization = authorization;
	}
}
