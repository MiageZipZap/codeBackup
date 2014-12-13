package fr.esiag.isies.pds.controller.referential.organization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.esiag.isies.pds.dao.referential.organization.OrgaTypeDao;
import fr.esiag.isies.pds.dao.referential.organization.OrganizationDao;
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
		model.addAttribute(new Organization());
		model.addAttribute(orgaTypeDao.getAll());
		
		
		return "ref/orga/create";
	}
}
