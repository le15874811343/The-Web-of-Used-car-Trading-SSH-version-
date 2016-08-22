package cn.com.action;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileOutputStream;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.labels.StandardPieToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.TextAnchor;

import cn.com.pojo.Price;
import cn.com.service.IPriceService;
import cn.com.service.impl.PriceServiceImpl;

import com.opensymphony.xwork2.ActionSupport;

public class PriceAction extends ActionSupport implements SessionAware,ServletRequestAware,ServletResponseAware {
	private HttpServletRequest request;
	private Map<String, Object> session;
	private HttpServletResponse response=null;
	private  int year=0;

	private  int month=0;
	private  int day=0;
	private CategoryDataset dataset = getDataSet();  
	private DefaultPieDataset dfp = new DefaultPieDataset();  
	private IPriceService iPriceService=new PriceServiceImpl();
	
	

	public HttpServletResponse getServletResponse() {
		return response;
	}
	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.response=arg0;
	}
	public HttpServletRequest getServletRequest() {
		return request;
	}
	@Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.request=arg0;
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
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		if(request.getParameter("sel1")==null)
		{
			year=0;
		}
		else
		{
			 year=Integer.parseInt(request.getParameter("sel1")) ;
		}
		if(request.getParameter("sel2")==null)
		{
			month=0;
		}
		else
		{
			month=Integer.parseInt(request.getParameter("sel2")) ;
		}
		if(request.getParameter("sel3")==null)
		{
			day=0;
		}
		else
		{
			 day=Integer.parseInt(request.getParameter("sel3")) ;
		}
			String chartkind=new String(request.getParameter("sel4").getBytes("ISO8859-1"),"UTF-8");
			
			if(chartkind.equals("��״ͼ"))
			{ 
				
			if(year>0&month>0&day>0)
			{
				 dataset = getDataSet();  
			}
			if(year>0&month>0&day==0)
			{
				 dataset = getymDataSet();  
			}
			if(year==0&month==0&day==0)
			{
				 dataset = getallDataSet();  
			}
			if(year>0&month==0&day==0)
			{
				dataset = getyearDataSet();  
			}
				
			      
			        JFreeChart chart = ChartFactory.createBarChart3D("�����������", "����Ʒ��","��������", dataset, PlotOrientation.VERTICAL, true, true, true);  
			       
			        // �Զ����趨����ɫ  
			        // chart.setBackgroundPaint(Color.getHSBColor(23,192,223));  
			        chart.setBackgroundPaint(Color.WHITE);  
			        // ��� plot��3dBarΪCategoryPlot  
			        CategoryPlot categoryPlot = chart.getCategoryPlot();  
			        // �趨ͼ��������ʾ���ֱ���ɫ  
			        categoryPlot.setBackgroundPaint(Color.BLACK);  
			        // ������������  
			        categoryPlot.setDomainGridlinePaint(Color.RED);  
			        // ���������߿ɼ�  
			        categoryPlot.setDomainGridlinesVisible(true);  
			        // ������������  
			        categoryPlot.setRangeGridlinePaint(Color.RED);  
			        // ��Ҫ���࣬�������ɸ���Ч��  
			        // BarRenderer3D renderer=(BarRenderer3D) categoryPlot.getRenderer();  
			        // ��ȡ������  
			        NumberAxis numberaxis = (NumberAxis) categoryPlot.getRangeAxis();  
			        // ����������ı�������ʹ�С  
			        numberaxis.setLabelFont(new Font("����", Font.CENTER_BASELINE, 24));  
			        // ���ô����������ֵ��������ɫ  
			        numberaxis.setLabelPaint(Color.BLACK);  
			        // ���ô����������������ɫ  
			        numberaxis.setTickLabelPaint(Color.RED);  
			        // ����������ɫ  
			        numberaxis.setTickMarkPaint(Color.BLUE);  
			        // �������Ĭ�ϼ��ֵ  
			        // numberaxis.setAutoTickUnitSelection(true);  
			        // ���ô�������ֵ  
			        numberaxis.setAutoTickUnitSelection(false);  
			        numberaxis.setTickUnit(new NumberTickUnit(1));  
			        // ��ȡ������  
			        CategoryAxis domainAxis = categoryPlot.getDomainAxis();  
			        // ���ú�����ı�������ʹ�С  
			        domainAxis.setLabelFont(new Font("����", Font.PLAIN, 13));  
			        // ���ú����������ֵ��������ɫ  
			        domainAxis.setTickLabelPaint(Color.RED);  
			        // ���ú����������ֵ������  
			        domainAxis.setTickLabelFont(new Font("����", Font.PLAIN, 30));  
			        // ���ú��������ʾ  
			        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(0.4));  
			        // ���������˵ײ��������������  
			        chart.getLegend().setItemFont(new Font("����", 0, 16));  
			        // ����ͼ������  
			        Font font = new java.awt.Font("����", java.awt.Font.CENTER_BASELINE, 50);  
			        if(day>0)
			        {
			        	 TextTitle title = new TextTitle("����"+year+"-"+month+"-"+day+"�������");  
			        	  title.setFont(font);  
			        	//  title.getBackgroundPaint(); 
			        	  title.setPaint(Color.RED); 
			        	  chart.setTitle(title); 
			        }
			        else
			        {
			        	if(year==0)
			        	{
			        		TextTitle title = new TextTitle("���������������");  
				        	 title.setFont(font);  
				        	 // title.getBackgroundPaint(); 
				        	  title.setPaint(Color.RED);  
				        	  chart.setTitle(title); 
			        	}
			        	else
			        	{
			        	
			        		if(month!=0){	TextTitle title = new TextTitle("����"+year+"-"+month+"�������");  
			        	 title.setFont(font);  
			        	  title.setPaint(Color.RED);  
			        	//  title.getBackgroundPaint(); 
			        	  chart.setTitle(title); 
			        	}
			        		else{
			        			TextTitle title = new TextTitle("����"+year+"�������");  
					        	 title.setFont(font);  
					        	  title.setPaint(Color.RED);  
					        	//  title.getBackgroundPaint(); 
					        	  chart.setTitle(title); 
			        		}
			        	}
			        }
			        Date date=new Date();
			        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
			        String name=dateFormat.format(date);
			        String filepath =request.getServletContext().getRealPath("/yeji")+"/"+name+".jpeg";
			      
			        FileOutputStream out=new FileOutputStream(new File(filepath));
			        
			 ChartUtilities.writeChartAsJPEG(out, chart, 700, 700);
			 request.setAttribute("name", name);
		
			    
			}
			if(chartkind.equals("��״ͼ"))
			{
				int count=0;
				dfp.clear();
				DecimalFormat df = new DecimalFormat("0.00");
				if(year>0&month>0&day>0)
				{
			List<Price> map=  iPriceService.getsellinfo(year, month,day);

				for(Price p:map)
				{
	          count+=p.getC_sum();
				}
		 for(Price p:map)
		 {  double b=(p.getC_sum()/count)*100;
			 dfp.setValue(p.getC_selltime()+"����:"+df.format(b)+"%", p.getC_sum());  
		 }
				}
				if(year>0&month>0&day==0)
				{
					 List<Price> list= iPriceService.getsellinfo(year, month);
					 for(Price s:list){
							count+=s.getC_sum();
						}
					 for(Price c:list)
					 {  String date[]=c.getC_selltime().split("-");
							double b=(c.getC_sum()/count)*100;
						dfp.setValue(date[2]+"��"+"����:"+df.format(b)+"%", c.getC_sum());
					 }
				}
				if(year==0&month==0&day==0)
				{ List<Price> list=  iPriceService.getsellinfo();
				for(Price s:list){
					count+=s.getC_sum();
				}
				for(Price s:list)
				{
					double b=(s.getC_sum()/count)*100;
					  String date[]=s.getC_selltime().split("-");
					dfp.setValue(date[0]+"��"+"����:"+df.format(b)+"%", s.getC_sum());
				}
					
				}
				if(year>0&month==0&day==0)
				{
					List<Price> map=  iPriceService.getsellinfo(year);
					for(Price p:map)
					{
	              count+=p.getC_sum();
					}
					for(Price p:map)
					{
						double b=(p.getC_sum()/count)*100;
						String date[]=p.getC_selltime().split("-");
						dfp.setValue(date[1]+"��"+"����:"+df.format(b)+"%",p.getC_sum());
					}
				}
		 
		        // ��״ͼ�Ľ���취  
		        // createpieChart3D����3D��ͼ  
		        // createpieChart������ͼ  
		        JFreeChart chart = ChartFactory.createPieChart3D("����������Ϣ",dfp, true, true, true);  
		      //����  
		        PiePlot pieplot = (PiePlot)chart.getPlot();
		        pieplot.setLabelFont(new Font("����", 0, 12));
		        pieplot.setNoDataMessage("������");
		        pieplot.setCircular(true);
		        
		       
		      
		        chart.setBackgroundPaint(Color.red);  
		        // ���ñ�������  
		        // ȡ�ñ�ͼplot����  
		        // PiePlot plot = (PiePlot) chart.getPlot();  
		        // ȡ��3D��ͼ����  
		        PiePlot3D plot = (PiePlot3D) chart.getPlot();  
		        // ͼ�α߿���ɫ  
		        plot.setBaseSectionOutlinePaint(Color.RED);  
		        // plot.setBaseSectionPaint(Color.WHITE);  
		        // ͼ�α߿��ϸ  
		        plot.setBaseSectionOutlineStroke(new BasicStroke(1.0f));  
		 
		        // ָ��ͼƬ��͸����(0.0-1.0)  
		        plot.setForegroundAlpha(0.65f);  
		        // ָ����ʾ�ı�ͼ��Բ��(false)����Բ��(true)  
		        plot.setCircular(true);  
		 
		        // ���õ�һ�� ����section �Ŀ�ʼλ�ã�Ĭ����12���ӷ���  
		        plot.setStartAngle(360);  
		        // ���������ͣ��ʾ  
		        plot.setToolTipGenerator(new StandardPieToolTipGenerator());  
		 
		        // ����ͻ����ʾ�����ݿ�  
		        plot.setExplodePercent("One", 0.1D);  
		        // ���ñ�ͼ�����ֱ�ǩ����  
		        plot.setLabelFont(new Font("����", Font.ITALIC, 20));  
		        // ���÷ֱ���ɫ  
		        plot.setSectionPaint(0, new Color(244, 194, 144));  
		        // plot.setSectionPaint("2", new Color(144, 233, 144));  
		        // ����ͼ��˵��Legend�ϵ�����  
		        chart.getLegend().setItemFont(new Font("����", Font.PLAIN, 30));  
		        // ���������ʽ  
		        Font font = new java.awt.Font("����", java.awt.Font.CENTER_BASELINE,50); 
		        if(day>0)
		        {
		        	 TextTitle title = new TextTitle("����"+year+"-"+month+"-"+day+"�������");  
		        	  title.setFont(font);  
		        	  chart.setTitle(title); 
		        }
		        else
		        {
		        	if(year==0)
		        	{
		        		TextTitle title = new TextTitle("���������������");  
			        	 title.setFont(font);  
			        	  chart.setTitle(title); 
		        	}
		        	else
		        	{
		        		if(month!=0){	TextTitle title = new TextTitle("����"+year+"-"+month+"�������");  
			        	 title.setFont(font);  
			        	  title.setPaint(Color.RED);  
			        	//  title.getBackgroundPaint(); 
			        	  chart.setTitle(title); 
			        	}
			        		else{
			        			TextTitle title = new TextTitle("����"+year+"�������");  
					        	 title.setFont(font);  
					        	  title.setPaint(Color.RED);  
					        	//  title.getBackgroundPaint(); 
					        	  chart.setTitle(title); 
			        		}
		        	}
		        }
		        Date date=new Date();
		        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		        String name=dateFormat.format(date);
		        String filepath =request.getServletContext().getRealPath("/yeji")+"/"+name+".jpeg";
		      
		        FileOutputStream out=new FileOutputStream(new File(filepath));
		        
		 ChartUtilities.writeChartAsJPEG(out, chart, 700, 700);
		 request.setAttribute("name", name);
				}
			if(chartkind.equals("����ͼ")){
				
				DefaultCategoryDataset dat = new DefaultCategoryDataset();
				dat.clear();
				if(year>0&month>0&day>0)
				{
			 List<Price> map=  iPriceService.getsellinfo(year, month, day);

		 for(Price s:map)
		 {  dat.addValue(s.getC_sum(), "ʱ��", s.getC_selltime());
		 }
				}
				if(year>0&month>0&day==0)
				{
					 List<Price> map=  iPriceService.getsellinfo(year, month);
					
					 for(Price c:map)
					 {  String date[]=c.getC_selltime().split("-");
					 dat.addValue(c.getC_sum(), "��", date[2]+"��");
					 }
				}
				if(year==0&month==0&day==0)
				{ List<Price> list= iPriceService.getsellinfo();
				
				for(Price s:list)
				{
					
					  String date[]=s.getC_selltime().split("-");
						 dat.addValue(s.getC_sum(), "��", date[0]+"��");

				}
					
				}
				if(year>0&month==0&day==0)
				{
					List<Price> map=  iPriceService.getsellinfo(year);
				
					for(Price s:map)
					{
						String date[]=s.getC_selltime().split("-");
						 dat.addValue(s.getC_sum(), "��", date[1]+"��");

					}
				}
		 
				JFreeChart chart = ChartFactory.createLineChart("��������ͼ", "����", "����", dat, PlotOrientation.VERTICAL,true, true, true);
				CategoryPlot cp = chart.getCategoryPlot();
				LineAndShapeRenderer renderer = (LineAndShapeRenderer) cp
						.getRenderer();
				renderer.setBaseItemLabelsVisible(true);
				renderer.setBaseShapesFilled(true);
				renderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(
						ItemLabelAnchor.OUTSIDE12, TextAnchor.BASELINE_LEFT));
				renderer

				.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());

				cp.setRenderer(renderer);
				cp.setBackgroundPaint(Color.WHITE); // ����ɫ����
				cp.setRangeGridlinePaint(Color.GRAY); // ������ɫ����
				 Date date=new Date();
			        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
			        String name=dateFormat.format(date);
			        String filepath =request.getServletContext().getRealPath("/yeji")+"/"+name+".jpeg";
			      
			        FileOutputStream out=new FileOutputStream(new File(filepath));
			        
			 ChartUtilities.writeChartAsJPEG(out, chart, 700, 700);
			 request.setAttribute("name", name);
		 
			}
			return "dateview";
	}
	
	
	private   CategoryDataset getDataSet(){
		  DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
		 IPriceService iPriceService=new PriceServiceImpl();
		  List<Price> map= iPriceService.getsellinfo(year, month, day);
		
		  for(Price s:map)
		  {
			  dataset.addValue(s.getC_sum(),s.getC_selltime()+s.getC_sum()+"��Ԫ",year+"-"+month+"-"+day );
			  }
 
		 return dataset;
	    }  
	private  CategoryDataset getallDataSet(){
		  DefaultCategoryDataset dataset = new DefaultCategoryDataset(); 
		  IPriceService iPriceService=new PriceServiceImpl();
		  List<Price> list=  iPriceService.getsellinfo();
		 
		  for(Price s:list)
		  {
			  String date[]=s.getC_selltime().split("-");
			  dataset.addValue(s.getC_sum(), date[0]+"��"+s.getC_sum()+"��Ԫ", s.getC_selltime());
			  }

		 return dataset;
	    } 
	private   CategoryDataset getymDataSet(){
		  DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
		  IPriceService iPriceService=new PriceServiceImpl();
		  List<Price> list= iPriceService.getsellinfo(year, month);
		for(Price c:list)
		{
			String date[]=c.getC_selltime().split("-");
			dataset.addValue(c.getC_sum(), date[2]+"��"+ c.getC_sum()+"��Ԫ", c.getC_selltime());
		}
		 return dataset;
	    }  
	private  CategoryDataset getyearDataSet(){
		  DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
		  IPriceService iPriceService=new PriceServiceImpl();
		List<Price> list=  iPriceService.getsellinfo(year);
		 
		for(Price p:list)
		{
			String date[]=p.getC_selltime().split("-");
			dataset.addValue(p.getC_sum(), date[1]+"��"+p.getC_sum()+"��Ԫ", p.getC_selltime());
			
		}
		 return dataset;
	    }  
    
	


}
