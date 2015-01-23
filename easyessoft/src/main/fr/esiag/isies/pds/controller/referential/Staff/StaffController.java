package fr.esiag.isies.pds.controller.referential.Staff;

import fr.esiag.isies.pds.dao.referential.staff.StaffMemberDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Get the HTTP request, do actions (Database) and return a view (JSP)
 * @author JASS KVI LAD YEL
 */

@Controller
@RequestMapping("ref/staffAdmin")
public class StaffController {
	private static final Logger LOGGER = LoggerFactory.getLogger(StaffController.class);
	
	private StaffMemberDAO staffMemberDAO;
	
	/**
	 * @param model
	 * @return form to create a Staff
	 */
	@RequestMapping("/staffHome")
	public String getMenu(){
		LOGGER.info("EASYES Administration menu page of Staff Member");
		return "ref/staff/menuStaffPage";
	}
	
}