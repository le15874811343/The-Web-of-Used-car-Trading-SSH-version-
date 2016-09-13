package cn.com.pojo;

/**
 * 价格区间信息类
 * @author lej
 */

public class Priceinterval implements java.io.Serializable {

	// Fields


	private int PId; //价格编号
	private String PName; //价格名称
	private Long PCount;  //热度

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
