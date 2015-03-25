package fr.esiag.isies.pds.congestion.simulator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;

import fr.esiag.isies.pds.dao.referential.person.patient.PatientDao;
import fr.esiag.isies.pds.dao.waitingqueue.WaitingQueueDAO;
import fr.esiag.isies.pds.model.referential.person.patient.Patient;
import fr.esiag.isies.pds.model.waitingqueue.WaitingQueue;

public class PatientEntrance implements Runnable{
	
	/*
	 * Average time between 2 entrances in ms
	 */
	protected float MU;
	
	protected ConcurrentLinkedQueue<WaitingQueue> queue;
	
	protected WaitingQueueDAO wqd;
	protected PatientDao patDao;
	protected int queueSize;
	protected int idHospital;
	protected volatile boolean running = true;

	public PatientEntrance(ConcurrentLinkedQueue<WaitingQueue> queue,int queueSize,float MU,int idHospital) {
		this.queue = queue;
		wqd = new WaitingQueueDAO();
		patDao = new PatientDao();
		this.queueSize = queueSize;
		this.MU = MU;
		this.idHospital = idHospital;
	}
	
	public void run(){
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		int i = 0;
		try {
			while(queue.size()<queueSize && running){
				Date date = new Date();
				
				//int maxPatient = patDao.getNbrPatient();
				//Patient patient = new Patient();
				//patient.setId(maxPatient+i+1);
				//patient.setFirstName("John");
				//patient.setLastName("Doe");
				//patient.setIdOrganization(idHospital);
				//patDao.create(patient);
				WaitingQueue wq = new WaitingQueue();
				//wq.setPatient(patient);
				wq.setIdOrganization(idHospital);
				wq.setIdPatient(i+1);
				wq.setIdService(1);
				wq.setIdBox(0);
				wq.setTimeQueueState(date);
				
				System.out.println("\n\nEntree du patient " + wq.getIdPatient() + " " + dateFormat.format(date) + "\nTAUX D'OCCUPATION : "+ 100*queue.size()/queueSize +"%\n");
				wqd.create(wq);
				queue.add(wq);
				ExponentialGenerator eg = new ExponentialGenerator(MU);
				long t = eg.generateTimeInterval();
				Thread.currentThread().sleep(t);
				i++;
			}
			Thread.currentThread().interrupt();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean isRunning() {
		return running;
	}

	public void setRunning(boolean running) {
		this.running = running;
	}
	
	
}
