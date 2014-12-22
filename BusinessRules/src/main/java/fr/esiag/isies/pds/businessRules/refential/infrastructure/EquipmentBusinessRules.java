package fr.esiag.isies.pds.businessRules.refential.infrastructure;

import fr.esiag.isies.pds.businessRules.IBusinessRules;
import fr.esiag.isies.pds.model.referential.infrastructure.Equipment;

/**
* Class which list all the business rules for the Equipment referential management
* @author ODI, GKA, MCH, PFR
*
*/
public class EquipmentBusinessRules implements IBusinessRules<Equipment> {

	public boolean verify(Equipment item) {
		return true;
	}
}
