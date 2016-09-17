package cn.com.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import cn.com.pojo.*;

import cn.com.dao.*;
import cn.com.service.*;
import cn.com.service.impl.*;
import cn.com.util.DbUtil;
import cn.com.util.PageUtil;

import com.opensymphony.xwork2.ActionSupport;
 /**
  * 公司动态消息管理action
  * 
  */
public class TrendsAction  extends ActionSupport implements SessionAware,ServletRequestAware,ServletResponseAware{
   private ITrendsService trendsService=null; //公司动态消息服务接口的引用
   private IPageDao trendsPage=null; //分页处理操作接口的引用（指向公司动态消息操作实现类）
   private ICommentService commentService=null;//评论信息服务接口的引用
   private IPageDao commentsPage=null; //分页处理操作接口的引用（指向评论消息操作实现类）
   private HttpServletRequest request=null;//request
   private HttpServletResponse response=null;//response
   public HttpServletResponse getServletResponse() {
		return response;
	}
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response=arg0;
	}
   public ICommentService getCommentService() {
	return commentService;
}
public void setCommentService(ICommentService commentService) {
	this.commentService = commentService;
}
public IPageDao getCommentsPage() {
	return commentsPage;
}
public void setCommentsPage(IPageDao commentsPage) {
	this.commentsPage = commentsPage;
}
private Map<String, Object> session=null;
public ITrendsService getTrendsService() {
	return trendsService;
}
public void setTrendsService(ITrendsService trendsService) {
	this.trendsService = trendsService;
}
public IPageDao getTrendsPage() {
	return trendsPage;
}
public void setTrendsPage(IPageDao trendsPage) {
	this.trendsPage = trendsPage;
}
public Map<String, Object> getSession() {
	return session;
}
@Override
public void setSession(Map<String, Object> arg0) {
	// TODO Auto-generated method stub
	this.session=arg0;
}

public HttpServletRequest getServletRequest() {
	return request;
}

@Override
public void setServletRequest(HttpServletRequest arg0) {
	// TODO Auto-generated method stub
	this.request=arg0;
}
/**
 * 展示新闻列表action
 */
public String shownewslist() throws Exception {
	// TODO Auto-generated method stub
	Trends trends=new Trends();
	trends.setTrType("新闻");
	fenye(request, trends);
	
	
	return "shownewslist";
}
/**
 * 展示新闻详情action
 */
public String showtei() throws Exception{
	String tr_id=	request.getParameter("tr_id");
	Trends trends=new Trends();
	trends.setTrId(Long.parseLong(tr_id));
 Trends _Trends=	 trendsService.getTrendsByWhere(trends);
 request.setAttribute("_trends", _Trends);

	return "showtei";
}
/**
 * 展示活动列表action
 */
public String showactive() throws Exception{
	Trends trends=new Trends();
	trends.setTrType("活动");
	fenye(request,  trends);

	return "showActive";
}
/**
 * 展示活动详情action
 */
public String showteia() throws Exception{
	String tr_id=	request.getParameter("tr_id");
	Trends trends=new Trends();
	trends.setTrId(Long.parseLong(tr_id));
 Trends _Trends=	 trendsService.getTrendsByWhere(trends);
 request.setAttribute("_trends", _Trends);
 
	return "showTeia";
}
/**
 * 展示评价列表action
 */
public String showcom() throws Exception{
	Comment1 comment=new Comment1();
	fenyec(request, comment);

	return "showCom";
}
/**
 *展示评价详情action 
 */
public String showcomd() throws Exception{
	String tr_id=	request.getParameter("cid");
	Comment1 comment=new Comment1();
	comment.setCId(Long.parseLong(tr_id));
	
comment=	commentService.getComment(comment);
request.setAttribute("_trends", comment);

	return "showComd";
}
/**
 * 展示所有动态消息action
 */
public String showalltrends() throws Exception{
	Trends trends=new Trends();
	
	fenye(request, trends);

	return "showalltrends";
}
/**
 * 添加动态消息action
 */
public String addtrends() throws Exception{
	String title=request.getParameter("maxAge");
	String text=request.getParameter("zm");
	String type=request.getParameter("sel1");
	String img=request.getParameter("ttp");
	Trends trends=new Trends();
	trends.setTrTitle(title);
	trends.setTrText(text);
	trends.setTrType(type);
    Date date=new Date();
   trends.setTrDate(date);
   trends.setTrImg("");
   if(img!=null&&!img.equals("")){
	   trends.setTrImg("tepimages/"+img);
     }
   if(trendsService.addTrends(trends)){
	   request.setAttribute("mea", "添加成功");
	 
   }
	return "addtrends";
}
/**
 * 请求修改动态消息action
 */
