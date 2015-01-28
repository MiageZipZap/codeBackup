//package fr.esiag.isies.pds.controller.referential.organization;
//
//import java.util.List;
//
//import mockit.Mocked;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContext;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.web.WebAppConfiguration;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.ui.Model;
//import org.springframework.web.context.WebApplicationContext;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
//
//import fr.esiag.isies.pds.businessRules.referential.organization.OrgaTypeBusinessRules;
//import fr.esiag.isies.pds.businessRules.referential.organization.OrganizationBusinessRules;
//import fr.esiag.isies.pds.dao.referential.organization.OrgaTypeDao;
//import fr.esiag.isies.pds.dao.referential.organization.OrganizationDao;
//import fr.esiag.isies.pds.dao.referential.organization.ServiceDao;
//import fr.esiag.isies.pds.model.referential.organization.OrgaType;
//
//
//@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
//@ContextConfiguration(locations = {"**/easyessoft-servlet.xml", "**/web.xml"})
//public class OrganizationMvcControllerTest {
//	private MockMvc mockMvc;
//	@Autowired
//	private WebApplicationContext wac;
//
//	/**
//	 * Mock DAO of Organization object
//	 */
//	@Mocked
//	OrganizationDao orgaDao;
//	@Mocked
//	Model model;
//
//	/**
//	 * DAO of Organization Type object
//	 */
//	@Mocked
//	OrgaTypeDao orgaTypeDao;
//	List<OrgaType> listTypeOrga;
//
//
//
//
//	/**
//	 * DAO of Organization Type object
//	 */
//	private ServiceDao servicedao;
//	/**
//	 * Load a List of Organization type referenced in the data base for a select option box
//	 */
//
//
//	/**
//	 * BussinessRules manager to verify business requirements for organization
//	 */
//	private OrganizationBusinessRules obr = new OrganizationBusinessRules();
//
//	/**
//	 * BussinessRules manager to verify business requirements for organization Type
//	 */
//	private OrgaTypeBusinessRules orgaTypeBR = new OrgaTypeBusinessRules();
//
//	/**
//	 * Mock Spring Security
//	 */
//	@Mocked SecurityContext securityContext;
//	@Mocked Authentication authentication;
//
//	@Before
//	public void setup(){
//		SecurityContextHolder.setContext(securityContext);
//		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
//	}
//	
//	
//	@Test
//	public void getCreationForm() throws Exception {
//		mockMvc.perform(get("ref/orga/creationForm"))
//		.andExpect(status().isOk())
//		.andExpect(view().name("ref/orga/chooseOrgaType"))
//		.andExpect(forwardedUrl("/WEB-INF/views/ref/orga/chooseOrgaType.jsp"));
//	}
//	
//	//------------------------
//	@Test
//	public void method() throws Exception {
//		//to be implemented with the others controllersTest
//	}
//	
//	
//	
//}
//
//
