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

import fr.esiag.isies.pds.businessRules.refential.infrastructure.MedicineBusinessRules;
import fr.esiag.isies.pds.dao.referential.infrastructure.CategoryRefInfraDao;
import fr.esiag.isies.pds.dao.referential.infrastructure.TypeRefInfraDao;
import fr.esiag.isies.pds.model.referential.infrastructure.CategoryRefInfra;
import fr.esiag.isies.pds.model.referential.infrastructure.Medicine;
import fr.esiag.isies.pds.model.referential.infrastructure.TypeRefInfra;

public class MedicineControllerTest {

	@Mocked
	CategoryRefInfraDao categoryRefInfraDao;
	@Mocked
	TypeRefInfraDao typeRefInfraDao;
	@Mocked
	Model model;
	@Mocked
	Medicine medicine;
	@Mocked
	MedicineBusinessRules medicineBusinessRules;
	
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
		category.setCode("TEST");
		category.setId(1);
		category.setLabel("MEDICINE");

		TypeRefInfra t1 = new TypeRefInfra();

		t1.setCategory(category);
		t1.setCode("MMMM000010");
		t1.setId(1);
		t1.setLabel("Doliprane");
		lstOfType = new ArrayList<TypeRefInfra>();
		lstOfType.add(t1);
	}

	MedicineController medicineController = new MedicineController();

	@Test
	public void testGetCreateForm() {
		assertEquals(medicineController.getCreateForm(model),
				"ref/infra/createMedicine");
	}

	@Test
	public void testCreate() {
		new NonStrictExpectations() {{
			securityContext.getAuthentication(); result = authentication;
			authentication.getName(); result = "test-unitaire";
			medicineBusinessRules.verify(medicine); result = true;
		}};
		assertEquals(medicineController.create(medicine, model),"ref/infra/createMedicineConfirm");
		
		new NonStrictExpectations() {{
			securityContext.getAuthentication(); result = authentication;
			authentication.getName(); result = "test-unitaire";
			medicineBusinessRules.verify(medicine); result = false;
		}}; 
		assertEquals(medicineController.create(medicine, model),null);
	}
}
