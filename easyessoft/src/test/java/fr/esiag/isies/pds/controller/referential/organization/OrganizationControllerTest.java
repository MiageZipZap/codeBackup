package fr.esiag.isies.pds.controller.referential.organization;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Set;

import mockit.Mocked;
import mockit.NonStrictExpectations;

import org.junit.Before;
import org.junit.Test;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.esiag.isies.pds.businessRules.referential.organization.OrgaTypeBusinessRules;
import fr.esiag.isies.pds.businessRules.referential.organization.OrganizationBusinessRules;
import fr.esiag.isies.pds.dao.referential.organization.OrgaTypeDao;
import fr.esiag.isies.pds.dao.referential.organization.OrganizationDao;
import fr.esiag.isies.pds.dao.referential.organization.ServiceDao;
import fr.esiag.isies.pds.model.referential.organization.Hospital;
import fr.esiag.isies.pds.model.referential.organization.OrgaType;
import fr.esiag.isies.pds.model.referential.organization.Organization;
import fr.esiag.isies.pds.model.referential.organization.Service;
import fr.esiag.isies.pds.model.referential.organization.ServiceType;

public class OrganizationControllerTest {
	

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
	@Mocked
	Set<ServiceType> servicesSet;
	
	OrganizationController organizationController;
	
	@Mocked
	Organization trueOrga , falseOrga;
	
	@Mocked
	Hospital trueHospital , falseHospital;
	
	@Mocked
	String name;
	
	@Mocked
	Integer id;
	
	@Mocked
	Service service;
	
	@Mocked 
	ServiceType serviceType;
	
	/**
	 * Mock Spring Security
	 */
	@Mocked SecurityContext securityContext;
	@Mocked Authentication authentification;
	
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
	
	@Test
	public void testgetFormOrganization(){
		assertEquals(organizationController.getFormOrganization(model, orgatype),"ref/orga/createOrganizationForm");
	}
	
	@Test
	public void testCreate(){
		// Parameters is init with values which 
		new NonStrictExpectations() {{
			securityContext.getAuthentication(); result = authentification;
			authentification.getName(); result = "unitary-test";
			organizationBR.verify(trueOrga); result = true;
		}};
		//Apply Test for organization wich have true informations
		String urlForTrueOrganization = organizationController.create(trueOrga, model);
		assertEquals(urlForTrueOrganization,"ref/orga/displaySuccessOrganization");
		
		new NonStrictExpectations() {{
			securityContext.getAuthentication(); result = authentification;
			authentification.getName(); result = "unitary-test";
			organizationBR.verify(falseOrga); result = false;
		}};
		//Apply Test for organization wich have wrong informations
		String urlForFalseOrganization = organizationController.create(falseOrga, model);
		assertEquals(urlForFalseOrganization,"ref/orga/error500");
		
	}
	
	@Test
	public void testGetFormHospital(){
		assertEquals (organizationController.getFormHospital(model, orgatype),"ref/orga/createOrgaHospital");
		}
	
	@Test
	public void testCreateHospital(){
		// Parameters is init with values which 
				new NonStrictExpectations() {{
					securityContext.getAuthentication(); result = authentification;
					authentification.getName(); result = "unitary-test";
					organizationBR.verify(trueHospital); result = true;
				}};
				//Apply Test for hospital wich have true informations
				String urlForTrueHospital = organizationController.createHospital(trueHospital, model);
				assertEquals(urlForTrueHospital,"ref/orga/displaySuccessHospital");
				
				new NonStrictExpectations() {{
					securityContext.getAuthentication(); result = authentification;
					authentification.getName(); result = "unitary-test";
					organizationBR.verify(falseHospital); result = false;
				}};
				//Apply Test for hospital wich have wrong informations
				String urlForFalseHospital = organizationController.createHospital(falseHospital, model);
				assertEquals(urlForFalseHospital,"ref/orga/error500");
	}
	
	@Test
	public void testChooseAService(){
	assertEquals (organizationController.chooseAService(name, id, model) , "ref/orga/chooseServiceOrgaForm");
	}
	
	/*@Test
	public void createService(){
		new NonStrictExpectations() {{
			service.getListIdTypeOfServices(); result = id;
			//serviceType.get resul
			
		}};
		assertEquals (organizationController.createService(name, service, model),"ref/orga/displaySuccessAddService");
		
	} TO COMPLETE*/
}
