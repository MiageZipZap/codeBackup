package fr.esiag.isies.pds.model.optimisation.interactionNetwork;

import java.util.Date;

import fr.esiag.isies.pds.model.AbstractEntity;
import fr.esiag.isies.pds.model.referential.infrastructure.Infrastructure;

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
	private Date interactionDate;
	
	/**
	 * Person which is in interaction
	 */
	private T personInteract;
	
	/**
	 * Second person who is in interaction
	 */
	private Z person2Interact;
	
	/**
	 * infrastructure which represents the place of interaction
	 */
	private Infrastructure infrastructure;
	
	public Infrastructure getInfrastructure() {
		return infrastructure;
	}
	
	public void setInfrastructure(Infrastructure infrastructure) {
		this.infrastructure = infrastructure;
	}
	
	public Date getInteractionDate() {
		return interactionDate;
	}
	
	public void setInteractionDate(Date interactionDate) {
		this.interactionDate = interactionDate;
	}

	public Z getPerson2Interact() {
		return person2Interact;
	}

	public void setPerson2Interact(Z person2Interact) {
		this.person2Interact = person2Interact;
	}

	public T getPersonInteract() {
		return personInteract;
	}

	public void setPersonInteract(T personInteract) {
		this.personInteract = personInteract;
	}
}
