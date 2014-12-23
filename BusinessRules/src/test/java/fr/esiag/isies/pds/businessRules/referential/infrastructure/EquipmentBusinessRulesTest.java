package fr.esiag.isies.pds.businessRules.referential.infrastructure;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import mockit.Mocked;
import mockit.NonStrictExpectations;

import org.junit.Before;
import org.junit.Test;

import fr.esiag.isies.pds.businessRules.refential.infrastructure.EquipmentBusinessRules;
import fr.esiag.isies.pds.dao.referential.infrastructure.CategoryRefInfraDao;
import fr.esiag.isies.pds.model.referential.infrastructure.CategoryRefInfra;
import fr.esiag.isies.pds.model.referential.infrastructure.Equipment;
import fr.esiag.isies.pds.model.referential.infrastructure.TypeRefInfra;


public class EquipmentBusinessRulesTest {
	/**
	 * class tested: EquipmentBusinessRules
	 */
	private EquipmentBusinessRules equipmentBR = new EquipmentBusinessRules();

	/**
	 * Valid equipment type (ex: Lit mobile)
	 */
	private TypeRefInfra validTypeRefInfra;

	/**
	 * non valid equipment type
	 */
	private TypeRefInfra errorTypeRefInfra;

	/**
	 * valid category :category == Equipment
	 */
	private CategoryRefInfra validCategoryRefInfra;

	/**
	 * non valid category (ex: Medicine)
	 */
	private CategoryRefInfra errorCategoryRefInfra;

	/**
	 * Valid Equipment
	 */
	private Equipment validEquip;
	/**
	 * Equipment which has a non valid serial number (ex :-+@11)
	 */
	private Equipment errSerialNumber;
	/**
	 * Equipment which is linked to a wrong category (ex: Medicine)
	 */
	private Equipment errTypeRefInfra;
	/**
	 * Equipment which has a non valid label( ex : less than 2 letters)
	 */
	private Equipment errLabelEquip;
	/**
	 * Mocked DAO
	 */
	@Mocked
	CategoryRefInfraDao categoryRefInfraDao;
	
	

	@Before
	public void init() {

		validCategoryRefInfra = new CategoryRefInfra();
		validCategoryRefInfra.setCode("0000000001");
		validCategoryRefInfra.setLabel("EQUIPMENT");
		
		errorCategoryRefInfra = new CategoryRefInfra();
		errorCategoryRefInfra.setCode("00000000002");
		errorCategoryRefInfra.setLabel("Medicine");
		
		validTypeRefInfra = new TypeRefInfra();
		validTypeRefInfra.setCode("1234567890");
		validTypeRefInfra.setLabel("Type d'équipment valide");
		validTypeRefInfra.setCategory(validCategoryRefInfra);
		
		errorTypeRefInfra = new TypeRefInfra();
		errorTypeRefInfra.setCode("0000000004");
		errorTypeRefInfra.setLabel("Type d'équipment non valide");
		errorTypeRefInfra.setCategory(errorCategoryRefInfra);

		validEquip = new Equipment();
		validEquip.setSerialNumber("LM22121493");
		validEquip.setLabel("Lit mobile");
		validEquip.setTypeRefInfra(validTypeRefInfra);

		errSerialNumber = new Equipment();
		errSerialNumber.setSerialNumber("-+@.11");
		errSerialNumber.setLabel("Lit mobile");
		errSerialNumber.setTypeRefInfra(validTypeRefInfra);
		
		
		
		errLabelEquip = new Equipment();
		errLabelEquip.setSerialNumber("LM22121493");
		errLabelEquip.setLabel("l");
		errLabelEquip.setTypeRefInfra(validTypeRefInfra);
		
		errTypeRefInfra = new Equipment();
		errTypeRefInfra.setSerialNumber("LM22121493");
		errTypeRefInfra.setLabel("Salle d'attente");
		errTypeRefInfra.setTypeRefInfra(errorTypeRefInfra);
		
	}

	@Test
	public void testVerify() {
		new NonStrictExpectations(){{
			categoryRefInfraDao.getEquipCategory(); result=validCategoryRefInfra;
		}};
		assertTrue(equipmentBR.verify(validEquip));
		assertFalse(equipmentBR.verify(null));
		assertFalse(equipmentBR.verify(errSerialNumber));
		assertFalse(equipmentBR.verify(errLabelEquip));
		assertFalse(equipmentBR.verify(errTypeRefInfra));
	}

}
