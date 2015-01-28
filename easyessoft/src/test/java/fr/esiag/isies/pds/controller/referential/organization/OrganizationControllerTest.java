package fr.esiag.isies.pds.controller.referential.organization;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Set;

import mockit.Expectations;
import mockit.Mocked;
import mockit.NonStrictExpectations;

import org.junit.Before;
import org.junit.Test;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.esiag.isies.pds.businessRules.referential.organization.OrgaTypeBusinessRules;
import fr.esiag.isies.pds.businessRules.referential.organization.OrganizationBusinessRules;
import fr.esiag.isies.pds.dao.referential.organization.OrgaTypeDao;
import fr.esiag.isies.pds.dao.referential.organization.OrganizationDao;
import fr.esiag.isies.pds.dao.referential.organization.ServiceDao;
import fr.esiag.isies.pds.dao.referential.organization.ServiceTypeDao;
import fr.esiag.isies.pds.model.referential.organization.Hospital;
import fr.esiag.isies.pds.model.referential.organization.OrgaType;
import fr.esiag.isies.pds.model.referential.organization.Organization;
import fr.esiag.isies.pds.model.referential.organization.Service;
import fr.esiag.isies.pds.model.referential.organization.ServiceType;
/**
 * Class to test if all methods wich are in organizationController is working good
 * @author SKO JLA OSA ADA JSB
 *
 */
public class OrganizationControllerTest {

	@Mocked
	OrganizationDao orgaDao;
	@Mocked
	OrgaTypeDao orgaTypeDao;
	@Mocked
	OrgaType orgaType;

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
	RedirectAttributes redirectAttribute;
	@Mocked
	Set<ServiceType> servicesSet;
	@Mocked
	Organization trueOrga , falseOrga;
	@Mocked
	Hospital trueHospital , falseHospital;
	@Mocked
	String name;
	@Mocked
	Service service;
	@Mocked 
	ServiceType serviceType;
	@Mocked 
	ServiceTypeDao ServiceTypeDao;
	@Mocked 
	Set<ServiceType> services;

	public OrganizationController organizationController;
	public Integer id;

	/**
	 * Mock Spring Security
	 */
	@Mocked SecurityContext securityContext;
	@Mocked Authentication authentification;


	@Before
	public void init() {
		organizationController =new OrganizationController();
		model = new ExtendedModelMap();
	}

	@Test
	public void testGetForm() {
		assertEquals(organizationController.getForm(model),
				"ref/orga/chooseOrgaType");
	}

	@Test
	public void testFormHospital(){	
		validateOrgatype();
		assertEquals(organizationController.getRedirectForm(orgaType , model,redirectAttribute), "ref/orga/chooseOrgaType");
	}

	private Expectations validateOrgatype()
	{
		return new NonStrictExpectations()
		{{
			orgaTypeBR.verify(orgaType);
			result = false;
		}};
	}

	@Test
	public void testCreateOrgaType(){
		new NonStrictExpectations() {{
			orgaType.getId();result = 1;
		}};//correspond to an Hospital Organization
		String UrlCreateHopitalForm1 = organizationController.CreateOrgType(orgaType);

		new NonStrictExpectations() {{
			orgaType.getId();result = 2;
		}};
		//correspond to an Hospital Organization
		String UrlCreateHopitalForm2 = organizationController.CreateOrgType(orgaType);

		assertEquals(UrlCreateHopitalForm1, UrlCreateHopitalForm2);
		assertEquals("redirect:createHospitalForm",UrlCreateHopitalForm1);
	}

	@Test
	public void testgetFormOrganization(){
		OrgaType orgatype = new OrgaType();
		assertEquals(organizationController.getFormOrganization(model, orgatype),"ref/orga/createOrganizationForm");
	}

	@Test
	public void testCreate(){
		// Parameters is init with mocked values to test method
		new NonStrictExpectations() {{
			SecurityContextHolder.setContext(securityContext);
			securityContext.getAuthentication(); result = authentification;
			authentification.getName(); result = "unitary-test";
			organizationBR.verify(trueOrga); result = true;
		}};

		//Apply Test for organization wich have true informations
		String urlForTrueOrganization = organizationController.create(trueOrga, model);
		assertEquals(urlForTrueOrganization,"ref/orga/displaySuccessOrganization");
		// Parameters is init with mocked values to test method
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
	/**
	 * Control when we call method "GetFormHospital" she respond by the correct url
	 */
	public void testGetFormHospital(){
		OrgaType orgatype = new OrgaType();
		assertEquals (organizationController.getFormHospital(model, orgatype),"ref/orga/createOrgaHospital");
	}
	/**
	 * Control when we call method "CreateHospital" she respond by the correct url
	 */
	@Test
	public void testCreateHospital(){
		// Parameters is init with values which have true informations
		new NonStrictExpectations() {{
			SecurityContextHolder.setContext(securityContext);
			securityContext.getAuthentication(); result = authentification;
			authentification.getName(); result = "unitary-test";
			organizationBR.verify(trueHospital); result = true;
		}};
		//Apply Test for hospital wich have true informations
		String urlForTrueHospital = organizationController.createHospital(trueHospital, model);
		assertEquals("ref/orga/displaySuccessHospital",urlForTrueHospital);

		// Parameters is init with mocked values to test method
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
		new NonStrictExpectations() {{
			ArrayList<ServiceType> list = new ArrayList<ServiceType>();
			list.add(serviceType);
			service.getListIdTypeOfServices(); result = list;
		}};
	assertEquals (organizationController.chooseAService(name, id, model) , "ref/orga/chooseServiceOrgaForm");
	}

	@Test
	public void testCreateService(){
		new NonStrictExpectations() {
		{
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(1);
			service.getListIdTypeOfServices(); result = list;
			service.getServices(); result = services;
		}};
		assertEquals (organizationController.createService(name, service, model),"ref/orga/displaySuccessAddService");

	}
	/**
	 * Control when we call method "GetOrgaTableView" she respond by the correct url
	 */
	@Test
	public void testGetOrgaTableView(){
		assertEquals (organizationController.getOrgaTableView(model),"ref/orga/displayOrganizationTable");
	}
	/**
	 * Control when we call method "GetOrgaDetailsView" she respond by the correct url
	 */
	@Test
	public void testGetOrgaDetailsView(){
		//We init id service with id wich correspond to an emergency departement
		int idServEq = 1;
		assertEquals (organizationController.getOrgaDetailsView(1, idServEq, model),"../../ihm/ref/emergencyDept/read/1");
		//We init id service with id wich correspond to a departement except emmergency
		int idServ= 2;		
		assertEquals (organizationController.getOrgaDetailsView(1, idServ, model),"/getOrganizationDetails/1");
	}


}