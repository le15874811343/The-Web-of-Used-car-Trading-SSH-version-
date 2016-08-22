package cn.com.pojo;

/**
 * Distance entity. @author MyEclipse Persistence Tools
 */

public class Distance implements java.io.Serializable {

	// Fields

	private int DId;
	private String DName;
	private Long DCount;

	// Constructors

	/** default constructor */
	public Distance() {
	}

	/** minimal constructor */
	public Distance(int DId) {
		this.DId = DId;
	}

	/** full constructor */
	public Distance(int DId, String DName, Long DCount) {
		this.DId = DId;
		this.DName = DName;
		this.DCount = DCount;
	}

	// Property accessors

	public int getDId() {
		return this.DId;
	}

	public void setDId(int DId) {
		this.DId = DId;
	}

	public String getDName() {
		return this.DName;
	}

	public void setDName(String DName) {
		this.DName = DName;
	}

	public Long getDCount() {
		return this.DCount;
	}

	public void setDCount(Long DCount) {
		this.DCount = DCount;
	}

}