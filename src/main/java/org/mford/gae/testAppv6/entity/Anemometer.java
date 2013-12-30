package org.mford.gae.testAppv6.entity;
/**
 * anemometer instance,
 * @author nick
 *
 */
public class Anemometer {

	private Integer id;
	private AnemometerSite code;
	private String name;

	/**
	 * Latitude of anemometer position in decimal degrees
	 */
	private double lattitude;

	/**
	 * longitude of anemometer position in decimal degrees
	 */
	private double longitude;
	
	public Anemometer(Integer id, AnemometerSite code, String name,
			double lattitude, double longitude) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.lattitude = lattitude;
		this.longitude = longitude;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the code
	 */
	public AnemometerSite getCode() {
		return code;
	}

	/**
	 * @param code the code to set
	 */
	public void setCode(AnemometerSite code) {
		this.code = code;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the lattitude
	 */
	public double getLattitude() {
		return lattitude;
	}

	/**
	 * @param lattitude the lattitude to set
	 */
	public void setLattitude(double lattitude) {
		this.lattitude = lattitude;
	}

	/**
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
}
