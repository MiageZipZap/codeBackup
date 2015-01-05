package fr.esiag.isies.pds.controller.referential.organization;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.jws.WebParam.Mode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.esiag.isies.pds.businessRules.referential.organization.OrgaTypeBusinessRules;
import fr.esiag.isies.pds.businessRules.referential.organization.OrganizationBusinessRules;
import fr.esiag.isies.pds.dao.referential.organization.OrgaTypeDao;
import fr.esiag.isies.pds.dao.referential.organization.OrganizationDao;
import fr.esiag.isies.pds.dao.referential.organization.ServiceDao;
import fr.esiag.isies.pds.dao.referential.organization.ServiceTypeDao;
import fr.esiag.isies.pds.model.referential.organization.Hospital;
import fr.esiag.isies.pds.model.referential.organization.OrgaType;
import fr.esiag.isies.pds.model.referential.organization.Organization;
import fr.esiag.isies.pds.model.referential.organization.Service;
import fr.esiag.isies.pds.model.referential.organization.ServiceType;

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
	 * **************************						
	 * ATTRIBUTES DECLARATIONS	*
	 * **************************
	 **/


	/**
	 * DAO of Organization object
	 */
	private OrganizationDao orgaDao=new OrganizationDao();
	/**
	 * DAO of Organization Type object
	 */
	private OrgaTypeDao orgaTypeDao=new OrgaTypeDao();
	/**
	 * DAO of Organization Type object
	 */
	private ServiceDao servicedao;
	/**
	 * Load a List of Organization type referenced in the data base for a select option box
	 */
	private List<OrgaType> listTypeOrga = orgaTypeDao.getAll();

	/**
	 * BussinessRules manager to verify business requirements for organization
	 */
	private OrganizationBusinessRules obr = new OrganizationBusinessRules();

	/**
	 * BussinessRules manager to verify business requirements for organization Type
	 */
	private OrgaTypeBusinessRules orgaTypeBR = new OrgaTypeBusinessRules();

	/**	
	 * **********************************************						
	 * CONTROLLER MANAGEMENT FOR ORGATYPE CHOICE	*
	 * **********************************************
	 **/

	/** 
	 * @param model
	 * @return form to create a organization
	 */
	@RequestMapping("creationForm")
	public String getForm(Model model) {
		model.addAttribute("orgaType",new OrgaType());
		model.addAttribute("listTypeOrga",listTypeOrga);
		return "ref/orga/chooseOrgaType";
	}

	@RequestMapping(value = "/addType", method = RequestMethod.POST)
	public String getForm(@ModelAttribute("orgaType") OrgaType orgaType,
			Model model,final RedirectAttributes redirectAttributes) {
		if(orgaTypeBR.verify(orgaType)){
			model.addAttribute("orgaType", orgaType);
			redirectAttributes.addFlashAttribute("orgaType", orgaType);
			return CreateOrgType(orgaType);
		}
		return "ref/orga/chooseOrgaType";
	}

	/**
	 * This method is a method which detects the Organization Type selected by the user and return
	 * the corresponding form controller with an http redirect
	 * @param orgaType
	 * @param model
	 * @return value: the corresponding form controller
	 * @return call : the controller called must accept GET method calls
	 */
	public String CreateOrgType(OrgaType orgaType){
		String returnValue = "default";
		if(orgaType.getId()==1 ||orgaType.getId()==2){
			returnValue="redirect:createHospitalForm";
		}else{
			returnValue="redirect:creationOrganizationForm";
		}
		return returnValue;
	}

	/**	
	 * **************************************************						
	 * CONTROLLER MANAGEMENT FOR ORGANIZATIONS	*
	 * **************************************************
	 **/


	/**
	 * 
	 * @param model
	 * @param orgaType
	 * @return
	 */
	@RequestMapping(value ="/creationOrganizationForm",method = { RequestMethod.POST, RequestMethod.GET})
	public String getFormOrganization(Model model, @ModelAttribute OrgaType orgaType) {
		Organization organization = new Organization();
		organization.setOrgaType(orgaType);
		model.addAttribute("organization",organization);
		return "ref/orga/createOrganizationForm";
	}

	/**
	 * @param organization
	 * @param model
	 * @return creation confirmation
	 */
	@RequestMapping(value = "/createOrganization", method = RequestMethod.POST)
	public String create(@ModelAttribute Organization organization,
			Model model) {
		organization.setUpdateUser(SecurityContextHolder.getContext()
				.getAuthentication().getName());
		if(obr.verify(organization)){
			orgaDao.create(organization);
			model.addAttribute("organization", organization);
			return "ref/orga/displaySuccessOrganization";
		}
		return null; //TODO:return error handling page
	}

	@RequestMapping(value ="/createHospitalForm",method = { RequestMethod.POST, RequestMethod.GET})
	public String getFormHospital(Model model, @ModelAttribute OrgaType orgaType) {
		Hospital hospital = new Hospital();
		model.addAttribute("hospital",hospital);
		return "ref/orga/createOrgaHospital";
	}

	/**
	 * @param organization
	 * @param model
	 * @return creation confirmation
	 */
	@RequestMapping(value = "/createHospital", method = RequestMethod.POST)
	public String createHospital(@ModelAttribute Hospital hospital,
			Model model) {
		hospital.setUpdateUser(SecurityContextHolder.getContext()
				.getAuthentication().getName());
		if(obr.verify(hospital)){
			orgaDao.create(hospital);
			model.addAttribute("hospital", hospital);
			return "ref/orga/displaySuccessHospital";
		}
		return null;
	}


	/**	
	 * **********************************************						
	 * CONTROLLER MANAGEMENT FOR SERVICE CHOICE		*
	 * **********************************************
	 **/
	@RequestMapping(value = "/chooseService",method = RequestMethod.POST)
	public String chooseAService(@RequestParam("name") String name, @RequestParam("id") Integer id, Model model) {
		List <ServiceType> listServiceType = new ServiceTypeDao().getAll();
		model.addAttribute("name",name);
		model.addAttribute("id",id);
		Service service = new Service();
		model.addAttribute("service",service);
		model.addAttribute("listServiceType",listServiceType);
		this.servicedao = new ServiceDao();
		return "ref/orga/chooseServiceOrgaForm";
	}
	/**
	 * This controller sets the link between define services and created organization
	 * @param organization
	 * @param service
	 * @param model
	 * @return success page if service added
	 */
	@RequestMapping(value = "/addNewService", method = RequestMethod.POST)
	public String createService(@ModelAttribute("service") Service service,Model model) {
		for(int idService:service.getListIdTypeOfServices()){
			ServiceType servType = new ServiceTypeDao().getById(idService);
			service.getServices().add(servType);
		}
		servicedao.addServices(service);
		return "ref/orga/displaySuccessAddService";
	}

}
