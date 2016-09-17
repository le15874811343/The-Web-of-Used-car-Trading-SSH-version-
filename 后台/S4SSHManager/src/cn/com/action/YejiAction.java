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

import cn.com.pojo.Carchart;
import cn.com.service.ICarchartService;
import cn.com.service.impl.CarchartServiceImpl;

import com.opensymphony.xwork2.ActionSupport;
/**
 * 营业额报表查询处理action
 * 
 */
public class YejiAction extends ActionSupport implements SessionAware,ServletRequestAware,ServletResponseAware {
	private HttpServletRequest request;  //request
	private Map<String, Object> session; //session
	private HttpServletResponse response=null; //response
	private  int year=0; //年

	private  int month=0; //月
	private  int day=0; //日
	CategoryDataset dataset = getDataSet();    //柱状数据集
	DefaultPieDataset dfp = new DefaultPieDataset();   //饼状数据集
	private ICarchartService iCarchartService=new CarchartServiceImpl();
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
		//处理页面传递年参数
		if(request.getParameter("sel1")==null)
		{
			year=0;
		}
		else
		{
			 year=Integer.parseInt(request.getParameter("sel1")) ;
		}
		//处理页面传递月参数
		if(request.getParameter("sel2")==null)
		{
			month=0;
		}
		else
		{
			month=Integer.parseInt(request.getParameter("sel2")) ;
		}
		//处理页面传递日参数
		if(request.getParameter("sel3")==null)
		{
			day=0;
		}
		else
		{
			 day=Integer.parseInt(request.getParameter("sel3")) ;
		}
			String chartkind=new String(request.getParameter("sel4").getBytes("ISO8859-1"),"UTF-8"); //页面传递图片类型
			
			if(chartkind.equals("柱状图"))
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
				
			      
			        JFreeChart chart = ChartFactory.createBarChart3D("汽车销售情况", "汽车品牌","销售数量", dataset, PlotOrientation.VERTICAL, true, true, true);  
			       
