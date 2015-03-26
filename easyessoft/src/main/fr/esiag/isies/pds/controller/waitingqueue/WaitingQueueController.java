package fr.esiag.isies.pds.controller.waitingqueue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.esiag.isies.pds.model.referential.organization.Organization;
import fr.esiag.isies.pds.model.referential.person.staff.StaffMember;
import fr.esiag.isies.pds.model.waitingqueue.WaitingQueue;
import fr.esiag.isies.pds.dao.waitingqueue.WaitingQueueDAO;
//import fr.esiag.isies.pds.dao.referential.staff.StaffMemberDAO;
import fr.esiag.isies.pds.dao.referential.organization.OrgaTypeDao;
import fr.esiag.isies.pds.dao.referential.organization.OrganizationDao;
import fr.esiag.isies.pds.dao.referential.organization.ServiceTypeDao;
import fr.esiag.isies.pds.dao.referential.person.staff.StaffMemberDAO;

/**
 * Get the HTTP request, do actions (Database) and return a view (JSP)
 * @author JASS KVI LAD YEL
 */

@Controller
@RequestMapping("waitingQueue")
public class WaitingQueueController {
	
	// Instantiate the Logger
	private static final Logger LOGGER = LoggerFactory.getLogger(WaitingQueueController.class);
	
	// Instantiate the DAO
	private WaitingQueueDAO waitingQueueDAO;
	private OrganizationDao organizationDAO;
	private OrgaTypeDao organizationTypeDAO;
	private ServiceTypeDao serviceTypeDAO;
	private StaffMemberDAO staffMemberDAO;
	
	public WaitingQueueController() {		
		waitingQueueDAO = new WaitingQueueDAO();
		organizationDAO = new OrganizationDao();
		organizationTypeDAO = new OrgaTypeDao();
		serviceTypeDAO = new ServiceTypeDao();
		staffMemberDAO = new StaffMemberDAO();
	}
	
	
	@RequestMapping("screenPatient")
	public String showScreenPatient(@RequestParam("idService") int idService, @RequestParam("idOrganization") int idOrganization, Model model) {
		//
		WaitingQueueManager waitingQueueManager = new WaitingQueueManager(idService, idOrganization);
			
		List<WaitingQueue> listPatient = waitingQueueManager.getPatientsInQueue();

		// Adding variables to JSP
		model.addAttribute(new WaitingQueue()); 
		model.addAttribute("idService", idService);
		model.addAttribute("idOrganization", idOrganization);
		model.addAttribute("tableRows", 10);
		model.addAttribute("listPatient", waitingQueueManager.getPatientsInQueue());
		System.out.println("nb patients " +  waitingQueueManager.getPatientsInQueue().size());
		
		return "waitingqueue/waitingQueuePatient";
	}
	
	
	@RequestMapping("screenStaff")
	public String showScreenStaff(@RequestParam("navigationScreen") String navigationScreen, @RequestParam("idService") int idService, @RequestParam("idOrganization") int idOrganization, Model model) {
		//
		WaitingQueueManager waitingQueueManager = new WaitingQueueManager(idService, idOrganization);
			
		// Adding variables to JSP
		model.addAttribute(new WaitingQueue()); 
		model.addAttribute("navigationScreen", navigationScreen);
		model.addAttribute("idService", idService);
		model.addAttribute("idOrganization", idOrganization);
		
		if(navigationScreen.equals("waitingRoom")) {
			model.addAttribute("listPatient", waitingQueueManager.getPatientsInQueue());
		}
		else if(navigationScreen.equals("boxs")) {
			model.addAttribute("listPatient", waitingQueueManager.getPatientsInBoxs());
		}
		else if(navigationScreen.equals("exits")) {
			model.addAttribute("listPatient", waitingQueueManager.getPatientsExits());
		}
		
		return "waitingqueue/waitingQueueStaff";
	}	
	
	

	
	
	
	
	
	
	// *******************************************************************/
	// FONCTIONS RESERVEES A LA DEMO
	
