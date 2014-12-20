package fr.esiag.isies.pds.dao.referential.infrastructure;

import java.util.List;

import fr.esiag.isies.pds.dao.AbstractTypeDao;
import fr.esiag.isies.pds.model.referential.infrastructure.CategoryRefInfra;

public class CategoryRefInfraDao extends AbstractTypeDao<CategoryRefInfra> {

	@Override
	public CategoryRefInfra getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * Get Infrastructure Category
	 * @return
	 */
	public CategoryRefInfra getInfraCategory() {
		CategoryRefInfra categoryRefInfra = new CategoryRefInfra();
		categoryRefInfra.setId(1);
		categoryRefInfra.setCode("XXXINFTYP1");
		categoryRefInfra.setLabel("Infrastructure");
		return categoryRefInfra;
	}
	
	/**
	 * Get Equipment Category
	 * @return
	 */
	public CategoryRefInfra getEquipCategory() {
		CategoryRefInfra categoryRefInfra = new CategoryRefInfra();
		categoryRefInfra.setId(2);
		categoryRefInfra.setCode("XXXINFTYP2");
		categoryRefInfra.setLabel("Equipement");
		return categoryRefInfra;
	}

	@Override
	public List<CategoryRefInfra> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
