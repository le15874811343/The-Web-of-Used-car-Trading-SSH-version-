package cn.com.pojo;

import java.math.BigDecimal;

/**
 * Model entity. @author MyEclipse Persistence Tools
 */

public class Model implements java.io.Serializable {

	// Fields

	private int MId;
	private int BId;
	private String MName;

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