package cn.com.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import cn.com.dao.IPageDao;
import cn.com.pojo.*;
import cn.com.service.IPerSonCarService;
import cn.com.service.impl.CarInfoServiceImpl;
import cn.com.service.impl.PersonNeedServiceImpl;
import cn.com.util.DbUtil;
import cn.com.util.PageUtil;

import com.opensymphony.xwork2.ActionSupport;

public class MgorderAction extends ActionSupport implements ServletRequestAware,ServletResponseAware,SessionAware{
	private HttpServletRequest request;
	private Map<String, Object> session;
	private HttpServletResponse response=null;
	private IPerSonCarService perSonCarService=null;
	private IPageDao perSonCarPage=null;
	private	CarInfoServiceImpl carInfoServiceImpl=null;
	private	PersonNeedServiceImpl personNeedServiceImpl=null;
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
	
	
	public IPerSonCarService getPerSonCarService() {
		return perSonCarService;
	}
	public void setPerSonCarService(IPerSonCarService perSonCarService) {
		this.perSonCarService = perSonCarService;
	}
	public IPageDao getPerSonCarPage() {
		return perSonCarPage;
	}
	public void setPerSonCarPage(IPageDao perSonCarPage) {
		this.perSonCarPage = perSonCarPage;
	}
	
	public CarInfoServiceImpl getCarInfoServiceImpl() {
		return carInfoServiceImpl;
	}
	public void setCarInfoServiceImpl(CarInfoServiceImpl carInfoServiceImpl) {
		this.carInfoServiceImpl = carInfoServiceImpl;
	}
	
