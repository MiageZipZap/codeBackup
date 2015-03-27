package fr.esiag.isies.pds.controller.interactionNetwork;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import mockit.Mocked;
import mockit.NonStrictExpectations;

import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.Model;

import fr.esiag.isies.pds.businessRules.optimisation.interactionNetwork.InteractionNetworkCriteriaBusinessRules;
import fr.esiag.isies.pds.controller.optimisation.interactionNetwork.InteractionNetworkController;
import fr.esiag.isies.pds.dao.optimisation.interactionNetwork.InteractionNetworkDao;
import fr.esiag.isies.pds.model.optimisation.interactionNetwork.AbstractInteraction;
import fr.esiag.isies.pds.model.optimisation.interactionNetwork.PatientToPatientInteraction;
import fr.esiag.isies.pds.model.optimisation.interactionNetwork.old.InteractionNetworkCriteria;

public class InteractionNetworkControllerTest {
	InteractionNetworkController controller = new InteractionNetworkController();
	
	@Mocked InteractionNetworkCriteria interactionNetworkCriteria = new InteractionNetworkCriteria();
	
	@Mocked Model model;
	
	@Mocked InteractionNetworkDao interactionNetworkDao;
	
	@Mocked InteractionNetworkCriteriaBusinessRules businessRules = new InteractionNetworkCriteriaBusinessRules();
	
	private PatientToPatientInteraction patientToPatientInteraction;
	
	private List<AbstractInteraction<?,?>> lst;
	
//	@Test
//	public void testGetFormPage() {
//		assertEquals(controller.getFormPage(model), "interactionNetwork/criteriaForm");
//	}
	
	@Before
	public void init() {
		lst = new ArrayList<AbstractInteraction<?,?>>();
		patientToPatientInteraction = new PatientToPatientInteraction();
		lst.add(patientToPatientInteraction);
	}
	
	@Test
	public void testGetInteractionNetworkPage() {
		new NonStrictExpectations() {{
			businessRules.verify(interactionNetworkCriteria); result = true;
			interactionNetworkDao.getInteractions(); result = lst;
		}};
		assertEquals(controller.getInteractionNetworkPage(model), "interactionNetwork/interactionNetwork");
//		new NonStrictExpectations() {{
//			businessRules.verify(interactionNetworkCriteria); result = false;
//		}};
//		assertEquals(controller.getInteractionNetworkPage(interactionNetworkCriteria, model), "interactionNetwork/criteriaForm");
	}
}
