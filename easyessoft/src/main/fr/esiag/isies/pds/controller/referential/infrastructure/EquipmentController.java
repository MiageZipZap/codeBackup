package fr.esiag.isies.pds.controller.referential.infrastructure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.esiag.isies.pds.dao.referential.infrastructure.EquipmentDao;
import fr.esiag.isies.pds.model.referential.infrastructure.Equipment;

/**
 * Get the http request which concern Equipment, do actions and return a the right
 * view
 * @author GKA, ODI,PFR,MCH
 *
 */
public class EquipmentController {

	/**
	 * Logger declaration
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(EquipmentController.class);

	/**
	 * persist data and get data in the database
	 */
	private EquipmentDao equipmentDao;

	/**
	 * 
	 * @param model
	 * @return form to create an equipment
	 */
	@RequestMapping("createForm")
	public String getCreateForm(Model model) {
		model.addAttribute(new Equipment());
		LOGGER.info("EASYES Form display : Equipement creation ");
		return "ref/infra/create";
	}

	/**
	 * 
	 * @param infrastructure
	 * @param model
	 * @return a confirmation of infrastructure creation
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@ModelAttribute Equipment equipment,
			Model model) {
		equipment.setUpdateUser(SecurityContextHolder.getContext()
				.getAuthentication().getName());
		// if (new InfrastructureBusinessRules().verify(infrastructure)) {
		equipmentDao.create(equipment);
		model.addAttribute("equipement", equipment);
		LOGGER.info("EASYES Equipement creation OK");
		return "ref/infra/display";
		// }
		// return null;

	}
}
