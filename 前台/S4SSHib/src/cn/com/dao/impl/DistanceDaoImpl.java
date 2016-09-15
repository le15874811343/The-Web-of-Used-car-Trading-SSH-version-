package cn.com.dao.impl;

import java.sql.*;
import java.util.*;
import cn.com.pojo.*;
import cn.com.dao.*;
import cn.com.util.*;
/**
 * 行驶距离操作实现类
 *@author lej 
 */
public class DistanceDaoImpl extends BaseDao implements IDistanceDao {
   /**
    * 
    * 按热度获取行驶距离信息的方法
    *@return Map<Integer,Distance> 
    */
	@Override
	public Map<Integer, Distance> getDistanceByCount() {
		// TODO Auto-generated method stub
		Map<Integer, Distance> distanceMap = new HashMap<Integer, Distance>();

		String hql = "from Distance order by DCount desc";

		try {
			List<Distance> dislist = PageUtil.querylist(1, 4, hql, null);//获取指定行数区间的结果集
			;
			//遍历结果集，加入map中
			for (Distance d : dislist) {
				distanceMap.put(d.getDId(), d);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return distanceMap;
	}

}
