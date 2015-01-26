package fr.esiag.isies.pds.controller.referential.organization;

import static org.junit.Assert.assertEquals;
import mockit.Mocked;
import mockit.NonStrictExpectations;

import org.junit.Before;
import org.junit.Test;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;

import fr.esiag.isies.pds.businessRules.referential.organization.OrgaTypeBusinessRules;
import fr.esiag.isies.pds.dao.referential.organization.OrgaTypeDao;
import fr.esiag.isies.pds.model.referential.organization.OrgaType;

public class OrgaTypeControllerTest {
	
	/**
	 * Mock Spring Security
	 */
	@Mocked 
	SecurityContext securityContext;
	
	@Mocked 
	Authentication authentication;
	
	@Mocked
	Model model;
	
	OrgaTypeController orgaTypeController;

	@Mocked
	OrgaTypeBusinessRules orgaTypeBR;
	
	@Mocked
	OrgaType orgaType , trueOrgaType , falseOrgaType;
	
	@Mocked
	OrgaTypeDao	orgaTypeDao;
	

	@Before
	public void init() {
		SecurityContextHolder.setContext(securityContext);
		orgaTypeController =new OrgaTypeController();
	}
	
	@Test
	public void testGetForm(){
		assertEquals(orgaTypeController.getForm(model),"ref/orga/createOrgaType");
		
	}

	@Test
	public void testCreate(){
		// Parameters is init with values which 
		new NonStrictExpectations() {{
			securityContext.getAuthentication(); result = authentication;
			authentication.getName(); result = "unitary-test";
			orgaTypeBR.verify(trueOrgaType); result = true;
			orgaTypeDao.create(orgaType); result = orgaType;
			
		}};
		//Apply Test for organization wich have true informations
		assertEquals(orgaTypeController.create(trueOrgaType, model),"ref/orga/displaySuccessOrgaType");
		
		new NonStrictExpectations() {{
			securityContext.getAuthentication(); result = authentication;
			authentication.getName(); result = "unitary-test";
			orgaTypeBR.verify(falseOrgaType); result = false;
			orgaTypeDao.create(orgaType); result = orgaType;
		}};
		//Apply Test for organization wich have wrong informations
		String urlForFalseOrganization = orgaTypeController.create(falseOrgaType, model);
		assertEquals(urlForFalseOrganization,null);
		
	}
}
