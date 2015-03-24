package fr.esiag.isies.pds.model.hospital.medical;
/**
 * Model class for biological act
 * @author Glawdys
 *
 */
public class BiologicalAct extends MedicalAct{
	
	/**
	 * Whether the act is refund by the social seurity
	 */
	private int SSRefund;
	/**
	 * Whether the biologist can do the act without the permission of the doctor
	 */
	private int biologistInitiative;
	/**
	 * Whether the act is an blood test
	 */
	private int bloodTest;
	/**
	 * With which acts, the act is conflicting
	 */
	private String conflictingCode;
	/**
	 * Whether a preliminary agreement is needed
	 */
	private boolean preliminaryAgreement;
	
	
	
	
	
	
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
	public int getBiologistInitiative() {
		return biologistInitiative;
	}
	public void setBiologistInitiative(int biologistInitiative) {
		this.biologistInitiative = biologistInitiative;
	}
	public int getBloodTest() {
		return bloodTest;
	}
	public void setBloodTest(int bloodTest) {
		this.bloodTest = bloodTest;
	}
	public int getSSRefund() {
		return SSRefund;
	}
	public void setSSRefund(int sSRefund) {
		SSRefund = sSRefund;
	}
	

}
