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

public class ModelAction extends ActionSupport implements ServletRequestAware,ServletResponseAware{
  private IModelService modelService=null;
  private HttpServletRequest request=null;
  private HttpServletResponse response=null;
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
	  response.getWriter().flush();//Çå¿Õ»º´æ,Ë¢ÐÂ
	  response.getWriter().close();
	  return null;
	}

	


   
}
