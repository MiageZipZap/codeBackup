package fr.esiag.isies.pds.model.emergency.callcenter;

import fr.esiag.isies.pds.model.AbstractEntity;

public class InterventionVehicule extends AbstractEntity {
	private VehiculeType category;
	private Float latitude;
	private Float longitude;
	private boolean stretcher;
	private int nbPlaces;
	
		
	public VehiculeType getCategory() {
		return category;
	}
	public void setCategory(VehiculeType category) {
		this.category = category;
	}
	public Float getLatitude() {
		return latitude;
	}
	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}
	public Float getLongitude() {
		return longitude;
	}
	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}
	public int getNbPlaces() {
		return nbPlaces;
	}
	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}
	public boolean isStretcher() {
		return stretcher;
	}
	public void setStretcher(boolean stretcher) {
		this.stretcher = stretcher;
	}
	
}
