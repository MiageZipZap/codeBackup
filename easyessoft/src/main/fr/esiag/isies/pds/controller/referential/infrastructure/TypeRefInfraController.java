package fr.esiag.isies.pds.controller.referential.infrastructure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.esiag.isies.pds.businessRules.refential.infrastructure.TypeRefInfraBusinessRules;
import fr.esiag.isies.pds.dao.referential.infrastructure.CategoryRefInfraDao;
import fr.esiag.isies.pds.dao.referential.infrastructure.TypeRefInfraDao;
import fr.esiag.isies.pds.model.referential.infrastructure.TypeRefInfra;

/**
 * Get the http request which concern Type Referential Infrastructure, do actions and return a the
 * right view
 * 
 * @author GKA, ODI,PFR,MCH
 *
 */

@Controller
@RequestMapping("ref/typeRefInfra")
public class TypeRefInfraController {

	/**
	 * Logger declaration
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(TypeRefInfraController.class);


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
	 * 
	 * @param model
	 * @return form to create a type Referential Infrastructure
	 */
	@RequestMapping("createForm")
	public String getCreateForm(Model model) {
		model.addAttribute(new TypeRefInfra());
		model.addAttribute("lstOfCategory",
				categoryRefInfraDao.getAll());
		LOGGER.info("EASYES Form display : TypeRefInfra creation ");
		return "ref/infra/createTypeRefInfra";
	}

	/**
	 * 
	 * @param type Referential infrastructure
	 * @param model
	 * @return a confirmation of infrastructure creation
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@ModelAttribute TypeRefInfra typeRefInfra, Model model) {
		
		if (new TypeRefInfraBusinessRules().verify(typeRefInfra)) {
			typeRefInfraDao.create(typeRefInfra);
			model.addAttribute("typeRefInfra", typeRefInfra);
			LOGGER.info("EASYES TypeRefInfra creation OK");
			return "ref/infra/createTypeRefInfraConfirm";
		}
		model.addAttribute("typeRefInfra", typeRefInfra);
		model.addAttribute("lstOfCategory",
				categoryRefInfraDao.getAll());
		LOGGER.info("EASYES Form display : TypeRefInfra creation Error ");
		return "ref/infra/createTypeRefInfra";

	}
}
