package cn.com.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import cn.com.pojo.Price;
import cn.com.dao.IPriceDao;
import cn.com.util.DbUtil;

public class PriceDaoImpl implements IPriceDao {

	@Override
	public List<Price>  getsellinfo(int year, int month, int day) {
		// TODO Auto-generated method stub
		List<Price> map=new ArrayList<Price>();
		StringBuffer stringBuffer=new StringBuffer("select sum(c_price) sum,to_char(c_mcsj,'HH24:mi:ss') time  from carinfo where to_char(c_mcsj,'YYYY-MM-DD')='");
		if(month>9)
		{
			stringBuffer.append(""+year+"-"+month);
		}
		else
		{
			stringBuffer.append(""+year+"-0"+month);
		}
		if(day>9)
		{
			stringBuffer.append("-"+day+"' group by to_char(c_mcsj,'HH24:mi:ss')");
		}
		else
		{
			stringBuffer.append("-0"+day+"' group by to_char(c_mcsj,'HH24:mi:ss')");
		}
		
		ResultSet res=DbUtil.executeQuery(stringBuffer.toString(), null);
		try {
			while (res.next())
			{
	         Price price=new Price();
	         price.setC_selltime(res.getString("time"));
	         price.setC_sum(res.getDouble("sum"));
	   map.add(price);
	
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public List<Price> getsellinfo(int year, int month) {
		// TODO Auto-generated method stub
		List<Price> list=new ArrayList<Price>();
		StringBuffer stringBuffer=new StringBuffer("select sum(c_price) sum,to_char(c_mcsj,'yyyy-mm-dd') time from carinfo where to_char(c_mcsj,'YYYY-MM')='"+year);
		if(month>9)
		{
			stringBuffer.append("-"+month);
		}
		else
		{
			stringBuffer.append("-0"+month);
		}
		stringBuffer.append("' group by to_char(c_mcsj,'yyyy-mm-dd') order by to_char(c_mcsj,'yyyy-mm-dd')");
		ResultSet res=DbUtil.executeQuery(stringBuffer.toString(), null);
		
	try {
		while(res.next())
		{
			Price price=new Price();
			price.setC_sum(res.getDouble("sum"));
			price.setC_selltime(res.getString("time"));
			list.add(price);
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return list;
	}

	@Override
	public List<Price> getsellinfo(int year) {
		// TODO Auto-generated method stub
		List<Price> map=new ArrayList<Price>();
		String sql="select sum(c_price) sum,to_char(c_mcsj,'YYYY-mm') time from carinfo where to_char(c_mcsj,'YYYY')='"+year+"' group by to_char(c_mcsj,'YYYY-mm') order by time";
		ResultSet res=DbUtil.executeQuery(sql, null);
		try {
			while(res.next())
			{
				   Price price=new Price();
			         price.setC_selltime(res.getString("time"));
			         price.setC_sum(res.getDouble("sum"));
			   map.add(price);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public List<Price> getsellinfo() {
		// TODO Auto-generated method stub
		List<Price> list=new ArrayList<Price>();
		String sql="select sum(c_price) sum,to_char(c_mcsj,'YYYY') a from carinfo where to_char(c_mcsj,'YYYY')>0 group by to_char(c_mcsj,'YYYY') order by a";
		ResultSet res=DbUtil.executeQuery(sql, null);
		try {
			while(res.next())
			{Price price=new Price();
			price.setC_sum(res.getDouble("sum"));
			price.setC_selltime(res.getString("a"));
			list.add(price);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
