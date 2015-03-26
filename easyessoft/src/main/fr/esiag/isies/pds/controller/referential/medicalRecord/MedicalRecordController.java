package fr.esiag.isies.pds.controller.referential.medicalRecord;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.esiag.isies.pds.controller.referential.Person.PersonMemberController;
import fr.esiag.isies.pds.dao.referential.medicalRecord.MedicalRecordDao;
import fr.esiag.isies.pds.dao.referential.person.PersonDao;
import fr.esiag.isies.pds.dao.referential.person.patient.PatientDao;
import fr.esiag.isies.pds.model.referential.medicalRecord.MedicalRecord;
import fr.esiag.isies.pds.model.referential.person.patient.Patient;

@SessionAttributes( value="medicalRecord", types={MedicalRecord.class} )
@Controller
@RequestMapping("ref/medicalRecord")
public class MedicalRecordController {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(PersonMemberController.class);

	// Instantiate the DAO
	private MedicalRecordDao medicalRecordDao;
	private PersonDao personDao;
	private PatientDao patientDao;

	public MedicalRecordController() {
		this.medicalRecordDao = new MedicalRecordDao();
		this.personDao = new PersonDao();
		this.patientDao = new PatientDao();
	}

	@RequestMapping(value = "{patientID}", method = RequestMethod.GET)
	public String findMRByPatientID(@PathVariable int patientID, Model model) {
		MedicalRecord mdr = medicalRecordDao.getById(patientID);
		Patient patient = patientDao.getById(patientID);
		if (mdr != null && patient != null) {
			patient.setMedicalRecord(mdr);
			mdr.setPatient(patient);
			medicalRecordDao.update(mdr);
			patientDao.update(patient);
			model.addAttribute("medicalRecord", mdr);
			model.addAttribute("patient", patient);
			return "ref/healthData/medicalRecordFoundDisplay";
		}
		return "ref/healthData/error400";
	}

	/**
	 * @param model
	 * @return form to create a Medical record
	 */
	@RequestMapping(value = "/medicalRecordCreateForm", method = {
			RequestMethod.POST, RequestMethod.GET })
	public String getMedicalRecordForm(@ModelAttribute Patient patient,
			Model model) {
		// Mock search ID of patient
		MedicalRecord mdr = new MedicalRecord();
		mdr.setPatient(patient);
		String[] listTypePatient = new String[] { "Newborn", "Private",
				"Under protection" };
		String[] listStatusPatient = new String[] { "Activate", "Discharge",
				"Pre-register" };
		model.addAttribute("listTypePatient", listTypePatient);
		model.addAttribute("listStatusPatient", listStatusPatient);
		model.addAttribute("medicalRecord", mdr);
		return "ref/healthData/medicalRecordCreate";
		// Create jsp file and package.
	}

	@RequestMapping(value = "/relateToPatient", method = RequestMethod.POST)
	public String relateToPatient(@ModelAttribute("patient") Patient patient,
			final RedirectAttributes redirectAttributes, Model model) {
		Patient patientFound = (Patient) patientDao.getByNIR(patient.getNir());
		if (patientFound != null) {
			redirectAttributes.addFlashAttribute("patient", patientFound);
			return "redirect:medicalRecordCreateForm";
		} else {
			return "ref/person/patient/error400";
		}
	}

	// Search for Patient to add relation with the patient record.
	/**
	 * @param model
	 *            Search for Patient to add relation with the patient record.
	 * @return jsp search by nir
	 */
	@RequestMapping(value = "/searchPatient", method = RequestMethod.GET)
	public String searchPatient(Model model) {
		model.addAttribute("patient", new Patient()); // Patient to find
		return "ref/healthData/searchRelatedPatient";
	}

	/**
	 * @param model
	 * @return form to create a Medical record
	 */
	@RequestMapping(value = "/medicalRecordCreateAction", method = {
			RequestMethod.POST, RequestMethod.GET })
	public String createMedicalRecord(@ModelAttribute MedicalRecord medicalRecord, SessionStatus status, Model model) {
		LOGGER.info("EASYES Create Medical Record");
		medicalRecordDao.create(medicalRecord);
		model.addAttribute("medicalRecord", medicalRecord);
		model.addAttribute("patient", medicalRecord.getPatient());
		LOGGER.info(medicalRecord.getPatient().getFirstName());
		status.setComplete();
		LOGGER.info(medicalRecord.getPatient().getFirstName());
		return "ref/healthData/medicalRecordDisplay";
	}

}
