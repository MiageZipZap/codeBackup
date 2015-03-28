package fr.esiag.isies.pds.model.hospital.medical;

import fr.esiag.isies.pds.model.AbstractEntity;
/**
 * Model class for a medical act
 * @author Glawdys
 *
 */
public abstract class MedicalAct extends AbstractEntity {
	
	
	
	private double actPrice;
	
	
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
	private TypeAct idtypeAct;
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
	
	public double getActPrice() {
		return actPrice;
	}
	public void setActPrice(double actPrice) {
		this.actPrice = actPrice;
	}
	public TypeAct getIdtypeAct() {
		return idtypeAct;
	}
	public void setIdtypeAct(TypeAct idtypeAct) {
		this.idtypeAct = idtypeAct;
	}
	
}
