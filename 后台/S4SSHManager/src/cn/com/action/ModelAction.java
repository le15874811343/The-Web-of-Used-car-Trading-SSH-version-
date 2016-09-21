package cn.com.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import net.sf.json.JSONArray;


import cn.com.dao.*;
import cn.com.pojo.*;
import cn.com.service.*;
import cn.com.service.impl.*;
import cn.com.util.DbUtil;
import cn.com.util.PageUtil;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 各项参数管理action
 * 
 */
public class ModelAction extends ActionSupport implements ServletRequestAware,ServletResponseAware,SessionAware{
  private IModelService modelService=null; //车系信息服务接口的引用
  private HttpServletRequest request=null; //request
  private HttpServletResponse response=null; //response
  private Map<String, Object> session; //session
  private  ICarBrandService brandServiceImpl=null; //汽车品牌服务接口的引用
  private IPageDao brandPage=null; //分页处理操作接口的引用（指向汽车品牌信息操作实现类）
  private  ICarAgeService ageServiceImpl=null;//车龄信息服务接口的引用
  private IPageDao carAgePage=null; //分页处理操作接口的引用（指向车龄信息操作实现类）
  private IPriceIntervalService priceIntervalServiceImpl=null;//车价信息服务接口的引用
  private  IPageDao  pricePage=null; //分页处理操作接口的引用（指向车价信息操作实现类）
  private  IDistanceService distanceService=null;//行驶距离信息服务接口的引用
  private IPageDao distancePage=null; //分页处理操作接口的引用（指向行驶距离信息操作实现类）
  private IEmissionstandardService emissionstandardService=null;//排放标准服务接口的引用
  private IPageDao  emisPage=null; //分页处理操作接口的引用（指向排放标准信息操作实现类）
  private ICarTypeService carTypeService=null;//车型服务接口的引用
  private IPageDao carTypePage=null; //分页处理操作接口的引用（指向车型信息操作实现类）
  
	public ICarBrandService getBrandServiceImpl() {
	return brandServiceImpl;
}

public void setBrandServiceImpl(ICarBrandService brandServiceImpl) {
	this.brandServiceImpl = brandServiceImpl;
}

public IPageDao getBrandPage() {
	return brandPage;
}

public void setBrandPage(IPageDao brandPage) {
	this.brandPage = brandPage;
}

public ICarAgeService getAgeServiceImpl() {
	return ageServiceImpl;
}

public void setAgeServiceImpl(ICarAgeService ageServiceImpl) {
	this.ageServiceImpl = ageServiceImpl;
}

public IPageDao getCarAgePage() {
	return carAgePage;
}

public void setCarAgePage(IPageDao carAgePage) {
	this.carAgePage = carAgePage;
}

public IPriceIntervalService getPriceIntervalServiceImpl() {
	return priceIntervalServiceImpl;
}

public void setPriceIntervalServiceImpl(
		IPriceIntervalService priceIntervalServiceImpl) {
	this.priceIntervalServiceImpl = priceIntervalServiceImpl;
}

public IPageDao getPricePage() {
	return pricePage;
}

public void setPricePage(IPageDao pricePage) {
	this.pricePage = pricePage;
}

public IDistanceService getDistanceService() {
	return distanceService;
}

public void setDistanceService(IDistanceService distanceService) {
	this.distanceService = distanceService;
}

public IPageDao getDistancePage() {
	return distancePage;
}

public void setDistancePage(IPageDao distancePage) {
	this.distancePage = distancePage;
}

public IEmissionstandardService getEmissionstandardService() {
	return emissionstandardService;
}

public void setEmissionstandardService(
		IEmissionstandardService emissionstandardService) {
	this.emissionstandardService = emissionstandardService;
}

public IPageDao getEmisPage() {
	return emisPage;
}

public void setEmisPage(IPageDao emisPage) {
	this.emisPage = emisPage;
}

public ICarTypeService getCarTypeService() {
	return carTypeService;
}

public void setCarTypeService(ICarTypeService carTypeService) {
	this.carTypeService = carTypeService;
}

public IPageDao getCarTypePage() {
	return carTypePage;
}

public void setCarTypePage(IPageDao carTypePage) {
	this.carTypePage = carTypePage;
}

