package fr.esiag.isies.pds.model.emergency.callcenter;

import fr.esiag.isies.pds.model.AbstractEntity;

public class InjuredPatient extends AbstractEntity {

	private String remarks;
	private String diagnostic;
	private EmergencyIncidentTicket ticket;
	private Caller caller;
	
	public Caller getCaller() {
		return caller;
	}
	public void setCaller(Caller caller) {
		this.caller = caller;
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
