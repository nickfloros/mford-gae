/**
 * 
 */
package org.mford.gae.testAppv6.entity;

import java.util.List;

/**
 * site readsing 
 * @author nick
 *
 */
public class AnemometerSiteResponse {
	
	/**
	 * operations outcome status
	 */
	private ResultStatus status;
	
	/**
	 * identifies site 
	 */
	private AnemometerSite site;
	
	/**
	 * readings 
	 */
	private List<AnemometerReading> readings;
	
	public AnemometerSiteResponse() {
	}
	
	public AnemometerSiteResponse(AnemometerSite site,
			List<AnemometerReading> readings, ResultStatus status) {
		this.site = site;
		this.readings = readings;
		this.status = status;
	}

	/**
	 * @return the site
	 */
	public AnemometerSite getSite() {
		return site;
	}

	/**
	 * @param site the site to set
	 */
	public void setSite(AnemometerSite site) {
		this.site = site;
	}

	/**
	 * @return the readings
	 */
	public List<AnemometerReading> getReadings() {
		return readings;
	}

	/**
	 * @param readings the readings to set
	 */
	public void setReadings(List<AnemometerReading> readings) {
		this.readings = readings;
	}

	

	/**
	 * @param status the status to set
	 */
	public ResultStatus getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(ResultStatus status) {
		this.status = status;
	}


}
