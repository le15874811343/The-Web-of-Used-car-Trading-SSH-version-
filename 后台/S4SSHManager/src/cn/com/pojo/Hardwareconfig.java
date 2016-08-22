package cn.com.pojo;

/**
 * Hardwareconfig entity. @author MyEclipse Persistence Tools
 */

public class Hardwareconfig implements java.io.Serializable {

	// Fields

	private Long CId;
	private Long UId;
	private String consolelcdscreen;
	private String autolight;
	private String headlights;
	private String lightwash;
	private String efgv;
	private int seatnumber;
	private String fuelform;
	private String cvt;
	private String drivingmethod;
	private String pke;
	private String keylessgo;
	private String sunroof;
	private String leatherseat;

	// Constructors

	/** default constructor */
	public Hardwareconfig() {
	}

	/** minimal constructor */
	public Hardwareconfig(Long CId, Long UId) {
		this.CId = CId;
		this.UId = UId;
	}

	/** full constructor */
	public Hardwareconfig(Long CId, Long UId, String consolelcdscreen,
			String autolight, String headlights, String lightwash, String efgv,
			int seatnumber, String fuelform, String cvt,
			String drivingmethod, String pke, String keylessgo, String sunroof,
			String leatherseat) {
		this.CId = CId;
		this.UId = UId;
		this.consolelcdscreen = consolelcdscreen;
		this.autolight = autolight;
		this.headlights = headlights;
		this.lightwash = lightwash;
		this.efgv = efgv;
		this.seatnumber = seatnumber;
		this.fuelform = fuelform;
		this.cvt = cvt;
		this.drivingmethod = drivingmethod;
		this.pke = pke;
		this.keylessgo = keylessgo;
		this.sunroof = sunroof;
		this.leatherseat = leatherseat;
	}

	// Property accessors

	public Long getCId() {
		return this.CId;
	}

	public void setCId(Long CId) {
		this.CId = CId;
	}

	public Long getUId() {
		return this.UId;
	}

	public void setUId(Long UId) {
		this.UId = UId;
	}

	public String getConsolelcdscreen() {
		return this.consolelcdscreen;
	}

	public void setConsolelcdscreen(String consolelcdscreen) {
		this.consolelcdscreen = consolelcdscreen;
	}

	public String getAutolight() {
		return this.autolight;
	}

	public void setAutolight(String autolight) {
		this.autolight = autolight;
	}

	public String getHeadlights() {
		return this.headlights;
	}

	public void setHeadlights(String headlights) {
		this.headlights = headlights;
	}

	public String getLightwash() {
		return this.lightwash;
	}

	public void setLightwash(String lightwash) {
		this.lightwash = lightwash;
	}

	public String getEfgv() {
		return this.efgv;
	}

	public void setEfgv(String efgv) {
		this.efgv = efgv;
	}

	public int getSeatnumber() {
		return this.seatnumber;
	}

	public void setSeatnumber(int seatnumber) {
		this.seatnumber = seatnumber;
	}

	public String getFuelform() {
		return this.fuelform;
	}

	public void setFuelform(String fuelform) {
		this.fuelform = fuelform;
	}

	public String getCvt() {
		return this.cvt;
	}

	public void setCvt(String cvt) {
		this.cvt = cvt;
	}

	public String getDrivingmethod() {
		return this.drivingmethod;
	}

	public void setDrivingmethod(String drivingmethod) {
		this.drivingmethod = drivingmethod;
	}

	public String getPke() {
		return this.pke;
	}

	public void setPke(String pke) {
		this.pke = pke;
	}

	public String getKeylessgo() {
		return this.keylessgo;
	}

	public void setKeylessgo(String keylessgo) {
		this.keylessgo = keylessgo;
	}

	public String getSunroof() {
		return this.sunroof;
	}

	public void setSunroof(String sunroof) {
		this.sunroof = sunroof;
	}

	public String getLeatherseat() {
		return this.leatherseat;
	}

	public void setLeatherseat(String leatherseat) {
		this.leatherseat = leatherseat;
	}

}