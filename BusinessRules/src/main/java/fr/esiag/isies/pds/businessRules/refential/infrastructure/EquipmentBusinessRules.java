package fr.esiag.isies.pds.businessRules.refential.infrastructure;

import fr.esiag.isies.pds.businessRules.IBusinessRules;
import fr.esiag.isies.pds.model.referential.infrastructure.Equipment;

/**
*
* @author ODI, GKA, MCH, PFR
*
*/
public class EquipmentBusinessRules implements IBusinessRules<Equipment> {

	public boolean verify(Equipment item) {
		return true;
	}
}
