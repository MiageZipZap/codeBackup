package fr.esiag.isies.pds.businessRules.emergency.sorting;

import fr.esiag.isies.pds.businessRules.IBusinessRules;
import fr.esiag.isies.pds.model.Doctor;
import fr.esiag.isies.pds.model.emergency.sort.Sorting;
import fr.esiag.isies.pds.model.hospital.administrative.Appointment;

/**
 * 
 * @author Meriem
 *
 */
public class SortingBusinessRules implements IBusinessRules<Sorting> {
	
	/**
	 * Verify the category value
	 * @param 
	 */
	public boolean verify(Sorting item) {
		return item.getSortingcategory().equals("Tri1")||
				 item.getSortingcategory().equals("Tri2")||
				 item.getSortingcategory().equals("Tri3")||
				 item.getSortingcategory().equals("Tri4")||
				 item.getSortingcategory().equals("Tri5");		
		}
		 
		
	}




