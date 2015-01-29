package fr.esiag.isies.pds.model.referential.staff;

import fr.esiag.isies.pds.model.referential.organization.Service;
import fr.esiag.isies.pds.model.referential.staff.Profession;
import fr.esiag.isies.pds.model.referential.staff.Authorization;
import fr.esiag.isies.pds.model.AbstractEntity;

import java.util.Date;

/**
 * This class is a model of a Staff Member
 * @author JASS KVI LAD YEL
 */

public class StaffMember extends AbstractEntity {
	/**
	 * Id of the Staff member
	 */
	private int idStaffMember;
	/**
	 * Id of the Staff member's profession
	 */
	private int idProfession;
	/**
	 * Id of the Staff member's speciality
	 */
	private int idSpeciality;
	/**
	 * Id of the Staff member's organization
	 */
	private int idOrganization;
	/**
	 * Id of the Staff member's service
	 */
	private int idService;
	/**
	 * Number Number ID of the Staff member
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
	 * Street Number of the Adress
	 */
	private String streetNumber;
	/**
	 * Street Type of the Adress
	 */
	private String streetType;
	/**
	 * Street Name of the Adress
	 */
	private String streetName;
	/**
	 * Region/Province/State of the Adress
	 */
	private String region;
	/**
	 * Zip Code of the Adress
	 */
	private String zipCode;
	/**
	 * City of the Adress
	 */
	private String city;
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
	 * ADELI of the Staff member
	 */
	private String codeADELI;
	/**
	 * RPPS of the Staff member
	 */
	private String codeRPPS;
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

	public int getIdStaffMember() {
		return idStaffMember;
	}

	public void setIdStaffMember(int idStaffMember) {
		this.idStaffMember = idStaffMember;
	}

	public int getIdProfession() {
		return idProfession;
	}

	public void setIdProfession(int idProfession) {
		this.idProfession = idProfession;
	}

	public int getIdSpeciality() {
		return idSpeciality;
	}

	public void setIdSpeciality(int idSpeciality) {
		this.idSpeciality = idSpeciality;
	}

	public int getIdOrganization() {
		return idOrganization;
	}

	public void setIdOrganization(int idOrganization) {
		this.idOrganization = idOrganization;
	}

	public int getIdService() {
		return idService;
	}

	public void setIdService(int idService) {
		this.idService = idService;
	}

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
	
	public String getStreetNumber() {
		return streetNumber;
	}
	
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}
	
	public String getStreetType() {
		return streetType;
	}
	
	public void setStreetType(String streetType) {
		this.streetType = streetType;
	}
	
	public String getStreetName() {
		return streetName;
	}
	
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	
	public String getZipCode() {
		return zipCode;
	}
	
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}
	
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
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

	public String getCodeADELI() {
		return codeADELI;
	}

	public void setCodeADELI(String codeADELI) {
		this.codeADELI = codeADELI;
	}

	public String getCodeRPPS() {
		return codeRPPS;
	}

	public void setCodeRPPS(String codeRPPS) {
		this.codeRPPS = codeRPPS;
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
	


	/**
	 * This is a test
	 */
	
	private int idTest;

	public int getIdTest() {
		return idTest;
	}

	public void setIdTest(int idTest) {
		this.idTest = idTest;
	}


	

}
