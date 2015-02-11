package fr.esiag.isies.pds.controller.emergency.callcenter;


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
@RequestMapping("emerg/callcenter")
public class EmergencyCallCenterController {
	/**
	 * Logger
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(EmergencyCallCenterController.class);
	
	/**
	 * 
	 * @param model
	 * @return Administration page for Organization referential
	 */
	@RequestMapping("CallHome")
	public String getHomePage(Model model) {
		LOGGER.info("EASYES Form display : Call Center treatment Page");
		return "emerg/callcenter/CallTreatment";
	}
}
