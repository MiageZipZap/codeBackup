package fr.esiag.isies.pds.model.optimisation;

import java.util.Date;

import fr.esiag.isies.pds.model.AbstractEntity;
import fr.esiag.isies.pds.model.referential.infrastructure.Infrastructure;
import fr.esiag.isies.pds.model.referential.organization.Hospital;
/**
 * Class wich represent an activity of patient in emergency service
 * @author OSA
 *
 */
public class EmergencyFrequentationTrafficLog extends AbstractEntity{
	
	Hospital hospital;
	int idPatient;
	int idDoctor;
	Infrastructure infra;
	Date dateInputPatient;
	Date dateExitBox;
	
	public EmergencyFrequentationTrafficLog(){}
	/**
	 * Constructor of object to create an activity
	 * @param hospital
	 * @param idPatient
	 * @param idDoctor
	 * @param infra
	 * @param dateInputPatient
	 * @param dateExitBox
	 */
	public EmergencyFrequentationTrafficLog(Hospital hospital, int idPatient, int idDoctor, Infrastructure infra,
		 Date dateInputPatient,Date dateExitBox) {
		this.hospital = hospital;
		this.idPatient = idPatient;
		this.idDoctor = idDoctor;
		this.infra = infra;
		this.dateInputPatient = dateInputPatient;
		this.dateExitBox = dateExitBox;
	}
	/**
	 * Method wich return Hospital for an activity of patient in emergency service
	 * @return Hospital
	 */
	public Hospital getHospital() {
		return hospital;
	}
	/**
	 * Method wich we can set an Hospital for an activity of patient in emergency service
	 * @param hospital
	 */
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	/**
	 * Method wich return id of patient for an activity of patient in emergency service
	 * @return idPatient
	 */
	public int getIdPatient() {
		return idPatient;
	}
	/**
	 * Method wich we can set an id of patient for an activity of patient in emergency service
	 * @param idPatient
	 */
	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}
	/**
	 * Method wich return id of doctor for an activity of patient in emergency service
	 * @return idDoctor
	 */
	public int getIdDoctor() {
		return idDoctor;
	}
	/**
	 * Method wich we can set an id of doctor for an activity of patient in emergency service
	 * @param idDoctor
	 */
	public void setIdDoctor(int idDoctor) {
		this.idDoctor = idDoctor;
	}
	/**
	 * Method wich return an infrastructure (exam box) for an activity of patient in emergency service
	 * @return infra
	 */
	public Infrastructure getInfra() {
		return infra;
	}
	/**
	 * Method wich we can set Infrastructure (exam box) for an activity of patient in emergency service
	 * @param infra
	 */
	public void setInfra(Infrastructure infra) {
		this.infra = infra;
	}
	/**
	 * Method wich return a date of input patient for an activity of patient in emergency service
	 * @return dateInputPatient
	 */
	public Date getDateInputPatient() {
		return dateInputPatient;
	}
	/**
	 * Method wich we can set a date of input patient for an activity of patient in emergency service
	 * @param dateInputPatient
	 */
	public void setDateInputPatient(Date dateInputPatient) {
		this.dateInputPatient = dateInputPatient;
	}
	/**
	 * Method wich return a date of exit of a exam box for an activity of patient in emergency service
	 * @return dateExitBox
	 */
	public Date getDateExitBox() {
		return dateExitBox;
	}
	/**
	 * Method wich we can set a date  exit of a exam box for an activity of patient in emergency service
	 * @param dateExitBox
	 */
	public void setDateExitBox(Date dateExitBox) {
		this.dateExitBox = dateExitBox;
	}

	
}