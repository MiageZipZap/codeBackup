package fr.esiag.isies.pds.model.hospital.medical;



import fr.esiag.isies.pds.model.AbstractEntity;




/**
 * This class is a model for Act related to a medical route
 * @author Glawdys
 *
 */
public class EligibleAct extends AbstractEntity{
	
	/**
	 * id of the primary act in the CCAM
	 */
	private CcamAct idCcam;
	
	private SubAct idSubAct;
	
	/**
	 * List of subAct for a primary act
	 */
	//private Set<SubAct> subAct = new HashSet<SubAct>(0);
	
	
	

	/*public Set<SubAct> getSubAct() {
		return subAct;
	}

	public void setSubAct(Set<SubAct> subAct) {
		this.subAct = subAct;
	}*/

	

	public CcamAct getIdCcam() {
		return idCcam;
	}

	public void setIdCcam(CcamAct idCcam) {
		this.idCcam = idCcam;
	}

	public SubAct getIdSubAct() {
		return idSubAct;
	}

	public void setIdSubAct(SubAct idSubAct) {
		this.idSubAct = idSubAct;
	}

	

}
