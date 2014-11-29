package fr.esiag.isies.pds.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Get the http request, do actions and return a view
 * @author PFR & JLA
 *
 */
@Controller
@RequestMapping("/geoloc")
public class GeolocController {
	private static final Logger LOGGER = LoggerFactory.getLogger(DoctorController.class);
	
	/**
	 * 
	 * @param model
	 * @return the coordinates 
	 */
	@RequestMapping("/get")
	public String getGeoloc(Model model){
		
		LOGGER.info("EASYES : Get Geolocalisation OK");
		return "geoloc/geoloc";
	}
	

}
