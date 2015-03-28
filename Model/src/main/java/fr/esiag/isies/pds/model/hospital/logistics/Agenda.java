package fr.esiag.isies.pds.model.hospital.logistics;

public class Agenda {
	private EquipementAgenda equipementAgenda;
	private InfrastructureAgenda infrastructureAgenda;
	private StaffAgenda staffAgenda;

	public EquipementAgenda getEquipementAgenda() {
		return equipementAgenda;
	}

	public void setEquipementAgenda(EquipementAgenda equipementAgenda) {
		this.equipementAgenda = equipementAgenda;
	}

	public InfrastructureAgenda getInfrastructureAgenda() {
		return infrastructureAgenda;
	}

	public void setInfrastructureAgenda(
			InfrastructureAgenda infrastructureAgenda) {
		this.infrastructureAgenda = infrastructureAgenda;
	}

	public StaffAgenda getStaffAgenda() {
		return staffAgenda;
	}

	public void setStaffAgenda(StaffAgenda staffAgenda) {
		this.staffAgenda = staffAgenda;
	}

}
