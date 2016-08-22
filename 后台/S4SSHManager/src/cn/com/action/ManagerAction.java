package cn.com.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import cn.com.pojo.*;

import cn.com.dao.IPageDao;
import cn.com.service.IPersonNeedService;
import cn.com.service.IUserInfoService;
import cn.com.service.impl.PersonNeedServiceImpl;
import cn.com.util.DbUtil;
import cn.com.util.PageUtil;

import com.opensymphony.xwork2.ActionSupport;

public class ManagerAction extends ActionSupport implements ServletRequestAware,SessionAware {
   private IUserInfoService userInfoServiceImpl=null;
   private IPageDao userInfoPage=null;
   private IPersonNeedService personNeedServiceImpl=null;
   private IPageDao personndPage=null;
	private HttpServletRequest request;
	private Map<String, Object> session;
	
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

	public IPageDao getUserInfoPage() {
	return userInfoPage;
}
public void setUserInfoPage(IPageDao userInfoPage) {
	this.userInfoPage = userInfoPage;
}

	public IPersonNeedService getPersonNeedServiceImpl() {
	return personNeedServiceImpl;
}
public void setPersonNeedServiceImpl(IPersonNeedService personNeedServiceImpl) {
	this.personNeedServiceImpl = personNeedServiceImpl;
}
public IPageDao getPersonndPage() {
	return personndPage;
}
public void setPersonndPage(IPageDao personndPage) {
	this.personndPage = personndPage;
}
	public String showalluser() throws Exception {
		// TODO Auto-generated method stub
		Userinfo3 userInfo=new Userinfo3();
		fenye(request,  userInfo);
		request.setAttribute("titile", "所有用户");
		
		return "showalluser";
	}
	public String showadmin() throws Exception {
		// TODO Auto-generated method stub
		Userinfo3 userInfo=new Userinfo3();
		userInfo.setUAdmin("管理员");
		fenye(request, userInfo);
		request.setAttribute("titile", "管理员");
		
		
		return "showadmin";
	}
	public String showuser() throws Exception {
		// TODO Auto-generated method stub
		Userinfo3 userInfo=new Userinfo3();
		userInfo.setUAdmin("普通用户");
		fenye(request,  userInfo);
		request.setAttribute("titile", "普通用户");
		
		return "showuser";
	}
	public String showsrdz() throws Exception {
		// TODO Auto-generated method stub
		Personneed personNeed=new Personneed();
		
		this.fenyepn(request, personNeed);
		DbUtil.closeAll();
	
		return "showsrdz";
	}
	public String showclzsrdz() throws Exception {
		// TODO Auto-generated method stub
	
		Personneed personNeed=new Personneed();
		personNeed.setPState("处理中");
		this.fenyepn(request,personNeed);
		DbUtil.closeAll();
	
		return "showclzsrdz";
	}
	public String showyclsrdz() throws Exception {
		// TODO Auto-generated method stub
		Personneed personNeed=new Personneed();
		personNeed.setPState("已处理");
		this.fenyepn(request,personNeed);
		DbUtil.closeAll();
	
		
		return "showyclsrdz";
	}
private void fenye(HttpServletRequest req, Userinfo3 userInfo){
		
		
		try {
		int curPage=0;
		if(req.getParameter("jumpPage")!=null){
		 curPage =Integer.parseInt(req.getParameter("jumpPage"));
	 }
		
		
   
	 long maxRowsCount=userInfoPage.queryPersonCarCount(userInfo);
		//处理分页逻辑<=>调用
		PageUtil pageUtil=new PageUtil(6, maxRowsCount);
		// 处理页码逻辑
		if (curPage <= 1) {

			pageUtil.setCurPage(1);
		} else if (curPage >= pageUtil.getMaxPage()) {

			pageUtil.setCurPage(pageUtil.getMaxPage());
		} else {
			pageUtil.setCurPage(curPage);
		}
		
		
		Map<Long, Object> trendsMap=userInfoPage.showPersonCarList(pageUtil.getCurPage(),pageUtil.getRowsPrePage(), userInfo);
		DbUtil.closeAll();
		Map<Long, Userinfo3> _usersMap=new HashMap<Long, Userinfo3>();
		for(Long key:trendsMap.keySet()){
			Userinfo3 _userInfo=(Userinfo3) trendsMap.get(key);
			_usersMap.put(_userInfo.getUId() ,_userInfo);
		}
		req.setAttribute("showuser", _usersMap);
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
	
	

 Long maxRowsCount=personndPage.queryPersonCarCount(personNeed);
	//处理分页逻辑<=>调用
	PageUtil pageUtil=new PageUtil(4, maxRowsCount);
	// 处理页码逻辑
	if (curPage <= 1) {

		pageUtil.setCurPage(1);
	} else if (curPage >= pageUtil.getMaxPage()) {

		pageUtil.setCurPage(pageUtil.getMaxPage());
	} else {
		pageUtil.setCurPage(curPage);
	}
	
	
	Map<Long, Object> carMap=personndPage.showPersonCarList(pageUtil.getCurPage(),pageUtil.getRowsPrePage(), personNeed);
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

}
