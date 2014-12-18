package fr.esiag.isies.pds.model.referential.organization;

import fr.esiag.isies.pds.model.AbstractEntity;

/**
 * Model of an organization type
 * @author SKO JLA OSA ADA JSB
 *
 */
public class OrgaType extends AbstractEntity {
	
	/*
	 * Code type
	 */
	private String typeCode;
	/*
	 * Label type
	 */
	private String description;
	/*
	 * Legal Status type
	 */
	private String legalStatus;
	
	
	public String getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getLegalStatus() {
		return legalStatus;
	}
	public void setLegalStatus(String legalStatus) {
		this.legalStatus = legalStatus;
	}
		
}
