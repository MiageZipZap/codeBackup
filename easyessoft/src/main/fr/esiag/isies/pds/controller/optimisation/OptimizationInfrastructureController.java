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
import fr.esiag.isies.pds.model.optimisation.EmergencyFrequentationTrafficLog;
import fr.esiag.isies.pds.model.referential.organization.Organization;

@Controller
@RequestMapping("/optim")
public class OptimizationInfrastructureController {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(OptimizationInfrastructureController.class);
	private static EmergencyFrequentationTrafficLogDao emergencyLog;
	private OrganizationDao myOrgaDao;
	private final ArrayList<Organization> orgaOfHistory;
	private ArrayList<EmergencyFrequentationTrafficLog> allEventsForOrga;
	private static Organization orgaChoosenToAnalyze;
	
	public OptimizationInfrastructureController(){
		emergencyLog = new EmergencyFrequentationTrafficLogDao();
		 myOrgaDao = new OrganizationDao();
		 orgaOfHistory = new ArrayList<Organization>();
		 orgaChoosenToAnalyze = new Organization();
		 allEventsForOrga = new ArrayList<EmergencyFrequentationTrafficLog>();
	}
	@RequestMapping("emergencyOptim")
	public String getHomePage(Model model) {
		System.out.println("Mon arrayliste contient :"+orgaOfHistory.size());
		if(orgaOfHistory.isEmpty()){
		List<Integer> ResultOrga = emergencyLog.getAllOrganizationInEmergencyTrafficLog();
		if(ResultOrga.isEmpty()){
			//A completer 
		}
		System.out.println(ResultOrga.size());
		for (int i = 0; i < ResultOrga.size(); i++) {
			Organization orgaConcernByHistory = myOrgaDao.getById(ResultOrga.get(i));
			orgaOfHistory.add(orgaConcernByHistory);
		}
		model.addAttribute("organization",orgaChoosenToAnalyze);
		model.addAttribute("orgaOfHistory",orgaOfHistory);
		System.out.println(orgaOfHistory.size());
		LOGGER.info("EASYES Form display : Emergency service optimisation Page");
		return "/optim/optimEmergencyChooseHospital";
		}
		else
		{
			orgaOfHistory.clear();
			return getHomePage(model);
		}
	}
	@RequestMapping(value = "/analyzeEmergencyService", method = RequestMethod.POST)
	public String analyzeEmergencyService(@ModelAttribute("Organization") Organization organization,
			Model model,final RedirectAttributes redirectAttributes) {
		allEventsForOrga = emergencyLog.getById(organization.getId());
		return "ref/orga/error400";
		
	}
}
