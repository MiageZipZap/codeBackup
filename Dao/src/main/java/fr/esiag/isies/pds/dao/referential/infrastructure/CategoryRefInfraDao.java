package fr.esiag.isies.pds.dao.referential.infrastructure;

import java.util.ArrayList;
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
	 * Get TypeRefInfra Category
	 * @return
	 */
	public CategoryRefInfra getEquipCategory() {
		CategoryRefInfra categoryRefInfra = new CategoryRefInfra();
		categoryRefInfra.setId(2);
		categoryRefInfra.setCode("XXXINFTYP2");
		categoryRefInfra.setLabel("Equipement");
		return categoryRefInfra;
	}
	public CategoryRefInfra getMedicCategory() {
		CategoryRefInfra categoryRefInfra = new CategoryRefInfra();
		categoryRefInfra.setId(3);
		categoryRefInfra.setCode("XXXMED0001");
		categoryRefInfra.setLabel("Medicament");
		return categoryRefInfra;
	}
	

	@Override
	public List<CategoryRefInfra> getAll() {
		
		List<CategoryRefInfra> lst = new ArrayList<CategoryRefInfra>();
		lst.add(getEquipCategory());
		lst.add(getInfraCategory());
		lst.add(getMedicCategory());
		
		return lst;
	}
}
