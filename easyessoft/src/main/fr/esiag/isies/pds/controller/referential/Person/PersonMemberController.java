//package fr.esiag.isies.pds.controller.referential.Person;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import fr.esiag.isies.pds.dao.referential.person.PersonDao;
//import fr.esiag.isies.pds.model.Address;
//import fr.esiag.isies.pds.model.Person;
//import fr.esiag.isies.pds.model.referential.person.patient.Patient;
//import fr.esiag.isies.pds.model.referential.person.staff.StaffMember;
//
///**
// * Get the HTTP request, do actions (Database) and return a view (JSP)
// * @author LAD
// */
//
//@Controller
//@RequestMapping("ref/person")
//public class PersonMemberController {
//	
//	// Instantiate the Logger
//	private static final Logger LOGGER = LoggerFactory.getLogger(PersonMemberController.class);
//	
//	// Instantiate the DAO
//	private PersonDao personDao;
//	
//	public PersonMemberController() {
//		this.personDao = new PersonDao();
//	}
//	
//	/**
//	 * @param model
//	 * @return form to create a Person
//	 */
//	@RequestMapping(value ="/personCreateForm",method = { RequestMethod.POST, RequestMethod.GET})
//	public String getPersonForm(Model model) {
//		String listPersonType[] = new String[]{"patient", "staffMember"};
//		model.addAttribute("listPersonType", listPersonType);
//		model.addAttribute("person", new Person());
//		return "ref/person/personCreate";
//	}
//	
//	public String createPersonType(String typeOfPerson){
//		if(typeOfPerson == "staffMember"){
//			return "ref/person/patientCreateForm";
//		}else{
//			return "ref/person/staffMembercreateForm";
//		}
//	}
//	
//	/**
//	 * @param Person
//	 * @param model
//	 * @return a confirmation of Person creation
//	 */
//	@RequestMapping(value = "/personMember",method = RequestMethod.POST)
//	public String createPerson(@ModelAttribute Person person, Model model){
//		LOGGER.info("EASYES Create a person");
//		return createPersonType(person.getPersonType());	
// 	}
//	
//	/**
//	 * @param model
//	 * @return form to create a Staff
//	 */
//	@RequestMapping(value ="/staffMembercreateForm",method = { RequestMethod.POST, RequestMethod.GET})
//	public String getStaffMemberForm(Model model) {
//
//		// ////////////////////////////////////////////////////////////////////
//		// Mock of Profession Type
///*
//		List<Profession> listProfessionType = new ArrayList<Profession>();
//		String[] professionType_Type = new String[] { "Médical", "Soignant",
//				"Social", "Administratif, logistique et technique" };
//
//		for (int i = 0; i < professionType_Type.length; i++) {
//			Profession profession = new Profession();
//			profession.setId(i + 1);
//			profession.setType(professionType_Type[i]);
//			listProfessionType.add(profession);
//		}
//
//		List<Profession> listProfession = new ArrayList<Profession>();
//		String[] profession_TypeId = new String[] { "1", "1", "1", "1", "2",
//				"2", "2", "2", "3", "3", "3", "3", "4", "4", "4", "4" };
//		String[] profession_Label = new String[] { "Chirurgien", "Médecin",
//				"Pharmacien", "Sage-femme", "Brancardier",
//				"Masseur-kinésithérapeute", "Orthophoniste", "Psychomotricien",
//				"Assistant de service social",
//				"Conseiller conjugal et familial",
//				"Éducateur technique spécialisé", "Psychologue",
//				"Assistant de recherche clinique", "Ambulancier",
//				"Secrétaire médical", "Standardiste" };
//
//		for (int i = 0; i < profession_Label.length; i++) {
//			Profession profession = new Profession();
//			profession.setId(i + 1);
//			profession.setLabel(profession_Label[i]);
//			profession.setType(profession_TypeId[i]);
//			listProfession.add(profession);
//		}
//
//		List<Speciality> listSpeciality = new ArrayList<Speciality>();
//		String[] speciality_profession_TypeId = new String[] { "1", "1", "1",
//				"1", "1", "1", "2", "2", "2", "2" };
//		String[] speciality_profession_Label = new String[] { "Addictologie",
//				"Alcoologie", "Allergologie", "Cardiologie",
//				"Gastro-entérologie et hépatologie", "Génétique", "Infantile",
//				"Plastique", "Vasculaire", "Viscérale" };
//
//		for (int i = 0; i < speciality_profession_TypeId.length; i++) {
//			Speciality speciality = new Speciality();
//			speciality.setId(i + 1);
//			speciality.setLabel(speciality_profession_Label[i]);
//			speciality.setCode(Integer
//					.parseInt(speciality_profession_TypeId[i]));
//			listSpeciality.add(speciality);
//		}
//		model.addAttribute("listProfession", listProfession);
//		model.addAttribute("listSpeciality", listSpeciality);
//		model.addAttribute("listProfessionType", listProfessionType);
//*/			
////		StaffMember staffMember = new StaffMember();
////		staffMember.setPerson(person);
////		staffMember.setCodeRPPS("12425235T5");
//		model.addAttribute("staffMember", new StaffMember());
////		model.addAttribute("listOrganization", organizationDAO.getAll());
////		model.addAttribute("listOrganizationType", organizationTypeDAO.getAll());
////		model.addAttribute("listService", serviceTypeDAO.getAll());
////		System.out.println((serviceTypeDAO.getAll()).size());
//
//		return "ref/person/staff/staffMemberCreate";
//	}
//	
//	/**
//	 * @param model
//	 * @return form to create a Patient
//	 */
//	@RequestMapping(value ="/patientCreateForm",method = { RequestMethod.POST, RequestMethod.GET})
//	public String getPatientMemberForm(Model model) {
//		String[] listTypePatient = new String[] {"Newborn", "Private", "Under protection"};
//		String[] listStatusPatient = new String[] {"Activate", "Discharge", "Pre-register"};
//		model.addAttribute("listTypePatient", listTypePatient);
//		model.addAttribute("listStatusPatient", listStatusPatient);
//		model.addAttribute("patient", new Patient());
//		return "ref/person/patient/patientCreate";
//	}
//	
//	/**
//	 * @param staffMember
//	 * @param model
//	 * @return a confirmation of Person creation 
//	 */
//	@RequestMapping(value = "/staffMember", method = RequestMethod.POST)
//	public String createStaffMember(@ModelAttribute StaffMember staffMember, Model model){
//		LOGGER.info("EASYES Create StaffMember");
//		model.addAttribute("staffMember", staffMember);
//		// Mock Address =====================================
//			Address address = new Address();
//			address.setCity("Créteil");
//			address.setStreetNumber("71");
//			address.setZipCode("94000");
//			staffMember.setAddress(address);
//		//Mock Address ======================================
//		personDao.create(staffMember);
//		return "ref/person/staff/staffMemberDisplay";		
//	}
//	
//	/**
//	 * @param staffMember
//	 * @param model
//	 * @return a confirmation of Person creation 
//	 */
//	@RequestMapping(value = "/patient", method = RequestMethod.POST)
//	public String createPatient(@ModelAttribute Patient patient, Model model){
//		LOGGER.info("EASYES Create StaffMember");
//		model.addAttribute("patient", patient);
//		// Mock Address =====================================
//					Address address = new Address();
//					address.setCity("Créteil");
//					address.setStreetNumber("71");
//					address.setZipCode("94000");
//					patient.setAddress(address);
//				//Mock Address ======================================
//		personDao.create(patient);
//		return "ref/person/patient/patientDisplay";		
//	}
//	
//	
//}
