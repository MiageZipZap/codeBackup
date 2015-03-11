package fr.esiag.isies.pds.model.hospital.medical;
/**
 * Model class for a act from the CCAM referential
 * @author Glawdys
 *
 */
public class CcamAct extends MedicalAct {

	/**
	 * Price of the act
	 */
	private float actPrice;
	/**
	 * Comment on the medical act
	 */
	private String actNote;
	/**
	 * Exoneration rule
	 */
	private String exonerationRule;
	/**
	 * Grouping code
	 */
	private String groupingCode;
	
	public float getActPrice() {
		return actPrice;
	}
	public void setActPrice(float actPrice) {
		this.actPrice = actPrice;
	}
	public String getActNote() {
		return actNote;
	}
	public void setActNote(String actNote) {
		this.actNote = actNote;
	}
	public String getExonerationRule() {
		return exonerationRule;
	}
	public void setExonerationRule(String exonerationRule) {
		this.exonerationRule = exonerationRule;
	}
	public String getGroupingCode() {
		return groupingCode;
	}
	public void setGroupingCode(String groupingCode) {
		this.groupingCode = groupingCode;
	}

}
