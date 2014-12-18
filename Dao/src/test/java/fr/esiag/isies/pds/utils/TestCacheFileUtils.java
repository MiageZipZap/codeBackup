package fr.esiag.isies.pds.utils;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.File;

import mockit.Deencapsulation;

import org.junit.Before;
import org.junit.Test;

import fr.esiag.isies.pds.model.referential.infrastructure.CategoryRefInfra;
import fr.esiag.isies.pds.model.referential.infrastructure.Infrastructure;
import fr.esiag.isies.pds.model.referential.infrastructure.TypeRefInfra;

public class TestCacheFileUtils {

	@Before
	public void init() {
		// Delete all file in tu directory
		File directory = new File("app-data/cacheFile/tu/");
		if (directory.exists()) {
			for (File cacheDirFile : directory.listFiles()) {
				if (cacheDirFile.isDirectory()) {
					for (File cacheFile : cacheDirFile.listFiles()) {
						cacheFile.delete();
					}
				}
				cacheDirFile.delete();
			}
		}
	}

	// @After
	// public void removeDirectoryTu() {
	// File directory = new File("app-data/cacheFile/tu/");
	// for (File cacheFile : directory.listFiles()) {
	// cacheFile.delete();
	// }
	// directory.delete();
	// }

	@Test
	public void testCreate() {
		Deencapsulation.setField(CacheFileUtils.class, "cacheDirectory",
				"app-data/cacheFile/tu/");
		
		Infrastructure inf = new Infrastructure();
		
		CategoryRefInfra cat = new CategoryRefInfra();
		cat.setId(1);
		cat.setCode("Infra");
		cat.setLabel("infrastructure");
		TypeRefInfra item = new TypeRefInfra();
		item.setId(1);
		item.setCategory(cat);
		item.setCode("XXX02");
		item.setLabel("T");
		
		inf.setTypeRefInfra(item);
		inf.setCapacity(12);
		inf.setDisabledFacilities(true);
		inf.setCode("toto");
		inf.setLabel("totoLabel");
		
		assertTrue(CacheFileUtils.add(inf, ActionEnum.UPDATE));
		assertFalse(CacheFileUtils.add(null, null));
	}
}
