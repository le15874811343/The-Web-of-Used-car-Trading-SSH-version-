package cn.com.dao.impl;

import java.sql.*;
import java.util.*;
import cn.com.pojo.*;
import cn.com.dao.*;
import cn.com.util.*;
/**
 * 价格区间操作实现类
 * @author lej
 */
public class PriceIntervalDaoImpl extends BaseDao implements IPriceIntervalDao{
  /**
   * 
   * 按热度获取价格区间信息的方法
   * @return Map<Integer,PriceInterval>
   */
	@Override
	public Map<Integer, Priceinterval> getPriceIntervalByCount() {
		// TODO Auto-generated method stub
		Map<Integer, Priceinterval> priceIntervalMap=new HashMap<Integer, Priceinterval>();
	
	      String hql="from Priceinterval  order by PCount desc";
	try {
	List<Priceinterval> plist=	PageUtil.querylist(1, 4, hql, null);//获取指定行数区间的结果集
	//遍历结果集，加入map中
	for(Priceinterval p:plist){
		priceIntervalMap.put(p.getPId(), p);
	}
	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return priceIntervalMap;
	}

}
