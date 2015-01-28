package fr.esiag.isies.pds.businessRules.referential.organization;

import java.util.ArrayList;
import java.util.List;

import fr.esiag.isies.pds.businessRules.ITypeBusinessRules;
import fr.esiag.isies.pds.model.referential.organization.ServiceType;

public class ServiceTypeBusinessRules implements ITypeBusinessRules<ServiceType>{
	
	private List<String> messages = new ArrayList<String>();
	public boolean verify(ServiceType item) {
		// TODO Auto-generated method stub
		return true;
	}
	public List<String> getMessages() {
		return messages;
	}
	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

}
