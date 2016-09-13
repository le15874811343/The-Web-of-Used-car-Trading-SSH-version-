package cn.com.pojo;

/**
 * 行驶距离类
 * @author  lej
 */

public class Distance implements java.io.Serializable {

	// Fields

	private int DId; //行驶距离编号
	private String DName; //行驶距离名称
	private Long DCount;  //热度

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
