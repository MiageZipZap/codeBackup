package fr.esiag.isies.pds.model.hospital.medical;
/**
 * Model class for biological act
 * @author Glawdys
 *
 */
public class BiologicalAct extends MedicalAct{
	/**
	 * Number of coefficient B
	 */
	private String coefficientB;
	/**
	 * Whether the act is refund by the social seurity
	 */
	private boolean SSRefund;
	/**
	 * Whether the biologist can do the act without the permission of the doctor
	 */
	private boolean biologistInitiative;
	/**
	 * Whether the act is an blood test
	 */
	private boolean bloodTest;
	/**
	 * With which acts, the act is conflicting
	 */
	private String conflictingCode;
	/**
	 * Whether a preliminary agreement is needed
	 */
	private boolean preliminaryAgreement;
	
	public String getCoefficientB() {
		return coefficientB;
	}
	public void setCoefficientB(String coefficientB) {
		this.coefficientB = coefficientB;
	}
	public boolean isSSRefund() {
		return SSRefund;
	}
	public void setSSRefund(boolean sSRefund) {
		SSRefund = sSRefund;
	}
	public boolean isBiologistInitiative() {
		return biologistInitiative;
	}
	public void setBiologistInitiative(boolean biologistInitiative) {
		this.biologistInitiative = biologistInitiative;
	}
	public boolean isBloodTest() {
		return bloodTest;
	}
	public void setBloodTest(boolean bloodTest) {
		this.bloodTest = bloodTest;
	}
	public String getConflictingCode() {
		return conflictingCode;
	}
	public void setConflictingCode(String conflictingCode) {
		this.conflictingCode = conflictingCode;
	}
	public boolean isPreliminaryAgreement() {
		return preliminaryAgreement;
	}
	public void setPreliminaryAgreement(boolean preliminaryAgreement) {
		this.preliminaryAgreement = preliminaryAgreement;
	}
	

}
