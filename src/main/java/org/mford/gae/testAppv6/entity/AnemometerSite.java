package org.mford.gae.testAppv6.entity;

/**
 * Enum of supported sites
 * @author nick
 *
 */
public enum AnemometerSite {
	HIGHCLIFFE ("highcliffe"), 
	PORTLAND ("portland"), 
	HUSTCASTLE ("hurst"),
	LYMINGTON ("lymington");
	
	private String code;
	
	AnemometerSite(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
}
