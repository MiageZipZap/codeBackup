package fr.esiag.isies.pds.model.referential.organization;

import fr.esiag.isies.pds.model.AbstractEntity;

/**
 * Model of service type
 * @author SKO JLA OSA ADA JSB
 *
 */
public class ServiceType extends AbstractEntity {
	
	/*
	 * Code of Service Type
	 */
	private int code;
	
	/*
	 * Label of Service Type
	 */
	private String label;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getLibelle() {
		return label;
	}

	public void setLibelle(String label) {
		this.label = label;
	}
	
	
}
