package fr.esiag.isies.pds.businessRules.referential.organization;

import fr.esiag.isies.pds.businessRules.IBusinessRules;
import fr.esiag.isies.pds.model.referential.organization.Organization;

/**
 * This class provide defined business rules verifications
 * @author Samuel
 *
 */
public class OrganizationBusinessRules implements IBusinessRules<Organization> {	
	/**
	 * 
	 */
	public boolean verify(Organization item) {
		//rule to verify that the siret validity
		if(verifySiret(item.getSiret())){
			return false;
		};

		/**
		 * another business rules to check
		 */
		return true;
	}

	private boolean verifySiret(String siret){
		/**
		 * TODO: will be implemented with the "search function: find by Siret method" 
		 * and will return true if siret is found in database
		 * OrganizationDao to be used
		 */
		return true;

	}

}
