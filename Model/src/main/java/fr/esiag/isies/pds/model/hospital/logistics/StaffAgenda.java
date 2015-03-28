package fr.esiag.isies.pds.model.hospital.logistics;

import java.util.Date;

import fr.esiag.isies.pds.model.AbstractModel;
import fr.esiag.isies.pds.model.referential.person.staff.StaffMember;

public class StaffAgenda extends AbstractModel {
	private StaffMember member;
	private Date bookedDate;
	private int slotStart;
	private boolean taken;
	public StaffMember getMember() {
		return member;
	}
	public void setMember(StaffMember member) {
		this.member = member;
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
