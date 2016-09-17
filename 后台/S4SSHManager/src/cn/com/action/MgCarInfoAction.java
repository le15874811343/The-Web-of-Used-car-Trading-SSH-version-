package cn.com.action;

import java.util.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import cn.com.pojo.*;
import cn.com.dao.*;
import cn.com.service.*;
import cn.com.service.impl.*;
import cn.com.util.*;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 汽车管理action
 * 
 */
public class MgCarInfoAction extends ActionSupport implements ServletRequestAware,SessionAware ,ServletResponseAware{
	private HttpServletRequest request;  //request
	private Map<String, Object> session; //session
	private ICarInfoService carInfoService=null; //汽车概要信息服务接口的引用
	private IPageDao carInfoPage=null; //分页处理操作接口的引用（指向汽车概要信息操作实现类）
	private ICarBrandService  brandServiceImpl=null; //汽车品牌信息服务接口的引用
	private HttpServletResponse response=null; //response
  private	IPerSonCarService personCarServiceImpl=null;  //个人汽车订单服务接口的引用
 
  private HardwareConfigServiceImpl hardwareConfigServiceImpl=null; //汽车硬件配置信息服务接口的引用
  private	ProcedureInfoServiceImpl procedureInfoServiceImpl=null; //手续信息服务接口的引用
  private	SystemConfigServiceImpl systemConfigServiceImpl=null; //汽车系统配置信息服务接口的引用
  private	SellInfoServiceImpl sellInfoServiceImpl=null;  //销售信息服务接口的引用
  private	CarImagesInfoServiceImpl carImagesInfoServiceImpl=null; //汽车图片服务接口的引用
  private	IBasicInfoService basicInfoServiceImpl=null;  //汽车基础信息服务接口的引用
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
	
	
	public ICarBrandService getBrandServiceImpl() {
		return brandServiceImpl;
	}
	public void setBrandServiceImpl(ICarBrandService brandServiceImpl) {
		this.brandServiceImpl = brandServiceImpl;
	}
	public ICarInfoService getCarInfoService() {
		return carInfoService;
	}
	public void setCarInfoService(ICarInfoService carInfoService) {
		this.carInfoService = carInfoService;
	}
	public IPageDao getCarInfoPage() {
		return carInfoPage;
	}
	public void setCarInfoPage(IPageDao carInfoPage) {
		this.carInfoPage = carInfoPage;
	}
	
