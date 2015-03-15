package fr.esiag.isies.pds.controller.interactionNetwork;

import static org.junit.Assert.assertEquals;
import mockit.Mocked;
import mockit.NonStrictExpectations;

import org.junit.Test;
import org.springframework.ui.Model;

import fr.esiag.isies.pds.businessRules.interactionNetwork.InteractionNetworkCriteriaBusinessRules;
import fr.esiag.isies.pds.model.interactionNetwork.InteractionNetworkCriteria;

public class InteractionNetworkControllerTest {
	InteractionNetworkController controller = new InteractionNetworkController();
	
	@Mocked InteractionNetworkCriteria interactionNetworkCriteria = new InteractionNetworkCriteria();
	
	@Mocked Model model;
	
	@Mocked InteractionNetworkCriteriaBusinessRules businessRules = new InteractionNetworkCriteriaBusinessRules();
	
//	@Test
//	public void testGetFormPage() {
//		assertEquals(controller.getFormPage(model), "interactionNetwork/criteriaForm");
//	}
	
	@Test
	public void testGetInteractionNetworkPage() {
		new NonStrictExpectations() {{
			businessRules.verify(interactionNetworkCriteria); result = true;
		}};
		assertEquals(controller.getInteractionNetworkPage(model), "interactionNetwork/interactionNetwork");
//		new NonStrictExpectations() {{
//			businessRules.verify(interactionNetworkCriteria); result = false;
//		}};
//		assertEquals(controller.getInteractionNetworkPage(interactionNetworkCriteria, model), "interactionNetwork/criteriaForm");
	}
}
