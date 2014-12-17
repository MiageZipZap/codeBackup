package fr.esiag.isies.pds.model.referential.organization;


/**
 * Model of an hospital (herited from Organization)
 * @author SKO JLA OSA ADA JSB
 *
 */
public class Hospital extends Organization {
	
	/**
	 * FINESS number of the hospital
	 */
	private String finess;

	public String getFiness() {
		return finess;
	}

	public void setFiness(String finess) {
		this.finess = finess;
	}
	
	
	
}
