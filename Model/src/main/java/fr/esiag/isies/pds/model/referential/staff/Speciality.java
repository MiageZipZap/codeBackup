package fr.esiag.isies.pds.model.referential.staff;

import fr.esiag.isies.pds.model.AbstractEntity;

/**
 * This class is a model of a Speciality
 * @author JASS KVI LAD YEL
 */

public class Speciality extends AbstractEntity {
	/**
	 * Code of the Speciality
	 */
	private Integer code;
	/**
	 * Label of the Speciality
	 */
	private String label;
	
	public Integer getCode() {
		return code;
	}
	
	public void setCode(Integer code) {
		this.code = code;
	}
	
	public String getLabel() {
		return label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
}
