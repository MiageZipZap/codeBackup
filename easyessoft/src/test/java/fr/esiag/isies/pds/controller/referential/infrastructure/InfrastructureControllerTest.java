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

import fr.esiag.isies.pds.businessRules.refential.infrastructure.InfrastructureBusinessRules;
import fr.esiag.isies.pds.dao.referential.infrastructure.CategoryRefInfraDao;
import fr.esiag.isies.pds.dao.referential.infrastructure.TypeRefInfraDao;
import fr.esiag.isies.pds.model.referential.infrastructure.CategoryRefInfra;
import fr.esiag.isies.pds.model.referential.infrastructure.Infrastructure;
import fr.esiag.isies.pds.model.referential.infrastructure.TypeRefInfra;

public class InfrastructureControllerTest {

	@Mocked
	CategoryRefInfraDao categoryRefInfraDao;
	@Mocked
	TypeRefInfraDao typeRefInfraDao;
	@Mocked
	Model model;
	@Mocked
	Infrastructure infrastructure;
	@Mocked
	InfrastructureBusinessRules infrastructureBusinessRules;
	
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
		category.setLabel("INFRASTRUCTURE");

		TypeRefInfra t1 = new TypeRefInfra();

		t1.setCategory(category);
		t1.setCode("TOTO");
		t1.setId(1);
		t1.setLabel("BOX");
		lstOfType = new ArrayList<TypeRefInfra>();
		lstOfType.add(t1);
	}

	InfrastructureController infraController = new InfrastructureController();

	@Test
	public void testGetCreateForm() {
		assertEquals(infraController.getCreateForm(model),
				"ref/infra/createInfra");
	}

	@Test
	public void testCreate() {
		new NonStrictExpectations() {{
			securityContext.getAuthentication(); result = authentication;
			authentication.getName(); result = "test-unitaire";
			infrastructureBusinessRules.verify(infrastructure); result = true;
		}};
		assertEquals(infraController.create(infrastructure, model),"ref/infra/createInfraConfirm");
		
		new NonStrictExpectations() {{
			securityContext.getAuthentication(); result = authentication;
			authentication.getName(); result = "test-unitaire";
			infrastructureBusinessRules.verify(infrastructure); result = false;
		}};
		assertEquals(infraController.create(infrastructure, model),null);
	}
}
