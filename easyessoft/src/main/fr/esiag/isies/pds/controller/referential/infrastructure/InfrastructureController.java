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

import fr.esiag.isies.pds.businessRules.refential.infrastructure.InfrastructureBusinessRules;
import fr.esiag.isies.pds.dao.referential.infrastructure.CategoryRefInfraDao;
import fr.esiag.isies.pds.dao.referential.infrastructure.InfrastructureDao;
import fr.esiag.isies.pds.dao.referential.infrastructure.TypeRefInfraDao;
import fr.esiag.isies.pds.dao.referential.organization.OrganizationDao;
import fr.esiag.isies.pds.model.referential.infrastructure.CategoryRefInfra;
import fr.esiag.isies.pds.model.referential.infrastructure.Infrastructure;
import fr.esiag.isies.pds.model.referential.organization.Hospital;

/**
 * Get the http request which concern Infrastructure, do actions and return a
 * view
 * 
 * @author ADI, MCH, GKA, PFR
 *
 */
@Controller
@RequestMapping("ref/infra")
public class InfrastructureController {
	/**
	 * Logger
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(InfrastructureController.class);

	/**
	 * Dao InfrastructureDao which get list of infrastructure referential
	 */
	private InfrastructureDao infrastructureDao = new InfrastructureDao();

	/**
	 * Dao OrganisationDao which get list of hospital
	 */
	OrganizationDao organizationDao = new OrganizationDao();
	
	/**
	 * Dao CategoryRefInfraDao which get list of category of infrastructure
	 * referential
	 */
	private CategoryRefInfraDao categoryRefInfraDao = new CategoryRefInfraDao();

	/**
	 * Dao TypeRefInfraDao which get list of type of infrastructure referential
	 */
	private TypeRefInfraDao typeRefInfraDao = new TypeRefInfraDao();

	/**
	 * Category of Infrastructure
	 */
	private CategoryRefInfra categoryRefInfra;

	/**
	 * Construct this class and initialize category item
	 */
	public InfrastructureController() {
		categoryRefInfra = categoryRefInfraDao.getInfraCategory();
	}

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
		model.addAttribute(new Infrastructure());
		model.addAttribute("lstOfType",
				typeRefInfraDao.getAllByCategory(categoryRefInfra));
		LOGGER.info("EASYES Form display : Infrastructure creation ");
		return "ref/infra/createInfra";
	}

	/**
	 * 
	 * @param infrastructure
	 * @param model
	 * @return a confirmation of infrastructure creation
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@ModelAttribute Infrastructure infrastructure,
			Model model) {
		infrastructure.setUpdateUser(SecurityContextHolder.getContext()
				.getAuthentication().getName());

		if (new InfrastructureBusinessRules().verify(infrastructure)) {
			Infrastructure infra = infrastructureDao.create(infrastructure);
			model.addAttribute("infrastructure", infra);
			LOGGER.info("EASYES Infrastructure creation OK");
			return "ref/infra/createInfraConfirm";
		}
		model.addAttribute("infrastructure", infrastructure);
		model.addAttribute("lstOfType",
				typeRefInfraDao.getAllByCategory(categoryRefInfra));
		LOGGER.info("EASYES Form display : Infrastructure creation Error");
		return "ref/infra/createInfra";

	}
}
