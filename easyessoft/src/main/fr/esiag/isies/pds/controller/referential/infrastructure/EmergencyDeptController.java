package fr.esiag.isies.pds.controller.referential.infrastructure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Get the http request which concern Emergency Department view
 * 
 * @author GKA,ODI,PFR,MCH
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

	/**
	 * Read infrastructure, equipment and medicine which are in the emergency
	 * service of an hospital
	 * 
	 * @param idHospital
	 *            of an hospital
	 * @param model
	 * @return page which show all the infrastructure, equipment and medicine
	 *         which are in the emergency service of an hospital
	 */
	@RequestMapping("read/{idHospital}")
	public String read(@PathVariable("idHospital") int idHospital, Model model) {
		//TODO get equipment, infrastructure and medicine by the idHospital in DAO
		//model.addAttribute("equipments", listOfEquipments);
		//model.addAttribute("infrastructures", listOfInfrastructures);
		//model.addAttribute("medicines", listOfMedicines);
		return "ref/infra/read";
	}
}
