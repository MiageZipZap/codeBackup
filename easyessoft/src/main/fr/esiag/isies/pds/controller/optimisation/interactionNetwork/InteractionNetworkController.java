package fr.esiag.isies.pds.controller.optimisation.interactionNetwork;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.esiag.isies.pds.businessRules.optimisation.interactionNetwork.InteractionNetworkBusinessRules;
import fr.esiag.isies.pds.dao.optimisation.interactionNetwork.InteractionNetworkDao;
import fr.esiag.isies.pds.model.optimisation.interactionNetwork.InteractionNetwork;

/**
 * Get the http request which concern interaction network
 * 
 * @author PFR
 *
 */
@Controller
@RequestMapping("interactionNetwork")
public class InteractionNetworkController {

	/**
	 * Logger
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(InteractionNetworkController.class);

	
	/**
	 * InteractionNetwork Dao
	 */
	private InteractionNetworkDao interactionNetworkDao = new InteractionNetworkDao();
	
	/**
	 * TODO AFTER
	 * 
	 * @param model
	 * @return interaction network form to enter criteria about the interation
	 *         network
	 */
	// @RequestMapping("criteriaFormPage")
	// public String getFormPage(Model model) {
	// LOGGER.info("EASYES Form display : Interaction Network Form");
	// model.addAttribute(new InteractionNetworkCriteria());
	// return "interactionNetwork/criteriaForm";
	// }

	/**
	 * 
	 * @param criteriaInteractionNetwork
	 *            : Criteria about an interaction network
	 * @param model
	 * @return an Interaction Network
	 */
	@RequestMapping(value = "view")
	public String getInteractionNetworkPage(Model model) {
		// if (new InteractionNetworkCriteriaBusinessRules()
		// .verify(interactionNetworkCriteria)) {
		InteractionNetwork interactionNetwork = constructInteractionNetwork();
		if (new InteractionNetworkBusinessRules().verify(interactionNetwork)) {
			model.addAttribute("interactionNetwork", interactionNetwork);
			LOGGER.info("EASYES : Show Interaction Network");
			return "interactionNetwork/interactionNetwork";
		}

		// ERROR About InteractionNetwork
		// model.addAttribute("interactionNetworkCriteria",
		// interactionNetworkCriteria);
		// LOGGER.info("EASYES Form display : InteractionNetworkCriteria ERROR");
		// return "interactionNetwork/criteriaForm";
		return null;
	}

	
	/*
	 * Construct an interaction network criteria
	 */
	private InteractionNetwork constructInteractionNetwork() {
		InteractionNetwork interactionNetwork = new InteractionNetwork();
		interactionNetwork.setInteractions(interactionNetworkDao.getInteractions());
		return interactionNetwork;
	}
}
