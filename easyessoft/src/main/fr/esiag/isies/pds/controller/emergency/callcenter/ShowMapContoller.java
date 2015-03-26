package fr.esiag.isies.pds.controller.emergency.callcenter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.esiag.isies.pds.model.emergency.callcenter.IncidentLocalization;

/**
 * create and post the map
 * @author OD
 */

@Controller
@RequestMapping("emerg/callcenter/map")

public class ShowMapContoller {
	
	@RequestMapping("MapHome")
	public String getHomePage(final Model model) {
		
		 
		IncidentLocalization start = new IncidentLocalization();
		start.setLatitude(new Float(48.8805820));
		start.setLongitude(new Float(2.3549880));
		
		IncidentLocalization end = new IncidentLocalization();
		end.setLatitude(new Float(48.8924230));
		end.setLongitude(new Float(2.2153310));
		
		IncidentLocalization incident = new IncidentLocalization();
		incident.setLatitude(new Float(48.7592550));
		incident.setLongitude(new Float(2.3025530));
		
		model.addAttribute("start", start);
		model.addAttribute("end", end);
		model.addAttribute("incident", incident);
		
		
		
		// put your initial command
		//model.addAttribute("interventionTicket", ticket);
		//LOGGER.info("EASYES Form display : Call Center treatment Page");
		return "emerg/callcenter/map/CeationCarte";
	}

}
