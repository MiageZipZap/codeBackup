package fr.esiag.isies.pds.model.optimisation;

import java.util.Date;

import fr.esiag.isies.pds.model.AbstractEntity;
import fr.esiag.isies.pds.model.referential.infrastructure.Infrastructure;
import fr.esiag.isies.pds.model.referential.organization.Hospital;

public class EmergencyFrequentationTrafficLog extends AbstractEntity{
	
	Hospital hospital;
	int idPatient;
	int idDoctor;
	Infrastructure infra;
	Date dateInputPatient;
	Date dateExitBox;
	
	public EmergencyFrequentationTrafficLog(Hospital hospital, int idPatient, int idDoctor, Infrastructure infra,
		 Date dateInputPatient,Date dateExitBox) {
		this.hospital = hospital;
		this.idPatient = idPatient;
		this.idDoctor = idDoctor;
		this.infra = infra;
		this.dateInputPatient = dateInputPatient;
		this.dateExitBox = dateExitBox;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public int getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}

	public int getIdDoctor() {
		return idDoctor;
	}

	public void setIdDoctor(int idDoctor) {
		this.idDoctor = idDoctor;
	}

	public Infrastructure getInfra() {
		return infra;
	}

	public void setInfra(Infrastructure infra) {
		this.infra = infra;
	}

	public Date getDateInputPatient() {
		return dateInputPatient;
	}

	public void setDateInputPatient(Date dateInputPatient) {
		this.dateInputPatient = dateInputPatient;
	}

	public Date getDateExitBox() {
		return dateExitBox;
	}

	public void setDateExitBox(Date dateExitBox) {
		this.dateExitBox = dateExitBox;
	}

	
}