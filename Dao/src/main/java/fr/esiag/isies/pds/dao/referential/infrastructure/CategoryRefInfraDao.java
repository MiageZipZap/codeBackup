package fr.esiag.isies.pds.dao.referential.infrastructure;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.hibernate.Session;

import fr.esiag.isies.pds.dao.AbstractTypeDao;
import fr.esiag.isies.pds.model.referential.infrastructure.CategoryRefInfra;
import fr.esiag.isies.pds.utils.HibernateUtil;

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
		return findByCode(properties.getProperty("infrastructure.category.code"));
//		CategoryRefInfra categoryRefInfra = new CategoryRefInfra();
//		categoryRefInfra.setId(1);
//		categoryRefInfra.setCode("XXXINFTYP1");
//		categoryRefInfra.setLabel("Infrastructure");
//		return categoryRefInfra;
	}
	
	/**
	 * Get CategoryRefInfra by code
	 * @param code
	 * @return
	 */
	private CategoryRefInfra findByCode(String code) {
		List<CategoryRefInfra> tmp = getAll();
		for (CategoryRefInfra item : tmp) {
			if (item.getCode().equals(code)) {
				return item;
			}
		}
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
	

	@SuppressWarnings("unchecked")
	@Override
	public List<CategoryRefInfra> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		return (List<CategoryRefInfra>) session.createCriteria(CategoryRefInfra.class).list();
	}
}
