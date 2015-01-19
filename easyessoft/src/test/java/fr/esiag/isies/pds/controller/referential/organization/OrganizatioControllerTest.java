package fr.esiag.isies.pds.controller.referential.organization;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import mockit.Mocked;
import fr.esiag.isies.pds.businessRules.referential.organization.OrgaTypeBusinessRules;
import fr.esiag.isies.pds.businessRules.referential.organization.OrganizationBusinessRules;
import fr.esiag.isies.pds.dao.referential.organization.OrgaTypeDao;
import fr.esiag.isies.pds.dao.referential.organization.OrganizationDao;
import fr.esiag.isies.pds.dao.referential.organization.ServiceDao;
import fr.esiag.isies.pds.model.referential.organization.OrgaType;
import fr.esiag.isies.pds.model.referential.organization.Organization;

public class OrganizatioControllerTest {
	

	@Mocked
	OrganizationDao orgaDao;
	@Mocked
	OrgaTypeDao orgaTypeDao;
	@Mocked
	Model model;
	@Mocked
	Organization organization;
	@Mocked
	ServiceDao servicedao;
	@Mocked
	OrganizationBusinessRules organizationBR;
	@Mocked
	OrgaTypeBusinessRules orgaTypeBR;
	@Mocked
	OrgaType orgatype;	
	@Mocked
	RedirectAttributes redirectAttribute;
	
	OrganizationController organizationController;
	/**
	 * Mock Spring Security
	 */
	@Mocked SecurityContext securityContext;
	@Mocked Authentication authentication;
	
	List<OrgaType> listTypeOrga;
	
	
	@Before
	public void init() {
		SecurityContextHolder.setContext(securityContext);
		organizationController =new OrganizationController();
	}
	
	@Test
	public void testGetForm() {
		assertEquals(organizationController.getForm(model),
				"ref/orga/chooseOrgaType");
	}
	
	@Test
	public void testFormHospital(){
		assertEquals(organizationController.getForm(orgatype, model,redirectAttribute), "ref/orga/chooseOrgaType");
	}
	
	@Test
	public void testCreateOrgaType(){
		OrgaType orgatype = new OrgaType();
		orgatype.setId(1);//correspond to an Hospital Organization
		String UrlCreateHopitalForm1 = organizationController.CreateOrgType(orgatype);
		
		orgatype = new OrgaType();
		orgatype.setId(2);//correspond to an Hospital Organization
		String UrlCreateHopitalForm2 = organizationController.CreateOrgType(orgatype);
		
		assertEquals(UrlCreateHopitalForm1, UrlCreateHopitalForm2);
		assertEquals(UrlCreateHopitalForm1, "redirect:createHospitalForm");
	}

}
