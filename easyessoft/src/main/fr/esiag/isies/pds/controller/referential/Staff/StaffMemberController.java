package fr.esiag.isies.pds.controller.referential.Staff;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import fr.esiag.isies.pds.dao.referential.organization.OrgaTypeDao;
import fr.esiag.isies.pds.dao.referential.organization.OrganizationDao;
import fr.esiag.isies.pds.dao.referential.organization.ServiceTypeDao;
import fr.esiag.isies.pds.dao.referential.person.staff.StaffMemberDAO;
import fr.esiag.isies.pds.model.referential.person.staff.Profession;
import fr.esiag.isies.pds.model.referential.person.staff.Speciality;
import fr.esiag.isies.pds.model.referential.person.staff.StaffMember;


/**
 * Get the HTTP request, do actions (Database) and return a view (JSP)
 * @author JASS KVI LAD YEL
 */

@Controller
@RequestMapping("ref/staffAdmin/member")
public class StaffMemberController {
	
	// Instantiate the Logger
	private static final Logger LOGGER = LoggerFactory.getLogger(StaffMemberController.class);
	
	// Instantiate the DAO
	private StaffMemberDAO staffMemberDAO;
	private OrganizationDao organizationDAO;
	private OrgaTypeDao organizationTypeDAO;
	private ServiceTypeDao serviceTypeDAO;
	

	
	public StaffMemberController() {
		staffMemberDAO = new StaffMemberDAO();
		organizationDAO = new OrganizationDao();
		organizationTypeDAO = new OrgaTypeDao();
		serviceTypeDAO = new ServiceTypeDao();
	}

	/**
	 * @param model
	 * @return form to create a Staff
	 */
	@RequestMapping("createForm")
	public String getForm(Model model) {
		
		
		//////////////////////////////////////////////////////////////////////
		// Mock of Profession Type
		List<Profession> listProfessionType = new ArrayList<Profession>();
		String[] professionType_Type = new String[]{"Médical","Soignant","Social","Administratif, logistique et technique"};
		
		for(int i=0; i < professionType_Type.length; i++) {
			Profession profession = new Profession();
			profession.setId(i+1);
			profession.setType(professionType_Type[i]);
			listProfessionType.add(profession);
		}
		//////////////////////////////////////////////////////////////////////
		// Mock of Profession
		List<Profession> listProfession = new ArrayList<Profession>();
		String[] profession_TypeId = new String[]{"1","1","1","1", "2","2","2","2", "3","3","3","3", "4","4","4","4"};
		String[] profession_Label = new String[]{"Chirurgien","Médecin","Pharmacien","Sage-femme","Brancardier","Masseur-kinésithérapeute","Orthophoniste","Psychomotricien","Assistant de service social","Conseiller conjugal et familial","Éducateur technique spécialisé","Psychologue","Assistant de recherche clinique","Ambulancier","Secrétaire médical","Standardiste"};
		
		for(int i=0; i < profession_Label.length; i++) {
			Profession profession = new Profession();
			profession.setId(i+1);
			profession.setLabel(profession_Label[i]);
			profession.setType(profession_TypeId[i]);
			listProfession.add(profession);
		}	
		//////////////////////////////////////////////////////////////////////
		// Mock of Profession
		List<Speciality> listSpeciality = new ArrayList<Speciality>();
		String[] speciality_profession_TypeId = new String[]{"1","1","1","1", "1","1", "2","2","2","2"};
		String[] speciality_profession_Label = new String[]{"Addictologie","Alcoologie","Allergologie","Cardiologie","Gastro-entérologie et hépatologie","Génétique","Infantile","Plastique","Vasculaire","Viscérale"};
		
		for(int i=0; i < speciality_profession_TypeId.length; i++) {
			Speciality speciality = new Speciality();
			speciality.setId(i+1);
			speciality.setLabel(speciality_profession_Label[i]);
			speciality.setCode(Integer.parseInt(speciality_profession_TypeId[i]));
			listSpeciality.add(speciality);
		}	
		//////////////////////////////////////////////////////////////////////
		
		
		model.addAttribute(new StaffMember()); 
		model.addAttribute("listProfessionType", listProfessionType);
		model.addAttribute("listProfession", listProfession);
		model.addAttribute("listSpeciality", listSpeciality);
		model.addAttribute("listOrganization", organizationDAO.getAll());
		model.addAttribute("listOrganizationType", organizationTypeDAO.getAll());
		model.addAttribute("listService", serviceTypeDAO.getAll());
		System.out.println((serviceTypeDAO.getAll()).size());
		
		return "ref/staff/staffMemberCreate";
	}
	
	/**
	 * @param Staff
	 * @param model
	 * @return a confirmation of Staff creation
	 */
	@RequestMapping(value = "/createAction",method = RequestMethod.POST)
	public String addStaffMember(@ModelAttribute StaffMember staffMember, Model model){
		LOGGER.info("EASYES Staff creation Create Action");
		staffMemberDAO.create(staffMember);
		LOGGER.info("EASYES Staff creation Create Action 2");
		model.addAttribute("staffMember",staffMember);
		return "ref/staff/staffMemberDisplay";		
	}
}
