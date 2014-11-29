package fr.esiag.isies.pds.businessRules;

import fr.esiag.isies.pds.model.actor.AbstractEntity;

/**
 * 
 * @author PFR & JLA
 *
 * @param <T extends AbstractEntity>
 */
public interface IBusinessRules<T extends AbstractEntity> {
	/**
	 * 
	 * @param item
	 * @return true if item is correct
	 */
	public boolean verify(T item);
}
