package fr.esiag.isies.pds.dao.referential.infrastructure;

import java.util.List;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.esiag.isies.pds.dao.AbstractTypeDao;
import fr.esiag.isies.pds.model.referential.infrastructure.CategoryRefInfra;
import fr.esiag.isies.pds.utils.HibernateUtil;

public class CategoryRefInfraDao extends AbstractTypeDao<CategoryRefInfra> {
	
	/**
	 * Logger
	 */
//	private static final Logger LOGGER = LoggerFactory
//			.getLogger(CategoryRefInfraDao.class);
	
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
		return findByCode("InfraCode1");
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
		return findByCode("equipCode2");
	}
	public CategoryRefInfra getMedicCategory() {
		return findByCode("medicCode3");
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
