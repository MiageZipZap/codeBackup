package fr.esiag.isies.pds.controller.referential.infrastructure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.esiag.isies.pds.businessRules.refential.infrastructure.EquipmentBusinessRules;
import fr.esiag.isies.pds.dao.referential.infrastructure.CategoryRefInfraDao;
import fr.esiag.isies.pds.dao.referential.infrastructure.EquipmentDao;
import fr.esiag.isies.pds.dao.referential.infrastructure.TypeRefInfraDao;
import fr.esiag.isies.pds.dao.referential.organization.OrganizationDao;
import fr.esiag.isies.pds.model.referential.infrastructure.CategoryRefInfra;
import fr.esiag.isies.pds.model.referential.infrastructure.Equipment;
import fr.esiag.isies.pds.model.referential.organization.Hospital;

/**
 * Get the http request which concern Equipment, do actions and return a the
 * right view
 * 
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
	 * Dao EquipmentDao which get list of equipment referential
	 */
	private EquipmentDao equipmentDao = new EquipmentDao();

	/**
	 * Dao of Organization
	 */
	OrganizationDao organizationDao = new OrganizationDao();

	/**
	 * Dao CategoryRefInfraDao which get list of category of infrastructure
	 * referential
	 */
	private CategoryRefInfraDao categoryRefInfraDao = new CategoryRefInfraDao();

	/**
	 * Dao TypeRefInfra which get list of type of infrastructure referential
	 */
	private TypeRefInfraDao typeRefInfraDao = new TypeRefInfraDao();

	/**
	 * Construct this class and initialize category item
	 */
	public EquipmentController() {
		categoryRefInfra = categoryRefInfraDao.getEquipCategory();
	}

	/**
	 * Category of Infrastructure
	 */
	private CategoryRefInfra categoryRefInfra;

	/**
	 * Create Form without id Hospital
	 * 
	 * @param model
	 * @return form to create an equipment
	 */
	@RequestMapping("createForm")
	public String getCreateForm(Model model) {
		return getForm(model);
	}

	/**
	 * Create Form with an id of an Hospital
	 * 
	 * @param model
	 * @return form to create an equipment
	 */
	@RequestMapping("createForm/{idHospital}")
	public String getCreateFormWithHospital(
			@PathVariable("idHospital") int idHospital, Model model) {
		model.addAttribute("idHospital", idHospital);
		return getForm(model);
	}

	private String getForm(Model model) {
		model.addAttribute("lstHospital",
				organizationDao.<Hospital> getAllByType());
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
	public String create(@ModelAttribute Equipment equipment, Model model) {
		equipment.setUpdateUser(SecurityContextHolder.getContext()
				.getAuthentication().getName());
		if (new EquipmentBusinessRules().verify(equipment)) {
			Equipment eq = equipmentDao.create(equipment);
			model.addAttribute("equipment", eq);
			LOGGER.info("EASYES Equipement creation OK");
			return "ref/infra/createEquipmentConfirm";
		}
		model.addAttribute("equipment", equipment);
		model.addAttribute("lstOfType",
				typeRefInfraDao.getAllByCategory(categoryRefInfra));
		LOGGER.info("EASYES Form display : Equipement creation Error ");
		return "ref/infra/createEquip";

	}
}
