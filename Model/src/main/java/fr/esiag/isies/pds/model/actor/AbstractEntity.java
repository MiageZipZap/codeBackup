package fr.esiag.isies.pds.model.actor;

import java.util.Date;

/**
 * Abstract Class with information which is in all Business Entity
 * @author PFR
 *
 */
public class AbstractEntity {
	/**
	 * Technical ID for the doctor
	 */
	private int id;
	
	
	/**
	 * Date of the newest update
	 */
	private Date updateDate;
	
	/**
	 * Date of the creation of this entity
	 */
	private Date createDate;
	
	/**
	 * User who create entity
	 */
	private String updateUser;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getUpdateUser() {
		return updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}
	
	
}
