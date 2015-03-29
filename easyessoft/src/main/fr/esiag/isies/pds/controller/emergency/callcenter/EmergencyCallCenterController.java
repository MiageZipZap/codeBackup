package fr.esiag.isies.pds.controller.emergency.callcenter;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import fr.esiag.isies.pds.dao.referential.emergency.callcenter.EmergencyTicketDAO;
import fr.esiag.isies.pds.dao.referential.emergency.callcenter.VehiculeTypeDAO;
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
	 * @return Administration page for Incident Management
	 */
	@RequestMapping("CallHome")
	public String getHomePage(final Model model) {
		// put your initial command
		List<EmergencyIncidentTicket> ticketList = new ArrayList<EmergencyIncidentTicket>();
		ticketList = new EmergencyTicketDAO().getAll();
		ticketList = getOptimalVehicules(ticketList);
		model.addAttribute("ticketList",ticketList);
		LOGGER.info("EASYES Form display : Call Center treatment Page");
		return "emerg/callcenter/CallTreatment";
	}

		@RequestMapping(value ="/getNbPending/{id}",method=RequestMethod.GET,produces = "application/json")
		public @ResponseBody String getNbPendingIntervention(@PathVariable("id") int id){
			int nb = new EmergencyTicketDAO().getCount("state.id",id);
			System.out.println(nb);
			return Integer.toString(nb);
		}

	public List<EmergencyIncidentTicket> getOptimalVehicules(List<EmergencyIncidentTicket> tickets){
		List<InterventionVehicule> vehicules = new ArrayList<InterventionVehicule>();
		for(EmergencyIncidentTicket ticket:tickets){
			int y= ticket.getNbStretcher();
			for(int i=0;i<=ticket.getInjPatientNumber();i++){

				InterventionVehicule vehicule = new InterventionVehicule();
				vehicule.setId((int)Math.round(Math.random()*100));
				vehicule.setCategory(new VehiculeTypeDAO().getById(1));
				vehicule.setLatitude(new Float(0.25451));
				vehicule.setLongitude(new Float(0.25451));
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
				vehicule.setCategory(new VehiculeTypeDAO().getById(2));
				vehicule.setLatitude(new Float(0.25451));
				vehicule.setLongitude(new Float(0.25451));
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
