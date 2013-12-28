package org.mford.gae.testAppv6.entity;

public class WindSpeed {

	private Double min, avg, max;
	
	public WindSpeed() {
		super();
	}
	
	public WindSpeed(Double min, Double avg, Double max) {
		super();
		this.min = min;
		this.avg = avg;
		this.max = max;
	}

	public Double getMin() {
		return min;
	}

	public void setMin(Double min) {
		this.min = min;
	}

	public Double getAvg() {
		return avg;
	}

	public void setAvg(Double avg) {
		this.avg = avg;
	}

	public Double getMax() {
		return max;
	}

	public void setMax(Double max) {
		this.max = max;
	}

	@Override
	public String toString() {
		return "WindSpeed [min=" + min + ", avg=" + avg + ", max=" + max + "]";
	}

}
