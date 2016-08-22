package cn.com.pojo;

import java.util.Date;

/**
 * Basicinfo entity. @author MyEclipse Persistence Tools
 */

public class Basicinfo implements java.io.Serializable {

	// Fields

	private Long CId;
	private Long UId;
	private Date aidd;
	private Date srdt;
	private String bodycolor;
	private String interiorcolor;
	private Date domf;
	private String orgin;
	private String cimd;

	// Constructors

	/** default constructor */
	public Basicinfo() {
	}

	/** minimal constructor */
	public Basicinfo(Long CId, Long UId) {
		this.CId = CId;
		this.UId = UId;
	}

	/** full constructor */
	public Basicinfo(Long CId, Long UId, Date aidd, Date srdt,
			String bodycolor, String interiorcolor, Date domf, String orgin,
			String cimd) {
		this.CId = CId;
		this.UId = UId;
		this.aidd = aidd;
		this.srdt = srdt;
		this.bodycolor = bodycolor;
		this.interiorcolor = interiorcolor;
		this.domf = domf;
		this.orgin = orgin;
		this.cimd = cimd;
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

	public Date getAidd() {
		return this.aidd;
	}

	public void setAidd(Date aidd) {
		this.aidd = aidd;
	}

	public Date getSrdt() {
		return this.srdt;
	}

	public void setSrdt(Date srdt) {
		this.srdt = srdt;
	}

	public String getBodycolor() {
		return this.bodycolor;
	}

	public void setBodycolor(String bodycolor) {
		this.bodycolor = bodycolor;
	}

	public String getInteriorcolor() {
		return this.interiorcolor;
	}

	public void setInteriorcolor(String interiorcolor) {
		this.interiorcolor = interiorcolor;
	}

	public Date getDomf() {
		return this.domf;
	}

	public void setDomf(Date domf) {
		this.domf = domf;
	}

	public String getOrgin() {
		return this.orgin;
	}

	public void setOrgin(String orgin) {
		this.orgin = orgin;
	}

	public String getCimd() {
		return this.cimd;
	}

	public void setCimd(String cimd) {
		this.cimd = cimd;
	}

}