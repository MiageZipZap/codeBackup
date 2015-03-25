package fr.esiag.isies.pds.model.emergency.callcenter;

import net.sf.oval.constraint.MatchPattern;
import fr.esiag.isies.pds.model.AbstractEntity;

public class IncidentLocalization extends AbstractEntity {
	
	
	
	private String incidentAddress;
	/*
	 * Latitude
	 *
	 */
	@MatchPattern(pattern = {"^(-?\\d{0,2}([.]\\d{0,5})?)$"})
	private Float latitude;
	/*
	 * Longitude
	 */
	@MatchPattern(pattern = {"^(-?\\d{0,3}([.]\\d{0,5})?)$"})
	private Float longitude;
	
	
	public String getIncidentAddress() {
		return incidentAddress;
	}
	public void setIncidentAddress(String incidentAddress) {
		this.incidentAddress = incidentAddress;
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
	
	
}
