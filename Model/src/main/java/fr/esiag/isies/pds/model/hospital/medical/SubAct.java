package fr.esiag.isies.pds.model.hospital.medical;


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
	private CcamAct subIdCcam;
	
	/**
	 * id sub act from nabm referntial
	 */
	private  BiologicalAct subIdNabm;

	public BiologicalAct getSubIdNabm() {
		return subIdNabm;
	}

	public void setSubIdNabm(BiologicalAct subIdNabm) {
		this.subIdNabm = subIdNabm;
	}

	public CcamAct getSubIdCcam() {
		return subIdCcam;
	}

	public void setSubIdCcam(CcamAct subIdCcam) {
		this.subIdCcam = subIdCcam;
	}
	
	
	
	
	
}
