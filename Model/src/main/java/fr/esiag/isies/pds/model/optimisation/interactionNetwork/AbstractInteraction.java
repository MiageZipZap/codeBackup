package fr.esiag.isies.pds.model.optimisation.interactionNetwork;

import java.util.Date;

import fr.esiag.isies.pds.model.AbstractEntity;
import fr.esiag.isies.pds.model.Person;
import fr.esiag.isies.pds.model.referential.infrastructure.Infrastructure;

/**
 * abstract class which represents an interaction in general case.
 * 
 * @author PFR
 *
 * @param <T>
 *            represents the first person who is in interaction (Patient or StaffMember)
 * @param <Z>
 *            represents the second person who is in interaction (Patient or StaffMember)
 */
public abstract class AbstractInteraction<T extends Person, Z extends Person>
		extends AbstractEntity {
	/**
	 * interaction date
	 */
	private Date interactionDate;

	/**
	 * The first person which is in interaction
	 */
	private T personInteract;

	/**
	 * Thes second person who is in interaction
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

	// for denormalization state
	public AbstractInteraction() {
		this.infrastructure = new Infrastructure();
	}
	public int getInfrastructureId() {
		return this.infrastructure.getId();
	}

	public void setInfrastructureId(int id) {
		this.infrastructure.setId(id);
	}
	
	public String getInfrastructureLabel() {
		return this.infrastructure.getLabel();
	}

	public void setInfrastructureLabel(String label) {
		this.infrastructure.setLabel(label);
	}
	
	public int getPersonInteractId() {
		return this.personInteract.getId();
	}

	public void setPersonInteractId(int id) {
		this.personInteract.setId(id);
	}
	
	public String getPersonInteractFirstName() {
		return this.personInteract.getFirstName();
	}

	public void setPersonInteractFirstName(String firstName) {
		this.personInteract.setFirstName(firstName);
	}
	
	public int getPerson2InteractId() {
		return this.person2Interact.getId();
	}

	public void setPerson2InteractId(int id) {
		this.person2Interact.setId(id);
	}
	
	public String getPerson2InteractFirstName() {
		return this.person2Interact.getFirstName();
	}

	public void setPerson2InteractFirstName(String firstName) {
		this.person2Interact.setFirstName(firstName);
	}
}
