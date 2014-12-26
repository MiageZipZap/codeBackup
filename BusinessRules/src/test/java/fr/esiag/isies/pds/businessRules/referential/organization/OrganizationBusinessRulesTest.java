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
 * @author Samuel
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
		//test 
	
	
	/**
	 * Mocked DAO
	 */
	@Mocked
	OrganizationDao categoryRefInfraDao;
	
	@Before
	public void prepareTest() {
		
	}
	
	@Test
	public void executeTest() {
		
	}
}
