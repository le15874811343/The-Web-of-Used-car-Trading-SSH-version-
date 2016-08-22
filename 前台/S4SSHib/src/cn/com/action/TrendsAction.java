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
import cn.com.service.ICommentService;
import cn.com.service.ITrendsService;
import cn.com.service.impl.CommentServiceImpl;
import cn.com.util.DbUtil;
import cn.com.util.PageUtil;

import com.opensymphony.xwork2.ActionSupport;

public class TrendsAction  extends ActionSupport implements SessionAware,ServletRequestAware{
   private ITrendsService trendsService=null;
   private IPageDao trendsPage=null;
   private ICommentService commentService=null;
   private IPageDao commentsPage=null;
   private HttpServletRequest request=null;
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
public String showNewsList() throws Exception {
	// TODO Auto-generated method stub
  Trends trends=new Trends();
	trends.setTrType("����");
	fenye(request,  trends);
	
	return "showNewsList";
}
public String showTei() throws Exception{
	String tr_id=	request.getParameter("tr_id");
	Trends trends=new Trends();
	trends.setTrId(Long.parseLong(tr_id));
 Trends _Trends=	 trendsService.getTrendsByWhere(trends);
 request.setAttribute("_trends", _Trends);

	return "showTei";
}
public String showActive() throws Exception{
	Trends trends=new Trends();
	trends.setTrType("�");
	fenye(request,  trends);

	return "showActive";
}
public String showTeia() throws Exception{
	String tr_id=	request.getParameter("tr_id");
	Trends trends=new Trends();
	trends.setTrId(Long.parseLong(tr_id));
 Trends _Trends=	 trendsService.getTrendsByWhere(trends);
 request.setAttribute("_trends", _Trends);
 
	return "showTeia";
}
public String showCom() throws Exception{
	Comment1 comment=new Comment1();
	fenyec(request, comment);

	return "showCom";
}
public String showComd() throws Exception{
	String tr_id=	request.getParameter("cid");
	Comment1 comment=new Comment1();
	comment.setCId(Long.parseLong(tr_id));
	
comment=	commentService.getComment(comment);
request.setAttribute("_trends", comment);

	return "showComd";
}
private void fenye(HttpServletRequest req,Trends trends){
	
	
	try {
	int curPage=0;
	if(req.getParameter("jumpPage")!=null){
	 curPage =Integer.parseInt(req.getParameter("jumpPage"));
 }
	
	

 long maxRowsCount=trendsPage.queryPersonCarCount(trends);
	//�����ҳ�߼�<=>����
	PageUtil pageUtil=new PageUtil(2, maxRowsCount);
	// ����ҳ���߼�
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
private void fenyec(HttpServletRequest req,Comment1 comment){

try {
int curPage=0;
if(req.getParameter("jumpPage")!=null){
 curPage =Integer.parseInt(req.getParameter("jumpPage"));
}



long maxRowsCount=commentsPage.queryPersonCarCount(comment);
//�����ҳ�߼�<=>����
PageUtil pageUtil=new PageUtil(2, maxRowsCount);
// ����ҳ���߼�
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
