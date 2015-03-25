package fr.esiag.isies.pds.model.hospital.administrative;

import java.util.ArrayList;
import java.util.Date;




import fr.esiag.isies.pds.model.AbstractEntity;
import fr.esiag.isies.pds.model.referential.organization.Hospital;

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
	
	private ArrayList<String> medicalCourse;
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
	
	private AppointmentType appointmentReason;
	
	private AppointmentTypeSpeciality apppointmentSpeciality;
	
	
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
	public ArrayList<String> getMedicalCourse() {
		return medicalCourse;
	}
	
	public void setMedicalCourse(ArrayList <String> medicalCourse) {
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
	
	
	public AppointmentTypeSpeciality getApppointmentSpeciality() {
		return apppointmentSpeciality;
	}
	public void setApppointmentSpeciality(AppointmentTypeSpeciality apppointmentSpeciality) {
		this.apppointmentSpeciality = apppointmentSpeciality;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	
	

}
