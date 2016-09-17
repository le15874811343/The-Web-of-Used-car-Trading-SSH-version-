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
public class CarTypeDaoImpl extends BaseDao implements ICarTypeDao,IPageDao {
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
/**
 * 添加车型的方法
 * @return int
 */
	@Override
	public int addCarType(Cartype carType) {
		// TODO Auto-generated method stub
		int count=0;
		try{
			super.getHibernateTemplate().save(carType); //加入
			count=1;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return count;
	}
/**
 * 删除车型的方法
 * @return int
 */
	@Override
	public int deleteCarType(Cartype carType) {
		// TODO Auto-generated method stub
		int count=0;
		try{
			super.getHibernateTemplate().delete(carType); //删除
			count=1;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return count;
	}
/**
 * 修改车型的方法
 * @return int
 */
	@Override
	public int updateType(Cartype carType) {
		// TODO Auto-generated method stub
		String sql="update Cartype set TName=?,TCount=?,TClass=? where TId=?";
		//返回受影响的行数
		return super.getHibernateTemplate().bulkUpdate(sql, new Object[]{carType.getTName(),carType.getTCount(),carType.getTClass(),carType.getTId()});
	}
/**
 * 获取车型的方法
 * @return CarType
 */
	@Override
	public Cartype getCarType(Cartype carType) {
		// TODO Auto-generated method stub
		Cartype _CarType=null;
		String sql=" from Cartype where TId=? ";
		try{
	List<Cartype> carTypeList=		super.getHibernateTemplate().find(sql,carType.getTId());//获取结果集
	  if(carTypeList.size()>0){
		  
		  _CarType=carTypeList.get(0); //获取结果
	  }
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return _CarType;
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
     * 获取车型信息的记录总条数
     * @return int
     */	
	@Override
	public Long queryPersonCarCount(Object object) {
		// TODO Auto-generated method stub
Long count=null;
		
		
		StringBuffer sql=new StringBuffer("select count(*) from Cartype where 1=1");
		
	
	try {
	count=	 (Long) super.getHibernateTemplate().find(sql.toString()).iterator().next();//获取结果
	} catch (Exception e) {
		// TODO Auto-generated catch block
		count=(long) 0;
		e.printStackTrace();
	}
		return count;
	}
/**
 * 分页获取车型信息
 * @param curPage 当前页数
 * @param rowsPrePage
 * @return Map<Long,Object>
 */	
	@Override
	public Map<Long, Object> showPersonCarList(int curPage, int rowsPrePage,
			Object object) {
		// TODO Auto-generated method stub
		String hql="from Cartype  a  where 1=1  order by TCount desc";
		Map<Long, Object> carTypeMap=new HashMap<Long, Object>();
	List<Cartype> carTypeList=	PageUtil.querylist(curPage, rowsPrePage, hql, null);//获取指定行数区间的结果集
	//遍历结果集，加入map中
	for(Cartype c:carTypeList){
		carTypeMap.put((long) c.getTId(), c);
	}
		return carTypeMap;
	}

}
