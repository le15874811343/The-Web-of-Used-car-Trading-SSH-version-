package cn.com.dao.impl;

import cn.com.pojo.*;
import cn.com.util.*;
import cn.com.dao.*;
import java.util.*;
import java.sql.*;

public class CarTypeDaoImpl extends BaseDao implements ICarTypeDao {

	@Override
	public Map<Integer, Cartype> getCarTypeByCount() {
		// TODO Auto-generated method stub
		Map<Integer, Cartype> carTypeMap = new HashMap<Integer, Cartype>();
		
   String hql="from Cartype order by TCount";
		try {
			List<Cartype> catplist = PageUtil.querylist(1, 6, hql, null);
			for (Cartype c : catplist) {
				carTypeMap.put(c.getTId(), c);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return carTypeMap;
	}

	@Override
	public Map<Integer, Cartype> getAllCarType() {
		// TODO Auto-generated method stub
		Map<Integer, Cartype> carTypeMap = new HashMap<Integer, Cartype>();
		String sql = "from Cartype where 1=1 ";

		try {
			List<Cartype> catplist = super.getHibernateTemplate().find(
					sql);
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
