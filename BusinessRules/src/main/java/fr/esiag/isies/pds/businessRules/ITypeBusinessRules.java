package fr.esiag.isies.pds.businessRules;

import fr.esiag.isies.pds.model.AbstractType;
/**
 * 
 * @author Samuel
 *
 * @param <T extends AbstractType>
 */
public interface ITypeBusinessRules <T extends AbstractType> {
	/**
	 * Method which verify an item
	 * 
	 * @param item
	 * @return true if item is correct
	 */
	public boolean verify(T item);
}
