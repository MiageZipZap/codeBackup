package fr.esiag.isies.pds.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.esiag.isies.pds.businessRules.DoctorBusinessRules;
import fr.esiag.isies.pds.dao.DoctorDao;
import fr.esiag.isies.pds.model.Doctor;


/**
 * Get the http request, do actions and return a view
 * @author PFR & JLA
 *
 */
@Controller
@RequestMapping("/doctor")
public class DoctorController {
	private static final Logger LOGGER = LoggerFactory.getLogger(DoctorController.class);
	
	
	private DoctorDao doctorDao;
	
	/**
	 * 
	 * @param model
	 * @return form to create a doctor
	 */
	@RequestMapping("/form")
	public String getForm(Model model){
		model.addAttribute(new Doctor());
		LOGGER.info("EASYES Form display : Doctor creation ");
		return "doctor/create";
	}
	
	/**
	 * 
	 * @param doctor
	 * @param model
	 * @return a confirmation of doctor creation
	 */
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public String create(@ModelAttribute Doctor doctor,Model model){
		doctor.setUpdateUser(SecurityContextHolder.getContext().getAuthentication().getName());
		if (new DoctorBusinessRules().verify(doctor)) {
			doctorDao.create(doctor);
			model.addAttribute("doctor",doctor);
			LOGGER.info("EASYES Doctor creation OK");
			return "doctor/display";
		}
		return null;
		
	}
	
}
