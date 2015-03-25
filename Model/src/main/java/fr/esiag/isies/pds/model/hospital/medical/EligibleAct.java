package fr.esiag.isies.pds.model.hospital.medical;

import java.util.HashSet;
import java.util.Set;

import fr.esiag.isies.pds.model.AbstractEntity;
import fr.esiag.isies.pds.model.referential.organization.ServiceType;



/**
 * This class is a model for Act related to a medical route
 * @author Glawdys
 *
 */
public class EligibleAct extends AbstractEntity{
	
	/**
	 * id of the primary act in the CCAM
	 */
	private int idCcam;
	
	private int idSubAct;
	
	/**
	 * List of subAct for a primary act
	 */
	//private Set<SubAct> subAct = new HashSet<SubAct>(0);
	
	
	public int getIdCcam() {
		return idCcam;
	}

	public void setIdCcam(int idCcam) {
		this.idCcam = idCcam;
	}

	/*public Set<SubAct> getSubAct() {
		return subAct;
	}

	public void setSubAct(Set<SubAct> subAct) {
		this.subAct = subAct;
	}*/

	public int getIdSubAct() {
		return idSubAct;
	}

	public void setIdSubAct(int idSubAct) {
		this.idSubAct = idSubAct;
	}

	

}
