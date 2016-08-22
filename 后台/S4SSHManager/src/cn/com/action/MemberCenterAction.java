package cn.com.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;


import cn.com.dao.IPageDao;
import cn.com.pojo.*;
import cn.com.service.*;

import cn.com.service.impl.*;

import cn.com.util.*;


import com.opensymphony.xwork2.ActionSupport;

public class MemberCenterAction extends ActionSupport implements ServletRequestAware ,SessionAware,ServletResponseAware  {
   private HttpServletRequest request=null;
   private Map<String, Object> session=null;
   private IPerSonCarService perSonCarService=null;
   private IPageDao personCarPage=null;
   private ICarInfoService carInfoService=null;
   private IPersonNeedService personNeedService=null;
   private IPageDao personNeedPage=null;
   private HttpServletResponse response=null;
   private ICarTypeService carTypeService=null;
   private IBasicInfoService basicInfoService=new BasicInfoServiceImpl();	
   private IHardwareConfigService hardwareConfigService=null;
   private ISystemConfigService systemConfigService=null;
   private IProcedureInfoService procedureInfoService=null;
   private ISellInfoService sellInfoService=null;
   private ICarImagesInfoService carImagesInfoService=null;
   private ICommentService commentServiceImpl=null;
   private long tzCid;
   private long tzUid;
public long getTzCid() {
	return tzCid;
}
public void setTzCid(long tzCid) {
	this.tzCid = tzCid;
}
public long getTzUid() {
	return tzUid;
}
public void setTzUid(long tzUid) {
	this.tzUid = tzUid;
}

public ICommentService getCommentServiceImpl() {
	return commentServiceImpl;
}
public void setCommentServiceImpl(ICommentService commentServiceImpl) {
	this.commentServiceImpl = commentServiceImpl;
}
public IBasicInfoService getBasicInfoService() {
	return basicInfoService;
}
public void setBasicInfoService(IBasicInfoService basicInfoService) {
	this.basicInfoService = basicInfoService;
}
public IHardwareConfigService getHardwareConfigService() {
	return hardwareConfigService;
}
public void setHardwareConfigService(
		IHardwareConfigService hardwareConfigService) {
	this.hardwareConfigService = hardwareConfigService;
}
public ISystemConfigService getSystemConfigService() {
	return systemConfigService;
}
public void setSystemConfigService(ISystemConfigService systemConfigService) {
	this.systemConfigService = systemConfigService;
}
public IProcedureInfoService getProcedureInfoService() {
	return procedureInfoService;
}
public void setProcedureInfoService(IProcedureInfoService procedureInfoService) {
	this.procedureInfoService = procedureInfoService;
}
public ISellInfoService getSellInfoService() {
	return sellInfoService;
}
public void setSellInfoService(ISellInfoService sellInfoService) {
	this.sellInfoService = sellInfoService;
}
public ICarImagesInfoService getCarImagesInfoService() {
	return carImagesInfoService;
}
public void setCarImagesInfoService(ICarImagesInfoService carImagesInfoService) {
	this.carImagesInfoService = carImagesInfoService;
}
public ICarTypeService getCarTypeService() {
	return carTypeService;
}
public void setCarTypeService(ICarTypeService carTypeService) {
	this.carTypeService = carTypeService;
}
public HttpServletResponse getServletResponse() {
	return response;
}
@Override
public void setServletResponse(HttpServletResponse arg0) {
	// TODO Auto-generated method stub
	this.response=arg0;
}
public IPersonNeedService getPersonNeedService() {
	return personNeedService;
}
public void setPersonNeedService(IPersonNeedService personNeedService) {
	this.personNeedService = personNeedService;
}
public IPageDao getPersonNeedPage() {
	return personNeedPage;
}
public void setPersonNeedPage(IPageDao personNeedPage) {
	this.personNeedPage = personNeedPage;
}
public HttpServletRequest getRequest() {
	return request;
}
public void setRequest(HttpServletRequest request) {
	this.request = request;
}
public IPerSonCarService getPerSonCarService() {
	return perSonCarService;
}
public void setPerSonCarService(IPerSonCarService perSonCarService) {
	this.perSonCarService = perSonCarService;
}
public IPageDao getPersonCarPage() {
	return personCarPage;
}
public void setPersonCarPage(IPageDao personCarPage) {
	this.personCarPage = personCarPage;
}
public ICarInfoService getCarInfoService() {
	return carInfoService;
}
public void setCarInfoService(ICarInfoService carInfoService) {
	this.carInfoService = carInfoService;
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
public String showmenber() throws Exception {	
	// TODO Auto-generated method stub
	if(chekUser()!=null){
		Personcar perSonCar = new Personcar();
		perSonCar.setUId(chekUser().getUId());
		perSonCar.setPState("�ղ�");
 long scCount=perSonCarService.getCarCountByWhere(perSonCar);

 perSonCar.setPState("�Ѷ�");
 long ydCount=perSonCarService.getCarCountByWhere(perSonCar);

 request.setAttribute("scCount", scCount);
 request.setAttribute("ydCount", ydCount);
         return "showmenber";

	}
	else{
		return "nouser";
	}
	
}
public String showmenberSc() throws Exception {
	// TODO Auto-generated method stub
	if(chekUser()!=null){
		Personcar perSonCar=new Personcar();
		perSonCar.setUId(chekUser().getUId());
		perSonCar.setPState("�ղ�");
     fenye(request, perSonCar);

         return "showmenberSc";

	}
	else{
		return "nouser";
	}
}
public String showmenberOrder() throws Exception {
	// TODO Auto-generated method stub
	if(chekUser()!=null){
		Personcar perSonCar=new Personcar();
		perSonCar.setUId(chekUser().getUId());
		perSonCar.setPState("�Ѷ�");
		 fenye(request,  perSonCar);
     
        return "showmenberOrder";

	}
	else{
		return "nouser";
	}
}
public String showmenberMc() throws Exception {
	// TODO Auto-generated method stub
	if(chekUser()!=null){
		Personcar perSonCar=new Personcar();
		perSonCar.setUId(chekUser().getUId());
		perSonCar.setPState("����");
		 fenye(request,  perSonCar);
           DbUtil.closeAll();
         
        return "showmenberMc";

	}
	else{
		return "nouser";
	}
}
public String showmenberYbcar() throws Exception {
	// TODO Auto-generated method stub
	if(chekUser()!=null){
		Personcar perSonCar=new Personcar();
		 perSonCar.setUId(chekUser().getUId());
			perSonCar.setPState("�������");
			 fenye(request,  perSonCar);
	           DbUtil.closeAll();
	          
        return "showmenberYbcar";

	}
	else{
		return "nouser";
	}
}
public String showmenberSh() throws Exception {
	// TODO Auto-generated method stub
	if(chekUser()!=null){
		Personcar perSonCar=new Personcar();
		perSonCar.setUId(chekUser().getUId());
		perSonCar.setPState("�����");
		 fenye(request, perSonCar);
           DbUtil.closeAll();
          
        return "showmenberSh";

	}
	else{
		return "nouser";
	}
}
public String showmenberbjj() throws Exception {
	// TODO Auto-generated method stub
	if(chekUser()!=null){
		Personcar perSonCar=new Personcar();
		perSonCar.setUId(chekUser().getUId());
		perSonCar.setPState("δͨ��");
		 fenye(request,  perSonCar);
           DbUtil.closeAll();
        return "showmenberbjj";

	}
	else{
		return "nouser";
	}
}
public String showmenberJyz() throws Exception {
	// TODO Auto-generated method stub
	if(chekUser()!=null){
		Personcar perSonCar=new Personcar();
		perSonCar.setUId(chekUser().getUId());
		perSonCar.setPState("����");
		 fenye(request,  perSonCar);
           DbUtil.closeAll();
       
        return "showmenberJyz";

	}
	else{
		return "nouser";
	}
}
public String showmenberymw() throws Exception {
	// TODO Auto-generated method stub
	if(chekUser()!=null){
		Personcar perSonCar=new Personcar();
		perSonCar.setUId(chekUser().getUId());
		perSonCar.setPState("�������");
		 fenye(request,  perSonCar);
           DbUtil.closeAll();
        
        return "showmenberymw";

	}
	else{
		return "nouser";
	}
}
public String showmenberzzmr() throws Exception {
	// TODO Auto-generated method stub
	if(chekUser()!=null){
		Personcar perSonCar=new Personcar();
		perSonCar.setUId(chekUser().getUId());
		perSonCar.setPState("��ͣ����");
		 fenye(request, perSonCar);
	       DbUtil.closeAll();
	    
        return "showmenberzzmr";

	}
	else{
		return "nouser";
	}
}
public String showmenberXj() throws Exception {
	// TODO Auto-generated method stub
	if(chekUser()!=null){
		Personcar perSonCar=new Personcar();
		perSonCar.setUId(chekUser().getUId());
		perSonCar.setPState("�¼�");
		 fenye(request, perSonCar);
           DbUtil.closeAll();
          
        return "showmenberXj";

	}
	else{
		return "nouser";
	}
}
public String showmenberSj() throws Exception {
	// TODO Auto-generated method stub
	if(chekUser()!=null){
		 Carinfo carInfo=new Carinfo();
		 Personcar perSonCar=new Personcar();
			this.finishop(request, perSonCar, chekUser(),carInfo);
		   perSonCar.setPState("�¼�");
		   carInfo.setCState("����");
			if(perSonCarService.updatePerSoncar(perSonCar, "����")){
				if(carInfoService.updateCarInfo(carInfo)){
					return "showmenberSj";
			
			}
				else{
					 return "ERROR";
				}
			}
			else{
				 return "ERROR";
			}
        

	}
	else{
		return "nouser";
	}
}
public String qxsc() throws Exception {
	// TODO Auto-generated method stub
	if(chekUser()!=null){
		Personcar perSonCar=new Personcar();
		this.finishop(request, perSonCar, chekUser(),null);
		perSonCar.setPState("�ղ�");
	  perSonCar=perSonCarService.getPersoncar(perSonCar);
		if(perSonCarService.deletePerSoncar(perSonCar)){
		
			 return "qxsc";
			
		}
       
		else{
			 return "ERROR";
		}
	}
	else{
		return "nouser";
	}
}
public String qrsh() throws Exception {
	// TODO Auto-generated method stub
	if(chekUser()!=null){
		Personcar perSonCar=new Personcar();
		Carinfo carInfo=new Carinfo();
        
		this.finishop(request, perSonCar, chekUser(),carInfo);
	   perSonCar.setPState("�Ѷ�");
	   carInfo.setCState("�������");
	  
	    Date date=new Date();
	   carInfo.setCMcsj( date);
		if(perSonCarService.updatePerSoncar(perSonCar, "�������")){
			if(carInfoService.updateCarInfo(carInfo)){
				perSonCar.setUId(perSonCar.getCUid());
				perSonCar.setPState("����");
				if(perSonCarService.updatePerSoncar(perSonCar, "�������")){
					  return "qrsh";
				}
				else{
					 return "ERROR";
				}
		}
			else{
				 return "ERROR";
			}
		}
		else{
			 return "ERROR";
		}

	}
	else{
		return "nouser";
	}
}
public String qxdd() throws Exception {
	// TODO Auto-generated method stub
	if(chekUser()!=null){
		Personcar perSonCar=new Personcar();
		Carinfo carInfo=new Carinfo();
        
		this.finishop(request, perSonCar, chekUser(),carInfo);
	   perSonCar.setPState("�Ѷ�");
	 
		if(perSonCarService.updatePerSoncar(perSonCar, "��ͣ����")){
			
				perSonCar.setUId(perSonCar.getCUid());
				perSonCar.setPState("����");
				if(perSonCarService.updatePerSoncar(perSonCar, "��ͣ����")){
					return "qxdd";
			
				}
				else{
					 return "ERROR";
				}
		}
		else{
			 return "ERROR";
		}

	}
	else{
		return "nouser";
	}
	}
public String tjbjj() throws Exception {
	// TODO Auto-generated method stub
	if(chekUser()!=null){
		Personcar perSonCar=new Personcar();
		Carinfo carInfo=new Carinfo();
   	 this.finishop(request, perSonCar, chekUser(),carInfo);
        perSonCar.setPState("δͨ��");
        carInfo.setCState("�����");
        if(perSonCarService.updatePerSoncar(perSonCar, "�����")){
			if(carInfoService.updateCarInfo(carInfo)){
				  return "tjbjj";
       	
			}
			else{
				 return "ERROR";
			}
        }
        else{
			 return "ERROR";
		}

	}
	else{
		return "nouser";
	}
}
public String needsc() throws Exception {
	// TODO Auto-generated method stub
	if(chekUser()!=null){
		Personcar perSonCar=new Personcar();
		String c_uid=request.getParameter("c_uid");
		String c_id=request.getParameter("c_id");
			perSonCar.setCUid(Long.parseLong(c_uid));
			perSonCar.setCId(Long.parseLong(c_id));
				perSonCar.setUId(chekUser().getUId());
				perSonCar.setPState("�ղ�");
				Carinfo carInfo=new Carinfo();
				carInfo.setCId(Long.parseLong(c_id));
				carInfo.setUId(Long.parseLong(c_uid));
			Map<Long, Carinfo> car=	carInfoService.getCarByWhere(carInfo);
			Carinfo _car=car.get(carInfo.getCId());
			 _car.setCSccount(_car.getCSccount()+1);
			 String scmessage=null;
			
			if(!chekUser().getUId().toString().equals(carInfo.getUId().toString()))
			 {if(perSonCarService.getPerSonCarMapByWhere(perSonCar).size()>0){
				 scmessage="��Ǹ!:���Ѿ��ղع���������,ȥ��Ա����-�ҵ�����-�ҵ��ղ��п�����";
			}
			else{ 
			if(perSonCarService.addPerSonCar(perSonCar)&&carInfoService.updateCarInfo(_car)){
				 scmessage="��ϲ!:�ղسɹ�,ȥ��Ա����-�ҵ�����-�ҵ��ղ��п�����";
				
			 }
			}
			}
			else{
				scmessage="�������ղ��Լ��ĳ�";
			}
			response.setContentType("text/html;charset=utf-8");
			 
			response.getWriter().println(scmessage);
			response.getWriter().flush();//��ջ���,ˢ��
			response.getWriter().close();
        return "josn";

	}
	else{
		return "nouser";
	}
}
public String needdg() throws Exception {
	// TODO Auto-generated method stub
	if(chekUser()!=null){
		String c_uid=request.getParameter("c_uid");
		String c_id=request.getParameter("c_id");
				Carinfo carInfo=new Carinfo();
				carInfo.setCId(Long.parseLong(c_id));
				carInfo.setUId(Long.parseLong(c_uid));
			Map<Long, Carinfo> car=	carInfoService.getCarByWhere(carInfo);
			Carinfo _car=car.get(carInfo.getCId());
		           
			 String scmessage=null;
			if(!chekUser().getUId().toString().equals(carInfo.getUId().toString()))
			 {
				scmessage="pass";
			   session.put("ydcarr", _car);
			   
			
			}
			else{
				scmessage="���������Լ��ĳ�";
			}
			response.setContentType("text/html;charset=utf-8");
			 
			response.getWriter().print(scmessage);
			response.getWriter().flush();//��ջ���,ˢ��
			response.getWriter().close();
		
        return "josn";

	}
	else{
		return "nouser";
	}
}
public String fukuan() throws Exception {
	// TODO Auto-generated method stub
	if(chekUser()!=null){
	
		Personcar perSonCar=new Personcar();
		String uid=request.getParameter("uid");
		String cid=request.getParameter("cid");
		
		String meeag=null;
		Carinfo carInfo1=new Carinfo();
		carInfo1.setCId(Long.parseLong(cid));
		carInfo1.setUId(Long.parseLong(uid));
		if(carInfoService.getCarByWhere(carInfo1).get(carInfo1.getCId()).getCState().equals("����")){
		perSonCar.setUId(chekUser().getUId());
		perSonCar.setCUid(Long.parseLong(uid));
		perSonCar.setCId(Long.parseLong(cid));
		perSonCar.setPState("�Ѷ�");
		
		carInfo1.setCState("�Ѷ�");
		
		Personcar _PerSonCar=new Personcar();
	 _PerSonCar.setUId(Long.parseLong(uid));
	 _PerSonCar.setCId(Long.parseLong(cid));
	 _PerSonCar.setCUid(Long.parseLong(uid));
	 _PerSonCar.setPState("����");
		if(perSonCarService.addPerSonCar(perSonCar)&&perSonCarService.updatePerSoncar(_PerSonCar, "����")){
			if(carInfoService.updateCarInfo(carInfo1)){
				meeag="��ϲ!:�����ɹ�,ȥ��Ա����-�ҵ�����-�ҵĶ����п�����";
			}
			else{
				meeag="����������";
			}
		}
		}
		else{
		
			meeag="�ó��Ѿ����������ȶ�����,�ٿ�����ĳ���!";
		}
		response.setContentType("text/html;charset=utf-8");
		 response.getWriter().print(meeag);
		 response.getWriter().flush();//��ջ���,ˢ��
		 response.getWriter().close();
        return "josn";

	}
	else{
		return "nouser";
	}
}
public String needxj() throws Exception {
	// TODO Auto-generated method stub
	if(chekUser()!=null){
		Personcar perSonCar=new Personcar();
		String uid=request.getParameter("uid");
		String cid=request.getParameter("cid");
		
		perSonCar.setUId(chekUser().getUId());
		perSonCar.setCUid(Long.parseLong(uid));
		perSonCar.setCId(Long.parseLong(cid));
		perSonCar.setPState("����");
		String state="�¼�";
		Carinfo carInfo1=new Carinfo();
		carInfo1.setCId(Long.parseLong(cid));
		carInfo1.setUId(Long.parseLong(uid));
		carInfo1.setCState("�¼�");
		String meeag=null;
		if(perSonCarService.updatePerSoncar(perSonCar, state)){
			
			if(carInfoService.updateCarInfo(carInfo1)){
				meeag="��ʾ:�¼ܳɹ�,ȥ��Ա����-�ҵĳ�-�¼ܵĳ�������";					}
			else{
				meeag="����������";
			}
	
			
			
		}
		 response.getWriter().print(meeag);
		 response.getWriter().flush();//��ջ���,ˢ��
		 response.getWriter().close();
        return "josn";

	}
	else{
		return "nouser";
	}
}
public String needmaiche() throws Exception {
	// TODO Auto-generated method stub
	if(chekUser()!=null){
		
		
		  Map<Integer, Cartype> typeMap=		 carTypeService.getAllCarType();
		  request.setAttribute("cartype", typeMap);
		 
				
        return "needmaiche";

	}
	else{
		return "nouser";
	}
}
public String logincar() throws Exception {
	// TODO Auto-generated method stub
	if(chekUser()!=null){
		String brand=request.getParameter("selq");
		String cx=request.getParameter("ccx");
		String cxi=request.getParameter("ccxi");
		String sptime=request.getParameter("buytime");
		String dis=request.getParameter("mialval");
		request.setAttribute("brad", brand);
		request.setAttribute("cx", cx);
		request.setAttribute("cxi", cxi);
		request.setAttribute("sptime", sptime);
		request.setAttribute("dis", dis);
		
		
        return "logincar";

	}
	else{
		return "nouser";
	}
}
public String tjmc() throws Exception {
	// TODO Auto-generated method stub
	 Userinfo3 userInfo=chekUser();
	if(userInfo!=null){
		try{
		Personcar perSonCar=new Personcar();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");  
			//carinfo
			Carinfo carInfo=new Carinfo();
			carInfo.setUId(chekUser().getUId());
			carInfo.setCSccount(new Long(0));
			carInfo.setCState("�����");
			carInfo.setCCount(new Long(0));
			
		    Date date=new Date();
			carInfo.setCSjtime(date);
			
	String brand=		request.getParameter("brad");
	carInfo.setCBrand(brand);
	String series=request.getParameter("cx");
	carInfo.setCSeries(series);
	String releaseyear=request.getParameter("fxn");
	carInfo.setCReleaseyear(Integer.parseInt(releaseyear));
	String volume=request.getParameter("dis");
	carInfo.setCVolume(Double.parseDouble(volume));
	String geartype=request.getParameter("speed");
	carInfo.setCGeartype(geartype);
	String code=request.getParameter("carbh");
	carInfo.setCCode(code);
	String model=request.getParameter("carxh");
	carInfo.setCModel(model);
	String licencetime=request.getParameter("stime");
	
	carInfo.setCLicencetime(sdf.parse(licencetime));
	String distance=request.getParameter("travel");
	carInfo.setCDistance(Double.parseDouble(distance));
	String emissonstandard=request.getParameter("stan");
	carInfo.setCEmissionstandard(emissonstandard);
	String price=request.getParameter("price");
	carInfo.setCPrice(Double.parseDouble(price));
	String img=request.getParameter("ttp");
	carInfo.setCImg("tepimages/"+img+"");
	String type=request.getParameter("cxi");
	carInfo.setCType(type);
	String czzx=request.getParameter("txta");
	carInfo.setCCzzx(czzx);
	if(carInfoService.addCarInfo(carInfo)){
		//basicinfo
Carinfo _carInfo=	  carInfoService.getCarInfoByUMN(carInfo);

Basicinfo basicInfo=new Basicinfo();
		basicInfo.setUId(userInfo.getUId());
		basicInfo.setCId(_carInfo.getCId());
		String aidd=request.getParameter("ytime");
		basicInfo.setAidd(sdf.parse(aidd));
		String srdt=request.getParameter("ytime1");
		basicInfo.setSrdt(sdf.parse(srdt));
		String bodycolor=request.getParameter("carcolor");
		basicInfo.setBodycolor(bodycolor);
		String interiorcolor=request.getParameter("carincolor");
		basicInfo.setInteriorcolor(interiorcolor);
		String domf=request.getParameter("data");
		basicInfo.setDomf(sdf.parse(domf));
		String orgin=request.getParameter("area");
		basicInfo.setOrgin(orgin);
		String cimd=request.getParameter("duedate");
		basicInfo.setCimd(cimd);
	  if(	basicInfoService.addBasicInfo(basicInfo)){
		  //hardware
		 
		  Hardwareconfig hardwareConfig=new Hardwareconfig();
		  hardwareConfig.setUId(userInfo.getUId());
		  hardwareConfig.setCId(_carInfo.getCId());
		  String  consolelcdscreen=request.getParameter("rad1");
		  hardwareConfig.setConsolelcdscreen(consolelcdscreen);
		  String   autolight=request.getParameter("rad2");
		  hardwareConfig.setAutolight(autolight);
		  String   headlights=request.getParameter("rad8");
		  hardwareConfig.setHeadlights(headlights);
		  String  lightwash=request.getParameter("rad-2");
		  hardwareConfig.setLightwash(lightwash);
		  String  efgv=request.getParameter("rad-3");
		  hardwareConfig.setEfgv(efgv);
		  String   seatnumber=request.getParameter("sate");
		  hardwareConfig.setSeatnumber(Integer.parseInt(seatnumber));
		  String   fuelform=request.getParameter("fuel");
		  hardwareConfig.setFuelform(fuelform);
		  String  cvt=request.getParameter("speed");
		  hardwareConfig.setCvt(cvt);
		  String   drivingmethod=request.getParameter("method");
		  hardwareConfig.setDrivingmethod(drivingmethod);
		  String  pke=request.getParameter("rad-key");
		  hardwareConfig.setPke(pke);
		  String  keylessgo=request.getParameter("rad-5");
		  hardwareConfig.setKeylessgo(keylessgo);
		  String  sunroof=request.getParameter("rad-6");
		  hardwareConfig.setSunroof(sunroof);
		  String  leatherseat=request.getParameter("rad-7");
		  hardwareConfig.setLeatherseat(leatherseat);
		if(  hardwareConfigService.addHardwareConfig(hardwareConfig)){
			Systemconfig systemConfig=new Systemconfig();
			
			systemConfig.setUId(userInfo.getUId());
			systemConfig.setCId(_carInfo.getCId());
			String  guidancesystem=request.getParameter("rad");
			systemConfig.setGuidancesystem(guidancesystem);
			String alb=request.getParameter("rad5");
			systemConfig.setAlb(alb);
			String fpg=request.getParameter("rad6");
			systemConfig.setFpg(fpg);
			String rpg=request.getParameter("rad7");
			systemConfig.setRpg(rpg);
			String rcpa=request.getParameter("rad9");
			systemConfig.setRcpa(rcpa);
			String dsea=request.getParameter("rad0");
			systemConfig.setDsea(dsea);
			String fsea=request.getParameter("rad-1");
			systemConfig.setFsea(fsea);
			String dlcc=request.getParameter("rad-4");
			systemConfig.setDlcc(dlcc);
			String hfs=request.getParameter("rad-8");
			systemConfig.setHfs(hfs);
			String hrs=request.getParameter("rad-9");
			systemConfig.setHrs(hrs);
			String fsv=request.getParameter("rad-qtf");
			systemConfig.setFsv(fsv);
			String rsv=request.getParameter("rad-htf");
			systemConfig.setRsv(rsv);
			String fsm=request.getParameter("rad-0");
			systemConfig.setFsm(fsm);
			String rsm=request.getParameter("rad-hjy");
			systemConfig.setRsm(rsm);
			String rvmh=request.getParameter("rad3");
			systemConfig.setRvmh(rvmh);
			String ess=request.getParameter("rad4");
		    systemConfig.setEss(ess);
		  if(  systemConfigService.addSystemConfig(systemConfig)){
			  Procedureinfo procedureInfo=new Procedureinfo();
			 
			  procedureInfo.setUId(userInfo.getUId());
			  procedureInfo.setCId(_carInfo.getCId());
			  String purchasetax=request.getParameter("buy");
			  procedureInfo.setPurchasetax(purchasetax);
			  String drivinglicense =request.getParameter("rad-a");
			  procedureInfo.setDrivinglicense(drivinglicense);
			  String ncw=request.getParameter("xczb");
			  procedureInfo.setNcw(ncw);
			  String registration =request.getParameter("rad-b");
			  procedureInfo.setRegistration(registration);
			  String newinvoice =request.getParameter("rad-c");
			  procedureInfo.setNewinvoice(newinvoice);
			  String key=request.getParameter("key");
			  procedureInfo.setKey(Integer.parseInt(key));
			  String transfertimes =request.getParameter("numm");
			  procedureInfo.setTransfertimes(Integer.parseInt(transfertimes));
			  String transgerticket =request.getParameter("ghp");
			  procedureInfo.setTransferticket(transgerticket);
			  if(procedureInfoService.addProcedureInfo(procedureInfo)){
				  Sellinfo sellInfo=new Sellinfo();
				 
				  sellInfo.setUId(userInfo.getUId());
				  sellInfo.setCId(_carInfo.getCId());
				  String pricetype=request.getParameter("p-type");
				  sellInfo.setPricetype(pricetype);
				  String transferfee =request.getParameter("rad-d");
				  sellInfo.setTransferfee(transferfee);
				  String stage=request.getParameter("rad-f");
				  sellInfo.setStage(stage);
				  if(sellInfoService.addSellInfo(sellInfo)){
					  Imagesinfo carImagesInfo=new Imagesinfo();
					
					  carImagesInfo.setUId(userInfo.getUId());
					  carImagesInfo.setCId(_carInfo.getCId());
					  String image1=request.getParameter("ftp1");
					  if(image1!=null&&!image1.equals("")){
						  carImagesInfo.setImage1("tepimages/"+image1+"");
					  }
					  String image2=request.getParameter("ftp2");
					  if(image2!=null&&!image2.equals("")){
						  carImagesInfo.setImage2("tepimages/"+image2+"");
					  }
					  String image3=request.getParameter("ftp3");
					  if(image3!=null&&!image3.equals("")){
						  carImagesInfo.setImage3("tepimages/"+image3+"");
					  }
					  String image4=request.getParameter("ftp4");
					  if(image4!=null&&!image4.equals("")){
						  carImagesInfo.setImage4("tepimages/"+image4+"");
					  }
					  String image5=request.getParameter("ftp5");
					  if(image5!=null&&!image5.equals("")){
						  carImagesInfo.setImage5("tepimages/"+image5+"");
					  }
					  String image6=request.getParameter("ftp6");
					  if(image6!=null&&!image6.equals("")){
						  carImagesInfo.setImage6("tepimages/"+image6+"");
					  }
					  String image7=request.getParameter("ftp7");
					  if(image7!=null&&!image7.equals("")){
						  carImagesInfo.setImage7("tepimages/"+image7+"");
					  }
					  String image8=request.getParameter("ftp8");
					  if(image8!=null&&!image8.equals("")){
						  carImagesInfo.setImage8("tepimages/"+image8+"");
					  }
					  String image9=request.getParameter("ftp9");
					  if(image9!=null&&!image9.equals("")){
						  carImagesInfo.setImage9("tepimages/"+image9+"");
					  }
					  String image10=request.getParameter("ftp10");
					  if(image10!=null&&!image10.equals("")){
						  carImagesInfo.setImage10("tepimages/"+image10+"");
					  }
					  if(carImagesInfoService.addCarImagesInfo(carImagesInfo)){
						  perSonCar.setPState("�����");
						  perSonCar.setUId(userInfo.getUId());
						  perSonCar.setCUid(userInfo.getUId());
						  perSonCar.setCId(_carInfo.getCId());
						  if(perSonCarService.addPerSonCar(perSonCar)){
							 this.setTzCid(perSonCar.getCId());
							 this.setTzUid(perSonCar.getUId());
							  request.setAttribute("xiaoxi", "�ύ�ɹ�,���ǽ������϶����ṩ����Ϣ�������,�ɽ���<a href='MemberCenter_showmenberSh.action'>��Ա����-�ҵ�����-����еĳ����в鿴</a>");
							 
						  }
					  }
						 
					  }
				  }
			  }
		  }
		}
	  }
	return "tjmc";
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "ERROR";
		}

	}
	else{
		return "nouser";
	}
}
public String uptj() throws Exception {
	// TODO Auto-generated method stub
	 Userinfo3 userInfo=chekUser();
	if(userInfo!=null){
		try{
		Personcar perSonCar=new Personcar();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");  
			//carinfo
			Carinfo carInfo=new Carinfo();
			carInfo.setCId(Long.parseLong(request.getParameter("cid")));
			
			
			carInfo.setCCount(new Long(0));
			carInfo.setCSccount(new Long(0));
	String brand=		request.getParameter("brad");
	carInfo.setCBrand(brand);
	String series=request.getParameter("cx");
	carInfo.setCSeries(series);
	String releaseyear=request.getParameter("fxn");
	carInfo.setCReleaseyear(Integer.parseInt(releaseyear));
	String volume=request.getParameter("dis");
	carInfo.setCVolume(Double.parseDouble(volume));
	String geartype=request.getParameter("speed");
	carInfo.setCGeartype(geartype);
	String code=request.getParameter("carbh");
	carInfo.setCCode(code);
	String model=request.getParameter("carxh");
	carInfo.setCModel(model);
	String licencetime=request.getParameter("stime");
	carInfo.setCLicencetime(sdf.parse(licencetime));
	String distance=request.getParameter("travel");
	carInfo.setCDistance(Double.parseDouble(distance));
	String emissonstandard=request.getParameter("stan");
	carInfo.setCEmissionstandard(emissonstandard);
	String price=request.getParameter("price");
	carInfo.setCPrice(Double.parseDouble(price));
	String img=request.getParameter("ttp");
	carInfo.setCImg(img);
	String type=request.getParameter("cxi");
	carInfo.setCType(type);
	String czzx=request.getParameter("txta");
	carInfo.setCCzzx(czzx);
	if(carInfoService.updateCarAll(carInfo)){
		//basicinfo

Basicinfo basicInfo=new Basicinfo();
		basicInfo.setUId(userInfo.getUId());
		basicInfo.setCId(carInfo.getCId());
		String aidd=request.getParameter("ytime");
		basicInfo.setAidd(sdf.parse(aidd));
		String srdt=request.getParameter("ytime1");
		basicInfo.setSrdt(sdf.parse(srdt));
		String bodycolor=request.getParameter("carcolor");
		basicInfo.setBodycolor(bodycolor);
		String interiorcolor=request.getParameter("carincolor");
		basicInfo.setInteriorcolor(interiorcolor);
		String domf=request.getParameter("data");
		basicInfo.setDomf(sdf.parse(domf));
		String orgin=request.getParameter("area");
		basicInfo.setOrgin(orgin);
		String cimd=request.getParameter("duedate");
		basicInfo.setCimd(cimd);
	  if(	basicInfoService.updateBasicInfo(basicInfo)){
		  //hardware
		  
		  Hardwareconfig hardwareConfig=new Hardwareconfig();
		  hardwareConfig.setUId(userInfo.getUId());
		  hardwareConfig.setCId(carInfo.getCId());
		  String  consolelcdscreen=request.getParameter("rad1");
		  hardwareConfig.setConsolelcdscreen(consolelcdscreen);
		  String   autolight=request.getParameter("rad2");
		  hardwareConfig.setAutolight(autolight);
		  String   headlights=request.getParameter("rad8");
		  hardwareConfig.setHeadlights(headlights);
		  String  lightwash=request.getParameter("rad-2");
		  hardwareConfig.setLightwash(lightwash);
		  String  efgv=request.getParameter("rad-3");
		  hardwareConfig.setEfgv(efgv);
		  String   seatnumber=request.getParameter("sate");
		  hardwareConfig.setSeatnumber(Integer.parseInt(seatnumber));
		  String   fuelform=request.getParameter("fuel");
		  hardwareConfig.setFuelform(fuelform);
		  String  cvt=request.getParameter("speed");
		  hardwareConfig.setCvt(cvt);
		  String   drivingmethod=request.getParameter("method");
		  hardwareConfig.setDrivingmethod(drivingmethod);
		  String  pke=request.getParameter("rad-key");
		  hardwareConfig.setPke(pke);
		  String  keylessgo=request.getParameter("rad-5");
		  hardwareConfig.setKeylessgo(keylessgo);
		  String  sunroof=request.getParameter("rad-6");
		  hardwareConfig.setSunroof(sunroof);
		  String  leatherseat=request.getParameter("rad-7");
		  hardwareConfig.setLeatherseat(leatherseat);
		if(  hardwareConfigService.updateHardwareConfig(hardwareConfig)){
			Systemconfig systemConfig=new Systemconfig();
			
			systemConfig.setUId(userInfo.getUId());
			systemConfig.setCId(carInfo.getCId());
			String  guidancesystem=request.getParameter("rad");
			systemConfig.setGuidancesystem(guidancesystem);
			String alb=request.getParameter("rad5");
			systemConfig.setAlb(alb);
			String fpg=request.getParameter("rad6");
			systemConfig.setFpg(fpg);
			String rpg=request.getParameter("rad7");
			systemConfig.setRpg(rpg);
			String rcpa=request.getParameter("rad9");
			systemConfig.setRcpa(rcpa);
			String dsea=request.getParameter("rad0");
			systemConfig.setDsea(dsea);
			String fsea=request.getParameter("rad-1");
			systemConfig.setFsea(fsea);
			String dlcc=request.getParameter("rad-4");
			systemConfig.setDlcc(dlcc);
			String hfs=request.getParameter("rad-8");
			systemConfig.setHfs(hfs);
			String hrs=request.getParameter("rad-9");
			systemConfig.setHrs(hrs);
			String fsv=request.getParameter("rad-qtf");
			systemConfig.setFsv(fsv);
			String rsv=request.getParameter("rad-htf");
			systemConfig.setRsv(rsv);
			String fsm=request.getParameter("rad-0");
			systemConfig.setFsm(fsm);
			String rsm=request.getParameter("rad-hjy");
			systemConfig.setRsm(rsm);
			String rvmh=request.getParameter("rad3");
			systemConfig.setRvmh(rvmh);
			String ess=request.getParameter("rad4");
		    systemConfig.setEss(ess);
		  if(  systemConfigService.updateSystemConfig(systemConfig)){
			  Procedureinfo procedureInfo=new Procedureinfo();
			
			  procedureInfo.setUId(userInfo.getUId());
			  procedureInfo.setCId(carInfo.getCId());
			  String purchasetax=request.getParameter("buy");
			  procedureInfo.setPurchasetax(purchasetax);
			  String drivinglicense =request.getParameter("rad-a");
			  procedureInfo.setDrivinglicense(drivinglicense);
			  String ncw=request.getParameter("xczb");
			  procedureInfo.setNcw(ncw);
			  String registration =request.getParameter("rad-b");
			  procedureInfo.setRegistration(registration);
			  String newinvoice =request.getParameter("rad-c");
			  procedureInfo.setNewinvoice(newinvoice);
			  String key=request.getParameter("key");
			  procedureInfo.setKey(Integer.parseInt(key));
			  String transfertimes =request.getParameter("numm");
			  procedureInfo.setTransfertimes(Integer.parseInt(transfertimes));
			  String transgerticket =request.getParameter("ghp");
			  procedureInfo.setTransferticket(transgerticket);
			  if(procedureInfoService.updateProcedureInfo(procedureInfo)){
				  Sellinfo sellInfo=new Sellinfo();
				
				  sellInfo.setUId(userInfo.getUId());
				  sellInfo.setCId(carInfo.getCId());
				  String pricetype=request.getParameter("p-type");
				  sellInfo.setPricetype(pricetype);
				  String transferfee =request.getParameter("rad-d");
				  sellInfo.setTransferfee(transferfee);
				  String stage=request.getParameter("rad-f");
				  sellInfo.setStage(stage);
				  if(sellInfoService.updateSellInfo(sellInfo)){
					Imagesinfo carImagesInfo=new Imagesinfo();
					 
					  carImagesInfo.setUId(userInfo.getUId());
					  carImagesInfo.setCId(carInfo.getCId());
					  String image1=request.getParameter("ftp1");
					  if(image1!=null&&!image1.equals("")){
						  carImagesInfo.setImage1(image1);
					  }
					  String image2=request.getParameter("ftp2");
					  if(image2!=null&&!image2.equals("")){
						  carImagesInfo.setImage2(image2);
					  }
					  String image3=request.getParameter("ftp3");
					  if(image3!=null&&!image3.equals("")){
						  carImagesInfo.setImage3(image3);
					  }
					  String image4=request.getParameter("ftp4");
					  if(image4!=null&&!image4.equals("")){
						  carImagesInfo.setImage4(image4);
					  }
					  String image5=request.getParameter("ftp5");
					  if(image5!=null&&!image5.equals("")){
						  carImagesInfo.setImage5(image5);
					  }
					  String image6=request.getParameter("ftp6");
					  if(image6!=null&&!image6.equals("")){
						  carImagesInfo.setImage6(image6);
					  }
					  String image7=request.getParameter("ftp7");
					  if(image7!=null&&!image7.equals("")){
						  carImagesInfo.setImage7(image7);
					  }
					  String image8=request.getParameter("ftp8");
					  if(image8!=null&&!image8.equals("")){
						  carImagesInfo.setImage8(image8);
					  }
					  String image9=request.getParameter("ftp9");
					  if(image9!=null&&!image9.equals("")){
						  carImagesInfo.setImage9(image9);
					  }
					  String image10=request.getParameter("ftp10");
					  if(image10!=null&&!image10.equals("")){
						  carImagesInfo.setImage10(image10);
					  }
					  if(carImagesInfoService.updateCarImagesInfo(carImagesInfo)){
						  request.setAttribute("xiaoxi", "�޸ĳɹ�,�����<a href='MemberCenter_showmenberbjj.action'>��Ա����-�ҵĳ�-���δͨ���ĳ��ٴ��ύ��</a>");
							this.setTzCid(carInfo.getCId());
							this.setTzUid(userInfo.getUId());
						
							
					  }
				  }
			  }
		  }
		}
	  }
	}
	 return "uptj";
		}
		catch (Exception e) {
			// TODO: handle exception
			return "ERROR";
		}
	}
	else{
		return "nouser";
	}
}
public String showdea() throws Exception {
	// TODO Auto-generated method stub
	if(chekUser()!=null){
		String cid=		request.getParameter("cid");
		String uid=		request.getParameter("uid");
		this.setTzCid(Long.parseLong(cid));
		this.setTzUid(Long.parseLong(uid));
			
        return "showdea";

	}
	else{
		return "nouser";
	}
}
public String upmc() throws Exception {
	// TODO Auto-generated method stub
	if(chekUser()!=null){
		Carinfo carInfo=new Carinfo();
		carInfo.setUId(chekUser().getUId());
		carInfo.setCId(Long.parseLong(request.getParameter("cid")));
		
		Carinfo _carInfo=carInfoService.getCarByWhere(carInfo).get(carInfo.getCId());
		request.setAttribute("car", _carInfo);

Basicinfo basicInfo= basicInfoService.getAllBasicById(carInfo);
request.setAttribute("bas", basicInfo); 

 Hardwareconfig hardwareConfig= hardwareConfigService.getHardwareConfigById(carInfo);
 request.setAttribute("hard", hardwareConfig); 
 
 
 Systemconfig systemConfig= systemConfigService.getSystemConfigById(carInfo);
 request.setAttribute("sys", systemConfig);

 Sellinfo sellInfo= sellInfoService.getSellInfoById(carInfo);
 request.setAttribute("sell", sellInfo); 

 Procedureinfo procedureInfo=  procedureInfoService.getProcedureInfoById(carInfo);
 request.setAttribute("proce", procedureInfo); 
 
Map<Integer, String> imgMap= carImagesInfoService.getCarImagesInfoByID(carInfo); 
for(Integer key:imgMap.keySet()){
	request.setAttribute("k"+key.toString(), imgMap.get(key));
}


        return "upmc";

	}
	else{
		return "nouser";
	}
}
public String comment() throws Exception {
	// TODO Auto-generated method stub
	if(chekUser()!=null){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss"); 
		Personneed personNeed=new Personneed();
		personNeed.setUId(chekUser().getUId());
		String p_brand=new String(request.getParameter("sel1").getBytes("ISO8859-1"),"UTF-8");
		String p_series=new String(request.getParameter("ccx").getBytes("ISO8859-1"),"UTF-8");
		String p_age=new String(request.getParameter("ccxi").getBytes("ISO8859-1"),"UTF-8");
		String p_price=new String(request.getParameter("cprice").getBytes("ISO8859-1"),"UTF-8");
		String p_time=new String(request.getParameter("buytime").getBytes("ISO8859-1"),"UTF-8");
		String p_miaoshu=new String(request.getParameter("content").getBytes("ISO8859-1"),"UTF-8");
		personNeed.setPAge(p_age);
		personNeed.setPBrand(p_brand);
        personNeed.setPMiaoshu(p_miaoshu);
        personNeed.setPPrice(p_price);
        personNeed.setPTime(sdf.parse(p_time));
        personNeed.setPSeries(p_series);
        personNeed.setPState("������");
      
	    Date date=new Date();
	    personNeed.setPTjtime(date);
	  String message=null;
	  PersonNeedServiceImpl personNeedServiceImpl=new PersonNeedServiceImpl();
	  if(personNeedServiceImpl.getPerSonNeed(personNeed)==null){
	  if(personNeedServiceImpl.addPersonNeed(personNeed)){
		  message="��ϲ���ύ�ɹ�,�����Ա���ġ��ҵ�����-˽�˶��ƿ�����";
	  }
	  else{
		  message="��Ǹ��������һ������";
	  }
	}
	  else{
		  message="�벻Ҫ�ظ��ύ";
	  }
	  response.getWriter().print(message);
	  response.getWriter().flush();//��ջ���,ˢ��
	  response.getWriter().close();
        return "josn";

	}
	else{
		return "nouser";
	}
}
public String showsrdz() throws Exception {
	// TODO Auto-generated method stub
	if(chekUser()!=null){
		Personneed personNeed=new Personneed();
		personNeed.setUId(chekUser().getUId());
		this.fenyepn(request,  personNeed);
		DbUtil.closeAll();
		
        return "showsrdz";

	}
	else{
		return "nouser";
	}
}
public String liuyan() throws Exception {
	// TODO Auto-generated method stub
	if(chekUser()!=null){
		Comment1 comment=new Comment1();
		comment.setUId(chekUser().getUId());
		comment.setCText(new String(request.getParameter("text").getBytes("iso8859-1"),"UTF-8"));
	
	    Date date=new Date();
	    comment.setCDate(date);
	 
	    if(commentServiceImpl.addComment(comment)){
	    	response.setContentType("text/html;charset=utf-8");
			 response.getWriter().print(1);
			 response.getWriter().flush();//��ջ���,ˢ��
			 response.getWriter().close();
	    
	    }
        return "josn";

	}
	else{
		return "nouser";
	}
}


   private Userinfo3 chekUser(){
	   Userinfo3 userinfo=null;
		Object object = session.get("userinfo");
		if(object!=null){
			userinfo=(Userinfo3) object;
		}
	   return userinfo;
   }
   private void fenye(HttpServletRequest req, Personcar perSonCar){
		
		
		try {
		int curPage=0;
		if(req.getParameter("jumpPage")!=null){
		 curPage =Integer.parseInt(req.getParameter("jumpPage"));
	 }
		
		
  
	 long maxRowsCount=personCarPage.queryPersonCarCount(perSonCar);
		//�����ҳ�߼�<=>����
		PageUtil pageUtil=new PageUtil(4, maxRowsCount);
		// ����ҳ���߼�
		if (curPage <= 1) {

			pageUtil.setCurPage(1);
		} else if (curPage >= pageUtil.getMaxPage()) {

			pageUtil.setCurPage(pageUtil.getMaxPage());
		} else {
			pageUtil.setCurPage(curPage);
		}
		
		
		Map<Long, Object> carMap=personCarPage.showPersonCarList(pageUtil.getCurPage(),pageUtil.getRowsPrePage(), perSonCar);
		DbUtil.closeAll();
		Map<Long, Carinfo> _carMap=new HashMap<Long, Carinfo>();
		for(Long key:carMap.keySet()){
			Carinfo _carInfo=(Carinfo) carMap.get(key);
		_carMap.put(_carInfo.getCId() ,_carInfo);
		}
		req.setAttribute("szCar", _carMap);
		req.setAttribute("rowsPrePage", pageUtil.getRowsPrePage());
		req.setAttribute("maxRowCount", pageUtil.getMaxRowsCount());
		req.setAttribute("maxPage", pageUtil.getMaxPage());
		req.setAttribute("jumpPage", curPage);
		req.setAttribute("curPage", pageUtil.getCurPage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	 }
private void fenyepn(HttpServletRequest req, Personneed personNeed){
		
		
		try {
		int curPage=0;
		if(req.getParameter("jumpPage")!=null){
		 curPage =Integer.parseInt(req.getParameter("jumpPage"));
	 }
		
		
  
	 long maxRowsCount=personNeedPage.queryPersonCarCount(personNeed);
		//�����ҳ�߼�<=>����
		PageUtil pageUtil=new PageUtil(4, maxRowsCount);
		// ����ҳ���߼�
		if (curPage <= 1) {

			pageUtil.setCurPage(1);
		} else if (curPage >= pageUtil.getMaxPage()) {

			pageUtil.setCurPage(pageUtil.getMaxPage());
		} else {
			pageUtil.setCurPage(curPage);
		}
		
		
		Map<Long, Object> carMap=personNeedPage.showPersonCarList(pageUtil.getCurPage(),pageUtil.getRowsPrePage(), personNeed);
		DbUtil.closeAll();
		Map<Long, Personneed> _carMap=new HashMap<Long, Personneed>();
		for(Long key:carMap.keySet()){
			Personneed _PersonNeed=(Personneed) carMap.get(key);
		_carMap.put( _PersonNeed.getPId(),_PersonNeed);
		}
		req.setAttribute("szCar", _carMap);
		req.setAttribute("rowsPrePage", pageUtil.getRowsPrePage());
		req.setAttribute("maxRowCount", pageUtil.getMaxRowsCount());
		req.setAttribute("maxPage", pageUtil.getMaxPage());
		req.setAttribute("jumpPage", curPage);
		req.setAttribute("curPage", pageUtil.getCurPage());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	 }
	private void finishop(HttpServletRequest req,Personcar perSonCar,Userinfo3 userInfo,Carinfo carInfo){
		String uid=req.getParameter("uid");
		String cid=req.getParameter("cid");
		
		perSonCar.setUId(userInfo.getUId());
		perSonCar.setCUid(Long.parseLong(uid));
		perSonCar.setCId(Long.parseLong(cid));
		if(carInfo!=null){
		carInfo.setCId(Long.parseLong(cid));
		carInfo.setUId(Long.parseLong(uid));
		}
	}

	

}
