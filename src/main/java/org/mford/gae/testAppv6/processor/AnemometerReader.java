/**
 * 
 */
package org.mford.gae.testAppv6.processor;

import org.mford.gae.testAppv6.entity.AnemometerReading;

/**
 * @author nick
 *
 */
public interface AnemometerReader {

	/**
	 * read one line of data 
	 * @param lineNo
	 * @param line
	 * @return
	 */
	AnemometerReading readLine(int lineNo, String line) throws Exception; 
}
