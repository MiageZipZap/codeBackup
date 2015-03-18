package fr.esiag.isies.pds.model.emergency.callcenter;

import java.util.List;

import fr.esiag.isies.pds.model.AbstractEntity;
import fr.esiag.isies.pds.model.referential.organization.Hospital;

public class EmergencyIncidentIntervention extends AbstractEntity{
	
	private Hospital hospital;
	private IncidentType incidentType;
	
	/**not used yet**/
	private IncidentLocalization incidentLocalization;
	private List<Integer> incidentVehicules;
	private int nbVehicule;
	private int workflow;
	private boolean status;
	/**not used yet**/
	
	public Hospital getHospital() {
		return (Hospital)hospital;
	}
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	public IncidentType getIncidentType() {
		return incidentType;
	}
	public void setIncidentType(IncidentType type) {
		this.incidentType = type;
	}
	public IncidentLocalization getIncidentLocalization() {
		return incidentLocalization;
	}
	public void setIncidentLocalization(IncidentLocalization incidentLocalization) {
		this.incidentLocalization = incidentLocalization;
	}
	public List<Integer> getIncidentVehicules() {
		return incidentVehicules;
	}
	public void setIncidentVehicules(List<Integer> incidentVehicules) {
		this.incidentVehicules = incidentVehicules;
	}
	public int getNbVehicule() {
		return nbVehicule;
	}
	public void setNbVehicule(int nbVehicule) {
		this.nbVehicule = nbVehicule;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public int getWorkflow() {
		return workflow;
	}
	public void setWorkflow(int workflow) {
		this.workflow = workflow;
	}
	
}
