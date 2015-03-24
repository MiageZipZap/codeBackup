package fr.esiag.isies.pds.model.optimisation.interactionNetwork;

import java.util.ArrayList;
import java.util.List;

/**
 * Class which represents an interaction network
 * 
 * @author PFR
 *
 */
public class InteractionNetwork {
	/**
	 * interaction list by id of patient
	 */
	private List<AbstractInteraction<?, ?>> interactions;
	
	public InteractionNetwork() {
		interactions = new ArrayList<AbstractInteraction<?, ?>>();
	}

	public List<AbstractInteraction<?, ?>> getInteractions() {
		return interactions;
	}

	public void setInteractions(
			List<AbstractInteraction<?, ?>> interactions) {
		this.interactions = interactions;
	}
}
