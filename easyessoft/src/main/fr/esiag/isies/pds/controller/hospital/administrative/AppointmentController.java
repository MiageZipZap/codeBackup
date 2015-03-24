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
import fr.esiag.isies.pds.dao.hospital.administrative.AppointmentDao;
import fr.esiag.isies.pds.dao.hospital.administrative.AppointmentTypeDao;
import fr.esiag.isies.pds.dao.hospital.administrative.AppointmentTypeSpecialityDao;
import fr.esiag.isies.pds.dao.referential.infrastructure.InfrastructureDao;
import fr.esiag.isies.pds.dao.referential.organization.OrganizationDao;
import fr.esiag.isies.pds.dao.referential.organization.ServiceDao;
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
	
	private InfrastructureDao infra = new InfrastructureDao();

	private ServiceDao serviceDao = new ServiceDao();
	/**
	 * appointment type speciality dao
	 */
	
	private AppointmentTypeSpecialityDao appointmentTSDao;
	
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
		appointmentTSDao = new AppointmentTypeSpecialityDao();
		getListDoctor();
		getListHeure();
	 	}
	
		//*******Mock random hour
		public String generateRandomHour(){
			int max =19;
			int min = 9;
			int limit = max-min +1;
			Random randomHour = new Random();
			int i = randomHour.nextInt()%limit;
			int rd = min+ i;
			return rd +"h";
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
		     /*while(ith.hasNext()) {  
		            Object elementHour = (Date)(ith.next());  
		            Set uniqueEntriesHour = new HashSet();  
		                 if (!uniqueEntriesHour.add(elementHour)){
		                	 ith.remove();
		                 }
		     }*/
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
		model.addAttribute("lstService", serviceDao.getServicesByOrga(33));
		model.addAttribute(new Appointment());
		model.addAttribute("lstHour",lstHour);
		model.addAttribute("lstDoctor",lstDoctor);
		model.addAttribute("lstReason",
				appointmentTypeDao.getAll());
		

		/*model.addAttribute("lstReasonSpeciality",
				appointmentTSDao.getAllByIdSpeciality(2));*/
	

		LOGGER.info("EASYES Form display : appointment creation ");
		return "admin/createAppointment";
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
		model.addAttribute("lstHour",lstHour);
		model.addAttribute("lstDoctor",lstDoctor);
		model.addAttribute("lstReason",
				appointmentTypeDao.getAll());
		/*model.addAttribute("lstReasonSpeciality",
				appointmentTSDao.getAllByIdSpeciality(2));*/
		LOGGER.info("EASYES Form display : Appointment creation Error");
		return "admin/appointment/createAppointment";
	}
}

