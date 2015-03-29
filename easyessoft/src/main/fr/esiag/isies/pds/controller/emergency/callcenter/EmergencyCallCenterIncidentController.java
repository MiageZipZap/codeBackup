package fr.esiag.isies.pds.controller.emergency.callcenter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
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
import fr.esiag.isies.pds.dao.referential.emergency.callcenter.EmergencyIncidentInterventionDao;
import fr.esiag.isies.pds.dao.referential.emergency.callcenter.EmergencyIncidentPriorityDAO;
import fr.esiag.isies.pds.dao.referential.emergency.callcenter.EmergencyIncidentStateDAO;
import fr.esiag.isies.pds.dao.referential.emergency.callcenter.EmergencyTicketDAO;
import fr.esiag.isies.pds.dao.referential.emergency.callcenter.IncidentLocalizationDAO;
import fr.esiag.isies.pds.dao.referential.emergency.callcenter.VehiculeTypeDAO;
import fr.esiag.isies.pds.model.emergency.callcenter.Caller;
import fr.esiag.isies.pds.model.emergency.callcenter.EmergencyIncidentIntervention;
import fr.esiag.isies.pds.model.emergency.callcenter.EmergencyIncidentTicket;
import fr.esiag.isies.pds.model.emergency.callcenter.IncidentLocalization;
import fr.esiag.isies.pds.model.emergency.callcenter.IncidentPriority;
import fr.esiag.isies.pds.model.emergency.callcenter.IncidentState;
import fr.esiag.isies.pds.model.emergency.callcenter.InterventionVehicule;
import fr.esiag.isies.pds.model.emergency.callcenter.VehiculeType;


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
		model.addAttribute("priorities",priorities);

		LOGGER.info("EASYES Form display : Go to create incident");
		return "emerg/callcenter/IncidentForm3";
	}

	@RequestMapping(value ="/createIncidentTicket",method = { RequestMethod.POST})
	public String create(Model model, @ModelAttribute("interventionTicket") EmergencyIncidentTicket ticket) {
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
		model.addAttribute("vehicules", chooseVehicules(ticket));
		model.addAttribute("InterventionVehicule", new InterventionVehicule());
		LOGGER.info("EASYES Form display : Go to create incident");
		//return "emerg/callcenter/CallHome";
		return "emerg/callcenter/SuccessIncidentTicket";
	}

	@RequestMapping(value ="/VehiculeChoiceTraitement",method = { RequestMethod.POST})
	public String create(Model model, @ModelAttribute("interventionVehicule") InterventionVehicule interventionVehicule,
			@ModelAttribute("interventionTicket") EmergencyIncidentTicket ticket
			,final Errors errors,final SessionStatus status) {
		EmergencyIncidentIntervention intervention = new EmergencyIncidentIntervention();
		intervention.setCreateDate(new Date(System.currentTimeMillis()));
		intervention.setIncidentVehicule(interventionVehicule);
		intervention = new EmergencyIncidentInterventionDao().create(intervention);
		System.out.println(intervention.getId());
		System.out.println(interventionVehicule.getId());
		System.out.println(intervention.getIncidentVehicule().getId());
		ticket.setVehicule(interventionVehicule);
		status.setComplete();
		return "emerg/callcenter/CallHome";

	}

	@RequestMapping(value ="/cancel")
	public String processCancel(Model model) {
		return "canceledView";
	}


	/**
	 * Mock of Vehicules
	 * @param ticket
	 * @return
	 */
	public List<InterventionVehicule> chooseVehicules(EmergencyIncidentTicket ticket) {
		//Create categories of vehicules
		//				VehiculeTypeDAO vehiculeTypeDAO = new VehiculeTypeDAO();
		//				VehiculeType cat1 = new VehiculeType();
		//				cat1.setCode("CAT1");
		//				cat1.setLabel("VSAB - lol");
		//				
		//				vehiculeTypeDAO.create(cat1);
		//				VehiculeType cat2 = new VehiculeType();
		//				cat2.setCode("CAT2");
		//				cat2.setLabel("Ambulance priv�e");
		//				vehiculeTypeDAO.create(cat2);
		//				
		//				VehiculeType cat3 = new VehiculeType();
		//				cat3.setCode("CAT3");
		//				cat3.setLabel("SMUR");
		//				vehiculeTypeDAO.create(cat3);

		int nbCat =3;

		List<InterventionVehicule> vehicules = new ArrayList<InterventionVehicule>();
		Boolean altern = false;
		int y= ticket.getNbStretcher();
		for(int i=0;i<=ticket.getInjPatientNumber();i++){
			InterventionVehicule vehicule = new InterventionVehicule();
			vehicule.setId(i);
			if(nbCat!=0){
				vehicule.setCategory(new VehiculeTypeDAO().getById(nbCat));
				nbCat--;
			}else{
				vehicule.setCategory(new VehiculeTypeDAO().getById(1));
			}

			vehicule.setLatitude(new Float(0.25451));
			vehicule.setLongitude(new Float(0.25451));
			if(y!=0){
				altern=true;
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
		LOGGER.info("EASYES Form display : return list vehicules");
		return vehicules;
	}


}
