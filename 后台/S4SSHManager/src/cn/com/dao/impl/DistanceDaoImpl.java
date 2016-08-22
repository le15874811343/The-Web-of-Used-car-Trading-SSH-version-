package cn.com.dao.impl;

import java.sql.*;
import java.util.*;

import cn.com.pojo.*;
import cn.com.dao.*;
import cn.com.util.*;

public class DistanceDaoImpl extends BaseDao implements IDistanceDao, IPageDao {

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

	@Override
	public int addDistance(Distance distance) {
		// TODO Auto-generated method stub
		int count = 0;
		try {
			super.getHibernateTemplate().save(distance);
			count = 1;
		} catch (Exception e) {
			// TODO: handle exception
			count = 0;
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int deleteDistance(Distance distance) {
		// TODO Auto-generated method stub
		int count = 0;
		try {
			super.getHibernateTemplate().delete(distance);
			count = 1;
		} catch (Exception e) {
			// TODO: handle exception
			count = 0;
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int updateDistance(Distance distance) {
		// TODO Auto-generated method stub
		String sql = "update Distance set DName=?,DCount=? where DId=?";
		return super.getHibernateTemplate().bulkUpdate(
				sql,
				new Object[] { distance.getDName(), distance.getDCount(),
						distance.getDId() });
	}

	@Override
	public Distance getDistanceById(Distance distance) {
		// TODO Auto-generated method stub
		String sql = "from Distance where DId=?";
		Distance _Distance = null;
		try {
			List<Distance> disList = super.getHibernateTemplate().find(sql,
					distance.getDId());
			if (disList.size() > 0) {
				_Distance = disList.get(0);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return _Distance;
	}

	@Override
	public Long queryMsgCount(Object object, int minPrice, int maxPrice,
			int minDis, int maxDis, int minAge, int maxAge) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Object> showMsgInfoList(int curPage, int rowsPrePage,
			Object object, String order, int minPrice, int maxPrice,
			int minDis, int maxDis, int minAge, int maxAge) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Long queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		Long count = null;

		StringBuffer sql = new StringBuffer(
				"select count(*) from Distance where 1=1");

		try {
			count = (Long) super.getHibernateTemplate().find(sql.toString())
					.iterator().next();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			count = (long) 0;
		}
		return count;
	}

	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		Map<Long, Object> brandMap = new HashMap<Long, Object>();
		String hql = "from Distance  a  where 1=1 order by DCount desc ";
		List<Distance> disList = PageUtil.querylist(curPage, rowsPrePage, hql,
				null);
		for (Distance d : disList) {
			brandMap.put((long) d.getDId(), d);
		}
		return brandMap;
	}

}
