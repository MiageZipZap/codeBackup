package fr.esiag.isies.pds.model.actor;

import fr.esiag.isies.pds.model.Doctor;
import junit.framework.TestCase;

public class DoctorTest extends TestCase{

	public void testGetSurname() {
		Doctor d = new Doctor();
		d.setSurname("Koulibali");
		assertEquals("Koulibali",d.getSurname());
	}

}
