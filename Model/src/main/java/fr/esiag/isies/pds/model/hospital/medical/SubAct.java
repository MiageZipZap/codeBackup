package fr.esiag.isies.pds.model.hospital.medical;

import java.util.ArrayList;

import fr.esiag.isies.pds.model.AbstractEntity;
/**
 * Model class for subAct linked to primary Act
 * @author Glawdys
 *
 */

public class SubAct extends AbstractEntity {
	
	
	
	
	/**
	 * id sub act from ccam referential
	 */
	private int subIdCcam;
	
	/**
	 * id sub act from nabm referntial
	 */
	private int subIdNabm;
	
	public int getSubIdCcam() {
		return subIdCcam;
	}
	public void setSubIdCcam(int subIdCcam) {
		this.subIdCcam = subIdCcam;
	}
	public int getSubIdNabm() {
		return subIdNabm;
	}
	public void setSubIdNabm(int subIdNabm) {
		this.subIdNabm = subIdNabm;
	}
	
	
	
}
