package fr.esiag.isies.pds.controller.waitingqueue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
import fr.esiag.isies.pds.model.waitingqueue.WaitingQueue;
import fr.esiag.isies.pds.dao.waitingqueue.WaitingQueueDAO;
//import fr.esiag.isies.pds.dao.referential.staff.StaffMemberDAO;
import fr.esiag.isies.pds.dao.referential.organization.OrgaTypeDao;
import fr.esiag.isies.pds.dao.referential.organization.OrganizationDao;
import fr.esiag.isies.pds.dao.referential.organization.ServiceTypeDao;

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
	
	public WaitingQueueController() {		
		waitingQueueDAO = new WaitingQueueDAO();
		organizationDAO = new OrganizationDao();
		organizationTypeDAO = new OrgaTypeDao();
		serviceTypeDAO = new ServiceTypeDao();
	}
	
	
	/**
	 * 
	 */
	@RequestMapping("screenDemo")
	public String showScreenDemo(Model model) {
		//
		List<Organization> listOrganization = organizationDAO.getAll();
		//
		model.addAttribute(new WaitingQueue()); 
		model.addAttribute("listOrganization", listOrganization);
		model.addAttribute("listMedicalProcedure", listOrganization);
		
		model.addAttribute("idService", 0);
		model.addAttribute("idOrganization", 0);
		
		return "waitingqueue/waitingQueueDemo";
	}

	
	/**
	 * 
	 */
	@RequestMapping(value = "/screenDemo",method = RequestMethod.POST)
	public String showScreenDemo(HttpServletRequest request, Model model) {
		//
		ArrayList<String[]> listPatient = new ArrayList<String[]>();
		String[]columnNames0 = {"16","Fabricio","Coloccini"};
		String[]columnNames1 = {"22","Ryan","Taylor"};
		String[]columnNames2 = {"643","Mike","Williamson"};
		String[]columnNames3 = {"534","Moussa","Sissoko"};
		String[]columnNames4 = {"98534","Vurnon","Anita"};
		String[]columnNames5 = {"543","Siem","De Jong"};
		String[]columnNames6 = {"54387","Jonas","Gutierrez"};
		String[]columnNames7 = {"3","Papiss","Cisse"};
		String[]columnNames8 = {"593","Yoan","Gouffran"};
		String[]columnNames9 = {"20","Emmanuel","Riviere"};
		listPatient.add(columnNames0);
		listPatient.add(columnNames1);
		listPatient.add(columnNames2);
		listPatient.add(columnNames3);
		listPatient.add(columnNames4);
		listPatient.add(columnNames5);
		listPatient.add(columnNames6);
		listPatient.add(columnNames7);
		listPatient.add(columnNames8);
		listPatient.add(columnNames9);
		
		//
		List<Organization> listOrganization = organizationDAO.getAll();
		
		//		
		model.addAttribute(new WaitingQueue()); 
		model.addAttribute("listOrganization", listOrganization);
		model.addAttribute("listOrganization", listOrganization);
		model.addAttribute("idService", Integer.parseInt(request.getParameter("idService")));
		model.addAttribute("idOrganization", Integer.parseInt(request.getParameter("idOrganization")));
		
		return "waitingqueue/waitingQueueDemo";
	}	
	

	/**
	 * 
	 */
	@RequestMapping("screenPatient")
	public String showScreenPatient(@RequestParam("idService") int idService, @RequestParam("idOrganization") int idOrganization, Model model) {
		//
		System.out.println(idService);
		System.out.println(idOrganization);

		//
		model.addAttribute(new WaitingQueue()); 
		
		return "waitingqueue/waitingQueuePatient";	

		
		
		
		//List<WaitingQueue> listPatient = waitingQueueDAO.getAll();

		
		
		//model.addAttribute("listPatient", listPatient);
		
		//model.addAttribute("listOrganizationType", organizationTypeDAO.getAll());

		//
		// Récuéperer la liste des patients avec le DAO
		
		

	/*
		
		model.addAttribute("navigationScreen", "screen");
		model.addAttribute("tableRows", 8);
		
		
		LOGGER.info("EASYES Staff creation Create Action");
		//staffMemberDAO.create(staffMember);
		LOGGER.info("EASYES Staff creation Create Action 2");
		model.addAttribute("listPatient", waitingQueueDAO.getAll());
	*/
	
	}
	
	
	/**
	 * 
	 */
	@RequestMapping("screenStaff")
	public String showScreenStaff(@RequestParam("navigationScreen") String navigationScreen, @RequestParam("idService") int idService, @RequestParam("idOrganization") int idOrganization, Model model) {
		//
		System.out.println(navigationScreen);
		System.out.println(idService);
		System.out.println(idOrganization);
		
		WaitingQueueManager waitingQueueManager = new WaitingQueueManager(idService, idOrganization);
			 
		//waitingQueueManager.insertPatientInQueue(14, 12, 11, 5, 100);
		//waitingQueueManager.insertPatientInQueue(14, 12, 12, 4, 100);
		//waitingQueueManager.insertPatientInQueue(14, 12, 13, 3, 100);
		//waitingQueueManager.insertPatientInQueue(14, 12, 14, 2, 100);
		//waitingQueueManager.insertPatientInQueue(14, 12, 15, 1, 100);
		//waitingQueueManager.insertPatientInQueue(14, 12, 16, 3, 100);
		//
	
	
	
		
		
		//SimpleDateFormat printFormat = new SimpleDateFormat("HH:mm:ss");
		//Date date = parseFormat.parse("2011-04-23 09:30:51:01");
		
		
		//System.out.println("date " + );
		

		
		// Adding variables to JSP
		model.addAttribute(new WaitingQueue()); 
		model.addAttribute("navigationScreen", navigationScreen);
		model.addAttribute("idService", idService);
		model.addAttribute("idOrganization", idOrganization);
		model.addAttribute("listPatient", waitingQueueManager.getPatientsInQueue());
		
		return "waitingqueue/waitingQueueStaff";
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	/**
	 * @param model
	 * @return form to create a Staff
	 */
	@RequestMapping("screenWaiting")
	public String showWaitingScreen1(Model model) {

		WaitingQueue wq = new WaitingQueue();
		wq.setIdOrganization(43);
		wq.setPriority(5);
		wq.setTimeQueueState(new Date());
		System.out.println("Date" + new Date());
		wq.setIdDoctor(22);
		wq.setIdService(1);
		wq.setIdMedicalProcedure(33);
		wq.setIdPatient(20);
		
		waitingQueueDAO.create(wq);
		
		model.addAttribute(new WaitingQueue()); 
		model.addAttribute("listOrganization", organizationDAO.getAll());
		model.addAttribute("listService", serviceTypeDAO.getAll());

		return "waitingqueue/waitingQueuePatient";
	}
	
	/**
	 * @param Staff
	 * @param model
	 * @return a confirmation of Staff creation
	 */
	@RequestMapping(value = "/screenWaiting",method = RequestMethod.POST)
	public String showWaitingScreen(@ModelAttribute WaitingQueue waitingQueue, Model model){
		
		//List<WaitingQueue> listPatient = waitingQueueDAO.getAll();

		
		
		//model.addAttribute("listPatient", listPatient);
		
		//model.addAttribute("listOrganizationType", organizationTypeDAO.getAll());

		//
		// Récuéperer la liste des patients avec le DAO
		
		
		System.out.println("Service : " + waitingQueue.getIdService());
		System.out.println("Organization : " + waitingQueue.getIdOrganization());
		//System.out.println("Liste des patients : " + listPatient.size());
		
		model.addAttribute("navigationScreen", "screen");
		model.addAttribute("tableRows", 8);
		
		
		LOGGER.info("EASYES Staff creation Create Action");
		//staffMemberDAO.create(staffMember);
		LOGGER.info("EASYES Staff creation Create Action 2");
		model.addAttribute("listPatient", waitingQueueDAO.getAll());

		return "waitingQueue/waitingScreen";		
	}
	
	
	
	
	
	
	/**
	 * 
	 */
	@RequestMapping(value = "/screenStaff",method = RequestMethod.POST)
	public String showScreenStaff3(HttpServletRequest request, Model model) {
		//
		int idService = Integer.parseInt(request.getParameter("idService"));
		int idOrganization = Integer.parseInt(request.getParameter("idOrganization"));

		
		//
		model.addAttribute(new WaitingQueue()); 
		
/*
		if (navigationScreen.compareTo("staffScreen") == 1) {
			return "waitingQueue/waitingQueueStaff";	
		} 
		else if (navigationScreen.compareTo("patientScreen") == 1) {
			return "waitingQueue/waitingQueuePatient";
		}
		else {
			
		}
	*/	
		
		
		//List<WaitingQueue> listPatient = waitingQueueDAO.getAll();

		
		
		//model.addAttribute("listPatient", listPatient);
		
		//model.addAttribute("listOrganizationType", organizationTypeDAO.getAll());

		//
		// Récuéperer la liste des patients avec le DAO
		
		

	/*
		
		model.addAttribute("navigationScreen", "screen");
		model.addAttribute("tableRows", 8);
		
		
		LOGGER.info("EASYES Staff creation Create Action");
		//staffMemberDAO.create(staffMember);
		LOGGER.info("EASYES Staff creation Create Action 2");
		model.addAttribute("listPatient", waitingQueueDAO.getAll());
	*/
		return "waitingqueue/waitingQueueDemo";
	}
	
}
