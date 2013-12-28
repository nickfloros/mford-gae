/**
 * 
 */
package org.mford.gae.testAppv6.entity;

/**
 * Operation outcome enum
 * @author Nick Floros, nickfloros@gmail.com
 *
 */
public enum ErrorCode {

	FAILED_TO_ACCESS_SITE ("Failed to access site"),
	NO_DATA ("No available data");
	
	private String msg;
	
	ErrorCode(String msg) {
		this.setMsg(msg);
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
