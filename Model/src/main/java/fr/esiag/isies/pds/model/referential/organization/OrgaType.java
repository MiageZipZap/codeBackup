package fr.esiag.isies.pds.model.referential.organization;

import fr.esiag.isies.pds.model.AbstractType;

/**
 * Model of an organization type
 * @author SKO JLA OSA ADA JSB
 *
 */
public class OrgaType extends AbstractType {
	
	/*
	 * Legal Status type
	 */
	private String legalStatus;
	
	public String getLegalStatus() {
		return legalStatus;
	}
	public void setLegalStatus(String legalStatus) {
		this.legalStatus = legalStatus;
	}
		
}
