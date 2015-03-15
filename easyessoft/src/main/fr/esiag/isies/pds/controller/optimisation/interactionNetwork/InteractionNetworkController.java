package fr.esiag.isies.pds.controller.optimisation.interactionNetwork;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.esiag.isies.pds.businessRules.optimisation.interactionNetwork.InteractionNetworkBusinessRules;
import fr.esiag.isies.pds.model.optimisation.interactionNetwork.AbstractInteraction;
import fr.esiag.isies.pds.model.optimisation.interactionNetwork.Disease;
import fr.esiag.isies.pds.model.optimisation.interactionNetwork.DiseaseInteraction;
import fr.esiag.isies.pds.model.optimisation.interactionNetwork.InfrastructureInteraction;
import fr.esiag.isies.pds.model.optimisation.interactionNetwork.InteractionNetwork;
import fr.esiag.isies.pds.model.optimisation.interactionNetwork.MedicineInteraction;
import fr.esiag.isies.pds.model.optimisation.interactionNetwork.Patient;
import fr.esiag.isies.pds.model.optimisation.interactionNetwork.Person;
import fr.esiag.isies.pds.model.referential.infrastructure.Infrastructure;
import fr.esiag.isies.pds.model.referential.infrastructure.Medicine;

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

		 //ERROR About InteractionNetwork
//		 model.addAttribute("interactionNetworkCriteria",
//		 interactionNetworkCriteria);
//		 LOGGER.info("EASYES Form display : InteractionNetworkCriteria ERROR");
		 return "interactionNetwork/criteriaForm";
	}

	/*
	 * Construct an interaction network according to the interaction network
	 * criteria
	 */
	private InteractionNetwork constructInteractionNetwork() {
		InteractionNetwork interactionNetwork = new InteractionNetwork();
		// Recup interaction avec la date de debut et la date de fin
		// Lhopital également
		// Récuperer les interactions liées aux premières trouvé et ainsi de
		// suite
		// S'arreter au bout de combien de temps ?
		// Faire le mock ici pour tester la vue au plus vite...
		// Pour la vue faire un tableau et infovis...
		// Tableau => Voir ce que j'avais fait...
		// Prévoir l'import excel ?
		// Ici le mock :
		// Add des interactions
		// Faire la vue après...

		// A tester avec plus de points !!!
		Person p = new Person();
		p.setName("Annick");
		p.setId(3);
		
		Person p2 = new Person();
		p2.setName("Peter");
		p2.setId(4);

		Person p3 = new Person();
		p3.setName("Jacques");
		p3.setId(1);

		Infrastructure i = new Infrastructure();
		i.setLabel("Salle d'attente - mondor");
		i.setId(2);
		interactionNetwork.getInfrastructures().put(i,2);
		AbstractInteraction<Infrastructure, Patient> ii = new InfrastructureInteraction();
		ii.setItemWithInteract(i);
		AbstractInteraction<Infrastructure, Patient> ii2 = new InfrastructureInteraction();
		ii2.setItemWithInteract(i);
		List<AbstractInteraction<?, ?>> lst = new ArrayList<AbstractInteraction<?, ?>>();
		List<AbstractInteraction<?, ?>> lst2 = new ArrayList<AbstractInteraction<?, ?>>();
		List<AbstractInteraction<?, ?>> lst3 = new ArrayList<AbstractInteraction<?, ?>>();
		lst.add(ii);
		lst3.add(ii2);
		Medicine m = new Medicine();
		m.setId(1);
		m.setLabel("Imurel");
		Medicine m2 = new Medicine();
		m2.setId(2);
		m2.setLabel("Doliprane");
		Medicine m3 = new Medicine();
		m3.setId(3);
		m3.setLabel("Endoxan");
		Disease d1 = new Disease();
		d1.setName("SEP");
		d1.setId(1);
		AbstractInteraction<Disease, Patient> di = new DiseaseInteraction();
		di.setItemWithInteract(d1);
		lst2.add(di);
		AbstractInteraction<Medicine, Patient> mi = new MedicineInteraction();
		mi.setItemWithInteract(m);
		AbstractInteraction<Medicine, Patient> mi2 = new MedicineInteraction();
		mi2.setItemWithInteract(m2);
		AbstractInteraction<Medicine, Patient> mi3 = new MedicineInteraction();
		mi3.setItemWithInteract(m3);

		AbstractInteraction<Medicine, Patient> mi4 = new MedicineInteraction();
		mi4.setItemWithInteract(m2);
		AbstractInteraction<Medicine, Patient> mi5 = new MedicineInteraction();
		mi5.setItemWithInteract(m3);

		AbstractInteraction<Medicine, Patient> mi6 = new MedicineInteraction();
		mi6.setItemWithInteract(m);
		AbstractInteraction<Medicine, Patient> mi7 = new MedicineInteraction();
		mi7.setItemWithInteract(m3);

		interactionNetwork.getMedicines().put(m,2);
		interactionNetwork.getMedicines().put(m2,2);
		interactionNetwork.getMedicines().put(m3,3);
		lst.add(mi);
		lst.add(mi2);
		lst.add(mi3);
		lst2.add(mi4);
		lst2.add(mi5);
		lst3.add(mi6);
		lst3.add(mi7);
		interactionNetwork.getDiseases().put(d1,1);
		interactionNetwork.getInteractions().put(p, lst);
		interactionNetwork.getInteractions().put(p2, lst2);
		interactionNetwork.getInteractions().put(p3, lst3);
		return interactionNetwork;
	}
}
