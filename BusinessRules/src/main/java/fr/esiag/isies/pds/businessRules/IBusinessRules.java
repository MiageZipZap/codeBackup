package fr.esiag.isies.pds.businessRules;


/**
 * 
 * @author PFR & JLA
 *
 * @param <T extends AbstractEntity>
 */
public interface IBusinessRules<T> {
	/**
	 * Method which verify an item
	 * 
	 * @param item
	 * @return true if item is correct
	 */
	public boolean verify(T item);
}
