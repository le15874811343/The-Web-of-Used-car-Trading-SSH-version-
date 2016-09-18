package cn.com.action;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.imageio.ImageIO;
import javax.servlet.ServletRequest;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import cn.com.pojo.Userinfo3;
import cn.com.service.IUserInfoService;
import cn.com.service.impl.UserInfoServiceImpl;
import cn.com.util.DbUtil;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 用户信息处理action
 * 
 * 
 */
public class UserInfoAction extends ActionSupport  implements SessionAware,ServletRequestAware,ServletResponseAware{
  private HttpServletRequest  request;  //request
  private Map<String, Object>  session;  //session
  private IUserInfoService userInfoService=null;  //用户信息服务接口的引用

 private HttpServletResponse response; //response
 private String url;  //跳转地址
      //注入Session
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session=arg0;
	}
	public Map<String, Object> getSession() {
		return session;
	}

	//注入HttpServletRequest
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request=arg0;
	}
	public HttpServletRequest getServletRequest() {
		return request;
	}

	public IUserInfoService getUserInfoService() {
		return userInfoService;
	}
	public void setUserInfoService(IUserInfoService userInfoService) {
		this.userInfoService = userInfoService;
	}


	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
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
	 *登录action
	 */
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		 deleteYzm();//删除之前的验证码
		 bindWhere(); //跳转页面参数绑定
		 
		if(session.get("userinfo")==null){	 
			long u_tel=Long.parseLong(request.getParameter("username"));
			
			String u_pwd=request.getParameter("userpwd");
			
			Userinfo3 userInfo=new Userinfo3();
			userInfo.setUTel(u_tel);
			userInfo.setUPwd(u_pwd);
			Userinfo3 _userInfo=userInfoService.login(userInfo);
			DbUtil.closeAll();
			
			if(_userInfo!=null){
				Date date=new Date();
				 DateFormat dateFormat=new SimpleDateFormat("HH");
				 if(request.getParameterValues("checkbox")!=null){ //判断用户是否选择保存账户
				 //将账户保存至cookie中
				 Cookie cookie=new Cookie("bcUserName", Long.toString(_userInfo.getUTel()));
				 cookie.setMaxAge(365*24*60*60);
		         response.addCookie(cookie);
				 }
				 else{
				 	//否则删除原cookie中保存的账户
				Cookie[]	 cookies= request.getCookies();
				if(cookies!=null){
					for(int i=0;i<cookies.length;i++){
						if(cookies[i]!=null&&cookies[i].getName().equals("bcUserName")){
							cookies[i].setMaxAge(0);
							response.addCookie(cookies[i]);
							break;
						}
					
					}
				}
				 }
				session.put("time",dateFormat.format(date) );
				session.put("userinfo", _userInfo);
			
				
			}
			else{
				userInfo.setUPwd(null);
				String loginmessage=null;
				 if(userInfoService.getUserInfoByUnique(userInfo)==null){
					 DbUtil.closeAll();
					 loginmessage="该用户不存在";
					 String sRand= getYZM();
					    session.put("sRand", sRand);
				 }
				 else{
					 loginmessage="用户名或密码错误,请重新输入";
					 String sRand= getYZM();
					 session.put("sRand", sRand);
				 }
				 request.setAttribute("loginmessage", loginmessage);
			  

			}
		}
		 else{
			 String	 loginmessage="你已经登陆过一个账户了";
			 String sRand= getYZM();
			 session.put("sRand", sRand);
			 request.setAttribute("loginmessage", loginmessage);
			
		 }
		
		return "execute";
	}
	/**
	 * 用户需要登录的action
	 */
	public String needLogin() throws Exception{
		 deleteYzm();
		 bindWhere();
		String sRand= getYZM();
		Cookie[] cookies=request.getCookies();
		 //判断cookie中是否有用户保存的账户,有则显示
		if(cookies!=null){
			for(int i=0;i<cookies.length;i++){
				if(cookies[i]!=null&&cookies[i].getName().equals("bcUserName")){
					sRand+=","+cookies[i].getValue();
					break;
				}
			}
		}
	    session.put("sRand", sRand);
	    response.setContentType("text/html;charset=utf-8");
		 
	    response.getWriter().println(sRand);
	    response.getWriter().flush();//清空缓存,刷新
	    response.getWriter().close();
	  
		return null;
	}
	/**
	 * 用户需要注册的action
	 * 
	 */
	public String needReg() throws Exception{
		 deleteYzm();
		 bindWhere();
		 String sRand= getYZM();
		 session.put("sRand", sRand);
		
		 response.setContentType("text/html;charset=utf-8");
		
		 response.getWriter().println(sRand);
		 response.getWriter().flush();//清空缓存,刷新
		 response.getWriter().close();
		 
		return null;
	}
	/**
	 * 确认注册的action
	 */
	public String regUser() throws Exception {
		deleteYzm();//删除验证码
		 bindWhere(); //绑定页面传递参数条件
		long regname=Long.parseLong(request.getParameter("regname"));
		String realname=request.getParameter("realname");
		String sex=request.getParameter("gender");
	     String regpwd=  request.getParameter("regpwd");
	     String regmessage=null;
	     Userinfo3 userInfo=new Userinfo3();
	     userInfo.setUTel(regname);
	     if(userInfoService.getUserInfoByUnique(userInfo)!=null){
	    	 DbUtil.closeAll();
	    	 regmessage="此手机号已被注册,请进入登录面板试试找回密码吧";
	    	 String sRand= getYZM();
	    	 session.put("sRand", sRand);
	    	 
	     }
	     else{
	    	 userInfo.setUName(realname);
		     userInfo.setUPwd(regpwd);
		     userInfo.setUSex(sex);
		     userInfo.setUAdmin("普通用户");
		     if(userInfoService.addUserInfo(userInfo)){
		    	 DbUtil.closeAll();
		    String	 loginmessage="注册成功,现在就开始登录吧";
		    String sRand= getYZM();
	    	 session.put("sRand", sRand);
		    request.setAttribute("loginmessage", loginmessage);
		     }
		     else{
		    	 DbUtil.closeAll();
		    	 regmessage="注册失败";
		    	 String sRand= getYZM();
		    	 session.put("sRand", sRand);
		     }
	     }
	     request.setAttribute("regmessage", regmessage);
	    
	     return "execute";
	}
	/**
	 * 更改用户信息action
	 */
	public String update() throws Exception{
		deleteYzm();
		 bindWhere();
		 String card=request.getParameter("card");
		 String email=request.getParameter("email");
		 String qq=request.getParameter("qq");
		 String realname=request.getParameter("realname");
		 String adr=request.getParameter("adr");
		 String sex=request.getParameter("gender");
		 
	Userinfo3  userInfo=	 (Userinfo3) session.get("userinfo");
		 userInfo.setUName(realname);
		 userInfo.setUSex(sex);
		 if(card!=null&&!card.equals("")){
			 userInfo.setUCard(Long.parseLong(card));
		 }
		 if(qq!=null&&!qq.equals("")){
			 userInfo.setUQq(Long.parseLong(qq));
		 }
		 if(email!=null&&!email.equals("")){
			 userInfo.setUEmail(email);
		 }
		 if(adr!=null&&!adr.equals("")){
			 userInfo.setUAdr(adr);
		 }
		 try{
		 if(userInfoService.updateUserInfo(userInfo)){
			 session.put("userinfo", userInfo);
			return "update";
		 }
		 else{
			 return "ERROR";
			 }
		 }
		 catch (Exception e) {
             e.printStackTrace();
			 // TODO: handle exception
		return "ERROR";
		 }
		 
	}
	/**
	 * 更改密码action
	 * 
	 */
	public String updatePwd() throws Exception{
		deleteYzm();
		 bindWhere();
		Userinfo3 userInfo=(Userinfo3) session.get("userinfo");
		String opwd=	 request.getParameter("opwd");
		  userInfo.setUPwd(opwd);
		  if(userInfoService.login(userInfo)!=null){
			  String npwd=request.getParameter("npwd");
			  userInfo.setUPwd(npwd);
			if(userInfoService.updateUserPwd(userInfo)){
				 String updatemessage="密码修改成功";
				 request.setAttribute("updatemessage", updatemessage);
				 
				 return "updatepwdok";
			}
			else{
				return "ERROR";
			}
		  }
		  else{
			  String updatemessage="当前密码错误,请重新输入";
			  request.setAttribute("updatemessage", updatemessage);
			  request.getRequestDispatcher("admin/memberMyAccount.jsp").forward(request, response);
			  return "updatepwdno";
		  }
	}
	/**
	 * 换验证码action
	 * 
	 */
	public String updateYzm() throws Exception {
		deleteYzm();
		 bindWhere();
		 String sRand= getYZM();
		 response.setContentType("text/html;charset=utf-8");
		 session.put("sRand", sRand);
		 response.getWriter().println(sRand);
		 response.getWriter().flush();//清空缓存,刷新
		 response.getWriter().close();
		 return null;
	}
	/**
	 * 回到首页action
	 */
	public String hsy() throws Exception{
		deleteYzm();
		 bindWhere();
		 String sRand= getYZM();
    	 session.put("sRand", sRand);
		 String loginmessage="k";
		 request.setAttribute("loginmessage", loginmessage);
		
		return "hsy";
	}
	/**
	 * 注销操作action
	 */
	public String zhuXiao() throws Exception{
		deleteYzm();
		 bindWhere();
		 session.remove("userinfo");
		
		System.out.println(url);
		 return "execute";
	}
	/**
	 *验证码背景颜色设置的方法
	 * 
	 */
	private   Color getRandColor(int fc,int bc){  
        Random random = new Random();  
        if(fc > 255){  
            fc = 255;  
        }  
        if(bc < 255){  
            bc = 255;  
        }  
        int r = fc +random.nextInt(bc-fc);  
        int g = fc +random.nextInt(bc-fc);  
        int b = fc +random.nextInt(bc-fc);  
        return new Color(r,g,b);  
    }  
           /**
	    * 生成验证码图片的方法
	    */
