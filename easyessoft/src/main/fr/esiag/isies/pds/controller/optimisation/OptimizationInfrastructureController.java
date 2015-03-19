package fr.esiag.isies.pds.controller.optimisation;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.esiag.isies.pds.dao.optimisation.Emergency.EmergencyFrequentationTrafficLogDao;
import fr.esiag.isies.pds.dao.referential.organization.OrganizationDao;
import fr.esiag.isies.pds.model.referential.organization.Organization;

@Controller
@RequestMapping("/optim")
public class OptimizationInfrastructureController {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(OptimizationInfrastructureController.class);
	private static EmergencyFrequentationTrafficLogDao eFTLD;
	private OrganizationDao myOrgaDao;
	private ArrayList<Organization> orgaOfHistory;
	
	public OptimizationInfrastructureController(){
		 eFTLD = new EmergencyFrequentationTrafficLogDao();
		 myOrgaDao = new OrganizationDao();
		 orgaOfHistory = new ArrayList<Organization>();
	}
	@RequestMapping("emergencyOptim")
	public String getHomePage(Model model) {
		List<Integer> ResultOrga = eFTLD.getAllOrganizationInEmergencyTrafficLog();
		if(ResultOrga.isEmpty()){
			//A completer 
		}
		for (int i = 0; i < ResultOrga.size(); i++) {
			Organization orgaConcernByHistory = myOrgaDao.getById(ResultOrga.get(i));
			orgaOfHistory.add(orgaConcernByHistory);
		}
		Organization orga = new Organization();
		model.addAttribute("organization",orga);
		model.addAttribute("orgaOfHistory",orgaOfHistory);
		LOGGER.info("EASYES Form display : Emergency service optimisation Page");
		return "/optim/optimEmergencyChooseDepartment";
	}
	@RequestMapping(value = "/analyzeEmergencyService", method = RequestMethod.POST)
	public String analyzeEmergencyService(@ModelAttribute("Organization") Organization organization,
			Model model,final RedirectAttributes redirectAttributes) {
				System.out.println(organization.getId());
				return "ref/orga/error400";
		
	}
}
