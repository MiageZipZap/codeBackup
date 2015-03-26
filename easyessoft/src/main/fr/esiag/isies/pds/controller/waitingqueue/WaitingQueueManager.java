package fr.esiag.isies.pds.controller.waitingqueue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import fr.esiag.isies.pds.model.referential.person.staff.StaffMember;
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
	
	public void insertPatientInQueue(int idPatient, int priority, int idMedicalAct) {
		// call DAO to insert in database
		WaitingQueue patientToInsert = new WaitingQueue();
		patientToInsert.setIdService(this.idService);
		patientToInsert.setIdOrganization(this.idOrganization);
		patientToInsert.setTimeQueueState(new Date());
		patientToInsert.setIdPatient(idPatient);
		patientToInsert.setPriority(priority);
		patientToInsert.setIdMedicalAct(idMedicalAct);
		patientToInsert.setIdBox(0);
		patientToInsert.setIdDoctor(-1);
		/* FOR DEMO ONLY REMOVE AFTER */
		Random rand = new Random();
		patientToInsert.setTimeQueueState(new Date(patientToInsert.getTimeQueueState().getTime() - (rand.nextInt((300 - 1) + 1) + 1) * 60 * 1000));
		//patientToInsert.setTimeQueueState(new Date(20 * 60 * 1000)));
		////////////////////////////////
		this.waitingQueueDAO.create(patientToInsert);

		if (priority == 1) {
		
		}
	}
	
	public void insertPatientInBox(int idPatient, int priority, int idMedicalAct, int idDoctor, int idBox) {
		// call DAO to insert in database
		WaitingQueue patientToInsert = new WaitingQueue();
		patientToInsert.setIdService(this.idService);
		patientToInsert.setIdOrganization(this.idOrganization);
		patientToInsert.setTimeQueueState(new Date());
		patientToInsert.setIdPatient(idPatient);
		patientToInsert.setPriority(priority);
		patientToInsert.setIdMedicalAct(idMedicalAct);
		patientToInsert.setIdBox(idBox);
		patientToInsert.setIdDoctor(idDoctor);
		this.waitingQueueDAO.create(patientToInsert);
	}
	
	public void exitPatientInBox(int idPatient, int priority, int idMedicalAct) {
		// call DAO to insert in database
		WaitingQueue patientToInsert = new WaitingQueue();
		patientToInsert.setIdService(this.idService);
		patientToInsert.setIdOrganization(this.idOrganization);
		patientToInsert.setTimeQueueState(new Date());
		patientToInsert.setIdPatient(idPatient);
		patientToInsert.setPriority(priority);
		patientToInsert.setIdMedicalAct(idMedicalAct);
		patientToInsert.setIdBox(-1);
		patientToInsert.setIdDoctor(-1);
		this.waitingQueueDAO.create(patientToInsert);
	}
	
	public int calculateOrderScore(Date dateInsert, int priority) {
		return (int) (TimeUnit.MILLISECONDS.toMinutes(new Date().getTime() - dateInsert.getTime()) + (1/((float) priority+10)) *10000);
	}

	public List<WaitingQueue> getPatientsInQueue() {
		// get all patients with priority 2
		List<WaitingQueue> listPatientPriority2 = new ArrayList<WaitingQueue>();
		listPatientPriority2.addAll(this.getPatientsInQueueByPriority(2));
		System.out.println("okok");
		// get all patients with priority 3, 4 or 5
		List<WaitingQueue> listPatientPriority345 = new ArrayList<WaitingQueue>();
		listPatientPriority345.addAll(this.getPatientsInQueueByPriority(3));
		listPatientPriority345.addAll(this.getPatientsInQueueByPriority(4));
		listPatientPriority345.addAll(this.getPatientsInQueueByPriority(5));
		
		// sort patients 3, 4, 5 by calculating order score for each patients
		Collections.sort(listPatientPriority345, new Comparator<WaitingQueue>() {
	        @Override
	        public int compare(WaitingQueue waitingQueuePatient1, WaitingQueue waitingQueuePatient2) {
	            return calculateOrderScore(waitingQueuePatient2.getTimeQueueState(), waitingQueuePatient2.getPriority()) - calculateOrderScore(waitingQueuePatient1.getTimeQueueState(), waitingQueuePatient1.getPriority());
	        }
	    });
		
		// concatenate and return all patients with priority 2 with all patients with priority 3,4,5
		List<WaitingQueue> listPatient = new ArrayList<WaitingQueue>(listPatientPriority2);
		listPatient.addAll(listPatientPriority345);
		
		System.out.println("liste de patient " + listPatient);
		return listPatient;
	}
	
	public List<WaitingQueue> getPatientsInQueueByPriority(int priority) {
		return waitingQueueDAO.getPatientsByCriteria(this.idService, this.idOrganization, priority, true, false, false);
	}
	
	public List<WaitingQueue> getPatientsInBoxs() {
		// call DAO to get patients in database
		return waitingQueueDAO.getPatientsByCriteria(this.idService, this.idOrganization, 0, false, true, false);
	}
	
	public List<WaitingQueue> getPatientsExits() {
		// call DAO to get patients in database
		return waitingQueueDAO.getPatientsByCriteria(this.idService, this.idOrganization, 0, false, false, true);
	}
	
	public List<WaitingQueue> getPatientsInQueueWithWaitingTime() {
		// récupère les patients dans le box
		
		
		// get all patients in queue
		List<WaitingQueue> patientsInQueue = this.getPatientsInQueue();
		
		// fait le calcul
		return null;
	}
	
	public List<StaffMember> getDoctorsAvailable() {
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