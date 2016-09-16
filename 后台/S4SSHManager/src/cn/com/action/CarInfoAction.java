package cn.com.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;


import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import cn.com.service.*;

import cn.com.dao.IPageDao;
import cn.com.pojo.*;
import cn.com.util.CarAgeUtil;
import cn.com.util.DbUtil;
import cn.com.util.DistanceUtil;
import cn.com.util.PageUtil;
import cn.com.util.PriceUtil;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 汽车信息操作action类
 * @author lej
 */
public class CarInfoAction extends ActionSupport implements SessionAware,
		ServletRequestAware {
	private String res = null; //返回结果字段
	private Map<Integer, Priceinterval> priceMap = null;  //车价区间集合
	private Map<Integer, Carbrand> showBrandMap = null;   //名牌集合
	private Map<Integer, Cartype> showType = null; //热门车型集合
	private Map<Integer, Carage> ageMap = null;  //热门车龄集合
	private ICarInfoService carInfoService = null;  //汽车概要信息服务接口的引用
	private IPageDao carPage = null;  //分页处理操作接口引用
	private ICarBrandService carBrandService = null;  //品服务接口的引用
	private ICarTypeService carTypeService = null; //车型服务接口的引用
	private ITrendsService trendsService = null; //公司动态消息服务接口的引用
	private IPriceIntervalService priceIntervalService = null; //价格区间消息服务接口的引用
	private ICarAgeService carAgeService = null;  //车龄服务接口的引用
	private HttpServletRequest request = null;  //request
	private Map<String, Object> session = null; //session
	private IDistanceService distanceService=null; //行驶距离服务接口的引用
	private   IEmissionstandardService emissionstandardService=null; //排放标准服务接口的引用
 	private IBasicInfoService basicInfoService=null;  //汽车基础信息服务的引用
	private   ICarImagesInfoService carImagesInfoService=null;  //汽车图片信息服务接口的引用
	private   IHardwareConfigService hardwareConfigService=null; //汽车硬件配置信息服务接口的引用
	private	IProcedureInfoService procedureInfoService=null;  //手续服务接口的引用
	private	ISellInfoService sellInfoService=null;  //销售信息服务接口的引用
 	private	ISystemConfigService systemConfigService=null; //汽车系统配置服务接口的引用
	public IBasicInfoService getBasicInfoService() {
		return basicInfoService;
	}

	public void setBasicInfoService(IBasicInfoService basicInfoService) {
		this.basicInfoService = basicInfoService;
	}

	public ICarImagesInfoService getCarImagesInfoService() {
		return carImagesInfoService;
	}

	public void setCarImagesInfoService(ICarImagesInfoService carImagesInfoService) {
		this.carImagesInfoService = carImagesInfoService;
	}

	public IHardwareConfigService getHardwareConfigService() {
		return hardwareConfigService;
	}

	public void setHardwareConfigService(
			IHardwareConfigService hardwareConfigService) {
		this.hardwareConfigService = hardwareConfigService;
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

	public ISystemConfigService getSystemConfigService() {
		return systemConfigService;
	}

	public void setSystemConfigService(ISystemConfigService systemConfigService) {
		this.systemConfigService = systemConfigService;
	}

	public IDistanceService getDistanceService() {
		return distanceService;
	}

	public void setDistanceService(IDistanceService distanceService) {
		this.distanceService = distanceService;
	}

	public IEmissionstandardService getEmissionstandardService() {
		return emissionstandardService;
	}

	public void setEmissionstandardService(
			IEmissionstandardService emissionstandardService) {
		this.emissionstandardService = emissionstandardService;
	}
	private ICommentService commentService=null;
	
	

	public ICommentService getCommentService() {
		return commentService;
	}

	public void setCommentService(ICommentService commentService) {
		this.commentService = commentService;
	}

	public String getRes() {
		return res;
	}

	public void setRes(String res) {
		this.res = res;
	}

	public Map<Integer, Priceinterval> getPriceMap() {
		return priceMap;
	}

	public void setPriceMap(Map<Integer, Priceinterval> priceMap) {
		this.priceMap = priceMap;
	}

	public Map<Integer, Carbrand> getShowBrandMap() {
		return showBrandMap;
	}

	public void setShowBrandMap(Map<Integer, Carbrand> showBrandMap) {
		this.showBrandMap = showBrandMap;
	}

	public Map<Integer, Cartype> getShowType() {
		return showType;
	}

	public void setShowType(Map<Integer, Cartype> showType) {
		this.showType = showType;
	}

	public Map<Integer, Carage> getAgeMap() {
		return ageMap;
	}

	public void setAgeMap(Map<Integer, Carage> ageMap) {
		this.ageMap = ageMap;
	}

	public ICarInfoService getCarInfoService() {
		return carInfoService;
	}

	public void setCarInfoService(ICarInfoService carInfoService) {
		this.carInfoService = carInfoService;
	}

	public IPageDao getCarPage() {
		return carPage;
	}

	public void setCarPage(IPageDao carPage) {
		this.carPage = carPage;
	}

	public ICarBrandService getCarBrandService() {
		return carBrandService;
	}

	public void setCarBrandService(ICarBrandService carBrandService) {
		this.carBrandService = carBrandService;
	}

	public ICarTypeService getCarTypeService() {
		return carTypeService;
	}

	public void setCarTypeService(ICarTypeService carTypeService) {
		this.carTypeService = carTypeService;
	}

	public ITrendsService getTrendsService() {
		return trendsService;
	}

	public void setTrendsService(ITrendsService trendsService) {
		this.trendsService = trendsService;
	}

	public IPriceIntervalService getPriceIntervalService() {
		return priceIntervalService;
	}

	public void setPriceIntervalService(
			IPriceIntervalService priceIntervalService) {
		this.priceIntervalService = priceIntervalService;
	}

	public ICarAgeService getCarAgeService() {
		return carAgeService;
	}

	public void setCarAgeService(ICarAgeService carAgeService) {
		this.carAgeService = carAgeService;
	}
       //HttpServletRequest对象
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request = arg0;
	}

	public HttpServletRequest getServletRequest() {
		return request;
	}

	public Map<String, Object> getSession() {
		return session;
	}
 //session注入
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session = arg0;
	}
  /**
   * 默认action展示首页的请求
   */
	@Override
	public String execute() throws Exception {
		setOverAllUse();
		// TODO Auto-generated method stub
		Carinfo carInfo=new Carinfo();
		carInfo.setCState("在售");
		// 今日推荐
		Map<Long, Carinfo> showCarMap = carInfoService
				.getCarInfoByCountDesc(carInfo);
		DbUtil.closeAll();
		this.session.put("showcar", showCarMap);

		// 品牌展示
		Map<Integer, Carbrand> allBrandMap = carBrandService.getAllBrand();
		DbUtil.closeAll();
		this.session.put("allbrand", allBrandMap);

		// 热销品牌下的热销车辆
		Map<Long, Carinfo> carMap = new HashMap<Long, Carinfo>();
		for (Integer key : showBrandMap.keySet()) {
			clerCarAtr(carInfo);
			carInfo.setCBrand(showBrandMap.get(key).getBName());
			Map<Long, Carinfo> brandCar = carInfoService
					.getCarInfoByBrandCountDesc(carInfo);

			DbUtil.closeAll();

			for (Long key1 : brandCar.keySet()) {
				carMap.put(key1, brandCar.get(key1));
			}
		}
		this.request.setAttribute("brandcar", carMap);
		// 最新到店
		Map<Long, Carinfo> newCarMap = carInfoService
				.getCarInfoBySjTime(carInfo);
		DbUtil.closeAll();
		this.request.setAttribute("newcar", newCarMap);
		Map<Long, Carinfo> fourthCarMap = carInfoService
				.getFourthCarInfoBySjTime(carInfo);
		DbUtil.closeAll();
		this.request.setAttribute("fourthcar", fourthCarMap);
 //首字母菜单数据处理
		List<String> leftszm = new ArrayList<String>();
		List<String> rightszm = new ArrayList<String>();
		for (Integer key : allBrandMap.keySet()) {
			if (leftszm.size() < 9) {
				if (!leftszm.contains(allBrandMap.get(key).getBSzm())) {
					leftszm.add(allBrandMap.get(key).getBSzm());

				}
			} else {
				if (!leftszm.contains(allBrandMap.get(key).getBSzm())) {
					if (!rightszm.contains(allBrandMap.get(key).getBSzm())) {
						rightszm.add(allBrandMap.get(key).getBSzm());
					}

				}
			}
		}
		Collections.sort(leftszm); //排序
		Collections.sort(rightszm);//排序
		this.request.setAttribute("leftszm", leftszm);
		this.request.setAttribute("rightszm", rightszm);
//热销车型下的车
		Map<Long, Carinfo> typeCarMap = new HashMap<Long, Carinfo>();
		for (Integer key : showType.keySet()) {
			clerCarAtr(carInfo);
			carInfo.setCType(showType.get(key).getTName());

			Map<Long, Carinfo> typeCar = carInfoService
					.getCarInfoByTypeCountDesc(carInfo);

			DbUtil.closeAll();
			for (Long key1 : typeCar.keySet()) {
				typeCarMap.put(key1, typeCar.get(key1));
			}
		}
		//评论信息
		Comment1 comment = new Comment1();
		comment.setCAdmin("首页展示");
	
		this.request.setAttribute("com1",
				commentService.getTheTowComment(comment, 1, 2));
		this.request.setAttribute("com2",
				commentService.getTheTowComment(comment, 2, 2));
		this.request.setAttribute("com3",
				commentService.getTheTowComment(comment, 3, 2));
                //公司动态消息展示
		Trends trends = new Trends();
		trends.setTrType("指南");
		List<Trends> trendsList1 = trendsService.getITrendsByTime(trends, 6);
		this.session.put("zhinan", trendsList1);
		trends.setTrType("承诺");
		List<Trends> trendsList2 = trendsService.getITrendsByTime(trends, 6);
		this.session.put("chennuo", trendsList2);
		trends.setTrType("活动");

		List<Trends> trendsList = trendsService.getITrendsByTime(trends, 5);
		for (int i = 0; i < trendsList.size(); i++) {
			this.request.setAttribute("active" + (i + 1) + "",
					trendsList.get(i));
		}
		trends.setTrType("新闻");

		List<Trends> newsList = trendsService.getITrendsByTime(trends, 11);
		List<Trends> news1 = new ArrayList<Trends>();
		List<Trends> news2 = new ArrayList<Trends>();
		for (int i = 0; i < newsList.size(); i++) {
			if (i < 5) {
				if (i == 0) {
					this.request.setAttribute("new1", newsList.get(i));
				}
				news1.add(newsList.get(i));
			} else {
				if (i == 5) {
					this.request.setAttribute("new6", newsList.get(i));
				}
				news2.add(newsList.get(i));
			}
		}
		this.request.setAttribute("news1", news1);
		this.request.setAttribute("news2", news2);
		this.request.setAttribute("typecar", typeCarMap);

		return super.execute();
	}
