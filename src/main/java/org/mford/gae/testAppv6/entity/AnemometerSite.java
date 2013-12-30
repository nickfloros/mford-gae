package org.mford.gae.testAppv6.entity;

/**
 * Enum of supported sites
 * @author nick
 *
 */
public enum AnemometerSite {
	HIGHCLIFFE ("highcliffe",50.724402,-1.741988), 
	PORTLAND ("portland",50.5688716,-2.4504338), 
	HUSTCASTLE ("hurst",50.7085667,-1.5587),
	LYMINGTON ("lymington",50.758531,-1.5419099);
	
	private String code;
	private double lat, lng;
	
	AnemometerSite(String code, double lat, double lng) {
		this.code = code;
		this.lat=lat;
		this.lng=lng;
	}
	
	public String getCode() {
		return code;
	}

	/**
	 * @return the latitude
	 */
	public double getLat() {
		return lat;
	}

	/**
	 * @return the longitude
	 */
	public double getLng() {
		return lng;
	}

}
