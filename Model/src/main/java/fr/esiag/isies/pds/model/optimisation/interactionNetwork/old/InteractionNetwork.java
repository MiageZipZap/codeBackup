package fr.esiag.isies.pds.model.optimisation.interactionNetwork.old;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.esiag.isies.pds.model.referential.infrastructure.Infrastructure;
import fr.esiag.isies.pds.model.referential.infrastructure.Medicine;

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
	private Map<Person, List<AbstractInteraction<?, ?>>> interactions;

	private Map<Medicine, Integer> medicines;

	private Map<Infrastructure, Integer> infrastructures;

	private Map<Disease, Integer> diseases;
	
	public InteractionNetwork() {
		interactions = new HashMap<Person, List<AbstractInteraction<?, ?>>>();
		medicines = new HashMap<Medicine, Integer>();
		infrastructures = new HashMap<Infrastructure, Integer>();
		diseases = new HashMap<Disease, Integer>();
	}

	public Map<Person, List<AbstractInteraction<?, ?>>> getInteractions() {
		return interactions;
	}

	public void setInteractions(
			Map<Person, List<AbstractInteraction<?, ?>>> interactions) {
		this.interactions = interactions;
	}

	public Map<Medicine, Integer> getMedicines() {
		return medicines;
	}

	public void setMedicines(Map<Medicine, Integer> medicines) {
		this.medicines = medicines;
	}

	public Map<Infrastructure, Integer> getInfrastructures() {
		return infrastructures;
	}

	public void setInfrastructures(Map<Infrastructure, Integer> infrastructures) {
		this.infrastructures = infrastructures;
	}

	public Map<Disease, Integer> getDiseases() {
		return diseases;
	}

	public void setDiseases(Map<Disease, Integer> diseases) {
		this.diseases = diseases;
	}
}
