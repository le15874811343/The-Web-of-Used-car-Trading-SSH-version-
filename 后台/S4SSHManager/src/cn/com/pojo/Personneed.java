package cn.com.pojo;

import java.util.Date;

/**
 * Personneed entity. @author MyEclipse Persistence Tools
 */

public class Personneed implements java.io.Serializable {

	// Fields

	private Long PId;
	private Long UId;
	private String PBrand;
	private String PSeries;
	private String PAge;
	private String PPrice;
	private Date PTime;
	private String PMiaoshu;
	private String PState;
	private Date PTjtime;

	// Constructors

	/** default constructor */
	public Personneed() {
	}

	/** minimal constructor */
	public Personneed(Long PId) {
		this.PId = PId;
	}

	/** full constructor */
	public Personneed(Long PId, Long UId, String PBrand, String PSeries,
			String PAge, String PPrice, Date PTime, String PMiaoshu,
			String PState, Date PTjtime) {
		this.PId = PId;
		this.UId = UId;
		this.PBrand = PBrand;
		this.PSeries = PSeries;
		this.PAge = PAge;
		this.PPrice = PPrice;
		this.PTime = PTime;
		this.PMiaoshu = PMiaoshu;
		this.PState = PState;
		this.PTjtime = PTjtime;
	}

	// Property accessors

	public Long getPId() {
		return this.PId;
	}

	public void setPId(Long PId) {
		this.PId = PId;
	}

	public Long getUId() {
		return this.UId;
	}

	public void setUId(Long UId) {
		this.UId = UId;
	}

	public String getPBrand() {
		return this.PBrand;
	}

	public void setPBrand(String PBrand) {
		this.PBrand = PBrand;
	}

	public String getPSeries() {
		return this.PSeries;
	}

	public void setPSeries(String PSeries) {
		this.PSeries = PSeries;
	}

	public String getPAge() {
		return this.PAge;
	}

	public void setPAge(String PAge) {
		this.PAge = PAge;
	}

	public String getPPrice() {
		return this.PPrice;
	}

	public void setPPrice(String PPrice) {
		this.PPrice = PPrice;
	}

	public Date getPTime() {
		return this.PTime;
	}

	public void setPTime(Date PTime) {
		this.PTime = PTime;
	}

	public String getPMiaoshu() {
		return this.PMiaoshu;
	}

	public void setPMiaoshu(String PMiaoshu) {
		this.PMiaoshu = PMiaoshu;
	}

	public String getPState() {
		return this.PState;
	}

	public void setPState(String PState) {
		this.PState = PState;
	}

	public Date getPTjtime() {
		return this.PTjtime;
	}

	public void setPTjtime(Date PTjtime) {
		this.PTjtime = PTjtime;
	}

}