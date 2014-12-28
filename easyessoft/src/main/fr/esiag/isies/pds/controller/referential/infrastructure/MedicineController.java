package fr.esiag.isies.pds.controller.referential.infrastructure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.esiag.isies.pds.businessRules.refential.infrastructure.MedicineBusinessRules;
import fr.esiag.isies.pds.dao.referential.infrastructure.CategoryRefInfraDao;
import fr.esiag.isies.pds.dao.referential.infrastructure.MedicineDao;
import fr.esiag.isies.pds.dao.referential.infrastructure.TypeRefInfraDao;
import fr.esiag.isies.pds.model.referential.infrastructure.CategoryRefInfra;
import fr.esiag.isies.pds.model.referential.infrastructure.Medicine;


/**
 * 
 * Get the http request which concern Medicine, do actions and return a
 * view
 * 
 * @author ADI, MCH, GKA, PFR
 *
 */
@Controller
@RequestMapping("ref/medicine")
public class MedicineController {

	/**
	 * Logger
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(MedicineController.class);

	/**
	 * MedicineDao 
	 */
	private MedicineDao medicineDao = new MedicineDao();

	/**
	 * CategoryRefInfraDao which provide the list of all existing categories
	 */
	private CategoryRefInfraDao categoryRefInfraDao = new CategoryRefInfraDao();

	/**
	 * TypeRefInfraDao which provide the list of all existing types
	 */
	private TypeRefInfraDao typeRefInfraDao = new TypeRefInfraDao();

	/**
	 * Category of Infrastructure
	 */
	private CategoryRefInfra categoryRefInfra;

	/**
	 * Construct this class and initialize category item
	 */
	public MedicineController() {
		categoryRefInfra = categoryRefInfraDao.getInfraCategory();
	}

	/**
	 * 
	 * @param model
	 * @return form to create a medicine
	 */
	@RequestMapping("createForm")
	public String getCreateForm(Model model) {
		model.addAttribute(new Medicine());
		model.addAttribute("lstOfType",
				typeRefInfraDao.getAllByCategory(categoryRefInfra));
		LOGGER.info("EASYES Form display : Medicine creation ");
		return "ref/infra/createMedicine";
	}

	/**
	 * 
	 * @param infrastructure
	 * @param model
	 * @return a confirmation of a medicine creation
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@ModelAttribute Medicine medicine,
			Model model) {
		medicine.setUpdateUser(SecurityContextHolder.getContext()
				.getAuthentication().getName());
		
		//Before that, verify that type is in the right category
		medicine.getTypeRefInfra().setCategory(categoryRefInfraDao.getMedicCategory());
		if (new MedicineBusinessRules().verify(medicine)) {
			// TODO manage exception medicineDao.create(medicine);
			model.addAttribute("medicine", medicine);
			LOGGER.info("EASYES Medicine creation OK");
			return "ref/infra/createMedicineConfirm";
		}
		return null;

	}
}
