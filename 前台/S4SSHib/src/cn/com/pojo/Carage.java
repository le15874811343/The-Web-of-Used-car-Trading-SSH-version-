package cn.com.pojo;

/**
 * 车龄信息类
 * @author lej
 */

public class Carage implements java.io.Serializable {

	// Fields

	private int AId;   //车龄编号
	private String AName;  //车龄名称
	private Long ACount;  //热度

	// Constructors

	/** default constructor */
	public Carage() {
	}

	/** minimal constructor */
	public Carage(int AId) {
		this.AId = AId;
	}

	/** full constructor */
	public Carage(int AId, String AName, Long ACount) {
		this.AId = AId;
		this.AName = AName;
		this.ACount = ACount;
	}

	// Property accessors

	public int getAId() {
		return this.AId;
	}

	public void setAId(int AId) {
		this.AId = AId;
	}

	public String getAName() {
		return this.AName;
	}

	public void setAName(String AName) {
		this.AName = AName;
	}

	public Long getACount() {
		return this.ACount;
	}

	public void setACount(Long ACount) {
		this.ACount = ACount;
	}

}
