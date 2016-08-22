package cn.com.pojo;

import java.util.Date;

/**
 * Trends entity. @author MyEclipse Persistence Tools
 */

public class Trends implements java.io.Serializable {

	// Fields

	private Long trId;
	private String trTitle;
	private String trText;
	private Date trDate;
	private String trType;
	private String trImg;

	// Constructors

	/** default constructor */
	public Trends() {
	}

	/** minimal constructor */
	public Trends(Long trId, String trTitle, String trText, Date trDate,
			String trType) {
		this.trId = trId;
		this.trTitle = trTitle;
		this.trText = trText;
		this.trDate = trDate;
		this.trType = trType;
	}

	/** full constructor */
	public Trends(Long trId, String trTitle, String trText, Date trDate,
			String trType, String trImg) {
		this.trId = trId;
		this.trTitle = trTitle;
		this.trText = trText;
		this.trDate = trDate;
		this.trType = trType;
		this.trImg = trImg;
	}

	// Property accessors

	public Long getTrId() {
		return this.trId;
	}

	public void setTrId(Long trId) {
		this.trId = trId;
	}

	public String getTrTitle() {
		return this.trTitle;
	}

	public void setTrTitle(String trTitle) {
		this.trTitle = trTitle;
	}

	public String getTrText() {
		return this.trText;
	}

	public void setTrText(String trText) {
		this.trText = trText;
	}

	public Date getTrDate() {
		return this.trDate;
	}

	public void setTrDate(Date trDate) {
		this.trDate = trDate;
	}

	public String getTrType() {
		return this.trType;
	}

	public void setTrType(String trType) {
		this.trType = trType;
	}

	public String getTrImg() {
		return this.trImg;
	}

	public void setTrImg(String trImg) {
		this.trImg = trImg;
	}

}