package fr.esiag.isies.pds.model.emergency.sort;

import java.util.Date;

import fr.esiag.isies.pds.model.AbstractEntity;


/**
 * Model class for sorting data of a patient in emergency
 * 
 * @author Meriem
 *
 */
public class Sorting extends AbstractEntity {

	/**
	 * last name of the patient
	 */
	private String surname;
	/**
	 * first name of the patient
	 */
	private String firstname;
	/**
	 * reception date of the patient in emergency
	 */
	private Date receptiondate;

	/*//**
	  The category of sorting
	 //*/
	private String sortingcategory;
	/**
	 * chosen service
	 */
	private String sortingservice;
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
	public Date getReceptiondate() {
		return receptiondate;
	}
	public void setReceptiondate(Date receptiondate) {
		this.receptiondate = receptiondate;
	}
	public String getSortingcategory() {
		return sortingcategory;
	}
	public void setSortingcategory(String sortingcategory) {
		this.sortingcategory = sortingcategory;
	}
	public String getSortingservice() {
		return sortingservice;
	}
	public void setSortingservice(String sortingservice) {
		this.sortingservice = sortingservice;
	}

	
	
}
