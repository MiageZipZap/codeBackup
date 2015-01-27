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

import fr.esiag.isies.pds.businessRules.refential.infrastructure.MedicineBusinessRules;
import fr.esiag.isies.pds.dao.referential.infrastructure.CategoryRefInfraDao;
import fr.esiag.isies.pds.dao.referential.infrastructure.MedicineDao;
import fr.esiag.isies.pds.dao.referential.infrastructure.TypeRefInfraDao;
import fr.esiag.isies.pds.dao.referential.organization.OrganizationDao;
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
	 * Dao of organization
	 */
	private OrganizationDao organizationDao = new OrganizationDao();

	/**
	 * Category of Infrastructure
	 */
	private CategoryRefInfra categoryRefInfra;

	/**
	 * Construct this class and initialize category item
	 */
	public MedicineController() {
		categoryRefInfra = categoryRefInfraDao.getMedicCategory();
	}

	/**
	 * Full UCD code
	 */
	private String fullUcdCode;
	/**
	 * Create Form without id Hospital
	 * @param model
	 * @return form to create an infrastructure
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
		model.addAttribute("lstHospital", organizationDao.<Hospital>getAllByType(Hospital.class));
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
		
		fullUcdCode = "UCD" + medicine.getUcdCode();
		medicine.setUcdCode(fullUcdCode);
		if (new MedicineBusinessRules().verify(medicine)) {
			Medicine m = medicineDao.create(medicine);
			model.addAttribute("medicine", m);
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
