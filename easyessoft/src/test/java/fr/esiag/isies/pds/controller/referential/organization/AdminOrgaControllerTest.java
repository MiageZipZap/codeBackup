package fr.esiag.isies.pds.controller.referential.organization;

import static org.junit.Assert.assertEquals;
import mockit.Mocked;

import org.junit.Before;
import org.junit.Test;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;

public class AdminOrgaControllerTest {

	@Mocked
	AdminOrgaController adminOrgaController;
	
	@Mocked
	Model model;
	/**
	 * Mock Spring Security
	 */
	@Mocked SecurityContext securityContext;
	@Mocked Authentication authentication;
	
	
	@Before
	public void init() {
		SecurityContextHolder.setContext(securityContext);
		adminOrgaController =new AdminOrgaController();
	}
	
	@Test
	public void testGetHomePage() {
		assertEquals(adminOrgaController.getHomePage(model),
				"ref/orga/adminPage");
	}


}
