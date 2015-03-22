package fr.esiag.isies.pds.model;

import fr.esiag.isies.pds.model.emergency.callcenter.EmergencyIncidentTicket;

public class Person extends AbstractEntity{
	private String name;
	private String surname;
	private String age;
	private String sex;
	private String tel;
	private EmergencyIncidentTicket ticket;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public EmergencyIncidentTicket getTicket() {
		return ticket;
	}
	public void setTicket(EmergencyIncidentTicket ticket) {
		this.ticket = ticket;
	}
	
	
}
