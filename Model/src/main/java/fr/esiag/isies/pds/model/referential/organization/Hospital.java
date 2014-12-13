package fr.esiag.isies.pds.model.referential.organization;

import java.util.List;

/**
 * Model of an hospital (herited from Organization)
 * @author SKO JLA OSA ADA JSB
 *
 */
public class Hospital extends Organization {
	
	/**
	 * FINESS number of the hospital
	 */
	private String finess;
	
	/**
	 * List of services in the hospital
	 */
	//private Map<ServiceType, Integer> services;
	private List<ServiceType> list;

	public String getFiness() {
		return finess;
	}

	public void setFiness(String finess) {
		this.finess = finess;
	}

	public List<ServiceType> getList() {
		return list;
	}

	public void setList(List<ServiceType> list) {
		this.list = list;
	}

	/*public Map<ServiceType, Integer> getServices() {
		return services;
	}

	public void setServices(Map<ServiceType, Integer> services) {
		this.services = services;
	}*/
	
	
	
}
