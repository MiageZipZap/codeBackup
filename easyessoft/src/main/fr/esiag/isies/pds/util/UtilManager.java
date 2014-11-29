package fr.esiag.isies.pds.util;

import fr.esiag.isies.pds.dao.Dao;
import fr.esiag.isies.pds.model.actor.AbstractEntity;

/**
 * 
 * @author PFR & JLA
 *
 */
public class UtilManager {

	// Not instanciable
	private UtilManager() {
	}

	/**
	 * Add item in DataBase
	 * 
	 * @param item
	 * @return item which is added
	 */
	public static <T extends AbstractEntity> T create(T item) {
		Dao<T> dao = new Dao<T>();
		dao.create(item);
		return item;
	}

}
