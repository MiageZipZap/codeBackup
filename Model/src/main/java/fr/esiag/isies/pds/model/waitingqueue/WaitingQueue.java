package fr.esiag.isies.pds.model.waitingqueue;

import fr.esiag.isies.pds.model.AbstractEntity;

import java.util.Date;

/**
 * This class is a model of a Waiting Queue
 * @author JASS
 */

public class WaitingQueue extends AbstractEntity {
	/**
	 * Id of the queue state
	 */
	private int idQueueState;
	/**
	 * Id of the organization
	 */
	private int idOrganization;
	/**
	 * Id of the service
	 */
	private int idService;
	/**
	 * The time of the queue state
	 */
	private Date timeQueueState;
	/**
	 * Id of the patient 
	 */
	private int idPatient;
	/**
	 * Priority of the patient
	 */
	private int priority;	
	/**
	 * Id of the medical procedure
	 */
	private int idMedicalProcedure;
	/**
	 * Id of the Box 
	 */
	private int idBox;
	/**
	 * Id of the doctor
	 */
	private int idDoctor;
	/**
	 * Waiting Time of the patient (dynamic, not mapped)
	 */
	private int waitingTime;	

	
	public int getIdQueueState() {
		return idQueueState;
	}
	
	public void setIdQueueState(int idQueueState) {
		this.idQueueState = idQueueState;
	}
	
	public int getIdOrganization() {
		return idOrganization;
	}
	
	public void setIdOrganization(int idOrganization) {
		this.idOrganization = idOrganization;
	}
	
	public int getIdService() {
		return idService;
	}
	
	public void setIdService(int idService) {
		this.idService = idService;
	}
	
	public Date getTimeQueueState() {
		return timeQueueState;
	}
	
	public void setTimeQueueState(Date timeQueueState) {
		this.timeQueueState = timeQueueState;
	}
	
	public int getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}	
	
	public int getPriority() {
		return priority;
	}
	
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public int getIdMedicalProcedure() {
		return idMedicalProcedure;
	}
	
	public void setIdMedicalProcedure(int idMedicalProcedure) {
		this.idMedicalProcedure = idMedicalProcedure;
	}

	public int getIdBox() {
		return idBox;
	}
	
	public void setIdBox(int idBox) {
		this.idBox = idBox;
	}
	
	public int getIdDoctor() {
		return idDoctor;
	}
	
	public void setIdDoctor(int idDoctor) {
		this.idDoctor = idDoctor;
	}

	public int getWaitingTime() {
		return waitingTime;
	}

	public void setWaitingTime(int waitingTime) {
		this.waitingTime = waitingTime;
	}

}
