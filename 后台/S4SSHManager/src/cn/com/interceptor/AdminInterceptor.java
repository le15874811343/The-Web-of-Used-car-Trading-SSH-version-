package cn.com.interceptor;

import java.util.Map;

import cn.com.pojo.Userinfo3;

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
		Object object=  session.get("userinfo");
		if(object!=null){ //验证session中用户对象是否为空
			Userinfo3 userInfo=(Userinfo3) object;
			if(userInfo.getUAdmin().equals("管理员")){//验证用户权限是否为管理员
				arg0.invoke();  //不为空则通过
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
