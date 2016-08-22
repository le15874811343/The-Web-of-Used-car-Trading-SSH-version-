package cn.com.dao.impl;

import java.sql.*;
import java.util.*;
import cn.com.pojo.*;
import cn.com.dao.*;
import cn.com.util.*;

public class DistanceDaoImpl extends BaseDao implements IDistanceDao {

	@Override
	public Map<Integer, Distance> getDistanceByCount() {
		// TODO Auto-generated method stub
		Map<Integer, Distance> distanceMap = new HashMap<Integer, Distance>();

		String hql = "from Distance order by DCount desc";

		try {
			List<Distance> dislist = PageUtil.querylist(1, 4, hql, null);
			;
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
