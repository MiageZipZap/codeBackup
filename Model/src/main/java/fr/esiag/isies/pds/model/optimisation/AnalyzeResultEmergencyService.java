package fr.esiag.isies.pds.model.optimisation;

import java.util.Date;

public class AnalyzeResultEmergencyService {
	
	private String hourOfPassage;
	private Long nbwaitingPatient;
	
	public AnalyzeResultEmergencyService(String hourOfPassage, Long nbwaitingPatient) {
		super();
		this.hourOfPassage = hourOfPassage;
		this.nbwaitingPatient = nbwaitingPatient;
	}
	public String gethourOfPassage() {
		return hourOfPassage;
	}
	public void setRecoveryDate(String hourOfPassage) {
		this.hourOfPassage = hourOfPassage;
	}
	public Long getNbwaitingPatient() {
		return nbwaitingPatient;
	}
	public void setNbwaitingPatient(Long nbaitingPatient) {
		this.nbwaitingPatient = nbaitingPatient;
	}
	
	

}
