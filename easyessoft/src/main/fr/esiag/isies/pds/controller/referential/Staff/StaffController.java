package fr.esiag.isies.pds.controller.referential.Staff;

import fr.esiag.isies.pds.model.referential.organization.OrgaType;
import fr.esiag.isies.pds.model.referential.staff.StaffMember;
import fr.esiag.isies.pds.dao.referential.staff.StaffMemberDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Get the HTTP request, do actions (Database) and return a view (JSP)
 * @author JASS KVI LAD YEL
 */

@Controller
@RequestMapping("ref/staffAdmin/member")
public class StaffController {
	
	// Instantiate the Logger
	private static final Logger LOGGER = LoggerFactory.getLogger(StaffController.class);
	
	// Instantiate the DAO
	private StaffMemberDAO staffMemberDAO = new StaffMemberDAO();
	
	/**
	 * @param model
	 * @return form to create a Staff
	 */
	@RequestMapping("/staffHome")
	public String getForm(Model model){
		model.addAttribute(new StaffMember());
		LOGGER.info("EASYES Form display :  creation ");
		return "ref/staff/staffMemberCreate";
	}
	
	/**
	 * @param model
	 * @return form to create a Staff
	 */
	@RequestMapping("createForm")
	public String getForm(@ModelAttribute("StaffMember") OrgaType orgaType, Model model) {
		model.addAttribute(new StaffMember());
		return "ref/staff/staffMemberCreate";
	}
	
	/**
	 * @param Staff
	 * @param model
	 * @return a confirmation of Staff creation
	 */
	@RequestMapping(value = "/createAction",method = RequestMethod.POST)
	public String addStaffMember(@ModelAttribute StaffMember staffMember,Model model){
		LOGGER.info("EASYES Staff creation Create Action");
		staffMemberDAO.create(staffMember);
		model.addAttribute("Staff",staffMember);
		return "ref/staff/staffMemberDisplay";		
	}
}
