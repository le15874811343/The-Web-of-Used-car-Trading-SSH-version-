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
public class DistanceDaoImpl extends BaseDao implements IDistanceDao, IPageDao {
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
			List<Distance> dislist = PageUtil.querylist(1, 4, hql, null); //获取指定行数区间的结果集
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
          /**
           * 添加行驶距离的方法
           * @parma distance
           * @return int
           */
	@Override
	public int addDistance(Distance distance) {
		// TODO Auto-generated method stub
		int count = 0;
		try {
			super.getHibernateTemplate().save(distance);//加入
			count = 1;
		} catch (Exception e) {
			// TODO: handle exception
			count = 0;
			e.printStackTrace();
		}
		return count;
	}
          /**
           * 删除行驶距离的方法
           * @parma distance
           * @return int
           */
	@Override
	public int deleteDistance(Distance distance) {
		// TODO Auto-generated method stub
		int count = 0;
		try {
			super.getHibernateTemplate().delete(distance);//删除
			count = 1;
		} catch (Exception e) {
			// TODO: handle exception
			count = 0;
			e.printStackTrace();
		}
		return count;
	}
          /**
           * 修改行驶距离的方法
           * @parma distance
           * @return int
           */
	@Override
	public int updateDistance(Distance distance) {
		// TODO Auto-generated method stub
		String sql = "update Distance set DName=?,DCount=? where DId=?";
		//返回受影响的行数
		return super.getHibernateTemplate().bulkUpdate(
				sql,
				new Object[] { distance.getDName(), distance.getDCount(),
						distance.getDId() });
	}
   /**
    * 
    * 按编号获取行驶距离信息的方法
    *@return Distance
    */
	@Override
	public Distance getDistanceById(Distance distance) {
		// TODO Auto-generated method stub
		String sql = "from Distance where DId=?";
		Distance _Distance = null;
		try {
			List<Distance> disList = super.getHibernateTemplate().find(sql,
					distance.getDId());//获取结果集
			if (disList.size() > 0) {
				_Distance = disList.get(0); //获取结果
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
    /**
     * 获取行驶距离信息的记录总条数
     * @return Long
     */	
	@Override
	public Long queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
		Long count = null;

		StringBuffer sql = new StringBuffer(
				"select count(*) from Distance where 1=1");

		try {
			count = (Long) super.getHibernateTemplate().find(sql.toString())
					.iterator().next();//获取结果

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			count = (long) 0;
		}
		return count;
	}
/**
 * 分页获取行驶距离信息
 * @param curPage 当前页数
 * @param rowsPrePage
 * @return Map<Long,Object>
 */	
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		Map<Long, Object> brandMap = new HashMap<Long, Object>();
		String hql = "from Distance  a  where 1=1 order by DCount desc ";
		List<Distance> disList = PageUtil.querylist(curPage, rowsPrePage, hql,
				null);//获取指定行数区间的结果集
		//遍历结果集，加入Map中
		for (Distance d : disList) {
			brandMap.put((long) d.getDId(), d);
		}
		return brandMap;
	}

}
