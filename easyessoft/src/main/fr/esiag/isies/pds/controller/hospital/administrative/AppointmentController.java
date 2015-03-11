package fr.esiag.isies.pds.controller.hospital.administrative;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.esiag.isies.pds.businessRules.hospital.administrative.AppointmentBusinessRules;
import fr.esiag.isies.pds.businessRules.refential.infrastructure.InfrastructureBusinessRules;
import fr.esiag.isies.pds.controller.referential.infrastructure.InfrastructureController;
import fr.esiag.isies.pds.dao.hospital.administrative.AppointmentDao;
import fr.esiag.isies.pds.dao.hospital.administrative.AppointmentTypeDao;
import fr.esiag.isies.pds.dao.referential.organization.OrganizationDao;
import fr.esiag.isies.pds.model.hospital.administrative.Appointment;
import fr.esiag.isies.pds.model.hospital.administrative.AppointmentType;
import fr.esiag.isies.pds.model.referential.infrastructure.Infrastructure;
import fr.esiag.isies.pds.model.referential.organization.Hospital;


/**
 * Get the http request which concern Appoint, do actions and return a
 * view
 * @author Glawdys
 *
 */

@Controller
@RequestMapping("admin/appointment")
public class AppointmentController {
	
	/**
	 * Logger
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(AppointmentController.class);

	/**
	 * Dao AppointmentDao which get list of apppointments
	 */
	private AppointmentDao appointmentDao ;
	/**
	 * Dao AppointmentTypeDao which get list of type appointment
	 */
	private AppointmentTypeDao appointmentTypeDao;
	
	/**
	 * Appointment type
	 */
	private AppointmentType appointmentType;
	/**
	 * Dao OrganisationDao which get list of hospital
	 */
	OrganizationDao organizationDao = new OrganizationDao();
	
	/**
	 * Construct this class and initialize category item
	 */
	List <Date> lstDate = new ArrayList <Date>();
	List <String> lstHour = new ArrayList <String>();
	List <String> lstDoctor = new ArrayList <String>();
	
	
	public AppointmentController() {
		appointmentDao= new AppointmentDao();
		appointmentTypeDao = new AppointmentTypeDao();
		getListDoctor();
		getListDate();
		getListHeure();
	 	}
	//*************** BEGINING MOCK*****************//
		//Liste de date	
		@SuppressWarnings("deprecation")
		public static Date generateRandomDate() {  
		     int year, month, day=0;  		     
		     year = 2015;  
		         month = (int)(Math.random()*4+1);  
		     switch (month) {   
		     case 3:  
		     case 5:  	     
		         day = (int)(Math.random()*31+1);  
		         break;  
		     case 4:  
		     case 6:  	     
		         day = (int)(Math.random()*30+1);  
		         break;       
		     }  	  
		         return new Date(month,day,year);  
		  }  
		//*******Mock random hour
		public String generateRandomHour(){
			int limit = 19;
			Random randomHour = new Random();
			return randomHour.nextInt(limit)+"h";
		}
		
		//*** MOCK DOCTOR
	public List <String> getListDoctor (){
		
	     lstDoctor.add("Dr Glawdys Kangah");
	     lstDoctor.add("Dr John Doe");
	     lstDoctor.add("Dr Savannah Dawson");
	     lstDoctor.add("Professeur Danny Gilles");
	     lstDoctor.add("Dr Gilles Dermer");
	     lstDoctor.add("Dr Zirem Ozeh");
	     lstDoctor.add("Dr Olivier Durand");
	     lstDoctor.add("Dr Francis Dupont");
	     
	     return lstDoctor;
	   }
	//*** MOCK Date
	public List <Date> getListDate (){
		int size = 15;	
		for (int i=1; i<=size; i++) {  
	         lstDate.add(generateRandomDate());
		}
		Iterator it=lstDate.iterator();
		Date thisDate;  
	     while (it.hasNext()) {
	    	 thisDate = (Date)(it.next());
	    	 System.out.println(thisDate);
	     }
	     while(it.hasNext()) {  
	            Object element = (Date)(it.next());  
	            Set uniqueEntries = new HashSet();  
	                 if (!uniqueEntries.add(element)){
	                	 it.remove();
	                 }
	     }
	     return lstDate;
	   }
	
	
	//*** MOCK HOUR*****
	public List <String> getListHeure(){
			     
	     int sizeHour = 5;	
			for (int j=1; j<=sizeHour; j++) {  
		         lstHour.add(generateRandomHour());
			}
			Iterator ith=lstHour.iterator();
			 String thisHour;  
		     while (ith.hasNext()) {
		    	 thisHour = (String)(ith.next());
		    	 //to remove
		    	 System.out.println(thisHour);
		     }
		     while(ith.hasNext()) {  
		            Object elementHour = (Date)(ith.next());  
		            Set uniqueEntriesHour = new HashSet();  
		                 if (!uniqueEntriesHour.add(elementHour)){
		                	 ith.remove();
		                 }
		     }
			return lstHour;
	}
	//****************END MOCK*************************
	/**
	 * Create Form 
	 * @param model
	 * @return form to create an appointment
	 */
	@RequestMapping("createForm")
	public String getCreateForm(Model model) {
		return getForm(model);
	}
	/**
	 * 
	 * @param model
	 * @return
	 */
	private String getForm(Model model) {
		model.addAttribute("lstHospital", organizationDao.<Hospital>getAllByType(Hospital.class));
		model.addAttribute(new Appointment());
		model.addAttribute("lstDate",lstDate);
		model.addAttribute("lstHour",lstHour);
		model.addAttribute("lstDoctor",lstDoctor);
		model.addAttribute("lstOfType",
				appointmentDao.getAll());
		LOGGER.info("EASYES Form display : appointment creation ");
		return "admin/appointment/createAppointment";
	}
	
	/**
	 * 
	 * @param appointment
	 * @param model
	 * @return a confirmation of appointment creation
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(@ModelAttribute Appointment appointment,
			Model model) {
		appointment.setUpdateUser(SecurityContextHolder.getContext()
				.getAuthentication().getName());

		if (new AppointmentBusinessRules().verify(appointment)) {
			Appointment appoint = appointmentDao.create(appointment);
			model.addAttribute("appointment", appoint);
			LOGGER.info("EASYES Appointment creation OK");
			return "admin/appointment/createAppointmentConfirm";
		}
		model.addAttribute("appointment", appointment);
		model.addAttribute("lstDate",lstDate);
		model.addAttribute("lstHour",lstHour);
		model.addAttribute("lstDoctor",lstDoctor);
		model.addAttribute("lstOfType",
				appointmentDao.getAll());
		LOGGER.info("EASYES Form display : Appointment creation Error");
		return "admin/appointment/createAppointment";
	}
}

