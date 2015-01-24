package fr.esiag.isies.pds.dao.referential.infrastructure;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import fr.esiag.isies.pds.dao.AbstractTypeDao;
import fr.esiag.isies.pds.model.referential.infrastructure.CategoryRefInfra;

public class CategoryRefInfraDao extends AbstractTypeDao<CategoryRefInfra> {
	
	/**
	 * Properties wich has code of different categories
	 */
	private final Properties properties;
	
	public CategoryRefInfraDao() {
		properties = new Properties();
		try {
			properties.load(this.getClass().getClassLoader().getResourceAsStream("data-category-ref-infra.properties"));
		} catch (IOException e) {
			// TODO LOGGER
			e.printStackTrace();
		}
	}
	
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
		//return findByCode(properties.getProperty("infrastructure.category.code"));
		CategoryRefInfra categoryRefInfra = new CategoryRefInfra();
		categoryRefInfra.setId(1);
		categoryRefInfra.setCode("XXXINFTYP1");
		categoryRefInfra.setLabel("Infrastructure");
		return categoryRefInfra;
	}
	
	/**
	 * Get CategoryRefInfra by code
	 * @param code
	 * @return
	 */
	private CategoryRefInfra findByCode(String code) {
		//TODO Hibernate
		return null;
	}
	
	/**
	 * Get TypeRefInfra Category
	 * @return
	 */
	public CategoryRefInfra getEquipCategory() {
		return findByCode(properties.getProperty("infrastructure.category.code"));
//		CategoryRefInfra categoryRefInfra = new CategoryRefInfra();
//		categoryRefInfra.setId(2);
//		categoryRefInfra.setCode("XXXINFTYP2");
//		categoryRefInfra.setLabel("Equipement");
//		return categoryRefInfra;
	}
	public CategoryRefInfra getMedicCategory() {
		return findByCode(properties.getProperty("infrastructure.category.code"));
//		CategoryRefInfra categoryRefInfra = new CategoryRefInfra();
//		categoryRefInfra.setId(3);
//		categoryRefInfra.setCode("XXXMED0001");
//		categoryRefInfra.setLabel("Medicament");
//		return categoryRefInfra;
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
