package fr.esiag.isies.pds.model.congestion;

import java.util.Date;

import fr.esiag.isies.pds.model.AbstractEntity;

public class EmergencyActivity extends AbstractEntity{
	
	int idPatient;
	int idDoctor;
	int idRoom;
	Date dateEntree;
	Date dateSortie;
	
	
	
	public EmergencyActivity(int idPatient, int idDoctor, int idRoom,
		 Date dateEntree,Date dateSortie) {
		this.idPatient = idPatient;
		this.idDoctor = idDoctor;
		this.idRoom = idRoom;
		this.dateEntree = dateEntree;
		this.dateSortie = dateSortie;
	}
	public int getIdPatient() {
		return idPatient;
	}
	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}
	public int getIdDoctor() {
		return idDoctor;
	}
	public void setIdDoctor(int idDoctor) {
		this.idDoctor = idDoctor;
	}
	public int getIdRoom() {
		return idRoom;
	}
	public void setIdRoom(int idRoom) {
		this.idRoom = idRoom;
	}
	public Date getDateEntree() {
		return dateEntree;
	}
	public void setDateEntree(Date dateEntree) {
		this.dateEntree = dateEntree;
	}
	public Date getDateSortie() {
		return dateSortie;
	}
	public void setDateSortie(Date dateSortie) {
		this.dateSortie = dateSortie;
	}
	
	
	
}
