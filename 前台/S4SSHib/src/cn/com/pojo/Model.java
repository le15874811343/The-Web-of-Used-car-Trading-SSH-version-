package cn.com.pojo;

import java.math.BigDecimal;

/**
 * 车系信息类
 * @author lej
 */

public class Model implements java.io.Serializable {

	// Fields

	private int MId; //车系ID
	private int BId; //品牌ID
	private String MName; //车型名称

	// Constructors

	/** default constructor */
	public Model() {
	}

	/** full constructor */
	public Model(int MId, int BId, String MName) {
		this.MId = MId;
		this.BId = BId;
		this.MName = MName;
	}

	// Property accessors

	public int getMId() {
		return this.MId;
	}

	public void setMId(int MId) {
		this.MId = MId;
	}

	public int getBId() {
		return this.BId;
	}

	public void setBId(int BId) {
		this.BId = BId;
	}

	public String getMName() {
		return this.MName;
	}

	public void setMName(String MName) {
		this.MName = MName;
	}

}
