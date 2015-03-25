package fr.esiag.isies.pds.model.optimisation;


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
	public void sethourOfPassage(String hourOfPassage) {
		this.hourOfPassage = hourOfPassage;
	}
	public Long getNbWaitingPatient() {
		return nbwaitingPatient;
	}
	public void setNbWaitingPatient(Long nbWaitingPatient) {
		this.nbwaitingPatient = nbWaitingPatient;
	}
	
	

}
