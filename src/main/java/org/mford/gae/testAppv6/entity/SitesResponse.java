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
	
	List<AnemometerSite> sites;

	public SitesResponse() {
		
	}

	public SitesResponse(ResultStatus status, List<AnemometerSite> sites) {
		super();
		this.status = status;
		this.sites = sites;
	}

	
	/**
	 * @return the sites
	 */
	public List<AnemometerSite> getSites() {
		if (sites==null) 
			sites = new ArrayList<AnemometerSite>();
		return sites;
	}

	/**
	 * @param sites the sites to set
	 */
	public void setSites(List<AnemometerSite> sites) {
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
