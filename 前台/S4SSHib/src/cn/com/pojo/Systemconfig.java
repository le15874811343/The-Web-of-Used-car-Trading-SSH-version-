package cn.com.pojo;

/**
 * 车辆系统配置类
 * @author lej
 */

public class Systemconfig implements java.io.Serializable {

	// Fields

	private Long CId;   //车辆编号
	private Long UId; //车主编号 
	private String guidancesystem;  //导航系统
	private String alb; //防抱死制动系统
	private String fpg; //前驻车雷达
	private String rpg; //后驻车雷达
	private String rcpa; //倒车影像系统
	private String dsea; //驾驶员座椅电动调节
	private String fsea; //副驾驶座椅电动调节
	private String dlcc; //定速巡航
	private String hfs; //前排座椅加热
	private String hrs; //后排座椅加热
	private String fsv; //前排座椅通风
	private String rsv; //后排座椅通风
	private String fsm; //前排座椅记忆
	private String rsm; //后排座椅记忆
	private String rvmh;  //后视镜加热
	private String ess; //发动机启停

	// Constructors

	/** default constructor */
	public Systemconfig() {
	}

	/** minimal constructor */
	public Systemconfig(Long CId, Long UId) {
		this.CId = CId;
		this.UId = UId;
	}

	/** full constructor */
	public Systemconfig(Long CId, Long UId, String guidancesystem, String alb,
			String fpg, String rpg, String rcpa, String dsea, String fsea,
			String dlcc, String hfs, String hrs, String fsv, String rsv,
			String fsm, String rsm, String rvmh, String ess) {
		this.CId = CId;
		this.UId = UId;
		this.guidancesystem = guidancesystem;
		this.alb = alb;
		this.fpg = fpg;
		this.rpg = rpg;
		this.rcpa = rcpa;
		this.dsea = dsea;
		this.fsea = fsea;
		this.dlcc = dlcc;
		this.hfs = hfs;
		this.hrs = hrs;
		this.fsv = fsv;
		this.rsv = rsv;
		this.fsm = fsm;
		this.rsm = rsm;
		this.rvmh = rvmh;
		this.ess = ess;
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

	public String getGuidancesystem() {
		return this.guidancesystem;
	}

	public void setGuidancesystem(String guidancesystem) {
		this.guidancesystem = guidancesystem;
	}

	public String getAlb() {
		return this.alb;
	}

	public void setAlb(String alb) {
		this.alb = alb;
	}

	public String getFpg() {
		return this.fpg;
	}

	public void setFpg(String fpg) {
		this.fpg = fpg;
	}

	public String getRpg() {
		return this.rpg;
	}

	public void setRpg(String rpg) {
		this.rpg = rpg;
	}

	public String getRcpa() {
		return this.rcpa;
	}

	public void setRcpa(String rcpa) {
		this.rcpa = rcpa;
	}

	public String getDsea() {
		return this.dsea;
	}

	public void setDsea(String dsea) {
		this.dsea = dsea;
	}

	public String getFsea() {
		return this.fsea;
	}

	public void setFsea(String fsea) {
		this.fsea = fsea;
	}

	public String getDlcc() {
		return this.dlcc;
	}

	public void setDlcc(String dlcc) {
		this.dlcc = dlcc;
	}

	public String getHfs() {
		return this.hfs;
	}

	public void setHfs(String hfs) {
		this.hfs = hfs;
	}

	public String getHrs() {
		return this.hrs;
	}

	public void setHrs(String hrs) {
		this.hrs = hrs;
	}

	public String getFsv() {
		return this.fsv;
	}

	public void setFsv(String fsv) {
		this.fsv = fsv;
	}

	public String getRsv() {
		return this.rsv;
	}

	public void setRsv(String rsv) {
		this.rsv = rsv;
	}

	public String getFsm() {
		return this.fsm;
	}

	public void setFsm(String fsm) {
		this.fsm = fsm;
	}

	public String getRsm() {
		return this.rsm;
	}

	public void setRsm(String rsm) {
		this.rsm = rsm;
	}

	public String getRvmh() {
		return this.rvmh;
	}

	public void setRvmh(String rvmh) {
		this.rvmh = rvmh;
	}

	public String getEss() {
		return this.ess;
	}

	public void setEss(String ess) {
		this.ess = ess;
	}

}
