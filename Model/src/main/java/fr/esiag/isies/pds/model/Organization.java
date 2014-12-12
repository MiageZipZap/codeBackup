/**
 * 
 */
package fr.esiag.isies.pds.model;

/**
 * @author JLA SKO OSA ADA JSB
 * @version 0.0.1
 * 
 * Model of an organization
 *
 */
public class Organization extends AbstractEntity {

	/*
	 * Name of the organization
	 */
	private String name;
	/*
	 * Street number of the organization
	 */
	private int streetNumber;
	/*
	 * Type of the street
	 */
	private String streetType;
	/*
	 * Name of the street
	 */
	private String streetName;
	/*
	 * Zip code of the organisation
	 */
	private String zipCode;
	/*
	 * City of the orga.
	 */
	private String city;
	/*
	 * Department of the orga.
	 */
	private String department;
	/*
	 * Phone number
	 */
	private String phone;
	/*
	 * Legal status
	 */
	private String legalStatus;
	/*
	 * SIRET number
	 */
	private String siret;
	/*
	 * Type of orga.
	 */
	private OrgaType orgaType;
	
}
