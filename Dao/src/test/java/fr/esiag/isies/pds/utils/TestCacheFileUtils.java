package fr.esiag.isies.pds.utils;

import java.io.FileNotFoundException;

import junit.framework.TestCase;
import fr.esiag.isies.pds.model.referential.infrastructure.TypeRefInfra;

public class TestCacheFileUtils extends TestCase {
	
	
	
	public void testCreate() {
		TypeRefInfra item = new TypeRefInfra();
		item.setId(1);
		item.setCategory(null);
		item.setCode("XXX02");
		item.setLabel("TITI");
		try {
			CacheFileUtils.add(item);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
