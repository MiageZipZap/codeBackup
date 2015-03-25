package fr.esiag.isies.pds.controller.emergency.callcenter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import fr.esiag.isies.pds.dao.referential.emergency.callcenter.CallerDAO;
import fr.esiag.isies.pds.dao.referential.emergency.callcenter.EmergencyIncidentPriorityDAO;
import fr.esiag.isies.pds.dao.referential.emergency.callcenter.EmergencyIncidentStateDAO;
import fr.esiag.isies.pds.dao.referential.emergency.callcenter.EmergencyTicketDAO;
import fr.esiag.isies.pds.dao.referential.emergency.callcenter.IncidentLocalizationDAO;
import fr.esiag.isies.pds.model.emergency.callcenter.Caller;
import fr.esiag.isies.pds.model.emergency.callcenter.EmergencyIncidentTicket;
import fr.esiag.isies.pds.model.emergency.callcenter.IncidentLocalization;
import fr.esiag.isies.pds.model.emergency.callcenter.IncidentPriority;
import fr.esiag.isies.pds.model.emergency.callcenter.IncidentState;
import fr.esiag.isies.pds.model.emergency.callcenter.InterventionVehicule;


@Controller
@RequestMapping("emerg/callcenter")
@SessionAttributes("interventionTicket")
public class EmergencyCallCenterIncidentController {


	/**
	 * Incident localization object
	 */
	private IncidentLocalization location;
	/**
	 * Contact or Caller person
	 */
	private Caller caller;
	/**
	 * EmergencyIncident Object
	 */
	private EmergencyIncidentTicket ticket;

	/**
	 * Logger
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(EmergencyCallCenterController.class);

	public EmergencyCallCenterIncidentController() {
		init();
	}
	

	public void init(){
		location = new IncidentLocalization();
		caller = new Caller();
		ticket= new EmergencyIncidentTicket();
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
		LOGGER.info("EASYES Form display : Rendering create incident location view");
		model.addAttribute("interventionTicket", ticket);
		return "emerg/callcenter/IncidentForm1";
	}

	@RequestMapping(value ="/createLocationTraitement",method = { RequestMethod.POST})
	public String create(Model model, @ModelAttribute("location") IncidentLocalization location) {
		System.out.println(location.getIncidentAddress());
		model.addAttribute("location",new IncidentLocalizationDAO().create(location));
		ticket.setLocation(location);
		ticket.setIdLocation(location.getId());
		model.addAttribute("caller",caller);
		LOGGER.info("EASYES Form display : Go to create link contact");
		return "emerg/callcenter/IncidentForm2";
	}

	@RequestMapping(value ="/createIncidentContact",method = { RequestMethod.POST})
	public String create(Model model, @ModelAttribute("interventionTicket") EmergencyIncidentTicket ticket, @ModelAttribute("caller") Caller caller) {
		model.addAttribute("caller",new CallerDAO().create(caller));
		System.out.println("id location dans ticket :"+ticket.getLocation().getId());
		ticket.setCaller(caller);
		ticket.setIdCaller(caller.getId());
		//state 1
		IncidentState state = new IncidentState();
		state = new EmergencyIncidentStateDAO().getById(1);
		ticket.setState(state);

		//loading objects to page
		model.addAttribute("interventionTicket", ticket);
		//		load set of priorities from database
		List<IncidentPriority> priorities = new ArrayList<IncidentPriority>();
		priorities = new EmergencyIncidentPriorityDAO().getAll();
		System.out.println(priorities.get(0).getId());
		System.out.println(priorities.get(0).getLabel());
		model.addAttribute("priorities",priorities);

		LOGGER.info("EASYES Form display : Go to create incident");
		return "emerg/callcenter/IncidentForm3";
	}

	@RequestMapping(value ="/createIncidentTicket",method = { RequestMethod.POST})
	public String create(Model model, @ModelAttribute("interventionTicket") EmergencyIncidentTicket ticket,
			final Errors errors,final SessionStatus status) {
		System.out.println("ticket state: "+ticket.getState().getLabel());
		System.out.println("ticket caller: "+ticket.getIdCaller());
		System.out.println("NbPatients: "+ticket.getInjPatientNumber());
		System.out.println("Allongement: "+ticket.getNbStretcher());
		System.out.println("Remarks: "+ticket.getRemarks());
		System.out.println("Diagnostics: "+ticket.getDiagnostics());
		System.out.println("Location: "+ticket.getLocation().getId());
		ticket.setOpenedDate(new Timestamp(System.currentTimeMillis()));
		System.out.println("OpenDated: "+ticket.getOpenedDate().toLocaleString());

		//loading objects to page
		model.addAttribute("interventionTicket",new EmergencyTicketDAO().create(ticket));
		status.setComplete();
		LOGGER.info("EASYES Form display : Go to create incident");
		return "emerg/callcenter/CallTreatment";
	}
	@RequestMapping(value ="/cancel")
	public String processCancel(Model model) {
		return "canceledView";
	}

	@RequestMapping(value ="/chooseVehicules",method = { RequestMethod.POST})
	public String choose(Model model, @ModelAttribute("interventionTicket") EmergencyIncidentTicket ticket) {
		List<InterventionVehicule> vehicules = new ArrayList<InterventionVehicule>();
		Boolean altern = false;
		int y= ticket.getNbStretcher();
		for(int i=0;i<=ticket.getInjPatientNumber();i++){

			InterventionVehicule vehicule = new InterventionVehicule();
			vehicule.setId(i);
			vehicule.setCategory("Priority1");
			vehicule.setLatitude("0.25451");
			vehicule.setLongitude("0.25451");
			if(y!=0){
				altern=false;
				vehicule.setStretcher(altern);
				vehicule.setNbPlaces(1);
				y--;
			}else{
				altern=false;
				vehicule.setStretcher(altern);
				vehicule.setNbPlaces(2);
			}
			vehicules.add(vehicule);
		}

		//loading objects to page
		model.addAttribute("interventionTicket",new EmergencyTicketDAO().create(ticket));
		model.addAttribute("vehicules",vehicules);

		LOGGER.info("EASYES Form display : Go to create incident");
		return "emerg/callcenter/IncidentForm3";
	}


}
