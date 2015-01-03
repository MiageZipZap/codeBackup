package fr.esiag.isies.pds.controller.referential.organization;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
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
		//TODO:show the last code saved
		orgatype.setCode("OTxx");
		model.addAttribute("orgaType",orgatype);
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
//		orgatype.setUpdateUser(SecurityContextHolder.getContext()
//				.getAuthentication().getName());
		OrgaTypeBusinessRules otBR = new OrgaTypeBusinessRules();
		if(otBR.verify(orgatype)){
			orgaTypeDao.create(orgatype);
			model.addAttribute("orgatype", orgatype);
			return "ref/orga/displaySuccessOrgaType";
		}
		return null;
	}

	}

	//	@RequestMapping(value ="/createHospitalForm",method = { RequestMethod.POST, RequestMethod.GET})
	//	public String getFormHospital(Model model, @ModelAttribute OrgaType orgaType) {
	//		Hospital hospital = new Hospital();
	//		model.addAttribute("hospital",hospital);
	//		return "ref/orga/createOrgaHospital";
	//	}
	//	@RequestMapping(value ="/createOrganization",method = { RequestMethod.POST, RequestMethod.GET})
	//	public String getFormOrganization(Model model, @ModelAttribute OrgaType orgaType) {
	//		Organization organization = new Organization();
	//		organization.setOrgaType(orgaType);
	//		model.addAttribute("organization",organization);
	//		return "ref/orga/createOrganization";
	//	}
	//
	//	@RequestMapping(value = "/createType", method = RequestMethod.POST)
	//	public String getForm(@ModelAttribute("orgaType") OrgaType orgaType,
	//			Model model,final RedirectAttributes redirectAttributes) {
	//		OrgaTypeBusinessRules orgaTypeBR = new OrgaTypeBusinessRules();
	//		if(orgaTypeBR.verify(orgaType)){
	//			model.addAttribute("orgaType", orgaType);
	//			redirectAttributes.addFlashAttribute("orgaType", orgaType);
	//			return CreateOrgType(orgaType);
	//		}
	//		return "ref/orga/chooseOrgaType";
	//	}
	//
	//	/**
	//	 * @param organization
	//	 * @param model
	//	 * @return creation confirmation
	//	 */
	//	@RequestMapping(value = "/create", method = RequestMethod.POST)
	//	public String create(@ModelAttribute Organization organization,
	//			Model model) {
	//		organization.setUpdateUser(SecurityContextHolder.getContext()
	//				.getAuthentication().getName());
	//		OrganizationBusinessRules obr = new OrganizationBusinessRules();
	//		if(obr.verify(organization)){
	//			orgaDao.create(organization);
	//			model.addAttribute("organization", organization);
	//			return "ref/orga/display";
	//		}
	//		return null;
	//	}
	//	/**
	//	 * @param organization
	//	 * @param model
	//	 * @return creation confirmation
	//	 */
	//	@RequestMapping(value = "/createHospital", method = RequestMethod.POST)
	//	public String createHospital(@ModelAttribute Hospital hospital,
	//			Model model) {
	//		hospital.setUpdateUser(SecurityContextHolder.getContext()
	//				.getAuthentication().getName());
	//		OrganizationBusinessRules obr = new OrganizationBusinessRules();
	//		if(obr.verify(hospital)){
	//			orgaDao.create(hospital);
	//			model.addAttribute("hospital", hospital);
	//			return "ref/orga/displayHospital";
	//		}
	//		return null;
	//	}
	//
	//	/**
	//	 * This method is a method which detects the Organization Type selected by the user and return
	//	 * the corresponding form controller with an http redirect
	//	 * @param orgaType
	//	 * @param model
	//	 * @return value: the corresponding form controller
	//	 * @return call : the controller called must accept GET method calls
	//	 */
	//	public String CreateOrgType(OrgaType orgaType){
	//		String returnValue = "default";
	//		if(orgaType.getId()==1){
	//			returnValue="redirect:createHospitalForm";
	//		}else{
	//			returnValue="redirect:createOrganization";
	//		}
	//		return returnValue;
	//	}
	//}
