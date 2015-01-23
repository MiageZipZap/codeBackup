package fr.esiag.isies.pds.businessRules.referential.infrastructure;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import mockit.Mocked;
import mockit.NonStrictExpectations;

import org.junit.Before;
import org.junit.Test;

import fr.esiag.isies.pds.businessRules.refential.infrastructure.MedicineBusinessRules;
import fr.esiag.isies.pds.dao.referential.infrastructure.CategoryRefInfraDao;
import fr.esiag.isies.pds.model.referential.infrastructure.CategoryRefInfra;
import fr.esiag.isies.pds.model.referential.infrastructure.Medicine;
import fr.esiag.isies.pds.model.referential.infrastructure.TypeRefInfra;

public class MedicineBusinessRulesTest {
	/**
	 * class which is tested
	 */
	private MedicineBusinessRules medicBR = new MedicineBusinessRules();

	/**
	 * Valid type of medicine
	 */
	private TypeRefInfra validTypeRefInfra;

	/**
	 * non valid type of medicine
	 */
	private TypeRefInfra errorTypeRefInfra;

	/**
	 * valid category of medicine=MEDICINE
	 */
	private CategoryRefInfra validCategoryRefInfra;

	/**
	 * non valid category of medicine (ex: EQUIPMENT)
	 */
	private CategoryRefInfra errorCategoryRefInfra;

	/**
	 * Valid medicine item
	 */
	private Medicine validMedic;
	/**
	 * Medicine which has a negative quantity
	 */
	private Medicine errQuantityInfra;
	/**
	 * Infrastructure which a non valid UCDcode
	 */
	private Medicine errUCDcode;
	/**
	 * Medicine which has a type in equipment category
	 */
	private Medicine errTypeInfra;
	/**
	 * Medicine which has a non valid label
	 */
	private Medicine errLabelMedic;
	/**
	 * Mocked DAO
	 */
	@Mocked
	CategoryRefInfraDao cateRefInfraDao;
	

	@Before
	public void init() {

		validCategoryRefInfra = new CategoryRefInfra();
		validCategoryRefInfra.setCode("TOTOTOTOTO");
		validCategoryRefInfra.setLabel("MEDICINE");
		
		errorCategoryRefInfra = new CategoryRefInfra();
		errorCategoryRefInfra.setCode("TITITITITI");
		errorCategoryRefInfra.setLabel("EQUIPMENT");
		
		validTypeRefInfra = new TypeRefInfra();
		validTypeRefInfra.setCode("TOTOTOTOTO");
		validTypeRefInfra.setLabel("Type de médicament valide");
		validTypeRefInfra.setCategory(validCategoryRefInfra);
		
		errorTypeRefInfra = new TypeRefInfra();
		errorTypeRefInfra.setCode("TOTOTOTOTO");
		errorTypeRefInfra.setLabel("Type de médicament non valide");
		errorTypeRefInfra.setCategory(errorCategoryRefInfra);

		validMedic = new Medicine();
		validMedic.setQuantity(2);;
		validMedic.setUcdCode("UCD1234567");
		validMedic.setLabel("Doliprane");
		validMedic.setTypeRefInfra(validTypeRefInfra);

		errQuantityInfra = new Medicine();
		errQuantityInfra.setQuantity(-100);
		errQuantityInfra.setUcdCode("UCD1234567");
		errQuantityInfra.setLabel("Doliprane");
		errQuantityInfra.setTypeRefInfra(validTypeRefInfra);
		
		errUCDcode = new Medicine();
		errUCDcode.setQuantity(2);
		errUCDcode.setUcdCode("1");
		errUCDcode.setLabel("Doliprane");
		errUCDcode.setTypeRefInfra(validTypeRefInfra);
		
		errLabelMedic = new Medicine();
		errLabelMedic.setQuantity(1);
		errLabelMedic.setUcdCode("UCD1234567");
		errLabelMedic.setLabel("D");
		errLabelMedic.setTypeRefInfra(validTypeRefInfra);
		
		errTypeInfra = new Medicine();
		errTypeInfra.setQuantity(1);
		errTypeInfra.setUcdCode("UCD1234567");
		errTypeInfra.setLabel("Doliprane");
		errTypeInfra.setTypeRefInfra(errorTypeRefInfra);
		
	}
	
	

	@Test
	public void testVerify() {
		new NonStrictExpectations(){{
			cateRefInfraDao.getMedicCategory(); result=validCategoryRefInfra;
		}};
		assertTrue(medicBR.verify(validMedic));
		assertFalse(medicBR.verify(null));
		assertFalse(medicBR.verify(errQuantityInfra));
		assertFalse(medicBR.verify(errUCDcode));
		assertFalse(medicBR.verify(errLabelMedic));
		assertFalse(medicBR.verify(errTypeInfra));
		
	}
	
}


