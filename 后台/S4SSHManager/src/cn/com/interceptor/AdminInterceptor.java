package cn.com.interceptor;

import java.util.Map;

import cn.com.pojo.Userinfo3;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class AdminInterceptor extends AbstractInterceptor {

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		String res=null;
		Map<String, Object> session=arg0.getInvocationContext().getSession();
		Object object=  session.get("userinfo");
		if(object!=null){
			Userinfo3 userInfo=(Userinfo3) object;
			if(userInfo.getUAdmin().equals("π‹¿Ì‘±")){
				arg0.invoke();
			}
			else{
	        res="login";
			}
		}
		else{
			res="Login";
		}
		return res;
	}
    
}
