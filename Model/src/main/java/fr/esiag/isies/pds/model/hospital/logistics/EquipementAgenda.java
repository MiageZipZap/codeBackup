package fr.esiag.isies.pds.model.hospital.logistics;

import java.util.Date;

import fr.esiag.isies.pds.model.AbstractModel;
import fr.esiag.isies.pds.model.referential.infrastructure.Equipment;

public class EquipementAgenda extends AbstractModel {
	private Equipment equipement;
	private Date bookedDate;
	private int slotStart;
	private boolean taken;
	public Equipment getEquipement() {
		return equipement;
	}
	public void setEquipement(Equipment equipement) {
		this.equipement = equipement;
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
