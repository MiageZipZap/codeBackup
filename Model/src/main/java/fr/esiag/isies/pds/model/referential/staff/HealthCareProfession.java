package fr.esiag.isies.pds.model.referential.staff;

/**
 * This class is a model of a Profession
 * @author JASS KVI LAD YEL
 */

public class HealthCareProfession extends Profession {
	/**
	 * RPPS Code of the Staff Member doing the Health Care Profession
	 */
	private Integer codeRPPS;
	/**
	 * Speciality of the Health Care Profession
	 */
	private Speciality speciality;
	
	public Integer getCodeRPPS() {
		return codeRPPS;
	}
	
	public void setCodeRPPS(Integer codeRPPS) {
		this.codeRPPS = codeRPPS;
	}
	
	public Speciality getSpeciality() {
		return speciality;
	}
	
	public void setSpeciality(Speciality speciality) {
		this.speciality = speciality;
	}
}
