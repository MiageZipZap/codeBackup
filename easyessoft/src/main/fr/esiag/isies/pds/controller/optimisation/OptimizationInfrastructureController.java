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
import org.apache.commons.lang.time.DateUtils;

import fr.esiag.isies.pds.dao.optimisation.emergency.EmergencyFrequentationTrafficLogDao;
import fr.esiag.isies.pds.dao.referential.infrastructure.InfrastructureDao;
import fr.esiag.isies.pds.dao.referential.organization.OrganizationDao;
import fr.esiag.isies.pds.model.optimisation.AnalyzeResultEmergencyService;
import fr.esiag.isies.pds.model.referential.infrastructure.Infrastructure;
import fr.esiag.isies.pds.model.referential.organization.Organization;
/**
 * Controller of Optimization infrastructure
 * @author OSA
 *
 */
@Controller
@RequestMapping("/optim")
public class OptimizationInfrastructureController {
	
	private static final Logger LOGGER = LoggerFactory
			.getLogger(OptimizationInfrastructureController.class);
	private static EmergencyFrequentationTrafficLogDao         emergencyLog;
	private static OrganizationDao 					  		   orgaConcernByHistoryDao;
	private static ArrayList<Organization> 			   		   orgaOfHistory;
	private static Organization  							   orgaChoosenToAnalyze;
	private static InfrastructureDao                           infrastructureDao;
	private static List<Infrastructure>                        infrastructureOfHospital;
	private static List<Integer>							   idOrgaConcernByHistory;
	private static int										   totalCapacityOfWaitingRoom,myBoxNumber;
	private static Date 									   minDate,maxDate,analyzeStartminDate,analyzeStartmaxDate;
	private static String									   dateMinDate,hourMinDate,hourMaxDate;
	private static ArrayList<AnalyzeResultEmergencyService>    resultOfFrequentation;
	
	
	public OptimizationInfrastructureController(){
		emergencyLog            = new EmergencyFrequentationTrafficLogDao();
		orgaConcernByHistoryDao = new OrganizationDao();
		orgaOfHistory           = new ArrayList<Organization>();
		orgaChoosenToAnalyze    = new Organization();
		infrastructureDao       = new InfrastructureDao();
	}
	/**
	 * Method wich return display choose an emergency. If we have nothing history
	 * for any emergency Service, it return page wich we have error message
	 * @param model
	 * @return String URL
	 */
	@RequestMapping("emergencyOptim")
	public String getViewChooseHospital(Model model) {
		//Control if object wich use on display optimEmergencyChooseHospital is empty if user refresh and recall method
		if(orgaOfHistory.isEmpty()){
			 idOrgaConcernByHistory 			= emergencyLog.getIdOfAllOrganizationInEmergencyTrafficLog();
			 //If we have any id of organization in history , it return errorpage
			 if(idOrgaConcernByHistory.isEmpty()){
				 return "optim/noHistory";
			 }
			 //adding organizations in list to use in optimEmergencyChooseHospital JSP
			 for (int i = 0; i < idOrgaConcernByHistory.size(); i++) {
				 Organization orgaConcernByHistory = orgaConcernByHistoryDao.getById(idOrgaConcernByHistory.get(i));
				 orgaOfHistory.add(orgaConcernByHistory);
			 }
			 //Add attribute to model for organization wich instanciate by choose of user (in JSP optimEmergencyChooseHospital)
			 model.addAttribute("organization",orgaChoosenToAnalyze);
			 //Add attribute to model for list of organization wich they present in history
			 model.addAttribute("orgaOfHistory",orgaOfHistory);
			 LOGGER.info("EASYES return display : optimEmergencyChooseHospital");
			 return "/optim/optimEmergencyChooseHospital";
		}
		else{
			orgaOfHistory.clear();
			return getViewChooseHospital(model);
		}
	}
	/**
	 * Method wich evaluate a situation of emergency service and return display of analyze
	 * @param organization
	 * @param model
	 * @return String URL
	 * @throws ParseException
	 */
	@RequestMapping(value = "/analyzeEmergencyService", method = RequestMethod.POST)
	public String analyzeEmergencyService(@ModelAttribute("organization") Organization organization
			,Model model) throws ParseException {
		// recovery number infrstructure of emergency service
		infrastructureOfHospital = infrastructureDao.getAllByIdHospital(organization.getId());
		totalCapacityOfWaitingRoom = 0;
		myBoxNumber = 0;
		for(int i =0; i<infrastructureOfHospital.size(); i++){
			//Control if infrastructure is waiting room, and then, increment variable
			if(infrastructureOfHospital.get(i).getLabel().equals("Salle d'attente")){
				totalCapacityOfWaitingRoom = infrastructureOfHospital.get(i).getCapacity() + totalCapacityOfWaitingRoom;
			}
			//Control if infrastructure is exam box, and then, increment variable
			if(infrastructureOfHospital.get(i).getLabel().equals("Box d'examen")){
				myBoxNumber= myBoxNumber +1;
			}
		}
		//Add attribute number of exam boxes to model to use in AnalyzeResultEmergencyService JSP
		model.addAttribute("BoxNumber",myBoxNumber);
		//Add attribute capacity of waiting room to model to use in AnalyzeResultEmergencyService JSP
		model.addAttribute("totalCapacityOfWaitingSalle",totalCapacityOfWaitingRoom);
		//Recovery min date of history for choosen organization
	    minDate = ((Date) emergencyLog.getMinDateOfHistory(organization.getId()).get(0));
	    //Make in french format
	    dateMinDate = getDateFormatInFrench(minDate);
	    //Add attribute  date of recovery to model to use in AnalyzeResultEmergencyService JSP
		model.addAttribute("dateMinDate",dateMinDate);
		//Make min hour in french format
		hourMinDate = getHourFormatInFrench(minDate);
		//Add attribute  minimum hour of recovery to model to use in AnalyzeResultEmergencyService JSP
		model.addAttribute("hourMinDate",hourMinDate);
		//Recovery max date of history for choosen organization
		maxDate = ((Date) emergencyLog.getMaxDateOfHistory(organization.getId()).get(0));
		//Make max hour in french format
		hourMaxDate =getHourFormatInFrench(maxDate);
		//Add attribute  maximum hour of recovery to model to use in AnalyzeResultEmergencyService JSP
		model.addAttribute("hourMaxDate",hourMaxDate);
		//Round of min and max analyzeDate
	    analyzeStartminDate = DateUtils.round(minDate, Calendar.HOUR);
	    analyzeStartmaxDate = DateUtils.round(maxDate, Calendar.HOUR);
		//Creation arrayList of object wich have all information about frequentation
	     resultOfFrequentation = new ArrayList<AnalyzeResultEmergencyService>();
		//instanciate a loop wich recovery at dates patients wich attending in waiting room
	    while (analyzeStartminDate.before(analyzeStartmaxDate)){
		//instanciate List to recovery patient wich attending their exam : 
		List nbPatient = emergencyLog.getWaitingPatientAtDate(organization.getId(), analyzeStartminDate);
			//Add to ArrayList hour and nb patient wich attending
			resultOfFrequentation.add(new AnalyzeResultEmergencyService(getHourFormatInFrench(analyzeStartminDate), (Long) nbPatient.get(0)));
			//increment hour 
			analyzeStartminDate = addHourOnDate(analyzeStartminDate, 1);
		}
	  //Add attribute  arraylist of frequentation to model to use in AnalyzeResultEmergencyService JSP
		model.addAttribute("resultOfFrequentation",resultOfFrequentation);
		LOGGER.info("EASYES return display : AnalyzeResultEmergencyService");
		return "optim/AnalyzeResultEmergencyService";
		
	}
	/**
	 * Method wich adding an hour pass in parameters to date 
	 * @param date
	 * @param nbHours
	 * @return Date
	 */
	public static Date addHourOnDate(Date date, int nbHours) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.HOUR, nbHours);
		return cal.getTime();
		}
	/**
	 * Method wich return in french format a date
	 * @param date
	 * @return String
	 */
	public String getDateFormatInFrench(Date date){
		SimpleDateFormat dateFormat =new SimpleDateFormat("dd/MM/yyyy");
		String formatedDate = dateFormat.format(date);
		return formatedDate;
	}
	/**
	 * Method wich return in french format a hour
	 * @param date
	 * @return String
	 */
	public static String getHourFormatInFrench(Date date){
		SimpleDateFormat formatedHour =new SimpleDateFormat("HH:mm");
		String Hour= formatedHour.format(date);
		return Hour;
	}
	
}
