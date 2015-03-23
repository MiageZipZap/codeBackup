package fr.esiag.isies.pds.controller.optimisation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.apache.commons.lang.time.DateUtils;

import fr.esiag.isies.pds.dao.optimisation.Emergency.EmergencyFrequentationTrafficLogDao;
import fr.esiag.isies.pds.dao.referential.infrastructure.InfrastructureDao;
import fr.esiag.isies.pds.dao.referential.organization.OrganizationDao;
import fr.esiag.isies.pds.model.optimisation.AnalyzeResultEmergencyService;
import fr.esiag.isies.pds.model.referential.infrastructure.Infrastructure;
import fr.esiag.isies.pds.model.referential.organization.Organization;

@Controller
@RequestMapping("/optim")
public class OptimizationInfrastructureController {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(OptimizationInfrastructureController.class);
	private static EmergencyFrequentationTrafficLogDao         emergencyLog;
	private static OrganizationDao 					  		   myOrgaDao;
	private static ArrayList<Organization> 			   		   orgaOfHistory;
	private static Organization  							   orgaChoosenToAnalyze;
	private static InfrastructureDao                           infrastructureDao;
	private static List<Infrastructure>                        infrastructureForHospital;
	private static int										   totalCapacityOfWaitingSalle;
	private static Date 									   minDate,maxDate,analyzeStartminDate,analyzeStartmaxDate;
	private static String									   dateMinDate,heureMinDate;
	private static ArrayList<AnalyzeResultEmergencyService>    resultOfFrequentation;
	
	
	public OptimizationInfrastructureController(){
		emergencyLog         = new EmergencyFrequentationTrafficLogDao();
		myOrgaDao            = new OrganizationDao();
		orgaOfHistory        = new ArrayList<Organization>();
		orgaChoosenToAnalyze = new Organization();
		infrastructureDao    = new InfrastructureDao();
	}
	@RequestMapping("emergencyOptim")
	public String getHomePage(Model model) {
		if(orgaOfHistory.isEmpty()){
			List<Integer> ResultOrga = emergencyLog.getAllOrganizationInEmergencyTrafficLog();
		if(ResultOrga.isEmpty()){
			//A completer lors de l'US correspondante
		}
		for (int i = 0; i < ResultOrga.size(); i++) {
			Organization orgaConcernByHistory = myOrgaDao.getById(ResultOrga.get(i));
			orgaOfHistory.add(orgaConcernByHistory);
		}
		model.addAttribute("organization",orgaChoosenToAnalyze);
		model.addAttribute("orgaOfHistory",orgaOfHistory);
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
	public String analyzeEmergencyService(@ModelAttribute("organization") Organization organization
			,Model model,final RedirectAttributes redirectAttributes) throws ParseException {
		// recovery of number boxes of emergency service
		infrastructureForHospital = infrastructureDao.getAllByIdHospital(organization.getId());
		//Add attribute to model
		model.addAttribute("BoxNumber",infrastructureForHospital.size());
		//Recovery  capacity of waiting rooms
		totalCapacityOfWaitingSalle = 0;
		for(int i =0; i<infrastructureForHospital.size(); i++){
			if(infrastructureForHospital.get(i).getCode().equals("WAITSALLE")){
				totalCapacityOfWaitingSalle = infrastructureForHospital.get(i).getCapacity() + totalCapacityOfWaitingSalle;
			}
		}
		//Add attribute to model
		model.addAttribute("totalCapacityOfWaitingSalle",totalCapacityOfWaitingSalle);
		//Recovery of min and max date of history
	    minDate = ((Date) emergencyLog.minDateOfHistory(organization.getId()).get(0));
	    dateMinDate = getDateFormatInFrench(minDate);
		model.addAttribute("dateMinDate",dateMinDate);
		heureMinDate = getHourFormatInFrench(minDate);
		model.addAttribute("hourMinDate",heureMinDate);
		maxDate = ((Date) emergencyLog.maxDateOfHistory(organization.getId()).get(0));
		String heureMaxDate =getHourFormatInFrench(maxDate);
		model.addAttribute("hourMaxDate",heureMaxDate);
		//Round of min and max analyzeDate
	    analyzeStartminDate = DateUtils.round(minDate, Calendar.HOUR);
	    analyzeStartmaxDate = DateUtils.round(maxDate, Calendar.HOUR);
		//Creation arrayList of object wich have all information about frequentation
	     resultOfFrequentation = new ArrayList<AnalyzeResultEmergencyService>();
		while (analyzeStartminDate.before(analyzeStartmaxDate)){
		 List nbPatient = emergencyLog.waitingPatient(organization.getId(), analyzeStartminDate);
			resultOfFrequentation.add(new AnalyzeResultEmergencyService(getHourFormatInFrench(analyzeStartminDate), (Long) nbPatient.get(0)));
			analyzeStartminDate = addHourOnDate(analyzeStartminDate, 1);
		}
		model.addAttribute("resultOfFrequentation",resultOfFrequentation);
		return "optim/AnalyzeResultEmergencyService";
		
	}
	public static Date addHourOnDate(Date date, int nbHours) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.HOUR, nbHours);
		return cal.getTime();
		}
	
	public static String getDateFormatInFrench(Date date){
		SimpleDateFormat dateFormat =new SimpleDateFormat("dd/MM/yyyy");
		String formatedDate = dateFormat.format(date);
		return formatedDate;
	}
	
	public static String getHourFormatInFrench(Date date){
		SimpleDateFormat formatedHour =new SimpleDateFormat("HH:mm");
		String HeureMinDate = formatedHour.format(date);
		return HeureMinDate;
	}
	
}
