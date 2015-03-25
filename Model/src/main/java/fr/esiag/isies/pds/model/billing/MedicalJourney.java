package fr.esiag.isies.pds.model.billing;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@XmlRootElement(name="MedicalJourneyXs")
@XmlAccessorOrder(XmlAccessOrder.UNDEFINED)
public class MedicalJourney {
	private int idJourney;
	private String nameJourney;
	private Date dateStartJourney;
	private Date dateEndJourney;
	private String statusJourney;
	public int getIdJourney() {
		return idJourney;
	}
	public void setIdJourney(int idJourney) {
		this.idJourney = idJourney;
	}
	public String getNameJourney() {
		return nameJourney;
	}
	public void setNameJourney(String nameJourney) {
		this.nameJourney = nameJourney;
	}
	public Date getDateStartJourney() {
		return dateStartJourney;
	}
	public void setDateStartJourney(Date dateStartJourney) {
		this.dateStartJourney = dateStartJourney;
	}
	public Date getDateEndJourney() {
		return dateEndJourney;
	}
	public void setDateEndJourney(Date dateEndJourney) {
		this.dateEndJourney = dateEndJourney;
	}
	public String getStatusJourney() {
		return statusJourney;
	}
	public void setStatusJourney(String statusJourney) {
		this.statusJourney = statusJourney;
	}
	public void runtest() {
		 
		String[] springConfig = { "BillingSimpleJob.xml" };
	 
		ApplicationContext context = new ClassPathXmlApplicationContext(springConfig);
	 
		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
		Job job = (Job) context.getBean("simpleDojJob");
	 
		try {
	 
			JobParameters param = new JobParametersBuilder().addString("statusjourney", "'closed'").toJobParameters();
	 
			JobExecution execution = jobLauncher.run(job, param);
			System.out.println("Exit Status : " + execution.getStatus());
			System.out.println("Exit Status : " + execution.getAllFailureExceptions());
	 
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Done");
	 
	  }
}