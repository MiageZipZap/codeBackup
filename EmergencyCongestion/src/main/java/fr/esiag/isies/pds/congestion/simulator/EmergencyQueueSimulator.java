package fr.esiag.isies.pds.congestion.simulator;

import java.util.concurrent.ConcurrentLinkedQueue;

import fr.esiag.isies.pds.model.congestion.EmergencyActivity;

/*
 * Singleton class
 */
public class EmergencyQueueSimulator {
	
	private static EmergencyQueueSimulator instance = null;
	
	public static final int queueSize = 30;
	
	public ConcurrentLinkedQueue<EmergencyActivity> queue;
	public PatientEntrance entrance;
	public PatientOutput output;

	private EmergencyQueueSimulator() {}
	
	public final static synchronized EmergencyQueueSimulator getInstance(){
		
		if(EmergencyQueueSimulator.instance == null){
			EmergencyQueueSimulator.instance = new EmergencyQueueSimulator();
		}
		
		return EmergencyQueueSimulator.instance;
	}
	
	public void startSimulation(){
		queue = new ConcurrentLinkedQueue<EmergencyActivity>();
		EmergencyQueueSimulator.getInstance().setQueue(queue);
		entrance = new PatientEntrance(EmergencyQueueSimulator.instance.queue,queueSize);
		output = new PatientOutput(EmergencyQueueSimulator.instance.queue, queueSize);
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
	
	public void stopSimulation(){
		entrance.setRunning(false);
		output.setRunning(false);
	}
	
	
	
	public ConcurrentLinkedQueue<EmergencyActivity> getQueue() {
		return queue;
	}

	public void setQueue(ConcurrentLinkedQueue<EmergencyActivity> queue) {
		this.queue = queue;
	}

	public static void main(String[] args) {
		System.out.println("Lancement");
		EmergencyQueueSimulator.getInstance().startSimulation();
		
		try {
			Thread.currentThread().sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Stop");
		EmergencyQueueSimulator.getInstance().stopSimulation();
		
	}
	
}