public String uptrends() throws Exception{
	String id=request.getParameter("tid");
	Trends trends=new Trends();
	trends.setTrId(Long.parseLong(id));
trends=	trendsService.getTrendsByWhere(trends);

session.put("utrends",trends );
	return "uptrends";
}
/**
 * 提交修改动态消息action
 */
public String tjuptrends() throws Exception{
	String id=request.getParameter("tid");
	
	String title=request.getParameter("maxAge");
	String text=request.getParameter("zm");
	String type=request.getParameter("sel1");
	String img=request.getParameter("ttp");
	Trends trends=new Trends();
	trends.setTrTitle(title);
	trends.setTrText(text);
	trends.setTrType(type);
	trends.setTrId(Long.parseLong(id));
	
   trends.setTrImg(request.getParameter("qtp"));
   if(img!=null&&!img.equals("")){
	 
      
           
		   trends.setTrImg("tepimages/"+img);
	
     }
   if(trendsService.updateTrends(trends)){
	   session.put("utrends",trends );
	   session.put("tmea","修改成功" );
		
   }
	return "tjuptrends";
}
/**
 * 删除动态消息action
 */
public String deltrends() throws Exception{
	String id=request.getParameter("tid");
	Trends trends=new Trends();
	trends.setTrId(Long.parseLong(id));
	if(trendsService.deleteTrends(trends)){
		 response.setContentType("text/html;charset=utf-8");
		response.getWriter().print(1);
		 response.getWriter().flush();//清空缓存,刷新
		   response.getWriter().close();
	}
	return "deltrends";
}
/**
 * 添加新闻action
 */
public String addnews() throws Exception{
	String title=request.getParameter("maxAge");
	String text=request.getParameter("zm");
	
	String img=request.getParameter("ttp");
	Trends trends=new Trends();
	trends.setTrTitle(title);
	trends.setTrText(text);
	trends.setTrType("新闻");
	
    Date date=new Date();
   trends.setTrDate(date);
   trends.setTrImg("");
   if(img!=null&&!img.equals("")){
	   trends.setTrImg("tepimages/"+img);
     }
   if(trendsService.addTrends(trends)){
	   request.setAttribute("mea", "添加成功");
	   
   }
	return "addnews";
}
/**
 * 请求修改新闻action
 */
public String upnews() throws Exception{
	String id=request.getParameter("tid");
	Trends trends=new Trends();
	trends.setTrId(Long.parseLong(id));
trends=	trendsService.getTrendsByWhere(trends);

session.put("utrends",trends );

	return "upnews";
}
/**
 * 提交修改新闻action
 */
public String tjupnews() throws Exception{
	String id=request.getParameter("tid");
	
	String title=request.getParameter("maxAge");
	String text=request.getParameter("zm");
	
	String img=request.getParameter("ttp");
	Trends trends=new Trends();
	trends.setTrTitle(title);
	trends.setTrText(text);
	trends.setTrType("新闻");
	trends.setTrId(Long.parseLong(id));
	
	   trends.setTrImg(request.getParameter("qtp"));
   if(img!=null&&!img.equals("")){
	 
     
       
	   trends.setTrImg("tepimages/"+img);
     }
   if(trendsService.updateTrends(trends)){
	   session.put("utrends",trends );
	   session.put("tmea","修改成功" );
		
   }
	return "tjupnews";
}
/**
 * 添加活动action
 */
public String addactive() throws Exception{
	String title=request.getParameter("maxAge");
	String text=request.getParameter("zm");
	
	String img=request.getParameter("ttp");
	Trends trends=new Trends();
	trends.setTrTitle(title);
	trends.setTrText(text);
	trends.setTrType("活动");
	
    Date date=new Date();
   trends.setTrDate(date);
   trends.setTrImg("");
   if(img!=null&&!img.equals("")){
	   trends.setTrImg("tepimages/"+img);
     }
   if(trendsService.addTrends(trends)){
	   request.setAttribute("mea", "添加成功");
	  
   }
	return "addactive";
}
/**
 * 请求修改活动action
 */
public String upactive() throws Exception{
	String id=request.getParameter("tid");
	Trends trends=new Trends();
	trends.setTrId(Long.parseLong(id));
trends=	trendsService.getTrendsByWhere(trends);

session.put("utrends",trends );

	return "upactive";
}
/**
 * 提交修改活动action
 */
