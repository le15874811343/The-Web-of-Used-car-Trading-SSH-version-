package cn.com.dao.impl;
import cn.com.pojo.*;
import cn.com.util.*;
import cn.com.dao.*;
import java.util.*;

public class CarBrandDaoImpl extends BaseDao implements ICarBrandDao,IPageDao {

	@Override
	public Map<Integer, Carbrand> getCarBrandByCount() {
		// TODO Auto-generated method stub
	   Map<Integer, Carbrand> carBrandMap=new HashMap<Integer, Carbrand>();
	
	   String hql="from Carbrand order by BCount desc";
	 try{
	List<Carbrand> cablist=  PageUtil.querylist(1, 7, hql, null);
	for(Carbrand c:cablist){
		carBrandMap.put(c.getBId(), c);
	}
	 }
	 catch (Exception e) {
		// TODO: handle exception
		 e.printStackTrace();
	}
	  return carBrandMap;
	}

	@Override
	public Map<Integer, Carbrand> getAllBrand() {
		// TODO Auto-generated method stub
		 Map<Integer, Carbrand> carBrandMap=new HashMap<Integer, Carbrand>();
		   String sql= " from Carbrand";
		   try{
				List<Carbrand> cablist=  super.getHibernateTemplate().find(sql);
				for(Carbrand c:cablist){
					carBrandMap.put(c.getBId(), c);
				}
				 }
				 catch (Exception e) {
					// TODO: handle exception
					 e.printStackTrace();
				}
		  return carBrandMap;
	}

	@Override
	public Carbrand getBrandByID(Carbrand carBrand) {
		// TODO Auto-generated method stub
		Carbrand _carBrand=null;
		   String sql= " from Carbrand where BId=? ";
		try{
		_carBrand=  (Carbrand) super.getHibernateTemplate().find(sql.toString(), new Object[]{carBrand.getBId()}).get(0);
		}
		catch (Exception e) {
			
			// TODO: handle exception
		e.printStackTrace();
		}
		  return _carBrand;
	}

	@Override
	public int addCarBrand(Carbrand carBrand) {
		// TODO Auto-generated method stub
		int count=0;
		try{
			super.getHibernateTemplate().save(carBrand);
			count=1;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public int updateCarBrand(Carbrand carBrand) {
		// TODO Auto-generated method stub
		String sql="update Carbrand set BName=?,BCount=?,BImg=?,BSzm=? where BId=?";
		return super.getHibernateTemplate().bulkUpdate(sql, new Object[]{carBrand.getBName(),carBrand.getBCount(),carBrand.getBImg(),carBrand.getBSzm(),carBrand.getBId()});
	}

	@Override
	public int deleteCarBrand(Carbrand carBrand) {
		// TODO Auto-generated method stub
		int count=0;
		try{
			super.getHibernateTemplate().delete(carBrand);
			count=1;
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return count;
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
		StringBuffer sql=new StringBuffer("select count(*) from Carbrand where 1=1");
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
		String hql="from Carbrand  a  where 1=1 order by BCount desc";
		Map<Long, Object> carBrandMap=new HashMap<Long, Object>();
	List<Carbrand> carBrandlist=	PageUtil.querylist(curPage, rowsPrePage, hql, null);
	for(Carbrand c:carBrandlist){
		carBrandMap.put((long) c.getBId(), c);
	}
		return carBrandMap;
	}

	@Override
	public Carbrand getBrandByName(Carbrand carBrand) {
		// TODO Auto-generated method stub
		Carbrand _carBrand=null;
		   String sql= " from Carbrand where BName=? ";
		try{
		_carBrand=  (Carbrand) super.getHibernateTemplate().find(sql.toString(), new Object[]{carBrand.getBName()}).get(0);
		}
		catch (Exception e) {
			
			// TODO: handle exception
		e.printStackTrace();
		}
		  return _carBrand;
	}
 
}
