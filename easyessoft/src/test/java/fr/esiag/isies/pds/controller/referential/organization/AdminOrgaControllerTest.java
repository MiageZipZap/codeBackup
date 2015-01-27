package fr.esiag.isies.pds.controller.referential.organization;

import static org.junit.Assert.assertEquals;
import mockit.Mocked;

import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.Model;

public class AdminOrgaControllerTest {

	AdminOrgaController adminOrgaController;
	
	@Mocked
	Model model;

	
	@Before
	public void init() {
		adminOrgaController =new AdminOrgaController();
	}
	
	@Test
	public void testGetHomePage() {
		assertEquals(adminOrgaController.getHomePage(model),
				"ref/orga/adminPage");
	}

}
