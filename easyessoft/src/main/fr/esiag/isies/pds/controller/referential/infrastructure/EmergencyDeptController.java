package fr.esiag.isies.pds.controller.referential.infrastructure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.esiag.isies.pds.model.referential.infrastructure.Equipment;

/**
 * Get the http request which concern Emergency Department view
 * @author GKA, ODI,PFR,MCH
 *
 */
@Controller
@RequestMapping("ref/emergencyDept")
public class EmergencyDeptController {
	/**
	 * Logger
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(EmergencyDeptController.class);
	
	/**
	 * 
	 * @param model
	 * @return emergency department home page
	 */
	@RequestMapping("homePage")
	public String getHomePage(Model model) {
		LOGGER.info("EASYES Form display : Emergency Department Home Page");
		return "ref/infra/emergencyDeptHomePage";
	}

}