			        // 自定义设定背景色  
			        // chart.setBackgroundPaint(Color.getHSBColor(23,192,223));  
			        chart.setBackgroundPaint(Color.WHITE);  
			        // 获得 plot：3dBar为CategoryPlot  
			        CategoryPlot categoryPlot = chart.getCategoryPlot();  
			        // 设定图表数据显示部分背景色  
			        categoryPlot.setBackgroundPaint(Color.BLACK);  
			        // 横坐标网格线  
			        categoryPlot.setDomainGridlinePaint(Color.RED);  
			        // 设置网格线可见  
			        categoryPlot.setDomainGridlinesVisible(true);  
			        // 纵坐标网格线  
			        categoryPlot.setRangeGridlinePaint(Color.RED);  
			        // 重要的类，负责生成各种效果  
			        // BarRenderer3D renderer=(BarRenderer3D) categoryPlot.getRenderer();  
			        // 获取纵坐标  
			        NumberAxis numberaxis = (NumberAxis) categoryPlot.getRangeAxis();  
			        // 设置纵坐标的标题字体和大小  
			        numberaxis.setLabelFont(new Font("黑体", Font.CENTER_BASELINE, 24));  
			        // 设置丛坐标的坐标值的字体颜色  
			        numberaxis.setLabelPaint(Color.BLACK);  
			        // 设置丛坐标的坐标轴标尺颜色  
			        numberaxis.setTickLabelPaint(Color.RED);  
			        // 坐标轴标尺颜色  
			        numberaxis.setTickMarkPaint(Color.BLUE);  
			        // 丛坐标的默认间距值  
			        // numberaxis.setAutoTickUnitSelection(true);  
			        // 设置丛坐标间距值  
			        numberaxis.setAutoTickUnitSelection(false);  
			        numberaxis.setTickUnit(new NumberTickUnit(1));  
			        // 获取横坐标  
			        CategoryAxis domainAxis = categoryPlot.getDomainAxis();  
			        // 设置横坐标的标题字体和大小  
			        domainAxis.setLabelFont(new Font("宋体", Font.PLAIN, 13));  
			        // 设置横坐标的坐标值的字体颜色  
			        domainAxis.setTickLabelPaint(Color.RED);  
			        // 设置横坐标的坐标值的字体  
			        domainAxis.setTickLabelFont(new Font("宋体", Font.PLAIN, 30));  
			        // 设置横坐标的显示  
			        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(0.4));  
			        // 这句代码解决了底部汉字乱码的问题  
			        chart.getLegend().setItemFont(new Font("黑体", 0, 16));  
			        // 设置图例标题  
			        Font font = new java.awt.Font("黑体", java.awt.Font.CENTER_BASELINE, 50);  
			        if(day>0)
			        {
			        	 TextTitle title = new TextTitle("汽车"+year+"-"+month+"-"+day+"销售情况");  
			        	  title.setFont(font);  
			        	//  title.getBackgroundPaint(); 
			        	  title.setPaint(Color.RED); 
			        	  chart.setTitle(title); 
			        }
			        else
			        {
			        	if(year==0)
			        	{
			        		TextTitle title = new TextTitle("汽车历年销售情况");  
				        	 title.setFont(font);  
				        	 // title.getBackgroundPaint(); 
				        	  title.setPaint(Color.RED);  
				        	  chart.setTitle(title); 
			        	}
			        	else
			        	{
			        	
			        		if(month!=0){	TextTitle title = new TextTitle("汽车"+year+"-"+month+"销售情况");  
			        	 title.setFont(font);  
			        	  title.setPaint(Color.RED);  
			        	//  title.getBackgroundPaint(); 
			        	  chart.setTitle(title); 
			        	}
			        		else{
			        			TextTitle title = new TextTitle("汽车"+year+"销售情况");  
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
			if(chartkind.equals("饼状图"))
			{
				int count=0;
				dfp.clear();
				DecimalFormat df = new DecimalFormat("0.00");
				if(year>0&month>0&day>0)
				{
			  Map<String, Carchart> map=  iCarchartService.chartinfo(year, month, day);

				for(String s:map.keySet())
				{
	          count+=map.get(s).getC_count();
				}
		 for(String s:map.keySet())
		 {  double b=((double)map.get(s).getC_count()/(double)count)*100;
			 dfp.setValue(map.get(s).getC_selltime()+s+"比例:"+df.format(b)+"%", map.get(s).getC_count());  
		 }
				}
				if(year>0&month>0&day==0)
				{
					 List<Carchart> list= iCarchartService.chartinfo(year, month);
					 for(Carchart s:list){
							count+=s.getC_count();
						}
					 for(Carchart c:list)
					 {  String date[]=c.getC_selltime().split("-");
							double b=((double)c.getC_count()/(double)count)*100;
						dfp.setValue(date[2]+"日"+c.getC_brand()+"比例:"+df.format(b)+"%", c.getC_count());
					 }
				}
				if(year==0&month==0&day==0)
				{ List<Carchart> list=  iCarchartService.chartinfo();
				for(Carchart s:list){
					count+=s.getC_count();
				}
				for(Carchart s:list)
				{
					double b=((double)s.getC_count()/(double)count)*100;
					  String date[]=s.getC_selltime().split("-");
					dfp.setValue(date[0]+"年"+s.getC_brand()+"比例:"+df.format(b)+"%", s.getC_count());
				}
					
				}
				if(year>0&month==0&day==0)
				{
					Map<String, Carchart> map=  iCarchartService.chartinfo(year);
					for(String s:map.keySet())
					{
	              count+=map.get(s).getC_count();
					}
					for(String s:map.keySet())
					{
						double b=((double)map.get(s).getC_count()/(double)count)*100;
						String date[]=map.get(s).getC_selltime().split("-");
						dfp.setValue(date[1]+"月"+s+"比例:"+df.format(b)+"%",map.get(s).getC_count());
					}
				}
		 
		        // 饼状图的解决办法  
		        // createpieChart3D创建3D饼图  
		        // createpieChart创建饼图  
		        JFreeChart chart = ChartFactory.createPieChart3D("汽车销售信息",dfp, true, true, true);  
		      //比例  
		        PiePlot pieplot = (PiePlot)chart.getPlot();
		        pieplot.setLabelFont(new Font("宋体", 0, 12));
		        pieplot.setNoDataMessage("无数据");
		        pieplot.setCircular(true);
		        
		       
		      
		        chart.setBackgroundPaint(Color.red);  
		        // 设置标题文字  
		        // 取得饼图plot对象  
		        // PiePlot plot = (PiePlot) chart.getPlot();  
		        // 取得3D饼图对象  
		        PiePlot3D plot = (PiePlot3D) chart.getPlot();  
		        // 图形边框颜色  
		        plot.setBaseSectionOutlinePaint(Color.RED);  
		        // plot.setBaseSectionPaint(Color.WHITE);  
		        // 图形边框粗细  
		        plot.setBaseSectionOutlineStroke(new BasicStroke(1.0f));  
		 
		        // 指定图片的透明度(0.0-1.0)  
		        plot.setForegroundAlpha(0.65f);  
		        // 指定显示的饼图上圆形(false)还椭圆形(true)  
		        plot.setCircular(true);  
		 
		        // 设置第一个 饼块section 的开始位置，默认是12点钟方向  
		        plot.setStartAngle(360);  
		        // 设置鼠标悬停提示  
		        plot.setToolTipGenerator(new StandardPieToolTipGenerator());  
		 
		        // 设置突出显示的数据块  
		        plot.setExplodePercent("One", 0.1D);  
		        // 设置饼图各部分标签字体  
		        plot.setLabelFont(new Font("宋体", Font.ITALIC, 20));  
		        // 设置分饼颜色  
		        plot.setSectionPaint(0, new Color(244, 194, 144));  
		        // plot.setSectionPaint("2", new Color(144, 233, 144));  
		        // 设置图例说明Legend上的文字  
		        chart.getLegend().setItemFont(new Font("宋体", Font.PLAIN, 30));  
		        // 定义字体格式  
		        Font font = new java.awt.Font("黑体", java.awt.Font.CENTER_BASELINE,50); 
		        if(day>0)
		        {
		        	 TextTitle title = new TextTitle("汽车"+year+"-"+month+"-"+day+"销售情况");  
		        	  title.setFont(font);  
		        	  chart.setTitle(title); 
		        }
		        else
		        {
		        	if(year==0)
		        	{
		        		TextTitle title = new TextTitle("汽车历年销售情况");  
			        	 title.setFont(font);  
			        	  chart.setTitle(title); 
		        	}
		        	else
		        	{
		        		if(month!=0){	TextTitle title = new TextTitle("汽车"+year+"-"+month+"销售情况");  
			        	 title.setFont(font);  
			        	  title.setPaint(Color.RED);  
			        	//  title.getBackgroundPaint(); 
			        	  chart.setTitle(title); 
			        	}
			        		else{
			        			TextTitle title = new TextTitle("汽车"+year+"销售情况");  
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
			if(chartkind.equals("折线图")){
				
				DefaultCategoryDataset dat = new DefaultCategoryDataset();
				dat.clear();
				if(year>0&month>0&day>0)
				{
			  Map<String, Carchart> map=  iCarchartService.chartinfo(year, month, day);

		 for(String s:map.keySet())
		 {  dat.addValue(map.get(s).getC_count(), "时刻", map.get(s).getC_selltime()+map.get(s).getC_brand());
		 }
				}
				if(year>0&month>0&day==0)
				{
					 List<Carchart> list= iCarchartService.chartinfo(year, month);
					
					 for(Carchart c:list)
					 {  String date[]=c.getC_selltime().split("-");
					 dat.addValue(c.getC_count(), "日", date[2]+"日"+c.getC_brand());
					 }
				}
				if(year==0&month==0&day==0)
				{ List<Carchart> list=  iCarchartService.chartinfo();
				
				for(Carchart s:list)
				{
					
					  String date[]=s.getC_selltime().split("-");
						 dat.addValue(s.getC_count(), "日", date[0]+"年"+s.getC_brand());

				}
					
				}
				if(year>0&month==0&day==0)
				{
					Map<String, Carchart> map=  iCarchartService.chartinfo(year);
				
					for(String s:map.keySet())
					{
						String date[]=map.get(s).getC_selltime().split("-");
						 dat.addValue(map.get(s).getC_count(), "月", date[1]+"月"+map.get(s).getC_brand());

					}
				}
		 
				JFreeChart chart = ChartFactory.createLineChart("销售折线图", "日期", "辆数", dat, PlotOrientation.VERTICAL,true, true, true);
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
				cp.setBackgroundPaint(Color.WHITE); // 背景色设置
				cp.setRangeGridlinePaint(Color.GRAY); // 网格线色设置
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
		
	/**
	 * 获得按年月日查询数据集的方法
	 * 
	 */
	private   CategoryDataset getDataSet(){
		  DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
		  ICarchartService iCarchartService=new CarchartServiceImpl();
		  Map<String, Carchart> map= iCarchartService.chartinfo(year, month, day);
		
		  for(String s:map.keySet())
		  {
			  dataset.addValue(map.get(s).getC_count(),map.get(s).getC_selltime()+ s+map.get(s).getC_count()+"辆",year+"-"+month+"-"+day );
			  }

		 return dataset;
	    }  
	/**
	 * 获得按不同年查询数据集的方法
	 * 
	 */
	private  CategoryDataset getallDataSet(){
		  DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
		  ICarchartService iCarchartService=new CarchartServiceImpl();
		  List<Carchart> list=  iCarchartService.chartinfo();
		 
		  for(Carchart s:list)
		  {
			  String date[]=s.getC_selltime().split("-");
			  dataset.addValue(s.getC_count(), date[0]+"年"+s.getC_brand()+s.getC_count()+"辆", s.getC_selltime());
			  }

		 return dataset;
	    } 
        /**
	 * 获得按年月查询数据集的方法
	 * 
	 */
	private   CategoryDataset getymDataSet(){
		  DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
		  ICarchartService iCarchartService=new CarchartServiceImpl();
		  List<Carchart> list= iCarchartService.chartinfo(year, month);
		for(Carchart c:list)
		{
			String date[]=c.getC_selltime().split("-");
			dataset.addValue(c.getC_count(), date[2]+"日"+ c.getC_brand()+c.getC_count()+"辆", c.getC_selltime());
		}
		 return dataset;
	    }  
	/**
	 * 获得按年查询数据集的方法
	 * 
	 */
	private  CategoryDataset getyearDataSet(){
		  DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
		  ICarchartService iCarchartService=new CarchartServiceImpl();
		  Map<String, Carchart> map= iCarchartService.chartinfo(year);
		for(String s:map.keySet())
		{
			String date[]=map.get(s).getC_selltime().split("-");
			dataset.addValue(map.get(s).getC_count(), date[1]+"月"+s+map.get(s).getC_count()+"辆", map.get(s).getC_selltime());
			
		}
		 return dataset;
	    }  
  
}
