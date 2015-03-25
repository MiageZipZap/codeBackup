package fr.esiag.isies.pds.congestion.simulator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;

import fr.esiag.isies.pds.dao.referential.infrastructure.InfrastructureDao;
import fr.esiag.isies.pds.dao.waitingqueue.WaitingQueueDAO;
import fr.esiag.isies.pds.model.waitingqueue.WaitingQueue;

public class PatientOutput implements Runnable {

	/*
	 * Average treatments duration in ms
	 */
	protected float MU;
	protected long nbrBoxes;

	protected ConcurrentLinkedQueue<WaitingQueue> queue;
	
	protected WaitingQueueDAO wqd;
	protected InfrastructureDao infd;
	protected int queueSize;
	protected int idHospital;
	protected volatile boolean running = true;

	public PatientOutput(ConcurrentLinkedQueue<WaitingQueue> queue,int queueSize,float MU,int idHospital) {
		this.queue = queue;
		wqd = new WaitingQueueDAO();
		this.queueSize = queueSize;
		this.MU = MU;
		this.idHospital=idHospital;
		
		infd = new InfrastructureDao();
		nbrBoxes = infd.getNbrBoxes(idHospital);
	}

	public void run() {

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		WaitingQueue wq;
		int i = 0;
		try {
			while (running) {
				if ((wq = queue.poll()) != null) {
					ExponentialGenerator eg = new ExponentialGenerator(MU/nbrBoxes);
					long t = eg.generateTimeInterval();
					Thread.currentThread().sleep(t);
					Date date = new Date();
					WaitingQueue wq2  = new WaitingQueue();
					wq2.setIdOrganization(wq.getIdOrganization());
					wq2.setIdPatient(wq.getIdPatient());
					wq2.setIdService(wq.getIdService());
					wq2.setTimeQueueState(date);
					wq2.setIdBox(999);
					wqd.create(wq2);
					System.out.println("\n\nSortie: Patient " + wq2.getIdPatient() + " "
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
