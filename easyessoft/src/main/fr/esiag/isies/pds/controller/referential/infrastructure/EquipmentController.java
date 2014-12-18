package fr.esiag.isies.pds.controller.referential.infrastructure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.esiag.isies.pds.dao.referential.infrastructure.EquipmentDao;
import fr.esiag.isies.pds.dao.referential.infrastructure.TypeRefInfraDao;
import fr.esiag.isies.pds.model.referential.infrastructure.CategoryRefInfra;
import fr.esiag.isies.pds.model.referential.infrastructure.Equipment;

/**
 * Get the http request which concern Equipment, do actions and return a the right
 * view
 * @author GKA, ODI,PFR,MCH
 *
 */
@Controller
@RequestMapping("ref/equip")
public class EquipmentController {

	/**
	 * Logger declaration
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(EquipmentController.class);

	/**
	 * persist data and get data in the database
	 */
	private EquipmentDao equipmentDao = new EquipmentDao();
	
	/**
	 * Dao TypeRefInfra which get list of type of infrastructure referential
	 */
	private TypeRefInfraDao typeRefInfraDao = new TypeRefInfraDao();
	
	/**
	 * Construct this class and initialize category item
	 */
	public EquipmentController() {
		// TODO get by Dao in the future
		categoryRefInfra = new CategoryRefInfra();
		categoryRefInfra.setId(1);
		categoryRefInfra.setCode("XXXINFTYP1");
		categoryRefInfra.setLabel("Infrastructure");
	}

	/**
	 * Category of Infrastructure
	 */
	private CategoryRefInfra categoryRefInfra;
	
	/**
	 * 
	 * @param model
	 * @return form to create an equipment
	 */
	@RequestMapping("createForm")
	public String getCreateForm(Model model) {
		model.addAttribute(new Equipment());
		model.addAttribute("lstOfType",
				typeRefInfraDao.getAllByCategory(categoryRefInfra));
		LOGGER.info("EASYES Form display : Equipement creation ");
		return "ref/infra/createEquip";
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
		// TODO equipmentDao.create(equipment);
		model.addAttribute("equipment", equipment);
		LOGGER.info("EASYES Equipement creation OK");
		return "ref/infra/createEquipmentConfirm";
		// }
		// return null;

	}
}
