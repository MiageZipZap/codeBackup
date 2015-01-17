package fr.esiag.isies.pds.controller.referential.organization;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.esiag.isies.pds.businessRules.referential.organization.ServiceTypeBusinessRules;
import fr.esiag.isies.pds.dao.referential.organization.OrgaTypeDao;
import fr.esiag.isies.pds.dao.referential.organization.ServiceTypeDao;
import fr.esiag.isies.pds.model.referential.organization.OrgaType;
import fr.esiag.isies.pds.model.referential.organization.ServiceType;

/**
 * Get the http request, do actions and return a view for ServiceType referential Management
 * @author SKO JLA OSA ADA JSB
 *
 */
@Controller
@RequestMapping("ref/orga")
public class ServiceTypeController {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(OrgaTypeController.class);

	/**
	 * DAO of Organization Type object
	 */
	private ServiceTypeDao serviceTypeDao = new ServiceTypeDao();
	
	/**
	 * DAO of Organization Type object
	 */
	private OrgaTypeDao orgaTypeDao=new OrgaTypeDao();
	/**
	 * Load a List of Organization type referenced in the data base for a select option box
	 */
	private List<String> listCategory;
	
	/**
	 * 
	 * @param model
	 * @return form to create a organization
	 */
	@RequestMapping("creationFormServiceType")
	public String getForm(Model model) {
		ServiceType serviceType = new ServiceType();
		//TODO:show the last code saved
		serviceType.setCode("OSxx");
		model.addAttribute("servicetype",serviceType);
		listCategory= this.initListCategory();
		model.addAttribute("listCategory",this.listCategory);
		return "ref/orga/createServiceType";
	}
	//creationServiceType
	/**
	 * @param serviceType
	 * @param model
	 * @return creation of a type of Service
	 */
	@RequestMapping(value = "/creationServiceType", method = RequestMethod.POST)
	public String create(@ModelAttribute ServiceType serviceType,
			Model model) {
		ServiceTypeBusinessRules stBR = new ServiceTypeBusinessRules();
		if(stBR.verify(serviceType)){
			serviceTypeDao.create(serviceType);
			model.addAttribute("serviceType", serviceType);
			return "ref/orga/displaySuccessServiceType";
		}
		return "ref/orga/error500";
	}
	/**
	 * This method uses the OrgaTypeDAO to return a set of Category for which 
	 * @return
	 */
	public List<String> initListCategory() {
		List<String> list = new ArrayList<String>();
		for(OrgaType o : orgaTypeDao.getAll()){
			if(!list.contains(o.getLabel())){
				list.add(o.getLabel());	
			}
		}
		return list;
	}

}
