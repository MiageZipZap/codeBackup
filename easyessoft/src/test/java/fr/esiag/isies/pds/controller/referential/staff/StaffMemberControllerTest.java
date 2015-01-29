package fr.esiag.isies.pds.controller.referential.staff;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import mockit.Expectations;
import mockit.Mocked;
import mockit.NonStrictExpectations;
import net.sf.oval.constraint.AssertFalse;
import net.sf.oval.constraint.AssertTrueCheck;

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
import fr.esiag.isies.pds.controller.referential.Staff.StaffMemberController;
import fr.esiag.isies.pds.dao.referential.organization.OrgaTypeDao;
import fr.esiag.isies.pds.dao.referential.organization.OrganizationDao;
import fr.esiag.isies.pds.dao.referential.organization.ServiceDao;
import fr.esiag.isies.pds.dao.referential.organization.ServiceTypeDao;
import fr.esiag.isies.pds.dao.referential.staff.StaffMemberDAO;
import fr.esiag.isies.pds.model.referential.organization.Hospital;
import fr.esiag.isies.pds.model.referential.organization.OrgaType;
import fr.esiag.isies.pds.model.referential.organization.Organization;
import fr.esiag.isies.pds.model.referential.organization.Service;
import fr.esiag.isies.pds.model.referential.organization.ServiceType;
import fr.esiag.isies.pds.model.referential.staff.StaffMember;
/**
 * Class to test if all methods wich are in StaffMemberController is working good
 * @author AL KV JA YE
 *
 */
public class StaffMemberControllerTest {

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
		staffMemberController = new StaffMemberController();
		model = new ExtendedModelMap();
		
		
	}
	
	/**
	 *  Control when we call method "GetForm" she respond by the correct url
	 * */
	@Test
	public void testGetForm() {
		assertEquals(staffMemberController.getForm(model),
				"ref/staff/staffMemberCreate");
	}

	
	/**
	 *	Check values return by OrganisationDAO getAll() method.
	 * */
	@Test
	public void testGetOrganisation(){	
		organizationDao = new OrganizationDao();
		List<Organization> listValues =  organizationDao.getAll();
		Boolean listValueEmpty = false;
		assertEquals(listValueEmpty, listValues.isEmpty());
		
	}
	
	/**
	 *	Check values return by OrganisationDAO getAll() method.
	 * */
	@Test
	public void testGetRelatedService(){
		serviceDao = new ServiceDao();
		List<Service> listValues =  serviceDao.getAll();
		Boolean listValueEmpty = false;
		assertEquals(listValueEmpty, listValues.isEmpty());
		
	}
	
	/**
	 *	Check values return by ServiceDAO getAll() method.
	 * */
	@Test
	public void testGetRelatedServiceType(){
		serviceDao = new ServiceDao();
		List<ServiceType> listValues =  serviceTypeDao.getAll();
		Boolean listValueEmpty = false;
		assertEquals(listValueEmpty, listValues.isEmpty());
		
	}
	
	/**
	 *	Check if the addStaffMember() return the correct url.
	 * */
	@Test
	public void testCreate(){
		assertEquals (staffMemberController.addStaffMember(staffMember, model),"ref/staff/staffMemberDisplay");
	}


}