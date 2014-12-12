package fr.esiag.isies.pds.model;

import java.util.Map;

public class Hospital extends Organization {
	
	private String finess;
	
	private Map<ServiceType, Integer> services;
}
