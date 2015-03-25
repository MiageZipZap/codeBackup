package fr.esiag.isies.pds.controller.congestion;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import fr.esiag.isies.pds.congestion.indicator.EmergencyCongestionIndicator;
import fr.esiag.isies.pds.congestion.simulator.SimulatorLauncher;
import fr.esiag.isies.pds.dao.referential.infrastructure.InfrastructureDao;
import fr.esiag.isies.pds.dao.referential.organization.OrganizationDao;
import fr.esiag.isies.pds.dao.waitingqueue.WaitingQueueDAO;
import fr.esiag.isies.pds.model.referential.organization.Hospital;
import fr.esiag.isies.pds.model.waitingqueue.WaitingQueue;

@Controller
@RequestMapping("emerg/congestion/simulator")
public class EmergencyQueueSimulatorController {

	/**
	 * Logger
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(EmergencyQueueSimulatorController.class);

	public WaitingQueueDAO wqd;
	public OrganizationDao od;
	public InfrastructureDao infrdao;
	
	public EmergencyCongestionIndicator eci;

	public EmergencyQueueSimulatorController() {
		wqd = new WaitingQueueDAO();
		od = new OrganizationDao();
		infrdao = new InfrastructureDao();
		eci = new EmergencyCongestionIndicator();
	}

	/**
	 * 
	 */
	@RequestMapping("ChooseHospital")
	public String chooseHospital(Model model){
		Hospital hospital = new Hospital();
		model.addAttribute("hospital",hospital);
		
		List<Hospital> listHospital = od.getAllByType(Hospital.class);
		model.addAttribute("listHospital",listHospital);
		
		return "emerg/congestion/chooseHospitalToMonitore";
	}
	
	/**
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value="DisplaySingleService")
	public String dislaySingleService(@ModelAttribute("hospital") Hospital hospital,Model model,final RedirectAttributes redirectAttributes) {
		List<WaitingQueue> waitingPatients = wqd.getWaitingPatient(hospital.getId(), 1);
		List<WaitingQueue> treatedPatients = wqd.getTreatedPatient(hospital.getId(), 1);
		System.out.println("\n\n" + waitingPatients.size() + "\n\n");
		long nbrBoxes = infrdao.getNbrBoxes(hospital.getId());
		int waitingRoomCapacity = 30;
		float waitingRoomCongestion = eci.getSingleCongestionIndicator(nbrBoxes, waitingPatients.size());
		
		model.addAttribute("hospital",hospital);
		model.addAttribute("waitingPatients",waitingPatients);
		model.addAttribute("treatedPatients",treatedPatients);
		model.addAttribute("waitingRoomCapacity",waitingRoomCapacity);
		model.addAttribute("waitingRoomCongestion",waitingRoomCongestion);
		

		// int nbrPatientInQueue = wqd.getNbrPatientInQueue(1, 1);

		// model.addAttribute("nbrPatientInQueue", nbrPatientInQueue);
		return "emerg/congestion/singleServiceMonitoring";
	}

	/**
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value="StartSimulation",params={"muArr","muSorties"},method = RequestMethod.GET)
	public @ResponseBody void startSimulation(@RequestParam float muArr, @RequestParam float muSorties) {
		SimulatorLauncher sl = SimulatorLauncher.getInstance();
		sl.init(muArr,muSorties);
		sl.startSimulator();
		
		
	}

	/**
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping("StopSimulation")
	public @ResponseBody void stopSimulation(Model model) {
		SimulatorLauncher sl = SimulatorLauncher.getInstance();
		sl.stopSimulator();
	}

	/**
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "RefreshChartSingle",params = "idHospital", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody float refreshChartSingle(@RequestParam int idHospital, Model model) {
		int nbrPatientInQueue = wqd.getWaitingPatient(idHospital, 1).size();
		long nbrBoxes = infrdao.getNbrBoxes(idHospital);
		float congestion = eci.getSingleCongestionIndicator(nbrBoxes, nbrPatientInQueue);
		
		model.addAttribute("congestion", congestion);

		return congestion;

	}
	
	/**
	 * 
	 * @param
	 * @return
	 */
	@RequestMapping(value = "RefreshTables",params = "idHospital", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<WaitingQueue> refreshTables(@RequestParam int idHospital,Model model) {
		List<WaitingQueue> allPatients = wqd.getDayPatients(idHospital, 1);

		//model.addAttribute("nbrPatientInQueue", nbrPatientInQueue);

		return allPatients;

	}
	
	

}
