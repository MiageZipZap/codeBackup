package fr.esiag.isies.pds.businessRules.refential.infrastructure;

import fr.esiag.isies.pds.businessRules.IBusinessRules;
import fr.esiag.isies.pds.dao.referential.infrastructure.CategoryRefInfraDao;
import fr.esiag.isies.pds.model.referential.infrastructure.Infrastructure;

/**
 * Class which list all the business rules for the Infrastructure referential
 * management
 * 
 * @author ODI, GKA, MCH, PFR
 *
 */
public class InfrastructureBusinessRules implements
		IBusinessRules<Infrastructure> {

	public CategoryRefInfraDao cateRefInfraDao = new CategoryRefInfraDao();

	public boolean verify(Infrastructure item) {

		if (item == null) {
			return false;
		}

		if (item.getCapacity() < 1) {
			return false;
		}

		if (item.getCode().length() != 10) {
			return false;
		}

		if (item.getLabel().length() > 255 || item.getLabel().length() < 2) {
			return false;
		}

		if (!item.getTypeRefInfra().getCategory().getCode()
				.equals(cateRefInfraDao.getInfraCategory().getCode())) {
			return false;
		}

		return true;

	}
}
