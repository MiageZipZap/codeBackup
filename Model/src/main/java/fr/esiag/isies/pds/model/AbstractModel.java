package fr.esiag.isies.pds.model;

/**
 * Abstract Class with information which is in all model class (Entity and Type)
 * @author PFR
 *
 */
public class AbstractModel {
	/**
	 * Technical ID for the doctor
	 */
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