	public IModelService getModelService() {
	return modelService;
}

public void setModelService(IModelService modelService) {
	this.modelService = modelService;
}

public HttpServletRequest getServletRequest() {
	return request;
}


@Override
public void setServletRequest(HttpServletRequest arg0) {
	// TODO Auto-generated method stub
	this.request=arg0;
}

public HttpServletResponse getServletResponse() {
	return response;
}
@Override
public void setServletResponse(HttpServletResponse arg0) {
	// TODO Auto-generated method stub
	this.response=arg0;
}
public Map<String, Object> getSession() {
	return session;
}

@Override
public void setSession(Map<String, Object> arg0) {
	// TODO Auto-generated method stub
	this.session=arg0;
}
   /**
    * 品牌车系二级联动操作action
    */
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		int b_id=Integer.parseInt(request.getParameter("brand"));
		Model model=new Model();
		model.setBId(b_id);
		List<Model> modelMap=modelService.getModelByWhere(model);
	  DbUtil.closeAll();
	  
	 
	   JSONArray jsonArray= JSONArray.fromObject(modelMap);
	  response.setContentType("text/html;charset=utf-8");
	  response.getWriter().println(jsonArray);
	  response.getWriter().flush();//清空缓存,刷新
	  response.getWriter().close();
	  return "execute";
	}
	/**
	 * 展示车系详情操作action
	 */
	public String getDea() throws Exception {
		int s_id=Integer.parseInt(request.getParameter("s_id"));
		Model model=new Model();
		model.setMId(s_id);
		List<Model> modelMap=modelService.getModelByWhere(model);
	  DbUtil.closeAll();
	  
	 
	   JSONArray jsonArray= JSONArray.fromObject(modelMap);
	   response.setContentType("text/html;charset=utf-8");
	   response.getWriter().println(jsonArray);
	   response.getWriter().flush();//清空缓存,刷新
	   response.getWriter().close();
		 return "getDea";
	}
	/**
	 * 展示品牌操作action
	 */
	public String showbrand() throws Exception {
		 Carbrand carBrand=new Carbrand();
	        this.fenye(request, carBrand);
	       
		 return "showbrand";
	}
	/**
	 * 展示车龄信息操作action
	 */
	public String showage() throws Exception {
		Carage carAge=new Carage();
		this.fenyeage(request, carAge);
		
		 return "showage";
	}
	/**
	 * 展示车型信息操作action
	 */
	public String showtype() throws Exception {
		Cartype carType=new Cartype();
		this.fenyeety(request, carType);
		
		 return "showtype";
	}
	/**
	 * 展示行驶距离信息操作action
	 */
	public String showdistance() throws Exception {
		Distance distance=new Distance();
		this.fenyedis(request, distance);
      
		 return "showdistance";
	}
	/**
	 * 展示排放标准操作action
	 */
	public String showemsi() throws Exception {
		 Emissionstandard emissionstandard=new Emissionstandard();
		 this.fenyeemsi(request, emissionstandard);
       
		 return "showemsi";
	}
	/**
	 * 展示价格区间操作action
	 */
	public String showprice() throws Exception {
		Priceinterval priceInterval=new Priceinterval();
		this.fenyeprice(request, priceInterval);
      
		 return "showprice";
	}
	/**
	 * 展示车系操作action
	 */
	public String showseries() throws Exception {
		
		Map<Integer, Carbrand> brandMap=	brandServiceImpl.getAllBrand();
		request.setAttribute("allbrand", brandMap);
		
		 return "showseries";
	}
	/**
	 * 请求增加车系操作action
	 */
	public String addseries() throws Exception {
	
		Map<Integer, Carbrand> brandMap=	brandServiceImpl.getAllBrand();
		request.setAttribute("allbrand", brandMap);
		
		 return "addseries";
	}
	/**
	 * //增加品牌操作action
	 */
	public String addbrand() throws Exception {
		
        String bname=request.getParameter("maxAge");
        String bcount=request.getParameter("count");
        String bimg=request.getParameter("ttp");
        String zm=request.getParameter("zm");
        Carbrand carBrand=new Carbrand();
           carBrand.setBName(bname);
           carBrand.setBCount(new Long(0));
           carBrand.setBImg("");
           carBrand.setBSzm(zm.toUpperCase());
        if(bimg!=null&&!bimg.equals("")){
          carBrand.setBImg("tepimages/"+bimg);
        }
        if(bcount!=null&&!bcount.equals("")){
            carBrand.setBCount(Long.parseLong(bcount));
          }
        if(brandServiceImpl.addCarBrand(carBrand)){
        	
        	request.setAttribute("meag", "添加成功");
        	
        }
		 return "addbrand";
	}
	/**
	 * 请求修改品牌操作action
	 */
	public String upbrand() throws Exception {
		String bid=request.getParameter("bid");
		Carbrand brand=new Carbrand();
		brand.setBId(Integer.parseInt(bid));
	
	
 Carbrand carBrand=		brandServiceImpl.getBrandByID(brand);
		
		session.put("brand", carBrand);

		 return "upbrand";
	}
	/**
	 * 提交修改品牌action
	 */
	public String tjupbr() throws Exception {
		
		String bid=request.getParameter("bid");
        String bname=request.getParameter("maxAge");
        String bcount=request.getParameter("count");
        String bimg=request.getParameter("ttp");
        String zm=request.getParameter("zm");
        Carbrand carBrand=new Carbrand();
           carBrand.setBName(bname);
           carBrand.setBCount(new Long(0));
           carBrand.setBImg(request.getParameter("qtp"));
           carBrand.setBSzm(zm.toUpperCase());
           carBrand.setBId(Integer.parseInt(bid));
        if(bimg!=null&&!bimg.equals("")){
    
        	
          carBrand.setBImg("tepimages/"+bimg);
        }
        if(bcount!=null&&!bcount.equals("")){
            carBrand.setBCount(Long.parseLong(bcount));
          }
        if(brandServiceImpl.updateCarBrand(carBrand)){
        	
        	session.put("upbrand", "修改成功");
        	session.put("brand", carBrand);
        	
        }
		 return "tjupbr";
	}
	/**
	 * 删除品牌操作action
	 */
	public String delbrand() throws Exception {
		
		String bid=request.getParameter("bid");
		 Carbrand carBrand=new Carbrand();
		 carBrand.setBId(Integer.parseInt(bid));
		 if(brandServiceImpl.deleteCarBrand(carBrand)){
			 response.setContentType("text/html;charset=utf-8");
				response.getWriter().print(1);
				 response.getWriter().flush();//清空缓存,刷新
				   response.getWriter().close();
		 }
		 return "delbrand";
	}
	/**
	 * 提交增加车系操作action
	 */
	public String addser() throws Exception {
		String bid=request.getParameter("cpp");
		String sname=request.getParameter("name");
		Model model=new Model();
		model.setBId(Integer.parseInt(bid));
		model.setMName(sname);
		
		if(modelService.addModel(model)){
			request.setAttribute("mea", "添加成功");
		
		}
		 return "addser";
	}
	/**
	 * 请求修改车系操作action
	 */
	public String upser() throws Exception {
		String mid=request.getParameter("mid");
		Model model=new Model();
		model.setMId(Integer.parseInt(mid));
	List<Model>  m=	modelService.getModelByWhere(model);
	request.setAttribute("model", m.get(0));
	
	Map<Integer, Carbrand> brandMap=	brandServiceImpl.getAllBrand();
	request.setAttribute("allbrand", brandMap);
	
		 return "upser";
	}
	/**
	 * 提交车系修改action
	 */
	public String tjupser() throws Exception {
		String mid=request.getParameter("mid");
		String bid=request.getParameter("cpp");
		String sname=request.getParameter("name");
		Model model=new Model();
		model.setBId(Integer.parseInt(bid));
		model.setMName(sname);
		model.setMId(Integer.parseInt(mid.trim()));
		if(modelService.updateModel(model)){
			
			Map<Integer, Carbrand> brandMap=	brandServiceImpl.getAllBrand();
			request.setAttribute("allbrand", brandMap);
			request.setAttribute("model", model);
			request.setAttribute("mea", "修改成功");
			
		}
		 return "tjupser";
	}
	/**
	 * 删除车系action
	 */
	public String delser() throws Exception {
		String mid=request.getParameter("mid");
		Model model=new Model();
		model.setMId(Integer.parseInt(mid.trim()));
		if(modelService.deleteModel(model)){
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().print(1);
			 response.getWriter().flush();//清空缓存,刷新
			   response.getWriter().close();
		}
		 return "delser";
	}
	/**
	 * 加车龄信息action
	 */
	public String addage() throws Exception {
		String aname=request.getParameter("cAge");
		String acount=request.getParameter("count");
		Carage carAge=new Carage();
		carAge.setAName(aname);
		carAge.setACount(new Long(0));
		 if(acount!=null&&!acount.equals("")){
			 carAge.setACount(Long.parseLong(acount));
              }
		
		 if(ageServiceImpl.addCarAge(carAge)){
			 request.setAttribute("mea", "添加成功");
				
		 }
		 return "addage";
	}
	/**
	 *请求修改车龄信息 action
	 */
	public String upage() throws Exception {
		String a_id=request.getParameter("aid");
		Carage carAge=new Carage();
		carAge.setAId(Integer.parseInt(a_id));
		
	Carage age=	ageServiceImpl.getCarAgeById(carAge);
	request.setAttribute("age", age);
	
		 return "upage";
	}
	/**
	 * 提交修改车龄信息action
	 */
	public String tjupage() throws Exception {
		String aname=request.getParameter("cAge");
		String acount=request.getParameter("count");
		String a_id=request.getParameter("aid");
		Carage carAge=new Carage();
		carAge.setAId(Integer.parseInt(a_id));
		carAge.setAName(aname);
		carAge.setACount(new Long(0));
		 if(acount!=null&&!acount.equals("")){
			 carAge.setACount(Long.parseLong(acount));
              }
		

			if(ageServiceImpl.updateCarAge(carAge)){
				request.setAttribute("age", carAge);
				request.setAttribute("mea", "修改成功");
			
			
			}
		 return "tjupage";
	}
	/**
	 * 删除车龄信息action
	 */
	public String delage() throws Exception {
		String aid=request.getParameter("aid");
		Carage carAge=new Carage();
		carAge.setAId(Integer.parseInt(aid.trim()));
	
		if(ageServiceImpl.deleteCarAge(carAge)){
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().print(1);
			 response.getWriter().flush();//清空缓存,刷新
			   response.getWriter().close();
		}
		 return "delage";
	}
	/**
	 * 增加价格区间信息action
	 */
	public String addprice() throws Exception {
		String aname=request.getParameter("cAge");
		String acount=request.getParameter("count");
		Priceinterval priceInterval=new Priceinterval();
		priceInterval.setPName(aname);
		priceInterval.setPCount(new Long(0));
		 if(acount!=null&&!acount.equals("")){
			 priceInterval.setPCount(Long.parseLong(acount));
              }
		
		 if(priceIntervalServiceImpl.addPriceInterval(priceInterval)){
			 request.setAttribute("mea", "添加成功");
				
		 }
		 return "addprice";
	}
	/**
	 * 请求修改价格区间信息action
	 */
	public String upprice() throws Exception {
		String pid=request.getParameter("pid");
		Priceinterval priceInterval=new Priceinterval();
		priceInterval.setPId(Integer.parseInt(pid));
		

	Priceinterval interval=	 priceIntervalServiceImpl.getPriceIntervalById(priceInterval);
	request.setAttribute("price", interval);

		 return "upprice";
	}
	/**
	 * 提交修改价格区间action
	 */
	public String tjupprice() throws Exception {
		String pid=request.getParameter("pid");
		String aname=request.getParameter("cAge");
		String acount=request.getParameter("count");
		Priceinterval priceInterval=new Priceinterval();
		priceInterval.setPId(Integer.parseInt(pid));
		priceInterval.setPName(aname);
		priceInterval.setPCount((long) 0);
		 if(acount!=null&&!acount.equals("")){
			 priceInterval.setPCount(Long.parseLong(acount));
              }
		
   if(priceIntervalServiceImpl.updatePriceInterval(priceInterval)){
	   request.setAttribute("mea", "修改成功");
	   request.setAttribute("price", priceInterval);
		
   }
		 return "tjupprice";
	}
	/**
	 * 删除价格区间action
	 */
	public String delprice() throws Exception {
		String pid=request.getParameter("pid");
		Priceinterval priceInterval=new Priceinterval();
		priceInterval.setPId(Integer.parseInt(pid.trim()));
		
if(priceIntervalServiceImpl.deletePriceInterval(priceInterval)){
	response.setContentType("text/html;charset=utf-8");
	response.getWriter().print(1);
	 response.getWriter().flush();//清空缓存,刷新
	   response.getWriter().close();
} 
		 return "delprice";
	}
	/**
	 * 添加行驶距离action
	 */
	public String adddis() throws Exception {
		String aname=request.getParameter("cAge");
		String acount=request.getParameter("count");
		Distance distance=new Distance();
		distance.setDName(aname);
		distance.setDCount(new Long(0));
		 if(acount!=null&&!acount.equals("")){
			 distance.setDCount(Long.parseLong(acount));
              }
		
		 if(distanceService.addDistance(distance)){
			 request.setAttribute("mea", "添加成功");
			
		 }
		 return "adddis";
	}
	/**
	 * 请求修改行驶距离action
	 */
	public String updis() throws Exception {
		String did=request.getParameter("did");
		Distance distance=new Distance();
		distance.setDId(Integer.parseInt(did.trim()));
		
	Distance dis=	distanceService.getDistanceById(distance);
	  request.setAttribute("distance", dis);
	 
		 return "updis";
	}
	/**
	 * 提交修改行驶距离action
	 */
	public String tjupdis() throws Exception {
		String aname=request.getParameter("cAge");
		String acount=request.getParameter("count");
		String did=request.getParameter("did");
		Distance distance=new Distance();
		distance.setDId(Integer.parseInt(did.trim()));
		distance.setDName(aname);
		distance.setDCount(new Long(0));
		 if(acount!=null&&!acount.equals("")){
			 distance.setDCount(Long.parseLong(acount));
              }
		
		 if(distanceService.updateDistance(distance)){
			 request.setAttribute("mea", "修改成功");
			 request.setAttribute("distance", distance);
			
		 }
		 return "tjupdis";
	}
	/**
	 * 删除行驶距离action
	 */
	public String deldis() throws Exception {
		String did=request.getParameter("did");
		Distance distance=new Distance();
		distance.setDId(Integer.parseInt(did.trim()));
		

		 if(distanceService.deleteDistance(distance)){
			 response.setContentType("text/html;charset=utf-8");
				response.getWriter().print(1);
				 response.getWriter().flush();//清空缓存,刷新
				   response.getWriter().close();
		 }
		 return "deldis";
	}
	/**
	 * 添加排放标准action
	 */
	public String addemsi() throws Exception {
		String name=request.getParameter("name");
		String acount=request.getParameter("count");
		Emissionstandard emissionstandard=new Emissionstandard();
		emissionstandard.setEName(name);
		emissionstandard.setECount(new Long(0));
		 if(acount!=null&&!acount.equals("")){
			 emissionstandard.setECount(Long.parseLong(acount));
              }
		
		 if(emissionstandardService.addEmissionstandard(emissionstandard)){
			 request.setAttribute("mea", "添加成功");
			
		 }
		 return "addemsi";
	}
	/**
	 * 请求修改排放标准action
	 */
	public String upemsi() throws Exception {
		String eid=request.getParameter("eid");
		Emissionstandard emissionstandard=new Emissionstandard();
		emissionstandard.setEId(Integer.parseInt(eid));
		
   Emissionstandard emsi=   emissionstandardService.getEmissionstandard(emissionstandard);
   request.setAttribute("emsi", emsi);
	
		 return "upemsi";
	}
	/**
	 * 提交排放标准修改action
	 */
	public String tjemsi() throws Exception {
		String eid=request.getParameter("eid");
		String name=request.getParameter("name");
		String acount=request.getParameter("count");
		Emissionstandard emissionstandard=new Emissionstandard();
		emissionstandard.setEId(Integer.parseInt(eid));
		emissionstandard.setEName(name);
		emissionstandard.setECount(new Long(0));
		 if(acount!=null&&!acount.equals("")){
			 emissionstandard.setECount(Long.parseLong(acount));
              }
		
	if(emissionstandardService.updateEmissionstandard(emissionstandard)){
		request.setAttribute("mea", "修改成功");
		request.setAttribute("emsi", emissionstandard);
	}
		 return "tjemsi";
	}
	/**
	 * 删除排放标准action
	 */
	public String delemsi() throws Exception {
		String eid=request.getParameter("eid");
		Emissionstandard emissionstandard=new Emissionstandard();
		emissionstandard.setEId(Integer.parseInt(eid));
		
       if(emissionstandardService.deleteEmissionstandard(emissionstandard)){
    	   response.setContentType("text/html;charset=utf-8");
			response.getWriter().print(1);
			 response.getWriter().flush();//清空缓存,刷新
			   response.getWriter().close();
       }
		 return "delemsi";
	}
	/**
	 * 添加车型action
	 */
	public String addtype() throws Exception {
		 String bname=request.getParameter("maxAge");
         String bcount=request.getParameter("count");
         String bimg=request.getParameter("ttp");
         Cartype carType=new Cartype();
         carType.setTName(bname);
         carType.setTCount(new Long(0));
         carType.setTClass("");
         carType.setTImg("");
         if(bimg!=null&&!bimg.equals("")){
         	carType.setTClass("tepimages/"+bimg);
           }
           if(bcount!=null&&!bcount.equals("")){
         	  carType.setTCount(Long.parseLong(bcount));
          }
        
        if(  carTypeService.addCarType(carType)){
        	request.setAttribute("mea", "添加成功");
     	  
        }
		 return "addtype";
	}
	/**
	 * 请求修改车型action
	 */
	public String uptype() throws Exception {
		  String tid=request.getParameter("tid");
		   Cartype carType=new Cartype();
		   carType.setTId(Integer.parseInt(tid));
		  
		  Cartype _cartype=  carTypeService.getCarType(carType);
		  session.put("upcartype", _cartype);
		 
		 return "uptype";
	}
	/**
	 * 提交修改车型action
	 */
	public String tjuptype() throws Exception {
		 String tid=request.getParameter("tid");
		 String bname=request.getParameter("maxAge");
            String bcount=request.getParameter("count");
            String bimg=request.getParameter("ttp");
		   Cartype carType=new Cartype();
		   carType.setTId(Integer.parseInt(tid));
		   carType.setTName(bname);
            carType.setTCount(new Long(0));
            carType.setTClass(request.getParameter("qtp"));
            if(bcount!=null&&!bcount.equals("")){
            	  carType.setTCount(Long.parseLong(bcount));
             }
            if(bimg!=null&&!bimg.equals("")){
              
                     carType.setTClass("tepimages/"+bimg);
                   }
		  
		   if(carTypeService.updateType(carType)){
			   session.put("upcartype", carType);
			   session.put("upbrand", "修改成功");
			 
		   }
		 return "tjuptype";
	}
	/**
	 * 删除车型action
	 */
	 public String deltype() throws Exception{
		 String tid=request.getParameter("tid");
		 Cartype carType=new Cartype();
		   carType.setTId(Integer.parseInt(tid));
		  
   if(carTypeService.deleteCarType(carType)){
	   response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(1);
		 response.getWriter().flush();//清空缓存,刷新
		   response.getWriter().close();
   }
		 return "deltype";
	 }
	 /**
	 * 分页展示品牌的方法
	 * 
	 */
	private void fenye(HttpServletRequest req,Carbrand carBrand){
		
		
			try {
			int curPage=0;
			if(req.getParameter("jumpPage")!=null){
			 curPage =Integer.parseInt(req.getParameter("jumpPage"));
		 }
			
			
	   
		 long maxRowsCount=brandPage.queryPersonCarCount(carBrand);
			//处理分页逻辑<=>调用
			PageUtil pageUtil=new PageUtil(8, maxRowsCount);
			// 处理页码逻辑
			if (curPage <= 1) {

				pageUtil.setCurPage(1);
			} else if (curPage >= pageUtil.getMaxPage()) {

				pageUtil.setCurPage(pageUtil.getMaxPage());
			} else {
				pageUtil.setCurPage(curPage);
			}
			
			
			Map<Long, Object> trendsMap=brandPage.showPersonCarList(pageUtil.getCurPage(),pageUtil.getRowsPrePage(), carBrand);
			DbUtil.closeAll();
			Map<Long, Carbrand> _brandMap=new HashMap<Long, Carbrand>();
			for(Long key:trendsMap.keySet()){
				Carbrand _carBrand=(Carbrand) trendsMap.get(key);
				_brandMap.put((long) _carBrand.getBId() ,_carBrand);
			}
			
			req.setAttribute("brandMap", _brandMap);
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
	 * 分页展示车龄的方法
	 * 
	 */
	private void fenyeage(HttpServletRequest req,Carage carAge){
		
		
			try {
			int curPage=0;
			if(req.getParameter("jumpPage")!=null){
			 curPage =Integer.parseInt(req.getParameter("jumpPage"));
		 }
			
			
	  
		 long maxRowsCount=carAgePage.queryPersonCarCount(carAge);
			//处理分页逻辑<=>调用
			PageUtil pageUtil=new PageUtil(8, maxRowsCount);
			// 处理页码逻辑
			if (curPage <= 1) {

				pageUtil.setCurPage(1);
			} else if (curPage >= pageUtil.getMaxPage()) {

				pageUtil.setCurPage(pageUtil.getMaxPage());
			} else {
				pageUtil.setCurPage(curPage);
			}
			
			
			Map<Long, Object> trendsMap=carAgePage.showPersonCarList(pageUtil.getCurPage(),pageUtil.getRowsPrePage(), carAge);
			DbUtil.closeAll();
			Map<Long, Carage> _brandMap=new HashMap<Long, Carage>();
			for(Long key:trendsMap.keySet()){
				Carage _carBrand=(Carage) trendsMap.get(key);
				_brandMap.put((long) _carBrand.getAId() ,_carBrand);
			}
			
			req.setAttribute("brandMap", _brandMap);
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
	 * 分页展示价格区间的方法
	 * 
	 */
	private void fenyeprice(HttpServletRequest req, Priceinterval priceInterval){
		
	
			try {
			int curPage=0;
			if(req.getParameter("jumpPage")!=null){
			 curPage =Integer.parseInt(req.getParameter("jumpPage"));
		 }
			
			
	  
		 long maxRowsCount=pricePage.queryPersonCarCount(priceInterval);
			//处理分页逻辑<=>调用
			PageUtil pageUtil=new PageUtil(8, maxRowsCount);
			// 处理页码逻辑
			if (curPage <= 1) {

				pageUtil.setCurPage(1);
			} else if (curPage >= pageUtil.getMaxPage()) {

				pageUtil.setCurPage(pageUtil.getMaxPage());
			} else {
				pageUtil.setCurPage(curPage);
			}
			
			
			Map<Long, Object> trendsMap=pricePage.showPersonCarList(pageUtil.getCurPage(),pageUtil.getRowsPrePage(), priceInterval);
			DbUtil.closeAll();
			Map<Long, Priceinterval> _brandMap=new HashMap<Long, Priceinterval>();
			for(Long key:trendsMap.keySet()){
				Priceinterval _carBrand=(Priceinterval) trendsMap.get(key);
				_brandMap.put((long) _carBrand.getPId() ,_carBrand);
			}
			
			req.setAttribute("brandMap", _brandMap);
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
	 * 分页展示行驶距离的方法
	 * 
	 */
	private void fenyedis(HttpServletRequest req,Distance distance){
		
		
			try {
			int curPage=0;
			if(req.getParameter("jumpPage")!=null){
			 curPage =Integer.parseInt(req.getParameter("jumpPage"));
		 }
			
			
	 
		 long maxRowsCount=distancePage.queryPersonCarCount(distance);
			//处理分页逻辑<=>调用
			PageUtil pageUtil=new PageUtil(8, maxRowsCount);
			// 处理页码逻辑
			if (curPage <= 1) {

				pageUtil.setCurPage(1);
			} else if (curPage >= pageUtil.getMaxPage()) {

				pageUtil.setCurPage(pageUtil.getMaxPage());
			} else {
				pageUtil.setCurPage(curPage);
			}
			
			
			Map<Long, Object> trendsMap=distancePage.showPersonCarList(pageUtil.getCurPage(),pageUtil.getRowsPrePage(), distance);
			DbUtil.closeAll();
			Map<Long, Distance> _brandMap=new HashMap<Long, Distance>();
			for(Long key:trendsMap.keySet()){
				Distance _carBrand=(Distance) trendsMap.get(key);
				_brandMap.put((long) _carBrand.getDId() ,_carBrand);
			}
			
			req.setAttribute("brandMap", _brandMap);
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
	 * 分页展示排放标准的方法
	 * 
	 */
	private void fenyeemsi(HttpServletRequest req, Emissionstandard emissionstandard){
		
		
			try {
			int curPage=0;
			if(req.getParameter("jumpPage")!=null){
			 curPage =Integer.parseInt(req.getParameter("jumpPage"));
		 }
			
			

		 long maxRowsCount=emisPage.queryPersonCarCount(emissionstandard);
			//处理分页逻辑<=>调用
			PageUtil pageUtil=new PageUtil(8, maxRowsCount);
			// 处理页码逻辑
			if (curPage <= 1) {

				pageUtil.setCurPage(1);
			} else if (curPage >= pageUtil.getMaxPage()) {

				pageUtil.setCurPage(pageUtil.getMaxPage());
			} else {
				pageUtil.setCurPage(curPage);
			}
			
			
			Map<Long, Object> trendsMap=emisPage.showPersonCarList(pageUtil.getCurPage(),pageUtil.getRowsPrePage(), emissionstandard);
			DbUtil.closeAll();
			Map<Long, Emissionstandard> _brandMap=new HashMap<Long, Emissionstandard>();
			for(Long key:trendsMap.keySet()){
				Emissionstandard _carBrand=(Emissionstandard) trendsMap.get(key);
				_brandMap.put((long) _carBrand.getEId() ,_carBrand);
			}
			
			req.setAttribute("brandMap", _brandMap);
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
	 * 分页展示车型的方法
	 * 
	 */
	private void fenyeety(HttpServletRequest req,Cartype carType){
		
		
			try {
			int curPage=0;
			if(req.getParameter("jumpPage")!=null){
			 curPage =Integer.parseInt(req.getParameter("jumpPage"));
		 }
			
			

		 long maxRowsCount=carTypePage.queryPersonCarCount(carType);
			//处理分页逻辑<=>调用
			PageUtil pageUtil=new PageUtil(8, maxRowsCount);
			// 处理页码逻辑
			if (curPage <= 1) {

				pageUtil.setCurPage(1);
			} else if (curPage >= pageUtil.getMaxPage()) {

				pageUtil.setCurPage(pageUtil.getMaxPage());
			} else {
				pageUtil.setCurPage(curPage);
			}
			
			
			Map<Long, Object> trendsMap=carTypePage.showPersonCarList(pageUtil.getCurPage(),pageUtil.getRowsPrePage(), carType);
			DbUtil.closeAll();
			Map<Long, Cartype> _brandMap=new HashMap<Long, Cartype>();
			for(Long key:trendsMap.keySet()){
				Cartype _carBrand=(Cartype) trendsMap.get(key);
				_brandMap.put((long) _carBrand.getTId() ,_carBrand);
			}
			
			req.setAttribute("brandMap", _brandMap);
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
   
}
