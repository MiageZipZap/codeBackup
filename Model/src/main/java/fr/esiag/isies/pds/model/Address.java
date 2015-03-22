package fr.esiag.isies.pds.model;

/**
 * This class is a model of an Address
 * @author JASS KVI LAD YEL
 */

public class Address extends AbstractEntity {	
	/**
	 * Street Number of the Address
	 */
	private String streetNumber;
	/**
	 * Street Type of the Address
	 */
	private String streetType;
	/**
	 * Street Name of the Address
	 */
	private String streetName;
	/**
	 * Region/Province/State of the Address
	 */
	private String region;
	/**
	 * Zip Code of the Address
	 */
	private String zipCode;
	/**
	 * City of the Address
	 */
	private String city;
	/**
	 * Phone number of the Address
	 */
	private String phoneNumberWork;
	/**
	 * phone number work.
	 */
	private String phoneNumberMobile;
	/**
	 * Mail adress
	 */
	private String mailAddress;
	/**
	 * Owner of the adress
	 */
	private Person person;
	
	
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
	
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
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

	public String getMailAddress() {
		return mailAddress;
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
}
