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
	 * Department of the Address
	 */
	private String department;
	/**
	 * Zip Code of the Address
	 */
	private String zipCode;
	/**
	 * City of the Address
	 */
	private String city;	
	
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
	
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
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
}