/**
 * 注入多个页面需要用到的条件数据
 * 
 */
	private void setOverAllUse() {
		// 热销价格
		this.setPriceMap(priceIntervalService.getPriceIntervalByCount());

		// 热销品牌
		this.setShowBrandMap(carBrandService.getCarBrandByCount());

		// 热销车型
		this.setShowType(carTypeService.getCarTypeByCount());

		// 热销车龄
		this.setAgeMap(carAgeService.getCarAgeByCount());

	}

	/**
	 * 展示买车菜单action
	 * 
	 */
	  public String showList() throws Exception{
		  Carinfo carInfo=new Carinfo();
		
		  setOverAllUse();
			clerCarAtr(carInfo);
			bindWhere(this.request);
			fenye(this.request,  carInfo);
		
		
		   return "showlist";
	   }
	   /**
	    * 车辆详情展示action
	    * 
	    */
		public String showDetails()throws Exception{
			Carinfo carInfo=new Carinfo();
			Map<Long, Carinfo> detailsMap=getdea(this.request,  carInfo);
			Carinfo _carInfo=detailsMap.get(carInfo.getCId());
		  Map<Long, Carinfo> bcar=   carInfoService.getCarInfoByBrandCountDesc(_carInfo);
		  bcar.remove(_carInfo.getCId()); //在同品牌热度高的车集合下删除目前正在浏览的车
		  this.request.setAttribute("bcar", bcar);
		     _carInfo.setCCount(_carInfo.getCCount()+1);
		    if(carInfoService.updateCarInfo(_carInfo)){
		      return "showdetails";
				}
		    else{
		    	return "error";
		    }
		
		}
		/**
		 *审核中的车详情展示action
		 */
		public String showshdea()throws Exception{
			Carinfo carInfo=new Carinfo();
			
			getdea(this.request, carInfo);
			return "showshdea";
		}
		/**
		 *展示私人定制页面的action
		 */
		public String showsrdz()throws Exception{
			setOverAllUse();
			return "showsrdz";
		}
		/**
		 * 进行车辆比较的action
		 * 
		 */
		public String showCompare()throws Exception{
			 Carinfo carInfo=new Carinfo();
				this.setID(this.request,  carInfo);
				Map<Long, Carinfo> detailsMap=carInfoService.getCarByWhere(carInfo);
				 DbUtil.closeAll();
			
					Basicinfo    basicInfo=   basicInfoService.getAllBasicById(carInfo);
		     DbUtil.closeAll();
		     Hardwareconfig   hardwareConfig= hardwareConfigService.getHardwareConfigById(carInfo);
		 DbUtil.closeAll();
		 Procedureinfo   procedureInfo= procedureInfoService.getProcedureInfoById(carInfo);
		 DbUtil.closeAll();
		 Systemconfig  systemConfig= systemConfigService.getSystemConfigById(carInfo);
		 DbUtil.closeAll();
		 Sellinfo sellInfo=sellInfoService.getSellInfoById(carInfo);
		 DbUtil.closeAll();
		  //从session中获取比较过的车的集合
	        Object pareCar=   this.session.get("pareCarInfo");
	        Object pareSys=   this.session.get("pareSystemConfig");
	        Object pareSell=   this.session.get("pareSellInfo");
	        Object pareHar=   this.session.get("pareHardwareConfig");
	        Object parePro=   this.session.get("pareProcedureInfo");
	        Object pareBas=   this.session.get("pareBasic");
	         //创建进行比较的车的各种信息的集合，指向空引用
	        Map<Integer, Carinfo> pareCarInfo=null;
	        Map<Integer, Systemconfig> pareSystemConfig=null;
	        Map<Integer, Sellinfo> pareSellInfo=null;
	        Map<Integer, Hardwareconfig> pareHardwareConfig=null;
	        Map<Integer, Procedureinfo> pareProcedureInfo=null;
	        Map<Integer, Basicinfo> pareBasic=null;
	        boolean flag=false;
	       //如果之前没有进行比较，则直接将该车加入进比较集合
	        if(pareCar==null){
	            pareCarInfo=new HashMap<Integer, Carinfo>();
	            pareCarInfo.put(1, detailsMap.get(carInfo.getCId()));
	        }
	        //如果之前进行过比较
	        if(pareCar!=null){
	        	//新的比较集合指向之前比较的集合
	            pareCarInfo=(Map<Integer, Carinfo>) pareCar;
	            //判断集合中是否存在现在选中的车
	          flag=  pareCarInfo.containsValue(detailsMap.get(carInfo.getCId()));
	           //如果不存在，则按照不同的条件在比较集合中加入这辆车
	          if(flag==false){
	            if(pareCarInfo.size()==1){
	            	 pareCarInfo.put(2, detailsMap.get(carInfo.getCId()));
	            }
	            else if(pareCarInfo.size()==2){
	            	 pareCarInfo.put(3, detailsMap.get(carInfo.getCId()));
	            }
	            else{
	            	pareCarInfo.put(1, pareCarInfo.get(2));
	            	pareCarInfo.put(2, pareCarInfo.get(3));
	            	 pareCarInfo.put(3, detailsMap.get(carInfo.getCId()));
	            }
	        }
	        }
	         //之后的操作与pareCar处相同
	        if(pareSys==null){
	            pareSystemConfig=new HashMap<Integer, Systemconfig>();
	           pareSystemConfig.put(1, systemConfig);
	        }
	        if(pareSys!=null){
	        	
	        	pareSystemConfig=(Map<Integer, Systemconfig>) pareSys;
	        	if(flag==false){
	            if(pareSystemConfig.size()==1){
	            	pareSystemConfig.put(2, systemConfig);
	            }
	            else if(pareSystemConfig.size()==2){
	            	pareSystemConfig.put(3,systemConfig);
	            }
	            else{
	            	pareSystemConfig.put(1, pareSystemConfig.get(2));
	            	pareSystemConfig.put(2, pareSystemConfig.get(3));
	            	pareSystemConfig.put(3, systemConfig);
	            }
	        	}
	        }
	        if(pareSell==null){
	             pareSellInfo=new HashMap<Integer, Sellinfo>();
	            pareSellInfo.put(1,sellInfo );
	        }
	        if(pareSell!=null){
	        	
	         pareSellInfo=(Map<Integer, Sellinfo>) pareSell;
	         if(flag==false){
	            if(pareSellInfo.size()==1){
	            	pareSellInfo.put(2, sellInfo);
	            }
	            else if(pareSellInfo.size()==2){
	            	pareSellInfo.put(3,sellInfo);
	            }
	            else{
	            	pareSellInfo.put(1, pareSellInfo.get(2));
	            	pareSellInfo.put(2, pareSellInfo.get(3));
	            	pareSellInfo.put(3, sellInfo);
	            }
	        	}
	        }
	        if(pareHar==null){
	           pareHardwareConfig=new HashMap<Integer, Hardwareconfig>();
	            pareHardwareConfig.put(1, hardwareConfig);
	        }
	        if(pareHar!=null){
	        
	        	 pareHardwareConfig=(Map<Integer, Hardwareconfig>) pareHar;
	        	 if(flag==false){
	            if(pareHardwareConfig.size()==1){
	            	pareHardwareConfig.put(2, hardwareConfig);
	            }
	            else if(pareHardwareConfig.size()==2){
	            	pareHardwareConfig.put(3,hardwareConfig);
	            }
	            else{
	            	pareHardwareConfig.put(1, pareHardwareConfig.get(2));
	            	pareHardwareConfig.put(2, pareHardwareConfig.get(3));
	            	pareHardwareConfig.put(3, hardwareConfig);
	            
	        	 }
	        	}
	        }
	        if(parePro==null){
	             pareProcedureInfo=new HashMap<Integer, Procedureinfo>();
	            pareProcedureInfo.put(1, procedureInfo);
	        }
	        if(parePro!=null){
	        	
	        	 pareProcedureInfo=(Map<Integer, Procedureinfo>) parePro;
	        	 if(flag==false){
	            if(pareProcedureInfo.size()==1){
	            	pareProcedureInfo.put(2, procedureInfo);
	            }
	            else if(pareProcedureInfo.size()==2){
	            	pareProcedureInfo.put(3,procedureInfo);
	            }
	            else{
	            	pareProcedureInfo.put(1, pareProcedureInfo.get(2));
	            	pareProcedureInfo.put(2, pareProcedureInfo.get(3));
	            	pareProcedureInfo.put(3, procedureInfo);
	            
	        	 }
	        	}
	        }
	        if(pareBas==null){
	             pareBasic=new HashMap<Integer, Basicinfo>();
	            pareBasic.put(1, basicInfo);
	        }
	        if(pareBas!=null){
	        	
	        	 pareBasic=(Map<Integer, Basicinfo>) pareBas;
	        	 if(flag==false){
	            if(pareBasic.size()==1){
	            	pareBasic.put(2, basicInfo);
	            }
	            else if(pareBasic.size()==2){
	            	pareBasic.put(3,basicInfo);
	            }
	            else{
	            	pareBasic.put(1, pareBasic.get(2));
	            	pareBasic.put(2, pareBasic.get(3));
	            	pareBasic.put(3, basicInfo);
	            
	        	 }
	        	}
	        }
	        this.request.setAttribute("cid", carInfo.getCId());
	        this.request.setAttribute("uid", carInfo.getUId());
	        
	       this.session.put("pareCarInfo", pareCarInfo);
	       this.session.put("pareSystemConfig", pareSystemConfig);
	       this.session.put("pareSellInfo", pareSellInfo);
	       this.session.put("pareHardwareConfig", pareHardwareConfig);
	       this.session.put("pareProcedureInfo", pareProcedureInfo);
	       this.session.put("pareBasic", pareBasic);
	     
			return "showCompare";
		}
		/**
		 * 会员操作栏中的直接比较action，即获取session中的比较集合
		 * 
		 */
		public String zjbj()throws Exception{
			 Object pareCar=   session.get("pareCarInfo");
		        Object pareSys=   session.get("pareSystemConfig");
		        Object pareSell=   session.get("pareSellInfo");
		        Object pareHar=   session.get("pareHardwareConfig");
		        Object parePro=   session.get("pareProcedureInfo");
		        Object pareBas=   session.get("pareBasic");
		        Map<Long, Carinfo> car=(Map<Long, Carinfo>) pareCar;
		 Object[] cars=     car.values().toArray();
		 Carinfo _carInfo=(Carinfo) cars[cars.length-1];
		 
		 this.request.setAttribute("cid",_carInfo.getCId());
		 this.request.setAttribute("uid", _carInfo.getUId());
		        session.put("pareCarInfo", pareCar);
		         session.put("pareSystemConfig", pareSys);
		         session.put("pareSellInfo", pareSell);
		         session.put("pareHardwareConfig", pareHar);
		         session.put("pareProcedureInfo", parePro);
		         session.put("pareBasic", pareBas);
		    
			return "zjbj";
		}
		/**
		 * /展示点击榜单的action
		 * 
		 */
		public String djbd()throws Exception{
			Carinfo carInfo=new Carinfo();
			carInfo.setCState("在售");
			 List<Carinfo>	tencar=	carInfoService.getTenCount(carInfo);
			 this.request.setAttribute("trends", tencar);
			
			return "djbd";
		}
		/**
		 * 展示交易榜单的action
		 */
		public String jybd()throws Exception{
			Carinfo carinfo=new Carinfo();
			List<Carinfo>	tencar=	carInfoService.getTenBrandCar(carinfo);
			List<Carbrand> tenBrand=new ArrayList<Carbrand>();
			for(Carinfo c:tencar){
				Carbrand brand=new Carbrand();
				brand.setBName(c.getCBrand());
				tenBrand.add(carBrandService.getBrandByName(brand));
				
			}
			this.request.setAttribute("trends", tencar);
			this.request.setAttribute("tenBrand", tenBrand);
			
			return "jybd";
		}
		
		/**
		 * 置空carinfo的属性
		 * 
		 * @param carInfo
		 */
		private void clerCarAtr(Carinfo carInfo) {
			carInfo.setCBrand(null);
			carInfo.setCType(null);
		}
		 
      /**
       * 分页处理的方法
       * 
       * 
       */
			private void fenye(HttpServletRequest req, Carinfo carInfo){
				try {
			carInfo.setCState("在售");
			//设置当前页
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
		    //设置页面传递的各种汽车条件参数
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
			long maxRowsCount=carPage.queryMsgCount(carInfo,priceMap.get("minPrice"),priceMap.get("maxPrice"),distanceMap.get("minDis"),distanceMap.get("maxDis"),ageMap.get("minAge"),ageMap.get("maxAge"));
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
				
				List<Object> carMap=carPage.showMsgInfoList(pageUtil.getCurPage(), pageUtil.getRowsPrePage(), carInfo,order,priceMap.get("minPrice"),priceMap.get("maxPrice"),distanceMap.get("minDis"),distanceMap.get("maxDis"),ageMap.get("minAge"),ageMap.get("maxAge"));
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
		        * @param distance
		        * @return
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
		       /**
		        * 设置两个ID的方法的方法
		        * @param req
		        * @param resp
		        * @param carInfo
		        */
		       private void setID(HttpServletRequest req,Carinfo carInfo){
		    	   long c_id=Long.parseLong(req.getParameter("cid"));
		    	   long u_id=Long.parseLong(req.getParameter("uid"));
		    		clerCarAtr(carInfo);
		    		carInfo.setCId(c_id);
		    		carInfo.setUId(u_id);
		       }
	/**
	  * 绑定几个页面需要用到条件参数
	  * 
	  */
		       private  void bindWhere(HttpServletRequest req){
		    	   Map<Integer, Distance> distanceMap= distanceService.getDistanceByCount();
		          DbUtil.closeAll();  
		    	  req.setAttribute("distanceMap", distanceMap);
		          Map<Integer,Emissionstandard> emisMap=emissionstandardService.getEmissionstandardByCount();
		          DbUtil.closeAll();
		          req.setAttribute("emisMap", emisMap);
		       }
      /**
       * 获取车辆详细信息的方法
       * @return Map<Long,CarInfo>
       */
		       private Map<Long, Carinfo> getdea(HttpServletRequest req,Carinfo carInfo){
                        this.setID(req, carInfo);
		        Map<Integer, String> carImagesInfo=      carImagesInfoService.getCarImagesInfoByID(carInfo);
		    	DbUtil.closeAll();
		    	req.setAttribute("carImagesInfo", carImagesInfo);
		    	Map<Long, Carinfo> detailsMap=carInfoService.getCarByWhere(carInfo);
		    	DbUtil.closeAll();
		    	req.setAttribute("detailsMap", detailsMap);
		    	Basicinfo    basicInfo=   basicInfoService.getAllBasicById(carInfo);
		    	DbUtil.closeAll();
		    	Hardwareconfig   hardwareConfig= hardwareConfigService.getHardwareConfigById(carInfo);
		    	DbUtil.closeAll();
		    	Procedureinfo   procedureInfo= procedureInfoService.getProcedureInfoById(carInfo);
		    	DbUtil.closeAll();
		    	Systemconfig  systemConfig= systemConfigService.getSystemConfigById(carInfo);
		    	DbUtil.closeAll();
		    	Sellinfo sellInfo=sellInfoService.getSellInfoById(carInfo);
		    	DbUtil.closeAll();
		    	req.setAttribute("cid", carInfo.getCId());
		    	req.setAttribute("uid", carInfo.getUId());
		    	req.setAttribute("sellInfo", sellInfo);
		    	 req.setAttribute("systemConfig", systemConfig);
		    	 req.setAttribute("procedureInfo", procedureInfo);
		    	  req.setAttribute("hardwareConfig", hardwareConfig);
		    	  req.setAttribute("basicInfo", basicInfo);
		    		  return detailsMap;
		    	  }
		    	       
}
