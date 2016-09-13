package cn.com.pojo;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 * 用户信息类
 * @author lej
 */

public class Userinfo3 implements java.io.Serializable {

	// Fields

	private Long UId;  //用户编号
	private Long UTel; //用户手机（账号）
	private String UPwd; //用户密码
	private Long UCard;  //用户身份证
	private String UAdr; //用户地址
	private Long UQq; //用户QQ
	private String UEmail; //用户邮箱
	private String UName;  //用户姓名
	private String USex; //用户性别
	private String UAdmin; //用户权限


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
			Long UQq, String UEmail, String UName, String USex, String UAdmin
		) {
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



}
