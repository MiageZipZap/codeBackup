package fr.esiag.isies.pds.model.referential.organization;

import fr.esiag.isies.pds.model.AbstractModel;

public class Service extends AbstractModel {
	/**
	 * The id of the organization in which the service is provided 
	 */
	private int idOrganizaton;
	/**
	 * The id of the organization in which the service is provided 
	 */
	private int idTypeOfService;
	
	public int getIdOrganizaton() {
		return idOrganizaton;
	}
	public void setIdOrganizaton(int idOrganizaton) {
		this.idOrganizaton = idOrganizaton;
	}
	public int getIdTypeOfService() {
		return idTypeOfService;
	}
	public void setIdTypeOfService(int idTypeOfService) {
		this.idTypeOfService = idTypeOfService;
	}
	
	

}
