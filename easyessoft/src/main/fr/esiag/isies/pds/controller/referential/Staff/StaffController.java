package fr.esiag.isies.pds.controller.referential.Staff;

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
@RequestMapping("ref/staff/member")
public class StaffController {
	private static final Logger LOGGER = LoggerFactory.getLogger(StaffController.class);
	
	private StaffMemberDAO staffMemberDAO;
	
	/**
	 * @param model
	 * @return form to create a Staff
	 */
	@RequestMapping("/create")
	public String getForm(Model model){
		model.addAttribute(new StaffMember());
		LOGGER.info("EASYES Form display :  creation ");
		return "ref/staff/staffMemberCreate";
	}
	
	/**
	 * @param Staff
	 * @param model
	 * @return a confirmation of Staff creation
	 */
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public String create(@ModelAttribute StaffMember StaffMember,Model model){
	//	Staff.setUpdateUser(SecurityContextHolder.getContext().getAuthentication().getName());
			staffMemberDAO.create(StaffMember);
			model.addAttribute("Staff",StaffMember);
			LOGGER.info("EASYES Staff creation OK");
			return "staff/display";		
	}
}
