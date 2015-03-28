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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.esiag.isies.pds.businessRules.hospital.administrative.AppointmentBusinessRules;
import fr.esiag.isies.pds.dao.hospital.administrative.AppointmentDao;
import fr.esiag.isies.pds.dao.hospital.administrative.AppointmentTypeDao;
import fr.esiag.isies.pds.dao.hospital.administrative.AppointmentTypeSpecialityDao;
import fr.esiag.isies.pds.dao.hospital.medical.CcamActDao;
import fr.esiag.isies.pds.dao.hospital.medical.EligibleActDao;
import fr.esiag.isies.pds.dao.hospital.medical.SubActDao;
import fr.esiag.isies.pds.dao.referential.infrastructure.InfrastructureDao;
import fr.esiag.isies.pds.dao.referential.organization.OrganizationDao;
import fr.esiag.isies.pds.dao.referential.organization.ServiceDao;
import fr.esiag.isies.pds.dao.referential.person.patient.PatientDao;
import fr.esiag.isies.pds.model.hospital.administrative.Appointment;
import fr.esiag.isies.pds.model.hospital.administrative.AppointmentType;
import fr.esiag.isies.pds.model.hospital.medical.BiologicalAct;
import fr.esiag.isies.pds.model.hospital.medical.CcamAct;
import fr.esiag.isies.pds.model.hospital.medical.SubAct;
import fr.esiag.isies.pds.model.referential.infrastructure.Infrastructure;
import fr.esiag.isies.pds.model.referential.organization.Hospital;
import fr.esiag.isies.pds.model.referential.person.patient.Patient;

/**
 * Get the http request which concern Appoint, do actions and return a view
 * 
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
	private AppointmentDao appointmentDao;
	/**
	 * Dao AppointmentTypeDao which get list of type appointment
	 */
	private AppointmentTypeDao appointmentTypeDao;

	private PatientDao patientDao;

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
	List<Date> lstDate = new ArrayList<Date>();
	List<String> lstHour = new ArrayList<String>();
	List<String> lstDoctor = new ArrayList<String>();

	public AppointmentController() {
		appointmentDao = new AppointmentDao();
		appointmentTypeDao = new AppointmentTypeDao();
		appointmentTSDao = new AppointmentTypeSpecialityDao();
		patientDao = new PatientDao();
		getListDoctor();
		getHour();
	}

	// *******Mock random hour
	public List<String> getHour() {

		lstHour.add("8h00-8h20");
		lstHour.add("8h20-8h40");
		lstHour.add("8h40-9h20");
		lstHour.add("9h20-9h40");
		lstHour.add("10h00-10h20");
		lstHour.add("13h00-13h20");
		lstHour.add("17h00-17h40");
		return lstHour;
	}

	// *** MOCK DOCTOR
	public List<String> getListDoctor() {

		lstDoctor.add("Glawdys Kangah");
		lstDoctor.add("John Doe");
		lstDoctor.add("Savannah Dawson");
		lstDoctor.add("Professeur Danny Gilles");
		lstDoctor.add("Gilles Dermer");
		lstDoctor.add("Zirem Ozeh");
		lstDoctor.add("Olivier Durand");
		lstDoctor.add("Francis Dupont");

		return lstDoctor;
	}

	// ****************END MOCK*************************
	/**
	 * Create Form
	 * 
	 * @param model
	 * @return form to create an appointment
	 */
	@RequestMapping("createForm")
	/*public String getCreateForm(Model model) {
		//return searchPatient(model);
	}*/

	/*public String searchPatient(Model model) {
		//List<Patient> tablePatient = patientDao.getAllByIdHospital(1);
		model.addAttribute("tablePatient", tablePatient);
		System.out.println(tablePatient.get(1).getFirstName());
		LOGGER.info("EASYES Form display : patient search ");
		return "admin/patientTable";
	}*/

	/*@RequestMapping("createFormAppoint/{idPatient}")
	public String getCreateFormWithPatient(
			@PathVariable("idPatient") int idPatient, Model model) {
		model.addAttribute("idPatient", idPatient);
		return getForm(model);
	}*/

	/**
	 * 
	 * @param model
	 * @return
	 */
	private String getForm(Model model) {
		// model.addAttribute("lstHospital", organizationDao.getById(1));
		model.addAttribute(new Appointment());
		model.addAttribute("lstHour", lstHour);
		model.addAttribute("lstDoctor", lstDoctor);
		model.addAttribute("lstReason", appointmentTypeDao.getAll());

		/*
		 * model.addAttribute("lstReasonSpeciality",
		 * appointmentTSDao.getAllByIdSpeciality(2));
		 */

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
	public String create(@ModelAttribute Appointment appointment, Model model) {
		System.out.println("ok create");
		String key = appointment.getKeyword();
		List<String> acts = getActs(key);

		appointment.setUpdateUser(SecurityContextHolder.getContext()
				.getAuthentication().getName());

		if (new AppointmentBusinessRules().verify(appointment)) {
			Appointment appoint = appointmentDao.create(appointment);
			model.addAttribute("acts", acts);
			model.addAttribute("appointment", appoint);
			LOGGER.info("EASYES Appointment creation OK");
			return "admin/createAppointmentConfirm";
		}
		model.addAttribute("appointment", appointment);
		model.addAttribute("lstHour", lstHour);
		model.addAttribute("lstDoctor", lstDoctor);
		model.addAttribute("lstReason", appointmentTypeDao.getAll());
		/*
		 * model.addAttribute("lstReasonSpeciality",
		 * appointmentTSDao.getAllByIdSpeciality(2));
		 */
		LOGGER.info("EASYES Form display : Appointment creation Error");
		return "admin/appointment/createAppointment";
	}

	/**
	 * Method to retrieve all the act 
	 * @param key
	 * @return
	 */
	public List<String> getActs(String key) {

		CcamActDao princip = new CcamActDao();
		List<CcamAct> exemple = princip.getActFromModel(key);
		System.out.println(exemple.get(1).getNameAct());

		EligibleActDao elaD = new EligibleActDao();
		elaD.getById(exemple.get(1).getId());
		List<String> act = new ArrayList<String>();

		SubActDao sabD = new SubActDao();
		List<SubAct> lstSub = sabD.getAll();
		for (int i = 0; i < lstSub.size(); i++) {

			String labelCcam = lstSub.get(i).getSubIdCcam().getNameAct();
			String labelNabm = lstSub.get(i).getSubIdNabm().getNameAct();
			act.add(labelCcam);
			act.add(labelNabm);
			System.out.println(labelCcam);
			System.out.println(labelNabm);

		}

		return act;
	}

}
