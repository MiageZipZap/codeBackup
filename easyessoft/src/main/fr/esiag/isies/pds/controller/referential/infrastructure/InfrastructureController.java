package fr.esiag.isies.pds.controller.referential.infrastructure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.esiag.isies.pds.dao.referential.infrastructure.InfrastructureDao;
import fr.esiag.isies.pds.dao.referential.infrastructure.TypeRefInfraDao;
import fr.esiag.isies.pds.model.referential.infrastructure.CategoryRefInfra;
import fr.esiag.isies.pds.model.referential.infrastructure.Infrastructure;

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
	 * persiste data and get data in the database
	 */
	private InfrastructureDao infrastructureDao = new InfrastructureDao();

	/**
	 * Dao TypeRefInfra which get list of type of infrastructure referential
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
		// TODO get by Dao in the future
		categoryRefInfra = new CategoryRefInfra();
		categoryRefInfra.setId(1);
		categoryRefInfra.setCode("XXXINFTYP1");
		categoryRefInfra.setLabel("Infrastructure");
	}

	/**
	 * 
	 * @param model
	 * @return form to create an infrastructure
	 */
	@RequestMapping("createForm")
	public String getCreateForm(Model model) {
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
		// if (new InfrastructureBusinessRules().verify(infrastructure)) {
		// TODO manage exception infrastructureDao.create(infrastructure);
		model.addAttribute("infrastructure", infrastructure);
		LOGGER.info("EASYES Infrastructure creation OK");
		return "ref/infra/createInfraConfirm";
		// }
		// return null;

	}
}