	@RequestMapping("screenDemo")
	public String showScreenDemo(Model model) {
		
		List<Organization> listOrganization = organizationDAO.getAll();
		List<StaffMember> listDoctors = new ArrayList();
		
		model.addAttribute(new WaitingQueue()); 
		model.addAttribute("idService", 0);
		model.addAttribute("idOrganization", 0);
		model.addAttribute("listOrganization", listOrganization);
		model.addAttribute("listDoctors", listDoctors);
		
		return "waitingqueue/waitingQueueDemo";
	}

	@RequestMapping(value = "/screenDemo",method = RequestMethod.POST)
	public String showScreenDemo(HttpServletRequest request, Model model) {

		List<Organization> listOrganization = organizationDAO.getAll();
		List<StaffMember> listDoctors = new ArrayList();
		
		model.addAttribute(new WaitingQueue()); 
		model.addAttribute("idService", Integer.parseInt(request.getParameter("idService")));
		model.addAttribute("idOrganization", Integer.parseInt(request.getParameter("idOrganization")));
		model.addAttribute("listOrganization", listOrganization);
		model.addAttribute("listMedicalProcedure", listOrganization);
		model.addAttribute("listDoctors", listDoctors);

		return "waitingqueue/waitingQueueDemo";
	}	
	
	@RequestMapping("testDemo")
	public void showTestDemo(Model model) {
		this.showScreenDemo(model);
	}

	@RequestMapping(value = "/testDemo",method = RequestMethod.POST)
	public String testDemo(HttpServletRequest request, Model model) {

		int idService = Integer.parseInt(request.getParameter("idService"));
		int idOrganization = Integer.parseInt(request.getParameter("idOrganization"));

		List<Organization> listOrganization = organizationDAO.getAll();
		List<StaffMember> listDoctors = new ArrayList();
		
		WaitingQueueManager waitingQueueManager = new WaitingQueueManager(idService, idOrganization);
		Random rand = new Random();

		if(request.getParameter("typeInjection").equals("insert")) {
			for(int iInsert=0; iInsert < Integer.parseInt(request.getParameter("number")); iInsert++) {
				waitingQueueManager.insertPatientInQueue(rand.nextInt((500 - 200) + 1) + 200, rand.nextInt((5 - 2) + 1) + 2, 20);
				model.addAttribute("successMessage", "YES");
			}
		}
		
		if(request.getParameter("typeInjection").equals("treatment")) {
			System.out.println("okok");
			List<WaitingQueue> listPatientsInQueue = waitingQueueManager.getPatientsInQueue();
			int patientRandom = rand.nextInt((listPatientsInQueue.size()-1 - 0) + 1) + 0;
			waitingQueueManager.insertPatientInBox(listPatientsInQueue.get(patientRandom).getIdPatient(), listPatientsInQueue.get(patientRandom).getPriority(), 20, rand.nextInt((926 - 802) + 1) + 802, rand.nextInt((10 - 1) + 1) + 1);
			model.addAttribute("successMessage", "YES");
		}
		
		if(request.getParameter("typeInjection").equals("exit")) {
			List<WaitingQueue> listPatientsInBoxs = waitingQueueManager.getPatientsInBoxs();
			int patientRandom = rand.nextInt((listPatientsInBoxs.size()-1 - 0) + 1) + 0;
			waitingQueueManager.exitPatientInBox(listPatientsInBoxs.get(patientRandom).getIdPatient(), listPatientsInBoxs.get(patientRandom).getPriority(), 20);
			model.addAttribute("successMessage", "YES");
		}
		
		//
		model.addAttribute(new WaitingQueue()); 
		model.addAttribute("idService", Integer.parseInt(request.getParameter("idService")));
		model.addAttribute("idOrganization", Integer.parseInt(request.getParameter("idOrganization")));
		model.addAttribute("listOrganization", listOrganization);
		model.addAttribute("listMedicalProcedure", listOrganization);
		model.addAttribute("listDoctors", listDoctors);

		return "waitingqueue/waitingQueueDemo";
	}
	
	//
	// *******************************************************************/
		
}