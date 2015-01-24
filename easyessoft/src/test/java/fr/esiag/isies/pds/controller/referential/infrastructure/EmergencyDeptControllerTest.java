package fr.esiag.isies.pds.controller.referential.infrastructure;

import static org.junit.Assert.assertEquals;
import mockit.Mocked;

import org.junit.Test;
import org.springframework.ui.Model;

import fr.esiag.isies.pds.dao.referential.infrastructure.EquipmentDao;
import fr.esiag.isies.pds.dao.referential.infrastructure.InfrastructureDao;
import fr.esiag.isies.pds.dao.referential.infrastructure.MedicineDao;
import fr.esiag.isies.pds.dao.referential.organization.OrganizationDao;

public class EmergencyDeptControllerTest {
	EmergencyDeptController controller = new EmergencyDeptController();
	
	@Mocked Model model;
	@Mocked InfrastructureDao infrastrucureDao;
	@Mocked EquipmentDao equipmentDao;
	@Mocked MedicineDao medicineDao;
	@Mocked OrganizationDao organizationDao;
	
	@Test
	public void testGetHomePage() {
		assertEquals(controller.getHomePage(model), "ref/infra/emergencyDeptHomePage");
	}
	
	@Test
	public void testRead() {
		assertEquals(controller.read(1, model), "ref/infra/read");
	}
}
