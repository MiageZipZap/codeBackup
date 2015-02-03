/**
 * 
 */
package fr.esiag.isies.pds.model.referential.organization;

import java.util.HashSet;
import java.util.Set;

import net.sf.oval.constraint.Assert;
import net.sf.oval.constraint.Digits;
import net.sf.oval.constraint.MatchPattern;
import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;
import net.sf.oval.constraint.Size;
import fr.esiag.isies.pds.model.AbstractEntity;

/**
 * @author JLA SKO OSA ADA JSB
 * 
 * Model of an organization
 *
 */
public class Organization extends AbstractEntity {

	/*
	 * Name of the organization
	 */
	@NotNull
	@NotEmpty
	@Size(min=2, max=45)
	private String name;
	/*
	 * SIRET number
	 */
	@Size(min=14, max=14)
	@NotNull
	@Digits
	private String siret;
	/*
	 * Street number of the organization
	 */
	@Size(max=45)
	private int streetNumber;
	/*
	 * Type of the street
	 */
	@Size(max=45)
	private String streetType;
	/*
	 * Name of the street
	 */
	@Size(min=2, max=45)
	private String streetName;
	/*
	 * Zip code of the organisation
	 */
	@Size(min=5, max=5)
	@Digits
	private String zipCode;
	/*
	 * City of the orga.
	 */
	@Size(min=2, max=45)
	private String city;
	/*
	 * Department of the orga.
	 */
	@Size(min=2, max=45)
	private String department;
	/*
	 * Phone number
	 */
	@MatchPattern(pattern = "^[0-9]{10}$")
	@Digits
	private String phone;
	/*
	 * Fax
	 */
	@MatchPattern(pattern = "^[0-9]{10}$")
	@Digits
	private String fax;
	/*
	 * Legal email
	 */
	@MatchPattern(pattern = {"^([a-z0-9]{1,}[\\.\\_\\-]?[a-z0-9]{1,})\\@([a-z0-9\\-?]{2,}\\.)([a-z]{2,2}|org|net|com|gov|edu|int|info|biz|museum)$"})
	private String email;
	/*
	 * Legal status
	 */
	private String legalStatus;
	/*
	 * Latitude
	 *
	 */
	@MatchPattern(pattern = {"^(-?\\d{0,2}([.]\\d{0,5})?)$"})
	private Float latitude;
	/*
	 * Longitude
	 */
	@MatchPattern(pattern = {"^(-?\\d{0,3}([.]\\d{0,5})?)$"})
	private Float longitude;
	/*
	 * Type of orga.
	 */
	private OrgaType orgaType;

	/**
	 * List of services in the hospital
	 */
	
	private Set<ServiceType> servicesSet = new HashSet<ServiceType>(0);

	public Set<ServiceType> getServicesSet() {
		return servicesSet;
	}

	public void setServicesSet(Set<ServiceType> servicesSet) {
		this.servicesSet = servicesSet;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStreetNumber() {
		return streetNumber;
	}
	public void setStreetNumber(int streetNumber) {
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
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getLegalStatus() {
		return legalStatus;
	}
	public void setLegalStatus(String legalStatus) {
		this.legalStatus = legalStatus;
	}
	public String getSiret() {
		return siret;
	}
	public void setSiret(String siret) {
		this.siret = siret;
	}
	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}
	@NotNull
	@Assert(expr = "_this.id!=0", lang = "groovy")
	public OrgaType getOrgaType() {
		return orgaType;
	}

	public void setOrgaType(OrgaType orgaType) {
		this.orgaType = orgaType;
	}

}
