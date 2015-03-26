package fr.esiag.isies.pds.model.healthPath;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import fr.esiag.isies.pds.model.AbstractEntity;
import fr.esiag.isies.pds.model.hospital.medical.CcamAct;

public class HealthPath extends AbstractEntity {
	private Date startDate;
	private Date endDate;
	private Set<CcamAct> medicalAct = new HashSet<CcamAct>(0);
	
	private String currentState;

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getCurrentState() {
		return currentState;
	}

	public void setCurrentState(String currentState) {
		this.currentState = currentState;
	}

	public Set<CcamAct> getMedicalAct() {
		return medicalAct;
	}

	public void setMedicalAct(Set<CcamAct> medicalAct) {
		this.medicalAct = medicalAct;
	}

}
