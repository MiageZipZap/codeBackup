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
	private int typeCode;
	/*
	 * Label type
	 */
	private String label;
	
	public int getTypeCode() {
		return typeCode;
	}
	public void setTypeCode(int typeCode) {
		this.typeCode = typeCode;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	
	
}
