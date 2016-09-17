package cn.com.action;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 图片上传action
 * @author lej
 */
public class UploadAction extends ActionSupport implements ServletResponseAware,ServletRequestAware,SessionAware {
   private HttpServletResponse response; //response
   private HttpServletRequest request;  //request
   private Map<String, Object> session;  //session
   private File filePath; //文件
   private String filePathFileName; //文件名
   private String filePathFileContentType;  //文件内容形式
   private File filePath1;
   private String filePath1FileName;
   private String filePath1FileContentType;
   private File filePath2;
   private String filePath2FileName;
   private String filePath2FileContentType;
   private File filePath3;
   private String filePath3FileName;
   private String filePath3FileContentType;
   private File filePath4;
   private String filePath4FileName;
   private String filePath4FileContentType;
   private File filePath5;
   private String filePath5FileName;
   private String filePath5FileContentType;
   
	public File getFilePath2() {
	return filePath2;
}


public void setFilePath2(File filePath2) {
	this.filePath2 = filePath2;
}


public String getFilePath2FileName() {
	return filePath2FileName;
}


public void setFilePath2FileName(String filePath2FileName) {
	this.filePath2FileName = filePath2FileName;
}


public String getFilePath2FileContentType() {
	return filePath2FileContentType;
}


public void setFilePath2FileContentType(String filePath2FileContentType) {
	this.filePath2FileContentType = filePath2FileContentType;
}


public File getFilePath3() {
	return filePath3;
}


public void setFilePath3(File filePath3) {
	this.filePath3 = filePath3;
}


public String getFilePath3FileName() {
	return filePath3FileName;
}


public void setFilePath3FileName(String filePath3FileName) {
	this.filePath3FileName = filePath3FileName;
}


public String getFilePath3FileContentType() {
	return filePath3FileContentType;
}


public void setFilePath3FileContentType(String filePath3FileContentType) {
	this.filePath3FileContentType = filePath3FileContentType;
}


public File getFilePath4() {
	return filePath4;
}


public void setFilePath4(File filePath4) {
	this.filePath4 = filePath4;
}


public String getFilePath4FileName() {
	return filePath4FileName;
}


public void setFilePath4FileName(String filePath4FileName) {
	this.filePath4FileName = filePath4FileName;
}


public String getFilePath4FileContentType() {
	return filePath4FileContentType;
}


public void setFilePath4FileContentType(String filePath4FileContentType) {
	this.filePath4FileContentType = filePath4FileContentType;
}


public File getFilePath5() {
	return filePath5;
}


public void setFilePath5(File filePath5) {
	this.filePath5 = filePath5;
}


public String getFilePath5FileName() {
	return filePath5FileName;
}


public void setFilePath5FileName(String filePath5FileName) {
	this.filePath5FileName = filePath5FileName;
}


public String getFilePath5FileContentType() {
	return filePath5FileContentType;
}


public void setFilePath5FileContentType(String filePath5FileContentType) {
	this.filePath5FileContentType = filePath5FileContentType;
}


	public File getFilePath1() {
	return filePath1;
}


public void setFilePath1(File filePath1) {
	this.filePath1 = filePath1;
}


public String getFilePath1FileName() {
	return filePath1FileName;
}


public void setFilePath1FileName(String filePath1FileName) {
	this.filePath1FileName = filePath1FileName;
}


public String getFilePath1FileContentType() {
	return filePath1FileContentType;
}


public void setFilePath1FileContentType(String filePath1FileContentType) {
	this.filePath1FileContentType = filePath1FileContentType;
}




	public File getFilePath() {
	return filePath;
}


public void setFilePath(File filePath) {
	this.filePath = filePath;
}


public String getFilePathFileName() {
	return filePathFileName;
}


public void setFilePathFileName(String filePathFileName) {
	this.filePathFileName = filePathFileName;
}


public String getFilePathFileContentType() {
	return filePathFileContentType;
}


public void setFilePathFileContentType(String filePathFileContentType) {
	this.filePathFileContentType = filePathFileContentType;
}


	public HttpServletResponse getServletResponse() {
	return response;
}


public HttpServletRequest getServletRequest() {
	return request;
}



public Map<String, Object> getSession() {
	return session;
}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session=arg0;
	}

	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request=arg0;
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response=arg0;
	}

