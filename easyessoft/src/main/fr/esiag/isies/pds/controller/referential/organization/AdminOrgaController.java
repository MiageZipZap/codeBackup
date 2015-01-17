package fr.esiag.isies.pds.controller.referential.organization;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Get the http request which concern Organization referential administration page view
 * @author SKO JLA OSA ADA JSB
 *
 */
@Controller
@RequestMapping("ref/orgaAdmin")
public class AdminOrgaController {
	/**
	 * Logger
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(AdminOrgaController.class);
	
	/**
	 * 
	 * @param model
	 * @return Administration page for Organization referential
	 */
	@RequestMapping("organizationHome")
	public String getHomePage(Model model) {
		LOGGER.info("EASYES Form display : Organization Referential Admin Page");
//		return "ref/orga/displaySuccessHospital";
		return "ref/orga/adminPage";
	}
}
