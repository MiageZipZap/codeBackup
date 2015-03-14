package fr.esiag.isies.pds.congestion.simulator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;

import fr.esiag.isies.pds.dao.congestion.EmergencyActivityDao;
import fr.esiag.isies.pds.model.congestion.EmergencyActivity;

public class PatientOutput implements Runnable {

	/*
	 * Average treatments duration in ms
	 */
	protected static final double MU = 8000;

	protected ConcurrentLinkedQueue<EmergencyActivity> queue;
	
	protected EmergencyActivityDao ead;
	protected int queueSize;
	protected volatile boolean running = true;

	public PatientOutput(ConcurrentLinkedQueue<EmergencyActivity> queue,int queueSize) {
		this.queue = queue;
		ead = new EmergencyActivityDao();
		this.queueSize = queueSize;
	}

	public void run() {

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		EmergencyActivity ea;
		int i = 0;
		try {
			while (running) {
				if ((ea = queue.poll()) != null) {
					ExponentialGenerator eg = new ExponentialGenerator(MU);
					long t = eg.generateTimeInterval();
					Thread.currentThread().sleep(t);
					Date date = new Date();
					ea.setDateSortie(date);
					ead.updatePatientStatus(ea);;
					System.out.println("\n\nSortie: Patient " + ea.getIdPatient() + " "
							+ dateFormat.format(date)+ "\nTAUX D'OCCUPATION : "+ 100*queue.size()/queueSize +"%\n");
				}
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