/**
 * 上传图片action
 * 
 */
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		

	        try {

	  		  bancfsc(request); //防止重复上传
	  		  if(this.getFilePath()!=null&&this.getFilePath().exists()){
	            File f = this.getFilePath();
	           
	            String filepath =request.getServletContext().getRealPath("/tepimages")+"/";//获取工程服务器路径 
	           
	         
		          int p = this.getFilePathFileName().lastIndexOf(".");  //截断文件名和拓展名
		          
		          //文件类型  
		      String    type=this.getFilePathFileName().substring(p,this.getFilePathFileName().length());     
		   
		          //文件名称  
		      this.filePathFileName= System.currentTimeMillis()+type;    
	            FileInputStream inputStream = new FileInputStream(f);
	            FileOutputStream outputStream = new FileOutputStream(filepath +  this.getFilePathFileName());
	            byte[] buf = new byte[1024];
	            int length = 0;
	            while ((length = inputStream.read(buf)) != -1) {
	                outputStream.write(buf, 0, length);
	            }
	            inputStream.close();
	            outputStream.flush();
	            outputStream.close();
	            session.put("sctname", this.getFilePathFileName());
	            PrintWriter out=response.getWriter();  
	  	      String result =  this.getFilePathFileName() ;  
	  	      out.print(result);  
	  	      out.close();  
	  		  }
	  		  //之后的操作同file处
	  		  if(this.getFilePath1()!=null&&this.getFilePath1().exists()){
	  			File f = this.getFilePath1();
		           
	            String filepath =request.getServletContext().getRealPath("/tepimages")+"/";
	           
	         
		          int p = this.getFilePath1FileName().lastIndexOf("."); 
		         
		          //文件类型  
		      String    type=this.getFilePath1FileName().substring(p,this.getFilePath1FileName().length());     
		   
		          //文件名称  
		      this.filePath1FileName= System.currentTimeMillis()+type;    
	            FileInputStream inputStream = new FileInputStream(f);
	            FileOutputStream outputStream = new FileOutputStream(filepath +  this.getFilePath1FileName());
	            byte[] buf = new byte[1024];
	            int length = 0;
	            while ((length = inputStream.read(buf)) != -1) { //读取
	                outputStream.write(buf, 0, length);  //写入
	            }
	            inputStream.close();
	            outputStream.flush();
	            outputStream.close();
	            session.put("sctname", this.getFilePath1FileName());
	            PrintWriter out=response.getWriter();  
	  	      String result =  this.getFilePath1FileName() ;  
	  	      out.print(result);   //异步返回文件名
	  	      out.close();  
	  		  }
	  		 if(this.getFilePath2()!=null&&this.getFilePath2().exists()){
		  			File f = this.getFilePath2();
			           
		            String filepath =request.getServletContext().getRealPath("/tepimages")+"/";
		           
		         
			          int p = this.getFilePath2FileName().lastIndexOf("."); 
			         
			          //文件类型  
			      String    type=this.getFilePath2FileName().substring(p,this.getFilePath2FileName().length());     
			   
			          //文件名称  
			      this.filePath2FileName= System.currentTimeMillis()+type;    
		            FileInputStream inputStream = new FileInputStream(f);
		            FileOutputStream outputStream = new FileOutputStream(filepath +  this.getFilePath2FileName());
		            byte[] buf = new byte[1024];
		            int length = 0;
		            while ((length = inputStream.read(buf)) != -1) {
		                outputStream.write(buf, 0, length);
		            }
		            inputStream.close();
		            outputStream.flush();
		            outputStream.close();
		            session.put("sctname", this.getFilePath2FileName());
		            PrintWriter out=response.getWriter();  
		  	      String result =  this.getFilePath2FileName() ;  
		  	      out.print(result);  
		  	      out.close();  
		  		  }
	  		 if(this.getFilePath3()!=null&&this.getFilePath3().exists()){
		  			File f = this.getFilePath3();
			           
		            String filepath =request.getServletContext().getRealPath("/tepimages")+"/";
		           
		         
			          int p = this.getFilePath3FileName().lastIndexOf("."); 
			         
			          //文件类型  
			      String    type=this.getFilePath3FileName().substring(p,this.getFilePath3FileName().length());     
			   
			          //文件名称  
			      this.filePath3FileName= System.currentTimeMillis()+type;    
		            FileInputStream inputStream = new FileInputStream(f);
		            FileOutputStream outputStream = new FileOutputStream(filepath +  this.getFilePath3FileName());
		            byte[] buf = new byte[1024];
		            int length = 0;
		            while ((length = inputStream.read(buf)) != -1) {
		                outputStream.write(buf, 0, length);
		            }
		            inputStream.close();
		            outputStream.flush();
		            outputStream.close();
		            session.put("sctname", this.getFilePath3FileName());
		            PrintWriter out=response.getWriter();  
		  	      String result =  this.getFilePath3FileName() ;  
		  	      out.print(result);  
		  	      out.close();  
		  		  }
	  		 if(this.getFilePath4()!=null&&this.getFilePath4().exists()){
		  			File f = this.getFilePath4();
			           
		            String filepath =request.getServletContext().getRealPath("/tepimages")+"/";
		           
		         
			          int p = this.getFilePath4FileName().lastIndexOf("."); 
			         
			          //文件类型  
			      String    type=this.getFilePath4FileName().substring(p,this.getFilePath4FileName().length());     
			   
			          //文件名称  
			      this.filePath4FileName= System.currentTimeMillis()+type;    
		            FileInputStream inputStream = new FileInputStream(f);
		            FileOutputStream outputStream = new FileOutputStream(filepath +  this.getFilePath4FileName());
		            byte[] buf = new byte[1024];
		            int length = 0;
		            while ((length = inputStream.read(buf)) != -1) {
		                outputStream.write(buf, 0, length);
		            }
		            inputStream.close();
		            outputStream.flush();
		            outputStream.close();
		            session.put("sctname", this.getFilePath4FileName());
		            PrintWriter out=response.getWriter();  
		  	      String result =  this.getFilePath4FileName() ;  
		  	      out.print(result);  
		  	      out.close();  
		  		  }
	  		 if(this.getFilePath5()!=null&&this.getFilePath5().exists()){
		  			File f = this.getFilePath5();
			           
		            String filepath =request.getServletContext().getRealPath("/tepimages")+"/";
		           
		         
			          int p = this.getFilePath5FileName().lastIndexOf("."); 
			         
			          //文件类型  
			      String    type=this.getFilePath5FileName().substring(p,this.getFilePath5FileName().length());     
			   
			          //文件名称  
			      this.filePath5FileName= System.currentTimeMillis()+type;    
		            FileInputStream inputStream = new FileInputStream(f);
		            FileOutputStream outputStream = new FileOutputStream(filepath +  this.getFilePath5FileName());
		            byte[] buf = new byte[1024];
		            int length = 0;
		            while ((length = inputStream.read(buf)) != -1) {
		                outputStream.write(buf, 0, length);
		            }
		            inputStream.close();
		            outputStream.flush();
		            outputStream.close();
		            session.put("sctname", this.getFilePath5FileName());
		            PrintWriter out=response.getWriter();  
		  	      String result =  this.getFilePath5FileName() ;  
		  	      out.print(result);  
		  	      out.close();  
		  		  }
	        } catch (Exception e) {
	            e.printStackTrace();
	          
	        }
	     

		
	   
	      return "josn";
	}
	  /**
	   * 检测重复上传的方法
	   * 
	   * 
	   */
	 private void bancfsc(HttpServletRequest request){
		  String	sctname=(String)  request.getParameter("sctname");
		  System.out.println(sctname);
		 if(sctname!=null&&!sctname.equals(""))  {String url=request.getServletContext().getRealPath("/tepimages")+"/"+sctname;
		 System.out.println(url);
		    File file=new File(url);
		    System.out.println(file.getName());
		    System.out.println(file.exists());
		    if(file.exists()){
		    	
		    	if(file.delete()){
		    		System.out.println("ok");
		    	}
		    	else{
		    		System.out.println("no");
		    	}
		    
		    }
		   }
	  }
   
}
