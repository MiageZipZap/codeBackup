package fr.esiag.isies.pds.model.optimisation.interactionNetwork;

import fr.esiag.isies.pds.model.AbstractEntity;

/**
 * Class which represents a person (abstract) A person maybe a patient or a
 * staff member
 * 
 * @author PFR
 *
 */
public class Person extends AbstractEntity {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
