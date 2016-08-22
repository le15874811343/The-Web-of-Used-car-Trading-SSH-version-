package cn.com.pojo;

/**
 * Sellinfo entity. @author MyEclipse Persistence Tools
 */

public class Sellinfo implements java.io.Serializable {

	// Fields

	private Long CId;
	private Long UId;
	private String pricetype;
	private String transferfee;
	private String stage;

	// Constructors

	/** default constructor */
	public Sellinfo() {
	}

	/** minimal constructor */
	public Sellinfo(Long CId, Long UId) {
		this.CId = CId;
		this.UId = UId;
	}

	/** full constructor */
	public Sellinfo(Long CId, Long UId, String pricetype, String transferfee,
			String stage) {
		this.CId = CId;
		this.UId = UId;
		this.pricetype = pricetype;
		this.transferfee = transferfee;
		this.stage = stage;
	}

	// Property accessors

	public Long getCId() {
		return this.CId;
	}

	public void setCId(Long CId) {
		this.CId = CId;
	}

	public Long getUId() {
		return this.UId;
	}

	public void setUId(Long UId) {
		this.UId = UId;
	}

	public String getPricetype() {
		return this.pricetype;
	}

	public void setPricetype(String pricetype) {
		this.pricetype = pricetype;
	}

	public String getTransferfee() {
		return this.transferfee;
	}

	public void setTransferfee(String transferfee) {
		this.transferfee = transferfee;
	}

	public String getStage() {
		return this.stage;
	}

	public void setStage(String stage) {
		this.stage = stage;
	}

}