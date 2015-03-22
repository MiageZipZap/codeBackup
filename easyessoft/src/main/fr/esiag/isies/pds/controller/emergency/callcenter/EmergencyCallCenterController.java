package fr.esiag.isies.pds.controller.emergency.callcenter;


import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import fr.esiag.isies.pds.dao.referential.emergency.callcenter.EmergencyTicketDAO;
import fr.esiag.isies.pds.model.emergency.callcenter.EmergencyIncidentTicket;
import fr.esiag.isies.pds.model.emergency.callcenter.InterventionVehicule;

/**
 * Get the http request which concern Incident pages
 * @author SKO
 *
 */
@Controller
@RequestMapping("emerg/callcenter")
@SessionAttributes("interventionTicket")
public class EmergencyCallCenterController{
	/**
	 * Logger
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(EmergencyCallCenterController.class);

	public EmergencyCallCenterController() {
	}

	/**
	 * 
	 * @param model
	 * @return Administration page for Organization referential
	 */
	@RequestMapping("CallHome")
	public String getHomePage(final Model model) {
		// put your initial command
		List<EmergencyIncidentTicket> ticketList = new ArrayList<EmergencyIncidentTicket>();
		ticketList = new EmergencyTicketDAO().getAll();
		ticketList = getOptimalVehicule(ticketList);
		model.addAttribute("ticketList",ticketList);
		LOGGER.info("EASYES Form display : Call Center treatment Page");
		return "emerg/callcenter/CallTreatment";
	}

	//	@RequestMapping(value ="/patients/jsonVehicule",method=RequestMethod.GET,produces = "application/json")
	//	public @ResponseBody List<InterventionVehicule> getOptimalVehiculesList(){
	//		List<InterventionVehicule> vehicules=new ArrayList<InterventionVehicule>();
	//		for(int i=0;i<=3;i++){
	//			InterventionVehicule vehicule = new InterventionVehicule();
	//			vehicule.setId(1);
	//			vehicule.setCategory("Priority1");
	//			vehicule.setLatitude("0.25451");
	//			vehicule.setLongitude("0.25451");
	//			vehicule.setNbPlaces(2);
	//			vehicules.add(vehicule);
	//		}
	//		return vehicules;
	//	}



	public List<EmergencyIncidentTicket> getOptimalVehicule(List<EmergencyIncidentTicket> tickets){
		List<InterventionVehicule> vehicules = new ArrayList<InterventionVehicule>();
		for(EmergencyIncidentTicket ticket:tickets){
			int y= ticket.getNbStretcher();
			for(int i=0;i<=ticket.getInjPatientNumber();i++){

				InterventionVehicule vehicule = new InterventionVehicule();
				vehicule.setId(i);
				vehicule.setCategory("Priority1");
				vehicule.setLatitude("0.25451");
				vehicule.setLongitude("0.25451");
				if(y!=0){
					vehicule.setStretcher(true);
					vehicule.setNbPlaces(1);
					y--;
				}else{
					vehicule.setStretcher(false);
					vehicule.setNbPlaces(2);
				}
				vehicules.add(vehicule);
			}
		}
		return tickets;
	}
}
