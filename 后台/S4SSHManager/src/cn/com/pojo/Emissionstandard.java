package cn.com.pojo;

/**
 * Emissionstandard entity. @author MyEclipse Persistence Tools
 */

public class Emissionstandard implements java.io.Serializable {

	// Fields

	private int EId;
	private String EName;
	private Long ECount;

	// Constructors

	/** default constructor */
	public Emissionstandard() {
	}

	/** minimal constructor */
	public Emissionstandard(int EId) {
		this.EId = EId;
	}

	/** full constructor */
	public Emissionstandard(int EId, String EName, Long ECount) {
		this.EId = EId;
		this.EName = EName;
		this.ECount = ECount;
	}

	// Property accessors

	public int getEId() {
		return this.EId;
	}

	public void setEId(int EId) {
		this.EId = EId;
	}

	public String getEName() {
		return this.EName;
	}

	public void setEName(String EName) {
		this.EName = EName;
	}

	public Long getECount() {
		return this.ECount;
	}

	public void setECount(Long ECount) {
		this.ECount = ECount;
	}

}