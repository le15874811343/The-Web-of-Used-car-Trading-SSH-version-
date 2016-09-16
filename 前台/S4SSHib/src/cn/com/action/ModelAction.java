package cn.com.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;

import net.sf.json.JSONArray;
import cn.com.pojo.*;
import cn.com.service.IModelService;
import cn.com.service.impl.ModelServiceImpl;
import cn.com.util.DbUtil;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 车系操作action类
 * 
 */
public class ModelAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{
  private IModelService modelService=null;  //车系信息服务接口的引用
  private HttpServletRequest request=null;  //request
  private HttpServletResponse response=null; //response
	public IModelService getModelService() {
	return modelService;
}

public void setModelService(IModelService modelService) {
	this.modelService = modelService;
}

public HttpServletRequest getServletRequest() {
	return request;
}

//注入HttpServletRequest
@Override
public void setServletRequest(HttpServletRequest arg0) {
	// TODO Auto-generated method stub
	this.request=arg0;
}

public HttpServletResponse getServletResponse() {
	return response;
}


//注入HttpServletResponse
@Override
public void setServletResponse(HttpServletResponse arg0) {
	// TODO Auto-generated method stub
	this.response=arg0;
}
/**
 * 获取某品牌下的车系的action
 * 
 */
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		int b_id=Integer.parseInt(request.getParameter("brand"));
		Model model=new Model();
		model.setBId(b_id);
		List<Model> modelMap=modelService.getModelByWhere(model);
	  DbUtil.closeAll();
	   //list json转换
	 
	   JSONArray jsonArray= JSONArray.fromObject(modelMap);
	  response.setContentType("text/html;charset=utf-8"); //设置上下文编码，格式
	  response.getWriter().println(jsonArray);
	  response.getWriter().flush();//清空缓存，刷新
	  response.getWriter().close();
	  return null;
	}

	


   
}
