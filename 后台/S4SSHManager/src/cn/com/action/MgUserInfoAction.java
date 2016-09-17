package cn.com.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import cn.com.pojo.*;
import cn.com.service.*;


import cn.com.util.DbUtil;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 用户信息管理action
 * 
 */
public class MgUserInfoAction  extends ActionSupport implements ServletRequestAware,ServletResponseAware,SessionAware{
	private HttpServletRequest request;  //request
	private Map<String, Object> session; //session
	private HttpServletResponse response=null;  //response
	private IUserInfoService userInfoServiceImpl=null; //用户信息服务接口的引用
	private IBasicInfoService iBasicInfoService=null; //汽车基础信息服务接口的引用
	private	IHardwareConfigService iHardwareConfigService=null; //汽车硬件配置信息服务接口的引用
	private	ICarImagesInfoService iCarImagesInfoService=null; //汽车图片服务接口的引用
	private	IPerSonCarService iPerSonCarService=null; //汽车个人订单服务接口的引用
	private	ISellInfoService iSellInfoService=null; //销售信息服务接口的引用
	private	ISystemConfigService iSystemConfigService=null; //汽车系统配置信服服务接口的引用
	private	IProcedureInfoService iProcedureInfoService=null; //手续信息服务接口的引用
	private	IUserInfoService iUserinfoService=null;//用户信息服务接口的引用
	private	ICarInfoService iCarInfoService=null;//汽车概要信息服务接口的引用
	private IPersonNeedService iPersonNeedService=null;
	
	
	public IPersonNeedService getiPersonNeedService() {
		return iPersonNeedService;
	}
	public void setiPersonNeedService(IPersonNeedService iPersonNeedService) {
		this.iPersonNeedService = iPersonNeedService;
	}
	public HttpServletResponse getServletResponse() {
		return response;
	}
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response=arg0;
	}
	public HttpServletRequest getServletRequest() {
		return request;
	}
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request=arg0;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session=arg0;
	}

	public IUserInfoService getUserInfoServiceImpl() {
		return userInfoServiceImpl;
	}
	public void setUserInfoServiceImpl(IUserInfoService userInfoServiceImpl) {
		this.userInfoServiceImpl = userInfoServiceImpl;
	}
	public IBasicInfoService getiBasicInfoService() {
		return iBasicInfoService;
	}
	public void setiBasicInfoService(IBasicInfoService iBasicInfoService) {
		this.iBasicInfoService = iBasicInfoService;
	}
	public IHardwareConfigService getiHardwareConfigService() {
		return iHardwareConfigService;
	}
	public void setiHardwareConfigService(
			IHardwareConfigService iHardwareConfigService) {
		this.iHardwareConfigService = iHardwareConfigService;
	}
	public ICarImagesInfoService getiCarImagesInfoService() {
		return iCarImagesInfoService;
	}
	public void setiCarImagesInfoService(ICarImagesInfoService iCarImagesInfoService) {
		this.iCarImagesInfoService = iCarImagesInfoService;
	}
	public IPerSonCarService getiPerSonCarService() {
		return iPerSonCarService;
	}
	public void setiPerSonCarService(IPerSonCarService iPerSonCarService) {
		this.iPerSonCarService = iPerSonCarService;
	}
	public ISellInfoService getiSellInfoService() {
		return iSellInfoService;
	}
	public void setiSellInfoService(ISellInfoService iSellInfoService) {
		this.iSellInfoService = iSellInfoService;
	}
	public ISystemConfigService getiSystemConfigService() {
		return iSystemConfigService;
	}
	public void setiSystemConfigService(ISystemConfigService iSystemConfigService) {
		this.iSystemConfigService = iSystemConfigService;
	}
	public IProcedureInfoService getiProcedureInfoService() {
		return iProcedureInfoService;
	}
	public void setiProcedureInfoService(IProcedureInfoService iProcedureInfoService) {
		this.iProcedureInfoService = iProcedureInfoService;
	}
	public IUserInfoService getiUserinfoService() {
		return iUserinfoService;
	}
	public void setiUserinfoService(IUserInfoService iUserinfoService) {
		this.iUserinfoService = iUserinfoService;
	}
	public ICarInfoService getiCarInfoService() {
		return iCarInfoService;
	}
	public void setiCarInfoService(ICarInfoService iCarInfoService) {
		this.iCarInfoService = iCarInfoService;
	}
	/**
	 * 修改用户信息请求action
	 */
	public String uptadeuser() throws Exception {
		// TODO Auto-generated method stub
		String uid=request.getParameter("uid");
		Userinfo3 userInfo=new Userinfo3();
		userInfo.setUId(Long.parseLong(uid));
	Userinfo3 info=	userInfoServiceImpl.getUserInfoByUnique(userInfo);
	request.setAttribute("getuser",info );
	
		return "uptadeuser";
	}
	/**
	 * 新增用户操作action
	 */
	public String reguser() throws Exception {
		// TODO Auto-generated method stub

		long regname=Long.parseLong(request.getParameter("mobile"));
		String realname=request.getParameter("realname");
		String sex=request.getParameter("sex");
	     String regpwd=  request.getParameter("npwd");
	     String admin=request.getParameter("admin");
	     String regmessage=null;
	     Userinfo3 userInfo=new Userinfo3();
	     userInfo.setUTel(regname);
	     if(userInfoServiceImpl.getUserInfoByUnique(userInfo)!=null){
	    	 DbUtil.closeAll();
	    	 regmessage="该用户已存在";
	    	
	    	 
	     }
	     else{
	    	 userInfo.setUName(realname);
		     userInfo.setUPwd(regpwd);
		     userInfo.setUSex(sex);
		     userInfo.setUAdmin(admin);
		     if(userInfoServiceImpl.addUserInfo(userInfo)){
		    	 DbUtil.closeAll();
		    	 regmessage="添加成功";
		   
		    	 request.setAttribute("regmessage", regmessage);
		     }
		     else{
		    	 DbUtil.closeAll();
		    	 regmessage="添加失败";
		    	
		     }
	     }
	     request.setAttribute("regmessage", regmessage);
			
		return "reguser";
	}
	/**
	 * 删除用户操作action（先删除子表，再删主表）
	 */
	public String del() throws Exception {
		// TODO Auto-generated method stub
		try{
			long uid=Long.parseLong(request.getParameter("id"));
			Userinfo3 userinfo=new Userinfo3();
			userinfo.setUId(uid);
			Basicinfo basicInfo=new Basicinfo();
			basicInfo.setUId(uid);
			Hardwareconfig hardwareConfig=new Hardwareconfig();
			hardwareConfig.setUId(uid);
			Imagesinfo carImagesInfo=new Imagesinfo();
			carImagesInfo.setUId(uid);
			Personcar perSonCar=new Personcar();
			perSonCar.setUId(uid);
			perSonCar.setCUid(uid);
			Personneed personneed=new Personneed();
			personneed.setUId(uid);
			Sellinfo sellInfo=new Sellinfo();
			sellInfo.setUId(uid);
			Systemconfig systemConfig=new Systemconfig();
			systemConfig.setUId(uid);
			Procedureinfo procedureInfo=new Procedureinfo();
			procedureInfo.setUId(uid);
			Carinfo carInfo=new Carinfo();
			carInfo.setUId(uid);
			boolean dbflag=false;
			boolean dhflag=false;
			boolean diflag=false;
			boolean dpcflag=false;
			boolean dsflag=false;
			boolean dscflag=false;
			boolean dpflag=false;
			boolean dcflag=false;
			boolean dcuidflag=false;
			boolean duperneed=false;
			if(iBasicInfoService.checkbasicinfo(basicInfo))
			{
				 dbflag=	iBasicInfoService.deletebasicinfo( basicInfo);
			}
			else
			{
				dbflag=true;
			}
			if(iHardwareConfigService.checkhardwareconfig(hardwareConfig))
			{
				 dhflag=	iHardwareConfigService.deletehardwareconfiguser(hardwareConfig);
			}
			else
			{
				dhflag=true;
			}
			if(iCarImagesInfoService.checkimageinfouser(carImagesInfo))
			{
				 diflag=	iCarImagesInfoService.deleteimagesinfouser(carImagesInfo);
			}
			else
			{
				diflag=true;
			}
			if(iPerSonCarService.checkipersoncaruser(perSonCar))
			{
				 dpcflag=	iPerSonCarService.deletepersoncaruser( perSonCar);
			}
			else
			{
				dpcflag=true;
			}
			if(iPerSonCarService.checkcuidperson(perSonCar)){
				dcuidflag=iPerSonCarService.deletecuidperson(perSonCar);
			}
			else{
				dcuidflag=true;
			}
			if(iPersonNeedService.chekUidPerson(personneed)){
				duperneed=iPersonNeedService.deleteUidPerson(personneed);
			}
			else{
				duperneed=true;
			}
			if(iSellInfoService.checksellinfouser(sellInfo))
			{
				 dsflag=	iSellInfoService.deletesellinfouser( sellInfo);
			}
			else
			{
				dsflag=true;
			}
			if(iSystemConfigService.checksystemconfiguser(systemConfig))
			{
				 dscflag =iSystemConfigService.deletesystemconfiguser( systemConfig);
			}
			else
			{dscflag=true;
				
			}
			if(iProcedureInfoService.checkprocedureinfouser(procedureInfo))
			{
				 dpflag=iProcedureInfoService.deleteprocedureinfouser( procedureInfo);
			}
			else
			{
				dpflag=true;
			}
			if(iCarInfoService.checkcarinfouser(carInfo))
			{
				 dcflag =iCarInfoService. deletecarinfouser( carInfo);
			}
			else
			{ dcflag=true;
				
			}
			if(dbflag&&dhflag&&diflag&&dpcflag&&dscflag&&dsflag&&dcflag&&dpflag&&dcuidflag&&duperneed)
			{
			boolean flag= iUserinfoService. deleteuserinfouser( userinfo);
			if(flag)
			{
				 response.setContentType("text/html;charset=utf-8");
					response.getWriter().print(1);
					 response.getWriter().flush();//清空缓存,刷新
					   response.getWriter().close();
			}
			else
			{
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().print(0);
				 response.getWriter().flush();//清空缓存,刷新
				   response.getWriter().close();
			}
			}
			else
			{
				response.setContentType("text/html;charset=utf-8");
				response.getWriter().print(0);
				 response.getWriter().flush();//清空缓存,刷新
				   response.getWriter().close();
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "del";
	}
	/**
	 * 展示用户详细信息操作action
	 */
	public String showdeauser() throws Exception {
		// TODO Auto-generated method stub
		 String uid=request.getParameter("uid");
		 Userinfo3 info=new Userinfo3();
		 info.setUId(Long.parseLong(uid));
	info=	 userInfoServiceImpl.getUserInfoByUnique(info);
	request.setAttribute("info", info);
	
		return "showdeauser";
	}
	/**
	 * 提交修改action
	 */
	public String update() throws Exception {
		// TODO Auto-generated method stub
		 String card=request.getParameter("card");
		 String email=request.getParameter("email");
		 String qq=request.getParameter("qq");
		 String realname=request.getParameter("realname");
		 String adr=request.getParameter("adr");
		 String sex=request.getParameter("gender");
		 String uid=request.getParameter("uid");
		
	Userinfo3  userInfo=	 new Userinfo3();
	   userInfo.setUId(Long.parseLong(uid));
		 userInfo.setUName(realname);
		userInfo.setUSex(sex);
		 if(card!=null&&!card.equals("")){
			 userInfo.setUCard(Long.parseLong(card));
		 }
		 if(qq!=null&&!qq.equals("")){
			 userInfo.setUQq(Long.parseLong(qq));
		 }
		 if(email!=null&&!email.equals("")){
			 userInfo.setUEmail(email);
		 }
		 if(adr!=null&&!adr.equals("")){
			 userInfo.setUAdr(adr);
		 }
		 if(userInfoServiceImpl.updateUserInfo(userInfo)){
			String mesg="修改成功";
		Userinfo3 info=	userInfoServiceImpl.getUserInfoByUnique(userInfo);
		 request.setAttribute("getuser", info);
		 request.setAttribute("mesg", mesg);
			 
		 }
		return "update";
	}
}
