package cn.com.dao.impl;
import cn.com.pojo.*;
import cn.com.util.*;
import cn.com.dao.*;
import java.util.*;

public class CarBrandDaoImpl extends BaseDao implements ICarBrandDao {

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
