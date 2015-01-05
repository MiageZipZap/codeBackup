package fr.esiag.isies.pds.model.referential.organization;

import java.util.HashSet;
import java.util.Set;

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
	
	private Set<Organization> organizationSet = new HashSet<Organization>(0);

	public String getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(String categoryService) {
		this.categoryService = categoryService;
	}

	public Set<Organization> getOrganizationSet() {
		return organizationSet;
	}

	public void setOrganizationSet(Set<Organization> organizationSet) {
		this.organizationSet = organizationSet;
	}
	
}