	public PersonNeedServiceImpl getPersonNeedServiceImpl() {
		return personNeedServiceImpl;
	}
	public void setPersonNeedServiceImpl(PersonNeedServiceImpl personNeedServiceImpl) {
		this.personNeedServiceImpl = personNeedServiceImpl;
	}
	public String showzzjy() throws Exception {
		// TODO Auto-generated method stub
		Personcar perSonCar=new Personcar();
		perSonCar.setPState("暂停交易");
		this.fenye(request, perSonCar);
		
		return  "showzzjy";
	}
	public String showjyz() throws Exception {
		// TODO Auto-generated method stub
		Personcar perSonCar=new Personcar();
		perSonCar.setPState("已定");
		this.fenye(request,  perSonCar);
		
		return "showjyz";
	}
	public String showjywc() throws Exception {
		// TODO Auto-generated method stub
		Personcar perSonCar=new Personcar();
		perSonCar.setPState("交易完成");
		this.fenye(request, perSonCar);
		
		return "showjywc";
	}
	public String showallord() throws Exception {
		// TODO Auto-generated method stub
		Personcar perSonCar=new Personcar();
		
		this.fenye(request, perSonCar);
		
		return "showallord";
	}
	public String tgzz() throws Exception {
		// TODO Auto-generated method stub
		
		String uid=request.getParameter("uid");
		String cuid=request.getParameter("cuid");
		String cid=request.getParameter("cid");
		Personcar perSonCar=new Personcar();
		perSonCar.setUId(Long.parseLong(uid));
		perSonCar.setCId(Long.parseLong(cid));
		perSonCar.setCUid(Long.parseLong(cuid));
		perSonCar.setPState("暂停交易");
		Carinfo carInfo=new Carinfo();
		carInfo.setCId(Long.parseLong(cid));
		carInfo.setCState("在售");
		Personcar _PerSonCar=new Personcar();
		_PerSonCar.setUId(Long.parseLong(cuid));
		_PerSonCar.setCId(Long.parseLong(cid));
		_PerSonCar.setCUid(Long.parseLong(cuid));
		_PerSonCar.setPState("暂停交易");
		
		if(perSonCarService.updatePerSoncar(_PerSonCar, "出售")&&perSonCarService.deletePersonByAll(perSonCar)&&carInfoServiceImpl.updateCarInfo(carInfo)){
			 response.setContentType("text/html;charset=utf-8");
				response.getWriter().print(1);
				 response.getWriter().flush();//清空缓存,刷新
				   response.getWriter().close();
		}
		return "tgzz";
	}
	public String qzzz() throws Exception {
		// TODO Auto-generated method stub
		String uid=request.getParameter("uid");
		String cuid=request.getParameter("cuid");
		String cid=request.getParameter("cid");
		Personcar perSonCar=new Personcar();
		perSonCar.setUId(Long.parseLong(uid));
		perSonCar.setCId(Long.parseLong(cid));
		perSonCar.setCUid(Long.parseLong(cuid));
		perSonCar.setPState("已定");
		Carinfo carInfo=new Carinfo();
		carInfo.setCId(Long.parseLong(cid));
		carInfo.setCState("在售");
		Personcar _PerSonCar=new Personcar();
		_PerSonCar.setUId(Long.parseLong(cuid));
		_PerSonCar.setCId(Long.parseLong(cid));
		_PerSonCar.setCUid(Long.parseLong(cuid));
		_PerSonCar.setPState("被定");
		
		if(perSonCarService.updatePerSoncar(_PerSonCar, "出售")&&perSonCarService.deletePersonByAll(perSonCar)&&carInfoServiceImpl.updateCarInfo(carInfo)){
			 response.setContentType("text/html;charset=utf-8");
				response.getWriter().print(1);
				 response.getWriter().flush();//清空缓存,刷新
				   response.getWriter().close();
		}
		return "qzzz";
	}
	public String jjzz() throws Exception {
		// TODO Auto-generated method stub
		String uid=request.getParameter("uid");
		String cuid=request.getParameter("cuid");
		String cid=request.getParameter("cid");
		
		Personcar perSonCar=new Personcar();
		perSonCar.setUId(Long.parseLong(uid));
		perSonCar.setCId(Long.parseLong(cid));
		perSonCar.setCUid(Long.parseLong(cuid));
		perSonCar.setPState("暂停交易");
		Personcar _PerSonCar=new Personcar();
		_PerSonCar.setUId(Long.parseLong(cuid));
		_PerSonCar.setCId(Long.parseLong(cid));
		_PerSonCar.setCUid(Long.parseLong(cuid));
		_PerSonCar.setPState("暂停交易");
		try{
		if(perSonCarService.updatePerSoncar(_PerSonCar, "被定")&&perSonCarService.updatePerSoncar(perSonCar, "已定")){
			 response.setContentType("text/html;charset=utf-8");
				response.getWriter().print(1);
				 response.getWriter().flush();//清空缓存,刷新
				   response.getWriter().close();
		}
		
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return "jjzz";
	}
	public String yclsrdz() throws Exception {
		// TODO Auto-generated method stub
		String id=request.getParameter("pid");
		Personneed personNeed=new Personneed();
		personNeed.setPId(Long.parseLong(id));
		personNeed.setPState("已处理");
	
		if(personNeedServiceImpl.updatePersonNeed(personNeed)){
			 response.setContentType("text/html;charset=utf-8");
				response.getWriter().print(1);
				 response.getWriter().flush();//清空缓存,刷新
				   response.getWriter().close();
		}
		return "yclsrdz";
	}
	public String delsrdz() throws Exception {
		// TODO Auto-generated method stub
		String id=request.getParameter("pid");
		Personneed personNeed=new Personneed();
		personNeed.setPId(Long.parseLong(id));
	
		
		if(personNeedServiceImpl.deletePersonNeed(personNeed) ){
			 response.setContentType("text/html;charset=utf-8");
				response.getWriter().print(1);
				 response.getWriter().flush();//清空缓存,刷新
				   response.getWriter().close();
		}
		return "delsrdz";
	}
private void fenye(HttpServletRequest req, Personcar perSonCar){
		
		
		try {
		int curPage=0;
		if(req.getParameter("jumpPage")!=null){
		 curPage =Integer.parseInt(req.getParameter("jumpPage"));
	 }
		
		
   
	 Long maxRowsCount=perSonCarPage.queryPersonCarCount(perSonCar);
		//处理分页逻辑<=>调用
		PageUtil pageUtil=new PageUtil(9, maxRowsCount);
		// 处理页码逻辑
		if (curPage <= 1) {

			pageUtil.setCurPage(1);
		} else if (curPage >= pageUtil.getMaxPage()) {

			pageUtil.setCurPage(pageUtil.getMaxPage());
		} else {
			pageUtil.setCurPage(curPage);
		}
		
		
		Map<Long, Personcar> perMap=perSonCarService.getPersonList(pageUtil.getCurPage(),pageUtil.getRowsPrePage(), perSonCar);
		
		Map<Long, Carinfo> carMap=new HashMap<Long, Carinfo>();
		
		for(Long key :perMap.keySet()){
			if(!perMap.get(key).getCUid().equals(perMap.get(key).getUId())){
				Carinfo carInfo=new Carinfo();
				carInfo.setCId(perMap.get(key).getCId());
			
			carInfo=	carInfoServiceImpl.getCarByWhere(carInfo).get(carInfo.getCId());
			
				carMap.put(carInfo.getCId(), carInfo);
			}
			
		}
		
		DbUtil.closeAll();
		
		req.setAttribute("szCar", perMap);
		req.setAttribute("car", carMap);
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
