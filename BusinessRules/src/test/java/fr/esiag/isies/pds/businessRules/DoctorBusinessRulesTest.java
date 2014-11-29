package fr.esiag.isies.pds.businessRules;

import junit.framework.TestCase;
import fr.esiag.isies.pds.model.actor.Doctor;

public class DoctorBusinessRulesTest extends TestCase{

	public void testVerify(){
		DoctorBusinessRules br = new DoctorBusinessRules();
		Doctor d = new Doctor();
		
		assertFalse(br.verify(d));
		
		d.setFirstname("toto");
		assertTrue(br.verify(d));
	}
}
