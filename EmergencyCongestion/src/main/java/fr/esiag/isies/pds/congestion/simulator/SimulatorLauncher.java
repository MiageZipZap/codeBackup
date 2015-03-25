package fr.esiag.isies.pds.congestion.simulator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import fr.esiag.isies.pds.dao.referential.organization.OrganizationDao;
import fr.esiag.isies.pds.model.referential.organization.Hospital;
import fr.esiag.isies.pds.model.referential.organization.ServiceType;

public class SimulatorLauncher {

	private static SimulatorLauncher instance = null;

	public Map<Thread,EmergencyQueueSimulator> listThread;
	public boolean isrunning;

	private SimulatorLauncher() {
	}

	public final static synchronized SimulatorLauncher getInstance() {

		if (SimulatorLauncher.instance == null) {
			SimulatorLauncher.instance = new SimulatorLauncher();
		}

		return SimulatorLauncher.instance;
	}

	public void init(float muArr, float muDep) {
		this.listThread = new HashMap<Thread, EmergencyQueueSimulator>();
		OrganizationDao od = new OrganizationDao();
		List<Hospital> listHospital = od.getAllByType(Hospital.class);

		for (Hospital h : listHospital) {
			boolean emerg = false;
			Set<ServiceType> set = h.getServicesSet();
			for (ServiceType st : set) {
				if (st.getId() == 1) {
					emerg = true;
					break;
				}
			}

			if (emerg) {
				EmergencyQueueSimulator eqs = new EmergencyQueueSimulator(
						muArr, muDep, h);
				listThread.put(new Thread(eqs), eqs);
			}
		}
	}

	public void startSimulator() {
		for (Thread th : listThread.keySet()) {
			th.start();
		}
		this.setIsrunning(true);
	}

	public void stopSimulator() {
		if (isrunning) {
			for (Thread th : listThread.keySet()) {
				listThread.get(th).stopSimulation();
				th.interrupt();
			}
		}
		this.setIsrunning(false);
	}

	public Map<Thread, EmergencyQueueSimulator> getListThread() {
		return listThread;
	}

	public void setListThread(Map<Thread, EmergencyQueueSimulator> listThread) {
		this.listThread = listThread;
	}

	public boolean isIsrunning() {
		return isrunning;
	}

	public void setIsrunning(boolean isrunning) {
		this.isrunning = isrunning;
	}

}
