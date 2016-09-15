package cn.com.dao.impl;

import cn.com.pojo.*;
import cn.com.util.*;
import cn.com.dao.*;
import java.util.*;
import java.sql.*;
/**
 * 车型操作实现类
 * @author
 */
public class CarTypeDaoImpl extends BaseDao implements ICarTypeDao {
        /**
	 * 按热度获取车型信息的方法
	 * @return Map<Integer,CarType>
	 */
	@Override
	public Map<Integer, Cartype> getCarTypeByCount() {
		// TODO Auto-generated method stub
		Map<Integer, Cartype> carTypeMap = new HashMap<Integer, Cartype>();
		
   String hql="from Cartype order by TCount";
		try {
			List<Cartype> catplist = PageUtil.querylist(1, 6, hql, null); //获取指定行数区间的车型信息
			//遍历结果集，加入map中
			for (Cartype c : catplist) {
				carTypeMap.put(c.getTId(), c);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return carTypeMap;
	}
        /**
	 * 获取所有车型信息的方法
	 * @return  Map<Integer,CarType>
	 */
	@Override
	public Map<Integer, Cartype> getAllCarType() {
		// TODO Auto-generated method stub
		Map<Integer, Cartype> carTypeMap = new HashMap<Integer, Cartype>();
		String sql = "from Cartype where 1=1 ";

		try {   
			//获取结果集
			List<Cartype> catplist = super.getHibernateTemplate().find(
					sql);
					//遍历结果集，加入map中
			for (Cartype c : catplist) {
				carTypeMap.put(c.getTId(), c);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return carTypeMap;
	}

}
