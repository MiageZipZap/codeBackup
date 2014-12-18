package fr.esiag.isies.pds.model.referential.staff;

public class HealthStaff extends Staff{
	public HealthStaff(String surname, String firstname, String birhDate) {
		super(surname, firstname, birhDate);
		// TODO Auto-generated constructor stub
	}

	/**
	 * First name of the staff
	 */
	//private CPSCard cpsCard;
	/**
	 * RPPS Number identification of each Health Staff.
	 */
	private String RPPS;

	public String getRPPS() {
		return RPPS;
	}

	public void setRPPS(String rPPS) {
		RPPS = rPPS;
	}
}
