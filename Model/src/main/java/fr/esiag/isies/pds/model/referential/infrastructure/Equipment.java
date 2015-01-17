package fr.esiag.isies.pds.model.referential.infrastructure;

import fr.esiag.isies.pds.model.AbstractEntity;
import fr.esiag.isies.pds.model.referential.organization.Hospital;

/**
 * This class is a model of equipment item
 * @author PFR GKA MCH ODI 
 */
public class Equipment extends AbstractEntity {
	
	/**
	 * Equipment serial number
	 */
	
	private String serialNumber;

	/**
	 * Name of equipment
	 */
	private String label;

	/**
	 * Type of equipment
	 */
	private TypeRefInfra typeRefInfra;
	
	/**
	 * Hospital which contains this equipment
	 */
	private Hospital hospital;

	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public TypeRefInfra getTypeRefInfra() {
		return typeRefInfra;
	}

	public void setTypeRefInfra(TypeRefInfra typeRefInfra) {
		this.typeRefInfra = typeRefInfra;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	

}
