package cn.com.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * Userinfo3 entity. @author MyEclipse Persistence Tools
 */

public class Userinfo3 implements java.io.Serializable {

	// Fields

	private Long UId;
	private Long UTel;
	private String UPwd;
	private Long UCard;
	private String UAdr;
	private Long UQq;
	private String UEmail;
	private String UName;
	private String USex;
	private String UAdmin;
	private Set carinfos = new HashSet(0);

	// Constructors

	/** default constructor */
	public Userinfo3() {
	}

	/** minimal constructor */
	public Userinfo3(Long UId, Long UTel, String UPwd) {
		this.UId = UId;
		this.UTel = UTel;
		this.UPwd = UPwd;
	}

	/** full constructor */
	public Userinfo3(Long UId, Long UTel, String UPwd, Long UCard, String UAdr,
			Long UQq, String UEmail, String UName, String USex, String UAdmin,
			Set carinfos) {
		this.UId = UId;
		this.UTel = UTel;
		this.UPwd = UPwd;
		this.UCard = UCard;
		this.UAdr = UAdr;
		this.UQq = UQq;
		this.UEmail = UEmail;
		this.UName = UName;
		this.USex = USex;
		this.UAdmin = UAdmin;
		this.carinfos = carinfos;
	}

	// Property accessors

	public Long getUId() {
		return this.UId;
	}

	public void setUId(Long UId) {
		this.UId = UId;
	}

	public Long getUTel() {
		return this.UTel;
	}

	public void setUTel(Long UTel) {
		this.UTel = UTel;
	}

	public String getUPwd() {
		return this.UPwd;
	}

	public void setUPwd(String UPwd) {
		this.UPwd = UPwd;
	}

	public Long getUCard() {
		return this.UCard;
	}

	public void setUCard(Long UCard) {
		this.UCard = UCard;
	}

	public String getUAdr() {
		return this.UAdr;
	}

	public void setUAdr(String UAdr) {
		this.UAdr = UAdr;
	}

	public Long getUQq() {
		return this.UQq;
	}

	public void setUQq(Long UQq) {
		this.UQq = UQq;
	}

	public String getUEmail() {
		return this.UEmail;
	}

	public void setUEmail(String UEmail) {
		this.UEmail = UEmail;
	}

	public String getUName() {
		return this.UName;
	}

	public void setUName(String UName) {
		this.UName = UName;
	}

	public String getUSex() {
		return this.USex;
	}

	public void setUSex(String USex) {
		this.USex = USex;
	}

	public String getUAdmin() {
		return this.UAdmin;
	}

	public void setUAdmin(String UAdmin) {
		this.UAdmin = UAdmin;
	}

	public Set getCarinfos() {
		return this.carinfos;
	}

	public void setCarinfos(Set carinfos) {
		this.carinfos = carinfos;
	}

}