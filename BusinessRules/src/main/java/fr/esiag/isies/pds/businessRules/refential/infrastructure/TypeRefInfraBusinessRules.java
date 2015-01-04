package fr.esiag.isies.pds.businessRules.refential.infrastructure;

import fr.esiag.isies.pds.businessRules.ITypeBusinessRules;
import fr.esiag.isies.pds.dao.referential.infrastructure.CategoryRefInfraDao;
import fr.esiag.isies.pds.model.referential.infrastructure.CategoryRefInfra;
import fr.esiag.isies.pds.model.referential.infrastructure.TypeRefInfra;

public class TypeRefInfraBusinessRules implements ITypeBusinessRules<TypeRefInfra> {

	private CategoryRefInfraDao cateRefInfraDao = new CategoryRefInfraDao();

	public boolean verify(TypeRefInfra item) {

		if (item == null) {
			return false;
		}

		if (item.getLabel().length() < 2 || item.getLabel().length() > 255) {
			return false;
		}

		if (item.getCode().length() != 10) {
			return false;
		}

		boolean test = false;

		for (CategoryRefInfra cat : cateRefInfraDao.getAll()) {

			if (item.getCategory().getCode().equals(cat.getCode())) {
				test = true;
			}
		}

		if (!test) {
			return false;
		}

		return true;
	}

}
