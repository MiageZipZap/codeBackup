package fr.esiag.isies.pds.controller.referential.Staff.Health;

import fr.esiag.isies.pds.dao.referential.staff.StaffDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.esiag.isies.pds.model.referential.staff.Staff;


/**
 * Get the http request, do actions and return a view
 * @author PFR & JLA
 *
 */
@Controller
@RequestMapping("ref/staff")
public class StaffController {
	private static final Logger LOGGER = LoggerFactory.getLogger(StaffController.class);
	
	
	private StaffDao StaffDao;
	
	/**
	 * 
	 * @param model
	 * @return form to create a Staff
	 */
	@RequestMapping("/form")
	public String getForm(Model model){
		model.addAttribute(new Staff());
		LOGGER.info("EASYES Form display :  creation ");
		return "staff/create";
	}
	
	/**
	 * 
	 * @param Staff
	 * @param model
	 * @return a confirmation of Staff creation
	 */
	@RequestMapping(value="/create",method=RequestMethod.POST)
	public String create(@ModelAttribute Staff Staff,Model model){
	//	Staff.setUpdateUser(SecurityContextHolder.getContext().getAuthentication().getName());
			StaffDao.create(Staff);
			model.addAttribute("Staff",Staff);
			LOGGER.info("EASYES Staff creation OK");
			return "staff/display";		
	}
	
}
