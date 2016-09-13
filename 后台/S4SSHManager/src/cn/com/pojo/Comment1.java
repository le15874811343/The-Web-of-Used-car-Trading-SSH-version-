package cn.com.pojo;

import java.util.Date;

/**
 * 评价信息类
 * @author lej
 */

public class Comment1 implements java.io.Serializable {

	// Fields

	private Long CId;   //评价编号
	private Long UId;  //用户编号
	private String CText;  //评价正文 
	private Date CDate;  //评价日期
	private String CImg; //评价图片
	private String CBt; //评价标题
	private String CAdmin; //评价等级

	// Constructors

	/** default constructor */
	public Comment1() {
	}

	/** minimal constructor */
	public Comment1(Long CId, Long UId, String CText, Date CDate) {
		this.CId = CId;
		this.UId = UId;
		this.CText = CText;
		this.CDate = CDate;
	}

	/** full constructor */
	public Comment1(Long CId, Long UId, String CText, Date CDate, String CImg,
			String CBt, String CAdmin) {
		this.CId = CId;
		this.UId = UId;
		this.CText = CText;
		this.CDate = CDate;
		this.CImg = CImg;
		this.CBt = CBt;
		this.CAdmin = CAdmin;
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

	public String getCText() {
		return this.CText;
	}

	public void setCText(String CText) {
		this.CText = CText;
	}

	public Date getCDate() {
		return this.CDate;
	}

	public void setCDate(Date CDate) {
		this.CDate = CDate;
	}

	public String getCImg() {
		return this.CImg;
	}

	public void setCImg(String CImg) {
		this.CImg = CImg;
	}

	public String getCBt() {
		return this.CBt;
	}

	public void setCBt(String CBt) {
		this.CBt = CBt;
	}

	public String getCAdmin() {
		return this.CAdmin;
	}

	public void setCAdmin(String CAdmin) {
		this.CAdmin = CAdmin;
	}

}
