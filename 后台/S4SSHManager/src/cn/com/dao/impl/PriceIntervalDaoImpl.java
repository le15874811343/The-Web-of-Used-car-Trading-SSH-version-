package cn.com.dao.impl;

import java.sql.*;
import java.util.*;

import cn.com.pojo.*;

import cn.com.dao.*;
import cn.com.util.*;

public class PriceIntervalDaoImpl extends BaseDao implements IPriceIntervalDao ,IPageDao{

	@Override
	public Map<Integer, Priceinterval> getPriceIntervalByCount() {
		// TODO Auto-generated method stub
		Map<Integer, Priceinterval> priceIntervalMap=new HashMap<Integer, Priceinterval>();
	
	      String hql="from Priceinterval  order by PCount desc";
	try {
	List<Priceinterval> plist=	PageUtil.querylist(1, 4, hql, null);
	for(Priceinterval p:plist){
		priceIntervalMap.put(p.getPId(), p);
	}
	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return priceIntervalMap;
	}

	@Override
	public int addPriceInterval(Priceinterval priceInterval) {
		// TODO Auto-generated method stub
		int count = 0;
		try {
			super.getHibernateTemplate().save(priceInterval);
			count = 1;
		} catch (Exception e) {
			// TODO: handle exception
			count = 0;
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int deletePriceInterval(Priceinterval priceInterval) {
		// TODO Auto-generated method stub
		int count = 0;
		try {
			super.getHibernateTemplate().delete(priceInterval);
			count = 1;
		} catch (Exception e) {
			// TODO: handle exception
			count = 0;
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int updatePriceInterval(Priceinterval priceInterval) {
		// TODO Auto-generated method stub
		String sql="update Priceinterval set PName=?,PCount=? where PId=?";
		return super.getHibernateTemplate().bulkUpdate(sql, new Object[]{priceInterval.getPName(),priceInterval.getPCount(),priceInterval.getPId()});
	}

	@Override
	public Priceinterval getPriceIntervalById(Priceinterval priceInterval) {
		// TODO Auto-generated method stub
		 Priceinterval	_priceInterval=null;
			String sql="from Priceinterval where PId=?";
	
			
		    try {
				List<Priceinterval> pri=super.getHibernateTemplate().find(sql, priceInterval.getPId());
				if(pri.size()>0){
					_priceInterval=pri.get(0);
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return _priceInterval ;
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
		Long count=null;
		try{
		StringBuffer sql=new StringBuffer("select count(*) from Priceinterval where 1=1");
	count=	(Long) super.getHibernateTemplate().find(sql.toString()).iterator().next();
		}
		catch (Exception e) {
			// TODO: handle exception
			count=(long) 0;
		}
		return count;
	}

	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		String hql="from Priceinterval  a  where 1=1 order by PCount desc";
		Map<Long, Object> carBrandMap=new HashMap<Long, Object>();
	List<Priceinterval> carBrandlist=	PageUtil.querylist(curPage, rowsPrePage, hql, null);
	for(Priceinterval c:carBrandlist){
		carBrandMap.put((long) c.getPId(), c);
	}
		return carBrandMap;
	}

}
