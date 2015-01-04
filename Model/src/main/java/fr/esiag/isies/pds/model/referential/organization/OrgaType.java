package fr.esiag.isies.pds.model.referential.organization;

import net.sf.oval.constraint.NotEmpty;
import net.sf.oval.constraint.NotNull;
import net.sf.oval.constraint.Size;
import fr.esiag.isies.pds.model.AbstractType;

/**
 * Model of an organization type
 * @author SKO JLA OSA ADA JSB
 *
 */
public class OrgaType extends AbstractType {
	
	/*
	 * Legal Status type
	 */
	@NotNull
	@NotEmpty
	@Size(min=2, max=45)
	private String legalStatus;
	
	public String getLegalStatus() {
		return legalStatus;
	}
	public void setLegalStatus(String legalStatus) {
		this.legalStatus = legalStatus;
	}	
		
}
