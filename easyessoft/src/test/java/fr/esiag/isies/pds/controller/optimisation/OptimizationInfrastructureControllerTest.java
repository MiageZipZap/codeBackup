package fr.esiag.isies.pds.controller.optimisation;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import mockit.Mocked;
import mockit.NonStrictExpectations;

import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import fr.esiag.isies.pds.dao.optimisation.emergency.EmergencyFrequentationTrafficLogDao;
import fr.esiag.isies.pds.model.referential.organization.Organization;
/**
 * Class wich test all methods of optimizationInfrastructureController
 * @author OSA
 *
 */
public class OptimizationInfrastructureControllerTest {

	public OptimizationInfrastructureController optimizationInfrastructureController;
	public Model model;
	/**
	 * Mocked DAO of EmergencyFrequentationTrafficLogDao
	 */
	@Mocked
	EmergencyFrequentationTrafficLogDao emergencyLog;
	@Mocked
	Organization organization;
	
	/**
	 * Initialize variable before test
	 */
	@Before
	public void init() {
		optimizationInfrastructureController =new OptimizationInfrastructureController();
		model = new ExtendedModelMap();
	}
	/**
	 * Method wich test method getViewChooseHospitalTest
	 */
	@Test
	public void getViewChooseHospitalTest() {
		//This test control if the return URL is their when we have no history for emergency service
		new NonStrictExpectations() {{
			//mock response of DAO 
			emergencyLog.getIdOfAllOrganizationInEmergencyTrafficLog(); result = new ArrayList<Integer>();
		}};
		//initialize an URL with method tested
		String url = optimizationInfrastructureController.getViewChooseHospital(model);
		//Control result if we have no organization for history
		assertEquals(url, "optim/noHistory");
		//Second Test
		//This test control if the return URL is their when we have history for emergency service 
		new NonStrictExpectations() {{
			//Initialize List
			ArrayList<Integer> listIdOrga = new ArrayList<Integer>();
			//Set idOrganization on list
			listIdOrga.add(38);
			//mock result of this call
			emergencyLog.getIdOfAllOrganizationInEmergencyTrafficLog(); result = listIdOrga;
		}};
		//initialize an URL with method tested
		String url2 = optimizationInfrastructureController.getViewChooseHospital(model);
		//Control result if we have organization for history
		assertEquals(url2, "/optim/optimEmergencyChooseHospital");
	}

}
