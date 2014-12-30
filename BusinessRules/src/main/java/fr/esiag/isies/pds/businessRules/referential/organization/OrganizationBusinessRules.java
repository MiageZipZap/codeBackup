package fr.esiag.isies.pds.businessRules.referential.organization;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import fr.esiag.isies.pds.businessRules.IBusinessRules;
import fr.esiag.isies.pds.model.referential.organization.Organization;

/**
 * This class provide defined business rules verifications
 * @author Samuel
 * TODO: remove system.out
 *
 */
public class OrganizationBusinessRules implements IBusinessRules<Organization> {	
	/**
	 * 
	 */
	private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationBusinessRules.class);
	Validator validator = new Validator();
	List<ConstraintViolation> violations;
	public boolean verify(Organization item) {
		if(!isValidConstraints(item)){
			return false;
		}
		//rule to verify coords value
		if(!verifyCoords(item)){
			return false;
		}

		//rule to verify that the siret validity
		if(!verifySiret(item.getSiret())){
			return false;
		};

		/**
		 * another business rules to check
		 */
		return true;
	}

	public boolean verifySiret(String siret){
		/**
		 * TODO: will be implemented with the "search function: find by Siret method" 
		 * and will return true if siret is found in database
		 * OrganizationDao to be used
		 */
		if(siret.equals(null)){
			LOGGER.info("Siret should not be null");
		}
		return true;

	}

	public boolean verifyCoords(Organization item){
		if(-90.0 >item.getLatitude() || item.getLatitude() >90.0){
			LOGGER.info("latitude is not between -90.0 and 90.0");
			System.out.println("latitude is not between -90.0 and 90.0");
			return false;
		}
		if(-180.0 >item.getLongitude() || item.getLongitude() >180.0){
			LOGGER.info("longitude is not between -180.0 and 180.0");
			System.out.println("latitude is not between -180.0 and 180.0");
			return false;
		}
		return true;
	}

	public boolean isValidConstraints(Organization bo){
		violations = validator.validate(bo);

		if(violations.size()>0){
			LOGGER.error("Object " + bo + " is invalid.");

			for(ConstraintViolation exception:violations){
				LOGGER.info(exception.getMessage().toString());
				LOGGER.info(exception.getInvalidValue().toString());
				System.out.println(exception.getMessage().toString());
				System.out.println(exception.getInvalidValue().toString());
			}
			return false;
		}
		return true;
	}

}
