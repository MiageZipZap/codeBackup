package fr.esiag.isies.pds.controller.emergency.sorting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.esiag.isies.pds.businessRules.emergency.sorting.*;
import fr.esiag.isies.pds.dao.emergency_sort.SortingDao;
import fr.esiag.isies.pds.model.Doctor;
import fr.esiag.isies.pds.model.emergency.sort.Sorting;



@Controller
@RequestMapping("/sorting")

	public class SortingController {
		/**
		 * Logger
		 */
		private static final Logger LOGGER = LoggerFactory
				.getLogger(SortingController.class);

		
		SortingDao sortingDao;
		
		/**
		 * 
		 * @param model
		 * @return sorting page
		 */
		@RequestMapping("/form")
		public String getForm(Model model) {
			LOGGER.info("EASYES Form display : sorting form");
			model.addAttribute("sort", new Sorting());
			return "sorting/createSort";
		}
		@RequestMapping(value="createSort", method = RequestMethod.POST)
		public String createSort(@ModelAttribute("sort")Sorting sort, Model model) {
			sortingDao = new SortingDao();
			model.addAttribute("sort", sort);
			sortingDao.create(sort);
			return "sorting/displaySort";
		}
	
		
			/*@RequestMapping(value="createSort", method = RequestMethod.POST)
		public String createSort(@ModelAttribute("sort")Sorting sort, Model model) {
			
			if (new SortingBusinessRules().verify(sort)){
			sortingDao = new SortingDao();
			model.addAttribute("sort", sort); 
			sortingDao.create(sort);
			return "sorting/displaySort"; 
		} return null;
			}*/

		
		
		
	}
	
	
	
	
	
	


