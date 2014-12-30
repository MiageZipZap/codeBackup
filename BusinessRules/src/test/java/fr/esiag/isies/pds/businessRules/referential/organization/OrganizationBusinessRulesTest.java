package fr.esiag.isies.pds.businessRules.referential.organization;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import mockit.Mocked;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.esiag.isies.pds.dao.referential.organization.OrganizationDao;
import fr.esiag.isies.pds.model.referential.organization.OrgaType;
import fr.esiag.isies.pds.model.referential.organization.Organization;

/**
 * This class provide defined business rules verifications
 * @author SKO JLA OSA ADA JSB
 *
 */
public class OrganizationBusinessRulesTest{
	/**
	 *LOGGER
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationBusinessRules.class);
	/**
	 * Organization Business rule Tested
	 */
	private OrganizationBusinessRules orgaBR = new OrganizationBusinessRules(); 

	/**
	 * Valid
	 */
	private Organization validOrganization;
	private OrgaType validOrganizationType;

	/**
	 * Wrong
	 */
	private Organization wrongOrganizationConstraints;

	/**
	 *---------Elements to test--------- 
	 */
	//Forms constraints wrongOrganizationConstraint
	
	//siret
	private Organization wrongOrganizationSiret;
	
	//TODO:organization id
	/** 
	 * Mocked DAO
	 */
	@Mocked
	OrganizationDao orgaDao;

	@Before
	public void prepareTest() {
		//OrganizationType
		validOrganizationType = new OrgaType();
		validOrganizationType.setCode("OT02");
		validOrganizationType.setLabel("Hôpital");
		validOrganizationType.setLegalStatus("public");
		//Organization
		validOrganization = new Organization();
		validOrganization.setOrgaType(validOrganizationType);
		validOrganization.setName("Mondor");
		validOrganization.setSiret("12345678912345");
		validOrganization.setStreetNumber(83);
		validOrganization.setStreetType("rue");
		validOrganization.setStreetName("petit");
		validOrganization.setCity("Paris");
		validOrganization.setZipCode("75019");
		validOrganization.setDepartment("ile de france");
		validOrganization.setLatitude((float) 48.56325);
		validOrganization.setLongitude((float) 158.56325);
		validOrganization.setFax("0142515252");
		validOrganization.setEmail("samuel@koulibali.com");
		validOrganization.setPhone("0142515252");



		// Wrong Organization
		wrongOrganizationConstraints = new Organization();
		wrongOrganizationConstraints.setOrgaType(validOrganizationType);
		wrongOrganizationConstraints.setName("M");
		wrongOrganizationConstraints.setSiret("1234567891234");
		wrongOrganizationConstraints.setStreetNumber(83);
		wrongOrganizationConstraints.setStreetType(".");
		wrongOrganizationConstraints.setStreetName("t");
		wrongOrganizationConstraints.setCity("j");
		wrongOrganizationConstraints.setZipCode("k75019");
		wrongOrganizationConstraints.setDepartment("i");
		wrongOrganizationConstraints.setLatitude((float) -900);
		wrongOrganizationConstraints.setLongitude((float) 1585.563251111);
		wrongOrganizationConstraints.setFax("014251522");
		wrongOrganizationConstraints.setEmail("samuel@koulibali");
		wrongOrganizationConstraints.setPhone("0142515252$");
	}

	@Test
	public void executeTest() {
		assertTrue(orgaBR.verify(this.validOrganization));
		assertFalse(orgaBR.verify(this.wrongOrganizationConstraints));

	}
}
