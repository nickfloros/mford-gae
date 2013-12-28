/**
 * 
 */
package org.mford.gae.testAppv6.entity;

import java.util.Date;

/**
 * contains request outcome info  .. 
 * @author nick
 *
 */
public class ResultStatus {

	protected boolean success;
	protected ErrorCode status;
	protected String errorMsg;
	protected Date requestTime;
	
	private ResultStatus() {
		this.success = true;
		this.requestTime = new Date();
	}
	
	public static ResultStatus Success() {	
		ResultStatus val = new ResultStatus();
		val.requestTime = new Date();
		val.success=true;
		return val;
	}
	
	public static ResultStatus Error(ErrorCode status) {	
		ResultStatus val = new ResultStatus();
		val.requestTime = new Date();
		val.status = status;
		val.success=false;
		return val;
	}

	public static ResultStatus Error(ErrorCode status, String errorMsg) {
		ResultStatus val = new ResultStatus();
		val.requestTime = new Date();
		val.status = status;
		val.errorMsg = errorMsg;
		val.success=false;
		return val;
	}

	/**
	 * @return the errorMsg
	 */
	public String getErrorMsg() {
		return errorMsg;
	}

	/**
	 * @param errorMsg the errorMsg to set
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	/**
	 * @return the requestTime
	 */
	public Date getRequestTime() {
		return requestTime;
	}

	/**
	 * @param requestTime the requestTime to set
	 */
	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}

	/**
	 * @return the status
	 */
	public ErrorCode getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(ErrorCode status) {
		this.status = status;
	}

	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * @param success the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
}
