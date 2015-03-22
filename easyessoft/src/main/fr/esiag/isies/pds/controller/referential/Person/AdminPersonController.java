package fr.esiag.isies.pds.controller.referential.Person;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Get the HTTP request, do actions (Database) and return a view (JSP)
 * @author JASS KVI LAD YEL
 */
@Controller
@RequestMapping("ref/personAdmin/menu")
public class AdminPersonController {

	// Instantiate the Logger
	private static final Logger LOGGER = LoggerFactory.getLogger(PersonMemberController.class);	
	
	/**
	 * 
	 * @param model
	 * @return Administration page for Staff referential
	 */
	@RequestMapping("/personHome")
	public String getHomePage() {
		LOGGER.info("EASYES Form display : Staff Referential Admin Page");
		return "ref/staff/menuStaffPage";
	}
}
