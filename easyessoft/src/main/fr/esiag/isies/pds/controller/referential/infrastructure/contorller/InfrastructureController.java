package fr.esiag.isies.pds.controller.referential.infrastructure.contorller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.esiag.isies.pds.dao.referential.infrastructure.InfrastructureDao;
import fr.esiag.isies.pds.model.referential.infrastructure.Infrastructure;

/**
 * Get the http request which concern Infrastructure, do actions and return a
 * view
 * 
 * @author ODI, MCH, GKA, PFR
 *
 */
@Controller
@RequestMapping("ref/infra")
public class InfrastructureController {
	/**
	 * Logger declaration
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(InfrastructureController.class);

	/**
	 * persist data and get data in the database
	 */
	private InfrastructureDao infrastructureDao;

	/**
	 * 
	 * @param model
	 * @return form to create an infrastructure
	 */
	@RequestMapping("createForm")
	public String getCreateForm(Model model) {
		model.addAttribute(new Infrastructure());
		LOGGER.info("EASYES Form display : Infrastructure creation ");
		return "ref/infra/create";
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
		infrastructureDao.create(infrastructure);
		model.addAttribute("infrastructure", infrastructure);
		LOGGER.info("EASYES Infrastructure creation OK");
		return "ref/infra/display";
		// }
		// return null;

	}
}
