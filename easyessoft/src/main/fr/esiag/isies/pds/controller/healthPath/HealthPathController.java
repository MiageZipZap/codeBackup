package fr.esiag.isies.pds.controller.healthPath;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fr.esiag.isies.pds.controller.referential.Person.PersonMemberController;
import fr.esiag.isies.pds.model.healthPath.HealthPath;
import fr.esiag.isies.pds.model.hospital.medical.CcamAct;

/**
 * Get the HTTP request, do actions (Database) and return a view (JSP)
 * 
 * @author LAD
 */
@Controller
@RequestMapping("healthPaths/healthPath")
public class HealthPathController {
	// Instantiate the Logger
	private static final Logger LOGGER = LoggerFactory
			.getLogger(PersonMemberController.class);

	// Instantiate the DAO
//	private HealthPathDao healthPathDao;

	public HealthPathController() {
//		this.healthPathDao = new HealthPathDao();
	}
	
	/**
	 * @param model
	 * @return form to create a Person
	 */
	@RequestMapping(value ="/healthPathCreateForm",method = { RequestMethod.POST, RequestMethod.GET})
	public String getHPForm(Model model) {
		model.addAttribute("healthPath", new HealthPath());
		return "ref/healthPath/healthPathCreate";
	}
	
	/**
	 * @param model
	 * @return form to create a HealthPath
	 */
	@RequestMapping(value ="/healthPathCreateAction",method = { RequestMethod.POST, RequestMethod.GET})
	public String createHealthPath(@ModelAttribute HealthPath healthPath, Model model) {
//		healthPathDao.create(healthPath);
		return "ref/healthPath/healthPathDisplay"; // TO create
	}
	
	/**
	 *
	 * @param model
	 * @return view DisplayWFHealthPath
	 */
	@RequestMapping(value ="/workflowHP",method = { RequestMethod.POST, RequestMethod.GET})
	public String displayWF(Model model) {
		return "ref/healthPath/healthPathWFDisplay"; // TO create
	}
	 
	
	/**
	 * @param model
	 * @return form to create a HealthPath
	 */
	
	@RequestMapping(value ="/updateStatus",method = { RequestMethod.POST, RequestMethod.GET})
	public @ResponseBody
	String refreshHealPathWF() {
		/*============================================ Mock Acts ==================================*/
		List<CcamAct> principalActList = new ArrayList<CcamAct>();
		String[] noteActList = {"coloscopie", "ablation_Amidale", "toucher_rectal", "réanimation"};
		for(String actNote:noteActList){
			double lower = 5.000;
			double upper = 99.999;
			double price = Math.random() * (upper - lower) + lower;
			CcamAct ccamAct = new CcamAct();
			ccamAct.setActPrice(price);
			ccamAct.setActNote(actNote);
			principalActList.add(ccamAct);
		}
//		model.addAttribute("principalActList", principalActList);
		String htmlDivValue = 
					"<h1 class='block' id='h0_block' style='left: 10px; top:10px;'>"
			       +  "Libellé acte: " + principalActList.get(0).getActNote() + ""
			       +  "Prix acte : " + String.valueOf(principalActList.get(0).getActPrice()) + ""
			       + "</h1>"
			       + "<h2 class='block' id='h1_block' style='left: 10px; top:10px;'>"
			       +  "<p> Libellé acte: " + principalActList.get(1).getActNote() + "</p>"
			       +  "<p> Prix acte : " + String.valueOf(principalActList.get(1).getActPrice()) + "</p>"
			       + "</h2>"
				   + "<div class='connector h0_block h1_block'></div>";
		/*============================================ Mock Acts ==================================*/
		return htmlDivValue; 
	}
}