private String getYZM(){
	 int width = 60;  
	    int height = 40;  
	    BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);  
	    //创建图象  
	    Graphics g = image.getGraphics();  
	    //生成随机对象  
	    Random random = new Random();  
	    //设置背景色  
	    g.setColor(getRandColor(200,250));  
	    g.fillRect(0,0,width,height);  
	    //设置字体  
	    g.setFont(new Font("Tines Nev Roman",Font.PLAIN,18));  
	    //随机产生干扰线  
	    g.setColor(getRandColor(160,200));  
	    for(int i = 0; i < 255; i++){  
	        int x = random.nextInt(width);  
	        int y = random.nextInt(height);  
	        int x1 = random.nextInt(12);  
	        int y1 = random.nextInt(12); 
	        g.drawLine(x,y,x-x1,y-y1);
	    }  
	    //随机产生认证码,4位数字  
	    String sRand = "";  
	    for(int i = 0; i < 4; i++){  
	        String rand = String.valueOf(random.nextInt(10));  
	        sRand  += rand;  
	        //将认证码显示到图象中  
	        g.setColor(new Color(20 + random.nextInt(110),20 + random.nextInt(110),20 + random.nextInt(110)));  
	        g.drawString(rand,13*i+6,16);  
	    }  
	    //图像生效  
	    g.dispose();  
	    //输出图像到页面  
	    String url=this.request.getServletContext().getRealPath("/images")+"/"+sRand+".jpg";
	   FileOutputStream fileOutputStream;
	try {
		fileOutputStream = new FileOutputStream(url, false);
		  ImageIO.write(image, "jpg", fileOutputStream);
		    fileOutputStream.close();
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	    return sRand;
}
    /**
     * 
     * 删除验证码的方法
     */
