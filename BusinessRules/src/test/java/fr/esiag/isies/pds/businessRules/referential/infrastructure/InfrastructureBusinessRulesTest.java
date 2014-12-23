package fr.esiag.isies.pds.businessRules.referential.infrastructure;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import mockit.Mocked;
import mockit.NonStrictExpectations;

import org.junit.Before;
import org.junit.Test;

import fr.esiag.isies.pds.businessRules.refential.infrastructure.InfrastructureBusinessRules;
import fr.esiag.isies.pds.dao.referential.infrastructure.CategoryRefInfraDao;
import fr.esiag.isies.pds.model.referential.infrastructure.CategoryRefInfra;
import fr.esiag.isies.pds.model.referential.infrastructure.Infrastructure;
import fr.esiag.isies.pds.model.referential.infrastructure.TypeRefInfra;

public class InfrastructureBusinessRulesTest {

	/**
	 * class which is tested
	 */
	private InfrastructureBusinessRules infraBR = new InfrastructureBusinessRules();

	/**
	 * Valid type of infrastructure
	 */
	private TypeRefInfra validTypeRefInfra;

	/**
	 * non valid type of infrastructure
	 */
	private TypeRefInfra errorTypeRefInfra;

	/**
	 * valid category of infrastructure
	 */
	private CategoryRefInfra validCategoryRefInfra;

	/**
	 * non valid category of infrastructure
	 */
	private CategoryRefInfra errorCategoryRefInfra;

	/**
	 * Valid Infrastructure
	 */
	private Infrastructure validInfra;
	/**
	 * Infrastructure wich has a negative capacity
	 */
	private Infrastructure errCapacityInfra;
	/**
	 * Infrastructure which a non valid code
	 */
	private Infrastructure errCodeInfra;
	/**
	 * Infrastructure which has a type in equipment category
	 */
	private Infrastructure errTypeInfra;
	/**
	 * Infrastructure which has a non valid label
	 */
	private Infrastructure errLabelInfra;
	/**
	 * Mocked DAO
	 */
	@Mocked
	CategoryRefInfraDao categoryRefInfraDao;

	@Before
	public void init() {

		validCategoryRefInfra = new CategoryRefInfra();
		validCategoryRefInfra.setCode("TOTOTOTOTO");
		validCategoryRefInfra.setLabel("Infrastructure");
		
		errorCategoryRefInfra = new CategoryRefInfra();
		errorCategoryRefInfra.setCode("TITITITITI");
		errorCategoryRefInfra.setLabel("Equipement");
		
		validTypeRefInfra = new TypeRefInfra();
		validTypeRefInfra.setCode("TOTOTOTOTO");
		validTypeRefInfra.setLabel("Type d'infrastructure valide");
		validTypeRefInfra.setCategory(validCategoryRefInfra);
		
		errorTypeRefInfra = new TypeRefInfra();
		errorTypeRefInfra.setCode("TOTOTOTOTO");
		errorTypeRefInfra.setLabel("Type d'infrastructure valide");
		errorTypeRefInfra.setCategory(errorCategoryRefInfra);

		validInfra = new Infrastructure();
		validInfra.setCapacity(1);
		validInfra.setCode("1231231230");
		validInfra.setLabel("Salle d'attente");
		validInfra.setTypeRefInfra(validTypeRefInfra);

		errCapacityInfra = new Infrastructure();
		errCapacityInfra.setCapacity(-1);
		errCapacityInfra.setCode("1231231230");
		errCapacityInfra.setLabel("Salle d'attente");
		errCapacityInfra.setTypeRefInfra(validTypeRefInfra);
		
		errCodeInfra = new Infrastructure();
		errCodeInfra.setCapacity(1);
		errCodeInfra.setCode("12312310");
		errCodeInfra.setLabel("Salle d'attente");
		errCodeInfra.setTypeRefInfra(validTypeRefInfra);
		
		errLabelInfra = new Infrastructure();
		errLabelInfra.setCapacity(1);
		errLabelInfra.setCode("1231231230");
		errLabelInfra.setLabel("S");
		errLabelInfra.setTypeRefInfra(validTypeRefInfra);
		
		errTypeInfra = new Infrastructure();
		errTypeInfra.setCapacity(1);
		errTypeInfra.setCode("1231231230");
		errTypeInfra.setLabel("Salle d'attente");
		errTypeInfra.setTypeRefInfra(errorTypeRefInfra);
		
	}
	
	

	@Test
	public void testVerify() {
		new NonStrictExpectations(){{
			categoryRefInfraDao.getInfraCategory(); result=validCategoryRefInfra;
		}};
		assertTrue(infraBR.verify(validInfra));
		assertFalse(infraBR.verify(null));
		assertFalse(infraBR.verify(errCapacityInfra));
		assertFalse(infraBR.verify(errCodeInfra));
		assertFalse(infraBR.verify(errLabelInfra));
		assertFalse(infraBR.verify(errTypeInfra));
		
	}
	
}
