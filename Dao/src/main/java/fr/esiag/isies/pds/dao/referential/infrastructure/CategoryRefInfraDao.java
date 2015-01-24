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
	}
	
	/**
	 * Get CategoryRefInfra by code
	 * @param code
	 * @return
	 */
	public CategoryRefInfra findByCode(String code) {
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
		return findByCode(properties.getProperty("equipment.category.code"));
	}
	public CategoryRefInfra getMedicCategory() {
		return findByCode(properties.getProperty("medicine.category.code"));
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<CategoryRefInfra> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<CategoryRefInfra> lst = (List<CategoryRefInfra>) session.createCriteria(CategoryRefInfra.class).list();
		session.close();
		return lst;
	}
}
