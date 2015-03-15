package fr.esiag.isies.pds.businessRules.interactionNetwork;

import fr.esiag.isies.pds.businessRules.IBusinessRules;
import fr.esiag.isies.pds.model.interactionNetwork.InteractionNetwork;

public class InteractionNetworkBusinessRules implements
		IBusinessRules<InteractionNetwork> {

	public boolean verify(InteractionNetwork item) {
		if (item == null) {
			return false;
		}
		
		if (item.getInteractions().isEmpty()) {
			return false;
		}
		
		return true;
	}

}
