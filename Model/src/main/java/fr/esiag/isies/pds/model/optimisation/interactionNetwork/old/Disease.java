package fr.esiag.isies.pds.model.optimisation.interactionNetwork.old;

import fr.esiag.isies.pds.model.AbstractEntity;

/**
 * Mock of Disease class with information which i need for InteractionNetwork !
 * 
 * @author PFR
 *
 */
public class Disease extends AbstractEntity {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
