package fr.esiag.isies.pds.model.optimisation.interactionNetwork.old;

import java.util.Date;

import fr.esiag.isies.pds.model.AbstractEntity;

/**
 * abstract class which represents an interaction in general case.
 * @author PFR
 *
 * @param <T> represents medicine, disease, infrastructure, etc
 * @param <Z> represents person who is in interaction (Patient or StaffMember)
 */
public abstract class AbstractInteraction<T extends AbstractEntity, Z extends AbstractEntity> extends AbstractEntity {
	/**
	 * interaction begin date
	 */
	private Date beginDate;
	
	/**
	 * interaction end date
	 */
	private Date endDate;
	
	/**
	 * Item which is in interaction
	 */
	private T itemWithInteract;
	
	/**
	 * Person who is in interaction
	 */
	private Z personInteract;
	
	public Z getPersonInteract() {
		return personInteract;
	}
	
	public void setPersonInteract(Z personInteract) {
		this.personInteract = personInteract;
	}
	
	public Date getBeginDate() {
		return beginDate;
	}
	
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	
	public Date getEndDate() {
		return endDate;
	}
	
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	public T getItemWithInteract() {
		return itemWithInteract;
	}
	
	public void setItemWithInteract(T itemWithInteract) {
		this.itemWithInteract = itemWithInteract;
	}
}