	public IPerSonCarService getPersonCarServiceImpl() {
		return personCarServiceImpl;
	}
	public void setPersonCarServiceImpl(IPerSonCarService personCarServiceImpl) {
		this.personCarServiceImpl = personCarServiceImpl;
	}
	
	
	public HardwareConfigServiceImpl getHardwareConfigServiceImpl() {
		return hardwareConfigServiceImpl;
	}
	public void setHardwareConfigServiceImpl(
			HardwareConfigServiceImpl hardwareConfigServiceImpl) {
		this.hardwareConfigServiceImpl = hardwareConfigServiceImpl;
	}
	public ProcedureInfoServiceImpl getProcedureInfoServiceImpl() {
		return procedureInfoServiceImpl;
	}
	public void setProcedureInfoServiceImpl(
			ProcedureInfoServiceImpl procedureInfoServiceImpl) {
		this.procedureInfoServiceImpl = procedureInfoServiceImpl;
	}
	public SystemConfigServiceImpl getSystemConfigServiceImpl() {
		return systemConfigServiceImpl;
	}
	public void setSystemConfigServiceImpl(
			SystemConfigServiceImpl systemConfigServiceImpl) {
		this.systemConfigServiceImpl = systemConfigServiceImpl;
	}
	public SellInfoServiceImpl getSellInfoServiceImpl() {
		return sellInfoServiceImpl;
	}
	public void setSellInfoServiceImpl(SellInfoServiceImpl sellInfoServiceImpl) {
		this.sellInfoServiceImpl = sellInfoServiceImpl;
	}
	public CarImagesInfoServiceImpl getCarImagesInfoServiceImpl() {
		return carImagesInfoServiceImpl;
	}
	public void setCarImagesInfoServiceImpl(
			CarImagesInfoServiceImpl carImagesInfoServiceImpl) {
		this.carImagesInfoServiceImpl = carImagesInfoServiceImpl;
	}
	public IBasicInfoService getBasicInfoServiceImpl() {
		return basicInfoServiceImpl;
	}
	public void setBasicInfoServiceImpl(IBasicInfoService basicInfoServiceImpl) {
		this.basicInfoServiceImpl = basicInfoServiceImpl;
	}
	/**
	 * 展示车辆列表action
	 */
	public String showlist() throws Exception {
		// TODO Auto-generated method stub
		Carinfo carInfo=new Carinfo();
		fenye(request,  carInfo);
	
		request.setAttribute("allbrand", brandServiceImpl.getAllBrand());
		
		return "showlist";
	}
	/**
	 * 展示在售的汽车action
	 */
	public String showzs() throws Exception {
		// TODO Auto-generated method stub
		Carinfo carInfo=new Carinfo();
		carInfo.setCState("在售");
		fenye(request, carInfo);
		
		request.setAttribute("allbrand", brandServiceImpl.getAllBrand());
		
		return "showzs";
	}
	/**
	 * 展示审核中的车action
	 */
	public String showsh() throws Exception {
		// TODO Auto-generated method stub
		Carinfo carInfo=new Carinfo();
		carInfo.setCState("审核中");
		fenye(request,carInfo);
		
		request.setAttribute("allbrand", brandServiceImpl.getAllBrand());
	
	
		return "showsh";
	}
	/**
	 * 展示下架的车action
	 */
	public String showxj() throws Exception {
		// TODO Auto-generated method stub
		Carinfo carInfo=new Carinfo();
		carInfo.setCState("下架");
		fenye(request, carInfo);
		
		request.setAttribute("allbrand", brandServiceImpl.getAllBrand());
		
		return "showxj";
	}
	/**
	 * 展示未通过的车action
	 */
	public String showwtg() throws Exception {
		// TODO Auto-generated method stub
		Carinfo carInfo=new Carinfo();
		carInfo.setCState("未通过");
		fenye(request, carInfo);
		
		request.setAttribute("allbrand", brandServiceImpl.getAllBrand());
		
		return "showwtg";
	}
	/**
	 * 展示所有条件查询出的车action
	 */
	public String showwhere() throws Exception {
		// TODO Auto-generated method stub
		String pp=request.getParameter("cpp");
		String cx=request.getParameter("ccx");
	
		Carinfo carInfo=new Carinfo();
		if(cx!=null&&!cx.equals("")){
			carInfo.setCSeries(cx);
		}
		if(pp!=null&&!pp.equals("")){
			carInfo.setCBrand(pp);
		}
		
		
		request.setAttribute("allbrand", brandServiceImpl.getAllBrand());
		fenye(request, carInfo);
		request.setAttribute("pp", pp);
		request.setAttribute("cx", cx);
		
		return "showwhere";
	}
	/**
	 * 展示在售的条件查询出的车action
	 */
	public String showzswhere() throws Exception {
		// TODO Auto-generated method stub
		String pp=request.getParameter("cpp");
		String cx=request.getParameter("ccx");
	
		Carinfo carInfo=new Carinfo();
		carInfo.setCState("在售");
		if(cx!=null&&!cx.equals("")){
			carInfo.setCSeries(cx);
		}
		if(pp!=null&&!pp.equals("")){
			carInfo.setCBrand(pp);
		}
		
		request.setAttribute("allbrand", brandServiceImpl.getAllBrand());
		fenye(request, carInfo);
		request.setAttribute("pp", pp);
		request.setAttribute("cx", cx);
	
		return "showzswhere";
	}
	/**
	 * 展示审核中的条件查询出的车
	 */
	public String showshwhere() throws Exception {
		String pp=request.getParameter("cpp");
		String cx=request.getParameter("ccx");
	
		Carinfo carInfo=new Carinfo();
		carInfo.setCState("审核中");
		if(cx!=null&&!cx.equals("")){
			carInfo.setCSeries(cx);
		}
		if(pp!=null&&!pp.equals("")){
			carInfo.setCBrand(pp);
		}
		
		
		request.setAttribute("allbrand", brandServiceImpl.getAllBrand());
		fenye(request, carInfo);
		request.setAttribute("pp", pp);
		request.setAttribute("cx", cx);
	

		
		return "showshwhere";
	}
	/**
	 * 展示下架的条件查询出的车
	 */
	public String showxjwhere() throws Exception {
		// TODO Auto-generated method stub
		String pp=request.getParameter("cpp");
		String cx=request.getParameter("ccx");
	
		Carinfo carInfo=new Carinfo();
		carInfo.setCState("下架");
		if(cx!=null&&!cx.equals("")){
			carInfo.setCSeries(cx);
		}
		if(pp!=null&&!pp.equals("")){
			carInfo.setCBrand(pp);
		}
		
		
		request.setAttribute("allbrand", brandServiceImpl.getAllBrand());
		fenye(request, carInfo);
		request.setAttribute("pp", pp);
		request.setAttribute("cx", cx);
		

		return "showxjwhere";
	}
	/**
	 * 展示未通过的条件查询的车action
	 */
	public String showwtgwhere() throws Exception {
		// TODO Auto-generated method stub
		String pp=request.getParameter("cpp");
		String cx=request.getParameter("ccx");
	
		Carinfo carInfo=new Carinfo();
		carInfo.setCState("未通过");
		if(cx!=null&&!cx.equals("")){
			carInfo.setCSeries(cx);
		}
		if(pp!=null&&!pp.equals("")){
			carInfo.setCBrand(pp);
		}
		
	
		request.setAttribute("allbrand", brandServiceImpl.getAllBrand());
		fenye(request, carInfo);
		request.setAttribute("pp", pp);
		request.setAttribute("cx", cx);
	

		return "showwtgwhere";
	}
	/**
	 * 拒绝通过操作action
	 */
	public String jjtg() throws Exception {
		// TODO Auto-generated method stub
		String cid=request.getParameter("cid");
		String uid=request.getParameter("uid");
		
		
		Personcar perSonCar=new Personcar();
		perSonCar.setCId(Long.parseLong(cid));
		perSonCar.setUId(Long.parseLong(uid));
		perSonCar.setCUid(Long.parseLong(uid));
		perSonCar.setPState("审核中");
	
		
		Carinfo carInfo=new Carinfo();
		carInfo.setCId(Long.parseLong(cid));
		carInfo.setCState("未通过");
		
		if(personCarServiceImpl.updatePerSoncar(perSonCar, "未通过")&&carInfoService.updateCarInfo(carInfo)){
			 response.setContentType("text/html;charset=utf-8");
				response.getWriter().print(1);
				 response.getWriter().flush();//清空缓存,刷新
				   response.getWriter().close();
		}
		return "jjtg";
	}
	/**
	 * 允许通过操作action
	 */
	public String yxtg() throws Exception {
		// TODO Auto-generated method stub
		String cid=request.getParameter("cid");
		String uid=request.getParameter("uid");
		
		
		Personcar perSonCar=new Personcar();
		perSonCar.setCId(Long.parseLong(cid));
		perSonCar.setUId(Long.parseLong(uid));
		perSonCar.setCUid(Long.parseLong(uid));
		perSonCar.setPState("审核中");
		
	
		String newprice=request.getParameter("newprice");
	
		Carinfo carInfo=new Carinfo();
		carInfo.setCId(Long.parseLong(cid));
		carInfo.setCState("在售");
		carInfo.setNewprice(Double.parseDouble(newprice));
		
		if(personCarServiceImpl.updatePerSoncar(perSonCar, "出售")&&carInfoService.updateCarInfo(carInfo)){
			 response.setContentType("text/html;charset=utf-8");
				response.getWriter().print(1);
				 response.getWriter().flush();//清空缓存,刷新
				   response.getWriter().close();
		}
		return "yxtg";
	}
	/**
	 * 删除车操作action
	 */
	public String dellcar() throws Exception {
		// TODO Auto-generated method stub
		String cid=request.getParameter("cid");
	
		
		Hardwareconfig hardwareConfig=new Hardwareconfig();
		hardwareConfig.setCId(Long.parseLong(cid));
		if(hardwareConfigServiceImpl.deletecidhardwareconfiguser(hardwareConfig)){
			Procedureinfo procedureInfo=new Procedureinfo();
			procedureInfo.setCId(Long.parseLong(cid));
			
			if(procedureInfoServiceImpl.deletecidprocedureinfouser(procedureInfo)){
				Systemconfig systemConfig=new Systemconfig();
				systemConfig.setCId(Long.parseLong(cid));
			
				if(systemConfigServiceImpl.deletecidsystemconfiguser(systemConfig)){
					Sellinfo sellInfo=new Sellinfo();
					sellInfo.setCId(Long.parseLong(cid));
				
					if(sellInfoServiceImpl.deletecidsellinfouser(sellInfo)){
						Imagesinfo carImagesInfo=new Imagesinfo();
						carImagesInfo.setCId(Long.parseLong(cid));
					
						if(carImagesInfoServiceImpl.deletecidimagesinfouser(carImagesInfo)){
							Basicinfo basicInfo=new Basicinfo();
							basicInfo.setCId(Long.parseLong(cid));
							
							if(basicInfoServiceImpl.deletecidbasicinfo(basicInfo)){
								Carinfo carInfo=new Carinfo();
								carInfo.setCId(Long.parseLong(cid));
							
								if(carInfoService.deletecarinfo(carInfo)){
									Personcar perSonCar=new Personcar();
									perSonCar.setCId(Long.parseLong(cid));
								
									if(personCarServiceImpl.deletecidpersoncaruser(perSonCar)){
										 response.setContentType("text/html;charset=utf-8");
											response.getWriter().print(1);
											 response.getWriter().flush();//清空缓存,刷新
											   response.getWriter().close();
									}
								}
							}
						}
					}
				}
			}
		}
		
		
		
		
		
	
		return "dellcar";
	}
	/**
	 * 分页展示车辆操作
	 * 
	 */
	private void fenye(HttpServletRequest req,Carinfo carInfo){
		try {
		int curPage=0;
		if(req.getParameter("jumpPage")!=null){
		 curPage =Integer.parseInt(req.getParameter("jumpPage"));
	 }
		//设置距离参数
		String distance=null;
		if(req.getParameter("distance")!=null){
			distance = new String(req.getParameter("distance").getBytes("ISO8859-1"),"utf-8");
			}
	   Map<String, Integer> distanceMap=setDistance(distance);
		//设置价格参数
	   String price = null;
		if(req.getParameter("price")!=null){
			price = new String(req.getParameter("price").getBytes("ISO8859-1"),"utf-8");
		}
      Map<String, Integer> priceMap=setPrice(price);
      //设置车龄参数
      String age = null;
		if(req.getParameter("age")!=null){
			age = new String(req.getParameter("age").getBytes("ISO8859-1"),"utf-8");
		}
		
    Map<String, Integer> ageMap=setAge(age);
    if(req.getParameter("bname")!=null&&!req.getParameter("bname").equals("")){
    	carInfo.setCBrand(new String(req.getParameter("bname").getBytes("ISO8859-1"),"utf-8"));
    }	
	 if(req.getParameter("cser")!=null&&!req.getParameter("cser").equals("")){
		 carInfo.setCSeries(new String(req.getParameter("cser").getBytes("ISO8859-1"),"utf-8"));
	 }	
	 if(req.getParameter("tname")!=null&&!req.getParameter("tname").equals("")){
		 carInfo.setCType(new String(req.getParameter("tname").getBytes("ISO8859-1"),"utf-8"));
	 }
	 if(req.getParameter("emsi")!=null&&!req.getParameter("emsi").equals("")){
		 carInfo.setCEmissionstandard(new String(req.getParameter("emsi").getBytes("ISO8859-1"),"utf-8"));
	 }
	 long maxRowsCount=carInfoPage.queryMsgCount(carInfo,priceMap.get("minPrice"),priceMap.get("maxPrice"),distanceMap.get("minDis"),distanceMap.get("maxDis"),ageMap.get("minAge"),ageMap.get("maxAge"));
		//处理分页逻辑<=>调用
		PageUtil pageUtil=new PageUtil(7, maxRowsCount);
		// 处理页码逻辑
		if (curPage <= 1) {

			pageUtil.setCurPage(1);
		} else if (curPage >= pageUtil.getMaxPage()) {

			pageUtil.setCurPage(pageUtil.getMaxPage());
		} else {
			pageUtil.setCurPage(curPage);
		}
		String order=null;
		String _order=req.getParameter("order");
		if(_order!=null&&!_order.equals("")){
			order=_order;
		}
		
		List<Object> carMap=carInfoPage.showMsgInfoList(pageUtil.getCurPage(), pageUtil.getRowsPrePage(), carInfo,order,priceMap.get("minPrice"),priceMap.get("maxPrice"),distanceMap.get("minDis"),distanceMap.get("maxDis"),ageMap.get("minAge"),ageMap.get("maxAge"));
		DbUtil.closeAll();
		List<Object> _carMap=new ArrayList<Object>();
		for(Object o:carMap){
		Carinfo _carInfo=(Carinfo) o;
		_carMap.add( _carInfo);
		}
		req.setAttribute("bname", carInfo.getCBrand());
		req.setAttribute("tname", carInfo.getCType());
		req.setAttribute("cser", carInfo.getCSeries());
		req.setAttribute("order", order);
		req.setAttribute("age", age);
		req.setAttribute("price", price);
		req.setAttribute("distance", distance);
		req.setAttribute("emsi", carInfo.getCEmissionstandard());
		req.setAttribute("carMap", _carMap);
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
	  /**
	  * 设置距离参数的方法
	  * 
	  */
	 private Map<String, Integer> setDistance(String distance){
		   Map<String, Integer> distanceMap=new HashMap<String, Integer>();
	    DistanceUtil distanceUtil=null;
	    int minDis=0;
	    int maxDis=0;
		if(distance!=null&&!distance.equals("")){
			 distanceUtil=new DistanceUtil(distance);
			 minDis=distanceUtil.getMinDis();
			 maxDis=distanceUtil.getMaxDis();
		}
		  distanceMap.put("minDis", Integer.valueOf(minDis));
		  distanceMap.put("maxDis", Integer.valueOf(maxDis));
  	   return distanceMap;
     }
     /**
      * 设置价格参数的方法
      * @param price
      * @return
      */
     private Map<String, Integer> setPrice(String price){
		   Map<String, Integer> priceMap=new HashMap<String, Integer>();
  	   PriceUtil priceUtil=null;
  	    int minPrice=0;
  	    int maxPrice=0;
  		
  		if(price!=null&&!price.equals("")){
  			priceUtil=new PriceUtil(price);
  			minPrice=priceUtil.getMinPrice();
  			maxPrice=priceUtil.getMaxPrice();
  		}
  		priceMap.put("minPrice", Integer.valueOf(minPrice));
  		priceMap.put("maxPrice", Integer.valueOf(maxPrice));
  		return priceMap;
     }
     /**
      * 设置车龄参数的方法
      * @param age
      * @return
      */
     private Map<String, Integer> setAge(String age){
  	   Map<String, Integer> ageMap=new HashMap<String, Integer>();
  	   CarAgeUtil ageUtil=null;
  	    int minAge=0;
  	    int maxAge=0;
  		
  		if(age!=null&&!age.equals("")){
  			ageUtil=new CarAgeUtil(age);
  			minAge=ageUtil.getMinAge();
  			maxAge=ageUtil.getMaxAge();
  		}
  		ageMap.put("minAge", Integer.valueOf(minAge));
  		ageMap.put("maxAge", Integer.valueOf(maxAge));
  		return ageMap;
     }

	
}
