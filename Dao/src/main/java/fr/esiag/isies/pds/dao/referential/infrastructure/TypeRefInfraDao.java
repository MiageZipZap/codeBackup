package fr.esiag.isies.pds.dao.referential.infrastructure;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import fr.esiag.isies.pds.dao.AbstractTypeDao;
import fr.esiag.isies.pds.model.referential.infrastructure.CategoryRefInfra;
import fr.esiag.isies.pds.model.referential.infrastructure.TypeRefInfra;
import fr.esiag.isies.pds.utils.HibernateUtil;

public class TypeRefInfraDao extends AbstractTypeDao<TypeRefInfra>{

	@Override
	public TypeRefInfra getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<TypeRefInfra> getAllByCategory(CategoryRefInfra category) {
		List<TypeRefInfra> lstTypeRefInfra = new ArrayList<TypeRefInfra>();
		List<TypeRefInfra> tmp = getAll();
		for (TypeRefInfra item : tmp) {
			if (item.getCategory().getCode().equals(category.getCode())) {
				lstTypeRefInfra.add(item);
			}
		}
		return lstTypeRefInfra;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TypeRefInfra> getAll() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		List<TypeRefInfra> lst = (List<TypeRefInfra>) session.createCriteria(TypeRefInfra.class).list();
		session.close();
		return lst;
	}

	

}
