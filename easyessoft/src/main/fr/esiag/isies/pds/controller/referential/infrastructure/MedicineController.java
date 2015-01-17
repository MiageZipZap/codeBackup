package fr.esiag.isies.pds.controller.referential.infrastructure;

import java.util.ArrayList;
import java.util.List;

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
import fr.esiag.isies.pds.model.referential.organization.Hospital;

/**
 * 
 * Get the http request which concern Medicine, do actions and return a view
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
	 * Full UCD code
	 */
	private String fullUcdCode;

	/**
	 * 
	 * @param model
	 * @return form to create a medicine
	 */
	@RequestMapping("createForm")
	public String getCreateForm(Model model) {
		// TODO Appel du dao hospital (getAll())
		List<Hospital> lstHospital = new ArrayList<Hospital>();
		Hospital h1 = new Hospital();
		h1.setId(5);
		h1.setName("Mondor");
		Hospital h2 = new Hospital();
		h2.setId(6);
		h2.setName("Pitiée-Salpétrière");
		lstHospital.add(h1);
		lstHospital.add(h2);
		model.addAttribute("lstHospital", lstHospital);
		// -----------------------------------
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
	public String create(@ModelAttribute Medicine medicine, Model model) {
		medicine.setUpdateUser(SecurityContextHolder.getContext()
				.getAuthentication().getName());

		// Before that, verify that type is in the right category
		medicine.getTypeRefInfra().setCategory(
				categoryRefInfraDao.getMedicCategory());
		fullUcdCode = "UCD" + medicine.getUcdCode();
		medicine.setUcdCode(fullUcdCode);
		if (new MedicineBusinessRules().verify(medicine)) {
			// TODO manage exception medicineDao.create(medicine);
			model.addAttribute("medicine", medicine);
			LOGGER.info("EASYES Medicine creation OK");
			return "ref/infra/createMedicineConfirm";
		}
		medicine.setUcdCode(medicine.getUcdCode().substring(3));
		model.addAttribute("medicine", medicine);
		model.addAttribute("lstOfType",
				typeRefInfraDao.getAllByCategory(categoryRefInfra));
		LOGGER.info("EASYES Form display : Medicine creation Error");
		return "ref/infra/createMedicine";

	}
}
