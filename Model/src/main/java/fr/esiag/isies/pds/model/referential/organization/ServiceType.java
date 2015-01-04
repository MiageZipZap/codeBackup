package fr.esiag.isies.pds.model.referential.organization;

import fr.esiag.isies.pds.model.AbstractType;

/**
 * Model of service type
 * @author SKO JLA OSA ADA JSB
 *
 */
public class ServiceType extends AbstractType {
	/**
	 * indicate the type of organization for which the service is created
	 */
	private String categoryService;

	public String getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(String categoryService) {
		this.categoryService = categoryService;
	}
	
	
}
