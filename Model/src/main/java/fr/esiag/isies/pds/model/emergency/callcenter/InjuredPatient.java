package fr.esiag.isies.pds.model.emergency.callcenter;

import fr.esiag.isies.pds.model.AbstractEntity;
import fr.esiag.isies.pds.model.Person;

public class InjuredPatient extends AbstractEntity {

	private String remarks;
	private String diagnostic;
	private EmergencyIncidentTicket ticket;
	private Person person;
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getDiagnostic() {
		return diagnostic;
	}
	public void setDiagnostic(String diagnostic) {
		this.diagnostic = diagnostic;
	}
	public EmergencyIncidentTicket getTicket() {
		return ticket;
	}
	public void setTicket(EmergencyIncidentTicket ticket) {
		this.ticket = ticket;
	}
	
	
}
