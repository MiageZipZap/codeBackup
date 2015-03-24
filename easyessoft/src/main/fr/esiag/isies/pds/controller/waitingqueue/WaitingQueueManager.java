package fr.esiag.isies.pds.controller.waitingqueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import fr.esiag.isies.pds.model.waitingqueue.WaitingQueue;
import fr.esiag.isies.pds.dao.waitingqueue.WaitingQueueDAO;

public class WaitingQueueManager  {

	public int idService;
	public int idOrganization;
	private WaitingQueueDAO waitingQueueDAO;
	
	public WaitingQueueManager(int idService, int idOrganization) {
		this.idService = idService;
		this.idOrganization = idOrganization;
		this.waitingQueueDAO = new WaitingQueueDAO();
	}
	
	public void insertPatientInQueue(int idService, int idOrganization, int idPatient, int priority, int idMedicalProcedure) {
		System.out.println("syso");
		
		// Appel au DAO insert
		WaitingQueue patientToInsert = new WaitingQueue();
		patientToInsert.setIdService(idService);
		patientToInsert.setIdOrganization(idOrganization);
		patientToInsert.setTimeQueueState(new Date());
		patientToInsert.setIdPatient(idPatient);
		patientToInsert.setPriority(priority);
		patientToInsert.setIdMedicalProcedure(idMedicalProcedure);
		System.out.println("syso2");
		patientToInsert.setIdBox(1);
		patientToInsert.setIdDoctor(-1);
		System.out.println("syso3");
		
		this.waitingQueueDAO.create(patientToInsert);
		System.out.println("syso4");
		if (priority == 1) {
		
		}
	}
	
	public void insertPatientInBox(int idPatient, int idDoctor, int idBox) {

	}
	
	public void exitPatientInBox(int idPatient) {
		// Appel au DAO insert
	}
	
	public int calculateOrderScore(Date dateInsert, int priority) {
		System.out.println("etape 1 " + new Date());
		System.out.println("etape 2 " + (float) TimeUnit.MILLISECONDS.toMinutes(new Date().getTime() - dateInsert.getTime()));
    	System.out.println("priorité : " + priority);
		System.out.println("etape 4 " + (float) (1/((float) priority+10)) *10000);
		System.out.println("etape finale " + TimeUnit.MILLISECONDS.toMinutes(new Date().getTime() - dateInsert.getTime()) + (1/((float) priority+10)) *10000);
		return (int) (TimeUnit.MILLISECONDS.toMinutes(new Date().getTime() - dateInsert.getTime()) + (1/((float) priority+10)) *10000);
	}

	public List<WaitingQueue> getPatientsInQueue() {
		// Appel au DAO select
		List<WaitingQueue> listPatientPriority2 = new ArrayList<WaitingQueue>();
		listPatientPriority2.addAll(this.waitingQueueDAO.getPatientsByPriority(this.idService, this.idOrganization, 2));
		
		List<WaitingQueue> listPatientPriority345 = new ArrayList<WaitingQueue>();
		listPatientPriority345.addAll(this.waitingQueueDAO.getPatientsByPriority(this.idService, this.idOrganization, 3));
		listPatientPriority345.addAll(this.waitingQueueDAO.getPatientsByPriority(this.idService, this.idOrganization, 4));
		listPatientPriority345.addAll(this.waitingQueueDAO.getPatientsByPriority(this.idService, this.idOrganization, 5));
		
		Collections.sort(listPatientPriority345, new Comparator<WaitingQueue>() {
	        @Override
	        public int compare(WaitingQueue waitingQueuePatient1, WaitingQueue waitingQueuePatient2) {
	            return calculateOrderScore(waitingQueuePatient2.getTimeQueueState(), waitingQueuePatient2.getPriority()) - calculateOrderScore(waitingQueuePatient1.getTimeQueueState(), waitingQueuePatient1.getPriority());
	        }
	    });
		
		List<WaitingQueue> listPatient = new ArrayList<WaitingQueue>();
		listPatient.addAll(listPatientPriority2);
		listPatient.addAll(listPatientPriority345);
		
		
		
		System.out.println("Liste des patients dans la salle d'attente " + listPatient.size());
		
		return listPatient;
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