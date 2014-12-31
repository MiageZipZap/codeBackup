package fr.esiag.isies.pds.businessRules.referential.organization;

import java.util.List;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import fr.esiag.isies.pds.businessRules.ITypeBusinessRules;
import fr.esiag.isies.pds.model.referential.organization.OrgaType;
/**
 * This class provide defined business rules verifications for organization Model
 * @author JLA SKO OSA ADA JSB
 * TODO: remove system.out
 *
 */
public class OrgaTypeBusinessRules implements ITypeBusinessRules<OrgaType> {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrgaTypeBusinessRules.class);
	Validator validator = new Validator();
	List<ConstraintViolation> violations;
	
	public boolean verify(OrgaType item) {
		return false;
	}

	
	public boolean isValidConstraints(OrgaType ot){
		violations = validator.validate(ot);

		if(violations.size()>0){
			LOGGER.error("Object " + ot + " is invalid.");

			for(ConstraintViolation exception:violations){
				LOGGER.info(exception.getMessage().toString());
				LOGGER.info(exception.getInvalidValue().toString());
				System.out.println(exception.getMessage().toString());
				System.out.println(exception.getInvalidValue().toString());
			}
		}
			return false;
	}
}
