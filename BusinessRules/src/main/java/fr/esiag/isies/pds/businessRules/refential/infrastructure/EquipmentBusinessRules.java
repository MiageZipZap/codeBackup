package fr.esiag.isies.pds.businessRules.refential.infrastructure;

import fr.esiag.isies.pds.businessRules.IBusinessRules;
import fr.esiag.isies.pds.dao.referential.infrastructure.CategoryRefInfraDao;
import fr.esiag.isies.pds.model.referential.infrastructure.Equipment;

/**
 * Class which list all the business rules for the Equipment referential
 * management
 * 
 * @author ODI, GKA, MCH, PFR
 *
 */
public class EquipmentBusinessRules implements IBusinessRules<Equipment> {
	
	public CategoryRefInfraDao cateRefInfraDao = new CategoryRefInfraDao();  

	public boolean verify(Equipment item) {

		if (item == null) {
			return false;
		}

		if (item.getLabel().length() < 2 || item.getLabel().length() > 255) {
			return false;
		}

		if (item.getSerialNumber().length() != 10) {
			return false;
		}

		if (!item.getTypeRefInfra().getCategory().equals(cateRefInfraDao.getEquipCategory())){
			return false;
		}
		
		
	
		return true;
	}
}
