package fr.esiag.isies.pds.controller.referential.infrastructure;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import mockit.Mocked;
import mockit.NonStrictExpectations;

import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.Model;

import fr.esiag.isies.pds.businessRules.refential.infrastructure.TypeRefInfraBusinessRules;
import fr.esiag.isies.pds.dao.referential.infrastructure.CategoryRefInfraDao;
import fr.esiag.isies.pds.model.referential.infrastructure.CategoryRefInfra;
import fr.esiag.isies.pds.model.referential.infrastructure.TypeRefInfra;

/**
 * TU for Type Referential Infrastructure controller
 * @author PFR,GKA,ODI,MCH
 *
 */
public class TypeRefInfraControllerTest {

	@Mocked
	CategoryRefInfraDao categoryRefInfraDao;
	
	@Mocked
	Model model;
	@Mocked
	TypeRefInfra typeRefInfra;
	/**
	 * Class tested (methods)
	 */
	@Mocked
	TypeRefInfraBusinessRules typeRefInfraBusinessRules;
	

	CategoryRefInfra category;

	List<CategoryRefInfra> lstOfCategory;

	@Before
	public void init() {
		
		category = new CategoryRefInfra();
		category.setCode("Type");
		category.setId(1);
		category.setLabel("TypeRefInfra");


		lstOfCategory = new ArrayList<CategoryRefInfra>();
		lstOfCategory.add(category);
	}

	TypeRefInfraController typeRefInfraController = new TypeRefInfraController();
/**
 * Here it's tested if the controller can display the TypeRefInfra creation page
 */
	@Test
	public void testGetCreateForm() {
		assertEquals(typeRefInfraController.getCreateForm(model),
				"ref/infra/createTypeRefInfra");
	}
/**
 * Here it's tested the creation of a new Type Referential infrastructure, since there are no Business rules
 * the only method of this class "verify" return TRUE
 */
	@Test
	public void testCreate() {
		new NonStrictExpectations() {{
			
			typeRefInfraBusinessRules.verify(typeRefInfra); result = true;
		}};
		assertEquals(typeRefInfraController.create(typeRefInfra, model),"ref/infra/createTypeRefInfraConfirm");
		new NonStrictExpectations() {{
			
			typeRefInfraBusinessRules.verify(typeRefInfra); result = false;
		}}; 
		assertEquals(typeRefInfraController.create(typeRefInfra, model),"ref/infra/createTypeRefInfra");
	}

}
