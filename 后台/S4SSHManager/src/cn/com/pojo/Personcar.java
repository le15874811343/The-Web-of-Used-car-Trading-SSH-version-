package cn.com.pojo;

/**
 * 个人汽车订单类
 * @author lej
 */
public class Personcar implements java.io.Serializable {

	// Fields

	private Long PId; //个人汽车订单编号
	private Long UId; //用户编号
	private Long CUid;  //车主编号
	private Long CId; //车辆编号
	private String PState;  //订单状态

	// Constructors

	/** default constructor */
	public Personcar() {
	}

	/** minimal constructor */
	public Personcar(Long PId) {
		this.PId = PId;
	}

	/** full constructor */
	public Personcar(Long PId, Long UId, Long CUid, Long CId, String PState) {
		this.PId = PId;
		this.UId = UId;
		this.CUid = CUid;
		this.CId = CId;
		this.PState = PState;
	}

	// Property accessors

	public Long getPId() {
		return this.PId;
	}

	public void setPId(Long PId) {
		this.PId = PId;
	}

	public Long getUId() {
		return this.UId;
	}

	public void setUId(Long UId) {
		this.UId = UId;
	}

	public Long getCUid() {
		return this.CUid;
	}

	public void setCUid(Long CUid) {
		this.CUid = CUid;
	}

	public Long getCId() {
		return this.CId;
	}

	public void setCId(Long CId) {
		this.CId = CId;
	}

	public String getPState() {
		return this.PState;
	}

	public void setPState(String PState) {
		this.PState = PState;
	}

}
