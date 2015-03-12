package fr.esiag.isies.pds.model.optimisation;

import fr.esiag.isies.pds.model.AbstractEntity;
import fr.esiag.isies.pds.model.referential.organization.Hospital;

/**
 * Statement of admission for patient and statement average of time for exam to patient
 * @author oriel
 *
 */
public class EmergencyFrequentationTrafficLog extends AbstractEntity {
	/**
	 * Time Slot of statement
	 */
	private String representativeTimeSlot;
	/**
	 * In this Time-slot, number of patients of priority one which are admitted in emergency service 
	 */
	private int nbAdmissionForPriorityOne;
	/**
	 * In this Time-slot, number of patients of priority two which are admitted in emergency service
	 */
	private int nbAdmissionForPriorityTwo;
	/**
	 * In this Time-slot, number of patients of priority three which are admitted in emergency service
	 */
	private int nbAdmissionForPriorityThree;
	/**
	 * In this Time-slot, number of patients of priority four which are admitted in emergency service
	 */
	private int nbAdmissionForPriorityFour;
	/**
	 * In this Time-slot, number of patients of priority five which are admitted in emergency service
	 */
	private int nbAdmissionForPriorityFive;
	/**
	 * Hopital wich whose the statement are provide
	 */
	private Hospital evaluateHospital; 
	/**
	 * For priority one's patient which have a consultation with doctor, average time of this consultation
	 */
	private int examTimeForPriorityOnePatient;
	/**
	 * For priority two's patient which have a consultation with doctor, average time of this consultation
	 */
	private int examTimeForPriorityTwoPatient;
	/**
	 * For priority three's patient which have a consultation with doctor, average time of this consultation
	 */
	private int examTimeForPriorityThreePatient;
	/**
	 * For priority four's patient which have a consultation with doctor, average time of this consultation
	 */
	private int examTimeForPriorityFourPatient;
	/**
	 * For priority five's patient which have a consultation with doctor, average time of this consultation
	 */
	private int examTimeForPriorityFivePatient;
	/**
	 * Constructor of EmergencyFrequentation
	 */
	public EmergencyFrequentationTrafficLog() {
		super();
	}
	/**
	 * 
	 * @return
	 */
	public String getRepresentativeTimeSlot() {
		return representativeTimeSlot;
	}
	/**
	 * Set a representative time slot for a statement
	 * @param representativeTimeSlot
	 */
	public void setRepresentativeTimeSlot(String representativeTimeSlot) {
		this.representativeTimeSlot = representativeTimeSlot;
	}
	/**
	 * 
	 * @return number of admission for priority one
	 */
	public int getNbAdmissionForPriorityOne() {
		return nbAdmissionForPriorityOne;
	}
	public void setNbAdmissionForPriorityOne(int nbAdmissionForPriorityOne) {
		this.nbAdmissionForPriorityOne = nbAdmissionForPriorityOne;
	}
	public int getNbAdmissionForPriorityTwo() {
		return nbAdmissionForPriorityTwo;
	}
	public void setNbAdmissionForPriorityTwo(int nbAdmissionForPriorityTwo) {
		this.nbAdmissionForPriorityTwo = nbAdmissionForPriorityTwo;
	}
	public int getNbAdmissionForPriorityThree() {
		return nbAdmissionForPriorityThree;
	}
	public void setNbAdmissionForPriorityThree(int nbAdmissionForPriorityThree) {
		this.nbAdmissionForPriorityThree = nbAdmissionForPriorityThree;
	}
	public int getNbAdmissionForPriorityFour() {
		return nbAdmissionForPriorityFour;
	}
	public void setNbAdmissionForPriorityFour(int nbAdmissionForPriorityFour) {
		this.nbAdmissionForPriorityFour = nbAdmissionForPriorityFour;
	}
	public int getNbAdmissionForPriorityFive() {
		return nbAdmissionForPriorityFive;
	}
	public void setNbAdmissionForPriorityFive(int nbAdmissionForPriorityFive) {
		this.nbAdmissionForPriorityFive = nbAdmissionForPriorityFive;
	}
	public Hospital getEvaluateHospital() {
		return evaluateHospital;
	}
	public void setEvaluateHospital(Hospital evaluateHospital) {
		this.evaluateHospital = evaluateHospital;
	}
	public int getExamTimeForPriorityOnePatient() {
		return examTimeForPriorityOnePatient;
	}
	public void setExamTimeForPriorityOnePatient(int examTimeForPriorityOnePatient) {
		this.examTimeForPriorityOnePatient = examTimeForPriorityOnePatient;
	}
	public int getExamTimeForPriorityTwoPatient() {
		return examTimeForPriorityTwoPatient;
	}
	public void setExamTimeForPriorityTwoPatient(int examTimeForPriorityTwoPatient) {
		this.examTimeForPriorityTwoPatient = examTimeForPriorityTwoPatient;
	}
	public int getExamTimeForPriorityThreePatient() {
		return examTimeForPriorityThreePatient;
	}
	public void setExamTimeForPriorityThreePatient(
			int examTimeForPriorityThreePatient) {
		this.examTimeForPriorityThreePatient = examTimeForPriorityThreePatient;
	}
	public int getExamTimeForPriorityFourPatient() {
		return examTimeForPriorityFourPatient;
	}
	public void setExamTimeForPriorityFourPatient(int examTimeForPriorityFourPatient) {
		this.examTimeForPriorityFourPatient = examTimeForPriorityFourPatient;
	}
	public int getExamTimeForPriorityFivePatient() {
		return examTimeForPriorityFivePatient;
	}
	public void setExamTimeForPriorityFivePatient(int examTimeForPriorityFivePatient) {
		this.examTimeForPriorityFivePatient = examTimeForPriorityFivePatient;
	}
	
}
