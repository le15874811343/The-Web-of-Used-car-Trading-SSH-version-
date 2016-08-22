package cn.com.pojo;

/**
 * Carbrand entity. @author MyEclipse Persistence Tools
 */

public class Carbrand implements java.io.Serializable {

	// Fields

	private int BId;
	private String BName;
	private Long BCount;
	private String BImg;
	private String BSzm;

	// Constructors

	/** default constructor */
	public Carbrand() {
	}

	/** minimal constructor */
	public Carbrand(int BId) {
		this.BId = BId;
	}

	/** full constructor */
	public Carbrand(int BId, String BName, Long BCount, String BImg,
			String BSzm) {
		this.BId = BId;
		this.BName = BName;
		this.BCount = BCount;
		this.BImg = BImg;
		this.BSzm = BSzm;
	}

	// Property accessors

	public int getBId() {
		return this.BId;
	}

	public void setBId(int BId) {
		this.BId = BId;
	}

	public String getBName() {
		return this.BName;
	}

	public void setBName(String BName) {
		this.BName = BName;
	}

	public Long getBCount() {
		return this.BCount;
	}

	public void setBCount(Long BCount) {
		this.BCount = BCount;
	}

	public String getBImg() {
		return this.BImg;
	}

	public void setBImg(String BImg) {
		this.BImg = BImg;
	}

	public String getBSzm() {
		return this.BSzm;
	}

	public void setBSzm(String BSzm) {
		this.BSzm = BSzm;
	}

}