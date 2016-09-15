package cn.com.dao.impl;
import cn.com.pojo.*;
import cn.com.util.*;
import cn.com.dao.*;
import java.util.*;
/**
 * 品牌信息操作实现类
 * @author lej
 */
public class CarBrandDaoImpl extends BaseDao implements ICarBrandDao {
  /**
   * 按热度获取品牌信息的方法
   * @return  Map<Integer, Carbrand>
   */
	@Override
	public Map<Integer, Carbrand> getCarBrandByCount() {
		// TODO Auto-generated method stub
	   Map<Integer, Carbrand> carBrandMap=new HashMap<Integer, Carbrand>();
	
	   String hql="from Carbrand order by BCount desc";
	 try{
	List<Carbrand> cablist=  PageUtil.querylist(1, 7, hql, null); //获取结果集
	//遍历结果集 将结果加入map中
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
  /**
   * 获取所有品牌信息的方法
   * @return Map<Integer,Carbrand>
   */
	@Override
	public Map<Integer, Carbrand> getAllBrand() {
		// TODO Auto-generated method stub
		 Map<Integer, Carbrand> carBrandMap=new HashMap<Integer, Carbrand>();
		   String sql= " from Carbrand";
		   try{  
				List<Carbrand> cablist=  super.getHibernateTemplate().find(sql); //获取结果集
				//遍历结果集 将结果加入map中
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
  /**
   * 根据品牌编号获取品牌信息的方法
   * @param carBrand
   * @return Carbrand
   */
	@Override
	public Carbrand getBrandByID(Carbrand carBrand) {
		// TODO Auto-generated method stub
		Carbrand _carBrand=null;
		   String sql= " from Carbrand where BId=? ";
		try{
		_carBrand=  (Carbrand) super.getHibernateTemplate().find(sql.toString(), new Object[]{carBrand.getBId()}).get(0); //获取结果
		}
		catch (Exception e) {
			
			// TODO: handle exception
		e.printStackTrace();
		}
		  return _carBrand;
	}
  /**
   * 根据品牌名称获取品牌的方法
   *@return Carbrand 
   */
	@Override
	public Carbrand getBrandByName(Carbrand carBrand) {
		// TODO Auto-generated method stub
		Carbrand _carBrand=null;
		   String sql= " from Carbrand where BName=? ";
		try{
			//获取结果
		_carBrand=  (Carbrand) super.getHibernateTemplate().find(sql.toString(), new Object[]{carBrand.getBName()}).get(0);
		}
		catch (Exception e) {
			
			// TODO: handle exception
		e.printStackTrace();
		}
		  return _carBrand;
	}
 
}
