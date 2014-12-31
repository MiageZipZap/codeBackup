package fr.esiag.isies.pds.businessRules.referential.organization;

import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.esiag.isies.pds.model.referential.organization.OrgaType;
/**
 * Class wich test business rules for type of service
 * @author SKO JLA OSA ADA JSB
 *
 */
public class OrgaTypeBusinessRulesTest {
	/**
	 *LOGGER
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationBusinessRules.class);
	/**
	 * Organization Business rule Tested
	 */
	OrgaTypeBusinessRules orgaTypeBR = new OrgaTypeBusinessRules();
	/**
	 * Valid
	 */
	OrgaType validOrgaType;
	/**
	 * Wrong
	 */
	OrgaType wrongOrgaType;
	/**
	 *---------Elements to test--------- 
	 */
	@Before
	public void prepareTest() {
		//init valid OrgaType
		validOrgaType = new OrgaType();
		validOrgaType.setCode("4EB6");
		//To be continued
		
	}
}
