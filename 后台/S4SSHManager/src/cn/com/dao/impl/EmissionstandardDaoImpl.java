package cn.com.dao.impl;
import java.sql.*;
import java.util.*;

import cn.com.pojo.*;

import cn.com.dao.*;
import cn.com.util.*;
/**
 * 
 * 排放标准操作实现类
 *@author  lej
 */
public class EmissionstandardDaoImpl extends BaseDao implements IEmissionstandardDao ,IPageDao{
        /**
	 * 按热度获取排放标准信息的方法
	 * @Map<Integer,Emissionstandard>
	 */
	@Override
	public Map<Integer, Emissionstandard> getEmissionstandardByCount() {
		// TODO Auto-generated method stub
		Map<Integer, Emissionstandard> emissionstandardMap=new HashMap<Integer, Emissionstandard>();
		
           String hql="from  Emissionstandard  order by ECount desc";
	try {
		List<Emissionstandard> dislist=	PageUtil.querylist(1, 5, hql, null);  //获取指定行数区间的结果集
		//遍历结果集，加入map中
		for(Emissionstandard d: dislist){
			emissionstandardMap.put(d.getEId(), d);
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emissionstandardMap;
	}
          /**
           * 添加排放标准信息的方法
           * @parma emissionstandard
           * @return int
           */
	@Override
	public int addEmissionstandard(Emissionstandard emissionstandard) {
		// TODO Auto-generated method stub
		int count = 0;
		try {
			super.getHibernateTemplate().save(emissionstandard);//加入
			count = 1;
		} catch (Exception e) {
			// TODO: handle exception
			count = 0;
			e.printStackTrace();
		}
		return count;
	}
          /**
           * 删除排放标准信息的方法
           * @parma emissionstandard
           * @return int
           */
	@Override
	public int deleteEmissionstandard(Emissionstandard emissionstandard) {
		// TODO Auto-generated method stub
		int count = 0;
		try {
			super.getHibernateTemplate().delete(emissionstandard);//删除
			count = 1;
		} catch (Exception e) {
			// TODO: handle exception
			count = 0;
			e.printStackTrace();
		}
		return count;
	}
          /**
           * 修改排放标准信息的方法
           * @parma emissionstandard
           * @return int
           */
	@Override
	public int updateEmissionstandard(Emissionstandard emissionstandard) {
		// TODO Auto-generated method stub
		String sql="update Emissionstandard set EName=?,ECount=? where EId=? ";
		//返回受影响的行数
		return super.getHibernateTemplate().bulkUpdate(sql, new Object[]{emissionstandard.getEName(),emissionstandard.getECount(),emissionstandard.getEId()});
	}
        /**
	 * 获取排放标准信息的方法
	 * @return Emissionstandard
	 */
	@Override
	public Emissionstandard getEmissionstandard(
			Emissionstandard emissionstandard) {
		// TODO Auto-generated method stub
		Emissionstandard _Emissionstandard=null;
		String sql="from Emissionstandard where EId=? ";
		try{
	List<Emissionstandard> emis=		super.getHibernateTemplate().find(sql,emissionstandard.getEId());//获取结果集
	if(emis.size()>0){
		_Emissionstandard=emis.get(0);//获取结果
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
    /**
     * 获取排放标准信息的记录总条数
     * @return int
     */	
	@Override
	public Long queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
Long count=null;
		
		
		StringBuffer sql=new StringBuffer("select count(*) from Emissionstandard where 1=1");
		
	
	try {
	       count=(Long) super.getHibernateTemplate().find(sql.toString()).iterator().next();//获取结果
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		count=(long) 0;
	}
		return count;
	}
/**
 * 分页获取排放标准信息
 * @param curPage 当前页数
 * @param rowsPrePage
 * @return Map<Long,Object>
 */	
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		StringBuffer sql=new StringBuffer("from Emissionstandard  a  where 1=1 order by ECount desc");
		 Map<Long, Object> brandMap=new HashMap<Long, Object>();
		 //获取指定行数区间的结果集
	 List<Emissionstandard> emis=		PageUtil.querylist(curPage, rowsPrePage, sql.toString(), null);
	 //遍历结果集，加入map中
	 for(Emissionstandard e:emis){
		 brandMap.put((long) e.getEId(), e);
	 }
		return brandMap;
	}

}
