package fr.esiag.isies.pds.model.emergency.callcenter;

import java.sql.Timestamp;
import java.util.List;

import fr.esiag.isies.pds.model.AbstractEntity;
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
	private int idTicketState;
	private int injPatientNumber;
	private int idLocation;
	private int idCaller;
	private int nbStretcher;
	private String diagnostics;
	private String remarks;
	private Caller caller;
	private IncidentState state;
//	private IncidentState incidentState;
	private IncidentPriority priority;
	private InterventionVehicule vehicule;
	private IncidentLocalization location;
	private List<InjuredPatient> injPatients;
	private EmergencyIncidentIntervention emergencyIncidentIntervention;
	
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
	
	public int getIdTicketState() {
		return idTicketState;
	}
	public void setIdTicketState(int idTicketState) {
		this.idTicketState = idTicketState;
	}
//	public IncidentState getIncidentState() {
//		return incidentState;
//	}
//	public void setIncidentState(IncidentState incidentState) {
//		this.incidentState = incidentState;
//	}
	public Caller getCaller() {
		return caller;
	}
	public void setCaller(Caller caller) {
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
	public int getNbStretcher() {
		return nbStretcher;
	}
	public void setNbStretcher(int nbStretcher) {
		this.nbStretcher = nbStretcher;
	}
	public String getDiagnostics() {
		return diagnostics;
	}
	public void setDiagnostics(String diagnostics) {
		this.diagnostics = diagnostics;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
	public IncidentState getState() {
		return state;
	}
	public void setState(IncidentState state) {
		this.state = state;
	}
	
	public InterventionVehicule getVehicule() {
		return vehicule;
	}
	public void setVehicule(InterventionVehicule vehicule) {
		this.vehicule = vehicule;
	}
	public IncidentPriority getPriority() {
		return priority;
	}
	public void setPriority(IncidentPriority priority) {
		this.priority = priority;
	}
	public EmergencyIncidentIntervention getEmergencyIncidentIntervention() {
		return emergencyIncidentIntervention;
	}
	public void setEmergencyIncidentIntervention(EmergencyIncidentIntervention emergencyIncidentIntervention) {
		this.emergencyIncidentIntervention = emergencyIncidentIntervention;
	}
}
