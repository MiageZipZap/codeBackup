package fr.esiag.isies.pds.businessRules.referential.infrastructure;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import mockit.Mocked;
import mockit.NonStrictExpectations;

import org.junit.Before;
import org.junit.Test;

import fr.esiag.isies.pds.businessRules.refential.infrastructure.TypeRefInfraBusinessRules;
import fr.esiag.isies.pds.dao.referential.infrastructure.CategoryRefInfraDao;
import fr.esiag.isies.pds.model.referential.infrastructure.CategoryRefInfra;
import fr.esiag.isies.pds.model.referential.infrastructure.TypeRefInfra;

public class TypeRefInfraBusinessRulesTest {
	
	private TypeRefInfraBusinessRules typeRefInfraBR = new TypeRefInfraBusinessRules();

	/**
	 * Valid typeRefInfra (ex: Lit mobile)
	 */
	private TypeRefInfra validTypeRefInfra;

	/**
	 * non valid equipment type
	 */
	private TypeRefInfra errorLabelTypeRefInfra;
	
	/**
	 * non valid equipment type
	 */
	private TypeRefInfra errorCodeTypeRefInfra;
	
	private TypeRefInfra errorCategoryTypeRefInfra;
	


	/**
	 * valid category :category == Equipment
	 */
	private CategoryRefInfra validCategoryRefInfra;

	/**
	 * non valid category (ex: Medicine)
	 */
	private CategoryRefInfra errorCategoryRefInfra;
	
	/**
	 * Mocked DAO
	 */
	@Mocked
	CategoryRefInfraDao categoryRefInfraDao;
	
	private List<CategoryRefInfra> listCategory ;
	
	@Before
	public void init(){
		
		listCategory = new ArrayList<CategoryRefInfra>();
		
		CategoryRefInfra temp1 = new CategoryRefInfra();
		temp1.setCode("agdkjfjkj");
		temp1.setLabel("Equipement");
		listCategory.add(temp1);
		
		CategoryRefInfra temp2 = new CategoryRefInfra();
		temp2.setCode("agdkjfDDD");
		temp2.setLabel("Infrastructure");
		listCategory.add(temp2);
		
		CategoryRefInfra temp3 = new CategoryRefInfra();
		temp3.setCode("agdkjfOOO");
		temp3.setLabel("Medicament");
		listCategory.add(temp3);
		
		validCategoryRefInfra = new CategoryRefInfra();
		validCategoryRefInfra.setCode("agdkjfjkj");
		validCategoryRefInfra.setLabel("Equipement");
		
		errorCategoryRefInfra = new CategoryRefInfra();
		errorCategoryRefInfra.setCode("abcdefr");
		errorCategoryRefInfra.setLabel("non existant");
		
		validTypeRefInfra = new TypeRefInfra();
		validTypeRefInfra.setCategory(validCategoryRefInfra);
		validTypeRefInfra.setCode("ABCDEFGHTR");
		validTypeRefInfra.setLabel("TOTO");
		
		errorLabelTypeRefInfra = new TypeRefInfra();
		errorLabelTypeRefInfra.setCategory(validCategoryRefInfra);
		errorLabelTypeRefInfra.setCode("ABCDEFGHTR");
		errorLabelTypeRefInfra.setLabel("R");
		
		errorCodeTypeRefInfra = new TypeRefInfra();
		errorCodeTypeRefInfra.setCategory(validCategoryRefInfra);
		errorCodeTypeRefInfra.setCode("AB");
		errorCodeTypeRefInfra.setLabel("TOTO");
		
		errorCategoryTypeRefInfra = new TypeRefInfra();
		errorCategoryTypeRefInfra.setCategory(errorCategoryRefInfra);
		errorCategoryTypeRefInfra.setCode("ABCDEFGHTR");
		errorCategoryTypeRefInfra.setLabel("TOTO");
		
	}
	
	@Test
	public void testVerify(){
		new NonStrictExpectations(){{
			categoryRefInfraDao.getAll(); result=listCategory;
		}};
		assertTrue(typeRefInfraBR.verify(validTypeRefInfra));
		assertFalse(typeRefInfraBR.verify(null));
		assertFalse(typeRefInfraBR.verify(errorCodeTypeRefInfra));
		assertFalse(typeRefInfraBR.verify(errorLabelTypeRefInfra));
		assertFalse(typeRefInfraBR.verify(errorCategoryTypeRefInfra));
	}

}
