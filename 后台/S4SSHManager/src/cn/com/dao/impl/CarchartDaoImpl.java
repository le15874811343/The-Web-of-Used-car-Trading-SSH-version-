package cn.com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.com.pojo.Carchart;
import cn.com.dao.ICarchartDao;
import cn.com.util.DbUtil;
/**
 * 品牌销量操作实现类
 * 
 */
public class CarchartDaoImpl implements ICarchartDao {
 /**
   * 按年月查询的方法
   * @return  List<Carchart>
   */
	@Override
	public List<Carchart> chartinfo(int year,int month) {
		// TODO Auto-generated method stub
		List<Carchart> list=new ArrayList<Carchart>();
		StringBuffer stringBuffer=new StringBuffer("select c_brand,count(*) brand,to_char(c_mcsj,'YYYY-MM-DD') time from carinfo where to_char(c_mcsj,'YYYY-MM')='"+year);
		//月份数字形式处理
		if(month>9)
		{
			stringBuffer.append("-"+month);
		}
		else
		{
			stringBuffer.append("-0"+month);
		}
		stringBuffer.append("' group by c_brand,to_char(c_mcsj,'YYYY-MM-DD') order by to_char(c_mcsj,'YYYY-MM-DD')");
		//获取结果集
		ResultSet res=DbUtil.executeQuery(stringBuffer.toString(), null);
		
	try {
		while(res.next())
		{
			Carchart carchart=new Carchart();
			carchart.setC_brand(res.getString("c_brand"));
			carchart.setC_count(res.getInt("brand"));
			carchart.setC_selltime(res.getString("time"));
			list.add(carchart);
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return list;
	}
/**
 * 查询不同年的方法
 *  @return List<Carchart>
 */
	@Override
	public List<Carchart> chartinfo() {
		// TODO Auto-generated method stub
		List<Carchart> list=new ArrayList<Carchart>();
		String sql="select c_brand,count(*) count,to_char(c_mcsj,'YYYY') time from carinfo  where to_char(c_mcsj,'YYYY')>0 group by c_brand,to_char(c_mcsj,'YYYY') order by to_char(c_mcsj,'YYYY')";
		//获取结果集
		ResultSet res=DbUtil.executeQuery(sql, null);
		
	try {
		while (res.next())
		{Carchart carchart=new Carchart();
		carchart.setC_brand(res.getString("c_brand"));
		carchart.setC_count(res.getInt("count"));
		carchart.setC_selltime(res.getString("time"));
		list.add(carchart);
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return list;
	}
/**
 * 按年月日查询的方法
 * @return  Map<String, Carchart>
 */
	@Override
	public Map<String, Carchart> chartinfo(int year, int month, int day) {
		// TODO Auto-generated method stub
		Map<String, Carchart> map=new HashMap<String, Carchart>();
		StringBuffer stringBuffer=new StringBuffer("select c_brand,count(*) count ,to_char(c_mcsj,'HH24:mi:ss') time from carinfo where to_char(c_mcsj,'YYYY-MM-DD')='");
		//月份数字形式处理
		if(month>9)
		{
			stringBuffer.append(""+year+"-"+month);
		}
		else
		{
			stringBuffer.append(""+year+"-0"+month);
		}
		//日期数字形式处理
		if(day>9)
		{
			stringBuffer.append("-"+day+"' group by c_brand,to_char(c_mcsj,'HH24:mi:ss')");
		}
		else
		{
			stringBuffer.append("-0"+day+"' group by c_brand,to_char(c_mcsj,'HH24:mi:ss')");
		}
		//获取结果集
		ResultSet res=DbUtil.executeQuery(stringBuffer.toString(), null);
		try {
			while (res.next())
			{
	
				Carchart carchart=new Carchart();
				carchart.setC_brand(res.getString("c_brand"));
				carchart.setC_count(res.getInt("count"));
				carchart.setC_selltime(res.getString("time"));
				
				map.put(res.getString("c_brand"), carchart);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
/**
 * 按年查询的方法
 *  @return  Map<String, Carchart>
 */
	@Override
	public Map<String, Carchart> chartinfo(int year) {
		// TODO Auto-generated method stub
		
		Map<String, Carchart> map=new HashMap<String, Carchart>();
		String sql="select c_brand,count(*) count ,to_char(c_mcsj,'YYYY-mm') time from carinfo where to_char(c_mcsj,'YYYY')=? group by c_brand,to_char(c_mcsj,'YYYY-mm')";
		//参数绑定
		List<Object> params=new ArrayList<Object>();
		params.add(year);
		//获取结果集
		ResultSet res=DbUtil.executeQuery(sql, params);
		try {
			while(res.next())
			{

				Carchart carchart=new Carchart();
				carchart.setC_brand(res.getString("c_brand"));
				carchart.setC_count(res.getInt("count"));
				carchart.setC_selltime(res.getString("time"));
				map.put(res.getString("c_brand"), carchart);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return map;
	}

}
