package fr.esiag.isies.pds.congestion.indicator;

public class EmergencyCongestionIndicator {
	
	
	public float getSingleCongestionIndicator(long nbrBoxes,long nbrWaitingPatients ){
		return nbrWaitingPatients*100/nbrBoxes;
		
	}
}
