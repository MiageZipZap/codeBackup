package fr.esiag.isies.pds.controller.emergency.callcenter;
import static org.junit.Assert.assertEquals;
import mockit.Mocked;

import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.Model;

public class EmergencyCallCenterControllerTest {
	
	EmergencyCallCenterController emerCallCenterController;
	
	@Mocked
	Model model;

	
	@Before
	public void init() {
		emerCallCenterController =new EmergencyCallCenterController();
	}
	
	@Test
	public void testGetHomePage() {
		assertEquals(emerCallCenterController.getHomePage(model),
				"emerg/callCenter/CallTreatment");
	}
}
