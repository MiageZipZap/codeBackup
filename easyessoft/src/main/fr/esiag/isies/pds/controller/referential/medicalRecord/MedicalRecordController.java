package fr.esiag.isies.pds.controller.referential.medicalRecord;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.esiag.isies.pds.controller.referential.Person.PersonMemberController;
import fr.esiag.isies.pds.dao.referential.medicalRecord.MedicalRecordDao;
import fr.esiag.isies.pds.dao.referential.person.PersonDao;
import fr.esiag.isies.pds.dao.referential.person.patient.PatientDao;
import fr.esiag.isies.pds.model.referential.medicalRecord.MedicalRecord;
import fr.esiag.isies.pds.model.referential.person.patient.Patient;

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
	
	/**
	 * @param model
	 * @return form to create a Medical record
	 */
	@RequestMapping(value ="/medicalRecordCreateForm",method = { RequestMethod.POST, RequestMethod.GET})
	public String getMedicalRecordForm(Model model) {
		// Mock search ID of patient
		model.addAttribute("medicalRecord", new MedicalRecord());
		return "ref/healthData/medicalRecordCreate";
		//Create jsp file and package.
	}
	
	
	/**
	 * @param model
	 * @return form to create a Medical record
	 */
/*
	@RequestMapping(value = "/getPatientDetails/{idPatient}")
	public String getOrgaDetailsView(@PathVariable("idOrga") int idOrga, Model model) {		
		Organization organization = orgaDao.getById(idOrga);
		Set<ServiceType> services = new HashSet<ServiceType>(0);
		services = organization.getServicesSet();
		model.addAttribute("organization",organization);
		model.addAttribute("services",services);
		LOGGER.info("EASYES Form display : organization Details");
		return "ref/orga/displayOrganizationDetails";
	}
*/	
	// No existing patient with this ID
	
	/**	
	 * **********************************************						
	 * CONTROLLER MANAGEMENT FOR SERVICE CHOICE		*
	 * **********************************************
	 **/
	
	/*
	
	@RequestMapping(value = "/choosePatient",method = RequestMethod.POST)
	public String chooseAService(@RequestParam("name") String name, @RequestParam("id") Integer id, Model model) {
		List <Patient> listPatientType = p.getAll();
		model.addAttribute("name",name);
		model.addAttribute("id",id);
		service = new Service();
		model.addAttribute("service",service);
		model.addAttribute("listServiceType",listServiceType);
		LOGGER.info("EASYES Form display : service box chooser page");
		return "ref/orga/chooseServiceOrgaForm";
	}
	
	/**
	 * This controller sets the link between define services and created organization
	 * @param organization
	 * @param service
	 * @param model
	 * @return success page if service added
	 */
	
	
	@RequestMapping(value = "/relateToPatient", method = RequestMethod.POST)
	public String relateToPatient(@RequestParam("name") String name,@ModelAttribute("patient") Patient patient, Model model) {
/*		
		for(int idService:patient.getListIdTypeOfServices()){
			servType = serviceTypeDao.getById(idService);
			
			
			LOGGER.info("EASYES Form process : add service to an organization");

			patient.getServices().add(servType);
		}
		servicedao.addServices(service);
		model.addAttribute("services",service.getServices());
		model.addAttribute("name",name);
		LOGGER.info("EASYES Form display : service added success page");
*/		
		return "ref/orga/displaySuccessAddService";
	}
	
	// Search for Patient to add relation with the patient record.
	/**
	 * This controller sets the link between define services and created organization
	 * @param organization
	 * @param service
	 * @param model
	 * @return success page if service added
	 */
	@RequestMapping(value = "/searchPatient", method = RequestMethod.POST)
	public String searchPatient(@RequestParam("name") String name, @ModelAttribute("patient") Patient patient, Model model) {
		// get ID from field = Typing value 
		// get ID from field from list box value
		model.addAttribute("listPatient", patientDao.getAll());
		
		// Add javascript each time we choose one way to find data clear the other field. ?
		
		// IF found return ref/healthData/PatientFound
		
		// Not found return ref/healthData/PatientNotFound... Propose link to go to patient create form to add one.
		
		// 1st temporaly solution get a patient by name
		
		return "ref/healthData/searchRelatedPatient"; // medicalRecordFound JSP
	}
	
	/**
	 * @param model
	 * @return form to create a Medical record
	 */
	@RequestMapping(value ="/medicalRecordCreateAction",method = { RequestMethod.POST, RequestMethod.GET})
	public String createMedicalRecord(@RequestParam("name") String name, @ModelAttribute MedicalRecord medicalRecord, Model model) {
		// Mock search ID of patient=============================
		Patient patient = (Patient) personDao.getById(8); //We only set on ID=1 for start
		// after we will make able to search in the jsp for a patient and create it.
		medicalRecord.setPatient(patient);
		// End Mock=======================================
		// Vérifier valeur : date de naisssance + nom + preno 
		
		LOGGER.info("EASYES Create Medical Record");
		medicalRecordDao.create(medicalRecord);
		model.addAttribute("medicalRecord", medicalRecord);
		return "ref/healthData/medicalRecordDisplay";
		//Create jsp file and package.
	}
	
}
