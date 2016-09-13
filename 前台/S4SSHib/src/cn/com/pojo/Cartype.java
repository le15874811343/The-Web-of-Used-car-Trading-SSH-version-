package cn.com.pojo;

/**
 * 车型信息类
 * @author  lej
 */

public class Cartype implements java.io.Serializable {

	// Fields

	private int TId; //车型编号
	private String TName; //车型名称
	private String TImg;  //车型logo
	private Long TCount; //热度
	private String TClass;  //车型logo

	// Constructors

	/** default constructor */
	public Cartype() {
	}

	/** minimal constructor */
	public Cartype(int TId) {
		this.TId = TId;
		
	}

	/** full constructor */
	public Cartype(int TId, String TName, String TImg, Long TCount,
			String TClass) {
		this.TId = TId;
		this.TName = TName;
		this.TImg = TImg;
		this.TCount = TCount;
		this.TClass = TClass;
	}

	// Property accessors

	public int getTId() {
		return this.TId;
	}

	public void setTId(int TId) {
		this.TId = TId;
	}

	public String getTName() {
		return this.TName;
	}

	public void setTName(String TName) {
		this.TName = TName;
	}

	public String getTImg() {
		return this.TImg;
	}

	public void setTImg(String TImg) {
		this.TImg = TImg;
	}

	public Long getTCount() {
		return this.TCount;
	}

	public void setTCount(Long TCount) {
		this.TCount = TCount;
	}

	public String getTClass() {
		return this.TClass;
	}

	public void setTClass(String TClass) {
		this.TClass = TClass;
	}

}
