package fr.esiag.isies.pds.controller.referential.infrastructure;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import mockit.Mocked;
import mockit.NonStrictExpectations;

import org.junit.Before;
import org.junit.Test;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;

import fr.esiag.isies.pds.businessRules.refential.infrastructure.EquipmentBusinessRules;
import fr.esiag.isies.pds.dao.referential.infrastructure.CategoryRefInfraDao;
import fr.esiag.isies.pds.dao.referential.infrastructure.TypeRefInfraDao;
import fr.esiag.isies.pds.model.referential.infrastructure.CategoryRefInfra;
import fr.esiag.isies.pds.model.referential.infrastructure.Equipment;
import fr.esiag.isies.pds.model.referential.infrastructure.TypeRefInfra;
/**
 * TU for Equipment controller
 * @author PFR,GKA,ODI,MCH
 *
 */
public class EquipmentControllerTest {
	
	@Mocked
	CategoryRefInfraDao categoryRefInfraDao;
	@Mocked
	TypeRefInfraDao typeRefInfraDao;
	@Mocked
	Model model;
	@Mocked
	Equipment equipment;
	/**
	 * Class tested (methods)
	 */
	@Mocked
	EquipmentBusinessRules equipmentBusinessRules;
	
	/**
	 * Mock Spring Security
	 */
	@Mocked SecurityContext securityContext;
	@Mocked Authentication authentication;
	

	CategoryRefInfra category;

	List<TypeRefInfra> lstOfType;

	@Before
	public void init() {
		SecurityContextHolder.setContext(securityContext);
		
		category = new CategoryRefInfra();
		category.setCode("TEST BIS EQUIPMENT");
		category.setId(1);
		category.setLabel("EQUIPMENT");

		TypeRefInfra t1 = new TypeRefInfra();

		t1.setCategory(category);
		t1.setCode("XXXX010203");
		t1.setId(1);
		t1.setLabel("Lit mobile");
		lstOfType = new ArrayList<TypeRefInfra>();
		lstOfType.add(t1);
	}

	EquipmentController equipmentController = new EquipmentController();
/**
 * Here it's tested if the controller can display the equipment creation page
 */
	@Test
	public void testGetCreateForm() {
		assertEquals(equipmentController.getCreateForm(model),
				"ref/infra/createEquip");
	}
/**
 * Here it's tested the creation of a new equipment, since there are no Business rules
 * the only method of this class "verify" return TRUE
 */
	@Test
	public void testCreate() {
		new NonStrictExpectations() {{
			securityContext.getAuthentication(); result = authentication;
			authentication.getName(); result = "test-unitaire";
			equipmentBusinessRules.verify(equipment); result = true;
		}};
		assertEquals(equipmentController.create(equipment, model),"ref/infra/createEquipmentConfirm");
	}

}
