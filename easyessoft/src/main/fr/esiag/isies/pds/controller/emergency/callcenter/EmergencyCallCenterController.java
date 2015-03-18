package fr.esiag.isies.pds.controller.emergency.callcenter;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import fr.esiag.isies.pds.dao.PersonDAO;
import fr.esiag.isies.pds.dao.referential.emergency.callcenter.IncidentLocalizationDAO;
import fr.esiag.isies.pds.dao.referential.emergency.callcenter.EmergencyTicketDAO;
import fr.esiag.isies.pds.model.Person;
import fr.esiag.isies.pds.model.emergency.callcenter.EmergencyIncidentTicket;
import fr.esiag.isies.pds.model.emergency.callcenter.IncidentLocalization;
import fr.esiag.isies.pds.model.emergency.callcenter.InjuredPatient;

/**
 * Get the http request which concern Organization referential administration page view
 * @author SKO JLA OSA ADA JSB
 *
 */
@Controller
@RequestMapping("emerg/callcenter")
@SessionAttributes({"interventionTicket","location","caller"})
public class EmergencyCallCenterController{

	/**
	 * Incident localization object
	 */
	private IncidentLocalization location;
	/**
	 * Contact or Caller person
	 */
	private Person caller;
	/**
	 * EmergencyIncident Object
	 */
	private EmergencyIncidentTicket ticket;
	/**
	 * Injured Patient object
	 */
	private InjuredPatient patient;
	/**
	 * Number of Injured Patient
	 */
	private int nbPatient;

	/**
	 * Logger
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(EmergencyCallCenterController.class);
	private static final int MaxPatientRecord = 5;


	public EmergencyCallCenterController() {		
		location = new IncidentLocalization();
		patient = new InjuredPatient();
		caller = new Person();
		ticket= new EmergencyIncidentTicket();
		nbPatient=0;
	}
	/**
	 * 
	 * @param model
	 * @return Administration page for Organization referential
	 */
	@RequestMapping("CallHome")
	public String getHomePage(final Model model) {
		// put your initial command
		model.addAttribute("interventionTicket", ticket);
		LOGGER.info("EASYES Form display : Call Center treatment Page");
		return "emerg/callcenter/CallTreatment";
	}
	/**	
	 * ******************************************************				
	 * CONTROLLER MANAGEMENT FOR INCIDENTS AND INTERVENTION	*
	 * ******************************************************
	 * @RequestMapping("createIncidentLocation")
	 * @RequestMapping(params = "_step=1")
	 **/
	@RequestMapping("createIncidentLocation")
	public String create(Model model) {
		model.addAttribute("location",location);
		/*		listTypeOrga = orgaTypeDao.getAll();
		if(listTypeOrga.isEmpty()){
			obr.setMessages(new ArrayList<String>());
			obr.getMessages().add("Merci de créer un type d'Organization avant de créer un organisme");
			model.addAttribute("listTypeOrga",obr.getMessages());
			return "ref/orga/error400";
		}
		model.addAttribute("listTypeOrga",listTypeOrga);
		 */		
		LOGGER.info("EASYES Form display : Rendering create incident location view");
		return "emerg/callcenter/IncidentForm1";
	}

	@RequestMapping(value ="/createLocationTraitement",method = { RequestMethod.POST})
	public String create(Model model, @ModelAttribute("location") IncidentLocalization location) {
		model.addAttribute("location",new IncidentLocalizationDAO().create(location));
		model.addAttribute("caller",caller);
		//ticket.setLocation(location);
		/*		listTypeOrga = orgaTypeDao.getAll();
		if(listTypeOrga.isEmpty()){
			obr.setMessages(new ArrayList<String>());
			obr.getMessages().add("Merci de créer un type d'Organization avant de créer un organisme");
			model.addAttribute("listTypeOrga",obr.getMessages());
			return "ref/orga/error400";
		}
		model.addAttribute("listTypeOrga",listTypeOrga);
		 */		
		LOGGER.info("EASYES Form display : Go to create link contact");
		return "emerg/callcenter/IncidentForm2";
	}

	@RequestMapping(value ="/createIncidentContact",method = { RequestMethod.POST})
	public String create(Model model, @ModelAttribute("caller") Person caller) {
		model.addAttribute("caller",new PersonDAO().create(caller));
		ticket.setCaller(caller);
		ticket.setLocation(location);
		ticket.setIdCaller(caller.getId());
		ticket.setIdLocation(location.getId());

		//loading objects to page
		model.addAttribute("interventionTicket",new EmergencyTicketDAO().create(ticket));

		LOGGER.info("EASYES Form display : Go to create incident");
		return "emerg/callcenter/IncidentForm3";
	}

	@RequestMapping(value ="/patients/jsonList", params="injPatientNumber",method=RequestMethod.GET,produces = "application/json")
	public @ResponseBody List<InjuredPatient> getPatienList(@RequestParam int injPatientNumber){
		System.out.println(injPatientNumber);

		//		if(nbInjPatients> MaxPatientRecord){
		//			return null;
		//		}
		List<InjuredPatient> patients = new ArrayList<InjuredPatient>();
		for (int i=0;i<injPatientNumber;i++) {
			InjuredPatient patient= new InjuredPatient();
			//default patient record
			Person person = new Person();
			person.setSurname("patientNom"+Integer.toString(i+1));
			person.setName("patientPrenom"+Integer.toString(i+1));
			//setting person as injured patient
			patient.setPerson(person);
			patient.setPerson(person);
			patients.add(patient);
		}	
		return patients;
	}
}
