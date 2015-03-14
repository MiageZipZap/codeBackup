package fr.esiag.isies.pds.controller.optimisation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/optim")
public class OptimizationInfrastructureController {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(OptimizationInfrastructureController.class);
	
	public OptimizationInfrastructureController(){
		
	}
	@RequestMapping("emergencyOptim")
	public String getHomePage(Model model) {
		LOGGER.info("EASYES Form display : Emergency service optimisation Page");
		return "/optim/optimEmergencyChooseDepartment";
	}
}
