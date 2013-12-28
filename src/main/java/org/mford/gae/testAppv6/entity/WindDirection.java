/**
 * 
 */
package org.mford.gae.testAppv6.entity;

/**
 * @author nick
 *
 */
public class WindDirection  {


	private Integer min, max, avg;
	
	public WindDirection() {
		super();
	}

	public WindDirection(Integer min, Integer avg, Integer max) {
		super();
		this.min = min;
		this.max = max;
		this.avg = avg;
	}

	public int getMin() {
		return min;
	}

	public void setMin(Integer min) {
		this.min = min;
	}

	public Integer getMax() {
		return max;
	}

	public void setMax(Integer max) {
		this.max = max;
	}

	public Integer getAvg() {
		return avg;
	}

	public void setAvg(Integer avg) {
		this.avg = avg;
	}

	@Override
	public String toString() {
		return "WindDirection [min=" + min + ", max=" + max + ", avg=" + avg
				+ "]";
	}
	
	
	
}
