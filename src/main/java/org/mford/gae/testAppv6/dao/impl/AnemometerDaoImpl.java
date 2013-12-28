/**
 * 
 */
package org.mford.gae.testAppv6.dao.impl;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.mford.gae.testAppv6.dao.AnemometerDao;
import org.mford.gae.testAppv6.entity.AnemometerReading;
import org.mford.gae.testAppv6.processor.AnemometerReader;

/**
 * @author nick
 *
 */
public class AnemometerDaoImpl implements AnemometerDao {

	private static final Logger log = Logger.getLogger(AnemometerDaoImpl.class.getName());
	
	private String hostSite;
	private String fileExt = "csv";
	private String userAgent = "Mozilla/5.0";
	private AnemometerReader processor;
	
	public AnemometerDaoImpl(){
	}
	
	/* (non-Javadoc)
	 * @see org.mford.gae.testAppv6.dao.AnemometerDao#read(java.util.Date)
	 */
	@Override
	public List<AnemometerReading> read(Date date) throws Exception {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		return read(formatter.format(date));
	}

	/* (non-Javadoc)
	 * @see org.mford.gae.testAppv6.dao.AnemometerDao#read(java.lang.String)
	 */
	@Override
	public List<AnemometerReading> read(String date) throws Exception {
		String inputLine;
		List<AnemometerReading> readings = new ArrayList<AnemometerReading>();
		URL obj = new URL(formatUrl(date));
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		//add request header
				con.setRequestProperty("User-Agent", userAgent);
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
 
		inputLine = in.readLine(); // read first line ... 
		int id=0;
		while ((inputLine = in.readLine()) != null) {
			log.fine(id + "input line "+inputLine);
			if (inputLine.trim().length()>0) 
				
				readings.add(getProcessor().readLine(id++, inputLine));
		}
		in.close();
		return readings;
	}
	
	private String formatUrl(String fileName) {
		return String.format("%s/%s.%s",getHostSite(), fileName,getFileExt());
	}

	/**
	 * @return the hostSite
	 */
	public String getHostSite() {
		return hostSite;
	}

	/**
	 * @param hostSite the hostSite to set
	 */
	public void setHostSite(String hostSite) {
		this.hostSite = hostSite;
	}

	/**
	 * @return the fileExt
	 */
	public String getFileExt() {
		return fileExt;
	}

	/**
	 * @param fileExt the fileExt to set
	 */
	public void setFileExt(String fileExt) {
		this.fileExt = fileExt;
	}

	/**
	 * @return the userAgent
	 */
	public String getUserAgent() {
		return userAgent;
	}

	/**
	 * @param userAgent the userAgent to set
	 */
	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	/**
	 * @return the processor
	 */
	public AnemometerReader getProcessor() {
		return processor;
	}


	/**
	 * @param processor the processor to set
	 */
	public void setProcessor(AnemometerReader processor) {
		this.processor = processor;
	}
	
}
