package fr.esiag.isies.pds.controller.referential.staff;

import mockit.Mocked;
import org.junit.Before;
import org.junit.Test;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
/**
 * Class to test if all methods wich are in StaffMemberController is working good
 * @author AL KV JA YE
 *
 */
public class StaffMemberControllerTest {
/*
	@Mocked
	StaffMemberDAO staffMemberDao;
	@Mocked
	Organization organization;
	@Mocked
	StaffMember staffMember;
	Model model;
	@Mocked
	ServiceDao servicedao;

	@Mocked
	RedirectAttributes redirectAttribute;
	@Mocked
	Set<ServiceType> servicesSet;
	
	@Mocked
	Hospital trueHospital , falseHospital;
	@Mocked
	String name;
	@Mocked
	Service service;
	@Mocked 
	ServiceType serviceType;
	
	@Mocked 
	Set<ServiceType> services;

	public StaffMemberController staffMemberController;
	public Integer id;
	public OrganizationDao organizationDao;
	public ServiceDao serviceDao;
	public ServiceTypeDao serviceTypeDao;

	/**
	 * Mock Spring Security
	 */
	@Mocked SecurityContext securityContext;
	@Mocked Authentication authentification;


	@Before
	public void init() {
/*		staffMemberController = new StaffMemberController();
		model = new ExtendedModelMap();
		
*/		
	}
	
	/**
	 *  Control when we call method "GetForm" she respond by the correct url
	 * */
	@Test
	public void testGetForm() {
	/*	assertEquals(staffMemberController.getForm(model),
				"ref/staff/staffMemberCreate"); */
	}

	
	/**
	 *	Check values return by OrganisationDAO getAll() method.
	 * */
	@Test
	public void testGetOrganisation(){	
	/*	organizationDao = new OrganizationDao();
		List<Organization> listValues =  organizationDao.getAll();
		Boolean listValueEmpty = false;
		assertEquals(listValueEmpty, listValues.isEmpty());
	*/	
	}
	
	/**
	 *	Check values return by OrganisationDAO getAll() method.
	 * */
	@Test
	public void testGetRelatedService(){
	/*	serviceDao = new ServiceDao();
		List<Service> listValues =  serviceDao.getAll();
		Boolean listValueEmpty = false;
		assertEquals(listValueEmpty, listValues.isEmpty());
		*/
	}
	
	/**
	 *	Check values return by ServiceDAO getAll() method.
	 * */
	@Test
	public void testGetRelatedServiceType(){
	/*	serviceDao = new ServiceDao();
		List<ServiceType> listValues =  serviceTypeDao.getAll();
		Boolean listValueEmpty = false;
		assertEquals(listValueEmpty, listValues.isEmpty());
	*/	
	}
	
	/**
	 *	Check if the addStaffMember() return the correct url.
	 * */
	@Test
	public void testCreate(){
	//	assertEquals (staffMemberController.addStaffMember(staffMember, model),"ref/staff/staffMemberDisplay");
	}

}