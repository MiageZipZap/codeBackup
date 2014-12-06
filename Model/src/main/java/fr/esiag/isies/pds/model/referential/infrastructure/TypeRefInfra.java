package fr.esiag.isies.pds.model.referential.infrastructure;

import fr.esiag.isies.pds.model.AbstractType;

/**
 * 
 * @author PFR GKA ODI MCH This class describes the infrastructure type
 */
public class TypeRefInfra extends AbstractType {
	/**
	 * Category of an item (equipment, infrastructure, medicine,...)
	 */
	private CategoryRefInfra category;

	public CategoryRefInfra getCategory() {
		return category;
	}

	public void setCategory(CategoryRefInfra category) {
		this.category = category;
	}

}
