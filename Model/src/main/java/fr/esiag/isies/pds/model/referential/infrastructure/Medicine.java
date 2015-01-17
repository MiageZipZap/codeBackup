package fr.esiag.isies.pds.model.referential.infrastructure;

import fr.esiag.isies.pds.model.AbstractEntity;
import fr.esiag.isies.pds.model.referential.organization.Hospital;

/**
 * This class is a model for medicine items
 * 
 * @author GKA,ODI,PFR,MCH
 *
 */
public class Medicine extends AbstractEntity {
	/**
	 * Kind of serial number for a medicine
	 */
	private String ucdCode;

	/**
	 * name of the medicine
	 */
	private String label;
	/**
	 * amount of one type of medicine
	 */
	private Integer quantity;

	/**
	 * Type of infrastructure referential
	 */
	private TypeRefInfra typeRefInfra;

	/**
	 * Hospital which contains this equipment
	 */
	private Hospital hospital;

	public String getUcdCode() {
		return ucdCode;
	}

	public void setUcdCode(String ucdCode) {
		this.ucdCode = ucdCode;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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
