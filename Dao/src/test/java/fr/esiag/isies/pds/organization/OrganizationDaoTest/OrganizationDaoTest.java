package fr.esiag.isies.pds.organization.OrganizationDaoTest;

import junit.framework.TestCase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.esiag.isies.pds.dao.referential.organization.OrganizationDao;
import fr.esiag.isies.pds.model.referential.organization.Hospital;
import fr.esiag.isies.pds.model.referential.organization.OrgaType;
/**
 * Test all method of administration DAO
 * @author SKO JLA OSA ADA JSB
 *
 */
public class OrganizationDaoTest extends TestCase {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationDaoTest.class);
	//main class wich we do all 
	public void testOrganizationDao(){
		LOGGER.info("Start TU for create organization");
		//Create an organisation type for hospital
		OrgaType hospitalOrgaType = new OrgaType();
		hospitalOrgaType.setLegalStatus("publique");
		//Create an object which we send in bdd
		Hospital myHospital = new Hospital();
		myHospital.setFiness("94000001");
		myHospital.setSiret("94000000000000");
		myHospital.setName("Hospital a");	
		myHospital.setStreetNumber(10);
		myHospital.setOrgaType(hospitalOrgaType);
		myHospital.setStreetName("rue saint simon");
		myHospital.setZipCode("94000");
		myHospital.setCity("Creteil");
		myHospital.setPhone("0102030405");
		myHospital.setFax("0607080910");
		myHospital.setEmail("user@hospital.fr");
		myHospital.setLatitude((float) 123432.454222);
		myHospital.setLongitude((float) 122.454345676543);
		//Send myHospital to bdd
		Hospital baseHospital = (Hospital) new OrganizationDao().create(myHospital);
		//Control if object is added in bdd with id
		assertNotNull(baseHospital.getId());
		//Control if all informations has added and if attributs are exactly added
		assertEquals(myHospital.getFiness(),baseHospital.getFiness());
		assertEquals(myHospital.getSiret(),baseHospital.getSiret());
		assertEquals(myHospital.getName(),baseHospital.getName());
		assertEquals(myHospital.getStreetNumber(),baseHospital.getStreetNumber());
		assertEquals(myHospital.getZipCode(),baseHospital.getZipCode());
		assertEquals(myHospital.getCity(),baseHospital.getCity());
		assertEquals(myHospital.getPhone(),baseHospital.getPhone());
		assertEquals(myHospital.getFax(),baseHospital.getFax());
		assertEquals(myHospital.getLatitude(),baseHospital.getLatitude());
		assertEquals(myHospital.getEmail(),baseHospital.getEmail());
		assertEquals(myHospital.getLongitude(),baseHospital.getLongitude());
		LOGGER.info("End Tests");
	}

}
