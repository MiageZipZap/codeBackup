package fr.esiag.isies.pds.controller.referential.organization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.esiag.isies.pds.businessRules.referential.organization.OrgaTypeBusinessRules;
import fr.esiag.isies.pds.dao.referential.organization.OrgaTypeDao;
import fr.esiag.isies.pds.model.referential.organization.OrgaType;

/**
 * Get the http request, do actions and return a view for OrganizationType referential Management
 * @author SKO JLA OSA ADA JSB
 *
 */
@Controller
@RequestMapping("ref/orga")
public class OrgaTypeController {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(OrgaTypeController.class);

	/**
	 * DAO of Organization Type object
	 */
	private OrgaTypeDao orgaTypeDao=new OrgaTypeDao();

	/**
	 * 
	 * @param model
	 * @return form to create a organization
	 */
	@RequestMapping("creationFormOrgaType")
	public String getForm(Model model) {
		OrgaType orgatype = new OrgaType();
		model.addAttribute("orgatype",orgatype);
		return "ref/orga/createOrgaType";
	}

	/**
	 * @param orgaType
	 * @param model
	 * @return creation of a type
	 */
	@RequestMapping(value = "/creationOrgaType", method = RequestMethod.POST)
	public String create(@ModelAttribute OrgaType orgatype,
			Model model) {
		OrgaTypeBusinessRules otBR = new OrgaTypeBusinessRules();
		if(otBR.verify(orgatype)){
			orgaTypeDao.create(orgatype);
			model.addAttribute("orgatype", orgatype);
			return "ref/orga/displaySuccessOrgaType";
		}
		return null;//error page handler
	}

}


