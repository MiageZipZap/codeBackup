package fr.esiag.isies.pds.model.referential.infrastructure;

import fr.esiag.isies.pds.model.AbstractEntity;

/**
 * 
 * @author PFR GKA MCH ODI This class is a model of infrastructure item
 */
public class Infrastructure extends AbstractEntity {

	private String code;

	/**
	 * Name of infrastructure
	 */
	private String label;

	/**
	 * type of infrastructure
	 */
	private TypeRefInfra typeRefInfra;

	/**
	 * Capacity of infrastructure
	 */
	private Integer capacity;
	//
	// private Integer hospitalService;

	/**
	 * Flag for disabled facilities
	 */
	private Boolean disabledFacilities;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Boolean getDisabledFacilities() {
		return disabledFacilities;
	}

	public void setDisabledFacilities(Boolean disabledFacilities) {
		this.disabledFacilities = disabledFacilities;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public TypeRefInfra getTypeRefInfra() {
		return typeRefInfra;
	}

	public void setTypeRefInfra(TypeRefInfra typeRefInfra) {
		this.typeRefInfra = typeRefInfra;
	}
}
