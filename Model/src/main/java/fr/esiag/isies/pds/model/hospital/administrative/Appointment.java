package fr.esiag.isies.pds.model.hospital.administrative;

import java.util.ArrayList;
import java.util.Date;





import fr.esiag.isies.pds.model.AbstractEntity;
import fr.esiag.isies.pds.model.referential.organization.Hospital;
import fr.esiag.isies.pds.model.referential.person.patient.Patient;

/**
 * Model class for an appointment
 * @author Glawdys
 *
 */
public class Appointment extends AbstractEntity{

	private Patient patient;
	/**
	 * Doctor who the patient will the appointment with
	 */
	private String doctorName;
	
	
	
	/**
	 * day of the appointment
	 */
	private Date appointmentDate;
	
	/**
	 * Hour of the appointment
	 */
	
	private String appointmentHour;
	
	
	
	/** 
	 * comments for the appointment
	 */
	
	private String comments;
	
	/**
	 *  reason of the appointment
	 */
	
	private AppointmentType appointmentReason;
	
	
	
	/**
	 * Whether it's a new patient
	 */
	private boolean newPatient;
	
	private Hospital hospital;
	
	private String keyword;
	
	public String getAppointmentHour() {
		return appointmentHour;
	}
	public void setAppointmentHour(String appointmentHour) {
		this.appointmentHour = appointmentHour;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	
	
	
	
	
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	
	
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public AppointmentType getAppointmentReason() {
		return appointmentReason;
	}
	public void setAppointmentReason(AppointmentType appointmentReason) {
		this.appointmentReason = appointmentReason;
	}
	public Hospital getHospital() {
		return hospital;
	}
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	public boolean isNewPatient() {
		return newPatient;
	}
	public void setNewPatient(boolean newPatient) {
		this.newPatient = newPatient;
	}
	
	
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	
	

}
