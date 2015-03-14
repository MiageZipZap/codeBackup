package fr.esiag.isies.pds.congestion.simulator;

import java.util.Random;

/**
 * 
 * @author JLA
 * This class generate time intervals according to a Exponential Distribution
 *
 */
public class ExponentialGenerator {
	/*
	 * mu is the parameter of the Exponential Distribution : The average size of the time interval
	 */
	double mu;
	Random rand;
	
	public ExponentialGenerator(double mu) {
		this.mu = mu;
		this.rand = new Random();
	}
	
	public long generateTimeInterval(){
		double u = rand.nextDouble();
		double t = -mu * Math.log(u);
		return Math.round(t);
	}
	
}
