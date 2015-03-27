package fr.esiag.isies.pds.model.optimisation;

/**
 * Class wich we have an hour and patient who are in emergency service
 * @author OSA
 *
 */
public class AnalyzeResultEmergencyService {
	
	private String hourOfPassage;
	private Long nbwaitingPatient;
	/**
	 * Construct of class , init with an analyze hour and number of patient wich attending in emergency service 
	 * @param hourOfPassage
	 * @param nbwaitingPatient
	 */
	public AnalyzeResultEmergencyService(String hourOfPassage, Long nbwaitingPatient) {
		super();
		this.hourOfPassage = hourOfPassage;
		this.nbwaitingPatient = nbwaitingPatient;
	}
	/**
	 * Method wich return hour of analyze
	 * @return String hour
	 */
	public String gethourOfPassage() {
		return hourOfPassage;
	}
	/**
	 * Method to make an hour of analyze
	 * @param hourOfPassage
	 */
	public void sethourOfPassage(String hourOfPassage) {
		this.hourOfPassage = hourOfPassage;
	}
	/**
	 * Method wich return nb patient for an hour
	 * @return Long 
	 */
	public Long getNbWaitingPatient() {
		return nbwaitingPatient;
	}
	/**
	 * Method to when we recovery a number of patient for analyze
	 * @param nbWaitingPatient
	 */
	public void setNbWaitingPatient(Long nbWaitingPatient) {
		this.nbwaitingPatient = nbWaitingPatient;
	}
	
	

}
