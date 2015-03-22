package fr.esiag.isies.pds.model.emergency.callcenter;

import fr.esiag.isies.pds.model.AbstractEntity;

public class InterventionVehicule extends AbstractEntity {
	private String category;
	private String latitude;
	private String longitude;
	private boolean stretcher;
	private int nbPlaces;
	
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
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
