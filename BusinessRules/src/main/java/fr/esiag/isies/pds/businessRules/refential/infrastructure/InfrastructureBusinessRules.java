package fr.esiag.isies.pds.businessRules.refential.infrastructure;

import fr.esiag.isies.pds.businessRules.IBusinessRules;
import fr.esiag.isies.pds.model.referential.infrastructure.Infrastructure;

/**
 *Class which list all the business rules for the Infrastructure referential management
 * @author ODI, GKA, MCH, PFR
 *
 */
public class InfrastructureBusinessRules implements IBusinessRules<Infrastructure> {

	public boolean verify(Infrastructure item) {
		return true;
	}
	
}
