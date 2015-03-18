package fr.esiag.isies.pds.model.emergency.callcenter;

import java.sql.Timestamp;
import java.util.List;

import fr.esiag.isies.pds.model.AbstractEntity;
import fr.esiag.isies.pds.model.Address;
import fr.esiag.isies.pds.model.Person;
/**
 * @author Samuel
 * 
 * Model of an Emergency Case
 *
 */
public class EmergencyIncidentTicket extends AbstractEntity{
	
	private Timestamp openedDate;
	private Timestamp closedDate;
	private int ticketState;
	private int injPatientNumber;
	private int idLocation;
	private int idCaller;
	private Person caller;
	private IncidentLocalization location;
	private List<InjuredPatient> injPatients;
	private List<EmergencyIncidentIntervention> emergencyIncidentInterventions;
	
	public Timestamp getOpenedDate() {
		return openedDate;
	}
	public void setOpenedDate(Timestamp openedDate) {
		this.openedDate = openedDate;
	}
	public Timestamp getClosedDate() {
		return closedDate;
	}
	public void setClosedDate(Timestamp closedDate) {
		this.closedDate = closedDate;
	}
	public int getTicketState() {
		return ticketState;
	}
	public void setTicketState(int ticketState) {
		this.ticketState = ticketState;
	}
	public Person getCaller() {
		return caller;
	}
	public void setCaller(Person caller) {
		this.caller = caller;
	}
	public IncidentLocalization getLocation() {
		return location;
	}
	public void setLocation(IncidentLocalization location) {
		this.location = location;
	}
	public int getIdLocation() {
		return idLocation;
	}
	public void setIdLocation(int idLocation) {
		this.idLocation = idLocation;
	}
	public int getIdCaller() {
		return idCaller;
	}
	public void setIdCaller(int idCaller) {
		this.idCaller = idCaller;
	}
	public int getInjPatientNumber() {
		return injPatientNumber;
	}
	public void setInjPatientNumber(int injPatientNumber) {
		this.injPatientNumber = injPatientNumber;
	}
	public List<InjuredPatient> getInjPatients() {
		return injPatients;
	}
	public void setInjPatients(List<InjuredPatient> injPatients) {
		this.injPatients = injPatients;
	}
	public List<EmergencyIncidentIntervention> getEmergencyIncidentInterventions() {
		return emergencyIncidentInterventions;
	}
	public void setEmergencyIncidentInterventions(List<EmergencyIncidentIntervention> emergencyIncidentInterventions) {
		this.emergencyIncidentInterventions = emergencyIncidentInterventions;
	}
}
