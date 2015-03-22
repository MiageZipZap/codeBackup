package fr.esiag.isies.pds.model.referential.person.staff;

import fr.esiag.isies.pds.model.Person;
import fr.esiag.isies.pds.model.referential.organization.Service;

/**
 * This class is a model of a Staff Member
 * @author JASS KVI LAD YEL
 */

public class StaffMember extends Person {
	
	/**
	 * Id of the number attribute to each staff member
	 */
	private String staffNumber;
	/**
	 * RPPS of the Staff member
	 */
	private String codeRPPS;
	/**
	 * Profession of the Staff member
	 */
	private int idProfession;
	/**
	 * Specialty of the Staff member
	 */
	private int idSpeciality;
	/**
	 * Organization of the Staff member
	 */
	private int idOrganization;
	/**
	 * Service of the Staff member
	 */
	private Service IdService;
	/**
	 * Authorization of the Staff member
	 */
	private Authorization authorization;
	/**
	 * ¨Personal info of StaffMember
	 */

	public String getCodeRPPS() {
		return codeRPPS;
	}

	public void setCodeRPPS(String codeRPPS) {
		this.codeRPPS = codeRPPS;
	}
	
	public String getStaffNumber() {
		return staffNumber;
	}

	public void setStaffNumber(String staffNumber) {
		this.staffNumber = staffNumber;
	}
	
	public int getIdProfession() {
		return idProfession;
	}
	
	public void setIdProfession(int idProfession) {
		this.idProfession = idProfession;
	}

	public Service getIdService() {
		return IdService;
	}

	public void setIdService(Service IdService) {
		this.IdService = IdService;
	}

	public Authorization getAuthorization() {
		return authorization;
	}

	public void setAuthorization(Authorization authorization) {
		this.authorization = authorization;
	}

	public int getIdSpeciality() {
		return idSpeciality;
	}

	public void setIdSpeciality(int idSpeciality) {
		this.idSpeciality = idSpeciality;
	}

	public int getIdOrganization() {
		return idOrganization;
	}

	public void setIdOrganization(int idOrganization) {
		this.idOrganization = idOrganization;
	}
}
