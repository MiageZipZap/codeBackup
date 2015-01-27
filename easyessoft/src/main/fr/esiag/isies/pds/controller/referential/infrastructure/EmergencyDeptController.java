package fr.esiag.isies.pds.controller.referential.infrastructure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.esiag.isies.pds.dao.referential.infrastructure.EquipmentDao;
import fr.esiag.isies.pds.dao.referential.infrastructure.InfrastructureDao;
import fr.esiag.isies.pds.dao.referential.infrastructure.MedicineDao;
import fr.esiag.isies.pds.dao.referential.organization.OrganizationDao;

/**
 * Get the http request which concern Emergency Department views
 * 
 * @author GKA,ODI,PFR,MCH
 *
 */
@Controller
@RequestMapping("ref/emergencyDept")
public class EmergencyDeptController {
	/**
	 * Logger
	 */
	private static final Logger LOGGER = LoggerFactory
			.getLogger(EmergencyDeptController.class);

	/**
	 * Dao for infrastructure
	 */
	private InfrastructureDao infrastructureDao = new InfrastructureDao();

	/**
	 * Dao for equipment
	 */
	private EquipmentDao equipmentDao = new EquipmentDao();

	/**
	 * Dao for medicine
	 */
	private MedicineDao medicineDao = new MedicineDao();

	/**
	 * Dao for medicine
	 */
	private OrganizationDao organizationDao = new OrganizationDao();

	/**
	 * 
	 * @param model
	 * @return emergency department home page
	 */
	@RequestMapping("homePage")
	public String getHomePage(Model model) {
		LOGGER.info("EASYES Form display : Emergency Department Home Page");
		return "ref/infra/emergencyDeptHomePage";
	}

	/**
	 * Read infrastructure, equipment and medicine which are in the emergency
	 * service of an hospital
	 * 
	 * @param idHospital
	 *            of an hospital
	 * @param model
	 * @return page which show all the infrastructure, equipment and medicine
	 *         which are in the emergency service of an hospital
	 */
	@RequestMapping("read/{idHospital}")
	public String read(@PathVariable("idHospital") int idHospital, Model model) {
		LOGGER.info("EASYES Form display : Read Equipment, Infrastructure and Medicine which are in an hospital");
		model.addAttribute("equipments",
				equipmentDao.getAllByIdHospital(idHospital));
		model.addAttribute("infrastructures",
				infrastructureDao.getAllByIdHospital(idHospital));
		model.addAttribute("medicines",
				medicineDao.getAllByIdHospital(idHospital));
		model.addAttribute("hospital", organizationDao.getById(idHospital));
		return "ref/infra/read";
	}
}
