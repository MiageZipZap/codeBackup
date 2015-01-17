package fr.esiag.isies.pds.model.referential.staff;

import fr.esiag.isies.pds.model.AbstractEntity;

/**
 * This class is a model of a Profession
 * @author JASS KVI LAD YEL
 */

public class Profession extends AbstractEntity {
	/**
	 * PCSES Code of a Staff Member doing the Profession
	 */
	private Integer codePCSES;
	/**
	 * Label of the Profession
	 */
	private String label;
	/**
	 * Type of the Profession
	 */
	private String type;
	
	public Integer getCodePCSES() {
		return codePCSES;
	}
	
	public void setCodePCSES(Integer codePCSES) {
		this.codePCSES = codePCSES;
	}
	
	public String getLabel() {
		return label;
	}
	
	public void setLabel(String label) {
		this.label = label;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
}
