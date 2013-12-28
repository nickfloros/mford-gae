/**
 * 
 */
package org.mford.gae.testAppv6.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author nick
 *
 */
public class AnemometerReading {

	private Integer id;
	private Date timeStamp;
	private WindDirection direction;
	private WindSpeed speed;
	
	public AnemometerReading(){
	}
	
	public AnemometerReading(Integer id, Date timeStamp, 
									WindDirection direction, WindSpeed speed) {
		super();
		this.id = id;
		this.timeStamp = timeStamp;
		this.direction = direction;
		this.speed = speed;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}

	public WindDirection getDirection() {
		return direction;
	}

	public void setDirection(WindDirection direction) {
		this.direction = direction;
	}

	public WindSpeed getSpeed() {
		return speed;
	}

	public void setSpeed(WindSpeed speed) {
		this.speed = speed;
	}

	public Integer getId() {
		return id;
	}
 
	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "WeatherReading [timeStamp=" + timeStamp + ", direction="
				+ direction + ", speed=" + speed + "]";
	}
	

}
