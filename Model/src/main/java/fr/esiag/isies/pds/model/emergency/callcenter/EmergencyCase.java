package fr.esiag.isies.pds.model.emergency.callcenter;

import fr.esiag.isies.pds.model.AbstractEntity;
/**
 * @author Samuel
 * 
 * Model of an Emergency Case
 *
 */

public class EmergencyCase extends AbstractEntity{
	
	private String openDate;
	private String closeDate;
	private boolean emergencyState;
	private MedicalIntervention medicIntervention;
}
