package fr.esiag.isies.pds.model.hospital.medical;

import fr.esiag.isies.pds.model.AbstractEntity;
/**
 * Model class for a medical act
 * @author Glawdys
 *
 */
public abstract class MedicalAct extends AbstractEntity {
	/**
	 * Act code
	 */
	private String codeAct;
	/**
	 * Act full name
	 */
	private String nameAct;
	/**
	 * Type of the act
	 */
	private int idtypeAct;
	/**
	 * Act time
	 */
	private Integer actTime;
	
	public String getCodeAct() {
		return codeAct;
	}
	public void setCodeAct(String codeAct) {
		this.codeAct = codeAct;
	}
	public String getNameAct() {
		return nameAct;
	}
	public void setNameAct(String nameAct) {
		this.nameAct = nameAct;
	}
	
	public Integer getActTime() {
		return actTime;
	}
	public void setActTime(Integer actTime) {
		this.actTime = actTime;
	}
	public int getIdtypeAct() {
		return idtypeAct;
	}
	public void setIdtypeAct(int idtypeAct) {
		this.idtypeAct = idtypeAct;
	}
	
}
