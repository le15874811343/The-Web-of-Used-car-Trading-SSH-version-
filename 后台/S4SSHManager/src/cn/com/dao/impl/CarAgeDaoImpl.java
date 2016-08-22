package cn.com.dao.impl;
import cn.com.pojo.*;
import cn.com.util.*;

import cn.com.dao.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class CarAgeDaoImpl extends BaseDao implements ICarAgeDao,IPageDao{
  
	@Override
	public Map<Integer, Carage> getCarAgeByCount() {
		// TODO Auto-generated method stub
		Map<Integer, Carage> carAgeMap=new HashMap<Integer, Carage>();
	
	 String hql="from Carage  order by ACount desc";
	List<Carage> caglist= PageUtil.querylist(1, 5, hql, null);
	for(Carage c:caglist){
		carAgeMap.put(c.getAId(), c);
	}
	
		return carAgeMap;
	}

	@Override
	public int addCarAge(Carage carAge) {
		// TODO Auto-generated method stub
		int count=0;
		try{
			 super.getHibernateTemplate().save(carAge);
			 count=1;
		}
		catch (Exception e) {
			// TODO: handle exception
		e.printStackTrace();
		}
		return count;
	}

	@Override
	public int deleteCarAge(Carage carAge) {
		// TODO Auto-generated method stub
		int count=0;
		try{
			super.getHibernateTemplate().delete(carAge);
			count=1;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int updateCarAge(Carage carAge) {
		// TODO Auto-generated method stub
		String sql="update Carage set AName=?,ACount=? where AId=?";
		
		return super.getHibernateTemplate().bulkUpdate(sql.toString(), new Object[]{carAge.getAName(),carAge.getACount(),carAge.getAId()});
	}

	@Override
	public Carage getCarAgeById(Carage carAge) {
		// TODO Auto-generated method stub
		String sql=" from Carage where AId=?";
		Carage _Carage=null;
		try{
	List<Carage> clist=		super.getHibernateTemplate().find(sql, carAge.getAId());
	if(clist.size()>0){
		_Carage=clist.get(0);
	}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return _Carage;
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
		
		
		StringBuffer sql=new StringBuffer("select count(*) from Carage where 1=1");
		try{
	count=   (Long) super.getHibernateTemplate().find(sql.toString()).iterator().next();
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		 StringBuffer sql=new StringBuffer("from Carage  a  where 1=1 order by ACount desc");
		 Map<Long, Object> brandMap=new HashMap<Long, Object>();
		List<Carage> agel=	PageUtil.querylist(curPage, rowsPrePage, sql.toString(), null);
		for(Carage c:agel){
			brandMap.put((long) c.getAId(), c);
		}
			return brandMap;
	}

}
