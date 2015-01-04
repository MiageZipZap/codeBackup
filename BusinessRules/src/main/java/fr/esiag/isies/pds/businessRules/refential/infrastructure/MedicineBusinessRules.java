package fr.esiag.isies.pds.businessRules.refential.infrastructure;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import fr.esiag.isies.pds.businessRules.IBusinessRules;
import fr.esiag.isies.pds.dao.referential.infrastructure.CategoryRefInfraDao;
import fr.esiag.isies.pds.model.referential.infrastructure.Medicine;

/**
 * Class which list all the business rules for the medicine referential
 * management
 * @author GKA, PFR, ODI, MCH
 *
 */
public class MedicineBusinessRules implements IBusinessRules<Medicine> {

	public CategoryRefInfraDao cateRefInfraDao = new CategoryRefInfraDao();
	private Pattern pattern;  
	private Matcher matcher;  
	private String ucdCode_PATTERN = "[0-9]{7}";
	private String ucdCode_Numeric;
	private String ucdCode_prefix;
	

	public boolean verify(Medicine item) {


			if (item == null) {
				return false;
			}
			
			/**
			 * if the ucdCode is not composed of 7 integer + prefix=UCD return false
			 */
		
				ucdCode_prefix=item.getUcdCode().substring(0,3);
				ucdCode_Numeric=item.getUcdCode().substring(3);
				
				pattern = Pattern.compile(ucdCode_PATTERN);
				matcher = pattern.matcher(ucdCode_Numeric); 
				if (!matcher.matches() && ucdCode_prefix !="UCD"){
					return false;
				}
			
			
			/**
			 * if the label length is inferior than 2 or superior than 255 return false
			 */
			if (item.getLabel().length() > 255 || item.getLabel().length() < 2) {
				return false;
			}
			
			/**
			 * If the quantity is null return false
			 */
			if(item.getQuantity().toString().length() < 1 || item.getQuantity()<=0) {
				return false;
			}

			if (!item.getTypeRefInfra().getCategory().getCode()
					.equals(cateRefInfraDao.getMedicCategory().getCode())) {
				return false;
			}

			return true;

		
	}

}
