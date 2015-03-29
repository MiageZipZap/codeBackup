package fr.esiag.isies.pds.model.emergency.callcenter;

import fr.esiag.isies.pds.model.AbstractEntity;
import fr.esiag.isies.pds.model.referential.organization.Hospital;

public class EmergencyIncidentIntervention extends AbstractEntity{
	private Hospital hospital;
	private InterventionVehicule incidentVehicule;
		
	public Hospital getHospital() {
		return (Hospital)hospital;
	}
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	public InterventionVehicule getIncidentVehicule() {
		return incidentVehicule;
	}
	public void setIncidentVehicule(InterventionVehicule incidentVehicule) {
		this.incidentVehicule = incidentVehicule;
	}
	
}
