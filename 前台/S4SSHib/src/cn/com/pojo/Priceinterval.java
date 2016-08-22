package cn.com.pojo;

/**
 * Priceinterval entity. @author MyEclipse Persistence Tools
 */

public class Priceinterval implements java.io.Serializable {

	// Fields

	private int PId;
	private String PName;
	private Long PCount;

	// Constructors

	/** default constructor */
	public Priceinterval() {
	}

	/** minimal constructor */
	public Priceinterval(int PId) {
		this.PId = PId;
	}

	/** full constructor */
	public Priceinterval(int PId, String PName, Long PCount) {
		this.PId = PId;
		this.PName = PName;
		this.PCount = PCount;
	}

	// Property accessors

	public int getPId() {
		return this.PId;
	}

	public void setPId(int PId) {
		this.PId = PId;
	}

	public String getPName() {
		return this.PName;
	}

	public void setPName(String PName) {
		this.PName = PName;
	}

	public Long getPCount() {
		return this.PCount;
	}

	public void setPCount(Long PCount) {
		this.PCount = PCount;
	}

}