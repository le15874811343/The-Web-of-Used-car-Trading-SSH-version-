package cn.com.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AdminInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		String res=null;
		Map<String, Object> session=arg0.getInvocationContext().getSession();
		Object obj=session.get("userinfo");
		if(obj!=null)
		{
			res=arg0.invoke();
		}
		else{
			
			res="Login";
		}
		return res;
	}
    
}
