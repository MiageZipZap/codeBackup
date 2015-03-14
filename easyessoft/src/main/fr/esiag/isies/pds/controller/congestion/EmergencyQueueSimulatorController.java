package fr.esiag.isies.pds.controller.congestion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.esiag.isies.pds.congestion.simulator.EmergencyQueueSimulator;

@Controller
@RequestMapping("emerg/congestion/simulator")
public class EmergencyQueueSimulatorController {

	/**
	 * Logger
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(EmergencyQueueSimulatorController.class);

	/**
	 * 
	 * @param 
	 * @return 
	 */
	@RequestMapping("DisplayMain")
	public String dislayMain(Model model) {
		return "emerg/congestion/main";
	}
	
	/**
	 * 
	 * @param 
	 * @return 
	 */
	@RequestMapping("StartSimulation")
	public String startSimulation(Model model) {
		EmergencyQueueSimulator.getInstance().startSimulation();
		return "emerg/congestion/main";
	}
	
	/**
	 * 
	 * @param 
	 * @return 
	 */
	@RequestMapping("StopSimulation")
	public String stopSimulation(Model model) {
		EmergencyQueueSimulator.getInstance().stopSimulation();
		return "emerg/congestion/main";
	}
}
