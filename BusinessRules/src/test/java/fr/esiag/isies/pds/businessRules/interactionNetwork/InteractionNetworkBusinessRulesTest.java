package fr.esiag.isies.pds.businessRules.interactionNetwork;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import fr.esiag.isies.pds.businessRules.optimisation.interactionNetwork.InteractionNetworkBusinessRules;
import fr.esiag.isies.pds.model.optimisation.interactionNetwork.AbstractInteraction;
import fr.esiag.isies.pds.model.optimisation.interactionNetwork.InteractionNetwork;
import fr.esiag.isies.pds.model.optimisation.interactionNetwork.PatientToPatientInteraction;
import fr.esiag.isies.pds.model.referential.person.patient.Patient;

public class InteractionNetworkBusinessRulesTest {
	/*
	 * Class which is tested
	 */
	InteractionNetworkBusinessRules interactionNetworkBusinessRules;
	
	/*
	 * Interaction Network which is valid
	 */
	InteractionNetwork validInteractionNetwork;
	
	/*
	 * Interaction network which has zero interaction
	 */
	InteractionNetwork emptyInteractionNetwork;
	
	@Before
	public void init() {
		interactionNetworkBusinessRules = new InteractionNetworkBusinessRules();

		AbstractInteraction<Patient,Patient> item = new PatientToPatientInteraction();
		validInteractionNetwork = new InteractionNetwork();
		validInteractionNetwork.getInteractions().add(item);
		
		emptyInteractionNetwork = new InteractionNetwork();

	}

	@Test
	public void testVerify() {
		assertTrue(interactionNetworkBusinessRules.verify(validInteractionNetwork));
		assertFalse(interactionNetworkBusinessRules.verify(null));
		assertFalse(interactionNetworkBusinessRules.verify(emptyInteractionNetwork));
	}
}
