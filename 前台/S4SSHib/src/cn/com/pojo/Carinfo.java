package cn.com.pojo;

import java.util.Date;



/**
 * Carinfo entity. @author MyEclipse Persistence Tools
 */

public class Carinfo implements java.io.Serializable {

	// Fields

	private Long CId;
	private Long UId;
	private String CBrand;
	private String CSeries;
	private Integer CReleaseyear;
	private Double CVolume;
	private String CGeartype;
	private String CCode;
	private String CModel;
	private Date CLicencetime;
	private Double CDistance;
	private String CEmissionstandard;
	private Double CPrice;
	private Long CCount;
	private String CImg;
	private Date CSjtime;
	private String CType;
	private String CState;
	private Long CSccount;
	private String CCzzx;
	private Double newprice;
	private Date CMcsj;

	// Constructors

	/** default constructor */
	public Carinfo() {
	}

	/** minimal constructor */
	public Carinfo(Long CId, Long UId, String CBrand, String CSeries,
			Integer CReleaseyear, Double CVolume, String CGeartype,
			String CCode, String CModel, Date CLicencetime, Double CDistance,
			String CEmissionstandard, Double CPrice, Long CCount, String CImg,
			Date CSjtime, String CType, String CState, Long CSccount) {
		this.CId = CId;
		this.UId = UId;
		this.CBrand = CBrand;
		this.CSeries = CSeries;
		this.CReleaseyear = CReleaseyear;
		this.CVolume = CVolume;
		this.CGeartype = CGeartype;
		this.CCode = CCode;
		this.CModel = CModel;
		this.CLicencetime = CLicencetime;
		this.CDistance = CDistance;
		this.CEmissionstandard = CEmissionstandard;
		this.CPrice = CPrice;
		this.CCount = CCount;
		this.CImg = CImg;
		this.CSjtime = CSjtime;
		this.CType = CType;
		this.CState = CState;
		this.CSccount = CSccount;
	}

	/** full constructor */
	public Carinfo(Long CId, Long UId, String CBrand, String CSeries,
			Integer CReleaseyear, Double CVolume, String CGeartype,
			String CCode, String CModel, Date CLicencetime, Double CDistance,
			String CEmissionstandard, Double CPrice, Long CCount, String CImg,
			Date CSjtime, String CType, String CState, Long CSccount,
			String CCzzx, Double newprice, Date CMcsj) {
		this.CId = CId;
		this.UId = UId;
		this.CBrand = CBrand;
		this.CSeries = CSeries;
		this.CReleaseyear = CReleaseyear;
		this.CVolume = CVolume;
		this.CGeartype = CGeartype;
		this.CCode = CCode;
		this.CModel = CModel;
		this.CLicencetime = CLicencetime;
		this.CDistance = CDistance;
		this.CEmissionstandard = CEmissionstandard;
		this.CPrice = CPrice;
		this.CCount = CCount;
		this.CImg = CImg;
		this.CSjtime = CSjtime;
		this.CType = CType;
		this.CState = CState;
		this.CSccount = CSccount;
		this.CCzzx = CCzzx;
		this.newprice = newprice;
		this.CMcsj = CMcsj;
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

	public String getCBrand() {
		return this.CBrand;
	}

	public void setCBrand(String CBrand) {
		this.CBrand = CBrand;
	}

	public String getCSeries() {
		return this.CSeries;
	}

	public void setCSeries(String CSeries) {
		this.CSeries = CSeries;
	}

	public Integer getCReleaseyear() {
		return this.CReleaseyear;
	}

	public void setCReleaseyear(Integer CReleaseyear) {
		this.CReleaseyear = CReleaseyear;
	}

	public Double getCVolume() {
		return this.CVolume;
	}

	public void setCVolume(Double CVolume) {
		this.CVolume = CVolume;
	}

	public String getCGeartype() {
		return this.CGeartype;
	}

	public void setCGeartype(String CGeartype) {
		this.CGeartype = CGeartype;
	}

	public String getCCode() {
		return this.CCode;
	}

	public void setCCode(String CCode) {
		this.CCode = CCode;
	}

	public String getCModel() {
		return this.CModel;
	}

	public void setCModel(String CModel) {
		this.CModel = CModel;
	}

	public Date getCLicencetime() {
		return this.CLicencetime;
	}

	public void setCLicencetime(Date CLicencetime) {
		this.CLicencetime = CLicencetime;
	}

	public Double getCDistance() {
		return this.CDistance;
	}

	public void setCDistance(Double CDistance) {
		this.CDistance = CDistance;
	}

	public String getCEmissionstandard() {
		return this.CEmissionstandard;
	}

	public void setCEmissionstandard(String CEmissionstandard) {
		this.CEmissionstandard = CEmissionstandard;
	}

	public Double getCPrice() {
		return this.CPrice;
	}

	public void setCPrice(Double CPrice) {
		this.CPrice = CPrice;
	}

	public Long getCCount() {
		return this.CCount;
	}

	public void setCCount(Long CCount) {
		this.CCount = CCount;
	}

	public String getCImg() {
		return this.CImg;
	}

	public void setCImg(String CImg) {
		this.CImg = CImg;
	}

	public Date getCSjtime() {
		return this.CSjtime;
	}

	public void setCSjtime(Date CSjtime) {
		this.CSjtime = CSjtime;
	}

	public String getCType() {
		return this.CType;
	}

	public void setCType(String CType) {
		this.CType = CType;
	}

	public String getCState() {
		return this.CState;
	}

	public void setCState(String CState) {
		this.CState = CState;
	}

	public Long getCSccount() {
		return this.CSccount;
	}

	public void setCSccount(Long CSccount) {
		this.CSccount = CSccount;
	}

	public String getCCzzx() {
		return this.CCzzx;
	}

	public void setCCzzx(String CCzzx) {
		this.CCzzx = CCzzx;
	}

	public Double getNewprice() {
		return this.newprice;
	}

	public void setNewprice(Double newprice) {
		this.newprice = newprice;
	}

	public Date getCMcsj() {
		return this.CMcsj;
	}

	public void setCMcsj(Date CMcsj) {
		this.CMcsj = CMcsj;
	}
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		boolean flag=false;
		if(obj instanceof Carinfo){
			Carinfo c=(Carinfo) obj;
			if(this.getCId()==c.getCId()){
			  flag=true;
			}
		}
		return flag;
	}
	 
}