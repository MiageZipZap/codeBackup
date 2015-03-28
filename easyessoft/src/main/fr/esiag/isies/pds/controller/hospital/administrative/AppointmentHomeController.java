package fr.esiag.isies.pds.controller.hospital.administrative;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.esiag.isies.pds.controller.referential.infrastructure.EmergencyDeptController;
import fr.esiag.isies.pds.dao.hospital.medical.BiologicalActDao;
import fr.esiag.isies.pds.dao.hospital.medical.CcamActDao;
import fr.esiag.isies.pds.dao.hospital.medical.EligibleActDao;
import fr.esiag.isies.pds.dao.hospital.medical.SubActDao;
import fr.esiag.isies.pds.dao.referential.infrastructure.EquipmentDao;
import fr.esiag.isies.pds.dao.referential.infrastructure.InfrastructureDao;
import fr.esiag.isies.pds.dao.referential.infrastructure.MedicineDao;
import fr.esiag.isies.pds.dao.referential.organization.OrganizationDao;
import fr.esiag.isies.pds.model.hospital.medical.BiologicalAct;
import fr.esiag.isies.pds.model.hospital.medical.CcamAct;
import fr.esiag.isies.pds.model.hospital.medical.EligibleAct;
import fr.esiag.isies.pds.model.hospital.medical.SubAct;

/**
 * Get the http request which concern Appointment views
 * 
 * @author Glawdys
 *
 */
@Controller
@RequestMapping("admin/appointment")

public class AppointmentHomeController {
	public EligibleActDao elDao = new EligibleActDao();
	
	
		/**
		 * Logger
		 */
		private static final Logger LOGGER = LoggerFactory
				.getLogger(AppointmentHomeController.class);

		
		/**
		 * 
		 * @param model
		 * @return appointment home page
		 */
		@RequestMapping("appointmentHome")
		public String getHomePage(Model model) {
			LOGGER.info("EASYES Form display : Appointment Home Page");
			
			
			
			return "admin/appointmentHomePage";
		}

		
		
		
}
