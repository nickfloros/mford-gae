/**
 * 
 */
package org.mford.gae.testAppv6;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import org.junit.Test;
import org.mford.gae.testAppv6.dao.impl.AnemometerDaoImpl;
import org.mford.gae.testAppv6.entity.AnemometerReading;
import org.mford.gae.testAppv6.processor.AnemometerReader;
import org.mford.gae.testAppv6.processor.impl.AnemometerReaderImpl;

/**
 * @author nick
 *
 */
public class AnemometerDaoImplTest {
	private static final Logger log = Logger.getLogger(AnemometerDaoImplTest.class.getName());

	/**
	 * test dao  by reading data for specific date 
	 */
	@Test
	public void readDataTest() {
		AnemometerDaoImpl dao = new AnemometerDaoImpl();
		dao.setProcessor(new AnemometerReaderImpl());
		dao.setHostSite("http://www.weather-file.com/highcliffe/data/");
		try {
			List<AnemometerReading> list = dao.read("20131210");
			log.fine("lines read "+list.size());
			System.out.print(list.size());
			assertTrue(list.size()>0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * test dao processor by reading todays data
	 */
	@Test()
	public void readByDateTest() {
		AnemometerDaoImpl dao = new AnemometerDaoImpl();
		dao.setProcessor(new AnemometerReaderImpl());
		dao.setHostSite("http://www.weather-file.com/highcliffe/data/");
		try {
			List<AnemometerReading> list = dao.read(new Date());
			log.fine("lines read "+list.size());
			System.out.print(list.size());
			assertTrue(list.size()>0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * test reader 
	 */
	@Test
	public void readerTest() {
		String val = "2013/12/06,00:00.00,276,288,300,7.97,9.61,11.48,600";
		AnemometerReader proc = new AnemometerReaderImpl();
		
		AnemometerReading s1;
		try {
			s1 = proc.readLine(1,val);
			assertNotNull(s1.getTimeStamp());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
