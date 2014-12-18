package fr.esiag.isies.pds.dao.referential.infrastructure;

import java.util.ArrayList;
import java.util.List;

import fr.esiag.isies.pds.dao.AbstractTypeDao;
import fr.esiag.isies.pds.model.referential.infrastructure.CategoryRefInfra;
import fr.esiag.isies.pds.model.referential.infrastructure.TypeRefInfra;

public class TypeRefInfraDao extends AbstractTypeDao<TypeRefInfra>{

	@Override
	public TypeRefInfra getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<TypeRefInfra> getAllByCategory(CategoryRefInfra category) {
		List<TypeRefInfra> lstTypeRefInfra = new ArrayList<TypeRefInfra>();
		TypeRefInfra typeRefInfra = new TypeRefInfra();
		typeRefInfra.setCategory(category);
		typeRefInfra.setCode("XXSALEX001");
		typeRefInfra.setLabel("Salle d'examen");
		typeRefInfra.setId(1);
		typeRefInfra.setCategory(category);
		TypeRefInfra typeRefInfra2 = new TypeRefInfra();
		typeRefInfra2.setCategory(category);
		typeRefInfra2.setCode("XXSALSL002");
		typeRefInfra2.setLabel("Salle de soins lourds");
		typeRefInfra2.setId(2);
		typeRefInfra2.setCategory(category);
		typeRefInfra2.setCode("XXXWW02LIT");
		typeRefInfra2.setLabel("Lit électrique");
		lstTypeRefInfra.add(typeRefInfra);
		lstTypeRefInfra.add(typeRefInfra2);
		return lstTypeRefInfra;
	}

	

}
