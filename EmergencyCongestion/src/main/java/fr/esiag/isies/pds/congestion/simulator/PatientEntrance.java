package fr.esiag.isies.pds.congestion.simulator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;

import fr.esiag.isies.pds.dao.congestion.EmergencyActivityDao;
import fr.esiag.isies.pds.model.congestion.EmergencyActivity;

public class PatientEntrance implements Runnable{
	
	/*
	 * Average time between 2 entrances in ms
	 */
	protected static final double MU = 5000;
	
	protected ConcurrentLinkedQueue<EmergencyActivity> queue;
	
	protected EmergencyActivityDao ead;
	protected int queueSize;
	protected volatile boolean running = true;

	public PatientEntrance(ConcurrentLinkedQueue<EmergencyActivity> queue,int queueSize) {
		this.queue = queue;
		ead = new EmergencyActivityDao();
		this.queueSize = queueSize;
	}
	
	public void run(){
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		int i = 0;
		try {
			while(queue.size()<queueSize && running){
				Date date = new Date();
				EmergencyActivity ea = new EmergencyActivity(i, 1, 1, date,null);
				System.out.println("\n\nEntree du patient " + ea.getIdPatient() + " " + dateFormat.format(date) + "\nTAUX D'OCCUPATION : "+ 100*queue.size()/queueSize +"%\n");
				ead.create(ea);
				queue.add(ea);
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
