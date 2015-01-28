package fr.esiag.isies.pds.controller.referential.Staff;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.esiag.isies.pds.model.referential.organization.OrgaType;
import fr.esiag.isies.pds.model.referential.organization.Organization;
import fr.esiag.isies.pds.model.referential.staff.StaffMember;
import fr.esiag.isies.pds.dao.referential.staff.StaffMemberDAO;
import fr.esiag.isies.pds.dao.referential.organization.OrgaTypeDao;
import fr.esiag.isies.pds.dao.referential.organization.OrganizationDao;
import fr.esiag.isies.pds.dao.referential.organization.ServiceDao;
import fr.esiag.isies.pds.dao.referential.organization.ServiceTypeDao;

/**
 * Get the HTTP request, do actions (Database) and return a view (JSP)
 * @author JASS KVI LAD YEL
 */

@Controller
@RequestMapping("ref/staffAdmin/member")
public class StaffMemberController {
	
	// Instantiate the Logger
	private static final Logger LOGGER = LoggerFactory.getLogger(StaffMemberController.class);
	
	// Instantiate the DAO
	private StaffMemberDAO staffMemberDAO;
	private OrganizationDao organizationDAO;
	private OrgaTypeDao organizationTypeDAO;
	private ServiceDao serviceDAO;
	private ServiceTypeDao serviceTypeDAO;
	
	//private List<Organization> listOrga;
	private List<OrgaType> listTypeOrga;
	
	public StaffMemberController() {
		staffMemberDAO = new StaffMemberDAO();
		organizationDAO = new OrganizationDao();
		organizationTypeDAO = new OrgaTypeDao();
		serviceDAO = new ServiceDao();
		serviceTypeDAO = new ServiceTypeDao();
	}
	
	
	/**
	 * @param model
	 * @return form to create a Staff
	 */
	@RequestMapping("/staffHome")
	public String getForm2(Model model2){
		model2.addAttribute(new StaffMember());
		LOGGER.info("EASYES Form display :  creation ");
		return "ref/staff/staffMemberCreate";
	}
	
	/**
	 * @param model
	 * @return form to create a Staff
	 */
	@RequestMapping("createForm")
	public String getForm(Model model) {
		model.addAttribute(new StaffMember()); 
		model.addAttribute("listOrganization", organizationDAO.getAll());
		model.addAttribute("listOrganizationType", organizationTypeDAO.getAll());
		model.addAttribute("listService", serviceDAO.getAll());
		System.out.println((serviceDAO.getAll()).size());
		System.out.println((serviceTypeDAO.getAll()).size());
		return "ref/staff/staffMemberCreate";
	}
	
	/**
	 * @param Staff
	 * @param model
	 * @return a confirmation of Staff creation
	 */
	@RequestMapping(value = "/createAction",method = RequestMethod.POST)
	public String addStaffMember(@ModelAttribute StaffMember staffMember, Model model){
		LOGGER.info("EASYES Staff creation Create Action");
		LOGGER.info("EASYES " + staffMember.getAdress().getStreetName());
		staffMemberDAO.create(staffMember);
		LOGGER.info("EASYES Staff creation Create Action 2");
		model.addAttribute("staffMember",staffMember);
		return "ref/staff/staffMemberDisplay";		
	}
}
