package fr.esiag.isies.pds.model;

/**
 * This class is a model of an Adress
 * @author JASS KVI LAD YEL
 */

public class Adress extends AbstractEntity {	
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
}
