package fr.esiag.isies.pds.businessRules.referential.organization;

import org.junit.Before;
import org.junit.Test;

import mockit.Mocked;
import fr.esiag.isies.pds.businessRules.refential.infrastructure.InfrastructureBusinessRules;
import fr.esiag.isies.pds.businessRules.referential.organization.OrganizationBusinessRules;
import fr.esiag.isies.pds.dao.referential.infrastructure.CategoryRefInfraDao;
import fr.esiag.isies.pds.dao.referential.organization.OrganizationDao;
import fr.esiag.isies.pds.model.referential.infrastructure.CategoryRefInfra;
import fr.esiag.isies.pds.model.referential.infrastructure.Infrastructure;
import fr.esiag.isies.pds.model.referential.infrastructure.TypeRefInfra;
import fr.esiag.isies.pds.model.referential.organization.Organization;

/**
 * This class provide defined business rules verifications
 * @author SKO JLA OSA ADA JSB
 *
 */
public class OrganizationBusinessRulesTest{
	/**
	 * Organization Business rule Tested
	 */
	private OrganizationBusinessRules orgaBR = new OrganizationBusinessRules(); 

	/**
	 * Valid organization
	 */
	private Organization validOrganization;

	/**
	 * Wrong organiazation
	 */
	private Organization wrongOrganization;

	/**
	 *---------Elements to test--------- 
	 */
	//organization type
	private Organization wrongOrganizationType;
	//name
	private Organization wrongOrganizationName;
	//siret
	private Organization wrongOrganizationSiret;
	
	//TODO:adress class will be created and corresponding Test Class
	
	//gps coords
	private Organization wrongOrganizationLatitude;
	private Organization wrongOrganizationLongitude;
	
	//gps contact
	private Organization wrongOrganizationFax;
	private Organization wrongOrganizationEmail;
	private Organization wrongOrganizationPhone;
	
	/**
	 * 
	 * Mocked DAO
	 */
	@Mocked
	OrganizationDao orgaDao;
	
	@Before
	public void prepareTest() {
		
	}
	
	@Test
	public void executeTest() {
		
	}
}
