package fr.esiag.isies.pds.dao.referential.organization;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.esiag.isies.pds.dao.referential.organization.OrgaTypeDao;
import fr.esiag.isies.pds.model.referential.organization.OrgaType;
import junit.framework.TestCase;
/**
 * Test Création of Organization Type
 * @author SKO JLA OSA ADA JSB
 *
 */
public class OrgaTypeDaoTest extends TestCase {
	private static final Logger LOGGER = LoggerFactory.getLogger(OrgaTypeDaoTest.class);
	public void testCreationAndSuppressionOrgaTypeDao(){
		LOGGER.info("Start TU Création and suppression of OrgaType");
		//Create an object OrgaType with informations
		OrgaType myOrgaType = new OrgaType();
		myOrgaType.setLabel("CHU");
		myOrgaType.setLegalStatus("publique");
		
		//Add To Bdd and receive object wich added
		OrgaType bddOrgaType = new OrgaTypeDao().create(myOrgaType);
		
		//Compare object return when we add on Bdd with actual object which create
		assertNotNull(bddOrgaType.getId());
		assertEquals(myOrgaType.getLabel(), bddOrgaType.getLabel());
		assertEquals(myOrgaType.getLegalStatus(), bddOrgaType.getLegalStatus());
		
		//Suppress orgaType
		OrgaType bddOrgaType1 = new OrgaTypeDao().deleteById(bddOrgaType.getId());
		
		//Control if the object is supress
		assertEquals(bddOrgaType.getId(), bddOrgaType1.getId());
		LOGGER.info("End Test");
	}

}