private void deleteYzm(){
String	sRand=(String) session.get("sRand");
    String url=request.getServletContext().getRealPath("/images")+"/"+sRand+".jpg";
File file=new File(url);

if(file.exists()){
	file.delete();
	
}
}
  /**
   * 绑定跳转页面传递参数的方法
   * 
   */
	private void bindWhere(){
		url=request.getParameter("url");
		if(request.getParameter("bname")!=null){
			request.setAttribute("bname", request.getParameter("bname"));
			System.out.println(request.getParameter("bname"));
		}
		if(request.getParameter("tname")!=null){
			request.setAttribute("tname", request.getParameter("tname"));
			System.out.println(request.getParameter("tname"));
		}
		if(request.getParameter("cesr")!=null){
			request.setAttribute("cesr", request.getParameter("cesr"));
			System.out.println(request.getParameter("cesr"));
		}
		if(request.getParameter("price")!=null){
			request.setAttribute("price", request.getParameter("price"));
			System.out.println(request.getParameter("price"));
		}
		if(request.getParameter("distance")!=null){
			request.setAttribute("distance", request.getParameter("distance"));
			System.out.println(request.getParameter("distance"));
		}
		if(request.getParameter("age")!=null){
			request.setAttribute("age", request.getParameter("age"));
			System.out.println(request.getParameter("age"));
		}
		if(request.getParameter("emsi")!=null){
			request.setAttribute("emsi", request.getParameter("emsi"));
			System.out.println(request.getParameter("emsi"));
		}
		if(request.getParameter("bid")!=null){
			request.setAttribute("bid", request.getParameter("bid"));
			System.out.println(request.getParameter("bid"));
		}
		if(request.getParameter("cid")!=null){
			request.setAttribute("cid", request.getParameter("cid"));
			System.out.println(request.getParameter("cid"));
		}
	}
}
