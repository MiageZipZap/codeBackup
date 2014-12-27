package fr.esiag.isies.pds.model.referential.infrastructure;

import fr.esiag.isies.pds.model.AbstractEntity;

/**
 * This class is a model of Type 
 * @author OD
 *
 */
public class Type extends AbstractEntity{
	
	private String code;
	
	/**
	 * Name of Type
	 */
	private String label;
	
	/**
	 * Category of type
	 */
	
	private TypeRefInfra category;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public TypeRefInfra getCategory() {
		return category;
	}

	public void setCategory(TypeRefInfra category) {
		this.category = category;
	}
	

}
