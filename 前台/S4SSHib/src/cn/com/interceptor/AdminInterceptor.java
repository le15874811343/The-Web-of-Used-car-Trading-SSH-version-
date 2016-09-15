package cn.com.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
/**
 * 权限拦截器
 * @author lej
 */
public class AdminInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		String res=null;
		Map<String, Object> session=arg0.getInvocationContext().getSession();
		Object obj=session.get("userinfo");
		if(obj!=null)   //验证session中用户对象是否为空
		{
			res=arg0.invoke();  //不为空则通过
		}
		else{
			
			res="Login";
		}
		return res;
	}
    
}
