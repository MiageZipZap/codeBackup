package fr.esiag.isies.pds.model.hospital.logistics;

import java.util.Date;

import fr.esiag.isies.pds.model.AbstractModel;
import fr.esiag.isies.pds.model.referential.infrastructure.Infrastructure;

public class InfrastructureAgenda extends AbstractModel  {
	private Infrastructure infrastructure;
	private Date bookedDate;
	private int slotStart;
	private boolean taken;
	public Infrastructure getInfrastructure() {
		return infrastructure;
	}
	public void setInfrastructure(Infrastructure infrastructure) {
		this.infrastructure = infrastructure;
	}
	public Date getBookedDate() {
		return bookedDate;
	}
	public void setBookedDate(Date bookedDate) {
		this.bookedDate = bookedDate;
	}
	public int getSlotStart() {
		return slotStart;
	}
	public void setSlotStart(int slotStart) {
		this.slotStart = slotStart;
	}
	public boolean isTaken() {
		return taken;
	}
	public void setTaken(boolean taken) {
		this.taken = taken;
	}

}