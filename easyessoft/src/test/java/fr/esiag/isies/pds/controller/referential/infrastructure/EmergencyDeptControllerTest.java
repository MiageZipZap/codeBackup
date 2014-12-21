package fr.esiag.isies.pds.controller.referential.infrastructure;

import static org.junit.Assert.assertEquals;
import mockit.Mocked;

import org.junit.Test;
import org.springframework.ui.Model;

public class EmergencyDeptControllerTest {
	EmergencyDeptController controller = new EmergencyDeptController();
	
	@Mocked Model model;
	
	@Test
	public void testGetHomePage() {
		assertEquals(controller.getHomePage(model), "ref/infra/emergencyDeptHomePage");
	}
}
