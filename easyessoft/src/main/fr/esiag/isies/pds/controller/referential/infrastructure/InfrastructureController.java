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

import fr.esiag.isies.pds.businessRules.refential.infrastructure.InfrastructureBusinessRules;
import fr.esiag.isies.pds.dao.referential.infrastructure.CategoryRefInfraDao;
import fr.esiag.isies.pds.dao.referential.infrastructure.InfrastructureDao;
import fr.esiag.isies.pds.dao.referential.infrastructure.TypeRefInfraDao;
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
	 * 
	 * @param model
	 * @return form to create an infrastructure
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
		h2.setName("Piti�e-Salp�tri�re");
		lstHospital.add(h1);
		lstHospital.add(h2);
		model.addAttribute("lstHospital", lstHospital);
		// -----------------------------------
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
			// TODO manage exception infrastructureDao.create(infrastructure);
			model.addAttribute("infrastructure", infrastructure);
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
