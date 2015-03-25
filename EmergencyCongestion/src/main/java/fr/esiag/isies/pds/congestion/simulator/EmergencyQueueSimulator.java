package fr.esiag.isies.pds.congestion.simulator;

import java.util.concurrent.ConcurrentLinkedQueue;

import fr.esiag.isies.pds.model.referential.organization.Hospital;
import fr.esiag.isies.pds.model.waitingqueue.WaitingQueue;

/*
 * Singleton class
 */
public class EmergencyQueueSimulator implements Runnable{
	
	//private static EmergencyQueueSimulator instance = null;
	
	public static final int queueSize = 30;
	
	public Hospital hospital;
	public ConcurrentLinkedQueue<WaitingQueue> queue;
	public PatientEntrance entrance;
	public PatientOutput output;
	

	
	public EmergencyQueueSimulator(float muArrivals, float muDepartures, Hospital hospital){
		this.queue = new ConcurrentLinkedQueue<WaitingQueue>();
		this.entrance = new PatientEntrance(queue,queueSize,muArrivals*1000,hospital.getId());
		this.output = new PatientOutput(queue, queueSize,muDepartures*1000,hospital.getId());
		this.hospital = hospital;
	}

	//private EmergencyQueueSimulator() {}
	
	/*public final static synchronized EmergencyQueueSimulator getInstance(){
		
		if(EmergencyQueueSimulator.instance == null){
			EmergencyQueueSimulator.instance = new EmergencyQueueSimulator();
		}
		
		return EmergencyQueueSimulator.instance;
	}*/
	
	public void stopSimulation(){
		entrance.setRunning(false);
		output.setRunning(false);
	}
	
	
	
	public ConcurrentLinkedQueue<WaitingQueue> getQueue() {
		return queue;
	}

	public void setQueue(ConcurrentLinkedQueue<WaitingQueue> queue) {
		this.queue = queue;
	}

	public void run() {
		Thread producer = new Thread(entrance);
		Thread consumer = new Thread(output);
		
		producer.start();
		try {
			Thread.currentThread().sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		consumer.start();
		
	}
	
	
}
