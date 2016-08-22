package cn.com.dao.impl;
import java.sql.*;
import java.util.*;

import cn.com.pojo.*;

import cn.com.dao.*;
import cn.com.util.*;
public class EmissionstandardDaoImpl extends BaseDao implements IEmissionstandardDao ,IPageDao{

	@Override
	public Map<Integer, Emissionstandard> getEmissionstandardByCount() {
		// TODO Auto-generated method stub
		Map<Integer, Emissionstandard> emissionstandardMap=new HashMap<Integer, Emissionstandard>();
		
           String hql="from  Emissionstandard  order by ECount desc";
	try {
		List<Emissionstandard> dislist=	PageUtil.querylist(1, 5, hql, null);
		for(Emissionstandard d: dislist){
			emissionstandardMap.put(d.getEId(), d);
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emissionstandardMap;
	}

	@Override
	public int addEmissionstandard(Emissionstandard emissionstandard) {
		// TODO Auto-generated method stub
		int count = 0;
		try {
			super.getHibernateTemplate().save(emissionstandard);
			count = 1;
		} catch (Exception e) {
			// TODO: handle exception
			count = 0;
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int deleteEmissionstandard(Emissionstandard emissionstandard) {
		// TODO Auto-generated method stub
		int count = 0;
		try {
			super.getHibernateTemplate().delete(emissionstandard);
			count = 1;
		} catch (Exception e) {
			// TODO: handle exception
			count = 0;
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int updateEmissionstandard(Emissionstandard emissionstandard) {
		// TODO Auto-generated method stub
		String sql="update Emissionstandard set EName=?,ECount=? where EId=? ";
		return super.getHibernateTemplate().bulkUpdate(sql, new Object[]{emissionstandard.getEName(),emissionstandard.getECount(),emissionstandard.getEId()});
	}

	@Override
	public Emissionstandard getEmissionstandard(
			Emissionstandard emissionstandard) {
		// TODO Auto-generated method stub
		Emissionstandard _Emissionstandard=null;
		String sql="from Emissionstandard where EId=? ";
		try{
	List<Emissionstandard> emis=		super.getHibernateTemplate().find(sql,emissionstandard.getEId());
	if(emis.size()>0){
		_Emissionstandard=emis.get(0);
	}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 		_Emissionstandard;
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
		
		
		StringBuffer sql=new StringBuffer("select count(*) from Emissionstandard where 1=1");
		
	
	try {
	       count=(Long) super.getHibernateTemplate().find(sql.toString()).iterator().next();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		count=(long) 0;
	}
		return count;
	}

	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		StringBuffer sql=new StringBuffer("from Emissionstandard  a  where 1=1 order by ECount desc");
		 Map<Long, Object> brandMap=new HashMap<Long, Object>();
	 List<Emissionstandard> emis=		PageUtil.querylist(curPage, rowsPrePage, sql.toString(), null);
	 for(Emissionstandard e:emis){
		 brandMap.put((long) e.getEId(), e);
	 }
		return brandMap;
	}

}
