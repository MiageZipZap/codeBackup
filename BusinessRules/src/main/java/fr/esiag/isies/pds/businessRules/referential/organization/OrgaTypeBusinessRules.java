package fr.esiag.isies.pds.businessRules.referential.organization;

import fr.esiag.isies.pds.businessRules.ITypeBusinessRules;
import fr.esiag.isies.pds.model.referential.organization.OrgaType;

public class OrgaTypeBusinessRules implements ITypeBusinessRules<OrgaType> {
	
	public boolean verify(OrgaType item) {
		return false;
	}

}
