package fr.esiag.isies.pds.businessRules.referential.organization;

import java.util.ArrayList;
import java.util.List;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;




import fr.esiag.isies.pds.businessRules.ITypeBusinessRules;
import fr.esiag.isies.pds.dao.referential.organization.OrgaTypeDao;
import fr.esiag.isies.pds.model.referential.organization.OrgaType;
/**
 * This class provide defined business rules verifications for organization Model
 * @author JLA SKO OSA ADA JSB
 * 
 *
 */
public class OrgaTypeBusinessRules implements ITypeBusinessRules<OrgaType> {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrgaTypeBusinessRules.class);
	Validator validator = new Validator();
	List<ConstraintViolation> violations;
	private OrgaTypeDao orgaTypeDAO = new OrgaTypeDao();
	List<String> messages = new ArrayList<String>();

	public boolean verify(OrgaType item) {
		if(!isValidConstraints(item)){
			return false;
		}
		return true;
	}


	public boolean isValidConstraints(OrgaType ot){
		OrgaType o= orgaTypeDAO.getById(ot.getId());
		violations = validator.validate(o);

		if(violations.size()>0){
			LOGGER.error("Object " + o + " is invalid.");
			messages.add("Object " + o + " is invalid.");

			for(ConstraintViolation exception:violations){
				try{
					LOGGER.info(exception.getMessage().toString());
					LOGGER.info(exception.getInvalidValue().toString());
					messages.add(exception.getMessage().toString() +""+exception.getInvalidValue().toString());
				}catch(Exception e){
					LOGGER.info("Validation fails! Print violation exception: could not print ");
					messages.add("Validation fails! Print violation exception: could not print ");
				}
			}
			return false;	
		}
		return true;
	}


	public List<String> getMessages() {
		return messages;
	}


	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
	
	
}
