package cn.com.pojo;

import java.util.Date;
/**
 * 公司动态信息类
 * @author lej
 */
public class Trends implements java.io.Serializable {

	// Fields
 
	private Long trId; //动态信息编号
	private String trTitle;  //动态信息标题
	private String trText; //动态信息正文
	private Date trDate;  //动态信息日期
	private String trType;  //动态信息配图
	private String trImg; //动态信息类型

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
