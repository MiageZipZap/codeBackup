package fr.esiag.isies.pds.model.interactionNetwork;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import fr.esiag.isies.pds.model.AbstractEntity;

/**
 * Model which reprensents all criteria about Interaction Network
 * @author PFR
 *
 */
public class InteractionNetworkCriteria extends AbstractEntity {
	
	private static final String DATE_FORMAT = "dd/MM/yyyy HH:mm";
	
	/**
	 * Begin date of interaction network
	 */
	private Date beginDate;
	
	private String beginDateStr;
	
	/**
	 * End date of interaction network
	 */
	private Date endDate;
	
	private String endDateStr;

	public Date getBeginDate() {
		return beginDate;
	}
	
	public void setBeginDate(Date beginDate) throws ParseException {
		this.beginDate = beginDate;
	}

	public Date getEndDate() {
		return endDate;
	}
	
	public void setEndDate(Date endDate) throws ParseException {
		this.endDate = endDate;
	}
	
	public String getBeginDateStr() {
		return beginDateStr;
	}
	
	public void setBeginDateStr(String beginDateStr) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
		this.beginDateStr = beginDateStr;
		this.beginDate = simpleDateFormat.parse(beginDateStr);
	}

	public String getEndDateStr() {
		return endDateStr;
	}
	
	public void setEndDateStr(String endDateStr) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORMAT);
		this.endDateStr = endDateStr;
		this.endDate = simpleDateFormat.parse(endDateStr);
	}
}
