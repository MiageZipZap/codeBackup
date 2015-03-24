package fr.esiag.isies.pds.controller.waitingqueue;

import java.util.List;

import fr.esiag.isies.pds.model.waitingqueue.WaitingQueue;
import fr.esiag.isies.pds.dao.waitingqueue.WaitingQueueDAO;

public class WaitingQueueManager  {

	public int idService;
	public int idOrganization;
	private WaitingQueueDAO waitingQueueDAO;
	
	public WaitingQueueManager(int idService, int idOrganization) {
		this.idService = idService;
		this.idOrganization = idOrganization;
		setWaitingQueueDAO(new WaitingQueueDAO());
	}
	
	public void insertPatientInQueue(int idPatient, int priority, int idMedicalProcedure) {
		// Appel au DAO Insert
		
		if (priority == 1) {
		
		}
	}
	
	public void insertPatientInBox(int idPatient, int idDoctor, int idBox) {
		// Appel au DAO insert
	}
	
	public void exitPatientInBox(int idPatient) {
		// Appel au DAO insert
	}

	public List<WaitingQueue> getPatientsInQueue() {
		// Appel au DAO select
		
		return null;
	}
	
	public List<WaitingQueue> getPatientsInBoxs() {
		// Appel au DAO select
		
		return null;
	}
	
	public List<WaitingQueue> getPatientsInQueueWithWaitingTime() {
		// récupère les patients dans le box
		
		// récupère les patients dans la queue
		
		// fait le calcul
		return null;
	}
	
	public List<?> getDoctorsAvailable() {
		//DAO.getDoctors("available");
		
		return null;
	}

	
	public WaitingQueueDAO getWaitingQueueDAO() {
		return waitingQueueDAO;
	}

	public void setWaitingQueueDAO(WaitingQueueDAO waitingQueueDAO) {
		this.waitingQueueDAO = waitingQueueDAO;
	}
	
}