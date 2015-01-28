package fr.esiag.isies.pds.controller.referential.organization;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
 *TODO: messagesHandler
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
	
	private OrganizationDao orgaDao;
	/**
	 * DAO of Organization Type object
	 */
	
	private OrgaTypeDao orgaTypeDao;
	/**
	 * DAO of Organization Type object
	 */
	
	private OrgaType orgatype;
	/**
	 * Service object
	 */
	private Service service;
	/**
	 * Service Type object
	 */
	private ServiceType servType;
	/**
	 * DAO of Services and Service Type DAO
	 */
	private ServiceTypeDao serviceTypeDao;
	private ServiceDao servicedao;
	/**
	 * Load a List of Organization type referenced in the data base for a select option box
	 */

	private List<OrgaType> listTypeOrga;

	/**
	 * BussinessRules manager to verify business requirements for organization
	 */
	
	private OrganizationBusinessRules obr;

	/**
	 * BussinessRules manager to verify business requirements for organization Type
	 */
	
	private OrgaTypeBusinessRules orgaTypeBR;
	
	
	public OrganizationController() {
		 // prepare the Dao for further operation
		orgaDao=new OrganizationDao();
		orgaTypeDao=new OrgaTypeDao();
		serviceTypeDao=new ServiceTypeDao();
		servicedao = new ServiceDao();
		//most used instances
		orgatype = new OrgaType();
		obr = new OrganizationBusinessRules();
		orgaTypeBR = new OrgaTypeBusinessRules();
		
	}
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
		model.addAttribute("orgaType",orgatype);
		listTypeOrga = orgaTypeDao.getAll();
		if(listTypeOrga.isEmpty()){
			obr.setMessages(new ArrayList<String>());
			obr.getMessages().add("Merci de créer un type d'Organization avant de créer un organisme");
			model.addAttribute("listTypeOrga",obr.getMessages());
			return "ref/orga/error400";
		}
		model.addAttribute("listTypeOrga",listTypeOrga);
		LOGGER.info("EASYES Form display : Rendering Organization Type selection view");
		return "ref/orga/chooseOrgaType";
	}

	@RequestMapping(value = "/addType", method = RequestMethod.POST)
	public String getRedirectForm(@ModelAttribute("orgaType") OrgaType orgaType,
			Model model,final RedirectAttributes redirectAttributes) {
		orgaTypeBR.setMessages(new ArrayList<String>());
		if(orgaTypeBR.verify(orgaType)){
			LOGGER.info("EASYES Form display : Pass Orgatype business rules");
			model.addAttribute("orgaType", orgaType);
			redirectAttributes.addFlashAttribute("orgaType", orgaType);
			LOGGER.info("EASYES Form display : Redirect to the corresponding creation form");
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
			LOGGER.info("EASYES Form display : redirect to createHospitalForm controller");
			returnValue="redirect:createHospitalForm";
		}else{
			LOGGER.info("EASYES Form display :  redirect to createHospitalForm controller");
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
		LOGGER.info("EASYES Form display : display creationOrganizationForm");
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
		obr.setMessages(new ArrayList<String>());
		if(obr.verify(organization)){
			orgaDao.create(organization);
			model.addAttribute("organization", organization);
			LOGGER.info("EASYES Form process : Create an organization");
			return "ref/orga/displaySuccessOrganization";
		}
		model.addAttribute("messages", obr.getMessages());
		return "ref/orga/error400";
	}

	@RequestMapping(value ="/createHospitalForm",method = { RequestMethod.POST, RequestMethod.GET})
	public String getFormHospital(Model model, @ModelAttribute OrgaType orgaType) {
		Hospital hospital = new Hospital();
		LOGGER.info("EASYES Form display : createHospitalForm");
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
		obr.setMessages(new ArrayList<String>());
		if(obr.verify(hospital)){
			LOGGER.info("EASYES Form process : create an Hospital organization");
			orgaDao.create(hospital);
			model.addAttribute("hospital", hospital);
			return "ref/orga/displaySuccessHospital";
		}
		LOGGER.info("EASYES Form display : error message");
		model.addAttribute("messages", obr.getMessages());
		return "ref/orga/error400";
	}


	/**	
	 * **********************************************						
	 * CONTROLLER MANAGEMENT FOR SERVICE CHOICE		*
	 * **********************************************
	 **/
	@RequestMapping(value = "/chooseService",method = RequestMethod.POST)
	public String chooseAService(@RequestParam("name") String name, @RequestParam("id") Integer id, Model model) {
		List <ServiceType> listServiceType = serviceTypeDao.getAll();
		model.addAttribute("name",name);
		model.addAttribute("id",id);
		service = new Service();
		model.addAttribute("service",service);
		model.addAttribute("listServiceType",listServiceType);
		LOGGER.info("EASYES Form display : service box chooser page");
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
	public String createService(@RequestParam("name") String name,@ModelAttribute("service") Service service,Model model) {
		for(int idService:service.getListIdTypeOfServices()){
			servType = serviceTypeDao.getById(idService);
			LOGGER.info("EASYES Form process : add service to an organization");

			service.getServices().add(servType);
		}
		servicedao.addServices(service);
		model.addAttribute("services",service.getServices());
		model.addAttribute("name",name);
		LOGGER.info("EASYES Form display : service added success page");
		return "ref/orga/displaySuccessAddService";
	}
	
	/**	
	 * **********************************************						
	 * DISPLAY LIST CONTROLLERS						*
	 * **********************************************
	 **/
	@RequestMapping(value = "/displayOrganizations")
	public String getOrgaTableView(Model model) {		
		//Fetch all values in organization Table
		List<Organization> tableValues=orgaDao.getAll();
		//publish tableHeaders and tableValues in Model
		model.addAttribute("tableValues",tableValues);
		LOGGER.info("EASYES Form display : organizations Table list");
		return "ref/orga/displayOrganizationTable";
	}
	

	@RequestMapping(value = "/getOrganizationDetails/{idOrga}")
	public String getOrgaDetailsView(@PathVariable("idOrga") int idOrga, Model model) {		
		Organization organization = orgaDao.getById(idOrga);
		Set<ServiceType> services = new HashSet<ServiceType>(0);
		services = organization.getServicesSet();
		model.addAttribute("organization",organization);
		model.addAttribute("services",services);
		LOGGER.info("EASYES Form display : organization Details");
		return "ref/orga/displayOrganizationDetails";
	}
	
	@RequestMapping(value = "/getServiceDetails/{idOrga}/{idServ}")
	public String getOrgaDetailsView(@PathVariable("idOrga") int idOrga,@PathVariable("idServ") int idServ, Model model) {				
		LOGGER.info("EASYES Form process : show service details requests");if(idServ==1){
			return "../../ihm/ref/emergencyDept/read/"+String.valueOf(idOrga);
		}
		return "/getOrganizationDetails/"+String.valueOf(idOrga);
	}
	
}
