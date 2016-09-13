package cn.com.pojo;

/**
 * 手续信息类
 * @author  lej
 */

public class Procedureinfo implements java.io.Serializable {

	// Fields

	private Long CId; //车辆编号
	private Long UId; //车主编号
	private String purchasetax;  //购置税
	private String drivinglicense; //行驶证
	private String ncw; //新车质保
	private String registration; //登记证
	private String newinvoice;   //新车发票
	private int key; //钥匙
	private int transfertimes; //过户次数
	private String transferticket; //过户票

	// Constructors

	/** default constructor */
	public Procedureinfo() {
	}

	/** minimal constructor */
	public Procedureinfo(Long CId, Long UId) {
		this.CId = CId;
		this.UId = UId;
	}

	/** full constructor */
	public Procedureinfo(Long CId, Long UId, String purchasetax,
			String drivinglicense, String ncw, String registration,
			String newinvoice, int key, int transfertimes,
			String transferticket) {
		this.CId = CId;
		this.UId = UId;
		this.purchasetax = purchasetax;
		this.drivinglicense = drivinglicense;
		this.ncw = ncw;
		this.registration = registration;
		this.newinvoice = newinvoice;
		this.key = key;
		this.transfertimes = transfertimes;
		this.transferticket = transferticket;
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

	public String getPurchasetax() {
		return this.purchasetax;
	}

	public void setPurchasetax(String purchasetax) {
		this.purchasetax = purchasetax;
	}

	public String getDrivinglicense() {
		return this.drivinglicense;
	}

	public void setDrivinglicense(String drivinglicense) {
		this.drivinglicense = drivinglicense;
	}

	public String getNcw() {
		return this.ncw;
	}

	public void setNcw(String ncw) {
		this.ncw = ncw;
	}

	public String getRegistration() {
		return this.registration;
	}

	public void setRegistration(String registration) {
		this.registration = registration;
	}

	public String getNewinvoice() {
		return this.newinvoice;
	}

	public void setNewinvoice(String newinvoice) {
		this.newinvoice = newinvoice;
	}

	public int getKey() {
		return this.key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public int getTransfertimes() {
		return this.transfertimes;
	}

	public void setTransfertimes(int transfertimes) {
		this.transfertimes = transfertimes;
	}

	public String getTransferticket() {
		return this.transferticket;
	}

	public void setTransferticket(String transferticket) {
		this.transferticket = transferticket;
	}

}
