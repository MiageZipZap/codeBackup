package fr.esiag.isies.pds.model;

/**
 * Abstract Class with information which is in all Type Model
 * @author PFR
 *
 */
public class AbstractType extends AbstractModel {
	/**
	 * Functional key which permit to retrieve a label
	 */
	private String code;
	/**
	 * Label about a type
	 */
	private String label;

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
}
