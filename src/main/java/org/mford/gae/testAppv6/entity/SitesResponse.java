/**
 * 
 */
package org.mford.gae.testAppv6.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nick
 *
 */
public class SitesResponse {


	private ResultStatus status;
	
	List<Anemometer> sites;

	public SitesResponse() {
		
	}

	public SitesResponse(ResultStatus status, List<Anemometer> sites) {
		super();
		this.status = status;
		this.sites = sites;
	}

	
	/**
	 * @return the sites
	 */
	public List<Anemometer> getSites() {
		if (sites==null) 
			sites = new ArrayList<Anemometer>();
		return sites;
	}

	/**
	 * @param sites the sites to set
	 */
	public void setSites(List<Anemometer> sites) {
		this.sites = sites;
	}

	/**
	 * @return the status
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
