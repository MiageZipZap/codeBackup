package fr.esiag.isies.pds.controller.referential.organization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.esiag.isies.pds.dao.referential.organization.OrgaTypeDao;
import fr.esiag.isies.pds.dao.referential.organization.OrganizationDao;
import fr.esiag.isies.pds.model.referential.infrastructure.Infrastructure;
import fr.esiag.isies.pds.model.referential.organization.Organization;

/**
 * Get the http request, do actions and return a view for Organizations management
 * @author SKO JLA OSA ADA JSB
 *
 */
@Controller
@RequestMapping("ref/orga")
public class OrganizationController {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(OrganizationController.class);

	/**
	 * DAO of Organization object
	 */
	private OrganizationDao orgaDao;
	/**
	 * DAO of Organization Type object
	 */
	private OrgaTypeDao orgaTypeDao;

	/**
	 * 
	 * @param model
	 * @return form to create a organization
	 */
	@RequestMapping("creationForm")
	public String getForm(Model model) {
		model.addAttribute("organization",new Organization());
		model.addAttribute("list",new OrgaTypeDao().getAll());
		return "ref/orga/create";
	}
	
	/**
	 * 
	 * @param organization
	 * @param model
	 * @return creation confirmation
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@ModelAttribute Organization organization,
			Model model) {
		organization.setUpdateUser(SecurityContextHolder.getContext()
				.getAuthentication().getName());
//		orgaDao.create(organization);
//		model.addAttribute("organization", organization);
		return "ref/orga/display";
		// }
		// return null;

	}
}