public String tjupactive() throws Exception{
	String id=request.getParameter("tid");
	
	String title=request.getParameter("maxAge");
	String text=request.getParameter("zm");
	
	String img=request.getParameter("ttp");
	Trends trends=new Trends();
	trends.setTrTitle(title);
	trends.setTrText(text);
	trends.setTrType("活动");
	trends.setTrId(Long.parseLong(id));
	
	   trends.setTrImg(request.getParameter("qtp"));
   if(img!=null&&!img.equals("")){
	
     
       
	   trends.setTrImg("tepimages/"+img);
     }
   if(trendsService.updateTrends(trends)){
	   session.put("utrends",trends );
	   session.put("tmea","修改成功" );
		
   }
	return "tjupactive";
}
/**
 * 请求修改评价action
 */
public String upcom() throws Exception{
	String cid=request.getParameter("cid");
	Comment1 comment=new Comment1();
	comment.setCId(Long.parseLong(cid));
	
	comment=commentService.getComment(comment);
	session.put("ucomment", comment);
	
	
	return "upcom";
}
/**
 * 提交修改评价action
 */
public String tjupcom() throws Exception{
	String cid=request.getParameter("cid");
	String bt=request.getParameter("maxAge");
	String admin=request.getParameter("sel1");
	String text=request.getParameter("zm");
	Comment1 comment=new Comment1();
	comment.setCId(Long.parseLong(cid));
	comment.setCBt(bt);
	comment.setCAdmin(admin);
	comment.setCText(text);
	comment.setCImg(request.getParameter("qtp"));	
	String img=request.getParameter("ttp");
   if(img!=null&&!img.equals("")){     
	   comment.setCImg("tepimages/"+img);
     }
  
   if(commentService.updateComment(comment)){
	   session.put("ucomment", comment);
	   session.put("cmea", "修改成功");
		
   }
	return "tjupcom";
}
/**
 * 删除评价action
 */
public String delcom() throws Exception{
	String cid=request.getParameter("cid");
	Comment1 comment=new Comment1();
	comment.setCId(Long.parseLong(cid));
	
	if(commentService.deleteComment(comment)){
		 response.setContentType("text/html;charset=utf-8");
			response.getWriter().print(1);
			 response.getWriter().flush();//清空缓存,刷新
			   response.getWriter().close();
	}
	return "delcom";
}
	/**
	 * 分页展示动态消息的方法
	 * 
	 */
private void fenye(HttpServletRequest req,Trends trends){
	
	
	try {
	int curPage=0;
	if(req.getParameter("jumpPage")!=null){
	 curPage =Integer.parseInt(req.getParameter("jumpPage"));
 }
	
	

 long maxRowsCount=trendsPage.queryPersonCarCount(trends);
	//处理分页逻辑<=>调用
	PageUtil pageUtil=new PageUtil(2, maxRowsCount);
	// 处理页码逻辑
	if (curPage <= 1) {

		pageUtil.setCurPage(1);
	} else if (curPage >= pageUtil.getMaxPage()) {

		pageUtil.setCurPage(pageUtil.getMaxPage());
	} else {
		pageUtil.setCurPage(curPage);
	}
	
	
	Map<Long, Object> trendsMap=trendsPage.showPersonCarList(pageUtil.getCurPage(),pageUtil.getRowsPrePage(), trends);
	DbUtil.closeAll();
	Map<Long, Trends> _trendsMap=new HashMap<Long, Trends>();
	for(Long key:trendsMap.keySet()){
		Trends _trends=(Trends) trendsMap.get(key);
	_trendsMap.put(_trends.getTrId() ,_trends);
	}
	req.setAttribute("trends", _trendsMap);
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
	  * 分页展示评价的方法
	  * 
	  */
private void fenyec(HttpServletRequest req,Comment1 comment){

try {
int curPage=0;
if(req.getParameter("jumpPage")!=null){
 curPage =Integer.parseInt(req.getParameter("jumpPage"));
}



long maxRowsCount=commentsPage.queryPersonCarCount(comment);
//处理分页逻辑<=>调用
PageUtil pageUtil=new PageUtil(2, maxRowsCount);
// 处理页码逻辑
if (curPage <= 1) {

	pageUtil.setCurPage(1);
} else if (curPage >= pageUtil.getMaxPage()) {

	pageUtil.setCurPage(pageUtil.getMaxPage());
} else {
	pageUtil.setCurPage(curPage);
}


Map<Long, Object> trendsMap=commentsPage.showPersonCarList(pageUtil.getCurPage(),pageUtil.getRowsPrePage(), comment);
DbUtil.closeAll();
Map<Long, Comment1> _trendsMap=new HashMap<Long, Comment1>();
for(Long key:trendsMap.keySet()){
	Comment1 _trends=(Comment1) trendsMap.get(key);
_trendsMap.put(_trends.getCId() ,_trends);
}
req.setAttribute("trends", _trendsMap);
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
