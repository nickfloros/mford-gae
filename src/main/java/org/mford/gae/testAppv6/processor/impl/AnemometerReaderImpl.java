/**
 * 
 */
package org.mford.gae.testAppv6.processor.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.mford.gae.testAppv6.entity.AnemometerReading;
import org.mford.gae.testAppv6.entity.WindDirection;
import org.mford.gae.testAppv6.entity.WindSpeed;
import org.mford.gae.testAppv6.processor.AnemometerReader;

/**
 * @author nick
 *
 */
public class AnemometerReaderImpl implements AnemometerReader {

	private String fieldSeperator = ",";
	private SimpleDateFormat timeStampFormat;
	
	public AnemometerReaderImpl() {
		timeStampFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm.ss");
	}
	
	/* (non-Javadoc)
	 * @see org.mford.gae.testAppv6.processor.AnemometerProcessor#readLine(int, java.lang.String)
	 */
	@Override
	public AnemometerReading readLine(int lineNo, String line) throws Exception{
		AnemometerReading val =null;
		String []fields = line.split(getFieldSeperator());
		try {
			int i=0;
			val = new AnemometerReading(lineNo, 
			getTimeStampFormat().parse(String.format("%s %s", fields[i++],fields[i++])),
			new WindDirection(Integer.parseInt(fields[i++]),Integer.parseInt(fields[i++]),Integer.parseInt(fields[i++])),
			new WindSpeed(Double.parseDouble(fields[i++]),Double.parseDouble(fields[i++]),Double.parseDouble(fields[i++])));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return val;
	}

	public String getFieldSeperator() {
		return fieldSeperator;
	}

	public void setFieldSeperator(String fieldSeperator) {
		this.fieldSeperator = fieldSeperator;
	}

	public SimpleDateFormat getTimeStampFormat() {
		return timeStampFormat;
	}

	public void setTimeStampFormat(SimpleDateFormat timeStampFormat) {
		this.timeStampFormat = timeStampFormat;
	}

}
