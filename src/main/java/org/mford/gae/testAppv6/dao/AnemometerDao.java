package org.mford.gae.testAppv6.dao;

import java.util.Date;
import java.util.List;

import org.mford.gae.testAppv6.entity.AnemometerReading;
import org.mford.gae.testAppv6.processor.AnemometerReader;

public interface AnemometerDao {

	/**
	 * 
	 * @param date
	 * @return
	 * @throws Exception
	 */
	List<AnemometerReading> read(Date date) throws Exception;
	
	/**
	 * 
	 * @param date
	 * @return
	 * @throws Exception
	 */
	List<AnemometerReading> read(String date) throws Exception;
	/**
	 * 
	 * @return
	 */
	AnemometerReader getProcessor();
	
	/**
	 * 
	 * @param processor
	 */
	void setProcessor(AnemometerReader processor);

	/**
	 * set host site
	 * @param url
	 */
	void setHostSite(String url);

	/**
	 * return host site
	 * @return
	 */
	String getHostSite();
}
