package fr.esiag.isies.pds.controller.emergency.callcenter;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
		ticketList = getOptimalVehicules(ticketList);
		model.addAttribute("ticketList",ticketList);
		for(EmergencyIncidentTicket ticket:ticketList){
			System.out.println("Start -----------------");
			System.out.println(ticket.getId());
			System.out.println(ticket.getState().getId());
			System.out.println(ticket.getState().getLabel());
			System.out.println(ticket.getIdLocation());
			System.out.println(ticket.getLocation().getIncidentAddress());
			System.out.println(ticket.getVehicule().getId());
			System.out.println(ticket.getVehicule().getCategory());
			System.out.println(ticket.getPriority().getLabel());
			System.out.println(ticket.getOpenedDate());
			System.out.println("End -----------------");
		}
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



	public List<EmergencyIncidentTicket> getOptimalVehicules(List<EmergencyIncidentTicket> tickets){
		List<InterventionVehicule> vehicules = new ArrayList<InterventionVehicule>();
		for(EmergencyIncidentTicket ticket:tickets){
			int y= ticket.getNbStretcher();
			for(int i=0;i<=ticket.getInjPatientNumber();i++){

				InterventionVehicule vehicule = new InterventionVehicule();
				vehicule.setId((int)Math.round(Math.random()*100));
				vehicule.setCategory("TypeVehicule1");
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
				ticket.setVehicule(vehicule);
				vehicules.add(vehicule);
			}
		}
		return tickets;
	}
	
	public List<EmergencyIncidentTicket> getOptimalVehicule(List<EmergencyIncidentTicket> tickets){
		for(EmergencyIncidentTicket ticket:tickets){
			int y= ticket.getNbStretcher();
//			for(int i=0;i<=ticket.getInjPatientNumber();i++){ should be list of vehicule
				InterventionVehicule vehicule = new InterventionVehicule();
				vehicule.setId((int)Math.round(Math.random()*100));
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
				ticket.setVehicule(vehicule);
			}
//		}
		return tickets;
	}
	
	/**
	 * Returns a pseudo-random number between min and max, inclusive.
	 * The difference between min and max can be at most
	 * <code>Integer.MAX_VALUE - 1</code>.
	 *
	 * @param min Minimum value
	 * @param max Maximum value.  Must be greater than min.
	 * @return Integer between min and max, inclusive.
	 * @see java.util.Random#nextInt(int)
	 */
	public static int randInt(int min, int max) {

	    // NOTE: Usually this should be a field rather than a method
	    // variable so that it is not re-seeded every call.
	    Random rand = new Random();

	    // nextInt is normally exclusive of the top value,
	    // so add 1 to make it inclusive
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
}
