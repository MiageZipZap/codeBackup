package fr.esiag.isies.pds.model.hospital.administrative;

import java.util.Date;
import java.util.Hashtable;

import fr.esiag.isies.pds.model.AbstractEntity;

/**
 * Model class for an appointment
 * @author Glawdys
 *
 */
public class Appointment extends AbstractEntity{

	/**
	 * Patient last name
	 */
	private String patientLastName;
	/**
	 * Patient first name
	 */
	private String patientFirstName;
	/**
	 * Doctor who the patient will the appointment with
	 */
	private String doctorName;
	/**
	 * Patient gender
	 */
	private String patientGender;
	/**
	 * patient birth date
	 */
	private Date patientBirthDate;
	/**
	 * list of medical acts
	 */
	
	private Hashtable <String,String> medicalCourse;
	/**
	 * day of the appointment
	 */
	private Date appointmentDate;
	
	/**
	 * Hour of the appointment
	 */
	
	private String appointmentHour;
	
	/**
	 * Appointment type
	 */
	
	private AppointmentType appointmentType;
	
	/** 
	 * comments for the appointment
	 */
	
	private String comments;
	
	/**
	 *  reason of the appointment
	 */
	
	private String appointmentReason;
	
	
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
	
	public String getPatientLastName() {
		return patientLastName;
	}
	public void setPatientLastName(String patientLastName) {
		this.patientLastName = patientLastName;
	}
	public String getPatientFirstName() {
		return patientFirstName;
	}
	public void setPatientFirstName(String patientFirstName) {
		this.patientFirstName = patientFirstName;
	}
	
	public String getPatientGender() {
		return patientGender;
	}
	public void setPatientGender(String patientGender) {
		this.patientGender = patientGender;
	}
	public Hashtable <String,String> getMedicalCourse() {
		return medicalCourse;
	}
	public void setMedicalCourse(Hashtable<String, String> medicalCourse) {
		this.medicalCourse = medicalCourse;
	}
	public Date getAppointmentDate() {
		return appointmentDate;
	}
	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}
	public AppointmentType getAppointmentType() {
		return appointmentType;
	}
	public void setAppointmentType(AppointmentType appointmentType) {
		this.appointmentType = appointmentType;
	}
	public Date getPatientBirthDate() {
		return patientBirthDate;
	}
	public void setPatientBirthDate(Date patientBirthDate) {
		this.patientBirthDate = patientBirthDate;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getAppointmentReason() {
		return appointmentReason;
	}
	public void setAppointmentReason(String appointmentReason) {
		this.appointmentReason = appointmentReason;
	}
	
	

}
