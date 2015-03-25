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
	
	private String actNote;
	/**
	 * Exoneration rule
	 */
	private String exonerationRule;
	/**
	 * Refund policy
	 */
	
	private String refund;
	/**
	 * Grouping code
	 */
	private String groupingCode;
	
	/**
	 * Whether the act is considered like a principal act
	 */
	private  int isPrincipal;
	
	
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
	
	public String getRefund() {
		return refund;
	}
	public void setRefund(String refund) {
		this.refund = refund;
	}
	public int getIsPrincipal() {
		return isPrincipal;
	}
	public void setIsPrincipal(int isPrincipal) {
		this.isPrincipal = isPrincipal;
	}

}
